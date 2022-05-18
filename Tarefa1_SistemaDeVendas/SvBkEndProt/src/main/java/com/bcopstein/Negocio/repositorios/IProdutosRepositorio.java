package com.bcopstein.Negocio.repositorios;

import java.util.List;

import com.bcopstein.Negocio.entidades.Produto;

public interface IProdutosRepositorio {
    List<Produto> todos();
    boolean podeVender(int codProd, int qtdade);
}