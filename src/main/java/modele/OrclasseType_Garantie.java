/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import enums.LibelleCategorie;
import enums.TypeGarantie;
import java.io.Serializable;
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

/**
 *
 * @author hp
 */
@Entity
@Table(name = "ORCLASS_TYPE_GARANTIE")
public class OrclasseType_Garantie implements DAOEntry {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_TYPE_GARANTIE")
    private Long id;
    String Code;
    @Enumerated(EnumType.STRING)
    @Column(name = "LIBELLE")
    private TypeGarantie libelle;
    String libelleAutre;

    @JoinColumn(name = "ID_ENTREPRISE", referencedColumnName = "ID_ENTREPRISE")
    @ManyToOne(optional = true)
    private OrclassEntreprises idEntreprise;
    @Column(name = "DATE_CREATION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreation;
    @Column(name = "DATE_MODIFICATION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateModification;
    Boolean showAllCompagnies = Boolean.FALSE;

    public OrclasseType_Garantie() {
        this.dateCreation = new Date();

    }

    public OrclasseType_Garantie(String Code, TypeGarantie libelle) {
        this.Code = Code;
        this.libelle = libelle;
        this.dateCreation = new Date();
    }

    public String getCode() {
        return Code;
    }

    public void setCode(String Code) {
        this.Code = Code;
    }

    public TypeGarantie getLibelle() {
        return libelle;
    }

    public void setLibelle(TypeGarantie libelle) {
        this.libelle = libelle;
    }

    public String getLibelleAutre() {
        return libelleAutre;
    }

    public void setLibelleAutre(String libelleAutre) {
        this.libelleAutre = libelleAutre;
    }

    public OrclassEntreprises getIdEntreprise() {
        return idEntreprise;
    }

    public void setIdEntreprise(OrclassEntreprises idEntreprise) {
        this.idEntreprise = idEntreprise;
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

    public Boolean getShowAllCompagnies() {
        return showAllCompagnies;
    }

    public void setShowAllCompagnies(Boolean showAllCompagnies) {
        this.showAllCompagnies = showAllCompagnies;
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
        if (!(object instanceof OrclasseType_Garantie)) {
            return false;
        }
        OrclasseType_Garantie other = (OrclasseType_Garantie) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modele.OrclasseType_Garantie[ id=" + id + " ]";
    }

}
