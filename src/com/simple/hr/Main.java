package com.simple.hr;

import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        DecimalFormat df = new DecimalFormat("#.##");

        // Department objects
        Department dept1 = new Department("Accounting");
        Department dept2 = new Department("IT");
        Department dept3 = new Department("Sales");

        // Add departments to a list
        List<Department> departments = new ArrayList<>();
        departments.add(dept1);
        departments.add(dept2);
        departments.add(dept3);

        // Address object
        Address address = new Address("18167 US Highway 19N Suite 500", "Clearwater", "Florida", "33764");

        // Company object
        Company company = new Company("Daifuku Intralogistics America Corporation", address, departments);

        SalariedEmployee emp1 = new SalariedEmployee("Bob Sawyer", 165000, dept1);
        SalariedEmployee emp2 = new SalariedEmployee("Jane Doe", 95000, dept2);
        SalariedEmployee emp3 = new SalariedEmployee("Bill Thomas", 105000, dept3);
        SalariedEmployee emp4 = new SalariedEmployee("Joseph Williams", 75000, dept1);
        SalariedEmployee emp5 = new SalariedEmployee("Sarah Hopkins", 85000, dept2);
        SalariedEmployee emp6 = new SalariedEmployee("Kirsten Cronin", 107000, dept3);

        // Array to store employees
        Employee[] employees = {emp1, emp2, emp3, emp4, emp5, emp6};

        // Print employee info
        List<Employee> employeeList = Arrays.asList(employees);

        // Print stream
        //employeeList.stream().forEach(System.out::println);

        // Group employees by department
        System.out.println("Employees grouped by department.");
        Map<String, List<Employee>> groupedByDepartment =
                employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment));
        groupedByDepartment.forEach(
                (department, employeesInDepartment) -> {
                    System.out.println(department);
                    employeesInDepartment.forEach(
                            employee -> System.out.printf("\t%s%n", employee)
                    );
                }
        );

//        String fileName = "Paystubs.txt";
//        List<SalariedEmployee> employees = new ArrayList<>();
//        employees.add(emp1);
//        employees.add(emp2);
//        employees.add(emp3);
//
//        SalariedEmployee.printStub(fileName,employees);

        //HourlyEmployee emp2 = new HourlyEmployee("Jane White", 35);
        //Contractor cont1 = new Contractor("Tom Builder", 35, 40, 300);

        //System.out.println(df.format(emp1.calculatePay()));
        //System.out.println(df.format(emp2.calculatePay()));
        //System.out.println(df.format(emp3.calculatePay()));
        //System.out.println(df.format(emp2.calculatePay()));
        //System.out.println(df.format(cont1.calculatePay()));
    }
}