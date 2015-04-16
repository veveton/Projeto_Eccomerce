/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

/**
 *
 * @author Felipe
 */
import java.util.List;
import org.hibernate.Hibernate;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import HibernateUtil.NewHibernateUtil;
import Entidades.Cliente;

/**
 *
 * @author Thales Tiago
 */
public class RepCliente {

    SessionFactory factory = NewHibernateUtil.getSessionFactory();

    /**
     * Método para cadastro cliente no banco de dados.
     *
     * @param a
     */
    public void saveCliente(Cliente a) {
        Session session;
        session = factory.openSession();
        Transaction trans = session.beginTransaction();
        trans.begin();

        session.save(a);

        trans.commit();
        session.close();
    }

    /**
     * Método para atualizar cliente no banco de dados.
     *
     *
     * @param a
     */
    public void updateCliente(Cliente a) {
        Session session = factory.openSession();
        Transaction trans = session.beginTransaction();
        trans.begin();

        session.update(a);

        trans.commit();
        session.close();
    }

    /**
     * Método para deletar cliente no banco de dados.
     *
     * @param a
     */
    public void deleteCliente(Cliente a) {
        Session session = factory.openSession();
        Transaction trans = session.beginTransaction();
        trans.begin();

        session.delete(a);

        trans.commit();
        session.close();
    }

    /**
     * Método para buscar cliente por nome no banco de dados.
     *
     * Cliente a
     *
     * @param a
     * @return
     */
    public List searchClientePorNome(Cliente a) {
        List clientes = null;

        Session session = factory.openSession();
        SQLQuery query = session.createSQLQuery("SELECT {cliente.*} "
                + " FROM ALUNO {cliente} WHERE nome_cliente = '" + a.getNomeCliente() + "'");

        query.addEntity("cliente", Cliente.class);

        clientes = query.list();
        for (Object o : clientes) {
            RepCliente.initialize((Cliente) o);
        }
        session.close();
        return clientes;
    }

    /**
     * Método para pesquisar usuario por Matricula.
     *
     * @param Cliente a
     * @return Usuario
     */
    public Cliente searchClientePorCpf(Cliente a) {
        Cliente cliente = null;
        Session session = factory.openSession();

        SQLQuery query = session.createSQLQuery("SELECT {cliente.*} "
                + " FROM Cliente {cliente} WHERE cpfcnpj_cliente = '" + a.getCpfCnpjCliente() + "'");

        query.addEntity("cliente", Cliente.class);

        if (query.list().size() > 0) {
            cliente = (Cliente) query.list().get(0);
            RepCliente.initialize(cliente);
        }
        session.close();
        return cliente;
    }

    /**
     * Método para inicializar os objetos do banco de dados com os seus valores.
     *
     * @param a
     */
    public static void initialize(Cliente a) {
        Hibernate.initialize(a);
        Hibernate.initialize(a.getEnderecoClientes());
        Hibernate.initialize(a.getVendas());
    }
}
