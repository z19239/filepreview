package cn.keking.service.easyExcel.impl;

import cn.keking.config.ConfigConstants;
import cn.keking.model.JsonMessage;
import cn.keking.model.easyExcel.EasyexlMessage;
import cn.keking.service.easyExcel.EasyRealInterface;
import cn.keking.utils.ConverterUtils;
import cn.keking.utils.easyExcel.EasyExceltofileUtil;
import org.springframework.beans.BeanUtils;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public abstract class EasyexlReadBaseService implements EasyRealInterface {

    public static String errmsg = "解析错误";
    public static String successmsg = "解析成功";
    //这边是用来控制表头是否读取正确的情况,如果是失败的情况,那么就不能进行业务逻辑操作
    private boolean issave = true;

    //失败集合
    private List errorList = new ArrayList();

    //失败导出的类
    private Class errcla;

    //失败条数
    private int failco = 0;

    //返回的提醒的内容,如果有错误,那么就会改成上传成功,失败原因下载查看
    private String message = successmsg;

    //成功条数
    private int successco = 0;

    public void setErrcla(Class errcla) {
        this.errcla = errcla;
    }

    //开始读表,这边如果表头正确才进行读取,
    public void savelist(List list) throws InstantiationException, IllegalAccessException, ExecutionException, InterruptedException {
        if (issave) {
            int oldfailco = failco;
            save(list,errcla);
            addsuccess(list.size() - (failco - oldfailco));//读取结束之后就能知道成功的数量了
        } else {
            if (ConverterUtils.isList(list)) {//这里是判断不为空且数量大于0
                for (Object o : list) {
                    addfailandsetremark(o, "表头标题不对应");
                }
            }
            message = errmsg;
        }
    }

    //执行存储的业务逻辑
    public abstract void save(List list, Class errcla) throws IllegalAccessException, InstantiationException, ExecutionException, InterruptedException;

    //读取结束的时候进行处理,如果有失败的,那么就导出到文件中
    public JsonMessage finish(String searcherrorpath) {
        String failpath = "";
        failpath = EasyExceltofileUtil.exlport(getreportName() + "导入失败内容", searcherrorpath, errorList, errcla);
        EasyexlMessage easyexlMessage = EasyexlMessage.builder().failco(failco).successco(successco).msg(message).failpath(failpath).build();
        return new JsonMessage(true, message, easyexlMessage);
    }


    @Override
    public String getreportName() {
        return ConfigConstants.EasyExcelTitle;
    }


    //将导出失败的原因进行反射加入
    protected void addfailandsetremark(Object o, String remark) {
        try {
            Object o1 = errcla.newInstance();
            BeanUtils.copyProperties(o, o1);
            Class<? extends Object> c = o1.getClass();
            Method methods2;
            try {
                methods2 = c.getMethod("setRemark", String.class);// 注意参数不是String,是string
                methods2.invoke(o1, remark);// 通过对象，调用有参数的方法
                // 如果这个地方需要持久保存，那么就是object类放进去。不然就是加上c.newInstance()
            } catch (Exception e) {
                e.printStackTrace();
            }
            addfailco(1);
            errorList.add(o1);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

    }


    //添加成功的条数
    public void addsuccess(int suco) {
        successco = successco + suco;
    }

    //添加失败的条数
    public void addfailco(int failco) {
        this.failco = this.failco + failco;
        message = errmsg;
    }

    public void setIssave(boolean issave) {
        this.issave = issave;
    }

    public boolean isIssave() {
        return issave;
    }

    public List getErrorList() {
        return errorList;
    }

    public int getFailco() {
        return failco;
    }

    public String getMessage() {
        return message;
    }

    public int getSuccessco() {
        return successco;
    }
}
