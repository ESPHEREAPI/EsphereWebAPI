/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.io.Serializable;
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
import javax.validation.constraints.Size;

/**
 *
 * @author hp
 */
@Entity
@Table(name = "ORCLASS_RUBRIQUE")
public class OrclassRubrique implements DAOEntry {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    @Column(name = "ID_RUBRIQUE")
    private Long id;

    @Size(max = 32)
    @Column(name = "CODE", unique = true)
    private String code;
    @Size(max = 255)
    @Column(name = "LIBELLE", unique = false)
    private String libelle;
     private String natrubta;
    @Column(name = "DATE_CREATION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreation;
    @Column(name = "DATE_MODIFICATION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateModification;
    @JoinColumn(name = "ID_ENTREPRISE", referencedColumnName = "ID_ENTREPRISE")
    @ManyToOne(optional = true)
    private OrclassEntreprises idEntreprise;
       Boolean showAllCompagnies = Boolean.FALSE;
       Boolean primeNette =Boolean.FALSE;

    public OrclassRubrique(String code, String libelle, String natrubta) {
        this.code = code;
        this.libelle = libelle;
        this.natrubta = natrubta;
        primeNette=Boolean.FALSE;
    }

    
    
    public OrclassRubrique() {
        
    }

    public String getNatrubta() {
        return natrubta;
    }

    public void setNatrubta(String natrubta) {
        this.natrubta = natrubta;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getShowAllCompagnies() {
        return showAllCompagnies;
    }

    public void setShowAllCompagnies(Boolean showAllCompagnies) {
        this.showAllCompagnies = showAllCompagnies;
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
        if (!(object instanceof OrclassRubrique)) {
            return false;
        }
        OrclassRubrique other = (OrclassRubrique) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modele.Rubrique[ id=" + id + " ]";
    }

    public Boolean getPrimeNette() {
        return primeNette;
    }

    public void setPrimeNette(Boolean primeNette) {
        this.primeNette = primeNette;
    }
    

}
