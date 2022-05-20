package com.bcopstein.Negocio.repositorios;

import java.util.List;

import com.bcopstein.Negocio.entidades.ItemCarrinho;

public interface ICalculoImposto {
  Integer calculaImposto(List<ItemCarrinho> produtos);
}
