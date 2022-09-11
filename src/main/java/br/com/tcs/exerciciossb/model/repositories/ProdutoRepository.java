package br.com.tcs.exerciciossb.model.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import br.com.tcs.exerciciossb.model.entities.Produto;

public interface ProdutoRepository extends PagingAndSortingRepository<Produto, Integer>{
    
    public Iterable<Produto> findByNomeContainingIgnoreCase(String parteNome);

    //findByNomeContainingIgnoreCase
    //findByNomeContaining
    //fingByNomeIsContaining
    //FingByNomeContains

    //findByNomeStartingWith
    //findByNomeEndingWith

    //findByNomeNotContaining

    @Query("select p from Produto p where p.nome like %:parteNome%")
    public Iterable<Produto> searchByNameLIke(@Param("parteNome") String parteNome);
}


