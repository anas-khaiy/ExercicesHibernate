package classes;


import javax.persistence.*;
import java.util.Date;

@Entity

public class EmployeTache {

    @EmbeddedId
    private EmployeTachePK pk;

    @ManyToOne
    @JoinColumn(name = "employe", insertable = false, updatable = false)
    private Employe employe;

    @ManyToOne
    @JoinColumn(name = "tache", insertable = false, updatable = false)
    private Tache tache;

    @Temporal(value = TemporalType.DATE)
    private Date dateDebutReelle;

    @Temporal(value = TemporalType.DATE)
    private Date dateFinReelle;


    public EmployeTache() {
        pk=new EmployeTachePK();

    }

    public EmployeTache(Employe employe, Tache tache, Date dateDebutReelle, Date dateFinReelle) {
        pk=new EmployeTachePK();
        pk.setEmploye(employe.getId());
        pk.setTache(tache.getId());
        this.employe = employe;
        this.tache = tache;
        this.dateDebutReelle = dateDebutReelle;
        this.dateFinReelle = dateFinReelle;
    }

    public EmployeTachePK getPk() {
        return pk;
    }

    public void setPk(EmployeTachePK pk) {
        this.pk = pk;
    }

    public Date getDateDebutReelle() {
        return dateDebutReelle;
    }

    public void setDateDebutReelle(Date dateDebutReelle) {
        this.dateDebutReelle = dateDebutReelle;
    }

    public Date getDateFinReelle() {
        return dateFinReelle;
    }

    public void setDateFinReelle(Date dateFinReelle) {
        this.dateFinReelle = dateFinReelle;
    }



}
