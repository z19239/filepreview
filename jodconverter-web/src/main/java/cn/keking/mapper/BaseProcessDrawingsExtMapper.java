package cn.keking.mapper;

import cn.keking.model.PageData;
import cn.keking.model.database.domain.BaseProcessDrawings;
import cn.keking.model.database.domain.Inventory;
import cn.keking.model.database.dto.BaseProcessDrawingsDTO;
import cn.keking.model.ext.DraweNoDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface BaseProcessDrawingsExtMapper{

    Inventory selectByCInvCodeInventory(@Param("cInvCode") String  cInvCode);

    /*@Insert("<script>insert into camera (chanIndex,cameraName) values " +
            "<foreach collection='list' item='c' separator=','>(#{c.chanIndex},#{c.cameraName})</foreach></script>")
    @Options(useGeneratedKeys = true, keyProperty = "cameraNo")*/
    void addDrawingsDetailsBatch(@Param("list") List<BaseProcessDrawingsDTO> baseProcessDrawingsDTOList);

    int insterBaseProcessDrawings(BaseProcessDrawings baseProcessDrawings);

    List<PageData> selectViewBydraweNo(@Param("drawe_no") String  cInvCode);

    List<PageData> selectTempBydraweNo(@Param("drawe_no") String cinvcode);

    List<DraweNoDTO> queryByDraweNo(@Param("pageNo") int pageNo,@Param("pageSize")  int pageSize);

    int queryDraweNoCount();
}
