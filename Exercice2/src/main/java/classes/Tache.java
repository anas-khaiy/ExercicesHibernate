package classes;

import javax.persistence.*;
import java.util.Date;
@Entity
@NamedNativeQueries({
        @NamedNativeQuery(name="tacheParEmploye",query = "Select t.* from Employe e INNER join EmployeTache x on e.id=x.employe INNER JOIN Tache t on t.id=x.tache where e.id =:idEmploye",resultClass = Tache.class),
        @NamedNativeQuery(name = "tacheParProjet", query = "SELECT t.* FROM Tache t INNER join Projet p on p.id=t.projet_id where p.id=:idProjet", resultClass = Tache.class),
        @NamedNativeQuery(name = "tacheParPrix", query = "SELECT * from Tache where `prix`>=1000", resultClass = Tache.class),
        @NamedNativeQuery(name = "tacheParDate", query = "SELECT * from Tache where `dateFin` BETWEEN :d1 and :d2", resultClass = Tache.class)

})
public class Tache {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nom;
    @Temporal(value = TemporalType.DATE)
    private Date dateDebut;

    @Temporal(value = TemporalType.DATE)
    private Date dateFin;

    private double prix;


    @ManyToOne
    private Projet projet;

    public Tache() {
    }

    public Tache(String nom, Date dateDebut, Date dateFin, double prix) {
        this.nom = nom;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.prix = prix;
    }

    public Projet getProjet() {
        return projet;
    }

    public void setProjet(Projet projet) {
        this.projet = projet;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }


    @Override
    public String toString() {
        return "Tache{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", dateDebut=" + dateDebut +
                ", dateFin=" + dateFin +
                ", prix=" + prix +
                '}';
    }
}
