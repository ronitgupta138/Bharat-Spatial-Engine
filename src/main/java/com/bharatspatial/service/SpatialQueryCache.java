package com.bharatspatial.service;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Thread-safe LRU cache for spatial reverse-geocoding lookups.
 */
public class SpatialQueryCache<K, V> {
    private final int capacity;
    private final LinkedHashMap<K, V> lruMap;

    public SpatialQueryCache(int capacity) {
        this.capacity = capacity;
        this.lruMap = new LinkedHashMap<>(capacity, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
                return size() > SpatialQueryCache.this.capacity;
            }
        };
    }

    public synchronized V get(K key) {
        return lruMap.get(key);
    }

    public synchronized void put(K key, V value) {
        lruMap.put(key, value);
    }

    public synchronized int size() {
        return lruMap.size();
    }
}
