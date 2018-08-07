package com.huoli.checkin.cache;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class DefaultCache<K, V> implements Cache<K, V> {
    
    private Map<K, V> cacheMap = new ConcurrentHashMap<K, V>();

    @Override
    public V get(K key) {
        // TODO Auto-generated method stub
        if(key == null) {
            throw new NullPointerException("key is null");
        }
        return cacheMap.get(key);
    }

    @Override
    public void put(K key, V value) {
        // TODO Auto-generated method stub
        cacheMap.put(key, value);
        
    }

    @Override
    public boolean remove(K key) {
        // TODO Auto-generated method stub
        return cacheMap.remove(key) !=null;
        
    }

    @Override
    public void clear() {
        // TODO Auto-generated method stub
        cacheMap.clear();
         
    }

}
