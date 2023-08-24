/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;


import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "ORCLASS_EXONERATION", uniqueConstraints = @UniqueConstraint(columnNames = {"CODE"}))
public class OrclassExoneration implements DAOEntry {

    private static final long serialVersionUID = 1L;
   
    @Id
    @NotNull
    @Column(name = "ID_EXONERATION")
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idExoneration;
    
    @Size(max =32 )
    @Column(name = "CODE")
    private String code;
    
    @Size(max = 255)
    @Column(name = "LIBELLE")
    private String libelle;

    public OrclassExoneration() {
    }

    public OrclassExoneration(String code, String libelle) {
        this.code = code;
        this.libelle = libelle;
    }

    public OrclassExoneration(Long idExoneration) {
        this.idExoneration = idExoneration;
    }
    
    

    public Long getIdExoneration() {
        return idExoneration;
    }

    public void setIdExoneration(Long idExoneration) {
        this.idExoneration = idExoneration;
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


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idExoneration != null ? idExoneration.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrclassExoneration)) {
            return false;
        }
        OrclassExoneration other = (OrclassExoneration) object;
        if ((this.idExoneration == null && other.idExoneration != null) || (this.idExoneration != null && !this.idExoneration.equals(other.idExoneration))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modele.OrclassExoneration[ idExoneration=" + idExoneration + " ]";
    }
    
}
