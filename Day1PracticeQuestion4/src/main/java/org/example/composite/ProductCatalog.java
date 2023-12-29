package org.example.composite;

import java.util.ArrayList;
import java.util.List;

public class ProductCatalog implements ProductCategory {
    private List<ProductCategory> items = new ArrayList<>();
    private String name;

    public ProductCatalog(String name) {
        this.name = name;
    }

    public void addProductCategory(ProductCategory item) {
        items.add(item);
    }
    @Override
    public void display() {
        System.out.println("Product Catalog : " + name);

        for (ProductCategory item : items) {
            item.display();
        }
    }
}