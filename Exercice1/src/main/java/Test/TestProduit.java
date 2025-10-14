package Test;

import Service.CategorieService;
import Service.CommandeProduitService;
import Service.CommandeService;
import Service.ProduitService;
import classes.Categorie;
import classes.Produit;

import java.sql.Date;
import java.util.List;

public class TestProduit {

    public static void main(String[] args) {
        ProduitService ps=new ProduitService();
        CategorieService cs=new CategorieService();
        CommandeService cm=new CommandeService();
        CommandeProduitService cps=new CommandeProduitService();
        Produit p1=new Produit("P1",1000);
        Produit p2=new Produit("P2",2000);
        Produit p3=new Produit("P3",4000);
        Produit p4=new Produit("P4",5000);

//        p1.setCategorie(cs.getByID(1));
//        p2.setCategorie(cs.getByID(1));
//        p3.setCategorie(cs.getByID(1));
//        p4.setCategorie(cs.getByID(2));

        System.out.println("Ajouter les  Produits");

//        ps.create(p1);
//        ps.create(p2);
//        ps.create(p3);
//        ps.create(p4);

        System.out.println("Afichages les  Produits");
        for (Produit p:ps.getall())
        {
            System.out.println(p);
        }



        System.out.println("Le Produit 9"+ps.getByID(9));

        System.out.println("Afichages les  Produits Par Categories 1");

        for (Produit p:ps.produitParCategorie(1))
        {
            System.out.println(p);
        }


        System.out.println("Produit par date");
        for (Produit p:ps.produitParDate( Date.valueOf("2025-10-13")))
        {
            System.out.println(p);
        }



        List<Produit> produits=ps.produitParCommande(5);
        String chaine="";
        for (Produit p:produits)
        {
            chaine+=p.getReference()+"  "+ p.getPrix()+"     "+cps.getQuantity(5,p.getId()).getQuantite()+"\n";
        }

        System.out.println("Produits par Commande");
        System.out.println("Commande : "+cm.getByID(5).getId()+" Date : "+cm.getByID(5).getDate());
        System.out.println("Liste Des Produits : ");
        System.out.println("Réf  Prix    Quantité  ");
        System.out.println(chaine);


        System.out.println("Produits par Prix Sup à 2000");
        for (Produit p:ps.ProduitParPrix())
        {
            System.out.println(p);
        }

    }
}
