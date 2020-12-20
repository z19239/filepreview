package cn.keking.service.database.domain.impl;

import cn.keking.mapper.database.BaseProcessDrawingsMapper;
import cn.keking.model.database.domain.BaseProcessDrawings;
import cn.keking.model.database.domain.BaseProcessDrawingsExample;
import cn.keking.service.database.domain.BaseProcessDrawingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BaseProcessDrawingsServiceimpl implements BaseProcessDrawingsService {

    @Autowired
    BaseProcessDrawingsMapper baseProcessDrawingsMapper;

    @Override
    public BaseProcessDrawings selectByDrawingNo(String drawingNo) {
        BaseProcessDrawingsExample baseProcessDrawingsExample=new BaseProcessDrawingsExample();
        BaseProcessDrawingsExample.Criteria criteria = baseProcessDrawingsExample.createCriteria();
        criteria.andDrawingNoEqualTo(drawingNo);
        List<BaseProcessDrawings> baseProcessDrawings=baseProcessDrawingsMapper.selectByExample(baseProcessDrawingsExample);
        if(baseProcessDrawings.size()>0){
            return baseProcessDrawings.get(0);
        }else{
            return  null;
        }
    }

    @Override
    public BaseProcessDrawings selectBycInvCodeAndversionNo(String cInvCode, String versionNo) {
        BaseProcessDrawingsExample baseProcessDrawingsExample=new BaseProcessDrawingsExample();
        BaseProcessDrawingsExample.Criteria criteria = baseProcessDrawingsExample.createCriteria();
        criteria.andCinvcodeEqualTo(cInvCode);
        criteria.andVersionNoEqualTo(versionNo);
        List<BaseProcessDrawings> baseProcessDrawings=baseProcessDrawingsMapper.selectByExample(baseProcessDrawingsExample);
        if(baseProcessDrawings.size()>0){
            return baseProcessDrawings.get(0);
        }else{
            return  null;
        }
    }
}
