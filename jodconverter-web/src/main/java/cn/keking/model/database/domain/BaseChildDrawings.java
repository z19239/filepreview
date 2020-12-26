package cn.keking.model.database.domain;

import cn.keking.model.easyExcel.EasyExcelErr;
import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

/**
 * 组件子件图纸表
 */
@Data
public class BaseChildDrawings extends EasyExcelErr {
    private Integer id;

    /**
     * 组件物料编码
     */
    @ExcelProperty("组件物料编码")
    private String cinvcode;

    /**
     * 组件版本号
     */
    @ExcelProperty("组件版本号")
    private String versionNo;

    /**
     * 子件物料编码
     */
    @ExcelProperty("零件物料编码")
    private String ccinvcode;

    /**
     * 子件版本号
     */
    @ExcelProperty("零件版本号")
    private String cversionNo;
}