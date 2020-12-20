package cn.keking.service.database.easyexcel.impl;

import cn.keking.config.ConfigConstants;
import cn.keking.model.ext.DraweNoDTO;
import cn.keking.service.cache.CacheService;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class DraweNoCache {

    private final String keymap = ConfigConstants.getkeyDRAWE();

    private final CacheService cacheService;

    public DraweNoCache(CacheService cacheService) {
        this.cacheService = cacheService;
    }

    /**
     * @return 已转换过的文件集合(缓存)
     */
    public Map<String, List<DraweNoDTO>> listConvertedFiles() {
        return cacheService.getDRAWINGSCache();
    }

    /**
     * 添加缓存
     * @param key
     * @param value 值
     */
    public void addConvertedDRAWINGS(String key, List<DraweNoDTO> value){
        cacheService.putDRAWINGSCache(key, value);
    }

    /**
     * 获取redis缓存
     * @return list
     */
    public List<DraweNoDTO> getDrawingsCache(String key){
        return cacheService.getDRAWINGSCache(key);
    }

}
