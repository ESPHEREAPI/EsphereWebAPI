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
@Table(name = "ORCLASS_ROLES_DONNEES")
//@XmlRootElement
public class OrclassRolesDonnees implements DAOEntry {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_ROLE_DONNEE")
    private Short idRoleDonnee;
    @JoinColumn(name = "ID_BRANCHE", referencedColumnName = "ID_BRANCHE")
    @ManyToOne
    private OrclassBranches idBranche;
    @JoinColumn(name = "ID_CATEGORIE", referencedColumnName = "ID_CATEGORIE")
    @ManyToOne
    private OrclassCategories idCategorie;
    @JoinColumn(name = "ID_INTERMEDIAIRE", referencedColumnName = "ID_INTERMEDIAIRE")
    @ManyToOne
    private OrclassIntermediaires idIntermediaire;
    @JoinColumn(name = "ID_ROLE", referencedColumnName = "ID_ROLE")
    @ManyToOne(optional = false)
    private OrclassRoless idRole;

    public OrclassRolesDonnees() {
    }

    public OrclassRolesDonnees(Short idRoleDonnee) {
        this.idRoleDonnee = idRoleDonnee;
    }

    public Short getIdRoleDonnee() {
        return idRoleDonnee;
    }

    public void setIdRoleDonnee(Short idRoleDonnee) {
        this.idRoleDonnee = idRoleDonnee;
    }

    public OrclassBranches getIdBranche() {
        return idBranche;
    }

    public void setIdBranche(OrclassBranches idBranche) {
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRoleDonnee != null ? idRoleDonnee.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrclassRolesDonnees)) {
            return false;
        }
        OrclassRolesDonnees other = (OrclassRolesDonnees) object;
        if ((this.idRoleDonnee == null && other.idRoleDonnee != null) || (this.idRoleDonnee != null && !this.idRoleDonnee.equals(other.idRoleDonnee))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modele.OrclassRolesDonnees[ idRoleDonnee=" + idRoleDonnee + " ]";
    }
    
}
