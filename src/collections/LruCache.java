package ru.ifmo.collections;

import java.util.LinkedHashMap;

/**
 * Represents LRU cache with fixed maximum capacity.
 *
 * get() should return null if there is no value for a given key.
 * elements() should return number of elements in cache.
 *
 * This class should not have any other public methods.
 *
 * Implementing this cache in (almost) the same manner as it was implemented during the lecture will result in extra points.
 */
public class LruCache<K, V> {
    private static final float LOAD_FACTOR = 0.75f;
    private final int capacity;
    private LinkedHashMap<K,V> lruMap;

    public LruCache(int capacity) {
        this.capacity = capacity;
        this.lruMap = new LinkedHashMap<>(capacity+1,LOAD_FACTOR, false);
    }

    public V get(K key) {
        if(lruMap.containsKey(key)){
            V tempValue = lruMap.get(key);
            lruMap.remove(key);
            lruMap.put(key, tempValue);
            return tempValue;
        }
        else {
            return null;
        }
    }

    public void put(K key, V value) {
        if(lruMap.size() >= capacity){
            lruMap.remove(lruMap.keySet().iterator().next());
        }
        lruMap.put(key, value);
    }

    public int elements() {
        return lruMap.size();
    }
}