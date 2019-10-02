package com.rana.design.vendingmachine;

import com.rana.models.Coin;
import com.rana.models.Item;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class VendingMachineImpl implements VendingMachine {
    List<Item> items;

    public VendingMachineImpl(List<Item> items) {
        this.items = items;
    }

    @Override
    public int getPrice(Item item) {
        for(;;){

        }
    }

    @Override
    public List<Coin> getChange(List<Coin> coins) {
        return null;
    }

    @Override
    public void cancel() {

    }

    @Override
    public void purchase(Item item) {

    }

    @Override
    public List<Item> availableItems() {
        Item coke = new Item(1, "cola", 5);
        Item pepsi = new Item(1, "pepsi", 2);
        Item thumbsup = new Item(1, "thumbsup", 3);
        List<Item> items = new ArrayList<>();
        items.add(coke);items.add(pepsi);items.add(thumbsup);
        return items;
    }
}
