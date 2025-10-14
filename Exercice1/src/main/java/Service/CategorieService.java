package Service;

import classes.Categorie;
import dao.IDao;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

import java.util.List;

public class CategorieService implements IDao<Categorie> {



    @Override
    public boolean create(Categorie o) {

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
    public Categorie getByID(int id) {
        Session session=null;
        Transaction tx=null;
        Categorie categorie=null;

        try{
            session=HibernateUtil.getSessionFactory().openSession();
            tx=session.beginTransaction();
            categorie=session.get(Categorie.class,id);
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
        return categorie;
    }

    @Override
    public List<Categorie> getall() {
        Session session=null;
        Transaction tx=null;
        List<Categorie> categories=null;

        try {
            session=HibernateUtil.getSessionFactory().openSession();
            tx=session.beginTransaction();
            categories=session.createQuery("from Categorie",Categorie.class).list();
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

        return categories;
    }



}
