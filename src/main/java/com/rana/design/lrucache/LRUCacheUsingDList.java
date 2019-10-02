package com.rana.design.lrucache;

import com.rana.models.DLinkedList;

import java.util.HashMap;
import java.util.LinkedList;

public class LRUCacheUsingDList {
    HashMap<Integer, DLinkedList> cache;
    int capacity;
    DLinkedList head, tail;
    int count = 0;

    LRUCacheUsingDList(int capacity){
        cache = new HashMap<>();
        this.capacity = capacity;
        head = new DLinkedList();
        tail = new DLinkedList();
        head.post = tail;
        head.pre = null;

        tail.pre = head;
        tail.post = null;
    }

    public void put(int key, int value){
        DLinkedList node = cache.get(key);
        if(node == null){
            node = new DLinkedList(key, value);
            //cache.put(key,);
        }
    }

    public int get(int key){
        DLinkedList node = cache.get(key);
        if(null == node) return -1;
       // update(node);
        return node.val;
    }

    private void addToHead(DLinkedList node) {
        if(node == null){
            return;
        }
        put(node.key, node.val);
    }

    private DLinkedList removeNode(DLinkedList node) {
        if(node == null) return null;
        DLinkedList d = new DLinkedList();
        d.post = head;
        while(head != null){
            if(head.key == node.key){
                DLinkedList pre = head.pre;
                DLinkedList post = head.post;

                pre.post = post;
                post.pre = pre;
            }
        }
        //count--;
        head = d.post;
        return node;
    }

    private void removeFromTail(){
        if(head == null) return;
        count--;
        DLinkedList tailPre = tail.pre;
        tailPre.post = null;

    }

    @Override
    public String toString() {
        return "LRUCacheUsingDList{" +
                "cache=" + cache +
                ", capacity=" + capacity +
                ", head=" + head +
                ", count=" + count +
                '}';
    }
}
