package com.xeven.sistemaventas.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello") //ruta hhtp esta siguiendo
public class HelloController {

    @GetMapping
    public String helloWorld() {
        return "hola voy a salir adelante porq me lo merezco";
    }
}
