package org.example;

public class CustomerDetails {
    private String name;
    private String number;
    private String address;

    public CustomerDetails(String name, String number, String address){
        this.name = name;
        this.number = number;
        this.address = address;
    }
    public String getName() {
        return name;
    }
    public String getNumber() {
        return number;
    }
    public String getAddress() {
        return address;
    }
}
