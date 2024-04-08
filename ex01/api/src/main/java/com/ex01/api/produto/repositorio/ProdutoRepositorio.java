package com.ex01.api.produto.repositorio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ex01.api.produto.entidade.Produto;


@Repository
public interface ProdutoRepositorio extends CrudRepository<Produto, Long>{

    
}