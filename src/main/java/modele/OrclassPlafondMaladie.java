/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import enums.DomaineApplication;
import enums.LibelleCategorie;
import enums.ModeControle;
import enums.UniteDuree;
import java.math.BigDecimal;
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
import javax.validation.constraints.NotNull;

/**
 *
 * @author hp
 */
@Entity
@Table(name = "ORCLASS_PLAFOND_MALADIE")
public class OrclassPlafondMaladie implements DAOEntry {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    @Column(name = "ID_PLAFOND")
    private Long id;
    String code;
    String libelle;
    BigDecimal montant;
    BigDecimal nombre_Acte;
    BigDecimal priode;
    @Column(name = "DATE_CREATION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreation;
    @Column(name = "DATE_MODIFICATION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateModification;
    @JoinColumn(name = "ID_ENTREPRISE", referencedColumnName = "ID_ENTREPRISE")
    @ManyToOne(optional = false)
    private OrclassEntreprises idEntreprise;
    @Enumerated(EnumType.STRING)
    @Column(name = "DOMAINE_APPLICATION")
    private DomaineApplication domaine_application;
    @Enumerated(EnumType.STRING)
    @Column(name = "MODE_CONTROLE")
    private ModeControle modeControle;
     @Column(name = "UNITE_DUREE")
    @Enumerated(EnumType.STRING)
    private UniteDuree uniteDuree;

    public OrclassPlafondMaladie() {

    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public BigDecimal getMontant() {
        return montant;
    }

    public void setMontant(BigDecimal montant) {
        this.montant = montant;
    }

    public BigDecimal getNombre_Acte() {
        return nombre_Acte;
    }

    public void setNombre_Acte(BigDecimal nombre_Acte) {
        this.nombre_Acte = nombre_Acte;
    }

    public BigDecimal getPriode() {
        return priode;
    }

    public void setPriode(BigDecimal priode) {
        this.priode = priode;
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

    public OrclassEntreprises getIdEntreprise() {
        return idEntreprise;
    }

    public void setIdEntreprise(OrclassEntreprises idEntreprise) {
        this.idEntreprise = idEntreprise;
    }

    public DomaineApplication getDomaine_application() {
        return domaine_application;
    }

    public void setDomaine_application(DomaineApplication domaine_application) {
        this.domaine_application = domaine_application;
    }

    public ModeControle getModeControle() {
        return modeControle;
    }

    public void setModeControle(ModeControle modeControle) {
        this.modeControle = modeControle;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UniteDuree getUniteDuree() {
        return uniteDuree;
    }

    public void setUniteDuree(UniteDuree uniteDuree) {
        this.uniteDuree = uniteDuree;
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
        if (!(object instanceof OrclassPlafondMaladie)) {
            return false;
        }
        OrclassPlafondMaladie other = (OrclassPlafondMaladie) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modele.OrclassPlafond[ id=" + id + " ]";
    }

}
