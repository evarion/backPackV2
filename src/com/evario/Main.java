package com.evario;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {


        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                MainGuiV2 frame = new MainGuiV2();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }
}