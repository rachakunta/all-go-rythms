package com.rana.models;

public class DLinkedList {
    public int val;
    public int key;
    public DLinkedList pre;
    public DLinkedList post;

    public DLinkedList(int val, int key) {
        this.val = val;
        this.key = key;
    }

    public DLinkedList() {
    }

    /*@Override
    public String toString() {
        return "DLinkedList{" +
                "val=" + val +
                ", key=" + key +
                ", pre=" + pre +
                ", post=" + post +
                '}';
    }*/
}
