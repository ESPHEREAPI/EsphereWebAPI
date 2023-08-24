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
@Table(name = "ORCLASS_PRESTATAIRE", uniqueConstraints = @UniqueConstraint(columnNames = {"ID_ENTREPRISE", "ID_REF_PREST"}))
public class OrclassPrestataire implements DAOEntry {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_PREST")
    private Long id;

    @JoinColumn(name = "ID_REF_PREST", referencedColumnName = "ID_REF_PREST")
    @ManyToOne(optional = false)
    private orclassRefPrestataire idRefPrestataire;
    @JoinColumn(name = "ID_ENTREPRISE", referencedColumnName = "ID_ENTREPRISE")
    @ManyToOne(optional = false)
    private OrclassEntreprises idEntreprise;
    @Column(name = "DATE_CREATION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreation;
    @Column(name = "DATE_MODIFICATION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateModification;

    public OrclassPrestataire() {
        idRefPrestataire = new orclassRefPrestataire();
    }

    public orclassRefPrestataire getIdRefPrestataire() {
        return idRefPrestataire;
    }

    public void setIdRefPrestataire(orclassRefPrestataire idRefPrestataire) {
        this.idRefPrestataire = idRefPrestataire;
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
        if (!(object instanceof OrclassPrestataire)) {
            return false;
        }
        OrclassPrestataire other = (OrclassPrestataire) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modele.OrclassPrestataire[ id=" + id + " ]";
    }

}
