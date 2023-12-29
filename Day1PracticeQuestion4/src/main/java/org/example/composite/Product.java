package org.example.composite;

public class Product implements ProductCategory {
    private String name;
    private double price;
    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }
    public void display() {
        System.out.println("Product Name ="+this.name);
        System.out.println("Product Price ="+this.price);
    }
}