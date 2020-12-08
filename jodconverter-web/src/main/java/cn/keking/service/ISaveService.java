package cn.keking.service;


import cn.keking.model.FileSave;

import java.util.List;

public interface ISaveService {
    FileSave save(FileSave fileSave);

    List<FileSave> findFileSavesByUserName(String useName);

    FileSave findFileSaveByLocalLink(String localLink);

    FileSave findFileSaveByUserNameAndFileName(String userName, String fileName);

    void delete(FileSave fileSave);
}
