/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import Entidades.Venda;
import HibernateUtil.NewHibernateUtil;
import java.util.List;
import org.hibernate.Hibernate;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author Felipe
 */
public class RepVenda {

    SessionFactory factory = NewHibernateUtil.getSessionFactory();

    public void saveVenda(Venda v) {
        Session session = factory.openSession();
        Transaction trans = session.beginTransaction();
        trans.begin();;

        session.save(v);

        trans.commit();
        session.close();

    }

    public void updateVenda(Venda v) {
        Session session = factory.openSession();
        Transaction trans = session.beginTransaction();
        trans.begin();

        session.update(v);

        trans.commit();
        session.close();
    }

    public void deleteVenda(Venda v) {
        Session session = factory.openSession();
        Transaction trans = session.beginTransaction();
        trans.begin();

        session.delete(v);

        trans.commit();
        session.close();
    }

    public Venda searchVenda(Venda v) {
        Venda venda = null;
        Session session = factory.openSession();
       
        SQLQuery query = session.createSQLQuery("SELECT (venda.*)"
                + "FROM VENDA (venda) WHERE codVenda =" + v.getCodVenda() + "'");

        query.addEntity("protudo", Venda.class);
       
        if(query.list().size() > 0){
            venda = (Venda) query.list().get(0);
            RepVenda.initialize(venda);

        }
        return venda;
    }

    private static void initialize(Venda v) {
        Hibernate.initialize(v);
        Hibernate.initialize(v.getProdutoVendas());

    }

}
