/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import enums.TypeContrat;
import java.math.BigInteger;
import java.util.Date;
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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author hp
 */
@Entity
@Table(name = "ORCLASS_MAJORA_DUREE")
public class OrclassMajorationDuree implements DAOEntry {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_MAJORA_DUREE")
    private Long id;
    @Column(name = "DATE_CREATION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreation;
    @Column(name = "DATE_MODIFICATION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateModification;
    @Column(name = "DATE_EFFET")
    @Temporal(TemporalType.TIMESTAMP)
    private Date effet;
    @Column(name = "DATE_FIN")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fin;
    @JoinColumn(name = "ID_CATEGORIE", referencedColumnName = "ID_CATEGORIE")
    @ManyToOne(optional = false)
    private OrclassCategories idCategories;
    @JoinColumn(name = "ID_DUREE", referencedColumnName = "ID_DUREE")
    @ManyToOne(optional = false)
    private OrclassDuree idDuree;

    @JoinColumn(name = "ID_ENTREPRISE", referencedColumnName = "ID_ENTREPRISE")
    @ManyToOne(optional = false)
    private OrclassEntreprises idEntreprise;
    BigInteger coefficient=BigInteger.ZERO;
    @Column(name = "TYPE_CONTRAT")
    @Enumerated(EnumType.STRING)
    private TypeContrat typeContrat;
    BigInteger prorogation = BigInteger.ZERO;
    BigInteger valeurAdditif=BigInteger.ZERO;

    public OrclassMajorationDuree() {
        this.dateCreation = new Date();
        this.idDuree = new OrclassDuree();
        this.idCategories = new OrclassCategories();
        this.coefficient=BigInteger.ZERO;
        this.valeurAdditif=BigInteger.ZERO;
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

    public Date getEffet() {
        return effet;
    }

    public void setEffet(Date effet) {
        this.effet = effet;
    }

    public Date getFin() {
        return fin;
    }

    public void setFin(Date fin) {
        this.fin = fin;
    }

    public OrclassCategories getIdCategories() {
        return idCategories;
    }

    public void setIdCategories(OrclassCategories idCategories) {
        this.idCategories = idCategories;
    }

    public OrclassDuree getIdDuree() {
        return idDuree;
    }

    public void setIdDuree(OrclassDuree idDuree) {
        this.idDuree = idDuree;
    }

    public OrclassEntreprises getIdEntreprise() {
        return idEntreprise;
    }

    public void setIdEntreprise(OrclassEntreprises idEntreprise) {
        this.idEntreprise = idEntreprise;
    }

    public BigInteger getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(BigInteger coefficient) {
        this.coefficient = coefficient;
    }

    public TypeContrat getTypeContrat() {
        return typeContrat;
    }

    public void setTypeContrat(TypeContrat typeContrat) {
        this.typeContrat = typeContrat;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigInteger getProrogation() {
        return prorogation;
    }

    public void setProrogation(BigInteger prorogation) {
        this.prorogation = prorogation;
    }

    public BigInteger getValeurAdditif() {
        return valeurAdditif;
    }

    public void setValeurAdditif(BigInteger valeurAdditif) {
        this.valeurAdditif = valeurAdditif;
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
        if (!(object instanceof OrclassMajorationDuree)) {
            return false;
        }
        OrclassMajorationDuree other = (OrclassMajorationDuree) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modele.OrclassMajorationDuree[ id=" + id + " ]";
    }

}
