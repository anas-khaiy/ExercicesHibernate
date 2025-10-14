package classes;

import javax.persistence.*;
import java.util.Date;
@Entity
@NamedNativeQueries({
        @NamedNativeQuery(name="projetParEmploye",query = "Select p.* from Employe e INNER join Projet p on p.employe_id=e.id where e.id=:idEmploye",resultClass = Projet.class)
})
public class Projet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nom;

    @Temporal(value = TemporalType.DATE)
    private Date dateDebut;

    @Temporal(value = TemporalType.DATE)
    private Date dateFin;

    @ManyToOne
    private Employe employe;

    public Employe getEmploye() {
        return employe;
    }

    public void setEmploye(Employe employe) {
        this.employe = employe;
    }



    public Projet() {
    }

    public Projet(String nom, Date dateDebut, Date dateFin) {
        this.nom = nom;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
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

    @Override
    public String toString() {
        return "Projet{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", dateDebut=" + dateDebut +
                ", dateFin=" + dateFin +
                '}';
    }
}
