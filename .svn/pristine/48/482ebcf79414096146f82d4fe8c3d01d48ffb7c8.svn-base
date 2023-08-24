/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import enums.LibelleFrais;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author JIATOU FRANCK
 */
@Entity
@Table(name = "ORCLASS_REF_TIMBRE")
public class OrclassRefTimbreGradue implements DAOEntry {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    @Column(name = "ID_REF_TIMBRE")
    private Long id;
    private String code;
    private String libelle;
    @Column(name = "LIBELLE_FRAIS")
    @Enumerated(EnumType.STRING)
    private LibelleFrais libelleFrais;

    public OrclassRefTimbreGradue() {
        
    }

    public OrclassRefTimbreGradue(String code, String libelle) {
        this.code = code;
        this.libelle = libelle;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LibelleFrais getLibelleFrais() {
        return libelleFrais;
    }

    public void setLibelleFrais(LibelleFrais libelleFrais) {
        this.libelleFrais = libelleFrais;
    }

    public OrclassRefTimbreGradue(String code, String libelle, LibelleFrais libelleFrais) {
        this.code = code;
        this.libelle = libelle;
        this.libelleFrais = libelleFrais;
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
        if (!(object instanceof OrclassRefTimbreGradue)) {
            return false;
        }
        OrclassRefTimbreGradue other = (OrclassRefTimbreGradue) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modele.OrclassRefTimbreGradue[ id=" + id + " ]";
    }

}
