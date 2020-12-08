package cn.keking.utils.easyExcel;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.BaseRowModel;
import com.alibaba.excel.support.ExcelTypeEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * easyexl导出到压缩包的的工具类
 */

public class EasyExceltofileUtil {
    private static final Logger logger = LoggerFactory.getLogger(EasyExceltofileUtil.class);


    /**
     * 根据表头，数据，文件名称，进行exl的导出，xlsx格式
     *
     * @param fileName 标题
     * @param filepath 文件名
     * @param alldata  实际数据
     */
    public  static  String exlport(String fileName, String filepath,  List<List<Object>> alldata,Class<? extends BaseRowModel> cls) {
        return exportfile(fileName, filepath, alldata, ".xlsx", ExcelTypeEnum.XLSX,cls);
    }


    private  static  String exportfile(String fileName, String filepath,  List<List<Object>> alldata, String filetype, ExcelTypeEnum exltype,Class<? extends BaseRowModel> cls) {
        /*FileOutputStream fos = null;
        String filespathresult="";
        try {
            filespathresult=filepath +File.separator + fileName+getnowtime() + filetype;
            //如果文件夹不存在就创建文件夹
            File folder = new File(filepath);
            if (!folder.exists() && !folder.isDirectory()) {
                folder.mkdirs();
            }
            File file = new File(filespathresult);
            if (!file.exists()) {
                file.createNewFile();
            }
            fos = new FileOutputStream(file);
            ExcelWriter writer = EasyExcelFactory.getWriter(fos, exltype, true);

            // 动态添加表头，适用一些表头动态变化的场景
            com.alibaba.excel.metadata.Sheet sheet1 = new com.alibaba.excel.metadata.Sheet(1, 0, cls);
            sheet1.setSheetName("sheet1");
            // 写数据
            writer.write1(alldata, sheet1);
            // 将上下文中的最终 outputStream 写入到指定文件中
            writer.finish();
        } catch (Exception e) {
            logger.error("导出exl失败" + fileName, e);
        } finally {
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }*/
        String filespathresult="";
        ExcelWriter excelWriter = null;
        try {
            filespathresult=filepath + fileName+getnowtime() + filetype;
            //如果文件夹不存在就创建文件夹
            File folder = new File(filepath);
            if (!folder.exists() && !folder.isDirectory()) {
                folder.mkdirs();
            }
            File file = new File(filespathresult);
            if (!file.exists()) {
                file.createNewFile();
            }
            EasyExcel.write(filespathresult)
                    // 这里放入动态头
                    .head(cls).sheet("sheet1")
                    // 当然这里数据也可以用 List<List<String>> 去传入
                    .doWrite(alldata);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 千万别忘记finish 会帮忙关闭流
            if (excelWriter != null) {
                excelWriter.finish();
            }
        }
        return filespathresult;
    }

    private static String getnowtime(){
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
        String dateString = formatter.format(new Date());
        return dateString;
    }

}

