package com.bcopstein.Negocio.entidades;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Venda {

    @Id
    int codigo;
    private String venda;

    public Venda(int codigo, String venda) {
        this.codigo = codigo;
        this.venda = venda;
    }

    protected Venda() {}

    public int getCodigo() {
        return codigo;
    }

    public String getVenda() {
        return venda;
    }
}
