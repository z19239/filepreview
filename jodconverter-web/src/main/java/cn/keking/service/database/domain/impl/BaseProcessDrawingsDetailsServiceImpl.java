package cn.keking.service.database.domain.impl;

import cn.keking.mapper.database.BaseProcessDrawingsDetailsMapper;
import cn.keking.mapper.database.BaseProcessDrawingsMapper;
import cn.keking.model.database.domain.BaseProcessDrawings;
import cn.keking.model.database.domain.BaseProcessDrawingsDetails;
import cn.keking.model.database.domain.BaseProcessDrawingsDetailsExample;
import cn.keking.model.database.domain.BaseProcessDrawingsExample;
import cn.keking.service.database.domain.BaseProcessDrawingsDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BaseProcessDrawingsDetailsServiceImpl implements BaseProcessDrawingsDetailsService {

    @Autowired
    BaseProcessDrawingsDetailsMapper baseProcessDrawingsDetailsMapper;

    @Override
    public BaseProcessDrawingsDetails selectByPid(Integer id) {
        BaseProcessDrawingsDetailsExample baseProcessDrawingsDetailsExample=new BaseProcessDrawingsDetailsExample();
        BaseProcessDrawingsDetailsExample.Criteria criteria = baseProcessDrawingsDetailsExample.createCriteria();
        criteria.andPdIdEqualTo(id);
        List<BaseProcessDrawingsDetails> baseProcessDrawingsDetailsList=baseProcessDrawingsDetailsMapper.selectByExample(baseProcessDrawingsDetailsExample);
        if(baseProcessDrawingsDetailsList.size()>0){
            return baseProcessDrawingsDetailsList.get(0);
        }else{
            return  null;
        }
    }
}
