package services;

import classes.Tache;
import dao.IDao;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

import java.util.Date;
import java.util.List;

public class TacheService implements IDao<Tache> {


    @Override
    public boolean create(Tache o) {

        Session session = null;
        boolean etat = false;
        Transaction tx = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.save(o);
            tx.commit();
            etat = true;
        } catch (HibernateException e) {
            if (tx != null)
                tx.rollback();
            e.printStackTrace();
        } finally {
            if (session != null)
                session.close();
        }

        return etat;
    }

    @Override
    public Tache getByID(int id) {
        Session session = null;
        Transaction tx = null;
        Tache tache = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            tache = session.get(Tache.class, id);
            tx.commit();

        } catch (HibernateException e) {
            if (tx != null)
                tx.rollback();
            e.printStackTrace();
        } finally {
            if (session != null)
                session.close();
        }
        return tache;
    }

    @Override
    public List<Tache> getall() {
        Session session = null;
        Transaction tx = null;
        List<Tache> taches = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            taches = session.createQuery("from Tache", Tache.class).list();
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null)
                tx.rollback();
            e.printStackTrace();
        } finally {
            if (session != null)
                session.close();
        }

        return taches;
    }




    public List<Tache> tacheParEmploye(int idEmploye) {
        Session session = null;
        Transaction tx = null;
        List<Tache> taches = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            taches = session.getNamedNativeQuery("tacheParEmploye").setParameter("idEmploye",idEmploye).list();
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null)
                tx.rollback();
            e.printStackTrace();
        } finally {
            if (session != null)
                session.close();
        }

        return taches;
    }


    public List<Tache> tacheParPrix() {
        Session session = null;
        Transaction tx = null;
        List<Tache> taches = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            taches = session.getNamedNativeQuery("tacheParPrix").list();
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null)
                tx.rollback();
            e.printStackTrace();
        } finally {
            if (session != null)
                session.close();
        }

        return taches;
    }


    public List<Tache> tacheParDate(Date d1, Date d2) {
        Session session = null;
        Transaction tx = null;
        List<Tache> taches = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            taches = session.getNamedNativeQuery("tacheParDate").setParameter("d1",d1).setParameter("d2",d2).list();
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null)
                tx.rollback();
            e.printStackTrace();
        } finally {
            if (session != null)
                session.close();
        }

        return taches;
    }

}