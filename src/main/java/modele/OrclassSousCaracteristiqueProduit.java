/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modele;

import enums.SousCaracteristiqueProduitEnum;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author JIATOU FRANCK
 */
@Entity
@Table(name = "ORCLASS_SOUSCARCPD", uniqueConstraints = @UniqueConstraint(columnNames = {"ID_ENTREPRISE", "ID_CATEGORIE", "ID_CARACTERISTIQUE"}))

public class OrclassSousCaracteristiqueProduit implements DAOEntry {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idSousCarPrd;
    @JoinColumn(name = "ID_ENTREPRISE", referencedColumnName = "ID_ENTREPRISE")
    @ManyToOne(optional = false)
    private OrclassEntreprises idEntreprise;

    @JoinColumn(name = "ID_UTILISATEUR", referencedColumnName = "ID_UTILISATEUR")
    @ManyToOne(optional = false)
    private OrclassUtilisateurs idUtilisateurs;
    @JoinColumn(name = "ID_CATEGORIE", referencedColumnName = "ID_CATEGORIE")
    @ManyToOne(optional = false)
    private OrclassCategories idCategories;
    @JoinColumn(name = "ID_CARACTERISTIQUE", referencedColumnName = "ID_CARACTERISTIQUE")// 
    @ManyToOne(optional = false)
    private OrclassCaracteristiques idCaracteristiques;
      @Enumerated(EnumType.STRING)
    private SousCaracteristiqueProduitEnum sousCaracteristiqueProduitEnum;
      private Boolean actifs=Boolean.FALSE;

    public OrclassSousCaracteristiqueProduit() {
       
    }

    public Long getIdSousCarPrd() {
        return idSousCarPrd;
    }

    public void setIdSousCarPrd(Long idSousCarPrd) {
        this.idSousCarPrd = idSousCarPrd;
    }

    public OrclassEntreprises getIdEntreprise() {
        return idEntreprise;
    }

    public void setIdEntreprise(OrclassEntreprises idEntreprise) {
        this.idEntreprise = idEntreprise;
    }

    public OrclassUtilisateurs getIdUtilisateurs() {
        return idUtilisateurs;
    }

    public void setIdUtilisateurs(OrclassUtilisateurs idUtilisateurs) {
        this.idUtilisateurs = idUtilisateurs;
    }

    public OrclassCategories getIdCategories() {
        return idCategories;
    }

    public void setIdCategories(OrclassCategories idCategories) {
        this.idCategories = idCategories;
    }

    public OrclassCaracteristiques getIdCaracteristiques() {
        return idCaracteristiques;
    }

    public void setIdCaracteristiques(OrclassCaracteristiques idCaracteristiques) {
        this.idCaracteristiques = idCaracteristiques;
    }

    public SousCaracteristiqueProduitEnum getSousCaracteristiqueProduitEnum() {
        return sousCaracteristiqueProduitEnum;
    }

    public void setSousCaracteristiqueProduitEnum(SousCaracteristiqueProduitEnum sousCaracteristiqueProduitEnum) {
        this.sousCaracteristiqueProduitEnum = sousCaracteristiqueProduitEnum;
    }

   

    public Boolean getActifs() {
        return actifs;
    }

    public void setActifs(Boolean actifs) {
        this.actifs = actifs;
    }
      

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSousCarPrd != null ? idSousCarPrd.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrclassSousCaracteristiqueProduit)) {
            return false;
        }
        OrclassSousCaracteristiqueProduit other = (OrclassSousCaracteristiqueProduit) object;
        if ((this.idSousCarPrd == null && other.idSousCarPrd != null) || (this.idSousCarPrd != null && !this.idSousCarPrd.equals(other.idSousCarPrd))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modele.OrclassSousCaracteristiqueProduit[ id=" + idSousCarPrd + " ]";
    }

}
