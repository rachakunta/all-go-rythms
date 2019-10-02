package com.rana.design.lrucache;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache extends LinkedHashMap<Integer, String>{
    int capacity;

    public LRUCache(int capacity){
        super(capacity, 0.75F, true);
        this.capacity = capacity;
    }

    public String put(Integer key, String value){
        return super.put(key, value);
    }

    public String get(Integer key){
        return getOrDefault(key, "-1");
    }
    @Override
    public boolean removeEldestEntry(Map.Entry<Integer, String> eldest){
        return size() > capacity;
    }
}
