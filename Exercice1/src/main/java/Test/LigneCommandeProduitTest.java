package Test;

import Service.CommandeProduitService;
import Service.CommandeService;
import Service.ProduitService;
import classes.LigneCommandeProduit;
import classes.Produit;

import java.util.ArrayList;
import java.util.List;

public class LigneCommandeProduitTest {

    public static void main(String[] args) {
        CommandeService cs = new CommandeService();
        ProduitService ps = new ProduitService();
        CommandeProduitService service = new CommandeProduitService();

        // 1 Première ligne
//        LigneCommandeProduit l1 = new LigneCommandeProduit(100,ps.getByID(26),cs.getByID(5));
//        LigneCommandeProduit l2 = new LigneCommandeProduit(100,ps.getByID(27),cs.getByID(5));
        LigneCommandeProduit l3 = new LigneCommandeProduit(100,ps.getByID(28),cs.getByID(6));

        service.create(l3);


    }

}
