/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.math.BigInteger;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author frankjiatou
 */
//@Table(name = "ORCLASS_POLICE", uniqueConstraints = @UniqueConstraint(columnNames = {"ID_ENTREPRISE", "ID_INTERMEDIAIRE", "ID_CATEGORIE", "NUMERO_POLICE"}))

@Entity
@Table(name = "ORCLASS_PROPOSITION", uniqueConstraints = @UniqueConstraint(columnNames = {"ID_ENTREPRISE", "ID_INTERMEDIAIRE", "ID_CATEGORIE","POLICE_PROPOSITION"}))
public class OrclassProposition implements DAOEntry {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "POLICE_PROPOSITION")
    BigInteger police_proposition;
    @Column(name = "POLICE_VALIDE")
    BigInteger police;
       @JoinColumn(name = "ID_INTERMEDIAIRE", referencedColumnName = "ID_INTERMEDIAIRE")
    @ManyToOne(optional = false)
    private OrclassIntermediaires idIntermediaire;

    @JoinColumn(name = "ID_ENTREPRISE", referencedColumnName = "ID_ENTREPRISE")
    @ManyToOne(optional = false)
    private OrclassEntreprises idEntreprises;
    
     @JoinColumn(name = "ID_POLICE", referencedColumnName = "ID_POLICE")
   @ManyToOne(optional = true)
    private OrclassPolice idPolice;
     
     @JoinColumn(name = "ID_CATEGORIE", referencedColumnName = "ID_CATEGORIE")
    @ManyToOne(optional = false)
    private OrclassCategories idCategories;

    public OrclassProposition() {

    }

    public OrclassProposition(BigInteger police_proposition) {
        this.police_proposition = police_proposition;
    }

    public BigInteger getPolice_proposition() {
        return police_proposition;
    }

    public void setPolice_proposition(BigInteger police_proposition) {
        this.police_proposition = police_proposition;
    }

    public BigInteger getPolice() {
        return police;
    }

    public void setPolice(BigInteger police) {
        this.police = police;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public OrclassIntermediaires getIdIntermediaire() {
        return idIntermediaire;
    }

    public void setIdIntermediaire(OrclassIntermediaires idIntermediaire) {
        this.idIntermediaire = idIntermediaire;
    }

    public OrclassEntreprises getIdEntreprises() {
        return idEntreprises;
    }

    public void setIdEntreprises(OrclassEntreprises idEntreprises) {
        this.idEntreprises = idEntreprises;
    }

    public OrclassPolice getIdPolice() {
        return idPolice;
    }

    public void setIdPolice(OrclassPolice idPolice) {
        this.idPolice = idPolice;
    }

    public OrclassCategories getIdCategories() {
        return idCategories;
    }

    public void setIdCategories(OrclassCategories idCategories) {
        this.idCategories = idCategories;
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
        if (!(object instanceof OrclassProposition)) {
            return false;
        }
        OrclassProposition other = (OrclassProposition) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modele.OrclassProposition[ id=" + id + " ]";
    }

}
