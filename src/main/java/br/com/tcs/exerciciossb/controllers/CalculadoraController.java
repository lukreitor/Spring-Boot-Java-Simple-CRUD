package br.com.tcs.exerciciossb.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/calculadora")
public class CalculadoraController {
    // http://localhost:8080/calculadora/somar/10/20
    @GetMapping("/somar/{n1}/{n2}")
    public int somar(@PathVariable int n1, @PathVariable int n2) {
        return n1 + n2;
    }

    // http://localhost:8080/calculadora/subtrair?n1=10&n2=20
   @GetMapping("/subtrair")
    public int subtrair(@RequestParam(name = "n1") int n1, @RequestParam(name = "n2") int n2) {
        return n1 - n2;
    }
}
