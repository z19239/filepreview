package cn.keking.mapper.database;

import cn.keking.model.database.domain.BaseProcessDrawingsDetails;
import cn.keking.model.database.domain.BaseProcessDrawingsDetailsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BaseProcessDrawingsDetailsMapper {
    long countByExample(BaseProcessDrawingsDetailsExample example);

    int deleteByExample(BaseProcessDrawingsDetailsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BaseProcessDrawingsDetails record);

    int insertSelective(BaseProcessDrawingsDetails record);

    List<BaseProcessDrawingsDetails> selectByExample(BaseProcessDrawingsDetailsExample example);

    BaseProcessDrawingsDetails selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BaseProcessDrawingsDetails record, @Param("example") BaseProcessDrawingsDetailsExample example);

    int updateByExample(@Param("record") BaseProcessDrawingsDetails record, @Param("example") BaseProcessDrawingsDetailsExample example);

    int updateByPrimaryKeySelective(BaseProcessDrawingsDetails record);

    int updateByPrimaryKey(BaseProcessDrawingsDetails record);
}