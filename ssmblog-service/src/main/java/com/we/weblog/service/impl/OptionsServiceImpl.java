package com.we.weblog.service.impl;

import com.we.weblog.domain.Options;
import com.we.weblog.service.OptionsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author Clay
 * @date 2018/10/24 9:43
 */
@Service
public class OptionsServiceImpl implements OptionsService {
    private static final Logger LOGGER = LoggerFactory.getLogger(OptionsServiceImpl.class);

    /**
     * 存储配置
     * @param key   key
     * @param value value
     */
    @Override
    public void saveOption(String key, String value) {

    }

    /**
     * 存储多个配置
     *
     * @param options options
     */
    @Override
    public void saveOptions(Map<String, String> options) {

    }

    /**
     * 查找所有的配置项
     *
     * @return
     */
    @Override
    public Map<String, String> findAllOptions() {
        return null;
    }


    /**
     * 删除配置项
     *
     * @param options options
     */
    @Override
    public void removeOption(Options options) {

    }
}
