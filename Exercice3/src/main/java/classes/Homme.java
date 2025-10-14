package classes;

import javax.persistence.Entity;
import java.sql.Date;
@Entity
public class Homme extends Personne {


    public Homme() {
    }

    public Homme(Date dateNaissance, String adresse, String telephone, String prenom, String nom) {
        super(dateNaissance, adresse, telephone, prenom, nom);
    }

    @Override
    public String toString() {
        return "Homme{" +
                "dateNaissance=" + dateNaissance +
                ", adresse='" + adresse + '\'' +
                ", telephone='" + telephone + '\'' +
                ", prenom='" + prenom + '\'' +
                ", nom='" + nom + '\'' +
                ", id=" + id +
                '}';
    }


}
