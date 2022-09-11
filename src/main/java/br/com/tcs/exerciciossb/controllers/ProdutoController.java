package br.com.tcs.exerciciossb.controllers;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.tcs.exerciciossb.model.entities.Produto;
import br.com.tcs.exerciciossb.model.repositories.ProdutoRepository;

@RestController
@RequestMapping(path = "/api/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoRepository produtoRepository;

    @RequestMapping(path = "/novoProduto", method = {RequestMethod.POST, RequestMethod.PUT})
    public @ResponseBody Produto novoProduto(@Valid Produto produto) { 
        produtoRepository.save(produto);
        return produto;  
    }

    // Consultando todos os produtos
    @GetMapping
    public Iterable<Produto> obterProdutos() {
        return produtoRepository.findAll();
    }

    // obter produtos por nome 
    @GetMapping(path = "/nomeQualquer/{parteNome}")
    public Iterable<Produto> obterProdutosPorNome(@PathVariable String parteNome) {
        return produtoRepository.findByNomeContainingIgnoreCase(parteNome);
    }

     // Consulta Paginada
     @GetMapping(path = "/pagina/{numeroPagina}/{quantidadeRegistros}")
     public Iterable<Produto> obterProdutoPorPagina(@PathVariable int numeroPagina, @PathVariable int quantidadeRegistros) {
        // if quantidadeRegistros > 5, quantidadeRegistros = 5
        quantidadeRegistros = quantidadeRegistros > 5 ? 5 : quantidadeRegistros;
        Pageable page = PageRequest.of(numeroPagina, quantidadeRegistros);
        return produtoRepository.findAll(page); 
     }

    // Atualizar um objeto parcialmente
    @PatchMapping
    public Produto alterarProdutoParcial(@Valid Produto produto) {
        produtoRepository.save(produto);
        return produto;
    }

    // Consultando um produto pelo id
    @GetMapping("/{id}")
    public Optional<Produto> obterProdutoPorId(@PathVariable int id) {
        return produtoRepository.findById(id);
    }

    // Consultando um produto pelo nome
    @GetMapping("/nome/{nome}")
    public Iterable<Produto> obterProdutoPorNome(@PathVariable String nome) {
        return produtoRepository.findByNomeContainingIgnoreCase(nome);
    }

    // searchByNameLike
    @GetMapping("/nomeLike/{parteNome}")
    public Iterable<Produto> obterProdutoPorNomeLike(@PathVariable String parteNome) {
        return produtoRepository.searchByNameLIke(parteNome);
    }

    // Atualizar um objeto inteiro ou parcialmente
    //@PutMapping
    //public Produto alterarProduto(@Valid Produto produto) {
    //    produtoRepository.save(produto);
    //    return produto;
    //}

    

    // Deletar um produto
    @DeleteMapping(path="/delete/{id}")
    public void deletarProduto(@PathVariable int id) {
        produtoRepository.deleteById(id);
    }

   
}

// validation api - javax.validation
// https://www.baeldung.com/javax-validation