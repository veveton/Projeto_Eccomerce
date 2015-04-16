package Entidades;
// Generated 07/04/2015 21:25:37 by Hibernate Tools 4.3.1



/**
 * EnderecoCliente generated by hbm2java
 */
public class EnderecoCliente  implements java.io.Serializable {


     private EnderecoClienteId id;
     private Cliente cliente;
     private String cidade;
     private String logradouro;
     private int numero;

    public EnderecoCliente() {
    }

    public EnderecoCliente(EnderecoClienteId id, Cliente cliente, String cidade, String logradouro, int numero) {
       this.id = id;
       this.cliente = cliente;
       this.cidade = cidade;
       this.logradouro = logradouro;
       this.numero = numero;
    }
   
    public EnderecoClienteId getId() {
        return this.id;
    }
    
    public void setId(EnderecoClienteId id) {
        this.id = id;
    }
    public Cliente getCliente() {
        return this.cliente;
    }
    
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    public String getCidade() {
        return this.cidade;
    }
    
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
    public String getLogradouro() {
        return this.logradouro;
    }
    
    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }
    public int getNumero() {
        return this.numero;
    }
    
    public void setNumero(int numero) {
        this.numero = numero;
    }




}


