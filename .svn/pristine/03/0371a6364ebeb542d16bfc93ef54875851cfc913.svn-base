/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import enums.Sexe;
import enums.TypePermis;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author JIATOU FRANCK
 */
@Entity
@Table(name = "ORCLASS_CONDUCTEUR")
public class OrclassConducteur implements DAOEntry {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    @Column(name = "ID_CONDUCT")
    private Long id;
    @Column(name = "NOM")
    private String nomComplet;
    @Enumerated(EnumType.STRING)
    private TypePermis permis;
    private String numero_permis;
    @Column(name = "DATE_SAISIR")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateSaisir;
    @Column(name = "DATE_DELI_PERM")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateDeliPerm;
    private String lieu_deli_permis;
    @Column(name = "DATE_NAISSANCE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date_Naissance;
    private Integer durre_conduite;
     @Enumerated(EnumType.STRING)
    private Sexe sexe;
//     private String num_attestation;
    

    @JoinColumn(name = "ID_ENTREPRISE", referencedColumnName = "ID_ENTREPRISE")
    @ManyToOne(optional = false)
    private OrclassEntreprises idEntreprise;
    @JoinColumn(name = "ID_RISQUE", referencedColumnName = "ID_RISQUE")
    @ManyToOne(optional = false)
    private OrclassRisque idRisque;
      @JoinColumn(name = "ID_ATTEST_CONDUCT", referencedColumnName = "ID_ATTEST_CONDUCT")
    @ManyToOne(optional = true)
    private OrclassAttestationConducteur idTestationConducteur;
    
    
        @Basic(fetch = FetchType.LAZY)
    @Lob
    @Column(name = "ATTESTATION")
    private byte[] attestation_conducteur;
    @Size(max = 50)
    @Column(name = "chemin")
    private String chemin_sauvegarde_attestation;

    public OrclassConducteur(String nomComplet) {
        this.nomComplet = nomComplet;
    }

    public OrclassConducteur() {
    }

    public String getNomComplet() {
        return nomComplet;
    }

    public void setNomComplet(String nomComplet) {
        this.nomComplet = nomComplet;
    }

    public TypePermis getPermis() {
        return permis;
    }

    public void setPermis(TypePermis permis) {
        this.permis = permis;
    }

    public String getNumero_permis() {
        return numero_permis;
    }

    public void setNumero_permis(String numero_permis) {
        this.numero_permis = numero_permis;
    }

    public Date getDateSaisir() {
        return dateSaisir;
    }

    public void setDateSaisir(Date dateSaisir) {
        this.dateSaisir = dateSaisir;
    }

    public Date getDateDeliPerm() {
        return dateDeliPerm;
    }

    public void setDateDeliPerm(Date dateDeliPerm) {
        this.dateDeliPerm = dateDeliPerm;
    }

    public String getLieu_deli_permis() {
        return lieu_deli_permis;
    }

    public void setLieu_deli_permis(String lieu_deli_permis) {
        this.lieu_deli_permis = lieu_deli_permis;
    }

    public Date getDate_Naissance() {
        return date_Naissance;
    }

    public void setDate_Naissance(Date date_Naissance) {
        this.date_Naissance = date_Naissance;
    }

    public Integer getDurre_conduite() {
        return durre_conduite;
    }

    public void setDurre_conduite(Integer durre_conduite) {
        this.durre_conduite = durre_conduite;
    }

    public Sexe getSexe() {
        return sexe;
    }

    public void setSexe(Sexe sexe) {
        this.sexe = sexe;
    }

 
    public OrclassEntreprises getIdEntreprise() {
        return idEntreprise;
    }

    public void setIdEntreprise(OrclassEntreprises idEntreprise) {
        this.idEntreprise = idEntreprise;
    }

    public OrclassRisque getIdRisque() {
        return idRisque;
    }

    public void setIdRisque(OrclassRisque idRisque) {
        this.idRisque = idRisque;
    }

    public OrclassAttestationConducteur getIdTestationConducteur() {
        return idTestationConducteur;
    }

    public void setIdTestationConducteur(OrclassAttestationConducteur idTestationConducteur) {
        this.idTestationConducteur = idTestationConducteur;
    }

    public byte[] getAttestation_conducteur() {
        return attestation_conducteur;
    }

    public void setAttestation_conducteur(byte[] attestation_conducteur) {
        this.attestation_conducteur = attestation_conducteur;
    }

    public String getChemin_sauvegarde_attestation() {
        return chemin_sauvegarde_attestation;
    }

    public void setChemin_sauvegarde_attestation(String chemin_sauvegarde_attestation) {
        this.chemin_sauvegarde_attestation = chemin_sauvegarde_attestation;
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
        if (!(object instanceof OrclassConducteur)) {
            return false;
        }
        OrclassConducteur other = (OrclassConducteur) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modele.Conducteur[ id=" + id + " ]";
    }

}
