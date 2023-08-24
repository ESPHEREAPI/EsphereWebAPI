/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import enums.ModeCalculDetailMaladie;
import enums.TypeDetailMaladie;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author JIATOU FRANCK
 */
@Entity
public class OrclassGroupPlafondPrestation implements DAOEntry {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
     @JoinColumn(name = "ID_GROUPE_PLAF_PRES", referencedColumnName = "ID_REF_GROUPE")
    @ManyToOne(optional = false)
    private OrclasseRefGroupe idGroup;
       @JoinColumn(name = "ID_ENTREPRISE", referencedColumnName = "ID_ENTREPRISE")
    @ManyToOne(optional = false)
    private OrclassEntreprises idEntreprise;
        @JoinColumn(name = "ID_PRESTATION", referencedColumnName = "ID_PRESTATION")
    @ManyToOne(optional = false)
    private OrclassPrestation idPrestation;
      @JoinColumn(name = "ID_RUBRIQUE", referencedColumnName = "ID_RUBRIQUE")
    @ManyToOne(optional = false)
    private OrclassRubrique idRubrique;
         @JoinColumn(name = "ID_PLAFOND", referencedColumnName = "ID_PLAFOND")
    @ManyToOne(optional = false)
    private OrclassPlafondMaladie idPlafondMaladie;
         
             BigDecimal forfait;
    BigDecimal taux;
    BigDecimal barem;
    BigDecimal plafond;
    String code_ss;

    @Enumerated(EnumType.STRING)
    @Column(name = "TYPE_DETAIL_MALADIE")
    private TypeDetailMaladie typeDetailMaladie;
    @Enumerated(EnumType.STRING)
    @Column(name = "MODE_CALCUL_MALADIE")
    private ModeCalculDetailMaladie modeCalculDetailMaladie;

    public OrclassGroupPlafondPrestation() {
        idGroup=new OrclasseRefGroupe();
        idPrestation=new OrclassPrestation();
        idRubrique=new OrclassRubrique();
        idPlafondMaladie=new OrclassPlafondMaladie();
    }

      
      
    public OrclasseRefGroupe getIdGroup() {
        return idGroup;
    }

    public void setIdGroup(OrclasseRefGroupe idGroup) {
        this.idGroup = idGroup;
    }

    public OrclassEntreprises getIdEntreprise() {
        return idEntreprise;
    }

    public void setIdEntreprise(OrclassEntreprises idEntreprise) {
        this.idEntreprise = idEntreprise;
    }

    public OrclassPrestation getIdPrestation() {
        return idPrestation;
    }

    public void setIdPrestation(OrclassPrestation idPrestation) {
        this.idPrestation = idPrestation;
    }

    public OrclassRubrique getIdRubrique() {
        return idRubrique;
    }

    public void setIdRubrique(OrclassRubrique idRubrique) {
        this.idRubrique = idRubrique;
    }
      
      

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public OrclassPlafondMaladie getIdPlafondMaladie() {
        return idPlafondMaladie;
    }

    public void setIdPlafondMaladie(OrclassPlafondMaladie idPlafondMaladie) {
        this.idPlafondMaladie = idPlafondMaladie;
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
    
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrclassGroupPlafondPrestation)) {
            return false;
        }
        OrclassGroupPlafondPrestation other = (OrclassGroupPlafondPrestation) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modele.OrclassGroupPlafondPrestation[ id=" + id + " ]";
    }
    
}
