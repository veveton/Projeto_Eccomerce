/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RegraDeNegocio;

import Entidades.Produto;
import Excecoes.ExceptionProdutoNaoCadastrado;
import persistencia.RepProduto;

/**
 *
 * @author Thales Tiago
 */
public class Controlador_Produto {

    private RepProduto produtos;

    public Controlador_Produto() {
        this.produtos = new RepProduto();
    }

    public void cadastrarProduto(Produto produto) throws ExceptionProdutoNaoCadastrado {

        if (produtos.searchProduto(produto) == null) {
            produtos.saveProduto(produto);
        } else {
        }
        throw new ExceptionProdutoNaoCadastrado();

    }

    public void atualizarProduto(Produto produto)
            throws ExceptionProdutoNaoCadastrado {
        //VERIFICAR ESSAS COMARAÇÕES PARA VER SE TÁ CORRETO
        if (produtos.searchProduto(produto).equals(produto.getCodProduto())) {
            produtos.updateProduto(produto);
        } else {
            throw new ExceptionProdutoNaoCadastrado();
        }
    }

    public void descadastrarProduto(Produto produto)
            throws ExceptionProdutoNaoCadastrado {
        
        try{
            produtos.deleteProduto(produto);
        }catch(Exception e){
            throw new ExceptionProdutoNaoCadastrado();
        }
    }
    public Produto recuperarCliente(Produto produto)
            throws ExceptionProdutoNaoCadastrado {

        //VERIFICAR ESSAS COMARAÇÕES PARA VER SE TÁ CORRETO
        if (produto.getNomeProduto().equals(produto.getCodProduto())) {
            produto = this.produtos.searchProduto(produto);
        } else {
            throw new ExceptionProdutoNaoCadastrado();
        }

        return produto;
    }
}
