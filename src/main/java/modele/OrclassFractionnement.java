/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author hp
 */
@Entity
@Table(name = "ORCLASS_FRACTION")
public class OrclassFractionnement implements DAOEntry {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    @Column(name = "ID_FRACTION")
    private Long id;
  @Column(name = "CODE",unique = true)
    private String code;
    private String libelle;
    BigInteger nombre_Fractionnement=BigInteger.ZERO;

    public OrclassFractionnement(String code, String libelle,Integer nombre_Fractionnement) {
        this.code = code;
        this.libelle = libelle;
        this.nombre_Fractionnement=BigInteger.valueOf(nombre_Fractionnement.longValue());
    }

    public OrclassFractionnement() {

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

    public BigInteger getNombre_Fractionnement() {
        return nombre_Fractionnement;
    }

    public void setNombre_Fractionnement(BigInteger nombre_Fractionnement) {
        this.nombre_Fractionnement = nombre_Fractionnement;
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
        if (!(object instanceof OrclassFractionnement)) {
            return false;
        }
        OrclassFractionnement other = (OrclassFractionnement) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modele.OrclasseFractionnement[ id=" + id + " ]";
    }

}
