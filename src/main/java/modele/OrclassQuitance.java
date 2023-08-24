/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import enums.TypeQuittance;
import java.math.BigDecimal;
import java.util.Comparator;
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
import javax.validation.constraints.NotNull;

/**
 *
 * @author hp
 */
@Entity
@Table(name = "ORCLASS_QUITANCE")
public class OrclassQuitance implements DAOEntry {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    @Column(name = "ID_QUITANCE")
    private Long id;

    @JoinColumn(name = "ID_POLICE", referencedColumnName = "ID_POLICE")
    @ManyToOne(optional = false)
    private OrclassPolice idPolice;
    @JoinColumn(name = "ID_AVENANT", referencedColumnName = "ID_AVENANT")
    @ManyToOne(optional = true)
    private OrclassAvenant idAvenant;
    @JoinColumn(name = "ID_ENTREPRISE", referencedColumnName = "ID_ENTREPRISE")
    @ManyToOne(optional = false)
    private OrclassEntreprises idEntreprise;
//    @JoinColumn(name = "ID_TYPE_QUITANCE", referencedColumnName = "ID_TYPE_QUITANCE")
//    @ManyToOne(optional = false)
//    private OrclassTypeQuitance idTypeQuitance;
    @JoinColumn(name = "ID_TIMB_DIM", referencedColumnName = "ID_TIMB_DIM")
    @ManyToOne(optional = true)
    private OrclasseTimbreDimension idTimbreDimension;
    @JoinColumn(name = "ID_DEVISE", referencedColumnName = "ID_DEVISE")
    @ManyToOne(optional = false)
    private OrclassDevise idDevise;
    @Column(name = "DATE_SAISIE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date_saisie;
    @Column(name = "DATE_EFFET")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date_effet;
    @Column(name = "DATE_VALIDATION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date_validation;
    @Column(name = "DATE_ECHEANCE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date_echeance;
    @Column(name = "DATE_CREATION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreation;
    @Column(name = "DATE_MODIFICATION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateModification;
    @Column(name = "DATE_EMISSION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateEmission;
    private String saisir_par;
    private String modifier_par;
    private String valider_par;
    private String annuler_par;
    BigDecimal primeNette;
    /*
    la somme de toutes taxe liée a cette prime
     */
    BigDecimal taxePrime;

    BigDecimal montant_Accessoire;
    BigDecimal taxeAccessoir;
    BigDecimal montantCommision;
    BigDecimal taxeCommision;
    /*
    nombre timbre x la valeur du timbre;
     */
    BigDecimal timbreDimension;
    /*
    montant total pour tous les timbre gradue vignette,carte rose,et bien autre
     */
    BigDecimal timbreGradue;

    BigDecimal taxe_asac_fga = BigDecimal.ZERO;
    BigDecimal taxe_tva = BigDecimal.ZERO;
    BigDecimal taxe_tva_acc = BigDecimal.ZERO;
    BigDecimal taxe_tva_sur_asac = BigDecimal.ZERO;
    BigDecimal taxe_caterose = BigDecimal.ZERO;
    BigDecimal taxe_pool_tpv = BigDecimal.ZERO;

    BigDecimal timbr_Gradue__vignette = BigDecimal.ZERO;//DTA
    BigDecimal timbr_Gradue_cp = BigDecimal.ZERO;
    BigDecimal bonus = BigDecimal.ZERO;
    BigDecimal red_statut_socioprof = BigDecimal.ZERO;
    BigDecimal red_duree_condit = BigDecimal.ZERO;
    BigDecimal reduction = BigDecimal.ZERO;
    BigDecimal redMajDonneeSpecial = BigDecimal.ZERO;
    BigDecimal reduction_commercial = BigDecimal.ZERO;
    BigDecimal reduction_tarif1 = BigDecimal.ZERO;
    BigDecimal majoration_age = BigDecimal.ZERO;
    BigDecimal majoration_permis = BigDecimal.ZERO;
    BigDecimal matiere_inflamable = BigDecimal.ZERO;
    BigDecimal reduction_tarif3 = BigDecimal.ZERO;
    BigDecimal reduction_tarif2 = BigDecimal.ZERO;

    BigDecimal montantApport;
    BigDecimal montantGestion;
    BigDecimal totalTaxes;
    BigDecimal total_a_paye;
    BigDecimal totalCommision;
    BigDecimal primeTaxe;
    BigDecimal accessoirTaxe;
//    BigDecimal taxesAccessoires;
    BigDecimal totalTimb;

    @Enumerated(EnumType.STRING)
    private TypeQuittance typQuittance;
    Boolean validation;
    BigDecimal taux_apport;
    BigDecimal taux_gestion;

    public OrclassQuitance() {
        idDevise = new OrclassDevise();
        idPolice = new OrclassPolice();
//        idTimbreDimension = new OrclasseTimbreDimension();
//        idTypeQuitance = new OrclassTypeQuitance();
    }

    public OrclassPolice getIdPolice() {
        return idPolice;
    }

    public void setIdPolice(OrclassPolice idPolice) {
        this.idPolice = idPolice;
    }

    public OrclassEntreprises getIdEntreprise() {
        return idEntreprise;
    }

    public void setIdEntreprise(OrclassEntreprises idEntreprise) {
        this.idEntreprise = idEntreprise;
    }

//    public OrclassTypeQuitance getIdTypeQuitance() {
//        return idTypeQuitance;
//    }
//
//    public void setIdTypeQuitance(OrclassTypeQuitance idTypeQuitance) {
//        this.idTypeQuitance = idTypeQuitance;
//    }
    public OrclasseTimbreDimension getIdTimbreDimension() {
        return idTimbreDimension;
    }

    public void setIdTimbreDimension(OrclasseTimbreDimension idTimbreDimension) {
        this.idTimbreDimension = idTimbreDimension;
    }

    public OrclassDevise getIdDevise() {
        return idDevise;
    }

    public void setIdDevise(OrclassDevise idDevise) {
        this.idDevise = idDevise;
    }

    public Date getDate_saisie() {
        return date_saisie;
    }

    public void setDate_saisie(Date date_saisie) {
        this.date_saisie = date_saisie;
    }

    public Date getDate_effet() {
        return date_effet;
    }

    public void setDate_effet(Date date_effet) {
        this.date_effet = date_effet;
    }

    public Date getDate_validation() {
        return date_validation;
    }

    public void setDate_validation(Date date_validation) {
        this.date_validation = date_validation;
    }

    public Date getDate_echeance() {
        return date_echeance;
    }

    public void setDate_echeance(Date date_echeance) {
        this.date_echeance = date_echeance;
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

    public Date getDateEmission() {
        return dateEmission;
    }

    public void setDateEmission(Date dateEmission) {
        this.dateEmission = dateEmission;
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

    public BigDecimal getPrimeNette() {
        return primeNette;
    }

    public void setPrimeNette(BigDecimal primeNette) {
        this.primeNette = primeNette;
    }

    public BigDecimal getTaxePrime() {
        return taxePrime;
    }

    public void setTaxePrime(BigDecimal taxePrime) {
        this.taxePrime = taxePrime;
    }

    public BigDecimal getMontant_Accessoire() {
        return montant_Accessoire;
    }

    public void setMontant_Accessoire(BigDecimal montant_Accessoire) {
        this.montant_Accessoire = montant_Accessoire;
    }

    public BigDecimal getTaxeAccessoir() {
        return taxeAccessoir;
    }

    public void setTaxeAccessoir(BigDecimal taxeAccessoir) {
        this.taxeAccessoir = taxeAccessoir;
    }

    public BigDecimal getMontantCommision() {
        return montantCommision;
    }

    public void setMontantCommision(BigDecimal montantCommision) {
        this.montantCommision = montantCommision;
    }

    public BigDecimal getTaxeCommision() {
        return taxeCommision;
    }

    public void setTaxeCommision(BigDecimal taxeCommision) {
        this.taxeCommision = taxeCommision;
    }

    public BigDecimal getTimbreDimension() {
        return timbreDimension;
    }

    public void setTimbreDimension(BigDecimal timbreDimension) {
        this.timbreDimension = timbreDimension;
    }

    public BigDecimal getTimbreGradue() {
        return timbreGradue;
    }

    public void setTimbreGradue(BigDecimal timbreGradue) {
        this.timbreGradue = timbreGradue;
    }

    public BigDecimal getMontantApport() {
        return montantApport;
    }

    public void setMontantApport(BigDecimal montantApport) {
        this.montantApport = montantApport;
    }

    public BigDecimal getMontantGestion() {
        return montantGestion;
    }

    public void setMontantGestion(BigDecimal montantGestion) {
        this.montantGestion = montantGestion;
    }

    public BigDecimal getTotalTaxes() {
        return totalTaxes;
    }

    public void setTotalTaxes(BigDecimal totalTaxes) {
        this.totalTaxes = totalTaxes;
    }

    public BigDecimal getTotal_a_paye() {
        return total_a_paye;
    }

    public void setTotal_a_paye(BigDecimal total_a_paye) {
        this.total_a_paye = total_a_paye;
    }

    public BigDecimal getTotalCommision() {
        return totalCommision;
    }

    public void setTotalCommision(BigDecimal totalCommision) {
        this.totalCommision = totalCommision;
    }

    public TypeQuittance getTypQuittance() {
        return typQuittance;
    }

    public void setTypQuittance(TypeQuittance typQuittance) {
        this.typQuittance = typQuittance;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

//    public BigDecimal getTaxesAccessoires() {
//        return taxesAccessoires;
//    }
//
//    public void setTaxesAccessoires(BigDecimal taxesAccessoires) {
//        this.taxesAccessoires = taxesAccessoires;
//    }
    public BigDecimal getPrimeTaxe() {
        return primeTaxe;
    }

    public void setPrimeTaxe(BigDecimal primeTaxe) {
        this.primeTaxe = primeTaxe;
    }

    public BigDecimal getAccessoirTaxe() {
        return accessoirTaxe;
    }

    public void setAccessoirTaxe(BigDecimal accessoirTaxe) {
        this.accessoirTaxe = accessoirTaxe;
    }

    public BigDecimal getTotalTimb() {
        return totalTimb;
    }

    public void setTotalTimb(BigDecimal totalTimb) {
        this.totalTimb = totalTimb;
    }

    public Boolean getValidation() {
        return validation;
    }

    public void setValidation(Boolean validation) {
        this.validation = validation;
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

    public OrclassAvenant getIdAvenant() {
        return idAvenant;
    }

    public void setIdAvenant(OrclassAvenant idAvenant) {
        this.idAvenant = idAvenant;
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
        if (!(object instanceof OrclassQuitance)) {
            return false;
        }
        OrclassQuitance other = (OrclassQuitance) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modele.OrclassQuitance[ id=" + id + " ]";
    }

    public static Comparator<OrclassQuitance> ByCodeApporteurASC = new Comparator<OrclassQuitance>() {
        public int compare(OrclassQuitance o1, OrclassQuitance o2) /*     */ {
            return o1.idPolice.getIdApporteur().getIdRefApporteur().getCode().compareTo(o2.idPolice.getIdApporteur().getIdRefApporteur().getCode());
        }
    };

    public static Comparator<OrclassQuitance> ByCodeAgenceASC = new Comparator<OrclassQuitance>() {
        public int compare(OrclassQuitance o1, OrclassQuitance o2) /*     */ {
            return o1.idPolice.getIdIntermediaire().getIdRefIntermediaire().getCode().compareTo(o2.idPolice.getIdApporteur().getIdRefApporteur().getCode());
        }
    };
    public static Comparator<OrclassQuitance> ByIdQuittanceASC = new Comparator<OrclassQuitance>() {
        public int compare(OrclassQuitance o1, OrclassQuitance o2) /*     */ {
            return o1.id.compareTo(o2.id);
        }
    };

    public static Comparator<OrclassQuitance> ByCodeBrancheASC = new Comparator<OrclassQuitance>() {
        public int compare(OrclassQuitance o1, OrclassQuitance o2) /*     */ {
            return o1.idPolice.getIdCategories().getIdBranche().getCode().compareTo(o2.idPolice.getIdCategories().getIdBranche().getCode());
        }
    };

    public static Comparator<OrclassQuitance> ByCodeCategoriesASC = new Comparator<OrclassQuitance>() {
        public int compare(OrclassQuitance o1, OrclassQuitance o2) /*     */ {
            return o1.idPolice.getIdCategories().getCode().compareTo(o2.idPolice.getIdCategories().getCode());
        }
    };

    public BigDecimal getTaxe_asac_fga() {
        return taxe_asac_fga;
    }

    public void setTaxe_asac_fga(BigDecimal taxe_asac_fga) {
        this.taxe_asac_fga = taxe_asac_fga;
    }

    public BigDecimal getTaxe_caterose() {
        return taxe_caterose;
    }

    public void setTaxe_caterose(BigDecimal taxe_caterose) {
        this.taxe_caterose = taxe_caterose;
    }

    public BigDecimal getBonus() {
        return bonus;
    }

    public void setBonus(BigDecimal bonus) {
        this.bonus = bonus;
    }

    public BigDecimal getRed_statut_socioprof() {
        return red_statut_socioprof;
    }

    public void setRed_statut_socioprof(BigDecimal red_statut_socioprof) {
        this.red_statut_socioprof = red_statut_socioprof;
    }

    public BigDecimal getRed_duree_condit() {
        return red_duree_condit;
    }

    public void setRed_duree_condit(BigDecimal red_duree_condit) {
        this.red_duree_condit = red_duree_condit;
    }

    public BigDecimal getReduction() {
        return reduction;
    }

    public void setReduction(BigDecimal reduction) {
        this.reduction = reduction;
    }

    public BigDecimal getTaxe_tva() {
        return taxe_tva;
    }

    public void setTaxe_tva(BigDecimal taxe_tva) {
        this.taxe_tva = taxe_tva;
    }

    public BigDecimal getTaxe_pool_tpv() {
        return taxe_pool_tpv;
    }

    public void setTaxe_pool_tpv(BigDecimal taxe_pool_tpv) {
        this.taxe_pool_tpv = taxe_pool_tpv;
    }

    public BigDecimal getTaxe_tva_acc() {
        return taxe_tva_acc;
    }

    public void setTaxe_tva_acc(BigDecimal taxe_tva_acc) {
        this.taxe_tva_acc = taxe_tva_acc;
    }

    public BigDecimal getTaxe_tva_sur_asac() {
        return taxe_tva_sur_asac;
    }

    public void setTaxe_tva_sur_asac(BigDecimal taxe_tva_sur_asac) {
        this.taxe_tva_sur_asac = taxe_tva_sur_asac;
    }

    public BigDecimal getTimbr_Gradue__vignette() {
        return timbr_Gradue__vignette;
    }

    public void setTimbr_Gradue__vignette(BigDecimal timbr_Gradue__vignette) {
        this.timbr_Gradue__vignette = timbr_Gradue__vignette;
    }

    public BigDecimal getTimbr_Gradue_cp() {
        return timbr_Gradue_cp;
    }

    public void setTimbr_Gradue_cp(BigDecimal timbr_Gradue_cp) {
        this.timbr_Gradue_cp = timbr_Gradue_cp;
    }

    public BigDecimal getRedMajDonneeSpecial() {
        return redMajDonneeSpecial;
    }

    public void setRedMajDonneeSpecial(BigDecimal redMajDonneeSpecial) {
        this.redMajDonneeSpecial = redMajDonneeSpecial;
    }

    public BigDecimal getReduction_commercial() {
        return reduction_commercial;
    }

    public void setReduction_commercial(BigDecimal reduction_commercial) {
        this.reduction_commercial = reduction_commercial;
    }

    public BigDecimal getReduction_tarif1() {
        return reduction_tarif1;
    }

    public void setReduction_tarif1(BigDecimal reduction_tarif1) {
        this.reduction_tarif1 = reduction_tarif1;
    }

    public BigDecimal getMajoration_age() {
        return majoration_age;
    }

    public void setMajoration_age(BigDecimal majoration_age) {
        this.majoration_age = majoration_age;
    }

    public BigDecimal getMajoration_permis() {
        return majoration_permis;
    }

    public void setMajoration_permis(BigDecimal majoration_permis) {
        this.majoration_permis = majoration_permis;
    }

    public BigDecimal getMatiere_inflamable() {
        return matiere_inflamable;
    }

    public void setMatiere_inflamable(BigDecimal matiere_inflamable) {
        this.matiere_inflamable = matiere_inflamable;
    }

    public BigDecimal getReduction_tarif3() {
        return reduction_tarif3;
    }

    public void setReduction_tarif3(BigDecimal reduction_tarif3) {
        this.reduction_tarif3 = reduction_tarif3;
    }

    public BigDecimal getReduction_tarif2() {
        return reduction_tarif2;
    }

    public void setReduction_tarif2(BigDecimal reduction_tarif2) {
        this.reduction_tarif2 = reduction_tarif2;
    }
    

}
