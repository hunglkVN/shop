package com.vn.ShopService.services;

public interface BaseRedisServiceV2<K, F, V> {
    void set(K key, V value);
    void setTimeToLive(K key, long timeoutInDays);
    void hashSet(K key, F field, V value);
    Object get(K key);
}
