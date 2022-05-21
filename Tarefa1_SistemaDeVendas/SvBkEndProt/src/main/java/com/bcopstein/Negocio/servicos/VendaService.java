package com.bcopstein.Negocio.servicos;

import java.util.List;

import com.bcopstein.Negocio.repositorios.ICalculoImposto;
import com.bcopstein.Negocio.entidades.ItemCarrinho;
import com.bcopstein.Negocio.entidades.ItemEstoque;
import com.bcopstein.Negocio.entidades.Venda;
import com.bcopstein.Negocio.repositorios.IVendaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class VendaService {
  private IVendaRepository vendaRepository;
  private ICalculoImposto calculoImposto;
  private ServicoEstoque servicoEstoque;

  @Autowired
  public VendaService(IVendaRepository vendaRepository, ICalculoImposto calculoImposto, ServicoEstoque servicoEstoque) {
    this.vendaRepository = vendaRepository;
    this.calculoImposto = calculoImposto;
    this.servicoEstoque = servicoEstoque;
  }

  public boolean cadastraVenda(Venda novaVenda) {
    // TODO: Ver isso aqui (Horario) !!!
    // IRestricaoHorarioVenda restricaoVenda = RestricaoVendaFactory.getInstance(LocalTime.now());
    // boolean vendaIsValida = restricaoVenda.vendaIsValida(novaVenda);

    // if (!vendaIsValida) {
    //   return false;
    // }

    List<ItemCarrinho> produtos = novaVenda.getItensCarrinho();

    for (ItemCarrinho produto : produtos) {
      boolean podeVender = servicoEstoque.podeVender(produto.getCodProduto(), produto.getQuantidade());

      if (!podeVender) {
        return false;
      }
    }

    for (ItemCarrinho produto : produtos) {
      ItemEstoque itemEstoque = servicoEstoque.getProduto(produto.getCodProduto());
      itemEstoque.setQuantidade(itemEstoque.getQuantidade() - produto.getQuantidade());
      servicoEstoque.atualizaProduto(itemEstoque);
    }

    this.vendaRepository.cadastra(novaVenda);

    return true;
  }

  public Integer[] consultaVenda(List<ItemCarrinho> itens) {
    Integer subtotal = 0;
    Integer imposto = 0;

    for (final ItemCarrinho prod : itens) {
      if (prod != null) {
        subtotal += (int) prod.getPrecoProd() * prod.getQuantidade();
      } else {
        throw new IllegalArgumentException("Codigo invalido");
      }
    }

    imposto = calculoImposto.calculaImposto(itens);

    final Integer[] resp = new Integer[4];

    resp[0] = subtotal;
    resp[1] = imposto;
    resp[2] = subtotal + imposto;
    resp[3] = 0; // frete
    

    return resp;
  }

  public List<Venda> todos() {
    return vendaRepository.todos();
  }
}
