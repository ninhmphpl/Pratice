package com.example.demo10.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.TimeZone;

@Controller
public class TimeController {

    @GetMapping("/world-clock")
    public String getTimeByTimezone(ModelMap model, @RequestParam(name = "city", required = false, defaultValue = "Asia/Ho_Chi_Minh") String city) {
        Date date = new Date();// Lấy ra thời gian hiện tại
        TimeZone local = TimeZone.getDefault();// Lấy ra time zone hiện tại
        TimeZone locale = TimeZone.getTimeZone(city);// Lấy ra time zone của 1 thành phố cụ thể
        long locale_time = date.getTime() + (locale.getRawOffset() - local.getRawOffset());// Tính thời gian hiện tại của một thành phố cụ thể
        date.setTime(locale_time);// Cài đặt lại thời gian cho biến date thành thời gian hiện tại của 1 thành phố cụ thể
        model.addAttribute("city", city);
        model.addAttribute("date", date);
        return "index";
    }
    @RequestMapping("/")
    public String home(){
        return "index";
    }
}