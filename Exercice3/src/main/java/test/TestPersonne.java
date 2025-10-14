package test;

import classes.Personne;
import services.PersonneService;

import java.sql.Date;

public class TestPersonne {
    public static void main(String[] args) {
        PersonneService ps=new PersonneService();



        Personne p1=new Personne(Date.valueOf("1999-10-10"),"adresse 1 ","05343232","Prenom1","Nom1");
        Personne p2=new Personne(Date.valueOf("1994-10-10"),"adresse 2 ","05343842","Prenom2","Nom2");
        Personne p3=new Personne(Date.valueOf("1993-10-10"),"adresse 3 ","05345342","Prenom3","Nom3");


        ps.create(p1);
        ps.create(p2);
        ps.create(p3);
    }
}
