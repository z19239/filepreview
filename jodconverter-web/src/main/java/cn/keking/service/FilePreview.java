package cn.keking.service;

import cn.keking.model.FileAttribute;
import org.springframework.ui.Model;

public interface FilePreview {
    String filePreviewHandle(String url, Model model, FileAttribute fileAttribute);
}
