/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

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
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

/**
 *
 * @author hp
 */
@Entity
@Table(name = "ORCLASSREDUCTION", uniqueConstraints = @UniqueConstraint(columnNames = {"ID_REF_RED", "DATE_EFFET", "ID_GARANTIE", "ID_ENTREPRISE"}))
public class OrclassReduction implements DAOEntry {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    @Column(name = "ID_REDUCTION")
    private Long id;

    @Column(name = "DATE_EFFET")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateEffet;
    @JoinColumn(name = "ID_REF_RED", referencedColumnName = "ID_REF_RED")
    @ManyToOne(optional = false)
    private OrclassRefReduction idRefReduction;
    @JoinColumn(name = "ID_GARANTIE", referencedColumnName = "ID_GARANTIE")
    @ManyToOne(optional = false)
    private OrclassGarantie idGarantie;
    @JoinColumn(name = "ID_ENTREPRISE", referencedColumnName = "ID_ENTREPRISE")
    @ManyToOne(optional = false)
    private OrclassEntreprises idEntreprise;
    @Column(name = "DATE_CREATION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreation;
    private String creer_par;
    @Column(name = "DATE_MoDIFICATION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateModification;
    private String modifier_par;
    BigDecimal taux = BigDecimal.ZERO;

    public OrclassReduction() {
        idGarantie = new OrclassGarantie();
        this.idGarantie.setIdCategories(new OrclassCategories());
        idRefReduction = new OrclassRefReduction();
    }

    public OrclassReduction(String code, String libelle) {

    }

    public OrclassRefReduction getIdRefReduction() {
        return idRefReduction;
    }

    public void setIdRefReduction(OrclassRefReduction idRefReduction) {
        this.idRefReduction = idRefReduction;
    }

    public Date getDateEffet() {
        return dateEffet;
    }

    public void setDateEffet(Date dateEffet) {
        this.dateEffet = dateEffet;
    }

    public OrclassGarantie getIdGarantie() {
        return idGarantie;
    }

    public void setIdGarantie(OrclassGarantie idGarantie) {
        this.idGarantie = idGarantie;
    }

    public OrclassEntreprises getIdEntreprise() {
        return idEntreprise;
    }

    public void setIdEntreprise(OrclassEntreprises idEntreprise) {
        this.idEntreprise = idEntreprise;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public String getCreer_par() {
        return creer_par;
    }

    public void setCreer_par(String creer_par) {
        this.creer_par = creer_par;
    }

    public Date getDateModification() {
        return dateModification;
    }

    public void setDateModification(Date dateModification) {
        this.dateModification = dateModification;
    }

    public String getModifier_par() {
        return modifier_par;
    }

    public void setModifier_par(String modifier_par) {
        this.modifier_par = modifier_par;
    }

    public BigDecimal getTaux() {
        return taux;
    }

    public void setTaux(BigDecimal taux) {
        this.taux = taux;
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
        if (!(object instanceof OrclassReduction)) {
            return false;
        }
        OrclassReduction other = (OrclassReduction) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modele.OrclassReduction[ id=" + id + " ]";
    }

}
