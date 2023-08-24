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
import javax.validation.constraints.NotNull;

/**
 *
 * @author hp
 */
//@MappedSuperclass
@Entity
@Table(name = "ORCLASS_UTILISATEURS_DONNEES")
//@XmlRootElement
public class OrclassUtilisateursDonnees implements DAOEntry {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_UTILISATEUR_DONNEE")
    private Short idUtilisateurDonnee;
    @Column(name = "ID_BRANCHE")
    private Short idBranche;
    @JoinColumn(name = "ID_CATEGORIE", referencedColumnName = "ID_CATEGORIE")
    @ManyToOne
    private OrclassCategories idCategorie;
    @JoinColumn(name = "ID_INTERMEDIAIRE", referencedColumnName = "ID_INTERMEDIAIRE")
    @ManyToOne
    private OrclassIntermediaires idIntermediaire;
    @JoinColumn(name = "ID_ROLE", referencedColumnName = "ID_ROLE")
    @ManyToOne
    private OrclassRoless idRole;
    @JoinColumn(name = "ID_UTILISATEUR", referencedColumnName = "ID_UTILISATEUR")
    @ManyToOne(optional = false)
    private OrclassUtilisateurs idUtilisateur;

    public OrclassUtilisateursDonnees() {
    }

    public OrclassUtilisateursDonnees(Short idUtilisateurDonnee) {
        this.idUtilisateurDonnee = idUtilisateurDonnee;
    }

    public Short getIdUtilisateurDonnee() {
        return idUtilisateurDonnee;
    }

    public void setIdUtilisateurDonnee(Short idUtilisateurDonnee) {
        this.idUtilisateurDonnee = idUtilisateurDonnee;
    }

    public Short getIdBranche() {
        return idBranche;
    }

    public void setIdBranche(Short idBranche) {
        this.idBranche = idBranche;
    }

    public OrclassCategories getIdCategorie() {
        return idCategorie;
    }

    public void setIdCategorie(OrclassCategories idCategorie) {
        this.idCategorie = idCategorie;
    }

    public OrclassIntermediaires getIdIntermediaire() {
        return idIntermediaire;
    }

    public void setIdIntermediaire(OrclassIntermediaires idIntermediaire) {
        this.idIntermediaire = idIntermediaire;
    }

    public OrclassRoless getIdRole() {
        return idRole;
    }

    public void setIdRole(OrclassRoless idRole) {
        this.idRole = idRole;
    }

    public OrclassUtilisateurs getIdUtilisateur() {
        return idUtilisateur;
    }

    public void setIdUtilisateur(OrclassUtilisateurs idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUtilisateurDonnee != null ? idUtilisateurDonnee.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrclassUtilisateursDonnees)) {
            return false;
        }
        OrclassUtilisateursDonnees other = (OrclassUtilisateursDonnees) object;
        if ((this.idUtilisateurDonnee == null && other.idUtilisateurDonnee != null) || (this.idUtilisateurDonnee != null && !this.idUtilisateurDonnee.equals(other.idUtilisateurDonnee))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modele.OrclassUtilisateursDonnees[ idUtilisateurDonnee=" + idUtilisateurDonnee + " ]";
    }
    
}
