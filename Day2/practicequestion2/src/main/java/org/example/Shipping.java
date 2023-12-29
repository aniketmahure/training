package org.example;

import java.util.HashMap;
import java.util.Map;
//single responsibility
public class Shipping implements Payment {
    private Map<String, Double> map= new HashMap<>();
    public void cart(CustomerDetails customerDetails, double totalAmount){
        totalAmount+=totalAmount>=500?addDeliveryCharge():0;
        map.put(customerDetails.getName(),totalAmount);
        System.out.println("Hi "+customerDetails.getName()+" Your Bill is "+ totalAmount+"rs");
    }
    @Override
    public int addDeliveryCharge() {
        System.out.println("Delivery Charges 150rs Applied");
        return 150;
    }
}