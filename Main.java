package com.henningSB412;


import com.henningSB412.entity.Student;
import com.henningSB412.service.StudentService;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import static com.sun.javafx.fxml.expression.Expression.equalTo;

@SpringBootApplication
public class Main {

    @Bean
    public RestTemplate getResttemplate() {
        return new RestTemplate();
    }

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
        System.out.println("system gestartet");

    }
}
