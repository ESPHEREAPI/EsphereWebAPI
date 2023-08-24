/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import enums.Energie;
import enums.ModeCalcul;
import enums.Sexe;
import enums.TypeVehicule;
import enums.Zone;
import java.math.BigDecimal;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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
import javax.validation.constraints.NotNull;

/**
 *
 * @author hp
 */
@Entity
@Table(name = "ORCLASS_RISQUE")
public class OrclassRisque implements DAOEntry {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    @Column(name = "ID_RISQUE")
    private Long id;

    @JoinColumn(name = "ID_POLICE", referencedColumnName = "ID_POLICE")
    @ManyToOne(optional = false)
    private OrclassPolice idPolice;
    @JoinColumn(name = "ID_AVENANT", referencedColumnName = "ID_AVENANT")
    @ManyToOne(optional = true)
    private OrclassAvenant idAvenant;
    @JoinColumn(name = "ID_ENTREPRISE", referencedColumnName = "ID_ENTREPRISE")
    @ManyToOne(optional = false)
    private OrclassEntreprises idEntreprise;
    @JoinColumn(name = "ID_VILLE", referencedColumnName = "ID_VILLE")
    @ManyToOne(optional = true)
    private OrclassVille idVille;
    @JoinColumn(name = "ID_GROUPE_RISQUE", referencedColumnName = "ID_REF_GROUPE")
    @ManyToOne(optional = true)
    private OrclasseRefGroupe idGroup;
    @GeneratedValue(strategy = GenerationType.AUTO)
//    @NotNull
    @Column(name = "CODE_RISQUE")
    private BigInteger numero_ordre;
    @Column(name = "LIBELLE_RISQUE")

    private String libelle;
    @Column(name = "MATRICULE")
    String matricule;
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
    @Column(name = "DATE_CREATION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreation;
    @Column(name = "DATE_MODIFICATION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateModification;
    @Column(name = "DATE_SORTIE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateSortie;
    private String saisir_par;
    private String modifier_par;
    @Embedded
    private Adresse adresse;
    private String libelleProfession;
    private String libelleActivite;
    private String lieu_naissance;
    private Boolean modifier, ajouter, retire_de_la_police = Boolean.FALSE;
    private Long codeid_retirer;
    private String marque_vehicule;
    private String refer_Marq_vehic;
    @Enumerated(EnumType.STRING)
    @Column(name = "TYPE_VEHICULE")
    private TypeVehicule typeVehicule;
    @Enumerated(EnumType.STRING)
    @Column(name = "ENERGIE")
    private Energie energie;
    @Enumerated(EnumType.STRING)
    @Column(name = "ZONE_VEHICULE")
    private Zone zone;
    @Column(name = "NUM_IMMATRICULE")
    private String num_immatricul;
    @Column(name = "DATE_MEC")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateMec;
    @JoinColumn(name = "ID_CARRO", referencedColumnName = "ID_CARRO")
    @ManyToOne(optional = true)
    private OrclassCarrosserie idCarrosserie;
    @JoinColumn(name = "ID_ZONE_TRA", referencedColumnName = "ID_ZONE_TRA")
    @ManyToOne(optional = true)
    private OrclassZoneTransport idZoneTransport;
     @JoinColumn(name = "ID_SS_US_TPV", referencedColumnName = "ID_SS_US_TPV")
    @ManyToOne(optional = true)
    private OrclassSousUsageTPV idSousUsageTPV;
    @JoinColumn(name = "ID_FORMULE", referencedColumnName = "ID_FORMULE")
    @ManyToOne(optional = true)
    private OrclassFormule idFormule;
    @Column(name = "NUM_MOTEUR")
    private String numero_moteur;
    @Column(name = "NUM_CHASS")
    private String numero_chassis;
    private BigInteger puissance_vehicule;
    private BigDecimal poids_vehicule;
    private BigInteger cylindre_vehicule;
    private BigDecimal vitesse_vehicule;
    private BigInteger nombre_place;
    private String observation;
    private BigInteger valeur_catalogue;
    private BigInteger valeur_declaree;
    private String genre_vehicule;
    private String usage_vehicule;
     private Boolean turbo,avec_remoque,matiere_inflamable=Boolean.FALSE;

    @Transient
    Orclass_TypeAvenant typeAvenant;
    @Transient
    private List<OrclassRisqueFamille> listeRisqueFamille;
     @Transient
     int index;

    public OrclassRisque() {
        listeRisqueFamille = new ArrayList<>();
        adresse = new Adresse();
        idVille = new OrclassVille();
    }

    public String getMarque_vehicule() {
        return marque_vehicule;
    }

    public void setMarque_vehicule(String marque_vehicule) {
        this.marque_vehicule = marque_vehicule;
    }

    public String getRefer_Marq_vehic() {
        return refer_Marq_vehic;
    }

    public void setRefer_Marq_vehic(String refer_Marq_vehic) {
        this.refer_Marq_vehic = refer_Marq_vehic;
    }

    public TypeVehicule getTypeVehicule() {
        return typeVehicule;
    }

    public void setTypeVehicule(TypeVehicule typeVehicule) {
        this.typeVehicule = typeVehicule;
    }

    public Energie getEnergie() {
        return energie;
    }

    public void setEnergie(Energie energie) {
        this.energie = energie;
    }

    public Zone getZone() {
        return zone;
    }

    public void setZone(Zone zone) {
        this.zone = zone;
    }

    public String getNum_immatricul() {
        return num_immatricul;
    }

    public void setNum_immatricul(String num_immatricul) {
        this.num_immatricul = num_immatricul;
    }

    public Date getDateMec() {
        return dateMec;
    }

    public void setDateMec(Date dateMec) {
        this.dateMec = dateMec;
    }

    public OrclassCarrosserie getIdCarrosserie() {
        return idCarrosserie;
    }

    public void setIdCarrosserie(OrclassCarrosserie idCarrosserie) {
        this.idCarrosserie = idCarrosserie;
    }

    public OrclassZoneTransport getIdZoneTransport() {
        return idZoneTransport;
    }

    public void setIdZoneTransport(OrclassZoneTransport idZoneTransport) {
        this.idZoneTransport = idZoneTransport;
    }

    public OrclassSousUsageTPV getIdSousUsageTPV() {
        return idSousUsageTPV;
    }

    public void setIdSousUsageTPV(OrclassSousUsageTPV idSousUsageTPV) {
        this.idSousUsageTPV = idSousUsageTPV;
    }

    public OrclassFormule getIdFormule() {
        return idFormule;
    }

    public void setIdFormule(OrclassFormule idFormule) {
        this.idFormule = idFormule;
    }

    public String getNumero_moteur() {
        return numero_moteur;
    }

    public void setNumero_moteur(String numero_moteur) {
        this.numero_moteur = numero_moteur;
    }

    public String getNumero_chassis() {
        return numero_chassis;
    }

    public void setNumero_chassis(String numero_chassis) {
        this.numero_chassis = numero_chassis;
    }

    public BigInteger getPuissance_vehicule() {
        return puissance_vehicule;
    }

    public void setPuissance_vehicule(BigInteger puissance_vehicule) {
        this.puissance_vehicule = puissance_vehicule;
    }

    public BigDecimal getPoids_vehicule() {
        return poids_vehicule;
    }

    public void setPoids_vehicule(BigDecimal poids_vehicule) {
        this.poids_vehicule = poids_vehicule;
    }

    public BigInteger getCylindre_vehicule() {
        return cylindre_vehicule;
    }

    public void setCylindre_vehicule(BigInteger cylindre_vehicule) {
        this.cylindre_vehicule = cylindre_vehicule;
    }

    public BigDecimal getVitesse_vehicule() {
        return vitesse_vehicule;
    }

    public void setVitesse_vehicule(BigDecimal vitesse_vehicule) {
        this.vitesse_vehicule = vitesse_vehicule;
    }

    public BigInteger getNombre_place() {
        return nombre_place;
    }

    public void setNombre_place(BigInteger nombre_place) {
        this.nombre_place = nombre_place;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }

    public BigInteger getValeur_catalogue() {
        return valeur_catalogue;
    }

    public void setValeur_catalogue(BigInteger valeur_catalogue) {
        this.valeur_catalogue = valeur_catalogue;
    }

    public BigInteger getValeur_declaree() {
        return valeur_declaree;
    }

    public void setValeur_declaree(BigInteger valeur_declaree) {
        this.valeur_declaree = valeur_declaree;
    }

    public Boolean getTurbo() {
        return turbo;
    }

    public void setTurbo(Boolean turbo) {
        this.turbo = turbo;
    }

    public Boolean getAvec_remoque() {
        return avec_remoque;
    }

    public void setAvec_remoque(Boolean avec_remoque) {
        this.avec_remoque = avec_remoque;
    }

    public Boolean getMatiere_inflamable() {
        return matiere_inflamable;
    }

    public void setMatiere_inflamable(Boolean matiere_inflamable) {
        this.matiere_inflamable = matiere_inflamable;
    }

   

    public String getGenre_vehicule() {
        return genre_vehicule;
    }

    public void setGenre_vehicule(String genre_vehicule) {
        this.genre_vehicule = genre_vehicule;
    }

    public String getUsage_vehicule() {
        return usage_vehicule;
    }

    public void setUsage_vehicule(String usage_vehicule) {
        this.usage_vehicule = usage_vehicule;
    }

    
    
    public OrclassAvenant getIdAvenant() {
        return idAvenant;
    }

    public void setIdAvenant(OrclassAvenant idAvenant) {
        this.idAvenant = idAvenant;
    }

    public String getLieu_naissance() {
        return lieu_naissance;
    }

    public void setLieu_naissance(String lieu_naissance) {
        this.lieu_naissance = lieu_naissance;
    }

    public OrclassPolice getIdPolice() {
        return idPolice;
    }

    public void setIdPolice(OrclassPolice idPolice) {
        this.idPolice = idPolice;
    }

    public OrclassEntreprises getIdEntreprise() {
        return idEntreprise;
    }

    public void setIdEntreprise(OrclassEntreprises idEntreprise) {
        this.idEntreprise = idEntreprise;
    }

    public OrclassVille getIdVille() {
        return idVille;
    }

    public void setIdVille(OrclassVille idVille) {
        this.idVille = idVille;
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

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    public String getLibelleProfession() {
        return libelleProfession;
    }

    public void setLibelleProfession(String libelleProfession) {
        this.libelleProfession = libelleProfession;
    }

    public String getLibelleActivite() {
        return libelleActivite;
    }

    public void setLibelleActivite(String libelleActivite) {
        this.libelleActivite = libelleActivite;
    }

    public Date getDateSortie() {
        return dateSortie;
    }

    public void setDateSortie(Date dateSortie) {
        this.dateSortie = dateSortie;
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

    public Orclass_TypeAvenant getTypeAvenant() {
        return typeAvenant;
    }

    public void setTypeAvenant(Orclass_TypeAvenant typeAvenant) {
        this.typeAvenant = typeAvenant;
    }

    public List<OrclassRisqueFamille> getListeRisqueFamille() {
        return listeRisqueFamille;
    }

    public void setListeRisqueFamille(List<OrclassRisqueFamille> listeRisqueFamille) {
        this.listeRisqueFamille = listeRisqueFamille;
    }

    public Boolean getModifier() {
        return modifier;
    }

    public void setModifier(Boolean modifier) {
        this.modifier = modifier;
    }

    public Boolean getAjouter() {
        return ajouter;
    }

    public void setAjouter(Boolean ajouter) {
        this.ajouter = ajouter;
    }

    public Boolean getRetire_de_la_police() {
        return retire_de_la_police;
    }

    public void setRetire_de_la_police(Boolean retire_de_la_police) {
        this.retire_de_la_police = retire_de_la_police;
    }

    public Long getCodeid_retirer() {
        return codeid_retirer;
    }

    public void setCodeid_retirer(Long codeid_retirer) {
        this.codeid_retirer = codeid_retirer;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
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
        if (!(object instanceof OrclassRisque)) {
            return false;
        }
        OrclassRisque other = (OrclassRisque) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modele.OrclassRisque[ id=" + id + " ]";
    }

}
