/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RegraDeNegocio;

import Entidades.Venda;
import Excecoes.ExceptionVendaNaoCadastrado;
import persistencia.RepVenda;

/**
 *
 * @author Thales Tiago
 */
public class Controlador_Venda {

    private RepVenda vendas;

    public Controlador_Venda() {
        this.vendas = new RepVenda();
    }

    /**
     *
     * @param venda
     */
    public void cadastrarVenda(Venda venda) throws ExceptionVendaNaoCadastrado {

        if (vendas.searchVenda(venda) == null) {
            vendas.saveVenda(venda);
        } else {

            throw new ExceptionVendaNaoCadastrado();
        }
    }

    public void atualizarVenda(Venda venda)
            throws ExceptionVendaNaoCadastrado {
        //VERIFICAR ESSAS COMARAÇÕES PARA VER SE TÁ CORRETO
        if (vendas.searchVenda(venda).equals(venda.getCodVenda())) {
            vendas.updateVenda(venda);
        } else {
            throw new ExceptionVendaNaoCadastrado();
        }
    }

    public void descadastrarVenda(Venda venda)
            throws ExceptionVendaNaoCadastrado {
        //VERIFICAR ESSAS COMARAÇÕES PARA VER SE TÁ CORRETO O ".EQUALS" NO FIM
        try {
            vendas.deleteVenda(venda);
        } catch (Exception e) {
            throw new ExceptionVendaNaoCadastrado();
        }
    }

    public Venda recuperarCliente(Venda venda)
            throws ExceptionVendaNaoCadastrado {

        //VERIFICAR ESSAS COMARAÇÕES PARA VER SE TÁ CORRETO
        if (venda.getProdutoVendas().equals(venda.getCodVenda())) {
            venda = this.vendas.searchVenda(venda);
        } else {
            throw new ExceptionVendaNaoCadastrado();
        }

        return venda;
    }
}
