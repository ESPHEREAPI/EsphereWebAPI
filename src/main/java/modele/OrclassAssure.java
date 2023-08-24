/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import enums.Sexe;
import enums.TypePieces;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embedded;
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
import javax.validation.constraints.NotNull;

/**
 *
 * @author hp
 */
@Entity
@Table(name = "ORCLASS_ASSURE")
public class OrclassAssure implements DAOEntry {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    @Column(name = "ID_ASSURE")
    private Long id;
    @Column(name = "CODE")
    private String code;
    private String raison_social;
    @Embedded
    private Adresse adresse;
    private String num_cni;
    private String patente;
    private String registre_commercial;
    private String nom, prenom;
    private String gsm;
    private String lieu_naissance;
    @JoinColumn(name = "ID_PROFESSION", referencedColumnName = "ID_PROFESSION")
    @ManyToOne(optional = true)
    private OrclassProfession idProfession;
    @JoinColumn(name = "ID_ACTIVITE", referencedColumnName = "ID_ACTIVITE")
    @ManyToOne(optional = false)
    private OrclassActivite idActivite;
    @JoinColumn(name = "ID_QUALITE_ASSU", referencedColumnName = "ID_QUALITE")
    @ManyToOne(optional = true)
    private OrclassQualite idQualite;
    @JoinColumn(name = "ID_VILLE", referencedColumnName = "ID_VILLE")
    @ManyToOne(optional = false)
    private OrclassVille idVille;

    @JoinColumn(name = "ID_INTERMEDIAIRE", referencedColumnName = "ID_INTERMEDIAIRE")
    @ManyToOne(optional = false)
    private OrclassIntermediaires idIntermediaire;
    @JoinColumn(name = "ID_ENTREPRISE", referencedColumnName = "ID_ENTREPRISE")
    @ManyToOne(optional = false)
    private OrclassEntreprises idEntreprise;
    @Enumerated(EnumType.STRING)
    private Sexe sexe;
    @Enumerated(EnumType.STRING)
    private TypePieces typePieces;
    @Column(name = "DATE_NAISSANCE")
    @Temporal(TemporalType.DATE)
    private Date date_naissance;

    @Column(name = "DATE_SAISIE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date_saisie;
    @Column(name = "DATE_CREATION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreation;
    @Column(name = "DATE_MODIFICATION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateModification;
    private String saisir_par;
    private String modifier_par;
    private String numero_piece;

    public OrclassAssure() {
        adresse = new Adresse();
    }

    public OrclassAssure(Adresse adresse) {
        this.adresse = adresse;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getRaison_social() {
        return raison_social;
    }

    public void setRaison_social(String raison_social) {
        this.raison_social = raison_social;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    public String getNum_cni() {
        return num_cni;
    }

    public void setNum_cni(String num_cni) {
        this.num_cni = num_cni;
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public String getRegistre_commercial() {
        return registre_commercial;
    }

    public void setRegistre_commercial(String registre_commercial) {
        this.registre_commercial = registre_commercial;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getGsm() {
        return gsm;
    }

    public void setGsm(String gsm) {
        this.gsm = gsm;
    }

    public OrclassProfession getIdProfession() {
        return idProfession;
    }

    public void setIdProfession(OrclassProfession idProfession) {
        this.idProfession = idProfession;
    }

    public OrclassActivite getIdActivite() {
        return idActivite;
    }

    public void setIdActivite(OrclassActivite idActivite) {
        this.idActivite = idActivite;
    }

    public OrclassQualite getIdQualite() {
        return idQualite;
    }

    public void setIdQualite(OrclassQualite idQualite) {
        this.idQualite = idQualite;
    }

    public OrclassVille getIdVille() {
        return idVille;
    }

    public void setIdVille(OrclassVille idVille) {
        this.idVille = idVille;
    }

    public OrclassIntermediaires getIdIntermediaire() {
        return idIntermediaire;
    }

    public void setIdIntermediaire(OrclassIntermediaires idIntermediaire) {
        this.idIntermediaire = idIntermediaire;
    }

    public Sexe getSexe() {
        return sexe;
    }

    public void setSexe(Sexe sexe) {
        this.sexe = sexe;
    }

    public Date getDate_naissance() {
        return date_naissance;
    }

    public void setDate_naissance(Date date_naissance) {
        this.date_naissance = date_naissance;
    }

    public Date getDate_saisie() {
        return date_saisie;
    }

    public void setDate_saisie(Date date_saisie) {
        this.date_saisie = date_saisie;
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

    public String getSaisir_par() {
        return saisir_par;
    }

    public void setSaisir_par(String saisir_par) {
        this.saisir_par = saisir_par;
    }

    public String getModifier_par() {
        return modifier_par;
    }

    public void setModifier_par(String modifier_par) {
        this.modifier_par = modifier_par;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public OrclassEntreprises getIdEntreprise() {
        return idEntreprise;
    }

    public void setIdEntreprise(OrclassEntreprises idEntreprise) {
        this.idEntreprise = idEntreprise;
    }

    public String getLieu_naissance() {
        return lieu_naissance;
    }

    public void setLieu_naissance(String lieu_naissance) {
        this.lieu_naissance = lieu_naissance;
    }

    public TypePieces getTypePieces() {
        return typePieces;
    }

    public void setTypePieces(TypePieces typePieces) {
        this.typePieces = typePieces;
    }

    public String getNumero_piece() {
        return numero_piece;
    }

    public void setNumero_piece(String numero_piece) {
        this.numero_piece = numero_piece;
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
        if (!(object instanceof OrclassAssure)) {
            return false;
        }
        OrclassAssure other = (OrclassAssure) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modele.OrclassAssure[ id=" + id + " ]";
    }

}
