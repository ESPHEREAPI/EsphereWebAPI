/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import enums.LibelleBranche;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author hp
 */
@Entity
//@MappedSuperclass
@Table(name = "ORCLASS_BRANCHES")
//@XmlRootElement
public class OrclassBranches implements DAOEntry {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_BRANCHE")
    private Short idBranche;
    @Size(max = 32)
    @Column(name = "CODE")
    private String code;
//    @Size(max = 255)
    @Enumerated(EnumType.STRING)
    @Column(name = "LIBELLE")
    private LibelleBranche libelle;
    String libelleAutre;
    @Column(name = "DATE_CREATION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreation;
    @Column(name = "DATE_MODIFICATION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateModification;
    @JoinColumn(name = "ID_CLASSE", referencedColumnName = "ID_CLASSE")
    @ManyToOne(optional = false)
    private OrclassClasses idClasse;
    @JoinColumn(name = "ID_ENTREPRISE", referencedColumnName = "ID_ENTREPRISE")
    @ManyToOne(optional = true)
    private OrclassEntreprises idEntreprise;
    @OneToMany(mappedBy = "idBranche")
    private List<OrclassRolesDonnees> orclassRolesDonneesList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idBranche")
    private List<OrclassCategories> orclassCategoriesList;
    Boolean showAllCompagnies = Boolean.FALSE;
    private BigInteger codePrincipal=BigInteger.ZERO;

    public OrclassBranches() {
        idClasse = new OrclassClasses();
        this.dateCreation = new Date();
    }

    public OrclassBranches(Short idBranche) {
        this.idBranche = idBranche;
    }

    public Short getIdBranche() {
        return idBranche;
    }

    public void setIdBranche(Short idBranche) {
        this.idBranche = idBranche;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public LibelleBranche getLibelle() {
        return libelle;
    }

    public void setLibelle(LibelleBranche libelle) {
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

    public OrclassClasses getIdClasse() {
        return idClasse;
    }

    public void setIdClasse(OrclassClasses idClasse) {
        this.idClasse = idClasse;
    }

    public OrclassEntreprises getIdEntreprise() {
        return idEntreprise;
    }

    public void setIdEntreprise(OrclassEntreprises idEntreprise) {
        this.idEntreprise = idEntreprise;
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

    @XmlTransient
    public List<OrclassCategories> getOrclassCategoriesList() {
        return orclassCategoriesList;
    }

    public void setOrclassCategoriesList(List<OrclassCategories> orclassCategoriesList) {
        this.orclassCategoriesList = orclassCategoriesList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idBranche != null ? idBranche.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrclassBranches)) {
            return false;
        }
        OrclassBranches other = (OrclassBranches) object;
        if ((this.idBranche == null && other.idBranche != null) || (this.idBranche != null && !this.idBranche.equals(other.idBranche))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modele.OrclassBranches[ code=" + code + " ]";
    }

    public BigInteger getCodePrincipal() {
        return codePrincipal;
    }

    public void setCodePrincipal(BigInteger codePrincipal) {
        this.codePrincipal = codePrincipal;
    }
    
    

}
