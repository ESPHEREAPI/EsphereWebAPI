/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import enums.ModeCalcul;
import enums.Sexe;
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
import javax.validation.constraints.NotNull;

/**
 *
 * @author frankjiatou
 */
@Entity
@Table(name = "ORCLASS_IMAGE_RISQ", uniqueConstraints = @UniqueConstraint(columnNames = {"ID_ENTREPRISE", "ID_GROUPE_RISQUE", "LIBELLE_RISQUE", "MATRICULE", "DATE_NAISSANCE","POLICE"}))
public class OrclassImageRisque implements DAOEntry {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    @NotNull
    @Column(name = "ID_IMAGE_RISQUE")
    private Long id;

    @JoinColumn(name = "ID_ENTREPRISE", referencedColumnName = "ID_ENTREPRISE")
    @ManyToOne(optional = false)
    private OrclassEntreprises idEntreprise;
    @Column(name = "POLICE")
    private BigInteger numero_polic;
    @JoinColumn(name = "ID_GROUPE_RISQUE", referencedColumnName = "ID_REF_GROUPE")
    @ManyToOne(optional = true)
    private OrclasseRefGroupe idGroup;
    @JoinColumn(name = "ID_UTILISATEUR", referencedColumnName = "ID_UTILISATEUR")
    @ManyToOne(optional = false)
    private OrclassUtilisateurs idUtilisateur;
    @JoinColumn(name = "ID_INTERMEDIAIRE", referencedColumnName = "ID_INTERMEDIAIRE")
    @ManyToOne(optional = false)
    private OrclassIntermediaires idIntermediaire;
      @JoinColumn(name = "ID_CATEGORIE", referencedColumnName = "ID_CATEGORIE")
    @ManyToOne(optional = false)
    private OrclassCategories idCategories;

    @Column(name = "CODE_RISQUE")
    private BigInteger numero_ordre;
    @Column(name = "LIBELLE_RISQUE")
    private String libelle;
    @Column(name = "MATRICULE")
    private String matricule;
    @Enumerated(EnumType.STRING)
    private Sexe sexe;
    @Enumerated(EnumType.STRING)
    @Column(name = "MODE_CALCUL")
    private ModeCalcul modeCalcul;
    @Column(name = "DATE_NAISSANCE")
    @Temporal(TemporalType.DATE)
    private Date dateNaissance;
    @Column(name = "DATE_ENTREE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateEntree;
    String souscripteur;

    public OrclassUtilisateurs getIdUtilisateur() {
        return idUtilisateur;
    }

    public void setIdUtilisateur(OrclassUtilisateurs idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }

    public OrclassIntermediaires getIdIntermediaire() {
        return idIntermediaire;
    }

    public void setIdIntermediaire(OrclassIntermediaires idIntermediaire) {
        this.idIntermediaire = idIntermediaire;
    }
    
    

    public OrclassImageRisque() {

    }

    public OrclassEntreprises getIdEntreprise() {
        return idEntreprise;
    }

    public void setIdEntreprise(OrclassEntreprises idEntreprise) {
        this.idEntreprise = idEntreprise;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public OrclasseRefGroupe getIdGroup() {
        return idGroup;
    }

    public void setIdGroup(OrclasseRefGroupe idGroup) {
        this.idGroup = idGroup;
    }

    public BigInteger getNumero_ordre() {
        return numero_ordre;
    }

    public void setNumero_ordre(BigInteger numero_ordre) {
        this.numero_ordre = numero_ordre;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public Sexe getSexe() {
        return sexe;
    }

    public void setSexe(Sexe sexe) {
        this.sexe = sexe;
    }

    public ModeCalcul getModeCalcul() {
        return modeCalcul;
    }

    public void setModeCalcul(ModeCalcul modeCalcul) {
        this.modeCalcul = modeCalcul;
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

    public String getSouscripteur() {
        return souscripteur;
    }

    public void setSouscripteur(String souscripteur) {
        this.souscripteur = souscripteur;
    }

    public OrclassCategories getIdCategories() {
        return idCategories;
    }

    public void setIdCategories(OrclassCategories idCategories) {
        this.idCategories = idCategories;
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
        if (!(object instanceof OrclassImageRisque)) {
            return false;
        }
        OrclassImageRisque other = (OrclassImageRisque) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modele.OrclassImageRisque[ id=" + id + " ]";
    }

}
