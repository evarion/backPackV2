package com.evario;

import javax.swing.*;
import java.awt.*;


public class Item {
    String name;
    public int weight;
    public ImageIcon imageIcon;


    public Item(String name, int weight,ImageIcon imageIcon) {
        this.name = name;
        this.weight = weight;
        this.imageIcon=imageIcon;
    }


    public Item(String name, int weight, Image image){
        this.name=name;
        this.weight=weight;
    }


}
