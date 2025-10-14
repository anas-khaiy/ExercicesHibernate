package Test;

import Service.CommandeService;
import Service.ProduitService;
import classes.Commande;
import classes.Produit;

import java.util.Date;

public class Testcommande {
    public static void main(String[] args) {
        CommandeService ps=new CommandeService();

        Commande c1=new Commande(new Date());
        Commande c2=new Commande(new Date());
        Commande c3=new Commande(new Date());
        Commande c4=new Commande(new Date());

        System.out.println("Ajouter les  Commandes");

        ps.create(c1);
        ps.create(c2);
        ps.create(c3);
        ps.create(c4);

        System.out.println("Afichages les  Commandes");
        for (Commande p:ps.getall())
        {
            System.out.println(p);
        }



        System.out.println("Le Commande 2"+ps.getByID(2));
    }
}
