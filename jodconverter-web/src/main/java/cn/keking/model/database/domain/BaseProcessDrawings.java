package cn.keking.model.database.domain;

import java.util.Date;
import lombok.Data;

/**
 * 工艺图纸管理
 */
@Data
public class BaseProcessDrawings {
    private Integer id;

    /**
     * 物料档案id
     */
    private Integer pId;

    /**
     * 存货分类编码
     */
    private String cinvccode;

    /**
     * 存货分类名称
     */
    private String cinvcname;

    /**
     * 物料编码
     */
    private String cinvcode;

    /**
     * 物料代码
     */
    private String ciinvaddcode;

    /**
     * 物料名称
     */
    private String ciinvname;

    /**
     * 规格型号
     */
    private String cinvstd;

    /**
     * 图号
     */
    private String drawingNo;

    /**
     * 版本号
     */
    private String versionNo;

    /**
     * 是否保存工艺图纸(0：是  1：否)
     */
    private Integer isDrawing;

    /**
     * 是否保存工艺卡（0：是  1：否）
     */
    private Integer isCard;

    private Date createTime;

    private Integer creatorId;

    private Date updateTime;

    private Integer updaterId;
}