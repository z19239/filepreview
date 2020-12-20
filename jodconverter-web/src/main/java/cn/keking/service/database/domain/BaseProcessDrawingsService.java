package cn.keking.service.database.domain;

import cn.keking.model.database.domain.BaseProcessDrawings;

public interface BaseProcessDrawingsService {
    BaseProcessDrawings selectByDrawingNo(String drawingNo);

    BaseProcessDrawings selectBycInvCodeAndversionNo(String cInvCode, String versionNo);
}
