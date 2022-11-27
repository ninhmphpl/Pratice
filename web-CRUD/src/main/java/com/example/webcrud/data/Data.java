package com.example.webcrud.data;

import java.util.HashMap;

public class Data {
    private final HashMap<Integer, Product> products;

    public Data(HashMap<Integer, Product> products) {
        this.products = products;
    }
    private int newProductCode;

    public Data() {
        products = new HashMap<>();
        newProductCode = 0;
    }

    public HashMap<Integer, Product> getProducts() {
        return products;
    }

    public boolean check(int productCode){
        return products.containsKey(productCode);
    }
    public int getNewProductCode(){
        return ++newProductCode;
    }



}
