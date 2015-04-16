/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RegraDeNegocio;

/**
 *
 * @author Thales Tiago
 */
import Persistencia.RepCliente;
import Entidades.Cliente;
import Excecoes.ExceptionClienteJaCadastrado;
import Excecoes.ExceptionClienteNaoCadastrado;

public class Controlador_Cliente {

    private RepCliente clientes;

    public Controlador_Cliente() {
        this.clientes = new RepCliente();
    }

    public void cadastrarCliente(Cliente cliente) throws ExceptionClienteJaCadastrado {

        if (cliente.getNomeCliente() == null) {
            clientes.saveCliente(cliente);
        } else {
            throw new ExceptionClienteJaCadastrado();
        }
    }

    public void atualizarCliente(Cliente cliente)
            throws ExceptionClienteNaoCadastrado {
        //VERIFICAR ESSAS COMARAÇÕES PARA VER SE TÁ CORRETO
        if (cliente.getCpfCnpjCliente() == cliente.getCodCliente()) {
            clientes.updateCliente(cliente);
        } else {
            throw new ExceptionClienteNaoCadastrado();
        }
    }

    public void descadastrarCliente(Cliente cliente)
            throws ExceptionClienteNaoCadastrado {
        //fazer essa comparação
        try {
            clientes.deleteCliente(cliente);
        } catch (Exception e) {
            throw new ExceptionClienteNaoCadastrado();
        }
    }

    public Cliente recuperarCliente(Cliente cliente)
            throws ExceptionClienteNaoCadastrado {

        //VERIFICAR ESSAS COMARAÇÕES PARA VER SE TÁ CORRETO
        if (cliente.getNomeCliente().equals(cliente.getCodCliente())) {
            cliente = this.clientes.searchClientePorCpf(cliente);
        } else {
            throw new ExceptionClienteNaoCadastrado();
        }

        return cliente;
    }
}
