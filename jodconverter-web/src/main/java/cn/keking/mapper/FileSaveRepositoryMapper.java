package cn.keking.mapper;


import cn.keking.model.FileSave;

import java.util.List;

public interface FileSaveRepositoryMapper{

    FileSave findFileSaveByLocalLink(String localLink);

    List<FileSave> findFileSavesByUserName(String useName);

    FileSave findFileSaveByPanPath(String panPath);

    FileSave findFileSaveByUserNameAndFileName(String userName, String fileName);

    FileSave save(FileSave fileSave);

    void delete(FileSave fileSave);

}
