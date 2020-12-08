package cn.keking.mapper;

import cn.keking.model.PageData;
import cn.keking.model.database.domain.BaseProcessDrawings;
import cn.keking.model.database.domain.Inventory;
import cn.keking.model.database.dto.BaseProcessDrawingsDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface TempBaseProcessDrawingsExtMapper {

    List<PageData> selectViewBydraweNo(@Param("drawe_no") String  cInvCode);
}
