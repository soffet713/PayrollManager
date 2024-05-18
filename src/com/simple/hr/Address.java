package com.simple.hr;

public class Address {
    private String street;
    private String city;
    private String state;
    private String zipCode;

    public Address(String str, String cty, String sta, String zip) {
        this.street = str;
        this.city = cty;
        this.state = sta;
        this.zipCode = zip;
    }

    public void getAddress(){
        System.out.println(
                "Street: " + street +
                "\nCity, State Zip: " + city + ", " + state + " " + zipCode
        );
    }
}
