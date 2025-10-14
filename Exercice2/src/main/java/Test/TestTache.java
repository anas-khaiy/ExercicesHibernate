package Test;

import classes.Tache;
import services.ProjetService;
import services.TacheService;

import java.sql.Date;

public class TestTache {

    public static void main(String[] args) {

        TacheService ts=new TacheService();

        ProjetService ps=new ProjetService();

        Tache tache=new Tache("tache1", Date.valueOf("2010-10-10"),Date.valueOf("2020-10-10"),10000);
        Tache tache2=new Tache("tache2", Date.valueOf("2011-10-10"),Date.valueOf("2022-10-10"),12000);
        Tache tache3=new Tache("tache3", Date.valueOf("2012-10-10"),Date.valueOf("2024-10-10"),13000);
        Tache tache4=new Tache("tache4", Date.valueOf("2013-10-10"),Date.valueOf("2023-10-10"),20000);
        Tache tache5=new Tache("tache5", Date.valueOf("2016-10-10"),Date.valueOf("2026-10-10"),20000);


        tache.setProjet(ps.getByID(4));
        tache2.setProjet(ps.getByID(5));
        tache3.setProjet(ps.getByID(6));
        tache4.setProjet(ps.getByID(4));
        tache5.setProjet(ps.getByID(4));


//        ts.create(tache);
//        ts.create(tache2);
//        ts.create(tache3);
//        ts.create(tache4);
//        ts.create(tache5);


        System.out.println("Les tache Par Employe 4");
        for (Tache t:ts.tacheParEmploye(4))
        {
            System.out.println(t);
        }



        System.out.println("Les tache Par Projet 4");
        for (Tache t:ps.tacheParProjet(4))
        {
            System.out.println(t);
        }



        System.out.println("Les tache - Salaire Sup 1000");
        for (Tache t:ts.tacheParPrix())
        {
            System.out.println(t);
        }


        System.out.println("Les tache - Entre Deux Date");
        for (Tache t:ts.tacheParDate(Date.valueOf("2000-01-01"),Date.valueOf("2025-01-01")))
        {
            System.out.println(t);
        }


    }
}
