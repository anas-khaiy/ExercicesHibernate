package test;

import classes.Femme;
import classes.Personne;
import services.FemmeService;

import java.sql.Date;

public class TestFemme {

    public static void main(String[] args) {

        FemmeService fs=new FemmeService();
        Femme p1=new Femme(Date.valueOf("1920-10-10"),"adresse 13 ","05343232","FemmePrenom4","FemmeNom4");
        Femme p2=new Femme(Date.valueOf("1930-10-10"),"adresse 2 2","05343842","FemmePrenom5","FemmeNom5");
        Femme p3=new Femme(Date.valueOf("1940-10-10"),"adresse 3 ZSZz","05345342","FemmePrenom6","FemmeNom6");


        fs.create(p1);
        fs.create(p2);
        fs.create(p3);
    }
}
