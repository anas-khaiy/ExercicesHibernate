package services;

import classes.EmployeTache;
import classes.EmployeTache;
import dao.IDao;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

import java.util.List;

public class EmployeTacheService implements IDao<EmployeTache> {


    @Override
    public boolean create(EmployeTache o) {

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
    public EmployeTache getByID(int id) {
        Session session = null;
        Transaction tx = null;
        EmployeTache employeTache = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            employeTache = session.get(EmployeTache.class, id);
            tx.commit();

        } catch (HibernateException e) {
            if (tx != null)
                tx.rollback();
            e.printStackTrace();
        } finally {
            if (session != null)
                session.close();
        }
        return employeTache;
    }

    @Override
    public List<EmployeTache> getall() {
        Session session = null;
        Transaction tx = null;
        List<EmployeTache> employeTaches = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            employeTaches = session.createQuery("from EmployeTache", EmployeTache.class).list();
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null)
                tx.rollback();
            e.printStackTrace();
        } finally {
            if (session != null)
                session.close();
        }

        return employeTaches;
    }

    public List<EmployeTache> tacheInfo(int idProjet) {
        Session session = null;
        Transaction tx = null;
        List<EmployeTache> employeTaches = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            employeTaches = session.getNamedNativeQuery("tacheInfo").setParameter("idProjet",idProjet).list();
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null)
                tx.rollback();
            e.printStackTrace();
        } finally {
            if (session != null)
                session.close();
        }

        return employeTaches;
    }


    public void afficherInfoTache(int projetId) {
        Session session = null;
        Transaction tx = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();

            String sql = "SELECT \n" +
                    "        p.id AS projet_id,\n" +
                    "        p.nom AS projet_nom,\n" +
                    "        p.dateDebut AS projet_date_debut,\n" +
                    "        t.id AS tache_id,\n" +
                    "        t.nom AS tache_nom,\n" +
                    "        e.dateDebutReelle AS debut_reelle,\n" +
                    "        e.dateFinReelle AS fin_reelle\n" +
                    "    FROM Tache t\n" +
                    "    INNER JOIN EmployeTache e ON t.id = e.tache\n" +
                    "    INNER JOIN Projet p ON p.id = t.projet_id\n" +
                    "    WHERE t.projet_id = :idProjet";

            List<Object[]> results = session.createNativeQuery(sql)
                    .setParameter("idProjet", projetId)
                    .list();

            tx.commit();

            String projetid="";
            String dateDebut="";
            String projetNom="";
            String chaine="";
            for (Object[] row : results) {
                 projetid =  row[0].toString();
                 projetNom = row[1].toString();
                 dateDebut =  row[2].toString();

                 String tacheNom =row[4].toString();
                 String dateDebutReelle = row[5].toString();
                 String dateFinReelle =row[6].toString();
                chaine+=tacheNom+"    "+dateDebutReelle+"    "+dateFinReelle+"\n";

            }

            System.out.println("Projet :"+projetid.toString()+" Nome : "+projetNom+" Date Début : "+dateDebut);
            System.out.println("List des Taches :");
            System.out.println("Nom    Date DébutReelle    Date FinReelle ");
            System.out.println(chaine);



        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            if (session != null) session.close();
        }
    }
}

