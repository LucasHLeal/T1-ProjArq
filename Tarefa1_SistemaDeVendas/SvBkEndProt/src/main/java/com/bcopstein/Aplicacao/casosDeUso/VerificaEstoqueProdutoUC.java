package com.bcopstein.Aplicacao.casosDeUso;

import com.bcopstein.Negocio.servicos.ServicoEstoque;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class VerificaEstoqueProdutoUC {
  private ServicoEstoque servicoEstoque;

  @Autowired
  public VerificaEstoqueProdutoUC(ServicoEstoque servicoEstoque) {
    this.servicoEstoque = servicoEstoque;
  }

  public boolean executar(int codProduto, int quantidade) {
    return servicoEstoque.podeVender(codProduto, quantidade);
  }
}
