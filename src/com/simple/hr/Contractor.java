package com.simple.hr;

public class Contractor implements Payable{
    private String name;
    private double hourlyRate;
    private int hoursWorked;
    private double partsCost;

    public Contractor(String name, double rate, int hours, double parts) {
        this.name = name;
        this.hourlyRate = rate;
        this.hoursWorked = hours;
        this.partsCost = parts;
    }

    @Override
    public double calculatePay() {
        return (hourlyRate*hoursWorked)*2 + partsCost;
    }

    @Override
    public String generatePayStub() {
        return null;
    }

    public void setPartsCost(double cost) { this.partsCost = cost; }
    public void setHoursWorked(int hours) { this.hoursWorked = hours; }
}
