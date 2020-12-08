package cn.keking.model.database.dto;

import cn.keking.model.easyExcel.EasyExcelErr;
import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

/**
 * 工艺图纸管理
 */
@Data
public class BaseProcessDrawingsDTO extends EasyExcelErr {

    @ExcelProperty("文件名称（带后缀）")
    private String draweNoSuffix;//文件名带后缀
    @ExcelProperty("文件名称（无后缀）")
    private String draweNo;//文件名不带后缀
    @ExcelProperty("文件位置")
    private String drawingPath;//文件地址

    private Integer pdId;

    private Integer drawingType;

    private Integer id;
}