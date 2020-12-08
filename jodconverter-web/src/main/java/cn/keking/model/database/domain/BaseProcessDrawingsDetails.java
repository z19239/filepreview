package cn.keking.model.database.domain;

import lombok.Data;

/**
 * 工艺图纸管理详情表（工艺图纸和工艺卡路径）
 */
@Data
public class BaseProcessDrawingsDetails {
    private Integer id;

    /**
     * 工艺图纸外键ID
     */
    private Integer pdId;

    /**
     * 图纸类型，0：工艺图纸，1：工艺卡
     */
    private Integer drawingType;

    /**
     * 图纸存放路径
     */
    private String drawingPath;
}