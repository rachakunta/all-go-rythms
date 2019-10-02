package com.rana.design.vendingmachine;

import com.rana.models.Coin;
import com.rana.models.Item;

import java.util.HashMap;
import java.util.List;

public interface VendingMachine {
    int getPrice(Item item);
    List<Coin> getChange(List<Coin> coins);
    void cancel();
    void purchase(Item item);
    List<Item> availableItems();
}
