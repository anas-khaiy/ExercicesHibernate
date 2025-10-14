package classes;


import javax.persistence.*;

@Entity
@NamedNativeQuery(name = "quantiteParCommande",query = "SELECT l.* FROM `LigneCommandeProduit` l INNER JOIN commande c on c.id=l.commande where c.id=:commande and l.produit=:idProduit",resultClass = LigneCommandeProduit.class)
public class LigneCommandeProduit {
    @EmbeddedId
    private LigneCommandePK ligneCommandePK;


    private int quantite;

    @MapsId("produit")
    @ManyToOne
    @JoinColumn(name = "produit")
    private Produit produit;

    @MapsId("commande")
    @ManyToOne
    @JoinColumn(name = "commande" )
    private Commande commande;

    public LigneCommandeProduit() {
        ligneCommandePK=new LigneCommandePK();
    }

    public LigneCommandePK getLigneCommandePK() {
        return ligneCommandePK;
    }

    public void setLigneCommandePK(LigneCommandePK ligneCommandePK) {
        this.ligneCommandePK = ligneCommandePK;
    }

    public LigneCommandeProduit(int quantite, Produit produit, Commande commande) {
        ligneCommandePK=new LigneCommandePK();
        this.ligneCommandePK.setCommande(commande.getId());
        this.ligneCommandePK.setProduit(produit.getId());
        this.quantite = quantite;
        this.produit = produit;
        this.commande = commande;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }

    public Commande getCommande() {
        return commande;
    }

    public void setCommande(Commande commande) {
        this.commande = commande;
    }
}
