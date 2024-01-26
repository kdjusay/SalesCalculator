package org.example;

public class Phone implements Item {
    private String productName;
    private double price;
    private int quantity;

    public Phone(String productName, double price, int quantity) {
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
    }

    @Override
    public String getItemName() {
        return productName;
    }

    @Override
    public double calculateTotalSales() {
        return price * quantity;
    }
}