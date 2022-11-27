package com.example.webcrud.data;

public class ProductCRUD {
    private final Data data;

    public ProductCRUD(Data data) {
        this.data = data;
    }

    public boolean add(String name, String price, String description) {
        int productCode;
        int iPrice;
        if(name == null || price == null || description == null){
            System.out.println("Add: some thing is null!");
            return false;
        }else {
            try {
                iPrice = Integer.parseInt(price);
            }catch (Exception e){
                System.out.println("Add: Cant ParseInt!");
                return false;
            }
            productCode = data.getNewProductCode();
        }
        Product product = new Product(productCode, name, iPrice, description);
        if (!data.check(productCode)) {
            data.getProducts().put(product.getProductCode(), product);
            System.out.println("Add : true");
            return true;
        } else {
            System.out.println("Add: Product Code is exist!");
            return false;
        }
    }

    public boolean delete(String productCode) {
        if(productCode == null){
            System.out.println("Delete: Product Code is null");
            return false;
        }
        int iProductCode;
        try{
            iProductCode = Integer.parseInt(productCode);
        }catch (Exception e){
            System.out.println("Delete: Cant parseInt!");
            return false;
        }
        if (data.check(iProductCode)) {
            data.getProducts().remove(iProductCode);
            System.out.println("Delete: true");
            return true;
        } else {
            System.out.println("Delete: Product code is not exist!");
            return false;
        }
    }

    public boolean update(String productCode, String name, String price, String description) {
        if(name == null || price == null || description == null){
            System.out.println("Update: some thing is null!");
            return false;
        }
        int iProductCode;
        try {
            iProductCode = Integer.parseInt(productCode);
        }catch (Exception e){
            System.out.println("Update: Cant parseInt!");
            return false;
        }
        if (data.check(iProductCode)) {
            Product product = data.getProducts().get(iProductCode);
            try {
                if (!name.equals("")) {
                    product.setName(name);
                }
                if (!price.equals("")) {
                    product.setPrice(Integer.parseInt(price));
                }
                if (!description.equals("")) {
                    product.setDescription(description);
                }
            } catch (Exception e) {
                System.out.println("Update: cant set property");
                return false;
            }
            return true;
        } else {
            System.out.println("Update: Product code is not exist");
            return false;
        }
    }


}
