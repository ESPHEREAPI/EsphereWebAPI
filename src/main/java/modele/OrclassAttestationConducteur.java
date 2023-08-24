/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author JIATOU FRANCK
 */
@Entity
@Table(name = "ORCLASS_ATTEST_CONDU")
public class OrclassAttestationConducteur implements DAOEntry {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
      @NotNull
    @Column(name = "ID_ATTEST_CONDUCT")
    private Long id;
    private String nomCmplet;
    private String adresse;
      @JoinColumn(name = "ID_VILLE", referencedColumnName = "ID_VILLE")
    @ManyToOne(optional = false)
    private OrclassVille idVille;
      private String profession;

    public OrclassAttestationConducteur() {
        
    }

    public OrclassAttestationConducteur(String nomCmplet, String adresse, OrclassVille idVille, String profession) {
        this.nomCmplet = nomCmplet;
        this.adresse = adresse;
        this.idVille = idVille;
        this.profession = profession;
    }
      
      

    public String getNomCmplet() {
        return nomCmplet;
    }

    public void setNomCmplet(String nomCmplet) {
        this.nomCmplet = nomCmplet;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public OrclassVille getIdVille() {
        return idVille;
    }

    public void setIdVille(OrclassVille idVille) {
        this.idVille = idVille;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
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
        if (!(object instanceof OrclassAttestationConducteur)) {
            return false;
        }
        OrclassAttestationConducteur other = (OrclassAttestationConducteur) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modele.OrclassTestationConducteur[ id=" + id + " ]";
    }
    
}
