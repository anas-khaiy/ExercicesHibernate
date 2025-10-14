package Test;

import classes.Employe;
import classes.Projet;
import services.EmployeService;
import services.ProjetService;

import java.sql.Date;

public class TestProjet {

    public static void main(String[] args) {
        ProjetService es=new ProjetService();
        EmployeService ems=new EmployeService();

        Projet projet=new Projet("Projet1",Date.valueOf("2010-10-10"),Date.valueOf("2020-10-10"));
        Projet projet2=new Projet("Projet2",Date.valueOf("2000-10-10"),Date.valueOf("2022-10-10"));
        Projet projet3=new Projet("Projet3",Date.valueOf("2013-10-10"),Date.valueOf("2024-10-10"));
        Projet projet4=new Projet("Projet4",Date.valueOf("2012-10-10"),Date.valueOf("2028-10-10"));


        projet.setEmploye(ems.getByID(4));
        projet2.setEmploye(ems.getByID(5));
        projet3.setEmploye(ems.getByID(6));
        projet4.setEmploye(ems.getByID(4));

//        es.create(projet);
//        es.create(projet2);
//        es.create(projet3);
//        es.create(projet4);


        System.out.println("List Projets Par Employe 4");

        for (Projet p:ems.projetParEmploye(4))
        {
            System.out.println(p);
        }
    }
}
