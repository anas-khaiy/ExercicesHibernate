package classes;

import javax.persistence.Entity;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import java.sql.Date;


@Entity

public class Femme extends Personne{
    public Femme() {
    }

    public Femme(Date dateNaissance, String adresse, String telephone, String prenom, String nom) {
        super(dateNaissance, adresse, telephone, prenom, nom);
    }

    @Override
    public String toString() {
        return "Femme{" +
                "dateNaissance=" + dateNaissance +
                ", adresse='" + adresse + '\'' +
                ", telephone='" + telephone + '\'' +
                ", prenom='" + prenom + '\'' +
                ", nom='" + nom + '\'' +
                ", id=" + id +
                '}';
    }
}
