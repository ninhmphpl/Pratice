package com.example.crud2class.service;

import com.example.crud2class.model.Category;

import java.util.List;

public interface ICategoryService extends ICoreCRUDService{
    List<Category> getCategory();
    Category getCategory(Integer index);

}
