package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SalesPanel extends JPanel {
    private JTextField phoneNameField, phonePriceField, phoneQuantityField, repairNameField, repairPriceField, repairHoursField;
    private JTextArea resultArea;

    public SalesPanel() {
        setLayout(new BorderLayout(5, 5));  // Use BorderLayout with vertical gap
        setBorder(BorderFactory.createEmptyBorder(20, 10, 20, 10)); // Add some padding

        // Set the background color to misty rose
        setBackground(new Color(255, 228, 225)); // RGB values for light blue

        JPanel inputPanel = new JPanel(new GridLayout(7, 2, 10, 10));
        inputPanel.setBackground(new Color(255, 228, 225));

        inputPanel.add(new JLabel("Product name:"));
        phoneNameField = new JTextField();
        inputPanel.add(phoneNameField);
        inputPanel.add(new JLabel("Price:"));
        phonePriceField = new JTextField();
        inputPanel.add(phonePriceField);
        inputPanel.add(new JLabel("Quantity sold:"));
        phoneQuantityField = new JTextField();
        inputPanel.add(phoneQuantityField);

        inputPanel.add(new JLabel("Repair Type:"));
        repairNameField = new JTextField();
        inputPanel.add(repairNameField);
        inputPanel.add(new JLabel("Price per hour:"));
        repairPriceField = new JTextField();
        inputPanel.add(repairPriceField);
        inputPanel.add(new JLabel("Number of hours:"));
        repairHoursField = new JTextField();
        inputPanel.add(repairHoursField);

        JButton calculateButton = new JButton("Calculate");

        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateAndDisplaySales();
            }
        });

        add(inputPanel, BorderLayout.NORTH);
        add(calculateButton, BorderLayout.CENTER);

        // Set the resultArea to a larger size below the button
        resultArea = new JTextArea(3, 20);
        resultArea.setEditable(false);
        resultArea.setFont(new Font("Arial", Font.PLAIN, 12)); // Set font size
        add(new JScrollPane(resultArea), BorderLayout.SOUTH); // Use a JScrollPane for multiline text
    }

    private void calculateAndDisplaySales() {
        try {
            // Parse input values
            String phoneName = phoneNameField.getText();
            double phonePrice = Double.parseDouble(phonePriceField.getText());
            int phoneQuantity = Integer.parseInt(phoneQuantityField.getText());

            String repairName = repairNameField.getText();
            double repairPrice = Double.parseDouble(repairPriceField.getText());
            int repairHours = Integer.parseInt(repairHoursField.getText());

            // Create instances of items using abstraction
            Item phone = new Phone(phoneName, phonePrice, phoneQuantity);
            Item repairService = new RepairService(repairName, repairPrice, repairHours);

            // Calculate total sales using the abstraction
            double phoneTotalSales = phone.calculateTotalSales();
            double repairTotalSales = repairService.calculateTotalSales();

            // Display results
            String resultText = "Total sales for " + phone.getItemName() + ": ₱" + phoneTotalSales + "\n" +
                    "Total sales for " + repairService.getItemName() + ": ₱" + repairTotalSales;

            resultArea.setText(resultText);

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Invalid input. Please enter numeric values.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

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