/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import enums.SortSinistre;
import enums.SortSinistreMaladie;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
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

/**
 *
 * @author JIATOU FRANCK
 */
@Entity
@Table(name = "ORCLASS_SIN_MALAD", uniqueConstraints = @UniqueConstraint(columnNames = {"ID_ENTREPRISE", "ID_SINISTRE", "ID_PRESTATION"}))
public class OrclassSinistreMaladie implements DAOEntry {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_SIN_MAL")
    private Long id;

    @JoinColumn(name = "ID_ENTREPRISE", referencedColumnName = "ID_ENTREPRISE")
    @ManyToOne(optional = false)
    private OrclassEntreprises idEntreprise;
    @JoinColumn(name = "ID_SINISTRE", referencedColumnName = "ID_SINISTRE")
    @ManyToOne(optional = false)
    private OrclassSinistre idSinistre;// ce corespond au registre de la branche
    @JoinColumn(name = "ID_PRESTATION", referencedColumnName = "ID_PRESTATION")
    @ManyToOne(optional = false)
    private OrclassPrestation idPrestation;
    @JoinColumn(name = "ID_UTILISATEUR", referencedColumnName = "ID_UTILISATEUR")
    @ManyToOne(optional = false)
    private OrclassUtilisateurs idUtilisateurs;
    @JoinColumn(name = "ID_EVENT", referencedColumnName = "ID_EVENT")
    @ManyToOne(optional = true)
    private OrclassEvenement idEvenement;
    @JoinColumn(name = "ID_INTERV", referencedColumnName = "ID_INTERV")
    @ManyToOne(optional = true)
    private OrclassIntervenant idIntervenant;

    private int cle;
    @Column(name = "DATE_ACTE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date_acte;
    @Column(name = "NOMBRE_ACTE_REEL")
    private Double nombre_acte_reel;
    @Column(name = "NOMBRE_CLE_REEL")
    private Double nombre_cle_reel;
    @Column(name = "DEBOURSEMENT_REEL")
    private Double deboursement_reel;
    @Column(name = "NOMBRE_ACTE_REMB")
    private Double nombre_acte_remb;
    @Column(name = "NOMBRE_CLE_REMB")
    private Double nombre_cle_remb;
    @Column(name = "MONTANT_EXCLURE")
    private Double montant_exclure;
    private Double base_remboursement;
    private Double montant_unitant;
    private Double remb_externe;
    private Double taux;
    private Double montant_remb;
    private Double forfait;
    private String motif_sort;
    @Enumerated(EnumType.STRING)
    @Column(name = "SORT")
    private SortSinistreMaladie sort;
    @Column(name = "DATE_CREATION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreation;
    @Column(name = "DATE_SAISIR")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date_saisir;
    @Column(name = "DATE_MODIFIER")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date_modification;
    @Column(name = "DATE_VALIDE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date_valider;
    @Column(name = "DATE_REJETTER")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date_rejetter;
    String Observation;//ceci devient import lorsque un rejet est effectuer
    private String saisir_par;
    private String modifier_par;
    private String valider_par;
    private String rejeter_par;

    public OrclassSinistreMaladie() {
        nombre_acte_reel = BigDecimal.ZERO.doubleValue();
        nombre_cle_reel = BigDecimal.ZERO.doubleValue();
        nombre_cle_remb = BigDecimal.ZERO.doubleValue();
        montant_unitant = BigDecimal.ZERO.doubleValue();
        montant_remb = BigDecimal.ZERO.doubleValue();
        montant_exclure = BigDecimal.ZERO.doubleValue();
        deboursement_reel = BigDecimal.ZERO.doubleValue();
        remb_externe = BigDecimal.ZERO.doubleValue();
        base_remboursement = BigDecimal.ZERO.doubleValue();
        nombre_acte_remb = BigDecimal.ZERO.doubleValue();
        forfait = 0.0;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getMontant_unitant() {
        return montant_unitant;
    }

    public void setMontant_unitant(Double montant_unitant) {
        this.montant_unitant = montant_unitant;
    }

    public OrclassEntreprises getIdEntreprise() {
        return idEntreprise;
    }

    public void setIdEntreprise(OrclassEntreprises idEntreprise) {
        this.idEntreprise = idEntreprise;
    }

    public OrclassSinistre getIdSinistre() {
        return idSinistre;
    }

    public void setIdSinistre(OrclassSinistre idSinistre) {
        this.idSinistre = idSinistre;
    }

    public OrclassPrestation getIdPrestation() {
        return idPrestation;
    }

    public void setIdPrestation(OrclassPrestation idPrestation) {
        this.idPrestation = idPrestation;
    }

    public OrclassUtilisateurs getIdUtilisateurs() {
        return idUtilisateurs;
    }

    public void setIdUtilisateurs(OrclassUtilisateurs idUtilisateurs) {
        this.idUtilisateurs = idUtilisateurs;
    }

    public OrclassEvenement getIdEvenement() {
        return idEvenement;
    }

    public void setIdEvenement(OrclassEvenement idEvenement) {
        this.idEvenement = idEvenement;
    }

    public OrclassIntervenant getIdIntervenant() {
        return idIntervenant;
    }

    public void setIdIntervenant(OrclassIntervenant idIntervenant) {
        this.idIntervenant = idIntervenant;
    }

    public int getCle() {
        return cle;
    }

    public void setCle(int cle) {
        this.cle = cle;
    }

    public Date getDate_acte() {
        return date_acte;
    }

    public void setDate_acte(Date date_acte) {
        this.date_acte = date_acte;
    }

    public Double getNombre_acte_reel() {
        return nombre_acte_reel;
    }

    public void setNombre_acte_reel(Double nombre_acte_reel) {
        this.nombre_acte_reel = nombre_acte_reel;
    }

    public Double getNombre_cle_reel() {
        return nombre_cle_reel;
    }

    public void setNombre_cle_reel(Double nombre_cle_reel) {
        this.nombre_cle_reel = nombre_cle_reel;
    }

    public Double getDeboursement_reel() {
        return deboursement_reel;
    }

    public void setDeboursement_reel(Double deboursement_reel) {
        this.deboursement_reel = deboursement_reel;
    }

    public Double getNombre_acte_remb() {
        return nombre_acte_remb;
    }

    public void setNombre_acte_remb(Double nombre_acte_remb) {
        this.nombre_acte_remb = nombre_acte_remb;
    }

    public Double getNombre_cle_remb() {
        return nombre_cle_remb;
    }

    public void setNombre_cle_remb(Double nombre_cle_remb) {
        this.nombre_cle_remb = nombre_cle_remb;
    }

    public Double getMontant_exclure() {
        return montant_exclure;
    }

    public void setMontant_exclure(Double montant_exclure) {
        this.montant_exclure = montant_exclure;
    }

    public Double getBase_remboursement() {
        return base_remboursement;
    }

    public void setBase_remboursement(Double base_remboursement) {
        this.base_remboursement = base_remboursement;
    }

    public Double getRemb_externe() {
        return remb_externe;
    }

    public void setRemb_externe(Double remb_externe) {
        this.remb_externe = remb_externe;
    }

    public Double getTaux() {
        return taux;
    }

    public void setTaux(Double taux) {
        this.taux = taux;
    }

    public Double getMontant_remb() {
        return montant_remb;
    }

    public void setMontant_remb(Double montant_remb) {
        this.montant_remb = montant_remb;
    }

    public String getMotif_sort() {
        return motif_sort;
    }

    public void setMotif_sort(String motif_sort) {
        this.motif_sort = motif_sort;
    }

    public SortSinistreMaladie getSort() {
        return sort;
    }

    public void setSort(SortSinistreMaladie sort) {
        this.sort = sort;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public Date getDate_saisir() {
        return date_saisir;
    }

    public void setDate_saisir(Date date_saisir) {
        this.date_saisir = date_saisir;
    }

    public Date getDate_modification() {
        return date_modification;
    }

    public void setDate_modification(Date date_modification) {
        this.date_modification = date_modification;
    }

    public Date getDate_valider() {
        return date_valider;
    }

    public void setDate_valider(Date date_valider) {
        this.date_valider = date_valider;
    }

    public Date getDate_rejetter() {
        return date_rejetter;
    }

    public void setDate_rejetter(Date date_rejetter) {
        this.date_rejetter = date_rejetter;
    }

    public String getObservation() {
        return Observation;
    }

    public void setObservation(String Observation) {
        this.Observation = Observation;
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

    public String getRejeter_par() {
        return rejeter_par;
    }

    public void setRejeter_par(String rejeter_par) {
        this.rejeter_par = rejeter_par;
    }

    public Double getForfait() {
        return forfait;
    }

    public void setForfait(Double forfait) {
        this.forfait = forfait;
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
        if (!(object instanceof OrclassSinistreMaladie)) {
            return false;
        }
        OrclassSinistreMaladie other = (OrclassSinistreMaladie) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modele.OrclassSinistreMaladie[ id=" + id + " ]";
    }

}
