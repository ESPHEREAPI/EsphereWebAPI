/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import enums.NatureRubrique;
import enums.TypeRecoursRubrique;
import enums.UtilisationRubrique;
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
import javax.validation.constraints.NotNull;

/**
 *
 * @author hp
 */
@Entity
@Table(name = "ORCLASS_RUB_CAT")
public class OrclassRubriqueCategorie implements DAOEntry {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    @Column(name = "ID_RUB_CAT")
    private Long id;

    @Column(name = "NATURE")
    @Enumerated(EnumType.STRING)
    NatureRubrique natureRubrique;

    @Column(name = "UTILISATION")
    @Enumerated(EnumType.STRING)
    UtilisationRubrique utilisationRubrique;
    @Column(name = "TYPE_RECOURS")
    @Enumerated(EnumType.STRING)
    TypeRecoursRubrique typeRecoursRubrique;

    Boolean honoraire = Boolean.FALSE;
    int ordre;
    @Column(name = "DATE_CREATION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreation;
    @Column(name = "DATE_MODIFICATION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateModification;
    @JoinColumn(name = "ID_ENTREPRISE", referencedColumnName = "ID_ENTREPRISE")
    @ManyToOne(optional = false)
    private OrclassEntreprises idEntreprise;
    @JoinColumn(name = "ID_RUBRIQUE", referencedColumnName = "ID_RUBRIQUE")
    @ManyToOne(optional = false)
    private OrclassRubrique idRubrique;
    
    @JoinColumn(name = "ID_CATEGORIE", referencedColumnName = "ID_CATEGORIE")
    @ManyToOne(optional = false)
    private OrclassCategories idCategories;

    public OrclassRubriqueCategorie() {
        idCategories= new OrclassCategories();
        idRubrique=new  OrclassRubrique();
    }

    public NatureRubrique getNatureRubrique() {
        return natureRubrique;
    }

    public void setNatureRubrique(NatureRubrique natureRubrique) {
        this.natureRubrique = natureRubrique;
    }

    public UtilisationRubrique getUtilisationRubrique() {
        return utilisationRubrique;
    }

    public void setUtilisationRubrique(UtilisationRubrique utilisationRubrique) {
        this.utilisationRubrique = utilisationRubrique;
    }

    public TypeRecoursRubrique getTypeRecoursRubrique() {
        return typeRecoursRubrique;
    }

    public void setTypeRecoursRubrique(TypeRecoursRubrique typeRecoursRubrique) {
        this.typeRecoursRubrique = typeRecoursRubrique;
    }

    public Boolean getHonoraire() {
        return honoraire;
    }

    public void setHonoraire(Boolean honoraire) {
        this.honoraire = honoraire;
    }

    public int getOrdre() {
        return ordre;
    }

    public void setOrdre(int ordre) {
        this.ordre = ordre;
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

    public OrclassRubrique getIdRubrique() {
        return idRubrique;
    }

    public void setIdRubrique(OrclassRubrique idRubrique) {
        this.idRubrique = idRubrique;
    }

    public OrclassCategories getIdCategories() {
        return idCategories;
    }

    public void setIdCategories(OrclassCategories idCategories) {
        this.idCategories = idCategories;
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
        if (!(object instanceof OrclassRubriqueCategorie)) {
            return false;
        }
        OrclassRubriqueCategorie other = (OrclassRubriqueCategorie) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modele.OrclassRubriqueCategorie[ id=" + id + " ]";
    }

}
