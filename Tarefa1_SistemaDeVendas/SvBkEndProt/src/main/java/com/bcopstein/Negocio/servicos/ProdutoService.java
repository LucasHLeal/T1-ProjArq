package com.bcopstein.Negocio.servicos;

import java.util.List;

import com.bcopstein.Negocio.entidades.Produto;

import com.bcopstein.Negocio.repositorios.IProdutosRepositorio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProdutoService {
    private IProdutosRepositorio repo;

    @Autowired
    public ProdutoService(IProdutosRepositorio repo) {
        this.repo = repo;
    }

    public List<Produto> todos(){
        return repo.todos();
    }
    
    
}
