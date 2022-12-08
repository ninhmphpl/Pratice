package com.example.crud2class.controller;

import com.example.crud2class.model.Product;
import com.example.crud2class.service.ICategoryService;
import com.example.crud2class.service.IProductService;
import com.example.crud2class.service.impl.CategoryService;
import com.example.crud2class.service.impl.ProductService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ServletProduct", value = "/products")
public class ServletProduct extends HttpServlet {
    private IProductService products;
    @Override
    public void init() throws ServletException {
        products = new ProductService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("list", products.getAll());
        request.setAttribute("listCategory", products.getCategories().getCategory());
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/list-product.jsp");
        requestDispatcher.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) action="";
        String active;
        switch (action){
            case "add":
                active = products.add(request,response);
                System.out.println(active);
                break;
            case "update":
                active = products.update(request,response);
                System.out.println(active);
                break;
            case "delete":
                active = products.delete(request,response);
                System.out.println(active);
                break;
            case "categoryAdd":
                active = products.getCategories().add(request,response);
                System.out.println(active);
                break;
            case "categoryDelete":
                active = products.getCategories().delete(request,response);
                System.out.println(active);
                break;
            case "categoryUpdate":
                active = products.getCategories().update(request,response);
                System.out.println(active);
                break;
        }
        response.sendRedirect("products");
    }

}
