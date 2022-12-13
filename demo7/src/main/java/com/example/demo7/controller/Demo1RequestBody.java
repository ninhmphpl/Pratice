package com.example.demo7.controller;

import com.example.demo7.model.LoginForm;
import com.example.demo7.model.ResponseTransfer;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Demo1RequestBody {
    @PostMapping(value = "/content", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseTransfer postResponseJsonContent(
            @RequestBody LoginForm loginForm) {
        return new ResponseTransfer("JSON Content!");
    }
}
