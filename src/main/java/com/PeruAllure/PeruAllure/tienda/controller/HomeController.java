package com.peruallure.peruallure.tienda.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HomeController {

    @GetMapping
    public String home() {
        return "Welcome to PeruAllure API! Available endpoints: "
                + "<br> - <a href='/api/administradores'>Administradores</a>"
                + "<br> - <a href='/api/auth/login'>Login</a>"
                + "<br> - <a href='/api/csrf'>CSRF Token</a>";
    }
}
