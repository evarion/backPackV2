package com.androievar;

import javax.swing.*;

public class BackPack extends Storage {
    Item item = new Item("empty", 0, new ImageIcon("images/empty1.png"));
    public Item[] itemsArrayBackPack = new Item[]{item, item, item, item, item, item, item, item, item, item, item, item};

    public int maxWeigth;

    public BackPack(int maxWeight) {
        this.maxWeigth = maxWeight;
    }

    public BackPack() {


    }
}