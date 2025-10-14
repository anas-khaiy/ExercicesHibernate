package classes;


import javax.persistence.*;
import java.util.List;

@Entity
@NamedNativeQueries({
        @NamedNativeQuery(name = "ProduitparCategorie", query = "select * from produit where categorie_id=:categorie",resultClass=Produit.class),
        @NamedNativeQuery(name = "produitByDate", query = "SELECT p.* from produit p INNER JOIN LigneCommandeProduit l on l.produit=p.id INNER JOIN commande c on l.commande=c.id where c.date =:date",resultClass=Produit.class),
        @NamedNativeQuery(name = "produitParCommande", query = "SELECT P.* FROM LigneCommandeProduit l INNER JOIN produit p on p.id=l.produit where l.commande=:idCommande",resultClass=Produit.class),
        @NamedNativeQuery(name = "ProduitParPrix", query = "SELECT * FROM `Produit` where prix >=2000",resultClass=Produit.class),


})
public class Produit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String reference;
    private double prix;

    @ManyToOne
    private Categorie categorie;

    @OneToMany(mappedBy = "produit")
    private List<LigneCommandeProduit> ligneCommandes;

    public List<LigneCommandeProduit> getLigneCommandes() {
        return ligneCommandes;
    }

    public void setLigneCommandes(List<LigneCommandeProduit> ligneCommandes) {
        this.ligneCommandes = ligneCommandes;
    }

    public Produit() {

    }

    public Produit(String reference, double prix) {
        this.reference = reference;
        this.prix = prix;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    public int getId() {
        return id;
    }


    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    @Override
    public String toString() {
        return "Produit{" +
                "id=" + id +
                ", reference='" + reference + '\'' +
                ", prix=" + prix +
                '}';
    }
}
