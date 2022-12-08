package com.example.crud2class.service.impl;

import com.example.crud2class.model.Product;
import com.example.crud2class.service.ICategoryService;
import com.example.crud2class.service.IProductService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ProductService implements IProductService {
    private final HashMap<Integer,Product> products;
    private final CategoryService categories;
    private int size;

    public ProductService() {
        this.products = new HashMap<>();
        categories = new CategoryService();
        this.size = 2;
        products.put(0,new Product(0, "abc", 1000, "abc"));
        products.put(1,new Product(1, "abc", 1000, "abc"));
        products.put(2,new Product(2, "abc", 1000, "abc"));
    }

    public CategoryService getCategories() {
        return categories;
    }

    @Override
    public String add(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        String price = request.getParameter("price");
        String description = request.getParameter("description");
        String categoryName = request.getParameter("categoryName");
        try{
            int iPrice = Integer.parseInt(price);
            Product product = new Product(++size,name,iPrice,description, categories.findCategory(categoryName));
            products.put(size,product);
        }catch (Exception e){
            return "Add: cant parseInt()";
        }
        return "Add: true";
    }

    @Override
    public String delete(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        try{
            int iId = Integer.parseInt(id);
            products.remove(iId);
        }catch (Exception e){
            return "Delete: cant parseInt()";
        }
        return "Delete: true";
    }

    @Override
    public String update(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String price = request.getParameter("price");
        String description = request.getParameter("description");
        String categoryName = request.getParameter("categoryName");
        try{
            int iId = Integer.parseInt(id);
            int iPrice = Integer.parseInt(price);
            if(products.containsKey(iId)){
                Product product = products.get(iId);
                product.setName(name);
                product.setDescription(description);
                product.setPrice(iPrice);
                product.setCategory(categories.findCategory(categoryName));
            }else{
                return "Add: id's not exist";
            }
        }catch (Exception e){
            return "Add: cant parseInt()";
        }
        return "Add: true";
    }

    @Override
    public List<Product> getAll() {
        return new ArrayList<>(products.values());
    }

}
