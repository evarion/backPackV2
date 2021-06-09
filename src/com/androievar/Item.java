package com.androievar;

import javax.swing.*;


public class Item {
    String name;
    public int weight;
    public ImageIcon imageIcon;


    public Item(String name, int weight,ImageIcon imageIcon) {
        this.name = name;
        this.weight = weight;
        this.imageIcon=imageIcon;
    }


    public Item(String name, int weight){
        this.name=name;
        this.weight=weight;
    }


}
