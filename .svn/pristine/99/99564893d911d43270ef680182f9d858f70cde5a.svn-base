/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import enums.LienParente;
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
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

/**
 *
 * @author hp
 */
@Entity
@Table(name = "ORCLASS_RISQUE_FAM")
public class OrclassRisqueFamille implements DAOEntry {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    @Column(name = "ID_RISQUE_FAM")
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
    @JoinColumn(name = "ID_RISQUE_RFAM", referencedColumnName = "ID_RISQUE")
    @ManyToOne(optional = false)
    private OrclassRisque idRisque;
    @Enumerated(EnumType.STRING)
    private Sexe sexe;
    @Enumerated(EnumType.STRING)
    private LienParente lienParente;
    @Column(name = "CODE_MEMBRE")
    @GeneratedValue(strategy = GenerationType.AUTO)
//    @NotNull
    BigInteger numero_ordre;
    private String nom_membre;
    @Column(name = "DATE_NAISSANCE")
    @Temporal(TemporalType.DATE)
    private Date dateNaissance;
    @Column(name = "DATE_ENTREE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateEntree;
    @Column(name = "DATE_SORTIE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateSortie;
    @Transient
    private String matricule;
    @Transient
    private Orclass_TypeAvenant typeAvenant;
    private Boolean modifier, ajouter, retire_de_la_police = Boolean.FALSE;
    private Long codeid_retirer;
    

    public OrclassRisqueFamille() {
        idPolice = new OrclassPolice();
        idRisque = new OrclassRisque();
        idVille = new OrclassVille();

    }

    public OrclassAvenant getIdAvenant() {
        return idAvenant;
    }

    public void setIdAvenant(OrclassAvenant idAvenant) {
        this.idAvenant = idAvenant;
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

    public OrclassRisque getIdRisque() {
        return idRisque;
    }

    public void setIdRisque(OrclassRisque idRisque) {
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
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrclassRisqueFamille)) {
            return false;
        }
        OrclassRisqueFamille other = (OrclassRisqueFamille) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modele.OrclassRisqueFamille[ id=" + id + " ]";
    }

}
