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
@Table(name = "ORCLASS_BORDEREAU", uniqueConstraints = @UniqueConstraint(columnNames = {"ID_ENTREPRISE", "NUMERO_BORDEREAU"}))
public class OrclassBordereau implements DAOEntry {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_BORDEREAU")
    private Long id;
    @Column(name = "NUMERO_BORDEREAU")
    private String numero_bordereau;
    @Column(name = "REF_BORDEREAU")
    private String ref_bordereau;
     private String numero_reglement;
    @Column(name = "DATE_CREATION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date_creation;
    @JoinColumn(name = "ID_UTILISATEUR", referencedColumnName = "ID_UTILISATEUR")
    @ManyToOne(optional = false)
    private OrclassUtilisateurs idUtilisateurs;
    @JoinColumn(name = "ID_FACTURE", referencedColumnName = "ID_FACTURE")
    @ManyToOne(optional = false)
    private OrclasseFacture idFacture;
     @JoinColumn(name = "ID_ENTREPRISE", referencedColumnName = "ID_ENTREPRISE")
    @ManyToOne(optional = false)
    private OrclassEntreprises idEntreprise;
     @JoinColumn(name = "ID_REGLEMENT", referencedColumnName = "ID_REGLEMENT")
    @ManyToOne(optional = true)
    private OrclassReglement idReglement ;

    public OrclassBordereau() {
        
    }

    public String getRef_bordereau() {
        return ref_bordereau;
    }

    public void setRef_bordereau(String ref_bordereau) {
        this.ref_bordereau = ref_bordereau;
    }

    public String getNumero_reglement() {
        return numero_reglement;
    }

    public void setNumero_reglement(String numero_reglement) {
        this.numero_reglement = numero_reglement;
    }
     
     

    public String getNumero_bordereau() {
        return numero_bordereau;
    }

    public void setNumero_bordereau(String numero_bordereau) {
        this.numero_bordereau = numero_bordereau;
    }

    public Date getDate_creation() {
        return date_creation;
    }

    public void setDate_creation(Date date_creation) {
        this.date_creation = date_creation;
    }

    public OrclassUtilisateurs getIdUtilisateurs() {
        return idUtilisateurs;
    }

    public void setIdUtilisateurs(OrclassUtilisateurs idUtilisateurs) {
        this.idUtilisateurs = idUtilisateurs;
    }

    public OrclasseFacture getIdFacture() {
        return idFacture;
    }

    public void setIdFacture(OrclasseFacture idFacture) {
        this.idFacture = idFacture;
    }

    public OrclassEntreprises getIdEntreprise() {
        return idEntreprise;
    }

    public void setIdEntreprise(OrclassEntreprises idEntreprise) {
        this.idEntreprise = idEntreprise;
    }

    public OrclassReglement getIdReglement() {
        return idReglement;
    }

    public void setIdReglement(OrclassReglement idReglement) {
        this.idReglement = idReglement;
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
        if (!(object instanceof OrclassBordereau)) {
            return false;
        }
        OrclassBordereau other = (OrclassBordereau) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modele.OrclassBordereau[ id=" + id + " ]";
    }

}
