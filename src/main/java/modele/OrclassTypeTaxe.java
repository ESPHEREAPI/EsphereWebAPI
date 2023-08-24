/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import enums.LibelleFrais;
import enums.NatureTypeTaxe;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author admin
 */
@Entity
@Table(name = "ORCLASS_TYPE_TAXE", uniqueConstraints = @UniqueConstraint(columnNames = {"CODE", "LIBELLE"}))

public class OrclassTypeTaxe implements DAOEntry {

    private static final long serialVersionUID = 1L;

    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_TYPE_TAXE")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idTypeTaxe;

    @Size(max = 32)
    @Column(name = "CODE", unique = true)
    private String code;

    @Size(max = 255)
    @Column(name = "LIBELLE", unique = true)
    private String libelle;

    @Size(max = 2)
    @Column(name = "NATURE")
    private String nature;

    @Column(name = "REGISTRE_TAXE")
    private Short registreTaxe;
    @Column(name = "NATURE_TAXE")
    @Enumerated(EnumType.STRING)
    private NatureTypeTaxe natureTypeTaxe;
     @Column(name = "LIBELLE_FRAIS")
    @Enumerated(EnumType.STRING)
    private LibelleFrais libelleFrais;
    private String pour_impression;

    public OrclassTypeTaxe() {
    }

    public OrclassTypeTaxe(Long idTypeTaxe) {
        this.idTypeTaxe = idTypeTaxe;
    }

    public Long getIdTypeTaxe() {
        return idTypeTaxe;
    }

    public void setIdTypeTaxe(Long idTypeTaxe) {
        this.idTypeTaxe = idTypeTaxe;
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

    public String getNature() {
        return nature;
    }

    public void setNature(String nature) {
        this.nature = nature;
    }

    public Short getRegistreTaxe() {
        return registreTaxe;
    }

    public void setRegistreTaxe(Short registreTaxe) {
        this.registreTaxe = registreTaxe;
    }

    public NatureTypeTaxe getNatureTypeTaxe() {
        return natureTypeTaxe;
    }

    public void setNatureTypeTaxe(NatureTypeTaxe natureTypeTaxe) {
        this.natureTypeTaxe = natureTypeTaxe;
    }

    public String getPour_impression() {
        return pour_impression;
    }

    public void setPour_impression(String pour_impression) {
        this.pour_impression = pour_impression;
    }

    public LibelleFrais getLibelleFrais() {
        return libelleFrais;
    }

    public void setLibelleFrais(LibelleFrais libelleFrais) {
        this.libelleFrais = libelleFrais;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTypeTaxe != null ? idTypeTaxe.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrclassTypeTaxe)) {
            return false;
        }
        OrclassTypeTaxe other = (OrclassTypeTaxe) object;
        if ((this.idTypeTaxe == null && other.idTypeTaxe != null) || (this.idTypeTaxe != null && !this.idTypeTaxe.equals(other.idTypeTaxe))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modele.OrclassTypeTaxe[ idTypeTaxe=" + idTypeTaxe + " ]";
    }

}
