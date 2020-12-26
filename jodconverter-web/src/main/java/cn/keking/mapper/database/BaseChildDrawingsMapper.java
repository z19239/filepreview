package cn.keking.mapper.database;

import cn.keking.model.database.domain.BaseChildDrawings;
import cn.keking.model.database.domain.BaseChildDrawingsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BaseChildDrawingsMapper {
    long countByExample(BaseChildDrawingsExample example);

    int deleteByExample(BaseChildDrawingsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BaseChildDrawings record);

    int insertSelective(BaseChildDrawings record);

    List<BaseChildDrawings> selectByExample(BaseChildDrawingsExample example);

    BaseChildDrawings selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BaseChildDrawings record, @Param("example") BaseChildDrawingsExample example);

    int updateByExample(@Param("record") BaseChildDrawings record, @Param("example") BaseChildDrawingsExample example);

    int updateByPrimaryKeySelective(BaseChildDrawings record);

    int updateByPrimaryKey(BaseChildDrawings record);

    List<BaseChildDrawings> selectAllDrawings();
}