package classes;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Marriage {
    @EmbeddedId
    private MarriagePK pk;

    @Temporal(value = TemporalType.DATE)
    private Date dateDebut;


    @Temporal(value = TemporalType.DATE)
    private Date dateFin;

    private int nbEnfant;


    @ManyToOne
    @JoinColumn(name = "homme",insertable = false,updatable = false)
    private Homme homme;

    @ManyToOne
    @JoinColumn(name = "femme",insertable = false,updatable = false)
    private Femme femme;


    public Marriage() {
        this.pk=new MarriagePK();
    }



    public Marriage(Date dateDebut, Date dateFin, int nbEnfant, Homme homme, Femme femme) {
        this.pk=new MarriagePK();

        this.pk.setFemme(femme.getId());
        this.pk.setHomme(homme.getId());
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.nbEnfant = nbEnfant;
    }

    public Femme getFemme() {
        return femme;
    }

    public void setFemme(Femme femme) {
        this.femme = femme;
    }

    public Homme getHomme() {
        return homme;
    }

    public void setHomme(Homme homme) {
        this.homme = homme;
    }
}
