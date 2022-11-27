package com.example.webcrud;

import com.example.webcrud.data.Data;
import com.example.webcrud.data.Product;
import com.example.webcrud.data.ProductCRUD;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "ServletCURD", value = "/ServletCURD")
public class ServletCURD extends HttpServlet {
    private ProductCRUD productCRUD;
    private Data data;

    @Override
    public void init(){
        data = new Data();
        productCRUD = new ProductCRUD(data);
        System.out.println(productCRUD.add("iphone", "1234", "comment"));
        System.out.println(productCRUD.add("iphone1", "1234", "comment"));
        System.out.println(productCRUD.add("iphone2", "1234", "comment"));
        System.out.println(productCRUD.add("iphone3", "1234", "comment"));
    }
    private void display(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Product> list = new ArrayList<>(data.getProducts().values());
        request.setAttribute("product", list);
        RequestDispatcher a = request.getRequestDispatcher("product.jsp");
        a.forward(request,response);
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        display(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action == null){
            display(request,response);
            System.out.println("Action is null");
            return;
        }
        String productCode = request.getParameter("productCode");
        String name = request.getParameter("name");
        String price = request.getParameter("price");
        String description = request.getParameter("description");
        boolean ac;
        switch (action) {
            case "add" -> {
                ac = productCRUD.add(name, price, description);
                System.out.println("Add: " + ac);
            }
            case "update" -> {
                ac = productCRUD.update(productCode, name, price, description);
                System.out.println("Update: " + ac);
            }
            case "delete" -> {
                ac = productCRUD.delete(productCode);
                System.out.println("Delete: " + ac);
            }
            default -> System.out.println("Cant read action");
        }
        display(request,response);
    }
}

