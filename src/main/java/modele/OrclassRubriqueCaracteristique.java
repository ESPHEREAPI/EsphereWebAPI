/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import enums.NatureOperationTarif;
import enums.StatutCaracteristique;
import java.io.Serializable;
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
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

/**
 *
 * @author hp
 */
@Entity
@Table(name = "ORCLASS_RUB_CARACTS", uniqueConstraints = @UniqueConstraint(columnNames = {"ID_ENTREPRISE", "ID_CATEGORIE", "ID_CARACTERISTIQUE", "ID_RUB_GAR"}))

public class OrclassRubriqueCaracteristique implements DAOEntry {

    private static final long serialVersionUID = 1L;
    @Id

    @NotNull
    @Column(name = "ID_RUB_CARACT")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @JoinColumn(name = "ID_ENTREPRISE", referencedColumnName = "ID_ENTREPRISE")
    @ManyToOne(optional = false)
    private OrclassEntreprises idEntreprise;
//    @JoinColumn(name = "ID_RUBRIQUE", referencedColumnName = "ID_RUBRIQUE")
//    @ManyToOne(optional = false)
//    private OrclassRubrique idRubrique;
    @JoinColumn(name = "ID_RUB_GAR", referencedColumnName = "ID_RUB_GAR")
    @ManyToOne(optional = false)
    private OrclassRubriqueGarantie idRubriqueGarantie;// elle permetra de faire un trie desc incluant ainsi la rubrique et la garantie en meme temps
    @JoinColumn(name = "ID_CARACTERISTIQUE", referencedColumnName = "ID_CARACTERISTIQUE")// 
    @ManyToOne(optional = false)
    private OrclassCaracteristiques idCaracteristiques;
    @JoinColumn(name = "ID_CATEGORIE", referencedColumnName = "ID_CATEGORIE")
    @ManyToOne(optional = false)
    private OrclassCategories idCategories;
//    @JoinColumn(name = "ID_GARANTIE", referencedColumnName = "ID_GARANTIE")// la garantie a deja un mode  de calcukl
//    @ManyToOne(optional = false)
//    private OrclassGarantie idGarantie;
    @Enumerated(EnumType.STRING)
    @Column(name = "STATUT")
    private StatutCaracteristique statutCaracteristique;
    @Transient
    private String valeurTexte;
    @Transient
    private String valeurCaracteristique;
    @Transient
    private BigDecimal valeurNumerique;
    @Transient
    private String valeurCode;
    @Transient

    @Temporal(TemporalType.DATE)
    private Date dateValeur;

    public OrclassRubriqueCaracteristique() {
        idCaracteristiques = new OrclassCaracteristiques();
        idCategories = new OrclassCategories();
//        idRubrique = new OrclassRubrique();
//        idGarantie = new OrclassGarantie();
        idRubriqueGarantie = new OrclassRubriqueGarantie();
    }

//    public OrclassGarantie getIdGarantie() {
//        return idGarantie;
//    }
//
//    public void setIdGarantie(OrclassGarantie idGarantie) {
//        this.idGarantie = idGarantie;
//    }

    public OrclassEntreprises getIdEntreprise() {
        return idEntreprise;
    }

    public void setIdEntreprise(OrclassEntreprises idEntreprise) {
        this.idEntreprise = idEntreprise;
    }

////    public OrclassRubrique getIdRubrique() {
////        return idRubrique;
////    }
////
////    public void setIdRubrique(OrclassRubrique idRubrique) {
////        this.idRubrique = idRubrique;
////    }

    public OrclassRubriqueGarantie getIdRubriqueGarantie() {
        return idRubriqueGarantie;
    }

    public void setIdRubriqueGarantie(OrclassRubriqueGarantie idRubriqueGarantie) {
        this.idRubriqueGarantie = idRubriqueGarantie;
    }
    
    

    public OrclassCaracteristiques getIdCaracteristiques() {
        return idCaracteristiques;
    }

    public void setIdCaracteristiques(OrclassCaracteristiques idCaracteristiques) {
        this.idCaracteristiques = idCaracteristiques;
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

    public StatutCaracteristique getStatutCaracteristique() {
        return statutCaracteristique;
    }

    public void setStatutCaracteristique(StatutCaracteristique statutCaracteristique) {
        this.statutCaracteristique = statutCaracteristique;
    }

    public String getValeurTexte() {
        return valeurTexte;
    }

    public void setValeurTexte(String valeurTexte) {
        this.valeurTexte = valeurTexte;
    }

    public String getValeurCaracteristique() {
        return valeurCaracteristique;
    }

    public void setValeurCaracteristique(String valeurCaracteristique) {
        this.valeurCaracteristique = valeurCaracteristique;
    }

    public BigDecimal getValeurNumerique() {
        return valeurNumerique;
    }

    public void setValeurNumerique(BigDecimal valeurNumerique) {
        this.valeurNumerique = valeurNumerique;
    }

    public String getValeurCode() {
        return valeurCode;
    }

    public void setValeurCode(String valeurCode) {
        this.valeurCode = valeurCode;
    }

    public Date getDateValeur() {
        return dateValeur;
    }

    public void setDateValeur(Date dateValeur) {
        this.dateValeur = dateValeur;
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
        if (!(object instanceof OrclassRubriqueCaracteristique)) {
            return false;
        }
        OrclassRubriqueCaracteristique other = (OrclassRubriqueCaracteristique) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modele.OrclassRubriqueCaracteristique[ id=" + id + " ]";
    }

}
