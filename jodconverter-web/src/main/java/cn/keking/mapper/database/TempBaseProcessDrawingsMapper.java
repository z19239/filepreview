package cn.keking.mapper.database;

import cn.keking.model.database.domain.TempBaseProcessDrawings;
import cn.keking.model.database.domain.TempBaseProcessDrawingsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TempBaseProcessDrawingsMapper {
    long countByExample(TempBaseProcessDrawingsExample example);

    int deleteByExample(TempBaseProcessDrawingsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TempBaseProcessDrawings record);

    int insertSelective(TempBaseProcessDrawings record);

    List<TempBaseProcessDrawings> selectByExample(TempBaseProcessDrawingsExample example);

    TempBaseProcessDrawings selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TempBaseProcessDrawings record, @Param("example") TempBaseProcessDrawingsExample example);

    int updateByExample(@Param("record") TempBaseProcessDrawings record, @Param("example") TempBaseProcessDrawingsExample example);

    int updateByPrimaryKeySelective(TempBaseProcessDrawings record);

    int updateByPrimaryKey(TempBaseProcessDrawings record);
}