/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import enums.NatureTypeTaxe;
import enums.RegimeTaxes;
import java.io.Serializable;
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
 * @author JIATOU FRANCK
 */
@Entity
@Table(name = "ORCLASS_REGIME_TAXE", uniqueConstraints = @UniqueConstraint(columnNames = {"CODE", "LIBELLE"}))

public class OrclassRegimeTaxe implements DAOEntry {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    @Column(name = "ID_RG_TAXE")
    private Long id;
    @Size(max = 32)
    @Column(name = "CODE", unique = true)
    private String code;

    @Size(max = 255)
    @Column(name = "LIBELLE", unique = true)
    private String libelle;
    private Boolean exoneration_timbre_gradue = Boolean.FALSE;
    @Enumerated(EnumType.STRING)
    private RegimeTaxes regimeTaxes;

    public OrclassRegimeTaxe(String code, String libelle) {
        this.code = code;
        this.libelle = libelle;
    }

    public OrclassRegimeTaxe() {
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

    public Boolean getExoneration_timbre_gradue() {
        return exoneration_timbre_gradue;
    }

    public void setExoneration_timbre_gradue(Boolean exoneration_timbre_gradue) {
        this.exoneration_timbre_gradue = exoneration_timbre_gradue;
    }

    public RegimeTaxes getRegimeTaxes() {
        return regimeTaxes;
    }

    public void setRegimeTaxes(RegimeTaxes regimeTaxes) {
        this.regimeTaxes = regimeTaxes;
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
        if (!(object instanceof OrclassRegimeTaxe)) {
            return false;
        }
        OrclassRegimeTaxe other = (OrclassRegimeTaxe) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modele.OrclassRegimeTaxe[ id=" + id + " ]";
    }

}
