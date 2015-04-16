/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RegraDeNegocio;

import Entidades.Cliente;
import Entidades.Produto;
import Entidades.Venda;
import Excecoes.ExceptionClienteJaCadastrado;
import Excecoes.ExceptionClienteNaoCadastrado;
import Excecoes.ExceptionProdutoNaoCadastrado;
import Excecoes.ExceptionVendaNaoCadastrado;

/**
 *
 * @author Admin
 */
public class Fachada {

    private Controlador_Cliente controlador_Cliente;
    private Controlador_Produto controlador_Produto;
    private Controlador_Venda controlador_Venda;
    private static Fachada fachada;

    private Fachada() {
        this.controlador_Cliente = new Controlador_Cliente();
        this.controlador_Produto = new Controlador_Produto();
        this.controlador_Venda = new Controlador_Venda();
    }

    public static Fachada getFachada() {
        if (fachada == null) {
            fachada = new Fachada();
        }
        return fachada;
    }

    
    public Controlador_Cliente getControladorCliente() {
        return this.controlador_Cliente;
    }
    
    public Controlador_Produto getControladorProduto() {
        return this.controlador_Produto;
    }
    
    public Controlador_Venda getControladorVenda() {
        return this.controlador_Venda;
    }
    
}
