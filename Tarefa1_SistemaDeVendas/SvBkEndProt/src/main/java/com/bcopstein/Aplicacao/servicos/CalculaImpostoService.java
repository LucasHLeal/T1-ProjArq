package com.bcopstein.Aplicacao.servicos;

import java.util.List;

import com.bcopstein.Negocio.entidades.ItemCarrinho;
import com.bcopstein.Negocio.servicos.ICalculoImposto;

import org.springframework.stereotype.Component;

@Component
public class CalculaImpostoService implements ICalculoImposto{

    @Override
    public Integer calculaImposto(List<ItemCarrinho> produtos) {
        return 0;
    }
    
}
