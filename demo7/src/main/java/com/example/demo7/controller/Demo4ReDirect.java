package com.example.demo7.controller;

import com.example.demo7.model.LoginForm;
import com.example.demo7.service.impl.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class Demo4ReDirect {

    @Autowired
    LoginService loginService;
    public String saveProduct(LoginForm loginForm,
                              RedirectAttributes redirectAttributes) {
//        logger.info("saveProduct called");
        // no need to create and instantiate a ProductForm
        // create Product
        LoginForm loginForm1 = new LoginForm();
        loginForm1.setUserName(loginForm.getUserName());
        loginForm1.setPassword(loginForm.getPassword());

        // add loginForm1

        redirectAttributes.addFlashAttribute("message",
                "The loginForm1 was successfully added.");

        return "list";
    }
}
