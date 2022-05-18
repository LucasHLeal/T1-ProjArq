package com.bcopstein.Negocio.servicos;

import java.util.List;

import com.bcopstein.Negocio.entidades.Venda;
import com.bcopstein.Negocio.repositorios.IVendasRepositorio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class VendaService {
    private IVendasRepositorio repo;

    @Autowired
    public VendaService(IVendasRepositorio repo) {
        this.repo = repo;
    }

    public List<Venda> todos() {
        return repo.todos();
    }
    
}
