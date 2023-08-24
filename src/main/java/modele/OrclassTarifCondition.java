/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.math.BigInteger;
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
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

/**
 *
 * @author hp
 */
@Entity
@Table(name = "ORCLASS_TARIF_CONDIT", uniqueConstraints = @UniqueConstraint(columnNames = {"ID_ENTREPRISE", "ID_RUB_CARACT", "ID_TARIF"}))
public class OrclassTarifCondition implements DAOEntry {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    @Column(name = "ID_TARIF_COND")
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
    @JoinColumn(name = "ID_RUB_CARACT", referencedColumnName = "ID_RUB_CARACT")
    @ManyToOne(optional = false)
    private OrclassRubriqueCaracteristique idRubriqueCaracteristique;
    @JoinColumn(name = "ID_TARIF", referencedColumnName = "ID_TARIF")
    @ManyToOne(optional = false)
    private OrclassTarif idTarif;

    BigInteger valeurMin;
    BigInteger valeurMax;
    Boolean valeurBoolean;
    Boolean valeurNonNull;
    String valeurTexte;
    String classCode;
    @Transient
    Boolean genre_vehicule = Boolean.FALSE;
    @Transient
    Boolean usage_vehicule = Boolean.FALSE;
    @Transient
    Boolean zone = Boolean.FALSE;
    @Transient
    Boolean energie = Boolean.FALSE;

    public OrclassTarifCondition() {
        idTarif = new OrclassTarif();
        idRubriqueCaracteristique = new OrclassRubriqueCaracteristique();
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

    public OrclassRubriqueCaracteristique getIdRubriqueCaracteristique() {
        return idRubriqueCaracteristique;
    }

    public void setIdRubriqueCaracteristique(OrclassRubriqueCaracteristique idRubriqueCaracteristique) {
        this.idRubriqueCaracteristique = idRubriqueCaracteristique;
    }

    public BigInteger getValeurMin() {
        return valeurMin;
    }

    public void setValeurMin(BigInteger valeurMin) {
        this.valeurMin = valeurMin;
    }

    public BigInteger getValeurMax() {
        return valeurMax;
    }

    public void setValeurMax(BigInteger valeurMax) {
        this.valeurMax = valeurMax;
    }

    public Boolean getValeurBoolean() {
        return valeurBoolean;
    }

    public void setValeurBoolean(Boolean valeurBoolean) {
        this.valeurBoolean = valeurBoolean;
    }

    public Boolean getValeurNonNull() {
        return valeurNonNull;
    }

    public void setValeurNonNull(Boolean valeurNonNull) {
        this.valeurNonNull = valeurNonNull;
    }

    public String getValeurTexte() {
        return valeurTexte;
    }

    public void setValeurTexte(String valeurTexte) {
        this.valeurTexte = valeurTexte;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public OrclassTarif getIdTarif() {
        return idTarif;
    }

    public void setIdTarif(OrclassTarif idTarif) {
        this.idTarif = idTarif;
    }

    public String getClassCode() {
        return classCode;
    }

    public void setClassCode(String classCode) {
        this.classCode = classCode;
    }

    public Boolean getGenre_vehicule() {
        return genre_vehicule;
    }

    public void setGenre_vehicule(Boolean genre_vehicule) {
        this.genre_vehicule = genre_vehicule;
    }

    public Boolean getUsage_vehicule() {
        return usage_vehicule;
    }

    public void setUsage_vehicule(Boolean usage_vehicule) {
        this.usage_vehicule = usage_vehicule;
    }

    public Boolean getZone() {
        return zone;
    }

    public void setZone(Boolean zone) {
        this.zone = zone;
    }

    public Boolean getEnergie() {
        return energie;
    }

    public void setEnergie(Boolean energie) {
        this.energie = energie;
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
        if (!(object instanceof OrclassTarifCondition)) {
            return false;
        }
        OrclassTarifCondition other = (OrclassTarifCondition) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modele.OrclassTraifCondition[ id=" + id + " ]";
    }

}
