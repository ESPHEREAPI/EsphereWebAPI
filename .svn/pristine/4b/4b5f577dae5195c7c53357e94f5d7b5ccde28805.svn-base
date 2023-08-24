/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author JIATOU FRANCK
 */
@Entity
public class OrclassExercice implements DAOEntry {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "ID")
    private Integer code;

    @Column(name = "LBELLE_EXERCICE")
    private String libelle;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer Code) {
        this.code = Code;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (code != null ? code.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrclassExercice)) {
            return false;
        }
        OrclassExercice other = (OrclassExercice) object;
        if ((this.code == null && other.code != null) || (this.code != null && !this.code.equals(other.code))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modele.OrclassExercice[ id=" + code + " ]";
    }

}
