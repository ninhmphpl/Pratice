package com.example.thit_thuc_hanh;

import com.example.thit_thuc_hanh.dao.EmployeeDAO;
import com.example.thit_thuc_hanh.model.EmployeeManager;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ServletManager", value = "/ServletManager")
public class ServletManager extends HttpServlet {
    EmployeeManager employeeManager;

    @Override
    public void init() throws ServletException {
        employeeManager  = new EmployeeManager();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        employeeManager.display(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action == null) action = "";
        switch (action){
            case "add" :
                employeeManager.addEmployee(request,response);
                break;
            case "update":
                employeeManager.updateEmployee(request,response);
                break;
            case "delete":
                employeeManager.deleteEmployee(request,response);
                break;
            case "updatePage":
                String id = request.getParameter("id");
                request.setAttribute("department", new EmployeeDAO().findAllDepartment());
                request.setAttribute("employee",new EmployeeDAO().find(Integer.parseInt(id)));
                request.getRequestDispatcher("update.jsp").forward(request,response);
                break;
            case "search":
                String string= request.getParameter("string");
                request.setAttribute("employee",new EmployeeDAO().findEmployeeByName(string));
                request.setAttribute("department", new EmployeeDAO().findAllDepartment());
                request.getRequestDispatcher("index.jsp").forward(request,response);
                break;
            default:
                response.sendRedirect("ServletManager");
        }

    }

}
