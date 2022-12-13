package com.example.demo7.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class Demo3VarURI {
    @GetMapping(value = "/helloWord/{id}-{name}")
    public String getValue(@PathVariable Long id,@PathVariable String name){
        System.out.println(id);
        System.out.println(name);
        return "list";
    }
    @GetMapping(value = "/value/{name:[a-z-]+}-{seri:\\d.\\d.\\d}{etx:\\.[a-z]+}")
    public String getValue(@PathVariable String name, @PathVariable String seri, @PathVariable String etx){
        return "list";
    }
}
