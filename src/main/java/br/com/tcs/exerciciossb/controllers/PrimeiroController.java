package br.com.tcs.exerciciossb.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PrimeiroController {

    @GetMapping(path = {"/ola", "/", "/saudacao"})
    public String ola() {
        return "Olá, Spring Boot!";
    }

    @GetMapping(path = "/saudacao2")
    public String saudacao() {
        return "Saudação Spring Boot!";
    }
}
