package com.example.demo7.config;

import com.example.demo7.service.CustomerService;
import com.example.demo7.service.impl.LoginService;
import com.example.demo7.service.impl.SimpleCustomerServiceImpl;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;


@Configuration
@EnableWebMvc
@ComponentScan("com.example.demo7")
public class ApplicationConfig implements WebMvcConfigurer, ApplicationContextAware {
    @Bean
    public LoginService loginService(){
        return new LoginService();
    }
//    @Bean
//    public CustomerService customerService(){
//        return new SimpleCustomerServiceImpl();
//    }

    @Bean
    public ViewResolver viewResolver(){
        InternalResourceViewResolver bean = new InternalResourceViewResolver();
        bean.setViewClass(JstlView.class);
        bean.setPrefix("/customers/");
        bean.setSuffix(".jsp");
        return bean;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {

    }
}
