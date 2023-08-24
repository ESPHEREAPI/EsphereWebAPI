/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import enums.NatureRisque;
import enums.StatutDocument;
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
 * @author JIATOU FRANCK
 */
@Entity
@Table(name = "ORCLASS_ATTEST_RISQ", uniqueConstraints = @UniqueConstraint(columnNames = {"ID_ENTREPRISE", "ID_POLICE", "ID_RISQUE", "ID_DOC_CAT", "NUM_ATTESTATION"}))

public class OrclassAttestationAssurance implements DAOEntry {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    @Column(name = "ID_ATT_ASS")
    private Long id;
    @JoinColumn(name = "ID_ENTREPRISE", referencedColumnName = "ID_ENTREPRISE")
    @ManyToOne(optional = false)
    private OrclassEntreprises idEntreprises;
    @JoinColumn(name = "ID_POLICE", referencedColumnName = "ID_POLICE")
    @ManyToOne(optional = false)
    private OrclassPolice idPolice;
    @JoinColumn(name = "ID_RISQUE", referencedColumnName = "ID_RISQUE")
    @ManyToOne(optional = false)
    private OrclassRisque idRisque;
    @JoinColumn(name = "ID_DOC_CAT", referencedColumnName = "ID_DOC_CAT")
    @ManyToOne(optional = false)
    private OrclassDocumentCategories idDocumentCategories;
    @Enumerated(EnumType.STRING)
    private NatureRisque natureRisque;
    @Enumerated(EnumType.STRING)
    private StatutDocument statutDocument;
    @Column(name = "NUM_ATTESTATION", unique = true)
    String numumero_Attestation;//numeroDocument
    @Column(name = "DATE_EFFET")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date_effet;
    @Column(name = "DATE_ECHEANCE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date_echeance;

    @Column(name = "DATE_CREATION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreation;
    @Column(name = "DATE_MODIFICATION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateModification;
    @Column(name = "DATE_AFFECTATION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date_affectation;
    private String saisir_par;
    private String modifier_par;
    private String valider_par;
    private String annuler_par;
    private BigInteger num_risque;
    Boolean imprimer = Boolean.FALSE;
    BigInteger num_logique = BigInteger.ZERO;

    public OrclassAttestationAssurance() {

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

    public OrclassRisque getIdRisque() {
        return idRisque;
    }

    public void setIdRisque(OrclassRisque idRisque) {
        this.idRisque = idRisque;
    }

    public OrclassDocumentCategories getIdDocumentCategories() {
        return idDocumentCategories;
    }

    public void setIdDocumentCategories(OrclassDocumentCategories idDocumentCategories) {
        this.idDocumentCategories = idDocumentCategories;
    }

    public NatureRisque getNatureRisque() {
        return natureRisque;
    }

    public void setNatureRisque(NatureRisque natureRisque) {
        this.natureRisque = natureRisque;
    }

    public StatutDocument getStatutDocument() {
        return statutDocument;
    }

    public void setStatutDocument(StatutDocument statutDocument) {
        this.statutDocument = statutDocument;
    }

    public String getNumumero_Attestation() {
        return numumero_Attestation;
    }

    public void setNumumero_Attestation(String numumero_Attestation) {
        this.numumero_Attestation = numumero_Attestation;
    }

   

    public Date getDate_effet() {
        return date_effet;
    }

    public void setDate_effet(Date date_effet) {
        this.date_effet = date_effet;
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

    public Date getDate_affectation() {
        return date_affectation;
    }

    public void setDate_affectation(Date date_affectation) {
        this.date_affectation = date_affectation;
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

    public BigInteger getNum_risque() {
        return num_risque;
    }

    public void setNum_risque(BigInteger num_risque) {
        this.num_risque = num_risque;
    }

    public Boolean getImprimer() {
        return imprimer;
    }

    public void setImprimer(Boolean imprimer) {
        this.imprimer = imprimer;
    }

    public BigInteger getNum_logique() {
        return num_logique;
    }

    public void setNum_logique(BigInteger num_logique) {
        this.num_logique = num_logique;
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
        if (!(object instanceof OrclassAttestationAssurance)) {
            return false;
        }
        OrclassAttestationAssurance other = (OrclassAttestationAssurance) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modele.OrclassAttestationAssurance[ id=" + id + " ]";
    }

}
