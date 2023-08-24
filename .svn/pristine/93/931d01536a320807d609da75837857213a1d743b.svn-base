/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import enums.ModeCalcul;
import enums.StatutPrestataire;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author JIATOU FRANCK
 */
@Entity
@Table(name = "orclass_RefPrestataire")
public class orclassRefPrestataire implements DAOEntry {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_REF_PREST")
    private Long id;
    @Column(name = "CODE", unique = true)
    private String code;
    @Column(name = "LIBELLE")
    private String libelle;
    @Enumerated(EnumType.STRING)
    @Column(name = "STATUT")
    private StatutPrestataire statutPrestataire;

    public orclassRefPrestataire(String code, String libelle) {
        this.code = code;
        this.libelle = libelle;
    }

    public orclassRefPrestataire() {

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

    public StatutPrestataire getStatutPrestataire() {
        return statutPrestataire;
    }

    public void setStatutPrestataire(StatutPrestataire statutPrestataire) {
        this.statutPrestataire = statutPrestataire;
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
        if (!(object instanceof orclassRefPrestataire)) {
            return false;
        }
        orclassRefPrestataire other = (orclassRefPrestataire) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modele.orclassRefPrestataire[ id=" + id + " ]";
    }

}
