/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import enums.ModeProrata;
import enums.TypeDuree;
import enums.UniteDuree;
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

/**
 *
 * @author hp
 */
@Entity
@Table(name = "ORCLASS_DUREE")
public class OrclassDuree implements DAOEntry {

    private static final long serialVersionUID = 1L;
    @Id

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_DUREE")
    private Long id;
    @Column(name = "CODE", unique = true)
    private String code;
    private String libelle;
    Boolean showAllCompagnies = Boolean.FALSE;
    @JoinColumn(name = "ID_ENTREPRISE", referencedColumnName = "ID_ENTREPRISE")
    @ManyToOne(optional = true)
    private OrclassEntreprises idEntreprise;
    @Column(name = "DATE_CREATION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreation;
    @Column(name = "DATE_MODIFICATION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateModification;
    @Column(name = "TYPE_DUREE")
    @Enumerated(EnumType.STRING)
    private TypeDuree typeDuree;

    @Column(name = "UNITE_DUREE")
    @Enumerated(EnumType.STRING)
    private UniteDuree uniteDuree;
    @Column(name = "MODE_PRORATA")
    @Enumerated(EnumType.STRING)
    private ModeProrata modeProrata;
    @Column(name = "BASE_PRORATA")
    BigInteger baseProrata;
    @Column(name = "DUREE", nullable = false)
    BigInteger minDuree;
    @Column(name = "MAX_DUREE")
    BigInteger maxDuree;
       

    public OrclassDuree() {
        this.dateCreation=new Date();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public Boolean getShowAllCompagnies() {
        return showAllCompagnies;
    }

    public void setShowAllCompagnies(Boolean showAllCompagnies) {
        this.showAllCompagnies = showAllCompagnies;
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

    public Date getDateModification() {
        return dateModification;
    }

    public void setDateModification(Date dateModification) {
        this.dateModification = dateModification;
    }

    public TypeDuree getTypeDuree() {
        return typeDuree;
    }

    public void setTypeDuree(TypeDuree typeDuree) {
        this.typeDuree = typeDuree;
    }

    public UniteDuree getUniteDuree() {
        return uniteDuree;
    }

    public void setUniteDuree(UniteDuree uniteDuree) {
        this.uniteDuree = uniteDuree;
    }

    public ModeProrata getModeProrata() {
        return modeProrata;
    }

    public void setModeProrata(ModeProrata modeProrata) {
        this.modeProrata = modeProrata;
    }

    public BigInteger getBaseProrata() {
        return baseProrata;
    }

    public void setBaseProrata(BigInteger baseProrata) {
        this.baseProrata = baseProrata;
    }

    public BigInteger getMinDuree() {
        return minDuree;
    }

    public void setMinDuree(BigInteger minDuree) {
        this.minDuree = minDuree;
    }

   
    public BigInteger getMaxDuree() {
        return maxDuree;
    }

    public void setMaxDuree(BigInteger maxDuree) {
        this.maxDuree = maxDuree;
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
        if (!(object instanceof OrclassDuree)) {
            return false;
        }
        OrclassDuree other = (OrclassDuree) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modele.OrclassDuree[ id=" + id + " ]";
    }

}
