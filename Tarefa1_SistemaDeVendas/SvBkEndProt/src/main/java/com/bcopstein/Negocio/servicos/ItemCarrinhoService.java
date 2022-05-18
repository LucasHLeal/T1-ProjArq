package com.bcopstein.Negocio.servicos;

import java.util.List;

import com.bcopstein.Negocio.entidades.ItemCarrinho;
import com.bcopstein.Negocio.repositorios.IItemCarrinhoRepositorio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ItemCarrinhoService {
    private IItemCarrinhoRepositorio repo;

    @Autowired
    public ItemCarrinhoService(IItemCarrinhoRepositorio repo) {
        this.repo = repo;
    }

    List<ItemCarrinho> todos() {
        return repo.todos();
    }

    boolean confirmaVenda(ItemCarrinho[] itens) {
        return true;
    }
}
