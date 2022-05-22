package com.bcopstein.Negocio.servicos;

import com.bcopstein.Negocio.entidades.ItemEstoque;
import com.bcopstein.Negocio.entidades.Produto;
import com.bcopstein.Negocio.repositorios.IEstoqueRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

public class ServicoEstoqueTest {

    @InjectMocks
    private ServicoEstoque servicoEstoque;

    @Mock
    private IEstoqueRepository estoqueRepository;

    private ItemEstoque itemEstoque;


    @BeforeEach
    public void setup(){
        MockitoAnnotations.initMocks(this);
        Produto produto = new Produto(1, "Produto 1", 45.0);
        itemEstoque = new ItemEstoque(1, produto, 5);
    }

    @Test
    public void returnTrueCanSell(){
        // GIVEN
        int codProduto = 1;
        int quantidade = 5;

        // WHEN
        when(estoqueRepository.getProduto(codProduto)).thenReturn(itemEstoque);

        // THEN
        Assertions.assertTrue(servicoEstoque.podeVender(codProduto,quantidade));
    }

    @Test
    public void returnFalseCanNotSellWithLargerQuantity(){
        // GIVEN
        int codProduto = 1;
        int quantidade = 6;

        // WHEN
        when(estoqueRepository.getProduto(codProduto)).thenReturn(itemEstoque);

        // THEN
        Assertions.assertFalse(servicoEstoque.podeVender(codProduto,quantidade));
    }

    @Test
    public void mustUpdateProduto(){
        // TODO: VER
        servicoEstoque.atualizaProduto(itemEstoque);
    }

    @Test
    public void mustReturnItemEstoqueByCodProduto(){
        // GIVEN
        int codProduto = 1;

        // WHEN
        when(estoqueRepository.getProduto(codProduto)).thenReturn(itemEstoque);

        // THEN
        assertEquals(itemEstoque, servicoEstoque.getProduto(codProduto));
    }
}