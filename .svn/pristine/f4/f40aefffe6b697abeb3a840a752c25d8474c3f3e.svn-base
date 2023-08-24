/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.io.Serializable;
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
@Table(name = "ORCLASS_FRACTION_CATEGORIE", uniqueConstraints = @UniqueConstraint(columnNames = {"ID_CATEGORIE", "ID_FRACTION","DATE_EFFET","ID_ENTREPRISE"}))
public class OrclassFractionnementCategories implements DAOEntry {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    @Column(name = "ID_FRACTION_CATEGORIE")
    private Long id;
    @JoinColumn(name = "ID_FRACTION", referencedColumnName = "ID_FRACTION")
    @ManyToOne(optional = false)
    private OrclassFractionnement idFractionnemente;
    @JoinColumn(name = "ID_CATEGORIE", referencedColumnName = "ID_CATEGORIE")
    @ManyToOne(optional = false)
    private OrclassCategories idCategories;
     @JoinColumn(name = "ID_ENTREPRISE", referencedColumnName = "ID_ENTREPRISE")
    @ManyToOne(optional = false)
    private OrclassEntreprises idEntreprise;
    @Column(name = "DATE_EFFET")
    @Temporal(TemporalType.DATE)
    private Date dateeffet;
    BigDecimal tauxFraction;
    Boolean defaut = Boolean.FALSE;

    public OrclassFractionnementCategories() {
        idCategories=new OrclassCategories();
        idFractionnemente=new OrclassFractionnement();
    }
    
    

    public OrclassFractionnement getIdFractionnemente() {
        return idFractionnemente;
    }

    public void setIdFractionnemente(OrclassFractionnement idFractionnemente) {
        this.idFractionnemente = idFractionnemente;
    }

    public OrclassCategories getIdCategories() {
        return idCategories;
    }

    public void setIdCategories(OrclassCategories idCategories) {
        this.idCategories = idCategories;
    }

    public Date getDateeffet() {
        return dateeffet;
    }

    public void setDateeffet(Date dateeffet) {
        this.dateeffet = dateeffet;
    }

    public BigDecimal getTauxFraction() {
        return tauxFraction;
    }

    public void setTauxFraction(BigDecimal tauxFraction) {
        this.tauxFraction = tauxFraction;
    }

    public Boolean getDefaut() {
        return defaut;
    }

    public void setDefaut(Boolean defaut) {
        this.defaut = defaut;
    }

    public OrclassEntreprises getIdEntreprise() {
        return idEntreprise;
    }

    public void setIdEntreprise(OrclassEntreprises idEntreprise) {
        this.idEntreprise = idEntreprise;
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
        if (!(object instanceof OrclassFractionnementCategories)) {
            return false;
        }
        OrclassFractionnementCategories other = (OrclassFractionnementCategories) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modele.OrclassFractionnementCategories[ id=" + id + " ]";
    }

}
