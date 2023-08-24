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
@Table(name = "ORCLASS_EVEN_SIN", uniqueConstraints = @UniqueConstraint(columnNames = {"ID_ENTREPRISE", "ID_EVENT", "ID_SIN_MAL"}))
public class OrclassEvenementSinistreMaladie implements DAOEntry {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_EVEN_SIN")
    private Long id;
    @JoinColumn(name = "ID_ENTREPRISE", referencedColumnName = "ID_ENTREPRISE")
    @ManyToOne(optional = false)
    private OrclassEntreprises idEntreprise;
    @JoinColumn(name = "ID_SIN_MAL", referencedColumnName = "ID_SIN_MAL")
    @ManyToOne(optional = false)
    private OrclassSinistreMaladie idSinistreMaladie;
    @JoinColumn(name = "ID_EVENT", referencedColumnName = "ID_EVENT")
    @ManyToOne(optional = false)
    private OrclassEvenement idEvenement;
    @Column(name = "DATE_CREATION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date_evenement;

    private String observation;
    Boolean traite = Boolean.FALSE;

    public OrclassEvenementSinistreMaladie() {
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

    public OrclassEvenement getIdEvenement() {
        return idEvenement;
    }

    public void setIdEvenement(OrclassEvenement idEvenement) {
        this.idEvenement = idEvenement;
    }

    public Date getDate_evenement() {
        return date_evenement;
    }

    public void setDate_evenement(Date date_evenement) {
        this.date_evenement = date_evenement;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }

    public Boolean getTraite() {
        return traite;
    }

    public void setTraite(Boolean traite) {
        this.traite = traite;
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
        if (!(object instanceof OrclassEvenementSinistreMaladie)) {
            return false;
        }
        OrclassEvenementSinistreMaladie other = (OrclassEvenementSinistreMaladie) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modele.OrclassEvenementSinistreMaladie[ id=" + id + " ]";
    }

}
