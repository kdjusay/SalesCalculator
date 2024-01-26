package org.example;

public class RepairService implements Item {
    private String serviceName;
    private double pricePerHour;
    private int numberOfHours;

    public RepairService(String serviceName, double pricePerHour, int numberOfHours) {
        this.serviceName = serviceName;
        this.pricePerHour = pricePerHour;
        this.numberOfHours = numberOfHours;
    }

    @Override
    public String getItemName() {
        return serviceName;
    }

    @Override
    public double calculateTotalSales() {
        return pricePerHour * numberOfHours;
    }
}
