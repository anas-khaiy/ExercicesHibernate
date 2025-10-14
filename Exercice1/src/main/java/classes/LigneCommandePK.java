package classes;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class LigneCommandePK implements Serializable {

    private int commande;
    private int produit;

    public LigneCommandePK() {
    }

    public int getCommande() {
        return commande;
    }

    public void setCommande(int commande) {
        this.commande = commande;
    }

    public int getProduit() {
        return produit;
    }

    public void setProduit(int produit) {
        this.produit = produit;
    }

}
