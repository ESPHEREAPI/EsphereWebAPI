/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.math.BigDecimal;
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
import javax.validation.constraints.NotNull;

/**
 *
 * @author hp
 */
@Entity
@Table(name = "ORCLASS_COM_PRIME_APP")
public class OrclassCommission_Prime_Apporteur implements DAOEntry {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    @Column(name = "ID_COM_PRIME_APP")
    private Long id;

    @Column(name = "DATE_CREATION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreation;
    @Column(name = "DATE_MODIFICATION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateModification;
    @JoinColumn(name = "ID_ENTREPRISE", referencedColumnName = "ID_ENTREPRISE")
    @ManyToOne(optional = false)
    private OrclassEntreprises idEntreprise;
    @JoinColumn(name = "ID_APPORTEUR", referencedColumnName = "ID_APPORTEUR")
    @ManyToOne(optional = true)
    private OrclassApporteur idApporteur;

    @JoinColumn(name = "ID_TYPEAPPORTEUR", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private OrclassTypeApporteur idTypeApporteur;
    @JoinColumn(name = "ID_CATEGORIE", referencedColumnName = "ID_CATEGORIE")
    @ManyToOne(optional = false)
    private OrclassCategories idCategories;
    @JoinColumn(name = "ID_GARANTIE", referencedColumnName = "ID_GARANTIE")
    @ManyToOne(optional = true)
    private OrclassGarantie idGarantie;

    BigDecimal taux_apport = BigDecimal.ZERO;
    BigDecimal taux_gestion = BigDecimal.ZERO;
    @Column(name = "DATE_EFFET")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date_effet;
    Boolean actif = Boolean.FALSE;

    public OrclassCommission_Prime_Apporteur() {
        idCategories = new OrclassCategories();
        idTypeApporteur = new OrclassTypeApporteur();
        this.dateCreation = new Date();
        actif = Boolean.TRUE;
        taux_apport = BigDecimal.ZERO;
        taux_gestion = BigDecimal.ZERO;

    }

    public OrclassCommission_Prime_Apporteur(BigDecimal taux_apport, BigDecimal taux_gestion, Date dateEffet) {
        this.actif = Boolean.TRUE;
        this.dateCreation = new Date();
        this.taux_apport = taux_apport;
        this.taux_gestion = taux_gestion;
        this.date_effet = dateEffet;

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

    public OrclassApporteur getIdApporteur() {
        return idApporteur;
    }

    public void setIdApporteur(OrclassApporteur idApporteur) {
        this.idApporteur = idApporteur;
    }

    public OrclassTypeApporteur getIdTypeApporteur() {
        return idTypeApporteur;
    }

    public void setIdTypeApporteur(OrclassTypeApporteur idTypeApporteur) {
        this.idTypeApporteur = idTypeApporteur;
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

    public BigDecimal getTaux_apport() {
        return taux_apport;
    }

    public void setTaux_apport(BigDecimal taux_apport) {
        this.taux_apport = taux_apport;
    }

    public BigDecimal getTaux_gestion() {
        return taux_gestion;
    }

    public void setTaux_gestion(BigDecimal taux_gestion) {
        this.taux_gestion = taux_gestion;
    }

    public Date getDate_effet() {
        return date_effet;
    }

    public void setDate_effet(Date date_effet) {
        this.date_effet = date_effet;
    }

    public Boolean getActif() {
        return actif;
    }

    public void setActif(Boolean actif) {
        this.actif = actif;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
        if (!(object instanceof OrclassCommission_Prime_Apporteur)) {
            return false;
        }
        OrclassCommission_Prime_Apporteur other = (OrclassCommission_Prime_Apporteur) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modele.Commission_Prime_Apporteur[ id=" + id + " ]";
    }

}
