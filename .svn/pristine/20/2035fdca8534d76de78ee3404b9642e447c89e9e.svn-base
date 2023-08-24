/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import utils.GlobalFonctions;

/**
 *
 * @author hp
 */
@Entity
@Table(name = "ORCLASS_POLICE_CARACT")
public class OrclassPoliceCaracteristique implements DAOEntry {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    @Column(name = "ID_POLICE_CARACT")
    private Long id;

    @JoinColumn(name = "ID_POLICE", referencedColumnName = "ID_POLICE")
    @ManyToOne
    private OrclassPolice idPolice;
    @JoinColumn(name = "ID_ENTREPRISE", referencedColumnName = "ID_ENTREPRISE")
    @ManyToOne(optional = false)
    private OrclassEntreprises idEntreprise;
    @JoinColumn(name = "ID_CARACTERISTIQUE", referencedColumnName = "ID_CARACTERISTIQUE")
    @ManyToOne(optional = false)
    private OrclassCaracteristiques idCaracteristiques;
    @JoinColumn(name = "ID_AVENANT", referencedColumnName = "ID_AVENANT")
    @ManyToOne(optional = true)
    private OrclassAvenant idAvenant;

    @JoinColumn(name = "ID_CATEGORIE", referencedColumnName = "ID_CATEGORIE")
    @ManyToOne(optional = false)
    private OrclassCategories idCategories;
    @JoinColumn(name = "ID_GROUPE_CARACT", referencedColumnName = "ID_REF_GROUPE")
    @ManyToOne(optional = true)
    private OrclasseRefGroupe idGroup;
    private Boolean valeurBoolean;

    private String valeurTexte;
    private String valeurCaracteristique;
    private BigDecimal valeurNumerique;
    private String valeurCode;
    @Temporal(TemporalType.DATE)
    private Date dateValeur;
    private Boolean modifier, ajouter, retire_de_la_police = Boolean.FALSE;
    private Long codeid_retirer;
    @Transient
    private Boolean afficher = Boolean.TRUE;
    @Transient
    String valeur;

    @Transient
    Orclass_TypeAvenant typeAvenant;

    public OrclassPoliceCaracteristique() {
        idCaracteristiques = new OrclassCaracteristiques();
        idPolice = new OrclassPolice();
    }

    public OrclassPolice getIdPolice() {
        return idPolice;
    }

    public void setIdPolice(OrclassPolice idPolice) {
        this.idPolice = idPolice;
    }

    public OrclassEntreprises getIdEntreprise() {
        return idEntreprise;
    }

    public void setIdEntreprise(OrclassEntreprises idEntreprise) {
        this.idEntreprise = idEntreprise;
    }

    public OrclassCaracteristiques getIdCaracteristiques() {
        return idCaracteristiques;
    }

    public void setIdCaracteristiques(OrclassCaracteristiques idCaracteristiques) {
        this.idCaracteristiques = idCaracteristiques;
    }

    public Boolean getValeurBoolean() {
        return valeurBoolean;
    }

    public void setValeurBoolean(Boolean valeurBoolean) {
        this.valeurBoolean = valeurBoolean;
    }

    public String getValeurTexte() {
        return valeurTexte;
    }

    public void setValeurTexte(String valeurTexte) {
        this.valeurTexte = valeurTexte;
    }

    public String getValeurCaracteristique() {
        return valeurCaracteristique;
    }

    public void setValeurCaracteristique(String valeurCaracteristique) {
        this.valeurCaracteristique = valeurCaracteristique;
    }

    public BigDecimal getValeurNumerique() {
        return valeurNumerique;
    }

    public void setValeurNumerique(BigDecimal valeurNumerique) {
        this.valeurNumerique = valeurNumerique;
    }

    public String getValeurCode() {
        return valeurCode;
    }

    public void setValeurCode(String valeurCode) {
        this.valeurCode = valeurCode;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDateValeur() {
        return dateValeur;
    }

    public void setDateValeur(Date dateValeur) {
        this.dateValeur = dateValeur;
    }

    public OrclassCategories getIdCategories() {
        return idCategories;
    }

    public void setIdCategories(OrclassCategories idCategories) {
        this.idCategories = idCategories;
    }

    public OrclassAvenant getIdAvenant() {
        return idAvenant;
    }

    public void setIdAvenant(OrclassAvenant idAvenant) {
        this.idAvenant = idAvenant;
    }

    public Orclass_TypeAvenant getTypeAvenant() {
        return typeAvenant;
    }

    public void setTypeAvenant(Orclass_TypeAvenant typeAvenant) {
        this.typeAvenant = typeAvenant;
    }

    public Boolean getModifier() {
        return modifier;
    }

    public void setModifier(Boolean modifier) {
        this.modifier = modifier;
    }

    public Boolean getAjouter() {
        return ajouter;
    }

    public void setAjouter(Boolean ajouter) {
        this.ajouter = ajouter;
    }

    public Boolean getRetire_de_la_police() {
        return retire_de_la_police;
    }

    public void setRetire_de_la_police(Boolean retire_de_la_police) {
        this.retire_de_la_police = retire_de_la_police;
    }

    public Long getCodeid_retirer() {
        return codeid_retirer;
    }

    public void setCodeid_retirer(Long codeid_retirer) {
        this.codeid_retirer = codeid_retirer;
    }

    public OrclasseRefGroupe getIdGroup() {
        return idGroup;
    }

    public void setIdGroup(OrclasseRefGroupe idGroup) {
        this.idGroup = idGroup;
    }

    public Boolean getAfficher() {
        return afficher;
    }

    public void setAfficher(Boolean afficher) {
        this.afficher = afficher;
    }

    public String getValeur() {
        if (this.getValeurBoolean() != null) {
            if (Objects.equals(this.getValeurBoolean(), Boolean.TRUE)) {
                this.setValeur("Oui");

            } else if (Objects.equals(this.getValeurBoolean(), Boolean.FALSE)) {
                this.setValeur("Non");

            }

        } else if (this.getDateValeur() != null) {
            this.setValeur(GlobalFonctions.formatDate(this.getDateValeur()));

        } else if (this.getValeurCode() != null) {

            this.setValeur(this.getValeurCode());
        } else if (this.getValeurNumerique() != null && this.getValeurNumerique().intValue() != 0) {
            this.setValeur(GlobalFonctions.formatNumberGeneral(this.getValeurNumerique().longValue()));

        }
        return valeur;
    }

    public void setValeur(String valeur) {
        this.valeur = valeur;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrclassPoliceCaracteristique)) {
            return false;
        }
        OrclassPoliceCaracteristique other = (OrclassPoliceCaracteristique) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modele.OrclassPoliceCaracteristique[ id=" + id + " ]";
    }

}
