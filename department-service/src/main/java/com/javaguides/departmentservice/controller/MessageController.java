package com.javaguides.departmentservice.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RefreshScope
@RestController
public class MessageController {

    /**
     * POST http://localhost:8080/actuator/refresh url is refreshing application.properties from github main branch.
     */

    @Value("${spring.boot.message}")
    private String message;
    @GetMapping("message")
    public String getMessage(){
        return message;
    }
}
