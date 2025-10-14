package Service;

import classes.Commande;
import classes.LigneCommandeProduit;
import dao.IDao;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

import java.util.List;

public class CommandeProduitService implements IDao<LigneCommandeProduit> {



    @Override
    public boolean create(LigneCommandeProduit o) {

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
    public LigneCommandeProduit getByID(int id) {
        Session session=null;
        Transaction tx=null;
        LigneCommandeProduit ligneCommandeProduit=null;

        try{
            session=HibernateUtil.getSessionFactory().openSession();
            tx=session.beginTransaction();
            ligneCommandeProduit=session.get(LigneCommandeProduit.class,id);
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
        return ligneCommandeProduit;
    }

    @Override
    public List<LigneCommandeProduit> getall() {
        Session session=null;
        Transaction tx=null;
        List<LigneCommandeProduit> ligneCommandeProduits=null;

        try {
            session=HibernateUtil.getSessionFactory().openSession();
            tx=session.beginTransaction();
            ligneCommandeProduits=session.createQuery("from LigneCommandeProduit",LigneCommandeProduit.class).list();
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

        return ligneCommandeProduits;
    }



    public LigneCommandeProduit getQuantity(int CommandeID, int idProduit) {
        Session session=null;
        Transaction tx=null;
        LigneCommandeProduit ligneCommandeProduit=null;

        try {
            session=HibernateUtil.getSessionFactory().openSession();
            tx=session.beginTransaction();
            ligneCommandeProduit=(LigneCommandeProduit)session.getNamedQuery("quantiteParCommande").setParameter("commande",CommandeID).setParameter("idProduit",idProduit).list().get(0);
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

        return ligneCommandeProduit;
    }


}
