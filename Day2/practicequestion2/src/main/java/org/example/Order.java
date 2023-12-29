package org.example;

import java.util.ArrayList;
import java.util.List;
//single responsibility
public class Order extends Shipping{
    private List<Product> products = new ArrayList<>();
    private List<String> productsName = new ArrayList<>();
    private double totalAmount;
    public void addProduct(Product product) {
        productsName.add(product.getName());
        products.add(product);
        totalAmount += product.getPrice();
    }
    public void checkout(CustomerDetails customerDetails) {
        //Perform order processing, payment, and shipping logic here
        System.out.print("Your Bill for ");
        System.out.println(productsName);
        //Open-Closed Principle
        cart(customerDetails,totalAmount);
        System.out.println("Order processed successfully.");
    }
}