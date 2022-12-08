package com.example.crud2class.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface ICoreCRUDService{
    String add(HttpServletRequest request, HttpServletResponse response);
    String delete(HttpServletRequest request, HttpServletResponse response);
    String update(HttpServletRequest request, HttpServletResponse response);

}
