package com.evario;

import javax.swing.*;

public class Warehouse extends Storage {

   // Item phone = new Item("Phone", 100, new ImageIcon("images/phone1.png"));было
    Item apple = new Item("Apple", 80, new ImageIcon(this.getClass().getResource("/apple1.png")));
    Item phone = new Item("Phone", 100, new ImageIcon("images/phone1.png"));
    Item laptop = new Item("Laptop", 250, new ImageIcon("images/laptop1.png"));
    Item pen = new Item("Pen", 70, new ImageIcon("images/pen1.png"));
    Item mouse = new Item("Mouse", 45, new ImageIcon("images/mouse1.png"));
    Item milk = new Item("Milk", 90, new ImageIcon("images/milk1.png"));
    Item cocaCola = new Item("CocaCola", 110, new ImageIcon("images/cocaCola1.png"));
    Item water = new Item("Water", 50, new ImageIcon("images/water1.png"));
    Item toy = new Item("Toy", 120, new ImageIcon("images/toy1.png"));
    Item cup = new Item("Cup", 120, new ImageIcon("images/cup1.png"));
    Item glass = new Item("Glass", 75, new ImageIcon("images/glass1.png"));
    Item notepad = new Item("Notepad", 40, new ImageIcon("images/notepad1.png"));

    Item item = new Item("empty", 0, new ImageIcon("images/empty1.png"));
    public Item[] itemsArrayWarehouse = new Item[]{
            apple, phone, laptop,
            pen, mouse, milk,
            cocaCola, water, toy,
            cup, glass, notepad,
            item, item, item,
            item, item, item,
            item, item, item,
            item, item, item,
            item, item, item};

    //public void addElementFromBack() {
    //
    // }

}
