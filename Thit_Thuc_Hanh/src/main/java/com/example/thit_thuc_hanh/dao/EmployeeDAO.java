package com.example.thit_thuc_hanh.dao;

import com.example.thit_thuc_hanh.model.Department;
import com.example.thit_thuc_hanh.model.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {
    private static String url = "jdbc:mysql://localhost:3306/mangage?useSSL=false";
    private static String username = "root";
    private static String password = "12345678";
    private static Connection connection;

    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public void addEmployee(Employee employee) throws SQLException {
        try (PreparedStatement preparedStatement = getConnection().prepareStatement("insert into employee(name, email, address, phone_number,salary, department_id) values (?, ? ,?, ?, ?, ?);")) {
            preparedStatement.setString(1, employee.getName());
            preparedStatement.setString(2, employee.getEmail());
            preparedStatement.setString(3, employee.getAddress());
            preparedStatement.setString(4, employee.getPhoneNumber());
            preparedStatement.setDouble(5, employee.getSalary());
            preparedStatement.setInt(6, employee.getDepartment().getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean updateUser(Employee employee, int id) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement("update employee set name = ?,email= ?, address =?, phone_number =?,salary = ?, department_id = ?   where id = ?;");) {
            statement.setString(1, employee.getName());
            statement.setString(2, employee.getEmail());
            statement.setString(3, employee.getAddress());
            statement.setString(4, employee.getPhoneNumber());
            statement.setDouble(5, employee.getSalary());
            statement.setInt(6, employee.getDepartment().getId());
            statement.setInt(7, id);

            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }

    public boolean deleteEmployee(int id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement("delete from employee where id =  ?");) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    public List<Employee> findAllEmployee() {
        List<Employee> users = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("select * from employee");) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String address = rs.getString("address");
                String phone_number = rs.getString("phone_number");
                double salary = rs.getDouble("salary");
                int department_id = rs.getInt("department_id");

                users.add(new Employee(id,name,email,address,phone_number,salary,findDepartmentById(department_id)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    public List<Employee> findEmployeeByName(String search) {
        List<Employee> users = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("select * from employee where name like concat('%',?,'%');") ){
            preparedStatement.setString(1, search);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String address = rs.getString("address");
                String phone_number = rs.getString("phone_number");
                double salary = rs.getDouble("salary");
                int department_id = rs.getInt("department_id");

                users.add(new Employee(id,name,email,address,phone_number,salary,findAllDepartment().get(department_id)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    public Employee find(int index){
        Employee employee = null;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("select * from employee where id = ?");) {
            preparedStatement.setInt(1,index);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String address = rs.getString("address");
                String phone_number = rs.getString("phone_number");
                double salary = rs.getDouble("salary");
                int department_id = rs.getInt("department_id");

                employee = new Employee(id,name,email,address,phone_number,salary,findAllDepartment().get(department_id));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employee;
    }
    public List<Department> findAllDepartment(){
        List<Department> departments = new ArrayList<>();
        try(PreparedStatement pre = getConnection().prepareStatement("select * from department")) {
            ResultSet rs = pre.executeQuery();
            while (rs.next()){
                int id = rs.getInt("id");
                String department = rs.getString("department");
                departments.add(new Department(id,department));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return departments;
    }
    public Department findDepartmentById(int index){
        Department departments = null;
        try(PreparedStatement pre = getConnection().prepareStatement("select * from department where id = ?")) {
            pre.setInt(1, index);
            ResultSet rs = pre.executeQuery();
            while (rs.next()){
                int id = rs.getInt("id");
                String department = rs.getString("department");
                departments = new Department(id,department);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return departments;
    }



}
