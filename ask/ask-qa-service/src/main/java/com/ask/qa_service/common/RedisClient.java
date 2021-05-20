package com.ask.qa_service.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author zhulongkun20@163.com
 * @since 2021/5/20 10:58 PM
 */
@Service
public class RedisClient {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    /**
     * 设置缓存
     *
     * @param key   key
     * @param value value
     */
    public void set(String key, Object value) {
        redisTemplate.opsForValue().set(key, value);
    }

    /**
     * 设置缓存并设置超期时间
     *
     * @param key     key
     * @param value   value
     * @param timeout 超时时间，单位 秒
     */
    public void set(String key, Object value, long timeout) {
        redisTemplate.opsForValue().set(key, value, timeout, TimeUnit.SECONDS);
    }

    /**
     * 删除缓存
     *
     * @param key key
     */
    public boolean delete(String key) {
        redisTemplate.delete(key);
        return !Boolean.TRUE.equals(redisTemplate.hasKey(key));
    }

    /**
     * 获取缓存
     *
     * @param key key
     * @return object or null
     */
    public Object get(String key) {
        if (Boolean.TRUE.equals(redisTemplate.hasKey(key))) {
            return redisTemplate.opsForValue().get(key);
        } else {
            return null;
        }
    }

    /**
     * 获取缓存的超期时间
     *
     * @param key key
     * @return 超期时间
     */
    public Long getExpire(String key) {
        if (Boolean.TRUE.equals(redisTemplate.hasKey(key))) {
            return redisTemplate.getExpire(key);
        } else {
            return Long.parseLong(-2 + "");
        }
    }
}
