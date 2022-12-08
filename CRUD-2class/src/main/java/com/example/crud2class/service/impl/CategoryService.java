package com.example.crud2class.service.impl;

import com.example.crud2class.model.Category;
import com.example.crud2class.service.ICategoryService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

public class CategoryService implements ICategoryService {
    private final ArrayList<Category> categories;

    public CategoryService() {
        this.categories = new ArrayList<>();
        categories.add(new Category("Phone"));
        categories.add(new Category("Laptop"));
        categories.add(new Category("Pc"));
    }
    public Category findCategory(String name){
        for (Category c : categories){
            if(c.getName().equals(name)){
                return c;
            }
        }
        return null;
    }

    @Override
    public List<Category> getCategory() {
        return categories;
    }

    @Override
    public Category getCategory(Integer index) {
        return categories.get(index);
    }

    @Override
    public String add(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("categoryName");
        categories.add(new Category(name));
        return "Add: true";
    }

    @Override
    public String delete(HttpServletRequest request, HttpServletResponse response) {
        String categoryName = request.getParameter("categoryName");
        if(categoryName == null){
            return "Delete: name is null";
        }
        Category c = findCategory(categoryName);
        try{
            if(c != null){
                categories.remove(c);
            }else{
                return "Delete: index is not exist";
            }
        }catch(Exception e){
            return "Delete: cant parseInt";
        }
        return "Delete: true";
    }

    @Override
    public String update(HttpServletRequest request, HttpServletResponse response) {
        String categoryName = request.getParameter("categoryName");
        if(categoryName == null){
            return "Delete: name is null";
        }
        Category c = findCategory(categoryName);
        try{
            if(c != null){
                c.setName(categoryName);
            }else{
                return "Update: index is not exist";
            }
        }catch(Exception e){
            return "Update: cant parseInt";
        }
        return "Update: true";
    }
}
