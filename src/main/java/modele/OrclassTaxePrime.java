/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import enums.BaseCalculTaxePrime;
import enums.BaseTaxePrime;
import enums.NatureTypeTaxe;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
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
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

/**
 *
 * @author JIATOU FRANCK
 */
@Entity
@Table(name = "ORCLASS_TAXE_PRIME", uniqueConstraints = @UniqueConstraint(columnNames = {"ID_ENTREPRISE", "ID_CATEGORIE", "ID_TYPE_TAXE", "ID_RG_TAXE", "DATE_EFFET"}))
public class OrclassTaxePrime implements DAOEntry {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    @Column(name = "ID_TAXE_PRIME")
    private Long id;

    @JoinColumn(name = "ID_ENTREPRISE", referencedColumnName = "ID_ENTREPRISE")
    @ManyToOne(optional = false)
    private OrclassEntreprises idEntreprise;
    @JoinColumn(name = "ID_CATEGORIE", referencedColumnName = "ID_CATEGORIE")
    @ManyToOne(optional = false)
    private OrclassCategories idCategories;
    @JoinColumn(name = "ID_GARANTIE", referencedColumnName = "ID_GARANTIE")
    @ManyToOne(optional = true)
    private OrclassGarantie idGarantie;
    @JoinColumn(name = "ID_TYPE_TAXE", referencedColumnName = "ID_TYPE_TAXE")
    @ManyToOne(optional = false)
    private OrclassTypeTaxe idTypeTaxe;
    @JoinColumn(name = "ID_RG_TAXE", referencedColumnName = "ID_RG_TAXE")
    @ManyToOne(optional = false)
    private OrclassRegimeTaxe idRegimeTaxe;
    @Column(name = "DATE_EFFET")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date_effet;
    @Column(name = "DATE_CREATION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date_creation;
    @Column(name = "DATE_MODIFICATION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date_modification;
    private String saisir_par;
    private String modifier_par;
    private Boolean forfaitaire = Boolean.FALSE;
    private BigDecimal taux = BigDecimal.ZERO;
    BigInteger montant_forfaitaire = BigInteger.ZERO;

    @Column(name = "BASE")
    @Enumerated(EnumType.STRING)
    private BaseTaxePrime baseTaxePrime;
    @Column(name = "BASE_CALCUL")
    @Enumerated(EnumType.STRING)
    private BaseCalculTaxePrime baseCalculTaxePrime;

    public OrclassTaxePrime() {
        idCategories = new OrclassCategories();
        idRegimeTaxe = new OrclassRegimeTaxe();
        idTypeTaxe = new OrclassTypeTaxe();
    }

    public OrclassEntreprises getIdEntreprise() {
        return idEntreprise;
    }

    public void setIdEntreprise(OrclassEntreprises idEntreprise) {
        this.idEntreprise = idEntreprise;
    }

    public OrclassTypeTaxe getIdTypeTaxe() {
        return idTypeTaxe;
    }

    public void setIdTypeTaxe(OrclassTypeTaxe idTypeTaxe) {
        this.idTypeTaxe = idTypeTaxe;
    }

    public OrclassRegimeTaxe getIdRegimeTaxe() {
        return idRegimeTaxe;
    }

    public void setIdRegimeTaxe(OrclassRegimeTaxe idRegimeTaxe) {
        this.idRegimeTaxe = idRegimeTaxe;
    }

    public Date getDate_effet() {
        return date_effet;
    }

    public void setDate_effet(Date date_effet) {
        this.date_effet = date_effet;
    }

    public Boolean getForfaitaire() {
        return forfaitaire;
    }

    public void setForfaitaire(Boolean forfaitaire) {
        this.forfaitaire = forfaitaire;
    }

    public BigDecimal getTaux() {
        return taux;
    }

    public void setTaux(BigDecimal taux) {
        this.taux = taux;
    }

    public BigInteger getMontant_forfaitaire() {
        return montant_forfaitaire;
    }

    public void setMontant_forfaitaire(BigInteger montant_forfaitaire) {
        this.montant_forfaitaire = montant_forfaitaire;
    }

    public BaseTaxePrime getBaseTaxePrime() {
        return baseTaxePrime;
    }

    public void setBaseTaxePrime(BaseTaxePrime baseTaxePrime) {
        this.baseTaxePrime = baseTaxePrime;
    }

    public BaseCalculTaxePrime getBaseCalculTaxePrime() {
        return baseCalculTaxePrime;
    }

    public void setBaseCalculTaxePrime(BaseCalculTaxePrime baseCalculTaxePrime) {
        this.baseCalculTaxePrime = baseCalculTaxePrime;
    }

    public OrclassCategories getIdCategories() {
        return idCategories;
    }

    public void setIdCategories(OrclassCategories idCategories) {
        this.idCategories = idCategories;
    }

    public OrclassGarantie getIdGarantie() {
        return idGarantie;
    }

    public void setIdGarantie(OrclassGarantie idGarantie) {
        this.idGarantie = idGarantie;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate_creation() {
        return date_creation;
    }

    public void setDate_creation(Date date_creation) {
        this.date_creation = date_creation;
    }

    public Date getDate_modification() {
        return date_modification;
    }

    public void setDate_modification(Date date_modification) {
        this.date_modification = date_modification;
    }

    public String getSaisir_par() {
        return saisir_par;
    }

    public void setSaisir_par(String saisir_par) {
        this.saisir_par = saisir_par;
    }

    public String getModifier_par() {
        return modifier_par;
    }

    public void setModifier_par(String modifier_par) {
        this.modifier_par = modifier_par;
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
        if (!(object instanceof OrclassTaxePrime)) {
            return false;
        }
        OrclassTaxePrime other = (OrclassTaxePrime) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modele.OrclassTaxePrime[ id=" + id + " ]";
    }

}
