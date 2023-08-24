/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author hp
 */
@Entity
@Table(name = "ORCLASS_POL_COM_APP")
public class OrclassPoliceCommissionApporteur implements DAOEntry {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    @Column(name = "ID_POL_COM_PR_APP")
    private Long id;

    @JoinColumn(name = "ID_ENTREPRISE", referencedColumnName = "ID_ENTREPRISE")
    @ManyToOne(optional = false)
    private OrclassEntreprises idEntreprise;
    @JoinColumn(name = "ID_COM_PRIME_APP", referencedColumnName = "ID_COM_PRIME_APP")
    @ManyToOne(optional = false)
    private OrclassCommission_Prime_Apporteur idCommission_Prime_Apporteur;

    @JoinColumn(name = "ID_POLICE", referencedColumnName = "ID_POLICE")
    @ManyToOne
    private OrclassPolice idPolice;
      @JoinColumn(name = "ID_AVENANT", referencedColumnName = "ID_AVENANT")
    @ManyToOne(optional = true)
    private OrclassAvenant idAvenant;
  
    BigDecimal taux_apport;
    BigDecimal taux_gestion;

    public OrclassPoliceCommissionApporteur() {
        idCommission_Prime_Apporteur = new OrclassCommission_Prime_Apporteur();
        idPolice = new OrclassPolice();
    }

    public OrclassAvenant getIdAvenant() {
        return idAvenant;
    }

    public void setIdAvenant(OrclassAvenant idAvenant) {
        this.idAvenant = idAvenant;
    }

    public OrclassEntreprises getIdEntreprise() {
        return idEntreprise;
    }

    public void setIdEntreprise(OrclassEntreprises idEntreprise) {
        this.idEntreprise = idEntreprise;
    }

    public OrclassCommission_Prime_Apporteur getIdCommission_Prime_Apporteur() {
        return idCommission_Prime_Apporteur;
    }

    public void setIdCommission_Prime_Apporteur(OrclassCommission_Prime_Apporteur idCommission_Prime_Apporteur) {
        this.idCommission_Prime_Apporteur = idCommission_Prime_Apporteur;
    }

   

    public OrclassPolice getIdPolice() {
        return idPolice;
    }

    public void setIdPolice(OrclassPolice idPolice) {
        this.idPolice = idPolice;
    }


    public BigDecimal getTaux_apport() {
        return taux_apport;
    }

    public void setTaux_apport(BigDecimal taux_apport) {
        this.taux_apport = taux_apport;
    }

    public BigDecimal getTaux_gestion() {
        return taux_gestion;
    }

    public void setTaux_gestion(BigDecimal taux_gestion) {
        this.taux_gestion = taux_gestion;
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
        if (!(object instanceof OrclassPoliceCommissionApporteur)) {
            return false;
        }
        OrclassPoliceCommissionApporteur other = (OrclassPoliceCommissionApporteur) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modele.OrclassPoliceCommissionApporteur[ id=" + id + " ]";
    }

}
