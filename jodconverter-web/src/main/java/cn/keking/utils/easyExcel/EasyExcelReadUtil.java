package cn.keking.utils.easyExcel;

import cn.keking.easyExcel.EasyExcelLister;
import cn.keking.model.JsonMessage;
import cn.keking.service.easyExcel.EasyRealInterface;
import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.read.metadata.ReadSheet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EasyExcelReadUtil {

    private static final Logger logger = LoggerFactory.getLogger(EasyExcelReadUtil.class);

    public static JsonMessage easyRead(EasyRealInterface easyRealInterface, String fileName, Class cls, String errfilepath) {
        ExcelReader excelReader = null;
        try {
            easyRealInterface.setErrcla(cls);

            excelReader = EasyExcel.read(fileName, cls, new EasyExcelLister(easyRealInterface)).build();

            ReadSheet readSheet = EasyExcel.readSheet(0).build();

            excelReader.read(readSheet);

            return easyRealInterface.finish(errfilepath);
        } catch (Exception e){
            logger.error(easyRealInterface.getreportName() + "读取excel异常", e);
            return new JsonMessage(false,"服务器异常,请重新上传");
        }finally {
            if (excelReader != null) {
                // 这里千万别忘记关闭，读的时候会创建临时文件，到时磁盘会崩的
                excelReader.finish();

            }

        }
    }
}
