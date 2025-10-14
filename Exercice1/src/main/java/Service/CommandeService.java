package Service;

import classes.Commande;
import dao.IDao;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

import java.util.List;

public class CommandeService implements IDao<Commande> {



    @Override
    public boolean create(Commande o) {

        Session session= null;
        boolean etat=false;
        Transaction tx=null;

        try {
            session= HibernateUtil.getSessionFactory().openSession();
            tx=session.beginTransaction();
            session.save(o);
            tx.commit();
            etat=true;
        } catch (HibernateException e) {
            if (tx!=null)
                tx.rollback();
            e.printStackTrace();
        }finally {
            if(session!=null)
                session.close();
        }

        return etat;
    }

    @Override
    public Commande getByID(int id) {
        Session session=null;
        Transaction tx=null;
        Commande commande=null;

        try{
            session=HibernateUtil.getSessionFactory().openSession();
            tx=session.beginTransaction();
            commande=session.get(Commande.class,id);
            tx.commit();

        }catch (HibernateException e)
        {
            if (tx!=null)
                tx.rollback();
            e.printStackTrace();
        }finally {
            if (session!=null)
                session.close();
        }
        return commande;
    }

    @Override
    public List<Commande> getall() {
        Session session=null;
        Transaction tx=null;
        List<Commande> commandes=null;

        try {
            session=HibernateUtil.getSessionFactory().openSession();
            tx=session.beginTransaction();
            commandes=session.createQuery("from Commande",Commande.class).list();
            tx.commit();
        }
        catch (HibernateException e)
        {
            if (tx!=null)
                tx.rollback();
            e.printStackTrace();
        }
        finally {
            if (session!=null)
                session.close();
        }

        return commandes;
    }





}
