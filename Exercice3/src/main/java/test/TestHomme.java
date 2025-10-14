package test;

import classes.Femme;
import classes.Homme;
import classes.Personne;
import services.HommeService;

import java.sql.Date;

public class TestHomme {

    public static void main(String[] args) {

        HommeService hs=new HommeService();
        Homme p1=new Homme(Date.valueOf("2000-10-10"),"adresse 1 ","05343232","HommePrenom1","HommeNom1");
        Homme p2=new Homme(Date.valueOf("2001-10-10"),"adresse 2 ","05343842","HommePrenom2","HommeNom2");
        Homme p3=new Homme(Date.valueOf("2003-10-10"),"adresse 3 ","05345342","HommePrenom3","HommeNom3");


//        hs.create(p1);
//        hs.create(p2);
//        hs.create(p3);


        System.out.println("femmes Par Homme ");
        for (Personne f:hs.femmeParHomme(4,Date.valueOf("1900-10-10"),Date.valueOf("2040-10-10")))
        {
            System.out.println(f);
        }
    }
}
