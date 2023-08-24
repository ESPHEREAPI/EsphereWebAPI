/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author hp
 */
//@MappedSuperclass
@Entity
@Table(name = "ORCLASS_ROLESS")
//@XmlRootElement
public class OrclassRoless implements DAOEntry {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_ROLE")
    private Short idRole;
    @Size(max = 32)
    @Column(name = "CODE")
    private String code;
    @Size(max = 255)
    @Column(name = "LIBELLE")
    private String libelle;
    @Column(name = "ACTIF")
    private Short actif;
    @Column(name = "DATE_CREATION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreation;
    @Column(name = "DATE_MODIFICATION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateModification;
    @JoinTable(name = "ORCLASS_ROLES_UTILISATEURS", joinColumns = {
        @JoinColumn(name = "ID_ROLE", referencedColumnName = "ID_ROLE")}, inverseJoinColumns = {
        @JoinColumn(name = "ID_UTILISATEUR", referencedColumnName = "ID_UTILISATEUR")})
    @ManyToMany
    private List<OrclassUtilisateurs> orclassUtilisateursList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idRole")
    private List<OrclassRolesDonnees> orclassRolesDonneesList;
    @OneToMany(mappedBy = "idRole")
    private List<OrclassUtilisateursDonnees> orclassUtilisateursDonneesList;

    public OrclassRoless() {
    }

    public OrclassRoless(Short idRole) {
        this.idRole = idRole;
    }

    public Short getIdRole() {
        return idRole;
    }

    public void setIdRole(Short idRole) {
        this.idRole = idRole;
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

    public Short getActif() {
        return actif;
    }

    public void setActif(Short actif) {
        this.actif = actif;
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

    @XmlTransient
    public List<OrclassUtilisateurs> getOrclassUtilisateursList() {
        return orclassUtilisateursList;
    }

    public void setOrclassUtilisateursList(List<OrclassUtilisateurs> orclassUtilisateursList) {
        this.orclassUtilisateursList = orclassUtilisateursList;
    }

    @XmlTransient
    public List<OrclassRolesDonnees> getOrclassRolesDonneesList() {
        return orclassRolesDonneesList;
    }

    public void setOrclassRolesDonneesList(List<OrclassRolesDonnees> orclassRolesDonneesList) {
        this.orclassRolesDonneesList = orclassRolesDonneesList;
    }

    @XmlTransient
    public List<OrclassUtilisateursDonnees> getOrclassUtilisateursDonneesList() {
        return orclassUtilisateursDonneesList;
    }

    public void setOrclassUtilisateursDonneesList(List<OrclassUtilisateursDonnees> orclassUtilisateursDonneesList) {
        this.orclassUtilisateursDonneesList = orclassUtilisateursDonneesList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRole != null ? idRole.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrclassRoless)) {
            return false;
        }
        OrclassRoless other = (OrclassRoless) object;
        if ((this.idRole == null && other.idRole != null) || (this.idRole != null && !this.idRole.equals(other.idRole))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modele.OrclassRoless[ idRole=" + idRole + " ]";
    }
    
}
