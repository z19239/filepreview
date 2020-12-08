package cn.keking.easyExcel;

import cn.keking.service.easyExcel.EasyRealInterface;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.excel.metadata.CellData;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * excel读取的监听器
 */
@Slf4j
public class EasyExcelLister<T> extends AnalysisEventListener<T> {
    /**
     * 每隔5条存储数据库，实际使用中可以3000条，然后清理list ，方便内存回收
     */
    private static  Integer  BATCH_COUNT = 3000;
    List<T> list = new ArrayList<T>();

    EasyRealInterface easyRealInterface;


    /**
     * 如果使用了spring,请使用这个构造方法。每次创建Listener的时候需要把spring管理的类传进来
     *
     * @param easyRealInterface ,传入批量处理的接口,每达到多少条就进行一次批量处理
     */
    public EasyExcelLister(EasyRealInterface easyRealInterface) {
        this.easyRealInterface=easyRealInterface;
    }

    /**
     *
     * @param easyRealInterface ,继承该接口进行业务逻辑的处理,每次保存多少
     * @param BATCH_COUNT ,每次解析的数量
     */
    public EasyExcelLister(EasyRealInterface easyRealInterface,int BATCH_COUNT) {
        this.easyRealInterface=easyRealInterface;
        this.BATCH_COUNT=BATCH_COUNT;
    }

    /**
     * 这个每一条数据解析都会来调用
     *
     * @param data
     *            one row value. Is is same as {@link AnalysisContext#readRowHolder()}
     * @param context
     */
    @Override
    public void invoke(T data, AnalysisContext context) {
        log.debug("文档解析标题为:"+easyRealInterface.getreportName()+",解析到一条数据:{}", JSON.toJSONString(data));
        list.add(data);
        // 达到BATCH_COUNT了，需要去存储一次数据库，防止数据几万条数据在内存，容易OOM
        if (list.size() >= BATCH_COUNT) {
            saveData();
            // 存储完成清理 list
            list.clear();
        }
    }


    /**
     * 所有数据解析完成了 都会来调用
     *
     * @param context
     */
    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {
        // 这里也要保存数据，确保最后遗留的数据也存储到数据库
        saveData();
        log.debug("所有数据解析完成！,读取的标题是:"+easyRealInterface.getreportName());
    }

    /**
     * 加上存储数据库
     */
    private void saveData() {
        log.debug("{}条数据，开始存储数据库！,读取的标题是"+easyRealInterface.getreportName(), list.size());
        try {
            easyRealInterface.savelist(list);
            log.debug("存储数据库成功！读取的标题是:"+easyRealInterface.getreportName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        ;
    }

    @Override
    public void invokeHeadMap(Map<Integer, String> headMap, AnalysisContext context) {
        System.out.println(1);
    }

    //这边是判断读取到了表头
    @Override
    public void invokeHead(Map<Integer, CellData> headMap, AnalysisContext context) {
        easyRealInterface.checkexlHead(headMap);//检查表头
    }

}

