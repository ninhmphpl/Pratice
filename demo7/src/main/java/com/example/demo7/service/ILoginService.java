package com.example.demo7.service;

import com.example.demo7.model.LoginForm;

import java.util.List;

public interface ILoginService {
    List<LoginForm> findAll();
}
