package cn.keking.service.impl;

import cn.keking.mapper.FileSaveRepositoryMapper;
import cn.keking.model.FileSave;
import cn.keking.service.ISaveService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SaveServiceImpl implements ISaveService {

    @Resource
    FileSaveRepositoryMapper fileSaveRepositoryMapper;

    @Override
    public FileSave save(FileSave fileSave) {
        return fileSaveRepositoryMapper.save(fileSave);
    }

    @Override
    public List<FileSave> findFileSavesByUserName(String useName) {
        return fileSaveRepositoryMapper.findFileSavesByUserName(useName);
    }

    @Override
    public FileSave findFileSaveByLocalLink(String localLink) {
        return fileSaveRepositoryMapper.findFileSaveByLocalLink(localLink);
    }

    @Override
    public FileSave findFileSaveByUserNameAndFileName(String userName, String fileName) {
        return fileSaveRepositoryMapper.findFileSaveByUserNameAndFileName(userName, fileName);
    }

    @Override
    public void delete(FileSave fileSave) {
        fileSaveRepositoryMapper.delete(fileSave);
    }
}
