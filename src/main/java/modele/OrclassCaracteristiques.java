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
import javax.persistence.Transient;

@Entity
@Table(name = "ORCLASS_CARACTERISTIQUE")
public class OrclassCaracteristiques implements DAOEntry {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_CARACTERISTIQUE")
    private Long id;

    private String code;

    private String libelle;

    @JoinColumn(name = "ID_TYPE_CARACT", referencedColumnName = "ID_TYPE_CARACT")
    @ManyToOne(optional = true)
    private OrclassType_Caracteristique type_Caracteristique;

    @JoinColumn(name = "ID_UNITE_BUREAU", referencedColumnName = "ID_UNITE_BUREAU")
    @ManyToOne(optional = true)
    private OrclassUnite_Caracteristique unite_Caracteristique;

    Boolean showAllCompagnies = Boolean.FALSE;

    @JoinColumn(name = "ID_ENTREPRISE", referencedColumnName = "ID_ENTREPRISE")
    @ManyToOne(optional = true)
    private OrclassEntreprises idEntreprise;

    @Column(name = "DATE_CREATION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreation;

    @Column(name = "DATE_MODIFICATION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateModification;

    @JoinColumn(name = "ID_OBJET", referencedColumnName = "ID_OBJET")
    @ManyToOne(optional = true)
    private Orclass_Objet orclass_Objet;

    @Column(name = "NOM_CHAMP")
    private String champ;

    Boolean systeme = Boolean.FALSE;
    @Transient
    String valeur;
    @Transient
    OrclassSinistreMaladie sinistreMaladie;
     @Transient
     Boolean afficher=Boolean.FALSE;

    public OrclassCaracteristiques(String code, String libelle) {
        this.code = code;
        this.libelle = libelle;
        this.dateCreation = new Date();
        sinistreMaladie=new OrclassSinistreMaladie();
    }

    public Orclass_Objet getOrclass_Objet() {
        return this.orclass_Objet;
    }

    public void setOrclass_Objet(Orclass_Objet orclass_Objet) {
        this.orclass_Objet = orclass_Objet;
    }

    public String getChamp() {
        return this.champ;
    }

    public void setChamp(String champ) {
        this.champ = champ;
    }

    public Boolean getSysteme() {
        return this.systeme;
    }

    public void setSysteme(Boolean systeme) {
        this.systeme = systeme;
    }

    public OrclassCaracteristiques() {
    }

    public String getLibelle() {
        return this.libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public OrclassType_Caracteristique getType_Caracteristique() {
        return this.type_Caracteristique;
    }

    public void setType_Caracteristique(OrclassType_Caracteristique type_Caracteristique) {
        this.type_Caracteristique = type_Caracteristique;
    }

    public OrclassUnite_Caracteristique getUnite_Caracteristique() {
        return this.unite_Caracteristique;
    }

    public void setUnite_Caracteristique(OrclassUnite_Caracteristique unite_Caracteristique) {
        this.unite_Caracteristique = unite_Caracteristique;
    }

    public Boolean getShowAllCompagnies() {
        return this.showAllCompagnies;
    }

    public void setShowAllCompagnies(Boolean showAllCompagnies) {
        this.showAllCompagnies = showAllCompagnies;
    }

    public OrclassEntreprises getIdEntreprise() {
        return this.idEntreprise;
    }

    public void setIdEntreprise(OrclassEntreprises idEntreprise) {
        this.idEntreprise = idEntreprise;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Date getDateCreation() {
        return this.dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public Date getDateModification() {
        return this.dateModification;
    }

    public void setDateModification(Date dateModification) {
        this.dateModification = dateModification;
    }

    public String getValeur() {
        return valeur;
    }

    public void setValeur(String valeur) {
        this.valeur = valeur;
    }

    public OrclassSinistreMaladie getSinistreMaladie() {
        return sinistreMaladie;
    }

    public void setSinistreMaladie(OrclassSinistreMaladie sinistreMaladie) {
        this.sinistreMaladie = sinistreMaladie;
    }

    public Boolean getAfficher() {
        return afficher;
    }

    public void setAfficher(Boolean afficher) {
        this.afficher = afficher;
    }

    public int hashCode() {
        int hash = 0;
        hash += (this.id != null) ? this.id.hashCode() : 0;
        return hash;
    }

    public boolean equals(Object object) {
        if (!(object instanceof OrclassCaracteristiques)) {
            return false;
        }
        OrclassCaracteristiques other = (OrclassCaracteristiques) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    public String toString() {
        return "modele.OrclassCaracteristiques[ id=" + this.id + " ]";
    }
}
