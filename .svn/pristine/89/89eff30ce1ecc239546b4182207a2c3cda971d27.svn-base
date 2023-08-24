/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import enums.ModeCalcul;
import enums.NatureGarantie;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import sante.CaracterisqueGroupeMaladie;

/**
 *
 * @author hp
 */
@Entity
@Table(name = "ORCLASS_GARANTIE")
public class OrclassGarantie implements DAOEntry {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_GARANTIE")
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "NATURE")
    private NatureGarantie natureGarantie;

    @Enumerated(EnumType.STRING)
    @Column(name = "MODE_CALCUL")
    private ModeCalcul modeCalcul;
    @Column(name = "DATE_CREATION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreation;
    @Column(name = "DATE_MODIFICATION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateModification;

    Boolean gratuit = Boolean.FALSE;
    Boolean proarate = Boolean.FALSE;
    Boolean forfaire = Boolean.FALSE;
    Boolean generer_caract = Boolean.FALSE;// cette variable permet la creation dune caracteristique lie a la garantie

    Integer capital_fixe = 0;
    Integer capital_min, capital_max = 0;
    Integer rapport = 0;// ceci permet de calcule le proata pour ceux ayant la possibilite du prorata coment l ajout d un avenant a sachant que la garantie est a 100 pour pour une periode de 1 ans
    Boolean capital_illimitter = Boolean.FALSE;
    @JoinColumn(name = "ID_CATEGORIE", referencedColumnName = "ID_CATEGORIE")
    @ManyToOne(optional = false)
    private OrclassCategories idCategories;
    @JoinColumn(name = "ID_TYPE_GARANTIE", referencedColumnName = "ID_TYPE_GARANTIE")
    @ManyToOne(optional = true)
    private OrclasseType_Garantie idType_Garantie;
    @JoinColumn(name = "ID_REF_GARANTIE", referencedColumnName = "ID_REF_GARANTIE")
    @ManyToOne(optional = false)
    private OrclassRefGaranties idRefGaranties;
    @JoinColumn(name = "ID_ENTREPRISE", referencedColumnName = "ID_ENTREPRISE")
    @ManyToOne(optional = false)
    private OrclassEntreprises idEntreprise;
    private Boolean globalCompagnie = Boolean.FALSE;
    @Transient
    private CaracterisqueGroupeMaladie caracterisqueGroupeMaladie;
   

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

    public OrclassGarantie() {
        this.idCategories = new OrclassCategories();
        this.idRefGaranties = new OrclassRefGaranties();
    }

    public OrclassEntreprises getIdEntreprise() {
        return idEntreprise;
    }

    public void setIdEntreprise(OrclassEntreprises idEntreprise) {
        this.idEntreprise = idEntreprise;
    }

    public NatureGarantie getNatureGarantie() {
        return natureGarantie;
    }

    public void setNatureGarantie(NatureGarantie natureGarantie) {
        this.natureGarantie = natureGarantie;
    }

    public ModeCalcul getModeCalcul() {
        return modeCalcul;
    }

    public void setModeCalcul(ModeCalcul modeCalcul) {
        this.modeCalcul = modeCalcul;
    }

    public Boolean getGratuit() {
        return gratuit;
    }

    public void setGratuit(Boolean gratuit) {
        this.gratuit = gratuit;
    }

    public Boolean getProarate() {
        return proarate;
    }

    public void setProarate(Boolean proarate) {
        this.proarate = proarate;
    }

    public Boolean getGenerer_caract() {
        return generer_caract;
    }

    public void setGenerer_caract(Boolean generer_caract) {
        this.generer_caract = generer_caract;
    }

    public Integer getCapital_fixe() {
        return capital_fixe;
    }

    public void setCapital_fixe(Integer capital_fixe) {
        this.capital_fixe = capital_fixe;
    }

    public Integer getCapital_min() {
        return capital_min;
    }

    public void setCapital_min(Integer capital_min) {
        this.capital_min = capital_min;
    }

    public Integer getCapital_max() {
        return capital_max;
    }

    public void setCapital_max(Integer capital_max) {
        this.capital_max = capital_max;
    }

    public Integer getRapport() {
        return rapport;
    }

    public void setRapport(Integer rapport) {
        this.rapport = rapport;
    }

    public OrclassCategories getIdCategories() {
        return idCategories;
    }

    public void setIdCategories(OrclassCategories idCategories) {
        this.idCategories = idCategories;
    }

    public OrclasseType_Garantie getIdType_Garantie() {
        return idType_Garantie;
    }

    public void setIdType_Garantie(OrclasseType_Garantie idType_Garantie) {
        this.idType_Garantie = idType_Garantie;
    }

    public OrclassRefGaranties getIdRefGaranties() {
        return idRefGaranties;
    }

    public void setIdRefGaranties(OrclassRefGaranties idRefGaranties) {
        this.idRefGaranties = idRefGaranties;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getGlobalCompagnie() {
        return globalCompagnie;
    }

    public void setGlobalCompagnie(Boolean globalCompagnie) {
        this.globalCompagnie = globalCompagnie;
    }

    public CaracterisqueGroupeMaladie getCaracterisqueGroupeMaladie() {
        return caracterisqueGroupeMaladie;
    }

    public void setCaracterisqueGroupeMaladie(CaracterisqueGroupeMaladie caracterisqueGroupeMaladie) {
        this.caracterisqueGroupeMaladie = caracterisqueGroupeMaladie;
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
        if (!(object instanceof OrclassGarantie)) {
            return false;
        }
        OrclassGarantie other = (OrclassGarantie) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modele.OrclassGarantie[ id=" + id + " ]";
    }

    public Boolean getForfaire() {
        return forfaire;
    }

    public void setForfaire(Boolean forfaire) {
        this.forfaire = forfaire;
    }

    public Boolean getCapital_illimitter() {
        return capital_illimitter;
    }

    public void setCapital_illimitter(Boolean capital_illimitter) {
        this.capital_illimitter = capital_illimitter;
    }

   
    
    

}
