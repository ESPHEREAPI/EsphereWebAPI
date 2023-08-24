package modele;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "ORCLASS_ACCESS_AVENANT", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"ID_ENTREPRISE", "ID_BRANCHE", "ID_CATEGORIE", "ID_TYPE_AVENANT", "AJOUTER", "MODIFIER", "SUPPRIME","ID_OBJET"})})
public class Orclass_Access_Avenant implements DAOEntry {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_ACCESS_AVENANT")
    private Long id;

    @JoinColumn(name = "ID_BRANCHE", referencedColumnName = "ID_BRANCHE")
    @ManyToOne(optional = false)
    private OrclassBranches idBranche;

    @JoinColumn(name = "ID_ENTREPRISE", referencedColumnName = "ID_ENTREPRISE")
    @ManyToOne(optional = false)
    private OrclassEntreprises idEntreprises;

    @JoinColumn(name = "ID_OBJET", referencedColumnName = "ID_OBJET")
    @ManyToOne(optional = false)
    private Orclass_Objet idObjet;

    @JoinColumn(name = "ID_CATEGORIE", referencedColumnName = "ID_CATEGORIE")
    @ManyToOne(optional = true)
    private OrclassCategories idCategories;

    @JoinColumn(name = "ID_TYPE_AVENANT", referencedColumnName = "ID_TYPE_AVENANT")
    @ManyToOne(optional = false)
    private Orclass_TypeAvenant idTypeAvenant;

    @Column(name = "AJOUTER")
    Boolean ajouter = Boolean.FALSE;

    @Column(name = "MODIFIER")
    Boolean modifier = Boolean.FALSE;

    @Column(name = "SUPPRIME")
    Boolean supprimer = Boolean.FALSE;

    @Column(name = "DATE_CREATION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreation;
    @Column(name = "DATE_MODIFICATION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateModification;

    public Orclass_Access_Avenant() {
        this.idBranche = new OrclassBranches();
        this.idObjet = new Orclass_Objet();
        this.idTypeAvenant = new Orclass_TypeAvenant();
    }

    public OrclassBranches getIdBranche() {
        return this.idBranche;
    }

    public void setIdBranche(OrclassBranches idBranche) {
        this.idBranche = idBranche;
    }

    public OrclassEntreprises getIdEntreprises() {
        return this.idEntreprises;
    }

    public void setIdEntreprises(OrclassEntreprises idEntreprises) {
        this.idEntreprises = idEntreprises;
    }

    public Orclass_Objet getIdObjet() {
        return this.idObjet;
    }

    public void setIdObjet(Orclass_Objet idObjet) {
        this.idObjet = idObjet;
    }

    public OrclassCategories getIdCategories() {
        return this.idCategories;
    }

    public void setIdCategories(OrclassCategories idCategories) {
        this.idCategories = idCategories;
    }

    public Orclass_TypeAvenant getIdTypeAvenant() {
        return this.idTypeAvenant;
    }

    public void setIdTypeAvenant(Orclass_TypeAvenant idTypeAvenant) {
        this.idTypeAvenant = idTypeAvenant;
    }

    public Boolean getAjouter() {
        return this.ajouter;
    }

    public void setAjouter(Boolean ajouter) {
        this.ajouter = ajouter;
    }

    public Boolean getModifier() {
        return this.modifier;
    }

    public void setModifier(Boolean modifier) {
        this.modifier = modifier;
    }

    public Boolean getSupprimer() {
        return this.supprimer;
    }

    public void setSupprimer(Boolean supprimer) {
        this.supprimer = supprimer;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public Date getDateModification() {
        return dateModification;
    }

    public void setDateModification(Date dateModification) {
        this.dateModification = dateModification;
    }
    
    

    public int hashCode() {
        int hash = 0;
        hash += (this.id != null) ? this.id.hashCode() : 0;
        return hash;
    }

    public boolean equals(Object object) {
        if (!(object instanceof Orclass_Access_Avenant)) {
            return false;
        }
        Orclass_Access_Avenant other = (Orclass_Access_Avenant) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    public String toString() {
        return "modele.Orclass_Access_Avenant[ id=" + this.id + " ]";
    }
}
