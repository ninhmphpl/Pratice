package com.example.demo7.service.impl;

import com.example.demo7.model.LoginForm;
import com.example.demo7.service.ILoginService;

import java.util.ArrayList;
import java.util.List;

public class LoginService implements ILoginService {
    static private final List<LoginForm> loginForm;
    static {
        loginForm = new ArrayList<>();
    }
    @Override
    public List<LoginForm> findAll() {
        return loginForm;
    }
}
