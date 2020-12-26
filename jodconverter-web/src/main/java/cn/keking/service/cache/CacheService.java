package cn.keking.service.cache;

import cn.keking.model.database.domain.BaseChildDrawings;
import cn.keking.model.ext.DraweNoDTO;

import java.util.List;
import java.util.Map;

/**
 * @author: chenjh
 * @since: 2019/4/2 16:45
 */
public interface CacheService {

    String FILE_PREVIEW_PDF_KEY = "converted-preview-pdf-file";
    String FILE_PREVIEW_IMGS_KEY = "converted-preview-imgs-file";//压缩包内图片文件集合
    String FILE_PREVIEW_PDF_IMGS_KEY = "converted-preview-pdfimgs-file";
    String TASK_QUEUE_NAME = "convert-task";
    String DRAWINGS_TASK_QUEUE_KEY = "draweNo";
    String DRAWINGS_TASK_QUEUE_C_KEY = "cdraweNo";

    Integer DEFAULT_PDF_CAPACITY = 500000;
    Integer DEFAULT_IMG_CAPACITY = 500000;
    Integer DEFAULT_PDFIMG_CAPACITY = 500000;

    void initPDFCachePool(Integer capacity);
    void initIMGCachePool(Integer capacity);
    void initPdfImagesCachePool(Integer capacity);
    void putPDFCache(String key, String value);
    void putDRAWINGSCache(String key, List<DraweNoDTO> value);
    void putCDRAWINGSCache(String key, List<BaseChildDrawings> value);
    void putImgCache(String key, List<String> value);
    Map<String, String> getPDFCache();
    String getPDFCache(String key);
    Map<String, List<String>> getImgCache();
    List<String> getImgCache(String key);
    List<DraweNoDTO> getDRAWINGSCache(String key);
    List<BaseChildDrawings> getCDRAWINGSCache(String key);
    Map<String, List<DraweNoDTO>> getDRAWINGSCache();
    Map<String, List<BaseChildDrawings>> getCDRAWINGSCache();
    Integer getPdfImageCache(String key);
    void putPdfImageCache(String pdfFilePath, int num);
    void cleanCache();
    void addQueueTask(String url);
    String takeQueueTask() throws InterruptedException;
}
