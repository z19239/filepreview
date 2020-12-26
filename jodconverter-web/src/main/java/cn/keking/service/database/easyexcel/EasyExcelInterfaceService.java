package cn.keking.service.database.easyexcel;

import cn.keking.model.JsonMessage;

public interface EasyExcelInterfaceService{

    JsonMessage save(String filePath, String errfilepath);

    JsonMessage saveChilddrawings(String filePath, String s);
}
