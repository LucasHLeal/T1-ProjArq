package com.bcopstein.Adaptadores.repositorios;

import java.util.List;

import com.bcopstein.Negocio.entidades.Venda;
import com.bcopstein.Negocio.repositorios.IVendaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class VendaRepository implements IVendaRepository {
    VendaCrud vendaCRUD;

    @Autowired
    public VendaRepository(VendaCrud vendaCRUD){
        this.vendaCRUD = vendaCRUD;
    }

    @Override
    public List<Venda> todos() {
        return vendaCRUD.findAll();
    }
}
