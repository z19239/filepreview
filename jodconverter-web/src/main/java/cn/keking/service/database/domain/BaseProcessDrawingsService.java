package cn.keking.service.database.domain;

import cn.keking.model.database.domain.BaseChildDrawings;
import cn.keking.model.database.domain.BaseProcessDrawings;

import java.util.List;

public interface BaseProcessDrawingsService {
    BaseProcessDrawings selectByDrawingNo(String drawingNo);

    BaseProcessDrawings selectBycInvCodeAndversionNo(String cInvCode, String versionNo);

    List<BaseChildDrawings> selectBycInvCodeAndversionNoPid(String cInvCode, String versionNo);
}
