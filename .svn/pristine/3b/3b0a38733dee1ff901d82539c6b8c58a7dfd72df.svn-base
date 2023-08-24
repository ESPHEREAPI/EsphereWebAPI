/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author JIATOU FRANCK
 */
@Entity
@Table(name = "ORCLASS_NAT_MALADIE", uniqueConstraints = @UniqueConstraint(columnNames = {"ID_ENTREPRISE", "ID_REF_NMAL"}))
public class OrclassNatureMaladie implements DAOEntry {

    private static final long serialVersionUID = 1L;
    @Column(name = "ID_NT_MAL")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @JoinColumn(name = "ID_REF_NMAL", referencedColumnName = "ID_REF_NMAL")
    @ManyToOne(optional = false)
    private OrclassRefNatureMaladie idRefNatureMaladie;
    @JoinColumn(name = "ID_ENTREPRISE", referencedColumnName = "ID_ENTREPRISE")
    @ManyToOne(optional = false)
    private OrclassEntreprises idEntreprise;
    @Column(name = "DATE_CREATION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreation;
    @Column(name = "DATE_MODIFICATION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateModification;

    public OrclassNatureMaladie() {
        idRefNatureMaladie = new OrclassRefNatureMaladie();
    }

    public OrclassRefNatureMaladie getIdRefNatureMaladie() {
        return idRefNatureMaladie;
    }

    public void setIdRefNatureMaladie(OrclassRefNatureMaladie idRefNatureMaladie) {
        this.idRefNatureMaladie = idRefNatureMaladie;
    }

    public OrclassEntreprises getIdEntreprise() {
        return idEntreprise;
    }

    public void setIdEntreprise(OrclassEntreprises idEntreprise) {
        this.idEntreprise = idEntreprise;
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
        if (!(object instanceof OrclassNatureMaladie)) {
            return false;
        }
        OrclassNatureMaladie other = (OrclassNatureMaladie) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modele.OrclassNatureMaladie[ id=" + id + " ]";
    }

}
