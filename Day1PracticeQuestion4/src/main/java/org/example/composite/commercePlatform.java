package org.example.composite;

public class commercePlatform {
    public static void main(String[] args) {
        // Build the product hierarchy
        ProductCategory electronics = new ProductCatalog("Electronics");
        ProductCategory clothing = new ProductCatalog("Clothing");

        ProductCategory smartphone = new Product("Smartphone", 699.99);
        ProductCategory shirt = new Product("Shirt", 29.99);

        ((ProductCatalog) electronics).addProductCategory(smartphone);
        ((ProductCatalog) clothing).addProductCategory(shirt);

        // Display information
        electronics.display();
        clothing.display();
    }
}