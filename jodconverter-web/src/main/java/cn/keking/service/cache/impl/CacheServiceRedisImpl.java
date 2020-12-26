package cn.keking.service.cache.impl;

import cn.keking.model.database.domain.BaseChildDrawings;
import cn.keking.model.database.dto.BaseProcessDrawingsDTO;
import cn.keking.model.ext.DraweNoDTO;
import cn.keking.service.cache.CacheService;
import org.redisson.Redisson;
import org.redisson.api.RBlockingQueue;
import org.redisson.api.RMapCache;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @auther: chenjh
 * @time: 2019/4/2 18:02
 * @description
 */
@ConditionalOnExpression("'${cache.type:default}'.equals('redis')")
@Service
public class CacheServiceRedisImpl implements CacheService {

    private final RedissonClient redissonClient;

    public CacheServiceRedisImpl(Config config) {
        this.redissonClient = Redisson.create(config);
    }

    @Override
    public void initPDFCachePool(Integer capacity) {

    }

    @Override
    public void initIMGCachePool(Integer capacity) {

    }

    @Override
    public void initPdfImagesCachePool(Integer capacity) {

    }

    @Override
    public void putPDFCache(String key, String value) {
        RMapCache<String, String> convertedList = redissonClient.getMapCache(FILE_PREVIEW_PDF_KEY);
        convertedList.fastPut(key, value);
    }

    @Override
    public void putDRAWINGSCache(String key, List<DraweNoDTO> value) {
        RMapCache<String, List<DraweNoDTO>> convertedList = redissonClient.getMapCache(DRAWINGS_TASK_QUEUE_KEY);
        convertedList.fastPut(key, value);
    }

    @Override
    public void putCDRAWINGSCache(String key, List<BaseChildDrawings> value) {
        RMapCache<String, List<BaseChildDrawings>> convertedList = redissonClient.getMapCache(DRAWINGS_TASK_QUEUE_C_KEY);
        convertedList.fastPut(key, value);
    }

    @Override
    public void putImgCache(String key, List<String> value) {
        RMapCache<String, List<String>> convertedList = redissonClient.getMapCache(FILE_PREVIEW_IMGS_KEY);
        convertedList.fastPut(key, value);
    }

    @Override
    public Map<String, String> getPDFCache() {
        return redissonClient.getMapCache(FILE_PREVIEW_PDF_KEY);
    }

    @Override
    public String getPDFCache(String key) {
        RMapCache<String, String> convertedList = redissonClient.getMapCache(FILE_PREVIEW_PDF_KEY);
        return convertedList.get(key);
    }

    @Override
    public Map<String, List<String>> getImgCache() {
        return redissonClient.getMapCache(FILE_PREVIEW_IMGS_KEY);
    }

    @Override
    public List<String> getImgCache(String key) {
        RMapCache<String, List<String>> convertedList = redissonClient.getMapCache(FILE_PREVIEW_IMGS_KEY);
        return convertedList.get(key);
    }

    @Override
    public List<DraweNoDTO> getDRAWINGSCache(String key) {
        RMapCache<String, List<DraweNoDTO>> convertedList = redissonClient.getMapCache(DRAWINGS_TASK_QUEUE_KEY);
        return convertedList.get(key);
    }

    @Override
    public List<BaseChildDrawings> getCDRAWINGSCache(String key) {
        RMapCache<String, List<BaseChildDrawings>> convertedList = redissonClient.getMapCache(DRAWINGS_TASK_QUEUE_C_KEY);
        return convertedList.get(key);
    }

    @Override
    public Map<String, List<DraweNoDTO>> getDRAWINGSCache() {
        return redissonClient.getMapCache(DRAWINGS_TASK_QUEUE_KEY);
    }

    @Override
    public Map<String, List<BaseChildDrawings>> getCDRAWINGSCache() {
        return redissonClient.getMapCache(DRAWINGS_TASK_QUEUE_C_KEY);
    }

    @Override
    public Integer getPdfImageCache(String key) {
        RMapCache<String, Integer> convertedList = redissonClient.getMapCache(FILE_PREVIEW_PDF_IMGS_KEY);
        return convertedList.get(key);
    }

    @Override
    public void putPdfImageCache(String pdfFilePath, int num) {
        RMapCache<String, Integer> convertedList = redissonClient.getMapCache(FILE_PREVIEW_PDF_IMGS_KEY);
        convertedList.fastPut(pdfFilePath, num);
    }

    @Override
    public void cleanCache() {
        cleanPdfCache();
        cleanImgCache();
        cleanPdfImgCache();
    }

    @Override
    public void addQueueTask(String url) {
        RBlockingQueue<String> queue = redissonClient.getBlockingQueue(TASK_QUEUE_NAME);
        queue.addAsync(url);
    }

    @Override
    public String takeQueueTask() throws InterruptedException {
        RBlockingQueue<String> queue = redissonClient.getBlockingQueue(TASK_QUEUE_NAME);
        return queue.take();
    }

    private void cleanPdfCache() {
        RMapCache<String, String> pdfCache = redissonClient.getMapCache(FILE_PREVIEW_PDF_KEY);
        pdfCache.clear();
    }

    private void cleanImgCache() {
        RMapCache<String, List<String>> imgCache = redissonClient.getMapCache(FILE_PREVIEW_IMGS_KEY);
        imgCache.clear();
    }

    private void cleanPdfImgCache() {
        RMapCache<String, Integer> pdfImg = redissonClient.getMapCache(FILE_PREVIEW_PDF_IMGS_KEY);
        pdfImg.clear();
    }
}
