package com.example.demo7.controller;

import com.example.demo7.model.Customer;
import com.example.demo7.service.CustomerService;
import com.example.demo7.service.impl.SimpleCustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
@Controller
public class CustomerController {
    @Autowired
    private SimpleCustomerServiceImpl simpleCustomerService;

    @GetMapping("/customers")
    public String showList(Model model) {
        List<Customer> customers = simpleCustomerService.findAll();
        model.addAttribute("customers", customers);
        return "list";
    }

    @PostMapping ("/showList")
    public String showList2(@RequestParam String id, String name, String email, String address, Model model){
        Customer customer = new Customer(name,email,address);
        Long iid = Long.valueOf(id);
        customer.setId(iid);
        simpleCustomerService.save(customer);
        model.addAttribute("customers",simpleCustomerService.findAll());
        return "list";
    }
}