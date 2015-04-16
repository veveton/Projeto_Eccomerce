/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.List;
import org.hibernate.Hibernate;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import HibernateUtil.NewHibernateUtil;
import Entidades.Produto;

/**
 *
 * @author Felipe
 */
public class RepProduto {

    SessionFactory factory = NewHibernateUtil.getSessionFactory();

    public void saveProduto(Produto p) {
        Session session = factory.openSession();
        Transaction trans = session.beginTransaction();
        trans.begin();;

        session.save(p);

        trans.commit();
        session.close();

    }

    public void updateProduto(Produto p) {
        Session session = factory.openSession();
        Transaction trans = session.beginTransaction();
        trans.begin();

        session.update(p);

        trans.commit();
        session.close();
    }

    public void deleteProduto(Produto p) {
        Session session = factory.openSession();
        Transaction trans = session.beginTransaction();
        trans.begin();

        session.delete(p);

        trans.commit();
        session.close();
    }

    public Produto searchProduto(Produto p) {
        Produto produto = null;
        Session session = factory.openSession();

        SQLQuery query = session.createSQLQuery("SELECT (produto.*)"
                + "FROM PRODUTO (produto) WHERE codProduto =" + p.getCodProduto() + "'");

        query.addEntity("protudo", Produto.class);

        if (query.list().size() > 0) {
            produto = (Produto) query.list().get(0);
            RepProduto.initialize(produto);

        }
        return produto;
    }

    private static void initialize(Produto p) {
        Hibernate.initialize(p);
        Hibernate.initialize(p.getProdutoVendas());

    }

}
