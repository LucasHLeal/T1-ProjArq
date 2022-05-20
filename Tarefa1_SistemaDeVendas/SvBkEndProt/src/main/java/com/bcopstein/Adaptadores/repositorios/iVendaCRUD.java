package com.bcopstein.Adaptadores.repositorios;

import java.util.List;

import com.bcopstein.Negocio.entidades.Venda;
import com.bcopstein.Negocio.repositorios.IVendaRepository;
import org.springframework.data.repository.CrudRepository;

public interface IVendaCRUD extends CrudRepository<Venda, Integer> {
    List<Venda> findAll();
}
