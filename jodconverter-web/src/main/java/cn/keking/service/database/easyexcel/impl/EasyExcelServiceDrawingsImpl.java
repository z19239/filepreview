package cn.keking.service.database.easyexcel.impl;

import cn.keking.mapper.BaseProcessDrawingsExtMapper;
import cn.keking.mapper.TempBaseProcessDrawingsExtMapper;
import cn.keking.model.FileType;
import cn.keking.model.JsonMessage;
import cn.keking.model.PageData;
import cn.keking.model.database.domain.BaseProcessDrawings;
import cn.keking.model.database.domain.Inventory;
import cn.keking.model.database.dto.BaseProcessDrawingsDTO;
import cn.keking.model.ext.DraweNoDTO;
import cn.keking.service.database.easyexcel.EasyExcelInterfaceService;
import cn.keking.service.easyExcel.impl.EasyexlReadBaseService;
import cn.keking.utils.ZipReader;
import cn.keking.utils.easyExcel.EasyExcelReadUtil;
import cn.keking.web.filter.BaseUrlFilter;
import com.alibaba.excel.metadata.CellData;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.junrar.Archive;
import com.github.junrar.exception.RarException;
import com.github.junrar.rarfile.FileHeader;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import io.netty.util.internal.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

@Service
public class EasyExcelServiceDrawingsImpl implements EasyExcelInterfaceService {

    @Autowired
    private BaseProcessDrawingsExtMapper baseProcessDrawingsExtMapper;

    private TempBaseProcessDrawingsExtMapper tempBaseProcessDrawingsExtMapper;

    private final Logger logger = LoggerFactory.getLogger(EasyExcelServiceDrawingsImpl.class);

    private static  List<DraweNoDTO> draweNoDTOList=new ArrayList<>();

    @PostConstruct
    public void startTask() throws ExecutionException, InterruptedException {
        logger.info("数据初始化开始！");
        draweNoDTOList=baseProcessDrawingsExtMapper.queryByDraweNo(-1,0);
        logger.info("数据初始化完成！");
    }

    @Override
    public JsonMessage save(String filePath, String errfilepath) {
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
            public void save(List list, Class errcla) throws IllegalAccessException, InstantiationException {
                List<BaseProcessDrawingsDTO> objs=new ArrayList<BaseProcessDrawingsDTO>();
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
                        if(!StringUtil.isNullOrEmpty(remark)){
                            addfailandsetremark(o, remark);
                        }else{//这边进行保存
                            //List<PageData> pds=baseProcessDrawingsExtMapper.selectTempBydraweNo(drawings.getCinvcode());
                            String draweNo=drawings.getDraweNo();
                            /*Optional<DraweNoDTO> draweNoDTO=draweNoDTOList.stream().filter(item ->
                                    item.getDraweNo().equals(draweNo)
                            ).findFirst();*/
                            List<DraweNoDTO> draweNoList=draweNoDTOList.stream().filter(item->(item.getDraweNo().equals(draweNo)))
                                    .collect(Collectors.toList());
                            if(draweNoList.size()>0){
                                for (DraweNoDTO dra:draweNoList) {
                                    //Inventory inventory= baseProcessDrawingsExtMapper.selectByCInvCodeInventory(pd.getString("cInvCode"));
                                    /*if(null==inventory){
                                        remark += "该物料不存在请核实";
                                        addfailandsetremark(o, remark);
                                    }else{*/
                                        BaseProcessDrawings baseProcessDrawings=new BaseProcessDrawings();
                                        baseProcessDrawings.setCinvcode(dra.getCinvcode());
                                        baseProcessDrawings.setCiinvaddcode(dra.getCinvaddcode());
                                        //baseProcessDrawings.setCinvcname(pd.getCinvcname());
                                        baseProcessDrawings.setDrawingNo(drawings.getDraweNo());
                                        baseProcessDrawings.setVersionNo(dra.getFree1());
                                        int is=baseProcessDrawingsExtMapper.insterBaseProcessDrawings(baseProcessDrawings);
                                        if(is>0){
                                            drawings.setPdId(baseProcessDrawings.getId());
                                            objs.add(drawings);
                                        }
                                    //}
                                }
                            }else{
                                remark += "该图纸暂时未查询到对应的物料信息请核实";
                                addfailandsetremark(o, remark);
                            }
                        }
                    }
                }
                if(null!=objs && objs.size()>0){
                    int limit=2000;
                    if (objs.size()>limit){
                        //需要分几次完成
                        int count=objs.size()/limit;
                        for (int i = 0; i < count; i++) {
                            List<BaseProcessDrawingsDTO> listDTO = objs.subList(0, limit);
                            //2000条
                            baseProcessDrawingsExtMapper.addDrawingsDetailsBatch(listDTO);
                            //剔除已经插入的数据
                            objs.subList(0,limit).clear();
                        }
                        if (!objs.isEmpty()){
                            //插入2000条
                            baseProcessDrawingsExtMapper.addDrawingsDetailsBatch(objs);
                        }
                    }else if(objs.size()>0){
                        //数据量不大，直接一次
                        baseProcessDrawingsExtMapper.addDrawingsDetailsBatch(objs);
                    }
                }
            }
        },filePath,BaseProcessDrawingsDTO.class,errfilepath);
        return jsonMessage;
    }
}
