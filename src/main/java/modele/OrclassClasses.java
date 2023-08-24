/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import enums.LibelleClasse;
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
//@MappedSuperclass
@Entity
@Table(name = "ORCLASS_CLASSES")
//@XmlRootElement
public class OrclassClasses implements DAOEntry {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_CLASSE")
    private Short idClasse;
    @Size(max = 32)
    @Column(name = "CODE")
    private String code;

    @Column(name = "LIBELLE")
    @Enumerated(EnumType.STRING)
    private LibelleClasse libelle;
    @Column(name = "DATE_CREATION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreation;
    @Column(name = "DATE_MODIFICATION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateModification;
    @JoinColumn(name = "ID_ENTREPRISE", referencedColumnName = "ID_ENTREPRISE")
    @ManyToOne(optional = true)
    private OrclassEntreprises idEntreprise;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idClasse")
    private List<OrclassBranches> orclassBranchesList;
    Boolean showAllCompagnies = Boolean.FALSE;
    String libelleAutre;

    public OrclassClasses() {
//        idEntreprise=new OrclassEntreprises();
        this.dateCreation = new Date();
    }

    public OrclassClasses(Short idClasse) {
        this.idClasse = idClasse;
    }

    public Short getIdClasse() {
        return idClasse;
    }

    public void setIdClasse(Short idClasse) {
        this.idClasse = idClasse;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public LibelleClasse getLibelle() {
        return libelle;
    }

    public void setLibelle(LibelleClasse libelleClasse) {
        this.libelle = libelleClasse;
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
    public List<OrclassBranches> getOrclassBranchesList() {
        return orclassBranchesList;
    }

    public void setOrclassBranchesList(List<OrclassBranches> orclassBranchesList) {
        this.orclassBranchesList = orclassBranchesList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idClasse != null ? idClasse.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrclassClasses)) {
            return false;
        }
        OrclassClasses other = (OrclassClasses) object;
        if ((this.idClasse == null && other.idClasse != null) || (this.idClasse != null && !this.idClasse.equals(other.idClasse))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modele.OrclassClasses[ idClasse=" + idClasse + " ]";
    }

}
