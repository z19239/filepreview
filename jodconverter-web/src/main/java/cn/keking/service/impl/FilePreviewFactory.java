package cn.keking.service.impl;

import cn.keking.model.FileAttribute;
import cn.keking.service.FilePreview;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class FilePreviewFactory {

    private final ApplicationContext context;

    public FilePreviewFactory(ApplicationContext context) {
        this.context = context;
    }

    public FilePreview get(FileAttribute fileAttribute) {
        Map<String, FilePreview> filePreviewMap = context.getBeansOfType(FilePreview.class);
        return filePreviewMap.get(fileAttribute.getType().getInstanceName());
    }
}
