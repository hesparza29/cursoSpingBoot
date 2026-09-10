package com.platzi.platzi_play.web.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.platzi.platzi_play.domain.service.PlatziPlayAiService;

@RestController 
public class HelloController {
    
    private final String plataform;
    
    private final PlatziPlayAiService aiService;

    public HelloController(@Value("${spring.application.name}") String plataform, PlatziPlayAiService aiService) {
        this.aiService = aiService;
        this.plataform = plataform;
    }
    @GetMapping("/hello")
    public String hello(){
        return this.aiService.genereteGreeting(plataform);
    }
}
