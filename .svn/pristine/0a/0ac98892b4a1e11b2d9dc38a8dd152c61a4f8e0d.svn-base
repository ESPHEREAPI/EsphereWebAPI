/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author hp
 */
@Entity
public class OrclassRubriquePrestation implements DAOEntry {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    @Column(name = "ID_RUB_PREST")
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
    @JoinColumn(name = "ID_RUB_CAT", referencedColumnName = "ID_RUB_CAT")
    @ManyToOne(optional = false)
    private OrclassRubriqueCategorie idRubriqueCategorie;
     @JoinColumn(name = "ID_PRESTATION", referencedColumnName = "ID_PRESTATION")
    @ManyToOne(optional = false)
    private OrclassPrestation idPrestation;

    public OrclassRubriquePrestation() {
        idPrestation=new OrclassPrestation();
       idRubriqueCategorie=new OrclassRubriqueCategorie();
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

    public OrclassRubriqueCategorie getIdRubriqueCategorie() {
        return idRubriqueCategorie;
    }

    public void setIdRubriqueCategorie(OrclassRubriqueCategorie idRubriqueCategorie) {
        this.idRubriqueCategorie = idRubriqueCategorie;
    }

    public OrclassPrestation getIdPrestation() {
        return idPrestation;
    }

    public void setIdPrestation(OrclassPrestation idPrestation) {
        this.idPrestation = idPrestation;
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
        if (!(object instanceof OrclassRubriquePrestation)) {
            return false;
        }
        OrclassRubriquePrestation other = (OrclassRubriquePrestation) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modele.OrclassRubriquePrestation[ id=" + id + " ]";
    }

}
