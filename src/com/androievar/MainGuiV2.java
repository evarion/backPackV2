package com.androievar;

import javax.swing.*;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MainGuiV2 extends JFrame {

    int limit = 0;
    int test =0;
    int test2 = 0;
    String tempString = "";
    int newWeight = 0;
    Warehouse warehouse = new Warehouse();
    BackPack backPack = new BackPack(600);


    String lastButtonClickBackPack;
    String lastButtonClickWarehouse;

    int sumElementBackPack = 0;

    public double progStepBackPack;

    JLabel jLabelWarehouse = new JLabel("WAREHOUSE");
    JLabel jLabelBackPack = new JLabel("BACKPACK");

    JLabel jLableWeigtName = new JLabel("изменение max веса");

    public JLabel jLabelCurrentWeightBackPack = new JLabel();

    JLabel jLabelText = new JLabel("<html>__________________________<br>" +
            "переключение режима<br>" +
            "перемещения предметов");

    JPanel jPanelLeftMain = new JPanel();//левая панель
    JPanel jPanelInLeft1 = new JPanel();
    JPanel jPanelInLeft2 = new JPanel();
    JPanel jPanelRightMain = new JPanel();//правая панель
    JPanel jPanelInRight1 = new JPanel();// на правой панели 1
    JPanel jPanelInRight2 = new JPanel();// на правой панели 2 пустая для кнопок
    JPanel jPanelInRight3 = new JPanel();// на правой панели 3

    JPanel jPanelWarehouseName = new JPanel();
    JPanel jPanelBackPackName = new JPanel();
    JPanel jPanelWarehouse = new JPanel();//панель для склада+++++++++++++++++++++++++++++++
    JScrollPane jScrollWarehouse = new JScrollPane(jPanelWarehouse); //на правой панели верх 1
    JPanel jPanelInfoPanelWareHouse = new JPanel(); //на правой панели низ 1
    JPanel jPanelBackPack = new JPanel();// панель для рюкзака++++++++++++++++++++++++++++++
    JScrollPane jScrollBackPack = new JScrollPane(jPanelBackPack); //на правой панели верх 3
    JPanel jPanelInfoPanelBackPack = new JPanel(); //на правой панели низ 3
    JPanel jPanelProgBarCurWeightBackPack = new JPanel();
    JPanel jPanelBackPackProgBar = new JPanel();
    JPanel jPanelCurrentWeightBackPack = new JPanel();

    JTextField jTextField = new JTextField();

    String textJTextField;

    JButton[] jButtonsWarehouse = new JButton[26];//21
    JButton[] jButtonsBackPack = new JButton[26];
    JCheckBox jCheckBox1 = new JCheckBox();


    public JProgressBar jProgressBarBackPack = new JProgressBar();


    public MainGuiV2() {
        super("App");
        createGUI();

    }

    public void createGUI() {


        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //setLayout(new GridBagLayout());
        setLayout(new GridLayout(1, 2));


        jPanelLeftMain.setBackground(Color.GREEN);
        //jPanelLeftMain.setLayout(new BoxLayout(jPanelLeftMain,BoxLayout.X_AXIS));
        jPanelLeftMain.setLayout(new GridLayout(1, 2));
        JButton jButtonPlus = new JButton("+");
        JButton jButtonMinus = new JButton("- ");
        JButton jButton2 = new JButton("включить режим");
        JButton jButton3 = new JButton("test Button3");


        jButtonPlus.addActionListener(new PlusMaxWeight());
        jButtonMinus.addActionListener(new MinusMaxWeight());

        jPanelInLeft1.setBackground(Color.ORANGE);
        jPanelLeftMain.add(jPanelInLeft1);
        //jPanelInLeft1.setLayout(new BoxLayout(jPanelInLeft1, BoxLayout.X_AXIS));
        jPanelInLeft1.setLayout(new FlowLayout());

        jPanelInLeft1.add(jLableWeigtName);
        jPanelInLeft1.add(jTextField);
        jPanelInLeft1.add(jButtonPlus);
        jPanelInLeft1.add(jButtonMinus);


        jTextField.setPreferredSize(new Dimension(80, 30));
        jTextField.setMaximumSize(new Dimension(150, 30));

        jTextField.setDocument(new PlainDocument() {//ограничение на jTextField
            String chars = "0123456789.";

            @Override
            public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {

                if (chars.indexOf(str) != -1) {

                    if (getLength() < 4) {

                        super.insertString(offs, str, a);

                    }
                }
            }
        });


        //_____________________________


        jPanelInLeft2.setBackground(Color.GREEN);
        jPanelLeftMain.add(jPanelInLeft2);

        jPanelInLeft2.setLayout(new BoxLayout(jPanelInLeft2, BoxLayout.Y_AXIS));

        jButton2.addActionListener(new ChangeMode());
        jPanelInLeft2.add(jButton2);
        jPanelInLeft2.add(jButton3);

        jPanelInLeft2.add(jLabelText);
        jPanelInLeft2.add(jCheckBox1);// проверка JCheckBox1


        jPanelRightMain.setBackground(Color.YELLOW);
        jPanelRightMain.setLayout(new BoxLayout(jPanelRightMain, BoxLayout.X_AXIS));

        jPanelRightMain.add(jPanelInRight1);
        jPanelInRight1.setBackground(Color.BLUE);
        jPanelInRight1.setLayout(new BoxLayout(jPanelInRight1, BoxLayout.Y_AXIS));

        jPanelRightMain.add(jPanelInRight2);
        jPanelInRight2.setBackground(Color.RED);
        jPanelRightMain.add(jPanelInRight3);
        jPanelInRight3.setBackground(Color.GRAY);
        jPanelInRight3.setLayout(new BoxLayout(jPanelInRight3, BoxLayout.Y_AXIS));


        jPanelWarehouseName.add(jLabelWarehouse);

        jPanelInRight1.add(jPanelWarehouseName);
        jPanelInRight1.add(jScrollWarehouse);
        jPanelInRight1.add(jPanelInfoPanelWareHouse);
        jPanelInfoPanelWareHouse.setBackground(Color.YELLOW);


        jPanelBackPackName.add(jLabelBackPack);

        jPanelInRight3.add(jPanelBackPackName);
        jPanelInRight3.add(jScrollBackPack);
        jPanelInRight3.add(jPanelInfoPanelBackPack);
        jPanelInfoPanelBackPack.setBackground(Color.PINK);

        jPanelWarehouse.setLayout(new GridLayout(14, 2));
        jPanelBackPack.setLayout(new GridLayout(14, 2));


        jScrollWarehouse.setPreferredSize(new Dimension(600, 500));
        jScrollWarehouse.createVerticalScrollBar();
        jScrollBackPack.setPreferredSize(new Dimension(600, 500));
        jScrollBackPack.createVerticalScrollBar();


        for (int i = 0; i < jButtonsWarehouse.length; i++) {
            jButtonsWarehouse[i] = new JButton();
            jButtonsWarehouse[i].setName("ButtonWarehouse" + i);
            jButtonsWarehouse[i].setIcon(warehouse.itemsArrayWarehouse[i].imageIcon);
            jButtonsWarehouse[i].setHorizontalAlignment(SwingConstants.LEFT);
            jButtonsWarehouse[i].setText(String.valueOf(warehouse.itemsArrayWarehouse[i].weight + "  г.     "));

            jButtonsWarehouse[0].setBackground(Color.gray.brighter());
            jButtonsWarehouse[i].addActionListener(new SelectElementWarehouse());


        }

        for (int i = 12; i < jButtonsWarehouse.length; i++) {
            jButtonsWarehouse[i].setEnabled(false);
        }
        for (int i = 0; i < jButtonsWarehouse.length; i++) {
            jPanelWarehouse.add(jButtonsWarehouse[i]);

        }

        for (int i = 0; i < jButtonsBackPack.length; i++) {
            jButtonsBackPack[i] = new JButton();
            jButtonsBackPack[i].setName("ButtonBackPack" + i);
            jButtonsBackPack[i].setIcon(backPack.itemsArrayBackPack[0].imageIcon);
            jButtonsBackPack[i].setHorizontalAlignment(SwingConstants.LEFT);
            jButtonsBackPack[i].setText(String.valueOf(backPack.itemsArrayBackPack[0].weight + "   г.      "));
            //режим выбора

            jButtonsBackPack[i].addActionListener(new SelectElementBackPack());
            jButtonsBackPack[0].setBackground(Color.gray.brighter());

        }
        for (int i = 12; i < jButtonsBackPack.length; i++) {
            jButtonsBackPack[i].setEnabled(false);
        }


        for (int i = 0; i < jButtonsBackPack.length; i++) {
            jPanelBackPack.add(jButtonsBackPack[i]);
        }


        jProgressBarBackPack.setStringPainted(true);
        jProgressBarBackPack.setMinimum(0);
        jProgressBarBackPack.setMaximum(100);
        jProgressBarBackPack.setValue(0);
        jProgressBarBackPack.setPreferredSize(new Dimension(180, 20));


        jPanelProgBarCurWeightBackPack.setLayout(new BoxLayout(jPanelProgBarCurWeightBackPack, BoxLayout.X_AXIS));


        jPanelBackPackProgBar.add(jProgressBarBackPack);
        jPanelBackPackProgBar.setBackground(Color.PINK);
        jPanelCurrentWeightBackPack.add(jLabelCurrentWeightBackPack);
        jLabelCurrentWeightBackPack.setBackground(Color.PINK);
        jPanelCurrentWeightBackPack.setBackground(Color.PINK);


        jLabelCurrentWeightBackPack.setText(Integer.toString(0) + " / " + backPack.maxWeigth);


        jPanelProgBarCurWeightBackPack.add(jPanelCurrentWeightBackPack);
        jPanelProgBarCurWeightBackPack.add(jPanelBackPackProgBar);
        jPanelProgBarCurWeightBackPack.setBackground(Color.PINK);
        jPanelInfoPanelBackPack.add(jPanelProgBarCurWeightBackPack);


        JButton jButtonAdd = new JButton("Переместить элемент");
        jPanelInfoPanelWareHouse.add(jButtonAdd);
        jButtonAdd.addActionListener(new ReplaceElement());


        add(jPanelLeftMain);
        add(jPanelRightMain);
        setLocation(200, 40);

        setMinimumSize(new Dimension(1300, 720));


    }

    class SelectElementWarehouse implements ActionListener {
        String lastButtonPress;

        @Override
        public void actionPerformed(ActionEvent e) {
            JButton btn = (JButton) e.getSource();
            lastButtonPress = btn.getName().toString();
            lastButtonClickWarehouse = lastButtonPress;

            for (JButton jButton : jButtonsWarehouse) {
                if (jButton.getBackground() != null)
                    jButton.setBackground(null);

                if (lastButtonPress.equals(jButton.getName())) {
                    jButton.setBackground(Color.GRAY.brighter());
                }
            }
        }
    }

    class SelectElementBackPack implements ActionListener {
        String lastButtonPress;

        @Override
        public void actionPerformed(ActionEvent e) {
            JButton btn = (JButton) e.getSource();
            lastButtonPress = btn.getName().toString();
            lastButtonClickBackPack = lastButtonPress;

            for (int i = 0; i < jButtonsBackPack.length; i++) {
                if (jButtonsBackPack[i].getBackground() != null)
                    jButtonsBackPack[i].setBackground(null);

                if (lastButtonPress.equals(jButtonsBackPack[i].getName())) {
                    jButtonsBackPack[i].setBackground(Color.GRAY.brighter());
                }
            }
        }
    }


    class ReplaceElement implements ActionListener {
        Item[] items = new Item[1];
        int selectElementBackPack;
        int selectElementWareHouse;


        @Override
        public void actionPerformed(ActionEvent e) {
            sumElementBackPack = 0;


            for (int i = 0; i < backPack.itemsArrayBackPack.length; i++) {
                sumElementBackPack = sumElementBackPack + backPack.itemsArrayBackPack[i].weight;

            }
            for (int i = 0; i < jButtonsBackPack.length; i++) {
                if (jButtonsBackPack[i].getName().equals(lastButtonClickBackPack)) {
                    selectElementBackPack = i;
                }
            }
            for (int i1 = 0; i1 < jButtonsWarehouse.length; i1++) {
                if (jButtonsWarehouse[i1].getName().equals(lastButtonClickWarehouse)) {
                    selectElementWareHouse = i1;
                }
            }


            if (jCheckBox1.isSelected()) {
                if (backPack.itemsArrayBackPack[selectElementBackPack].name.equals("empty")) {
                    if (!warehouse.itemsArrayWarehouse[selectElementWareHouse].name.equals("empty")) {
                        if (sumElementBackPack + warehouse.itemsArrayWarehouse[selectElementWareHouse].weight <= backPack.maxWeigth) {
                            items[0] = backPack.itemsArrayBackPack[selectElementBackPack];
                            backPack.itemsArrayBackPack[selectElementBackPack] = warehouse.itemsArrayWarehouse[selectElementWareHouse];
                            warehouse.itemsArrayWarehouse[selectElementWareHouse] = items[0];
                            jButtonsWarehouse[selectElementWareHouse].setIcon(warehouse.itemsArrayWarehouse[selectElementWareHouse].imageIcon);
                            jButtonsWarehouse[selectElementWareHouse].setText(String.valueOf(warehouse.itemsArrayWarehouse[selectElementWareHouse].weight + " г.   "));
                            jButtonsBackPack[selectElementBackPack].setIcon(backPack.itemsArrayBackPack[selectElementBackPack].imageIcon);
                            jButtonsBackPack[selectElementBackPack].setText(String.valueOf(backPack.itemsArrayBackPack[selectElementBackPack].weight + " г.   "));
                            sumElementBackPack = 0;
                            for (int i = 0; i < backPack.itemsArrayBackPack.length; i++) {
                                sumElementBackPack = sumElementBackPack + backPack.itemsArrayBackPack[i].weight;
                            }
                            jLabelCurrentWeightBackPack.setText(Integer.toString(sumElementBackPack) + " / " + backPack.maxWeigth);

                            progStepBackPack = ((double) sumElementBackPack) / backPack.maxWeigth * 100;

                            jProgressBarBackPack.setValue((int) progStepBackPack);
                        } //else {
                        //jLabelInformUser.setText("<html>рюкзак переполнен <br> вес предмета: " + warehouse.itemsArrayWarehouse[selectElementWareHouse].weight +
                        // "<br>вес рюкзака: " + sumElementBackPack + "<br> макс. вес рюкзака: " + backPack.maxWeigth + "</html>");
                        // }
                    }
                } else {
                    if (warehouse.itemsArrayWarehouse[selectElementWareHouse].name.equals("empty")) {
                        if (!backPack.itemsArrayBackPack[selectElementBackPack].name.equals("empty")) {
                            items[0] = warehouse.itemsArrayWarehouse[selectElementWareHouse];
                            warehouse.itemsArrayWarehouse[selectElementWareHouse] = backPack.itemsArrayBackPack[selectElementBackPack];
                            backPack.itemsArrayBackPack[selectElementBackPack] = items[0];
                            jButtonsBackPack[selectElementBackPack].setIcon(backPack.itemsArrayBackPack[selectElementBackPack].imageIcon);
                            jButtonsBackPack[selectElementBackPack].setText(String.valueOf(backPack.itemsArrayBackPack[selectElementBackPack].weight + " г.   "));
                            jButtonsWarehouse[selectElementWareHouse].setIcon(warehouse.itemsArrayWarehouse[selectElementWareHouse].imageIcon);
                            jButtonsWarehouse[selectElementWareHouse].setText(String.valueOf(warehouse.itemsArrayWarehouse[selectElementWareHouse].weight + " г.   "));
                            sumElementBackPack = 0;
                            for (int i = 0; i < backPack.itemsArrayBackPack.length; i++) {
                                sumElementBackPack = sumElementBackPack + backPack.itemsArrayBackPack[i].weight;
                            }
                            jLabelCurrentWeightBackPack.setText(Integer.toString(sumElementBackPack) + " / " + backPack.maxWeigth);

                            progStepBackPack = ((double) sumElementBackPack) / backPack.maxWeigth * 100;
                            jProgressBarBackPack.setValue((int) progStepBackPack);
                        }
                        jLabelCurrentWeightBackPack.setText(Integer.toString(sumElementBackPack) + " / " + backPack.maxWeigth);
                    }

                }
            } else {
                int i2 = 0;
                for (int i = 0; i < backPack.itemsArrayBackPack.length; i++) {
                    if (backPack.itemsArrayBackPack[i].name == "empty") {
                        i2 = i;
                        break;
                    }
                }

                if (backPack.itemsArrayBackPack[i2].name.equals("empty")) {
                    if (!warehouse.itemsArrayWarehouse[selectElementWareHouse].name.equals("empty")) {
                        if (sumElementBackPack + warehouse.itemsArrayWarehouse[selectElementWareHouse].weight <= backPack.maxWeigth) {
                            items[0] = backPack.itemsArrayBackPack[i2];
                            backPack.itemsArrayBackPack[i2] = warehouse.itemsArrayWarehouse[selectElementWareHouse];
                            warehouse.itemsArrayWarehouse[selectElementWareHouse] = items[0];
                            jButtonsWarehouse[selectElementWareHouse].setIcon(warehouse.itemsArrayWarehouse[selectElementWareHouse].imageIcon);
                            jButtonsWarehouse[selectElementWareHouse].setText(String.valueOf(warehouse.itemsArrayWarehouse[selectElementWareHouse].weight + " г.   "));
                            jButtonsBackPack[i2].setIcon(backPack.itemsArrayBackPack[i2].imageIcon);
                            jButtonsBackPack[i2].setText(String.valueOf(backPack.itemsArrayBackPack[i2].weight + " г.   "));
                            sumElementBackPack = 0;
                            for (int i = 0; i < backPack.itemsArrayBackPack.length; i++) {
                                sumElementBackPack = sumElementBackPack + backPack.itemsArrayBackPack[i].weight;
                            }
                            jLabelCurrentWeightBackPack.setText(Integer.toString(sumElementBackPack) + " / " + backPack.maxWeigth);

                            progStepBackPack = ((double) sumElementBackPack) / backPack.maxWeigth * 100;

                            jProgressBarBackPack.setValue((int) progStepBackPack);

                            //========================================================================================

                            for (int i1 = 0; i1 < jButtonsWarehouse.length; i1++) {
                                if (jButtonsWarehouse[i1].getBackground() != null)
                                    jButtonsWarehouse[i1].setBackground(null);

                            }
                            for (int i = 0; i < warehouse.itemsArrayWarehouse.length; i++) {
                                if (warehouse.itemsArrayWarehouse[i].name == "empty") {
                                    lastButtonClickWarehouse = jButtonsWarehouse[i].getName(); //проверить
                                    jButtonsWarehouse[i].setBackground(Color.GRAY.brighter());
                                    break;
                                }
                            }
                            //==========================================================================================
                        }

                        //else {
                        //jLabelInformUser.setText("<html>рюкзак переполнен <br> вес предмета: " + warehouse.itemsArrayWarehouse[selectElementWareHouse].weight +
                        // "<br>вес рюкзака: " + sumElementBackPack + "<br> макс. вес рюкзака: " + backPack.maxWeigth + "</html>");
                        // }

                    } else {
                        if (warehouse.itemsArrayWarehouse[selectElementWareHouse].name.equals("empty")) {
                            if (!backPack.itemsArrayBackPack[selectElementBackPack].name.equals("empty")) {
                                items[0] = warehouse.itemsArrayWarehouse[selectElementWareHouse];
                                warehouse.itemsArrayWarehouse[selectElementWareHouse] = backPack.itemsArrayBackPack[selectElementBackPack];
                                backPack.itemsArrayBackPack[selectElementBackPack] = items[0];
                                jButtonsBackPack[selectElementBackPack].setIcon(backPack.itemsArrayBackPack[selectElementBackPack].imageIcon);
                                jButtonsBackPack[selectElementBackPack].setText(String.valueOf(backPack.itemsArrayBackPack[selectElementBackPack].weight + " г.   "));
                                jButtonsWarehouse[selectElementWareHouse].setIcon(warehouse.itemsArrayWarehouse[selectElementWareHouse].imageIcon);
                                jButtonsWarehouse[selectElementWareHouse].setText(String.valueOf(warehouse.itemsArrayWarehouse[selectElementWareHouse].weight + " г.   "));
                                sumElementBackPack = 0;
                                for (int i = 0; i < backPack.itemsArrayBackPack.length; i++) {
                                    sumElementBackPack = sumElementBackPack + backPack.itemsArrayBackPack[i].weight;
                                }
                                jLabelCurrentWeightBackPack.setText(Integer.toString(sumElementBackPack) + " / " + backPack.maxWeigth);

                                progStepBackPack = ((double) sumElementBackPack) / backPack.maxWeigth * 100;
                                jProgressBarBackPack.setValue((int) progStepBackPack);


                            }
                            jLabelCurrentWeightBackPack.setText(Integer.toString(sumElementBackPack) + " / " + backPack.maxWeigth);
                        }
                    }
                }
            }
        }
    }

    class MinusMaxWeight implements ActionListener {

        String string1;

        @Override
        public void actionPerformed(ActionEvent e) {

            try {
                string1 = jTextField.getText();

                if (backPack.maxWeigth - Integer.parseInt(string1) >= sumElementBackPack) {

                    backPack.maxWeigth = backPack.maxWeigth - Integer.parseInt(string1);

                    sumElementBackPack = 0;
                    for (int i = 0; i < backPack.itemsArrayBackPack.length; i++) {
                        sumElementBackPack = sumElementBackPack + backPack.itemsArrayBackPack[i].weight;
                    }
                    jLabelCurrentWeightBackPack.setText(Integer.toString(sumElementBackPack) + " / " + backPack.maxWeigth);

                    progStepBackPack = ((double) sumElementBackPack) / backPack.maxWeigth * 100;

                    jProgressBarBackPack.setValue((int) progStepBackPack);

                    System.out.println(string1);

                }
            } catch (NumberFormatException e1) {

            }
        }
    }

    class ChangeMode implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }

    class PlusMaxWeight implements ActionListener {

        String string1;

        @Override
        public void actionPerformed(ActionEvent e) {


            try {
                string1 = jTextField.getText();
                backPack.maxWeigth = backPack.maxWeigth + Integer.parseInt(string1);
            } catch (NumberFormatException e1) {
            }


            sumElementBackPack = 0;
            for (int i = 0; i < backPack.itemsArrayBackPack.length; i++) {
                sumElementBackPack = sumElementBackPack + backPack.itemsArrayBackPack[i].weight;
            }
            jLabelCurrentWeightBackPack.setText(Integer.toString(sumElementBackPack) + " / " + backPack.maxWeigth);

            progStepBackPack = ((double) sumElementBackPack) / backPack.maxWeigth * 100;

            jProgressBarBackPack.setValue((int) progStepBackPack);

            System.out.println(string1);
        }
    }


}

