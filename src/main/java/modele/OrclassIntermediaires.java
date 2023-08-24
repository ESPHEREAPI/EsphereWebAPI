/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author hp
 */
@Entity
@Table(name = "ORCLASS_INTERMEDIAIRES", uniqueConstraints = @UniqueConstraint(columnNames = {"ID_ENTREPRISE", "ID_REF_INTERM","ID_VILLE"}))

public class OrclassIntermediaires implements DAOEntry {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_INTERMEDIAIRE")
    private Short idIntermediaire;
//    @Size(max = 32)
//    @Column(name = "CODE")
//    private String code;
//    @Size(max = 255)
//    @Column(name = "RAISON_SOCIALE")
//    private String raisonSociale;
    @JoinColumn(name = "ID_REF_INTERM", referencedColumnName = "ID_REF_INTERM")
    @ManyToOne(optional = false)
    private OrclassRefIntermediaire idRefIntermediaire;
    @Size(max = 32)
    @Column(name = "IMMATRICULATION")
    private String immatriculation;
    @Size(max = 32)
    @Column(name = "NO_CONTRIBUABLE")
    private String noContribuable;
    @Column(name = "NO_PATENTE")
    private String noPatente;
    @Column(name = "NO_IMPO")
    private String noImpot;

    @Column(name = "NO_TVA")
    private String noTva;
    @Column(name = "NO_CNSS")
    private String noCnss;
    @Column(name = "CAPITAL_SOCIAL")
    private String capitalSocial;
    @Column(name = "NO_RC")
    private String numeroRegiCommerce;
    @Column(name = "NO_AGREMENT")
    private String numeroAgrement;
    @Column(name = "NUMERO_FAX")
    private String numeroFax;
    @Column(name = "TELEX")
    private String numeroTelex;
    @Column(name = "COMPTE_COMMISSION")
    private String compteCommission;
    @Column(name = "COMPTE_PRIME")
    private String comptePrime;
    private String nom_contact;
    @Embedded
    private Adresse adresse;
    @Column(name = "DATE_CREATION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreation;
    @Column(name = "DATE_NOMINATION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateNomination;
    @Column(name = "DATE_MODIFICATION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateModification;
    @OneToMany(mappedBy = "idIntermediaire")
    private List<OrclassRolesDonnees> orclassRolesDonneesList;
    @JoinColumn(name = "ID_ENTREPRISE", referencedColumnName = "ID_ENTREPRISE")
    @ManyToOne(optional = false)
    private OrclassEntreprises idEntreprise;
    @JoinColumn(name = "ID_GROUPE_INT", referencedColumnName = "ID_GR")
    @ManyToOne(optional = true)
    private OrclassGroupes idGroupe;
    @JoinColumn(name = "ID_VILLE", referencedColumnName = "ID_VILLE")
    @ManyToOne(optional = false)
    private OrclassVille idVille;
    @JoinColumn(name = "ID_TYPE_BUREAU", referencedColumnName = "ID_TYPE_BUREAU")
    @ManyToOne(optional = false)
    private OrclassTypeBureau idTypeBureau;
    @OneToMany(mappedBy = "idIntermediaire")
    private List<OrclassUtilisateursDonnees> orclassUtilisateursDonneesList;
    @OneToMany(mappedBy = "idIntermediaire")
    private List<OrclassUtilisateurs> orclassUtilisateursList;
    private Boolean apposition_timbre = Boolean.FALSE;
    private String ancienCode;

    public OrclassIntermediaires() {
        adresse = new Adresse();
        idVille = new OrclassVille();
        idTypeBureau = new OrclassTypeBureau();
       idRefIntermediaire=new OrclassRefIntermediaire();
    }

    public Date getDateNomination() {
        return dateNomination;
    }

    public void setDateNomination(Date dateNomination) {
        this.dateNomination = dateNomination;
    }

    public String getAncienCode() {
        return ancienCode;
    }

    public void setAncienCode(String ancienCode) {
        this.ancienCode = ancienCode;
    }

    public Boolean getApposition_timbre() {
        return apposition_timbre;
    }

    public void setApposition_timbre(Boolean apposition_timbre) {
        this.apposition_timbre = apposition_timbre;
    }

    public String getNumeroAgrement() {
        return numeroAgrement;
    }

    public void setNumeroAgrement(String numeroAgrement) {
        this.numeroAgrement = numeroAgrement;
    }

    public OrclassIntermediaires(Short idIntermediaire) {
        this.idIntermediaire = idIntermediaire;
    }

    public Short getIdIntermediaire() {
        return idIntermediaire;
    }

    public void setIdIntermediaire(Short idIntermediaire) {
        this.idIntermediaire = idIntermediaire;
    }

    public OrclassRefIntermediaire getIdRefIntermediaire() {
        return idRefIntermediaire;
    }

    public void setIdRefIntermediaire(OrclassRefIntermediaire idRefIntermediaire) {
        this.idRefIntermediaire = idRefIntermediaire;
    }


 

    public String getImmatriculation() {
        return immatriculation;
    }

    public void setImmatriculation(String immatriculation) {
        this.immatriculation = immatriculation;
    }

    public String getNoContribuable() {
        return noContribuable;
    }

    public void setNoContribuable(String noContribuable) {
        this.noContribuable = noContribuable;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public Date getDateModification() {
        return dateModification;
    }

    public void setDateModification(Date dateModification) {
        this.dateModification = dateModification;
    }

    public String getNoPatente() {
        return noPatente;
    }

    public void setNoPatente(String noPatente) {
        this.noPatente = noPatente;
    }

    public String getNoImpot() {
        return noImpot;
    }

    public void setNoImpot(String noImpot) {
        this.noImpot = noImpot;
    }

    public String getNoTva() {
        return noTva;
    }

    public void setNoTva(String noTva) {
        this.noTva = noTva;
    }

    public String getNoCnss() {
        return noCnss;
    }

    public void setNoCnss(String noCnss) {
        this.noCnss = noCnss;
    }

    public String getCapitalSocial() {
        return capitalSocial;
    }

    public void setCapitalSocial(String capitalSocial) {
        this.capitalSocial = capitalSocial;
    }

    public String getNumeroRegiCommerce() {
        return numeroRegiCommerce;
    }

    public void setNumeroRegiCommerce(String numeroRegiCommerce) {
        this.numeroRegiCommerce = numeroRegiCommerce;
    }

    public String getNumeroFax() {
        return numeroFax;
    }

    public void setNumeroFax(String numeroFax) {
        this.numeroFax = numeroFax;
    }

    public String getNumeroTelex() {
        return numeroTelex;
    }

    public void setNumeroTelex(String numeroTelex) {
        this.numeroTelex = numeroTelex;
    }

    public String getCompteCommission() {
        return compteCommission;
    }

    public void setCompteCommission(String compteCommission) {
        this.compteCommission = compteCommission;
    }

    public String getComptePrime() {
        return comptePrime;
    }

    public void setComptePrime(String comptePrime) {
        this.comptePrime = comptePrime;
    }

    public OrclassVille getIdVille() {
        return idVille;
    }

    public void setIdVille(OrclassVille idVille) {
        this.idVille = idVille;
    }

    public OrclassTypeBureau getIdTypeBureau() {
        return idTypeBureau;
    }

    public void setIdTypeBureau(OrclassTypeBureau idTypeBureau) {
        this.idTypeBureau = idTypeBureau;
    }

    @XmlTransient
    public List<OrclassRolesDonnees> getOrclassRolesDonneesList() {
        return orclassRolesDonneesList;
    }

    public void setOrclassRolesDonneesList(List<OrclassRolesDonnees> orclassRolesDonneesList) {
        this.orclassRolesDonneesList = orclassRolesDonneesList;
    }

    public OrclassEntreprises getIdEntreprise() {
        return idEntreprise;
    }

    public void setIdEntreprise(OrclassEntreprises idEntreprise) {
        this.idEntreprise = idEntreprise;
    }

    public OrclassGroupes getIdGroupe() {
        return idGroupe;
    }

    public void setIdGroupe(OrclassGroupes idGroupe) {
        this.idGroupe = idGroupe;
    }

    public String getNom_contact() {
        return nom_contact;
    }

    public void setNom_contact(String nom_contact) {
        this.nom_contact = nom_contact;
    }

    @XmlTransient
    public List<OrclassUtilisateursDonnees> getOrclassUtilisateursDonneesList() {
        return orclassUtilisateursDonneesList;
    }

    public void setOrclassUtilisateursDonneesList(List<OrclassUtilisateursDonnees> orclassUtilisateursDonneesList) {
        this.orclassUtilisateursDonneesList = orclassUtilisateursDonneesList;
    }

    @XmlTransient
    public List<OrclassUtilisateurs> getOrclassUtilisateursList() {
        return orclassUtilisateursList;
    }

    public void setOrclassUtilisateursList(List<OrclassUtilisateurs> orclassUtilisateursList) {
        this.orclassUtilisateursList = orclassUtilisateursList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idIntermediaire != null ? idIntermediaire.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrclassIntermediaires)) {
            return false;
        }
        OrclassIntermediaires other = (OrclassIntermediaires) object;
        if ((this.idIntermediaire == null && other.idIntermediaire != null) || (this.idIntermediaire != null && !this.idIntermediaire.equals(other.idIntermediaire))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modele.OrclassIntermediaires[ idIntermediaire=" + idIntermediaire + " ]";
    }

}
