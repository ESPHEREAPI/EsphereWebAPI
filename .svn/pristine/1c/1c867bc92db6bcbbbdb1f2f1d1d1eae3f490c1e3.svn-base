/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import enums.TypeBureau;
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
 * @author hp
 */
@Entity
public class OrclassTypeBureau implements DAOEntry {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_TYPE_BUREAU")
    private Long id;
    String code;
    String libelle;
    @Column(name = "TYPE_BUREAU")
    @Enumerated(EnumType.STRING)
    private TypeBureau typeBureau;

    Boolean showAllCompagnies = Boolean.FALSE;

    @JoinColumn(name = "ID_ENTREPRISE", referencedColumnName = "ID_ENTREPRISE")
    @ManyToOne(optional = true)
    private OrclassEntreprises idEntreprise;

    public OrclassTypeBureau(String libelle, TypeBureau typeBureau) {
        this.libelle = libelle;
        this.typeBureau = typeBureau;
    }

    
    public OrclassTypeBureau() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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

    
    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public TypeBureau getTypeBureau() {
        return typeBureau;
    }

    public void setTypeBureau(TypeBureau typeBureau) {
        this.typeBureau = typeBureau;
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
        if (!(object instanceof OrclassTypeBureau)) {
            return false;
        }
        OrclassTypeBureau other = (OrclassTypeBureau) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modele.OrclassTypeBureau[ id=" + id + " ]";
    }

}
