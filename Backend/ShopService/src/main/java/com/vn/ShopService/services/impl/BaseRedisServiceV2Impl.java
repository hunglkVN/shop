package com.vn.ShopService.services.impl;

import com.vn.ShopService.services.BaseRedisServiceV2;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class BaseRedisServiceV2Impl<K, F, V> implements BaseRedisServiceV2<K, F, V> {
    private final RedisTemplate<K, V> redisTemplate;

    private final HashOperations<K, F, V> hashOperations;

    public BaseRedisServiceV2Impl(RedisTemplate<K, V> redisTemplate) {
        this.redisTemplate = redisTemplate;
        hashOperations = redisTemplate.opsForHash();
    }

    @Override
    public void set(K key, V value) {
        redisTemplate.opsForValue().set(key, value);
    }

    @Override
    public void setTimeToLive(K key, long timeoutInDays) {
        redisTemplate.expire(key, timeoutInDays, TimeUnit.DAYS);
    }

    @Override
    public void hashSet(K key, F field, V value) {
        hashOperations.put(key, field, value);
    }

    @Override
    public Object get(K key) {
        return redisTemplate.opsForValue().get(key);
    }
}
