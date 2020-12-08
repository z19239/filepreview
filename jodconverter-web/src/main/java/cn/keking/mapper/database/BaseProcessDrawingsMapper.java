package cn.keking.mapper.database;

import cn.keking.model.database.domain.BaseProcessDrawings;
import cn.keking.model.database.domain.BaseProcessDrawingsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BaseProcessDrawingsMapper {
    long countByExample(BaseProcessDrawingsExample example);

    int deleteByExample(BaseProcessDrawingsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BaseProcessDrawings record);

    int insertSelective(BaseProcessDrawings record);

    List<BaseProcessDrawings> selectByExample(BaseProcessDrawingsExample example);

    BaseProcessDrawings selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BaseProcessDrawings record, @Param("example") BaseProcessDrawingsExample example);

    int updateByExample(@Param("record") BaseProcessDrawings record, @Param("example") BaseProcessDrawingsExample example);

    int updateByPrimaryKeySelective(BaseProcessDrawings record);

    int updateByPrimaryKey(BaseProcessDrawings record);
}