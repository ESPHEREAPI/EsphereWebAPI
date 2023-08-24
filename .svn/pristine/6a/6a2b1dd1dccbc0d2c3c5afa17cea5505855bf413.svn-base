/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import enums.SortFacture;
import enums.SortSinistre;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
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
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

/**
 *
 * @author JIATOU FRANCK
 */
@Entity
@Table(name = "ORCLASS_FACTURE", uniqueConstraints = @UniqueConstraint(columnNames = {"ID_ENTREPRISE", "NUMERO_FACTURE"}))
public class OrclasseFacture implements DAOEntry {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    @Column(name = "ID_FACTURE")
    private Long id;
      @JoinColumn(name = "ID_ENTREPRISE", referencedColumnName = "ID_ENTREPRISE")
    @ManyToOne(optional = false)
    private OrclassEntreprises idEntreprise;
        @JoinColumn(name = "ID_UTILISATEUR", referencedColumnName = "ID_UTILISATEUR")
    @ManyToOne(optional = false)
    private OrclassUtilisateurs idUtilisateurs;
    @Column(name = "NUMERO_FACTURE")
    private String numero_facture;
    @Column(name = "DATE_CREATION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date_creation;
    @Column(name = "DATE_DEPOT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date_depot;
    @Column(name = "DATE_SAISIR")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date_saisir;
    @Column(name = "DATE_REGLEMENT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date_reglement;
     @Column(name = "DATE_ANNULATION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date_annulation;
    @Enumerated(EnumType.STRING)
    @Column(name = "SORT")
    private SortFacture sort;
    @Column(name = "MONTANT_FACTURE")
    BigDecimal montant = BigDecimal.ZERO;
    private String saisir_par;
    private String modifier_par;
    private String valider_par;
    private String annuler_par;
    private String nume_regle_valide;

    public OrclasseFacture() {
        
    }

    public String getNumero_facture() {
        return numero_facture;
    }

    public void setNumero_facture(String numero_facture) {
        this.numero_facture = numero_facture;
    }

    public Date getDate_creation() {
        return date_creation;
    }

    public void setDate_creation(Date date_creation) {
        this.date_creation = date_creation;
    }

    public Date getDate_depot() {
        return date_depot;
    }

    public void setDate_depot(Date date_depot) {
        this.date_depot = date_depot;
    }

    public Date getDate_saisir() {
        return date_saisir;
    }

    public void setDate_saisir(Date date_saisir) {
        this.date_saisir = date_saisir;
    }

    public Date getDate_reglement() {
        return date_reglement;
    }

    public void setDate_reglement(Date date_reglement) {
        this.date_reglement = date_reglement;
    }

    public SortFacture getSort() {
        return sort;
    }

    public void setSort(SortFacture sort) {
        this.sort = sort;
    }

    public BigDecimal getMontant() {
        return montant;
    }

    public void setMontant(BigDecimal montant) {
        this.montant = montant;
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

    public OrclassEntreprises getIdEntreprise() {
        return idEntreprise;
    }

    public void setIdEntreprise(OrclassEntreprises idEntreprise) {
        this.idEntreprise = idEntreprise;
    }

    public OrclassUtilisateurs getIdUtilisateurs() {
        return idUtilisateurs;
    }

    public void setIdUtilisateurs(OrclassUtilisateurs idUtilisateurs) {
        this.idUtilisateurs = idUtilisateurs;
    }

    public Date getDate_annulation() {
        return date_annulation;
    }

    public void setDate_annulation(Date date_annulation) {
        this.date_annulation = date_annulation;
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

    public String getValider_par() {
        return valider_par;
    }

    public void setValider_par(String valider_par) {
        this.valider_par = valider_par;
    }

    public String getAnnuler_par() {
        return annuler_par;
    }

    public void setAnnuler_par(String annuler_par) {
        this.annuler_par = annuler_par;
    }

    public String getNume_regle_valide() {
        return nume_regle_valide;
    }

    public void setNume_regle_valide(String nume_regle_valide) {
        this.nume_regle_valide = nume_regle_valide;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrclasseFacture)) {
            return false;
        }
        OrclasseFacture other = (OrclasseFacture) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modele.OrclasseFacture[ id=" + id + " ]";
    }

}
