/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

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

/**
 *
 * @author JIATOU FRANCK
 */
@Entity
@Table(name = "ORCLASS_INTERVEN")
public class OrclassIntervenant implements DAOEntry {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_INTERV")
    private Long id;

    private String code;
    private String nom;
    @Transient
    private String nature;
    @Transient
    private String designation;
    @Transient
    private String observation;
//    @Column(name = "DATE_CREATION")
//    @Temporal(TemporalType.TIMESTAMP)
    @Transient
    private Date date_creation;
//    @Column(name = "HORAIRE")
//    @Temporal(TemporalType.TIME)
    @Transient
    private Date horaire;
    @JoinColumn(name = "ID_ENTREPRISE", referencedColumnName = "ID_ENTREPRISE")
    @ManyToOne(optional = false)
    private OrclassEntreprises idEntreprise;
    @Transient
    OrclassSinistreMaladie sinistreMaladie;
    @Transient
    Boolean afficher = Boolean.FALSE;

    public OrclassIntervenant() {
        sinistreMaladie = new OrclassSinistreMaladie();
    }

    public OrclassIntervenant(String code, String nom) {
        this.code = code;
        this.nom = nom;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
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

    public OrclassEntreprises getIdEntreprise() {
        return idEntreprise;
    }

    public void setIdEntreprise(OrclassEntreprises idEntreprise) {
        this.idEntreprise = idEntreprise;
    }

    public OrclassSinistreMaladie getSinistreMaladie() {
        return sinistreMaladie;
    }

    public void setSinistreMaladie(OrclassSinistreMaladie sinistreMaladie) {
        this.sinistreMaladie = sinistreMaladie;
    }

    public Boolean getAfficher() {
        return afficher;
    }

    public void setAfficher(Boolean affiche) {
        this.afficher = affiche;
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
        if (!(object instanceof OrclassIntervenant)) {
            return false;
        }
        OrclassIntervenant other = (OrclassIntervenant) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modele.OrclassIntervenant[ id=" + id + " ]";
    }

}
