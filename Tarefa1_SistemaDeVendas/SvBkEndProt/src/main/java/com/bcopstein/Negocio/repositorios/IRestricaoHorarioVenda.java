package com.bcopstein.Negocio.repositorios;

import com.bcopstein.Negocio.entidades.Venda;

public interface IRestricaoHorarioVenda {
  public boolean vendaIsValida(Venda venda);
}
