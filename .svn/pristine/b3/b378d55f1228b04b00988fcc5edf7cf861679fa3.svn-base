/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import enums.LienParente;
import enums.Sexe;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author frankjiatou
 */
@Entity
@Table(name = "ORCLASS_IMAGE_RISQUE_FAM", uniqueConstraints = @UniqueConstraint(columnNames = {"ID_IMAGE_RISQUE", "MEMBRE", "DATE_NAISSANCE"}))
public class OrclassImageFamilleRisque implements DAOEntry {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private BigInteger numero_polic;

    @JoinColumn(name = "ID_IMAGE_RISQUE", referencedColumnName = "ID_IMAGE_RISQUE")
    @ManyToOne(optional = false)
    private OrclassImageRisque idRisque;
    @Enumerated(EnumType.STRING)
    private Sexe sexe;
    @Enumerated(EnumType.STRING)
    private LienParente lienParente;
    @Column(name = "CODE_MEMBRE")
    @GeneratedValue(strategy = GenerationType.AUTO)
//    @NotNull
    BigInteger numero_ordre;
    @Column(name = "MEMBRE")
    private String nom_membre;
    @Column(name = "DATE_NAISSANCE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateNaissance;
    @Column(name = "DATE_ENTREE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateEntree;
    @Column(name = "MATRICULE")
    private String matricule;

    public OrclassImageRisque getIdRisque() {
        return idRisque;
    }

    public void setIdRisque(OrclassImageRisque idRisque) {
        this.idRisque = idRisque;
    }

    public Sexe getSexe() {
        return sexe;
    }

    public void setSexe(Sexe sexe) {
        this.sexe = sexe;
    }

    public LienParente getLienParente() {
        return lienParente;
    }

    public void setLienParente(LienParente lienParente) {
        this.lienParente = lienParente;
    }

    public BigInteger getNumero_ordre() {
        return numero_ordre;
    }

    public void setNumero_ordre(BigInteger numero_ordre) {
        this.numero_ordre = numero_ordre;
    }

    public String getNom_membre() {
        return nom_membre;
    }

    public void setNom_membre(String nom_membre) {
        this.nom_membre = nom_membre;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public Date getDateEntree() {
        return dateEntree;
    }

    public void setDateEntree(Date dateEntree) {
        this.dateEntree = dateEntree;
    }

    public BigInteger getNumero_polic() {
        return numero_polic;
    }

    public void setNumero_polic(BigInteger numero_polic) {
        this.numero_polic = numero_polic;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
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
        if (!(object instanceof OrclassImageFamilleRisque)) {
            return false;
        }
        OrclassImageFamilleRisque other = (OrclassImageFamilleRisque) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modele.OrclassImageFamilleRisque[ id=" + id + " ]";
    }

}
