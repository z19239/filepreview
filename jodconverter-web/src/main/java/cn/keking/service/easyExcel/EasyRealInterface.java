package cn.keking.service.easyExcel;

import cn.keking.model.JsonMessage;
import com.alibaba.excel.metadata.CellData;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

//用于exl读取批量处理的接口
public interface EasyRealInterface {

    //批量保存
    public  void savelist(List list) throws InstantiationException, IllegalAccessException, ExecutionException, InterruptedException;

    //获取到这次批量保存的标题内容
    public String getreportName();

    //开始读表,这边如果表头正确才进行读取,
    public JsonMessage finish(String searcherrorpath);

    //判断读取的exl的表头是否正确
    public void checkexlHead(Map<Integer, CellData> headMap);


    public void setErrcla(Class errcla);

}
