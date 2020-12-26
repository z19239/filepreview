package cn.keking.service.database.easyexcel.impl;

import cn.keking.config.ConfigConstants;
import cn.keking.mapper.BaseProcessDrawingsExtMapper;
import cn.keking.mapper.database.BaseChildDrawingsMapper;
import cn.keking.model.JsonMessage;
import cn.keking.model.database.domain.BaseChildDrawings;
import cn.keking.model.database.dto.BaseProcessDrawingsDTO;
import cn.keking.model.database.dto.BaseProcessDrawingsExcelUploadDTO;
import cn.keking.model.ext.DraweNoDTO;
import cn.keking.service.cache.CacheService;
import cn.keking.service.database.easyexcel.EasyExcelInterfaceService;
import cn.keking.service.easyExcel.impl.EasyexlReadBaseService;
import cn.keking.utils.easyExcel.EasyExcelReadUtil;
import com.alibaba.excel.metadata.CellData;
import io.netty.util.internal.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;
import java.util.stream.Collectors;

@Service
public class EasyExcelServiceDrawingsImpl implements EasyExcelInterfaceService {

    @Autowired
    private BaseProcessDrawingsExtMapper baseProcessDrawingsExtMapper;

    //private static TempBaseProcessDrawingsExtMapper tempBaseProcessDrawingsExtMapper;
    @Autowired
    private BaseChildDrawingsMapper baseChildDrawingsMapper;

    private static final Logger logger = LoggerFactory.getLogger(EasyExcelServiceDrawingsImpl.class);

    private static String keymap=ConfigConstants.getkeyDRAWE();

    private static String ckeymap=ConfigConstants.getkeyDRAWE();

    @PostConstruct
    public void initDraweNoTask() throws InterruptedException {
        Thread initDraweNoThread = new Thread(new initDraweNoThread());
        initDraweNoThread.start();
    }
    class initDraweNoThread implements Runnable {
        @Override
        public void run() {
            try {
                while (true) {
                    List<DraweNoDTO> draweNoDTOList=baseProcessDrawingsExtMapper.queryByDraweNo(-1,0);
                    if (ConfigConstants.isCacheEnabled()) {
                        // 加入缓存
                        draweNoCache.addConvertedDRAWINGS(keymap,draweNoDTOList);
                    }
                    //Thread.sleep(1000L*60*30);//30分钟刷新下缓存
                    Thread.sleep(1000L*60*3);//3分钟刷新下缓存
                }
            } catch (InterruptedException e) {
                logger.error("数据初始化异常", e);
            }
        }
    }

    private final DraweNoCache draweNoCache;

    private final CacheService cacheService;

    public EasyExcelServiceDrawingsImpl(DraweNoCache draweNoCache, @Qualifier("cacheServiceRedisImpl") CacheService cacheService) {
        this.draweNoCache = draweNoCache;
        this.cacheService = cacheService;
    }

    @Override
    public JsonMessage save(String filePath, String filepath) {
        JsonMessage jsonMessage= EasyExcelReadUtil.easyRead(new EasyexlReadBaseService() {
            @Override
            public void checkexlHead(Map<Integer, CellData> headMap) {
                if (headMap != null && headMap.size() > 0) {
                    headMap.forEach((p, v) -> {
                        System.out.println(v);
                    });
                } else {
                    setIssave(false);
                }
            }

            @Override
            public void save(List list, Class errata) throws ExecutionException, InterruptedException {
                //判断是否有缓存 如果无初始化缓存
                if(draweNoCache.listConvertedDraweNo().isEmpty()){
                    //startTask();
                    initDraweNoTask();
                }
                try {
                    while (true){
                        if(!draweNoCache.listConvertedDraweNo().containsKey(keymap)) {
                            Thread.sleep(1000L);
                        }else break;
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //
                List<DraweNoDTO> noDTOList=new ArrayList<>();
                if (draweNoCache.listConvertedDraweNo().containsKey(keymap) && ConfigConstants.isCacheEnabled()) {
                    noDTOList=draweNoCache.listConvertedDraweNo().get(keymap);
                }

                ExecutorService serviceTask = Executors.newCachedThreadPool();
                List<DraweNoDTO> finalNoDTOList = noDTOList;
                Callable task = new Callable() {
                    @Override
                    public List call() throws Exception {
                        List baseProcessDrawingsExcelUploadDTOList=new ArrayList<>();
                        for (Object o : list) {
                            if (o != null) {
                                BaseProcessDrawingsDTO drawings = new BaseProcessDrawingsDTO();
                                drawings = (BaseProcessDrawingsDTO) o;
                                String remark = "";
                                if (StringUtil.isNullOrEmpty(drawings.getDrawingPath())) {
                                    remark += "图纸地址不能为空";
                                }
                                if (StringUtil.isNullOrEmpty(drawings.getDraweNo())|| StringUtil.isNullOrEmpty(drawings.getDraweNo())) {
                                    remark += "文件名称不能为空";
                                }
                                if(!StringUtil.isNullOrEmpty(remark)){//判断前面的为空是否生效
                                    addfailandsetremark(o, remark);
                                }else{//进行保存
                                    String drawerNo=drawings.getDraweNo();
                                    if (cn.keking.utils.StringUtil.isNull(drawerNo)){
                                        remark += "文件名称不能为空";
                                        addfailandsetremark(o, remark);
                                        break;
                                    }
                                    //图纸匹配插入数据库
                                    if (ConfigConstants.isCacheEnabled()) {
                                        List<DraweNoDTO> drawNoList= finalNoDTOList.stream()
                                                .filter(item->(item.getDraweNo().equals(drawerNo))
                                                )
                                                .collect(Collectors.toList());
                                        if(drawNoList.size()>0){
                                            for (DraweNoDTO dra:drawNoList) {
                                                BaseProcessDrawingsExcelUploadDTO baseProcessDrawingsExcelUploadDTO=new BaseProcessDrawingsExcelUploadDTO();
                                                baseProcessDrawingsExcelUploadDTO.setCinvcode(dra.getCinvcode());
                                                baseProcessDrawingsExcelUploadDTO.setCiinvaddcode(dra.getCinvaddcode());
                                                baseProcessDrawingsExcelUploadDTO.setDrawingNo(drawings.getDraweNo());
                                                baseProcessDrawingsExcelUploadDTO.setVersionNo(dra.getFree1());
                                                baseProcessDrawingsExcelUploadDTO.setDrawingPath(drawings.getDrawingPath());
                                                baseProcessDrawingsExcelUploadDTO.setExcelDraweNo(drawings.getDraweNo());
                                                baseProcessDrawingsExcelUploadDTO.setDrawingPath(drawings.getDrawingPath());
                                                baseProcessDrawingsExcelUploadDTOList.add(baseProcessDrawingsExcelUploadDTO);
                                            }
                                        }else{
                                            remark += "该图纸暂时未查询到对应的物料信息请核实";
                                            addfailandsetremark(o, remark);
                                        }
                                    }
                                }
                            }
                        }
                        return baseProcessDrawingsExcelUploadDTOList;
                    }
                };
                FutureTask ft = new FutureTask(task);
                for(int i=0;i<5;i++){
                    serviceTask.submit(ft);
                }
                List baseProcessDrawingsList= (List) ft.get();
                serviceTask.shutdown();
                ProducerConsumer pc = new ProducerConsumer();
                //数据仓库
                ProducerConsumer.Storage s = pc.new Storage();

                ExecutorService service = Executors.newFixedThreadPool(1);
                //1个线程进行生产
                ProducerConsumer.Producer p = pc.new Producer(baseProcessDrawingsExtMapper,s,baseProcessDrawingsList);
                service.submit(p);
                service.shutdown();
                //5个线程进行修改
                ExecutorService serviceConsumer = Executors.newCachedThreadPool();
                for(int i=0;i<5;i++){
                    serviceConsumer.submit(pc.new Consumer(baseProcessDrawingsExtMapper,baseProcessDrawingsExtMapper,s));
                }
                serviceConsumer.shutdown();
            }
        },filePath,BaseProcessDrawingsDTO.class,filepath);
        return jsonMessage;
    }


    @PostConstruct
    public void initChildDraweNoTask() throws InterruptedException {
        Thread initCDraweNoThread = new Thread(new initChildDraweNoThread());
        initCDraweNoThread.start();
    }
    class initChildDraweNoThread implements Runnable {
        @Override
        public void run() {
            try {
                while (true) {
                    List<BaseChildDrawings> draweNoDTOList=baseChildDrawingsMapper.selectAllDrawings();
                    if (ConfigConstants.isCacheEnabled()) {
                        // 加入缓存
                        draweNoCache.addConvertedCDRAWINGS(ckeymap,draweNoDTOList);
                    }
                    TimeUnit.MINUTES.sleep(3);//3分钟刷新下缓存
                }
            } catch (InterruptedException e) {
                logger.error("数据初始化异常", e);
            }
        }
    }

    @Override
    public JsonMessage saveChilddrawings(String filePath, String filepath) {
        JsonMessage jsonMessage= EasyExcelReadUtil.easyRead(new EasyexlReadBaseService() {
            @Override
            public void checkexlHead(Map<Integer, CellData> headMap) {
                if (headMap != null && headMap.size() > 0) {
                    headMap.forEach((p, v) -> {
                        System.out.println(v);
                    });
                } else {
                    setIssave(false);
                }
            }

            @Override
            public void save(List list, Class errata) throws ExecutionException, InterruptedException {
                //判断是否有缓存 如果无初始化缓存
                if(draweNoCache.listConvertedCDraweNo().isEmpty()){
                    //startTask();
                    initDraweNoTask();
                }
                try {
                    while (true){
                        if(!draweNoCache.listConvertedCDraweNo().containsKey(ckeymap)) {
                            Thread.sleep(1000L);
                        }else break;
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //
                List<BaseChildDrawings> noDTOList=new ArrayList<>();
                if (draweNoCache.listConvertedCDraweNo().containsKey(ckeymap) && ConfigConstants.isCacheEnabled()) {
                    noDTOList=draweNoCache.listConvertedCDraweNo().get(ckeymap);
                }

                ExecutorService serviceTask = Executors.newCachedThreadPool();
                List<BaseChildDrawings> finalNoDTOList = noDTOList;
                List baseProcessDrawingsExcelUploadDTOList=new ArrayList<>();
                for (Object o : list) {
                    if (o != null) {
                        BaseChildDrawings drawings = new BaseChildDrawings();
                        drawings = (BaseChildDrawings) o;
                        String remark = "";
                        if (StringUtil.isNullOrEmpty(drawings.getCinvcode())) {
                            remark += "组件物料编码不能为空";
                        }
                        if (StringUtil.isNullOrEmpty(drawings.getCcinvcode())) {
                            remark += "零件物料编码不能为空";
                        }
                        if(!StringUtil.isNullOrEmpty(remark)){//判断前面的为空是否生效
                            addfailandsetremark(o, remark);
                        }else{//进行保存
                            //图纸匹配插入数据库
                            baseChildDrawingsMapper.insertSelective(drawings);
                        }
                    }
                }
            }
        },filePath, BaseChildDrawings.class,filepath);
        return jsonMessage;
    }
}
