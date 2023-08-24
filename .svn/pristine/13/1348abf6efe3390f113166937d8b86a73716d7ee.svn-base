/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import enums.Contrat;
import enums.NatureContrat;
import enums.Sexe;
import enums.TypePieces;
import enums.UniteDuree;
import java.math.BigDecimal;
import java.math.BigInteger;
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
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

/**
 *
 * @author E-SPHERE
 */
@Entity
@Table(name = "ORCLASS_AVENAT", uniqueConstraints = @UniqueConstraint(columnNames = {"ID_ENTREPRISE", "ID_POLICE", "ID_TYPE_AVENANT", "NUMERO_AVENANT"}))
public class OrclassAvenant implements DAOEntry {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    @Column(name = "ID_AVENANT")
    private Long id;

    @JoinColumn(name = "ID_ENTREPRISE", referencedColumnName = "ID_ENTREPRISE")
    @ManyToOne(optional = false)
    private OrclassEntreprises idEntreprises;

    @JoinColumn(name = "ID_POLICE", referencedColumnName = "ID_POLICE")
    @ManyToOne(optional = false)
    private OrclassPolice idPolice;
    @JoinColumn(name = "ID_TYPE_AVENANT", referencedColumnName = "ID_TYPE_AVENANT")
    @ManyToOne(optional = false)
    private Orclass_TypeAvenant idTypeAvenant;

    @JoinColumn(name = "ID_UTILISATEUR", referencedColumnName = "ID_UTILISATEUR")
    @ManyToOne(optional = false)
    private OrclassUtilisateurs idUtilisateur;
    @JoinColumn(name = "ID_EXONERATION", referencedColumnName = "ID_EXONERATION")
    @ManyToOne(optional = true)
    private OrclassExoneration idExoneration;
    @JoinColumn(name = "ID_TYPE_TARIF", referencedColumnName = "ID_TYPE_TARIF")
    @ManyToOne(optional = true)
    private OrclassTypeTarif idTypeTarif;
    @JoinColumn(name = "ID_REDUCTION", referencedColumnName = "ID_REDUCTION")
    @ManyToOne(optional = true)
    private OrclassReduction idReduction;
    @JoinColumn(name = "ID_CONVENTION", referencedColumnName = "ID_CONVENTION")
    @ManyToOne(optional = true)
    private OrclassConvention idConvention;
    @JoinColumn(name = "ID_APPORTEUR", referencedColumnName = "ID_APPORTEUR")
    @ManyToOne(optional = true)
    private OrclassApporteur idApporteur;
    @JoinColumn(name = "ID_DEVISE", referencedColumnName = "ID_DEVISE")
    @ManyToOne(optional = true)
    private OrclassDevise idDevise;
    @JoinColumn(name = "ID_TIMBRE", referencedColumnName = "ID_TIMBRE")
    @ManyToOne(optional = true)
    private OrclassTimbre idTimbre;
    @JoinColumn(name = "ID_TIMB_DIM", referencedColumnName = "ID_TIMB_DIM")
    @ManyToOne(optional = true)
    private OrclasseTimbreDimension idTimbreDimension;
    @JoinColumn(name = "ID_FRACTION_CATEGORIE", referencedColumnName = "ID_FRACTION_CATEGORIE")
    @ManyToOne(optional = true)
    private OrclassFractionnementCategories idFractionnementCategories;
//    @JoinColumn(name = "ID_ASSURES", referencedColumnName = "ID_ASSURE")
//    @ManyToOne(optional = false)
//
//    private OrclassAssure idAssure;
    @JoinColumn(name = "ID_MAJORA_DUREE", referencedColumnName = "ID_MAJORA_DUREE")
    @ManyToOne(optional = true)
    private OrclassMajorationDuree idMajorationDuree;

    @Column(name = "DATE_SAISIE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date_saisie;
    @Column(name = "DATE_EFFET")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date_effet;
    @Column(name = "DATE_VALIDATION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date_validation;
    @Column(name = "DATE_ECHEANCE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date_echeance;
    @Column(name = "DATE_CREATION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreation;
    @Column(name = "DATE_MODIFICATION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateModification;
    private String saisir_par;
    private String modifier_par;
    private String valider_par;
    private String annuler_par;

    @Enumerated(EnumType.STRING)
    private Contrat contrat;
    private String ref_intermediaire;
    @Enumerated(EnumType.STRING)
    private NatureContrat natureContrat;
    BigInteger nombre_timbre;
    BigDecimal valeur_timbre;
//    BigInteger valeur_duree;
    @Enumerated(EnumType.STRING)
    private UniteDuree uniteDuree;
    private String numero_Borderau;
    private BigDecimal taux_echange;
    private BigDecimal valeur_Devis;
    private String cptg;
    BigDecimal montantaccessoir;
    @Enumerated(EnumType.STRING)
    private Sexe sexe;
    String titre;
    String observation;
    private Boolean validation = Boolean.FALSE;
    private Boolean annulation = Boolean.FALSE;
    private Boolean imprimer = Boolean.FALSE;
    private BigInteger valeurDuree;
    private BigDecimal coursDevise;
    private BigDecimal coursDeviseApplique;
    private BigDecimal accessoir;
    @Column(name = "DATE_COURS_DEVIS")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date_cours_devise;

    private String designationPlafonMaladie;
    @Column(name = "NUMERO_AVENANT")
    BigInteger numero_avenant = BigInteger.ZERO;

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
    @ManyToOne(optional = true)
    private OrclassActivite idActivite;
    @JoinColumn(name = "ID_QUALITE_ASSU", referencedColumnName = "ID_QUALITE")
    @ManyToOne(optional = true)
    private OrclassQualite idQualite;
    @JoinColumn(name = "ID_VILLE", referencedColumnName = "ID_VILLE")
    @ManyToOne(optional = true)
    private OrclassVille idVille;
    @JoinColumn(name = "ID_MOTIF", referencedColumnName = "ID_MOTIF")
    @ManyToOne(optional = true)
    private OrclassMotif idMotif;

    @Enumerated(EnumType.STRING)
    private TypePieces typePieces;
    @Column(name = "DATE_NAISSANCE")
    @Temporal(TemporalType.DATE)
    private Date date_naissance;
    private String numero_piece;
    @Transient
    String police;

    public OrclassAvenant() {
        adresse = new Adresse();
    }

    public OrclassEntreprises getIdEntreprises() {
        return idEntreprises;
    }

    public void setIdEntreprises(OrclassEntreprises idEntreprises) {
        this.idEntreprises = idEntreprises;
    }

    public OrclassPolice getIdPolice() {
        return idPolice;
    }

    public void setIdPolice(OrclassPolice idPolice) {
        this.idPolice = idPolice;
    }

    public Orclass_TypeAvenant getIdTypeAvenant() {
        return idTypeAvenant;
    }

    public void setIdTypeAvenant(Orclass_TypeAvenant idTypeAvenant) {
        this.idTypeAvenant = idTypeAvenant;
    }

    public OrclassUtilisateurs getIdUtilisateur() {
        return idUtilisateur;
    }

    public void setIdUtilisateur(OrclassUtilisateurs idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }

    public OrclassExoneration getIdExoneration() {
        return idExoneration;
    }

    public void setIdExoneration(OrclassExoneration idExoneration) {
        this.idExoneration = idExoneration;
    }

    public OrclassTypeTarif getIdTypeTarif() {
        return idTypeTarif;
    }

    public void setIdTypeTarif(OrclassTypeTarif idTypeTarif) {
        this.idTypeTarif = idTypeTarif;
    }

    public OrclassReduction getIdReduction() {
        return idReduction;
    }

    public void setIdReduction(OrclassReduction idReduction) {
        this.idReduction = idReduction;
    }

    public OrclassConvention getIdConvention() {
        return idConvention;
    }

    public void setIdConvention(OrclassConvention idConvention) {
        this.idConvention = idConvention;
    }

    public OrclassApporteur getIdApporteur() {
        return idApporteur;
    }

    public void setIdApporteur(OrclassApporteur idApporteur) {
        this.idApporteur = idApporteur;
    }

    public OrclassDevise getIdDevise() {
        return idDevise;
    }

    public void setIdDevise(OrclassDevise idDevise) {
        this.idDevise = idDevise;
    }

    public OrclassTimbre getIdTimbre() {
        return idTimbre;
    }

    public void setIdTimbre(OrclassTimbre idTimbre) {
        this.idTimbre = idTimbre;
    }

    public OrclasseTimbreDimension getIdTimbreDimension() {
        return idTimbreDimension;
    }

    public void setIdTimbreDimension(OrclasseTimbreDimension idTimbreDimension) {
        this.idTimbreDimension = idTimbreDimension;
    }

    public OrclassFractionnementCategories getIdFractionnementCategories() {
        return idFractionnementCategories;
    }

    public void setIdFractionnementCategories(OrclassFractionnementCategories idFractionnementCategories) {
        this.idFractionnementCategories = idFractionnementCategories;
    }

    public OrclassMajorationDuree getIdMajorationDuree() {
        return idMajorationDuree;
    }

    public void setIdMajorationDuree(OrclassMajorationDuree idMajorationDuree) {
        this.idMajorationDuree = idMajorationDuree;
    }

    public Date getDate_saisie() {
        return date_saisie;
    }

    public void setDate_saisie(Date date_saisie) {
        this.date_saisie = date_saisie;
    }

    public Date getDate_effet() {
        return date_effet;
    }

    public void setDate_effet(Date date_effet) {
        this.date_effet = date_effet;
    }

    public Date getDate_validation() {
        return date_validation;
    }

    public void setDate_validation(Date date_validation) {
        this.date_validation = date_validation;
    }

    public Date getDate_echeance() {
        return date_echeance;
    }

    public void setDate_echeance(Date date_echeance) {
        this.date_echeance = date_echeance;
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

    public String getValider_par() {
        return valider_par;
    }

    public void setValider_par(String valider_par) {
        this.valider_par = valider_par;
    }

    public String getAnnuler_par() {
        return annuler_par;
    }

    public void setAnnuler_par(String annuler_par) {
        this.annuler_par = annuler_par;
    }

    public Contrat getContrat() {
        return contrat;
    }

    public void setContrat(Contrat contrat) {
        this.contrat = contrat;
    }

    public String getRef_intermediaire() {
        return ref_intermediaire;
    }

    public void setRef_intermediaire(String ref_intermediaire) {
        this.ref_intermediaire = ref_intermediaire;
    }

    public NatureContrat getNatureContrat() {
        return natureContrat;
    }

    public void setNatureContrat(NatureContrat natureContrat) {
        this.natureContrat = natureContrat;
    }

    public BigInteger getNombre_timbre() {
        return nombre_timbre;
    }

    public void setNombre_timbre(BigInteger nombre_timbre) {
        this.nombre_timbre = nombre_timbre;
    }

    public BigDecimal getValeur_timbre() {
        return valeur_timbre;
    }

    public void setValeur_timbre(BigDecimal valeur_timbre) {
        this.valeur_timbre = valeur_timbre;
    }

    public UniteDuree getUniteDuree() {
        return uniteDuree;
    }

    public void setUniteDuree(UniteDuree uniteDuree) {
        this.uniteDuree = uniteDuree;
    }

    public String getNumero_Borderau() {
        return numero_Borderau;
    }

    public void setNumero_Borderau(String numero_Borderau) {
        this.numero_Borderau = numero_Borderau;
    }

    public BigDecimal getTaux_echange() {
        return taux_echange;
    }

    public void setTaux_echange(BigDecimal taux_echange) {
        this.taux_echange = taux_echange;
    }

    public BigDecimal getValeur_Devis() {
        return valeur_Devis;
    }

    public void setValeur_Devis(BigDecimal valeur_Devis) {
        this.valeur_Devis = valeur_Devis;
    }

    public String getCptg() {
        return cptg;
    }

    public void setCptg(String cptg) {
        this.cptg = cptg;
    }

    public BigDecimal getMontantaccessoir() {
        return montantaccessoir;
    }

    public void setMontantaccessoir(BigDecimal montantaccessoir) {
        this.montantaccessoir = montantaccessoir;
    }

    public Sexe getSexe() {
        return sexe;
    }

    public void setSexe(Sexe sexe) {
        this.sexe = sexe;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }

    public Boolean getValidation() {
        return validation;
    }

    public void setValidation(Boolean validation) {
        this.validation = validation;
    }

    public Boolean getAnnulation() {
        return annulation;
    }

    public void setAnnulation(Boolean annulation) {
        this.annulation = annulation;
    }

    public Boolean getImprimer() {
        return imprimer;
    }

    public void setImprimer(Boolean imprimer) {
        this.imprimer = imprimer;
    }

    public BigInteger getValeurDuree() {
        return valeurDuree;
    }

    public void setValeurDuree(BigInteger valeurDuree) {
        this.valeurDuree = valeurDuree;
    }

    public BigDecimal getCoursDevise() {
        return coursDevise;
    }

    public void setCoursDevise(BigDecimal coursDevise) {
        this.coursDevise = coursDevise;
    }

    public BigDecimal getCoursDeviseApplique() {
        return coursDeviseApplique;
    }

    public void setCoursDeviseApplique(BigDecimal coursDeviseApplique) {
        this.coursDeviseApplique = coursDeviseApplique;
    }

    public BigDecimal getAccessoir() {
        return accessoir;
    }

    public void setAccessoir(BigDecimal accessoir) {
        this.accessoir = accessoir;
    }

    public Date getDate_cours_devise() {
        return date_cours_devise;
    }

    public void setDate_cours_devise(Date date_cours_devise) {
        this.date_cours_devise = date_cours_devise;
    }

    public String getDesignationPlafonMaladie() {
        return designationPlafonMaladie;
    }

    public void setDesignationPlafonMaladie(String designationPlafonMaladie) {
        this.designationPlafonMaladie = designationPlafonMaladie;
    }

    public BigInteger getNumero_avenant() {
        return numero_avenant;
    }

    public void setNumero_avenant(BigInteger numero_avenant) {
        this.numero_avenant = numero_avenant;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getLieu_naissance() {
        return lieu_naissance;
    }

    public void setLieu_naissance(String lieu_naissance) {
        this.lieu_naissance = lieu_naissance;
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

    public TypePieces getTypePieces() {
        return typePieces;
    }

    public void setTypePieces(TypePieces typePieces) {
        this.typePieces = typePieces;
    }

    public Date getDate_naissance() {
        return date_naissance;
    }

    public void setDate_naissance(Date date_naissance) {
        this.date_naissance = date_naissance;
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
        if (!(object instanceof OrclassAvenant)) {
            return false;
        }
        OrclassAvenant other = (OrclassAvenant) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modele.OrclassAvenant[ id=" + id + " ]";
    }

    public OrclassMotif getIdMotif() {
        return idMotif;
    }

    public void setIdMotif(OrclassMotif idMotif) {
        this.idMotif = idMotif;
    }

    public String getPolice() {
        return police;
    }

    public void setPolice(String police) {
        this.police = police;
    }

}
