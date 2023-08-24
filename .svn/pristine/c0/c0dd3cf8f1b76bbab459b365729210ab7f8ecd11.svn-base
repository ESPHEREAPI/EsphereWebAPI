/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;



import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

/**
 *
 * @author admin
 */
@Entity
@Table(name = "ORCLASS_EXONERATION_TAXE", uniqueConstraints = @UniqueConstraint(columnNames = {"ID_EXONERATION", "ID_TYPE_TAXE","ID_ENTREPRISE"}))
public class OrclassExonerationTaxe implements DAOEntry {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_EXONERATION_TAXE")
   @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idExonerationTaxe;
    
    @JoinColumn(name = "ID_EXONERATION", referencedColumnName = "ID_EXONERATION")
    @ManyToOne(optional = false)
    private OrclassExoneration idExoneration;
    
     @JoinColumn(name = "ID_TYPE_TAXE", referencedColumnName = "ID_TYPE_TAXE")
    @ManyToOne(optional = true)
    private OrclassTypeTaxe idTypeTaxe;
       @JoinColumn(name = "ID_REF_TIMBRE", referencedColumnName = "ID_REF_TIMBRE")
    @ManyToOne(optional = true)
     private OrclassRefTimbreGradue idRefTimbreGradue;
    
        @JoinColumn(name = "ID_ENTREPRISE", referencedColumnName = "ID_ENTREPRISE")
    @ManyToOne(optional = false)
    private OrclassEntreprises idEntreprises;
   
    public OrclassExonerationTaxe() {
        idExoneration= new OrclassExoneration();
//        idTypeTaxe= new OrclassTypeTaxe();
    }

    public Long getIdExonerationTaxe() {
        return idExonerationTaxe;
    }

    public void setIdExonerationTaxe(Long idExonerationTaxe) {
        this.idExonerationTaxe = idExonerationTaxe;
    }

    public OrclassExoneration getIdExoneration() {
        return idExoneration;
    }

    public void setIdExoneration(OrclassExoneration idExoneration) {
        this.idExoneration = idExoneration;
    }

    public OrclassTypeTaxe getIdTypeTaxe() {
        return idTypeTaxe;
    }

    public void setIdTypeTaxe(OrclassTypeTaxe idTypeTaxe) {
        this.idTypeTaxe = idTypeTaxe;
    }

    public OrclassEntreprises getIdEntreprises() {
        return idEntreprises;
    }

    public void setIdEntreprises(OrclassEntreprises idEntreprises) {
        this.idEntreprises = idEntreprises;
    }

    public OrclassRefTimbreGradue getIdRefTimbreGradue() {
        return idRefTimbreGradue;
    }

    public void setIdRefTimbreGradue(OrclassRefTimbreGradue idRefTimbreGradue) {
        this.idRefTimbreGradue = idRefTimbreGradue;
    }

  
   

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idExonerationTaxe != null ? idExonerationTaxe.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrclassExonerationTaxe)) {
            return false;
        }
        OrclassExonerationTaxe other = (OrclassExonerationTaxe) object;
        if ((this.idExonerationTaxe == null && other.idExonerationTaxe != null) || (this.idExonerationTaxe != null && !this.idExonerationTaxe.equals(other.idExonerationTaxe))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modele.OrclassExonerationTaxe[ idExonerationTaxe=" + idExonerationTaxe + " ]";
    }
    
}
