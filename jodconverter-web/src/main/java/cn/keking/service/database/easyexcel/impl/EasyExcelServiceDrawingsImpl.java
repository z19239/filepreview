package cn.keking.service.database.easyexcel.impl;

import cn.keking.config.ConfigConstants;
import cn.keking.mapper.BaseProcessDrawingsExtMapper;
import cn.keking.model.JsonMessage;
import cn.keking.model.database.domain.BaseProcessDrawings;
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
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

@Service
public class EasyExcelServiceDrawingsImpl implements EasyExcelInterfaceService {

    private static BaseProcessDrawingsExtMapper baseProcessDrawingsExtMapper;

    public BaseProcessDrawingsExtMapper getBaseProcessDrawingsExtMapper() {
        return baseProcessDrawingsExtMapper;
    }

    @Autowired
    public void setBaseProcessDrawingsExtMapper(BaseProcessDrawingsExtMapper baseProcessDrawingsExtMapper) {
        EasyExcelServiceDrawingsImpl.baseProcessDrawingsExtMapper = baseProcessDrawingsExtMapper;
    }
    //private static TempBaseProcessDrawingsExtMapper tempBaseProcessDrawingsExtMapper;

    private static final Logger logger = LoggerFactory.getLogger(EasyExcelServiceDrawingsImpl.class);

    private static Map<String,List<DraweNoDTO>> draweNoDTOMap=new HashMap<>();

    private static String keymap=ConfigConstants.getkeyDRAWE();

    //@PostConstruct
    public void startTask(){
        logger.info("数据初始化开始！");
        //initDraweNoTask();
        /*List<DraweNoDTO> draweNoDTOList=baseProcessDrawingsExtMapper.queryByDraweNo(-1,0);
        if(draweNoDTOList.size()>0){
            draweNoDTOMap.put(keymap,draweNoDTOList);
        }
        if (ConfigConstants.isCacheEnabled()) {
            // 加入缓存
            draweNoCache.addConvertedDRAWINGS(keymap,draweNoDTOList);
        }*/
        logger.info("数据初始化完成！");
    }

    //@PostConstruct
    public void initDraweNoTask() {
        Thread initDraweNoThread = new Thread(new initDraweNoThread());
        initDraweNoThread.start();
    }
    class initDraweNoThread implements Runnable {
        @Override
        public void run() {
            try {
                while (true) {
                    List<DraweNoDTO> draweNoDTOList=baseProcessDrawingsExtMapper.queryByDraweNo(-1,0);
                    if(draweNoDTOList.size()>0){
                        draweNoDTOMap.put(keymap,draweNoDTOList);
                    }
                    if (ConfigConstants.isCacheEnabled()) {
                        // 加入缓存
                        draweNoCache.addConvertedDRAWINGS(keymap,draweNoDTOList);
                    }
                    Thread.sleep(1000L*10*300);//30分钟刷新下缓存
                    //Thread.sleep(1000L);//3分钟刷新下缓存
                }
            } catch (InterruptedException e) {
                logger.error("数据初始化异常", e);
            }
        }
    }
    private final DraweNoCache draweNoCache;

    private final CacheService cacheService;


    public EasyExcelServiceDrawingsImpl(DraweNoCache draweNoCache, CacheService cacheService) {
        this.draweNoCache = draweNoCache;
        this.cacheService = cacheService;
    }

    /*public void writeTask(){
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        executorService.submit(new EasyExcelServiceDrawingsImpl.ConvertTask(cacheService));
        logger.info("队列处理文件转换任务启动完成 ");
    }

    static class ConvertTask implements Runnable {

        private final Logger logger = LoggerFactory.getLogger(EasyExcelServiceDrawingsImpl.ConvertTask.class);

        private final CacheService cacheService;

        public ConvertTask(CacheService cacheService) {
            this.cacheService = cacheService;
        }

        @Override
        public void run() {
            while (true) {
                //List<BaseProcessDrawingsDTO> url = null;
                try {
                    //draweNoDTOList = cacheService.getDRAWINGSCache("drawings-convert-task");
                } catch (Exception e) {
                    try {
                        Thread.sleep(1000*10);
                    } catch (Exception ex){
                        ex.printStackTrace();
                    }
                    //logger.info("处理预览转换任务异常，url：{}", draweNoDTOList, e);
                }
            }
        }
    }*/



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
            public void save(List list, Class errata){
                //判断是否有缓存 如果无初始化缓存
                if(draweNoCache.listConvertedFiles().isEmpty()){
                    //startTask();
                    initDraweNoTask();
                }
                try {
                    while (true){
                        if(!draweNoCache.listConvertedFiles().containsKey(keymap)) {
                            Thread.sleep(100L * 1);
                        }else break;
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                List baseProcessDrawingsExcelUploadDTOList=new ArrayList<>();
                ExecutorService service = Executors.newCachedThreadPool();
                Comparison comparison=new Comparison(list,baseProcessDrawingsExcelUploadDTOList);
                for(int i=0;i<5;i++){
                    service.submit(comparison);
                }
                ProducerConsumer pc = new ProducerConsumer();
                //数据仓库
                ProducerConsumer.Storage s = pc.new Storage();

                //ExecutorService service = Executors.newFixedThreadPool(1);
                //1个线程进行生产
                ProducerConsumer.Producer p = pc.new Producer(baseProcessDrawingsExtMapper,s,baseProcessDrawingsExcelUploadDTOList);
                service.submit(p);
                //5个线程进行修改
                for(int i=0;i<5;i++){
                    service.submit(pc.new Consumer(baseProcessDrawingsExtMapper,baseProcessDrawingsExtMapper,s));
                }
            }
             class Comparison implements Runnable {

                private List list ;
                private List baseProcessDrawingsExcelUploadDTOList;
                public Comparison(List list,List baseProcessDrawingsExcelUploadDTOList) {
                    this.list=list;
                    this.baseProcessDrawingsExcelUploadDTOList=baseProcessDrawingsExcelUploadDTOList;
                }
                public void run() {
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
                                if (draweNoCache.listConvertedFiles().containsKey(keymap) && ConfigConstants.isCacheEnabled()) {
                                    List<DraweNoDTO> drawNoList=draweNoCache.listConvertedFiles().get(keymap).stream()
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
                }
            }
        },filePath,BaseProcessDrawingsDTO.class,filepath);
        return jsonMessage;
    }
}
