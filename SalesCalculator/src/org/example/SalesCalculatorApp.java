package org.example;

import javax.swing.*;

public class SalesCalculatorApp {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Sales Calculator");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            SalesPanel salesPanel = new SalesPanel();
            frame.getContentPane().add(salesPanel);

            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}