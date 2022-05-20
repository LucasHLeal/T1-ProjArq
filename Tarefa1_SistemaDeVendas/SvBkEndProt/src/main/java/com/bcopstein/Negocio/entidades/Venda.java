package com.bcopstein.Negocio.entidades;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Venda {

    @Id
    int codigo;
    private String venda;
    @OneToMany(mappedBy = "venda",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<ItemCarrinho> itensCarrinho;

    public Venda(int codigo, String venda, List<ItemCarrinho> itensCarrinho) {
        this.codigo = codigo;
        this.venda = venda;
        this.itensCarrinho = itensCarrinho;
    }

    protected Venda() {}

    public int getCodigo() {
        return codigo;
    }

    public String getVenda() {
        return venda;
    }

    public List<ItemCarrinho> getItensCarrinho() {
        return itensCarrinho;
    }
}
