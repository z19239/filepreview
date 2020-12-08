package cn.keking.model.easyExcel;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

@Data
public class EasyExcelErr {

    @ExcelProperty(value = {"失败原因"})
    protected  String remark;
}
