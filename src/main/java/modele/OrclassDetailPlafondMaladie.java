/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import enums.ModeCalculDetailMaladie;
import enums.TypeDetailMaladie;
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
import javax.validation.constraints.NotNull;

/**
 *
 * @author hp
 */
@Entity
@Table(name = "ORCLASS_DETAIL_PLAF_MALA")
public class OrclassDetailPlafondMaladie implements DAOEntry {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    @Column(name = "ID_Det_PLA_MAL")
    private Long id;

    @JoinColumn(name = "ID_ENTREPRISE", referencedColumnName = "ID_ENTREPRISE")
    @ManyToOne(optional = false)
    private OrclassEntreprises idEntreprise;
    @JoinColumn(name = "ID_PLAFOND", referencedColumnName = "ID_PLAFOND")
    @ManyToOne(optional = false)
    private OrclassPlafondMaladie idPlafondMaladie;
    @JoinColumn(name = "ID_RUB_PREST", referencedColumnName = "ID_RUB_PREST")
    @ManyToOne(optional = false)
    private OrclassRubriquePrestation idRubriquePrestation;
    BigDecimal forfait;
    BigDecimal taux;
    BigDecimal barem;
    BigDecimal plafond;
    String code_ss;
    @Column(name = "DATE_CREATION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreation;
    @Column(name = "DATE_MODIFICATION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateModification;
    @Enumerated(EnumType.STRING) 
    @Column(name = "TYPE_DETAIL_MALADIE")
    private TypeDetailMaladie typeDetailMaladie;
      @Enumerated(EnumType.STRING) 
    @Column(name = "MODE_CALCUL_MALADIE")
    private ModeCalculDetailMaladie modeCalculDetailMaladie;

    public OrclassDetailPlafondMaladie() {
        idPlafondMaladie=new OrclassPlafondMaladie();
        idRubriquePrestation=new OrclassRubriquePrestation();
    }

    public OrclassEntreprises getIdEntreprise() {
        return idEntreprise;
    }

    public void setIdEntreprise(OrclassEntreprises idEntreprise) {
        this.idEntreprise = idEntreprise;
    }

    public OrclassPlafondMaladie getIdPlafondMaladie() {
        return idPlafondMaladie;
    }

    public void setIdPlafondMaladie(OrclassPlafondMaladie idPlafondMaladie) {
        this.idPlafondMaladie = idPlafondMaladie;
    }

    public OrclassRubriquePrestation getIdRubriquePrestation() {
        return idRubriquePrestation;
    }

    public void setIdRubriquePrestation(OrclassRubriquePrestation idRubriquePrestation) {
        this.idRubriquePrestation = idRubriquePrestation;
    }

    public BigDecimal getForfait() {
        return forfait;
    }

    public void setForfait(BigDecimal forfait) {
        this.forfait = forfait;
    }

    public BigDecimal getTaux() {
        return taux;
    }

    public void setTaux(BigDecimal taux) {
        this.taux = taux;
    }

    public BigDecimal getBarem() {
        return barem;
    }

    public void setBarem(BigDecimal barem) {
        this.barem = barem;
    }

    public BigDecimal getPlafond() {
        return plafond;
    }

    public void setPlafond(BigDecimal plafond) {
        this.plafond = plafond;
    }

    public String getCode_ss() {
        return code_ss;
    }

    public void setCode_ss(String code_ss) {
        this.code_ss = code_ss;
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

    public TypeDetailMaladie getTypeDetailMaladie() {
        return typeDetailMaladie;
    }

    public void setTypeDetailMaladie(TypeDetailMaladie typeDetailMaladie) {
        this.typeDetailMaladie = typeDetailMaladie;
    }

    public ModeCalculDetailMaladie getModeCalculDetailMaladie() {
        return modeCalculDetailMaladie;
    }

    public void setModeCalculDetailMaladie(ModeCalculDetailMaladie modeCalculDetailMaladie) {
        this.modeCalculDetailMaladie = modeCalculDetailMaladie;
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
        if (!(object instanceof OrclassDetailPlafondMaladie)) {
            return false;
        }
        OrclassDetailPlafondMaladie other = (OrclassDetailPlafondMaladie) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modele.OrclassDetailPlafondMaladie[ id=" + id + " ]";
    }

}
