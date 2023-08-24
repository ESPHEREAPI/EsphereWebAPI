/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.io.Serializable;
import java.math.BigDecimal;
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
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

/**
 *
 * @author JIATOU FRANCK
 */
@Entity
@Table(name = "ORCLASS_GROUPE_GARANTIE_POLIC")
public class OrclassGroupeGarantiePolice implements DAOEntry {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    @Column(name = "ID_GROUPE_GAR_POL")
    private Long id;

    @JoinColumn(name = "ID_ENTREPRISE", referencedColumnName = "ID_ENTREPRISE")
    @ManyToOne(optional = false)
    private OrclassEntreprises idEntreprise;
    @JoinColumn(name = "ID_GROUPE_POL", referencedColumnName = "ID_GROUPE_POL")
    @ManyToOne(optional = false)
    private OrclassGroupePolice idGroupePolice;
    @JoinColumn(name = "ID_AVENANT", referencedColumnName = "ID_AVENANT")
    @ManyToOne(optional = true)
    private OrclassAvenant idAvenant;
       @JoinColumn(name = "ID_GARANTIE", referencedColumnName = "ID_GARANTIE")
    @ManyToOne(optional = false)
    private OrclassGarantie idGarantie;

    @Column(name = "DATE_CREATION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreation;
    @Column(name = "DATE_MODIFICATION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateModification;
    private String saisir_par;
    private String modifier_par;
    private BigDecimal prime=BigDecimal.ZERO;
    @Transient
    private OrclassPoliceGarantie policeGarantie;

    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public OrclassGroupeGarantiePolice() {
        idGroupePolice=new OrclassGroupePolice();
        idGarantie=new OrclassGarantie();
        policeGarantie=new OrclassPoliceGarantie();
    }

    public OrclassEntreprises getIdEntreprise() {
        return idEntreprise;
    }

    public void setIdEntreprise(OrclassEntreprises idEntreprise) {
        this.idEntreprise = idEntreprise;
    }

    public OrclassGroupePolice getIdGroupePolice() {
        return idGroupePolice;
    }

    public void setIdGroupePolice(OrclassGroupePolice idGroupePolice) {
        this.idGroupePolice = idGroupePolice;
    }

    public OrclassAvenant getIdAvenant() {
        return idAvenant;
    }

    public void setIdAvenant(OrclassAvenant idAvenant) {
        this.idAvenant = idAvenant;
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

    public String getSaisir_par() {
        return saisir_par;
    }

    public void setSaisir_par(String saisir_par) {
        this.saisir_par = saisir_par;
    }

    public String getModifier_par() {
        return modifier_par;
    }

    public void setModifier_par(String modifier_par) {
        this.modifier_par = modifier_par;
    }

    public OrclassGarantie getIdGarantie() {
        return idGarantie;
    }

    public void setIdGarantie(OrclassGarantie idGarantie) {
        this.idGarantie = idGarantie;
    }

    public BigDecimal getPrime() {
        return prime;
    }

    public void setPrime(BigDecimal prime) {
        this.prime = prime;
    }

    public OrclassPoliceGarantie getPoliceGarantie() {
        return policeGarantie;
    }

    public void setPoliceGarantie(OrclassPoliceGarantie policeGarantie) {
        this.policeGarantie = policeGarantie;
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
        if (!(object instanceof OrclassGroupeGarantiePolice)) {
            return false;
        }
        OrclassGroupeGarantiePolice other = (OrclassGroupeGarantiePolice) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modele.OrclassGroupeGarantiePolice[ id=" + id + " ]";
    }

}
