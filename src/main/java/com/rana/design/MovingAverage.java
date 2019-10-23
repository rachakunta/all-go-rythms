package com.rana.design;

import java.util.ArrayList;
import java.util.List;

public class MovingAverage {
    List<Integer> list;
    int count = 0;
    int size;

    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        list = new ArrayList<>();
        this.size = size;
    }

    public double next(int val) {
        count += val;
        list.add(val);

        if(list.size() > size){
            count = count - list.remove(0);
            size--;
        }
        return list.size() > 0 ? ((double)count)/list.size() : 0;
    }
}
