/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import enums.LibelleBranche;
import enums.LibelleCategorie;
import enums.ModeApplicationSante;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author hp
 */
//@MappedSuperclass
@Entity
@Table(name = "ORCLASS_CATEGORIES")
//@XmlRootElement
public class OrclassCategories implements DAOEntry {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_CATEGORIE")
    private Short idCategorie;
    @Size(max = 32)
    @Column(name = "CODE")
    private String code;
    @Enumerated(EnumType.STRING)
    @Column(name = "LIBELLE")
    private LibelleCategorie libelle;
    @Column(name = "DATE_CREATION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreation;
    @Column(name = "DATE_MODIFICATION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateModification;
    @OneToMany(mappedBy = "idCategorie")
    private List<OrclassRolesDonnees> orclassRolesDonneesList;
    @JoinColumn(name = "ID_BRANCHE", referencedColumnName = "ID_BRANCHE")
    @ManyToOne(optional = false)
    private OrclassBranches idBranche;
    @JoinColumn(name = "ID_ENTREPRISE", referencedColumnName = "ID_ENTREPRISE")
    @ManyToOne(optional = true)
    private OrclassEntreprises idEntreprise;
    @OneToMany(mappedBy = "idCategorie")
    private List<OrclassUtilisateursDonnees> orclassUtilisateursDonneesList;
    
    Boolean showAllCompagnies = Boolean.FALSE;
    String libelleAutre;
     @Enumerated(EnumType.STRING)
    @Column(name = "MODE_APPLICATION")
    private ModeApplicationSante modeApplicationSante;
     private BigInteger codePrincipal=BigInteger.ZERO;
     
//     @Transient
     @Column(name = "CAT_VEHICULE")
     private Integer categoriesVehicule=0;

    public OrclassCategories() {
        idBranche = new OrclassBranches();
    }

    public OrclassCategories(Short idCategorie) {
        this.idCategorie = idCategorie;
    }

    public Short getIdCategorie() {
        return idCategorie;
    }

    public void setIdCategorie(Short idCategorie) {
        this.idCategorie = idCategorie;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public LibelleCategorie getLibelle() {
        return libelle;
    }

    public void setLibelle(LibelleCategorie libelle) {
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

    public Boolean getShowAllCompagnies() {
        return showAllCompagnies;
    }

    public void setShowAllCompagnies(Boolean showAllCompagnies) {
        this.showAllCompagnies = showAllCompagnies;
    }

    public String getLibelleAutre() {
        return libelleAutre;
    }

    public void setLibelleAutre(String libelleAutre) {
        this.libelleAutre = libelleAutre;
    }

    @XmlTransient
    public List<OrclassRolesDonnees> getOrclassRolesDonneesList() {
        return orclassRolesDonneesList;
    }

    public void setOrclassRolesDonneesList(List<OrclassRolesDonnees> orclassRolesDonneesList) {
        this.orclassRolesDonneesList = orclassRolesDonneesList;
    }

    public OrclassBranches getIdBranche() {
        return idBranche;
    }

    public void setIdBranche(OrclassBranches idBranche) {
        this.idBranche = idBranche;
    }

    public OrclassEntreprises getIdEntreprise() {
        return idEntreprise;
    }

    public void setIdEntreprise(OrclassEntreprises idEntreprise) {
        this.idEntreprise = idEntreprise;
    }

    @XmlTransient
    public List<OrclassUtilisateursDonnees> getOrclassUtilisateursDonneesList() {
        return orclassUtilisateursDonneesList;
    }

    public void setOrclassUtilisateursDonneesList(List<OrclassUtilisateursDonnees> orclassUtilisateursDonneesList) {
        this.orclassUtilisateursDonneesList = orclassUtilisateursDonneesList;
    }

    public ModeApplicationSante getModeApplicationSante() {
        return modeApplicationSante;
    }

    public void setModeApplicationSante(ModeApplicationSante modeApplicationSante) {
        this.modeApplicationSante = modeApplicationSante;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCategorie != null ? idCategorie.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrclassCategories)) {
            return false;
        }
        OrclassCategories other = (OrclassCategories) object;
        if ((this.idCategorie == null && other.idCategorie != null) || (this.idCategorie != null && !this.idCategorie.equals(other.idCategorie))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modele.OrclassCategories[ code=" + code + " ]";
    }

    public BigInteger getCodePrincipal() {
        return codePrincipal;
    }

    public void setCodePrincipal(BigInteger codePrincipal) {
        this.codePrincipal = codePrincipal;
    }

    public Integer getCategoriesVehicule() {
        return categoriesVehicule;
    }

    public void setCategoriesVehicule(Integer categoriesVehicule) {
        this.categoriesVehicule = categoriesVehicule;
    }
    

}
