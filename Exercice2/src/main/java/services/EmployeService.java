package services;

import classes.Employe;
import classes.Projet;
import dao.IDao;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

import java.util.List;

public class EmployeService implements IDao<Employe> {


    @Override
    public boolean create(Employe o) {

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
    public Employe getByID(int id) {
        Session session = null;
        Transaction tx = null;
        Employe employe = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            employe = session.get(Employe.class, id);
            tx.commit();

        } catch (HibernateException e) {
            if (tx != null)
                tx.rollback();
            e.printStackTrace();
        } finally {
            if (session != null)
                session.close();
        }
        return employe;
    }

    @Override
    public List<Employe> getall() {
        Session session = null;
        Transaction tx = null;
        List<Employe> employes = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            employes = session.createQuery("from Employe", Employe.class).list();
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null)
                tx.rollback();
            e.printStackTrace();
        } finally {
            if (session != null)
                session.close();
        }

        return employes;
    }



    public List<Projet> projetParEmploye(int idEmploye) {
        Session session = null;
        Transaction tx = null;
        List<Projet> projets = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            projets = session.getNamedQuery("projetParEmploye").setParameter("idEmploye",idEmploye).list();
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null)
                tx.rollback();
            e.printStackTrace();
        } finally {
            if (session != null)
                session.close();
        }

        return projets;
    }




}