package br.com.tcs.exerciciossb.controllers;

import org.springframework.web.bind.annotation.RestController;

import br.com.tcs.exerciciossb.model.entities.Cliente;
import br.com.tcs.exerciciossb.model.repositories.ClienteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/clientes")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente novoCliente(@RequestParam String nome, @RequestParam String cpf) {
        Cliente cliente = new Cliente(nome, cpf);  
        clienteRepository.save(cliente);
        return cliente;  
    }

    //@GetMapping(path = "/cliente/qualquer")
    @GetMapping(path = "/qualquer")
    public Cliente obterCliente() {
        return new Cliente(1, "João", "123.456.789-00");
    }

    @GetMapping("/{id}")
    public Cliente obterClientePorId(@PathVariable int id) {
        return new Cliente(id, "Maria", "123.456.789-00");
    }

    @GetMapping
    public Cliente obterClientePorId2(@RequestParam(name = "id", defaultValue = "1") int id) {
        return new Cliente(id, "André", "124.456.789-00");
    }
}
