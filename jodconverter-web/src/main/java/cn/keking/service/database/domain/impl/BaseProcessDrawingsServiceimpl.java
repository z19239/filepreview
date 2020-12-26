package cn.keking.service.database.domain.impl;

import cn.keking.mapper.database.BaseChildDrawingsMapper;
import cn.keking.mapper.database.BaseProcessDrawingsMapper;
import cn.keking.model.database.domain.BaseChildDrawings;
import cn.keking.model.database.domain.BaseChildDrawingsExample;
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
    @Autowired
    BaseChildDrawingsMapper baseChildDrawingsMapper;

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

    @Override
    public List<BaseChildDrawings> selectBycInvCodeAndversionNoPid(String cInvCode, String versionNo) {
        BaseChildDrawingsExample baseChildDrawingsExample=new BaseChildDrawingsExample();
        BaseChildDrawingsExample.Criteria criteria = baseChildDrawingsExample.createCriteria();
        criteria.andCinvcodeEqualTo(cInvCode);
        criteria.andVersionNoEqualTo(versionNo);
        List<BaseChildDrawings> baseChildDrawingsList=baseChildDrawingsMapper.selectByExample(baseChildDrawingsExample);
        if(baseChildDrawingsList.size()>0){
            return baseChildDrawingsList;
        }else{
            return  null;
        }
    }
}
