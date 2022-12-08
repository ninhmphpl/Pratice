package com.example.thit_thuc_hanh.model;

import com.example.thit_thuc_hanh.dao.EmployeeDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class EmployeeManager {
    public void addEmployee(HttpServletRequest request, HttpServletResponse response) {
        EmployeeDAO employeeDAO = new EmployeeDAO();
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        String phoneNumber = request.getParameter("phoneNumber");
        String salary = request.getParameter("salary");
        String department = request.getParameter("department");

        Employee employee = new Employee(0, name,email,address,phoneNumber,Double.parseDouble(salary),employeeDAO.findDepartmentById(Integer.parseInt(department)));
        try {
            employeeDAO.addEmployee(employee);
            response.sendRedirect("ServletManager");
        } catch (SQLException | IOException e) {
            throw new RuntimeException(e);
        }

    }

    public void deleteEmployee(HttpServletRequest request, HttpServletResponse response){
        String id = request.getParameter("id");
        EmployeeDAO employeeDAO = new EmployeeDAO();
        try {
            employeeDAO.deleteEmployee(Integer.parseInt(id));
            response.sendRedirect("ServletManager");
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }

    public void updateEmployee(HttpServletRequest request, HttpServletResponse response) {
        EmployeeDAO employeeDAO = new EmployeeDAO();
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        String phoneNumber = request.getParameter("phoneNumber");
        String salary = request.getParameter("salary");
        String department = request.getParameter("department");
        Employee employee = new Employee(0, name,email,address,phoneNumber,Double.parseDouble(salary),employeeDAO.findDepartmentById(Integer.parseInt(department)));
        try {
            employeeDAO.updateUser(employee, Integer.parseInt(id));
            response.sendRedirect("ServletManager");
        } catch (SQLException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void display(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("employee", new EmployeeDAO().findAllEmployee());
        request.setAttribute("department", new EmployeeDAO().findAllDepartment());
        request.getRequestDispatcher("index.jsp").forward(request,response);
    }
}
