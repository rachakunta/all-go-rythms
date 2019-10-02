package com.rana.design.lrucache;

import com.rana.models.DLinkedList;

import java.util.Hashtable;
import java.util.Map;

public class DesignMain {
    public static void main(String[] args) {
        LRUCache cache = new LRUCache(3);
        cache.put(1, "h");cache.put(2, "h");cache.put(3, "h");cache.put(4, "h");cache.get(3);
        //System.out.println(cache.keySet());
        DLinkedList d1 = createDList(1, 10);DLinkedList d2 = createDList(2, 20);DLinkedList d3 = createDList(3, 30);
        DLinkedList d4 = createDList(4, 40);DLinkedList d5 = createDList(5, 50);

        /*d1.pre = null;d1.post = d2;
        d2.pre = d1; d2.post = d3;
        d3.pre = d2; d3.post = d4;
        d4.pre = d3; d4. post = d5;
        d5.pre = d4; d5.post = null;*/

        /*LRUCacheUsingDList cache2 = new LRUCacheUsingDList(2);
        cache2.put(1, 10);
        cache2.put(2, 20);
        cache2.put(3, 30);
        cache2.put(4, 40);
        cache2.get(2);
        printCache2(cache2);*/

        LRUCacheLC lc = new LRUCacheLC(3);
        lc.put(1, 10);lc.put(2, 20);lc.put(3, 30);
        System.out.println(lc.get(2));
        printCache2(lc);
    }

    private static void printCache2(LRUCacheLC cache2) {
        Hashtable<Integer, LRUCacheLC.DLinkedNode> head = cache2.cache;
        for(Map.Entry e : head.entrySet()){
            System.out.println(e.getKey() +"  " + e.getValue());
        }
    }

    private static DLinkedList createDList(int key, int value){
        DLinkedList d =  new DLinkedList();
        d.key = key;
        d.val = value;
        return d;
    }
}
