/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
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
@Table(name = "ORCLASS_INTV_SIN", uniqueConstraints = @UniqueConstraint(columnNames = {"ID_ENTREPRISE", "ID_INTERV", "ID_SIN_MAL"}))

public class OrclassIntervenantSinistreMaladie implements DAOEntry {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_INTE_SIN")
    private Long id;

    @JoinColumn(name = "ID_ENTREPRISE", referencedColumnName = "ID_ENTREPRISE")
    @ManyToOne(optional = false)
    private OrclassEntreprises idEntreprise;
    @JoinColumn(name = "ID_SIN_MAL", referencedColumnName = "ID_SIN_MAL")
    @ManyToOne(optional = false)
    private OrclassSinistreMaladie idSinistreMaladie;
    @JoinColumn(name = "ID_INTERV", referencedColumnName = "ID_INTERV")
    @ManyToOne(optional = false)
    private OrclassIntervenant idIntervenant;
    private String nature;
    private String designation;
    private String observation;
    @Column(name = "DATE_CREATION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date_creation;
    @Column(name = "HORAIRE")
    @Temporal(TemporalType.TIME)
    private Date horaire;

    public OrclassIntervenantSinistreMaladie() {
    }
    
    

    public OrclassEntreprises getIdEntreprise() {
        return idEntreprise;
    }

    public void setIdEntreprise(OrclassEntreprises idEntreprise) {
        this.idEntreprise = idEntreprise;
    }

    public OrclassSinistreMaladie getIdSinistreMaladie() {
        return idSinistreMaladie;
    }

    public void setIdSinistreMaladie(OrclassSinistreMaladie idSinistreMaladie) {
        this.idSinistreMaladie = idSinistreMaladie;
    }

    public OrclassIntervenant getIdIntervenant() {
        return idIntervenant;
    }

    public void setIdIntervenant(OrclassIntervenant idIntervenant) {
        this.idIntervenant = idIntervenant;
    }

    public String getNature() {
        return nature;
    }

    public void setNature(String nature) {
        this.nature = nature;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }

    public Date getDate_creation() {
        return date_creation;
    }

    public void setDate_creation(Date date_creation) {
        this.date_creation = date_creation;
    }

    public Date getHoraire() {
        return horaire;
    }

    public void setHoraire(Date horaire) {
        this.horaire = horaire;
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
        if (!(object instanceof OrclassIntervenantSinistreMaladie)) {
            return false;
        }
        OrclassIntervenantSinistreMaladie other = (OrclassIntervenantSinistreMaladie) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modele.OrclassIntervenantSinistreMaladie[ id=" + id + " ]";
    }

}
