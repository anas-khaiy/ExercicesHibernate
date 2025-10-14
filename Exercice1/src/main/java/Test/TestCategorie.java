package Test;

import Service.CategorieService;
import classes.Categorie;
import classes.Commande;

public class TestCategorie {

    public static void main(String[] args) {
        CategorieService cs=new CategorieService();
        Categorie c=new Categorie("CAT1","Libelle1");
        Categorie c2=new Categorie("CAT2","Libelle2");


        System.out.println("Ajouter les  Commandes");

        cs.create(c);
        cs.create(c2);


        System.out.println("Afichages les  Commandes");
        for (Categorie p:cs.getall())
        {
            System.out.println(p);
        }



        System.out.println("Le Categorie 2"+cs.getByID(2));
    }
}
