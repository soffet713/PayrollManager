package com.simple.hr;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.text.DecimalFormat;

public class SalariedEmployee extends Employee{

    private double salary;
    DecimalFormat df = new DecimalFormat("#.##");
    public SalariedEmployee(String name) {
        super(name);
    }

    public SalariedEmployee(String name, double sal, Department dept) {
        super(name);
        this.salary = sal;
        this.department = dept;
    }

    @Override
    public double calculatePay() {
        return (this.salary - (this.salary * 0.3));
    }

    @Override
    public String generatePayStub() {
        // Department objects
        Department dept1 = new Department("Accounting");
        Department dept2 = new Department("IT");
        Department dept3 = new Department("Sales");

        // Add departments to a list
        List<Department> departments = new ArrayList<>();
        departments.add(dept1);
        departments.add(dept2);
        departments.add(dept3);

        Address address = new Address("18167 US Highway 19N Suite 500", "Clearwater", "Florida", "33764");
        Company company = new Company("Daifuku Intralogistics America Corporation", address, departments);
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
        String strDate = format.format(date);

        String outStr;
        outStr = "\t\t\t" + company.getName() + "\n\t" + "Name: " + getName() + " - Employee Id: " + getEmployeeID() +
                "\n\t" + "Pay Date: \t" + strDate +
                "\n\t" + "Net Salary: $" + df.format(calculatePay()) +
                "\n\t" + "Gross Salary: $" + df.format(salary) + "\n\n";

        return outStr;
    }

    public static void printStub(String filePath, List<SalariedEmployee> employees) {
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))){
            for(SalariedEmployee employee : employees) {
                writer.write(employee.generatePayStub());
            }
        } catch (IOException e) {
            System.out.println("An error occurred printing the pay stubs.");
            e.printStackTrace();
        }
    }
}
