/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author JIATOU FRANCK
 */
@Entity
public class CodeActivation implements DAOEntry {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String codeActivation;
    private int nombreUtilisateur;
    @JoinColumn(name = "ID_REFLICENCE", referencedColumnName = "ID_REFLICENCE")
    @ManyToOne(optional = false)
    private RefLicence idRefLicence;
       @JoinColumn(name = "ID_EXERCICE", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private OrclassExercice OrclassExercice;
    private String desceription;

    public CodeActivation() {
    }

    public CodeActivation(String codeActivation, int nombreUtilisateur, RefLicence idRefLicence) {
        this.codeActivation = codeActivation;
        this.nombreUtilisateur = nombreUtilisateur;
        this.idRefLicence = idRefLicence;
    }

    public OrclassExercice getOrclassExercice() {
        return OrclassExercice;
    }

    public void setOrclassExercice(OrclassExercice OrclassExercice) {
        this.OrclassExercice = OrclassExercice;
    }
    
    

    public String getCodeActivation() {
        return codeActivation;
    }

    public void setCodeActivation(String codeActivation) {
        this.codeActivation = codeActivation;
    }

    public int getNombreUtilisateur() {
        return nombreUtilisateur;
    }

    public void setNombreUtilisateur(int nombreUtilisateur) {
        this.nombreUtilisateur = nombreUtilisateur;
    }

    public RefLicence getIdRefLicence() {
        return idRefLicence;
    }

    public void setIdRefLicence(RefLicence idRefLicence) {
        this.idRefLicence = idRefLicence;
    }

    public String getDesceription() {
        return desceription;
    }

    public void setDesceription(String desceription) {
        this.desceription = desceription;
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
        if (!(object instanceof CodeActivation)) {
            return false;
        }
        CodeActivation other = (CodeActivation) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modele.CodeActivation[ id=" + id + " ]";
    }

}
