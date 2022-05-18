package com.bcopstein.Adaptadores.repositorios;

import java.util.List;

import com.bcopstein.Negocio.entidades.Produto;
import com.bcopstein.Negocio.repositorios.IProdutosRepositorio;

public class ProdutoRepository implements IProdutosRepositorio {

    @Override
    public List<Produto> todos() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean podeVender(int codProd, int qtdade) {
        // TODO Auto-generated method stub
        return false;
    }

}
