/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.math.BigDecimal;
import java.math.BigInteger;
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
import javax.validation.constraints.NotNull;

/**
 *
 * @author hp
 */
@Entity
@Table(name = "ORCLASS_TIMBRE")
public class OrclassTimbre implements DAOEntry {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    @Column(name = "ID_TIMBRE")
    private Long id;

    @JoinColumn(name = "ID_REF_TIMBRE", referencedColumnName = "ID_REF_TIMBRE")
    @ManyToOne(optional = false)
    private OrclassRefTimbreGradue idRefTimbreGradue;
    @JoinColumn(name = "ID_CATEGORIE", referencedColumnName = "ID_CATEGORIE")
    @ManyToOne(optional = true)
    private OrclassCategories idCategories;
    @JoinColumn(name = "ID_ENTREPRISE", referencedColumnName = "ID_ENTREPRISE")
    @ManyToOne(optional = false)
    private OrclassEntreprises idEntreprises;
    BigInteger puissance_min = BigInteger.ZERO;
    BigInteger puissance_max = BigInteger.ZERO;
    BigDecimal prime_mini = BigDecimal.ZERO;
    BigDecimal prime_max = BigDecimal.ZERO;
    BigDecimal taux_tg_cp_fg = BigDecimal.ZERO;
    BigDecimal valeur_tg_cp_fg = BigDecimal.ZERO;
    @Column(name = "DATE_EFFET")
    @Temporal(TemporalType.DATE)
    private Date date_effet;

    private String saisir_par;
      private String Modifier_par;
    @Column(name = "DATE_SAISIE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date_saisie;
        @Column(name = "DATE_Modifier")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date_Modifier;
     

    public OrclassTimbre() {
        idRefTimbreGradue = new OrclassRefTimbreGradue();
    }

    public OrclassCategories getIdCategories() {
        return idCategories;
    }

    public void setIdCategories(OrclassCategories idCategories) {
        this.idCategories = idCategories;
    }

    public BigInteger getPuissance_min() {
        return puissance_min;
    }

    public void setPuissance_min(BigInteger puissance_min) {
        this.puissance_min = puissance_min;
    }

    public BigInteger getPuissance_max() {
        return puissance_max;
    }

    public void setPuissance_max(BigInteger puissance_max) {
        this.puissance_max = puissance_max;
    }

    public BigDecimal getPrime_mini() {
        return prime_mini;
    }

    public void setPrime_mini(BigDecimal prime_mini) {
        this.prime_mini = prime_mini;
    }

    public BigDecimal getPrime_max() {
        return prime_max;
    }

    public void setPrime_max(BigDecimal prime_max) {
        this.prime_max = prime_max;
    }

    public BigDecimal getTaux_tg_cp_fg() {
        return taux_tg_cp_fg;
    }

    public void setTaux_tg_cp_fg(BigDecimal taux_tg_cp_fg) {
        this.taux_tg_cp_fg = taux_tg_cp_fg;
    }

    public BigDecimal getValeur_tg_cp_fg() {
        return valeur_tg_cp_fg;
    }

    public void setValeur_tg_cp_fg(BigDecimal valeur_tg_cp_fg) {
        this.valeur_tg_cp_fg = valeur_tg_cp_fg;
    }

    public OrclassRefTimbreGradue getIdRefTimbreGradue() {
        return idRefTimbreGradue;
    }

    public void setIdRefTimbreGradue(OrclassRefTimbreGradue idRefTimbreGradue) {
        this.idRefTimbreGradue = idRefTimbreGradue;
    }

    public OrclassEntreprises getIdEntreprises() {
        return idEntreprises;
    }

    public void setIdEntreprises(OrclassEntreprises idEntreprises) {
        this.idEntreprises = idEntreprises;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate_effet() {
        return date_effet;
    }

    public void setDate_effet(Date date_effet) {
        this.date_effet = date_effet;
    }

    public String getSaisir_par() {
        return saisir_par;
    }

    public void setSaisir_par(String saisir_par) {
        this.saisir_par = saisir_par;
    }

    public Date getDate_saisie() {
        return date_saisie;
    }

    public void setDate_saisie(Date date_saisie) {
        this.date_saisie = date_saisie;
    }

    public String getModifier_par() {
        return Modifier_par;
    }

    public void setModifier_par(String Modifier_par) {
        this.Modifier_par = Modifier_par;
    }

    public Date getDate_Modifier() {
        return date_Modifier;
    }

    public void setDate_Modifier(Date date_Modifier) {
        this.date_Modifier = date_Modifier;
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
        if (!(object instanceof OrclassTimbre)) {
            return false;
        }
        OrclassTimbre other = (OrclassTimbre) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dao.OrclassTimbre[ id=" + id + " ]";
    }

}
