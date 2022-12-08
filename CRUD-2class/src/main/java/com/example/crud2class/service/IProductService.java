package com.example.crud2class.service;

import com.example.crud2class.model.Product;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public interface IProductService extends ICoreCRUDService {
    String add(HttpServletRequest request, HttpServletResponse response);

    List<Product> getAll();
    public ICategoryService getCategories();
}
