package Service;

import classes.Produit;
import com.mysql.cj.xdevapi.SessionFactory;
import dao.IDao;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public class ProduitService implements IDao<Produit> {



    @Override
    public boolean create(Produit o) {

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
    public Produit getByID(int id) {
        Session session=null;
        Transaction tx=null;
        Produit produit=null;

        try{
            session=HibernateUtil.getSessionFactory().openSession();
            tx=session.beginTransaction();
            produit=session.get(Produit.class,id);
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
        return produit;
    }

    @Override
    public List<Produit> getall() {
        Session session=null;
        Transaction tx=null;
        List<Produit> produits=null;

        try {
            session=HibernateUtil.getSessionFactory().openSession();
            tx=session.beginTransaction();
            produits=session.createQuery("from Produit",Produit.class).list();
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

        return produits;
    }


    public List<Produit> produitParCategorie(int catId) {
        Session session=null;
        Transaction tx=null;
        List<Produit> produits=null;

        try {
            session=HibernateUtil.getSessionFactory().openSession();
            tx=session.beginTransaction();
            produits=session.getNamedNativeQuery("ProduitparCategorie").setParameter("categorie",catId).list();
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

        return produits;
    }

    public List<Produit> produitParDate(Date date) {
        Session session=null;
        Transaction tx=null;
        List<Produit> produits=null;

        try {
            session=HibernateUtil.getSessionFactory().openSession();
            tx=session.beginTransaction();
            produits=session.getNamedNativeQuery("produitByDate").setParameter("date",date).list();
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

        return produits;
    }


    public List<Produit> produitParCommande(int idCommande) {
        Session session=null;
        Transaction tx=null;
        List<Produit> produits=null;

        try {
            session=HibernateUtil.getSessionFactory().openSession();
            tx=session.beginTransaction();
            produits=session.getNamedNativeQuery("produitParCommande").setParameter("idCommande",idCommande).list();
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

        return produits;
    }

    public List<Produit> ProduitParPrix() {
        Session session=null;
        Transaction tx=null;
        List<Produit> produits=null;

        try {
            session=HibernateUtil.getSessionFactory().openSession();
            tx=session.beginTransaction();
            produits=session.getNamedNativeQuery("ProduitParPrix").list();
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

        return produits;
    }

}
