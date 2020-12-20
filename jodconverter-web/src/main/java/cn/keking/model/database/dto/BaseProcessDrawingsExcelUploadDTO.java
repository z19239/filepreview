package cn.keking.model.database.dto;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.util.Date;

/**
 * 工艺图纸管理
 */
@Data
public class BaseProcessDrawingsExcelUploadDTO {
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

    private String draweNoSuffix;//文件名带后缀

    private String excelDraweNo;//文件名不带后缀

    private String drawingPath;//文件地址
}