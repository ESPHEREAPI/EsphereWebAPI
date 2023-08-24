/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import enums.NatureOperationTarif;
import enums.SigneTarif;
import enums.OperationsTarif;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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

/**
 *
 * @author hp
 */
@Entity
@Table(name = "ORCLASS_TARIF", uniqueConstraints = @UniqueConstraint(columnNames = {"ID_ENTREPRISE", "ID_RUB_GAR", "NUMERO_ORDRE"}))
public class OrclassTarif implements DAOEntry {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    @Column(name = "ID_TARIF")
    private Long id;
    @Column(name = "DATE_CREATION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreation;
    @Column(name = "DATE_MODIFICATION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateModification;
    @JoinColumn(name = "ID_ENTREPRISE", referencedColumnName = "ID_ENTREPRISE")
    @ManyToOne(optional = false)
    private OrclassEntreprises idEntreprise;
    @JoinColumn(name = "ID_RUB_GAR", referencedColumnName = "ID_RUB_GAR")
    @ManyToOne(optional = false)
    private OrclassRubriqueGarantie idRubriqueGarantie;
    @Column(name = "NUMERO_ORDRE")
    BigInteger numero_Ordre;
    BigDecimal valeur_Additif;
    BigDecimal coefficient;
    BigInteger rapport_Division;
//    BigInteger nature_Operation;
    @Enumerated(EnumType.STRING)
    @Column(name = "NATURE_OPEARTION1")
    private NatureOperationTarif operationTarif1;
    @Enumerated(EnumType.STRING)
    @Column(name = "NATURE_OPEARTION2")
    private NatureOperationTarif operationTarif2;
    @OneToMany(mappedBy = "idTarif")
    private List<OrclassTarifCondition> tarifConditions;
   
    String idRubrique1;
   
    String idRubrique2;

    String idCaracteristiques1;
   
    String idCaracteristiques2;
    @Enumerated(EnumType.STRING)
    @Column(name = "SIGNE1")
    private SigneTarif SigneTarif1;
    @Enumerated(EnumType.STRING)
    @Column(name = "SIGNE2")
    private SigneTarif SigneTarif2;
    @Enumerated(EnumType.STRING)
    @Column(name = "SIGNE3")
    private SigneTarif SigneTarif3;
    @Enumerated(EnumType.STRING)
    @Column(name = "SIGNE")
    private SigneTarif SigneTarif4;
    @Enumerated(EnumType.STRING)
    @Column(name = "SIGNE5")
    private SigneTarif SigneTarif5;
    @Enumerated(EnumType.STRING)
    @Column(name = "SIGNE6")
    private SigneTarif SigneTarif6;
    @Enumerated(EnumType.STRING)
    @Column(name = "OPERATION1")
    private OperationsTarif operations;
    @Column(name = "OPERATION2")
    private OperationsTarif operations1;
    /*
    la valeur -1 sera considerer comme une valeur null  pour tous les valeurs numerique
     si dans la base de donnee nous avons des valeurs comme constant=-1 cela signie que constant =null
    */
    BigDecimal constant1;
    BigDecimal constant2;
    BigDecimal limiteInferieur;
    BigDecimal limiteSuperieur;
    BigDecimal limiteSupProrata;
    BigDecimal limiteInfProrata;

    public OrclassTarif() {
        idRubriqueGarantie = new OrclassRubriqueGarantie();
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

    public OrclassEntreprises getIdEntreprise() {
        return idEntreprise;
    }

    public void setIdEntreprise(OrclassEntreprises idEntreprise) {
        this.idEntreprise = idEntreprise;
    }

    public OrclassRubriqueGarantie getIdRubriqueGarantie() {
        return idRubriqueGarantie;
    }

    public void setIdRubriqueGarantie(OrclassRubriqueGarantie idRubriqueGarantie) {
        this.idRubriqueGarantie = idRubriqueGarantie;
    }

    public BigInteger getNumero_Ordre() {
        return numero_Ordre;
    }

    public void setNumero_Ordre(BigInteger numero_Ordre) {
        this.numero_Ordre = numero_Ordre;
    }

    public BigDecimal getValeur_Additif() {
        return valeur_Additif;
    }

    public void setValeur_Additif(BigDecimal valeur_Additif) {
        this.valeur_Additif = valeur_Additif;
    }

    public BigDecimal getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(BigDecimal coefficient) {
        this.coefficient = coefficient;
    }

    public BigInteger getRapport_Division() {
        return rapport_Division;
    }

    public void setRapport_Division(BigInteger rapport_Division) {
        this.rapport_Division = rapport_Division;
    }

    public NatureOperationTarif getOperationTarif1() {
        return operationTarif1;
    }

    public void setOperationTarif1(NatureOperationTarif operationTarif1) {
        this.operationTarif1 = operationTarif1;
    }

    public NatureOperationTarif getOperationTarif2() {
        return operationTarif2;
    }

    public void setOperationTarif2(NatureOperationTarif operationTarif2) {
        this.operationTarif2 = operationTarif2;
    }

    public String getIdRubrique1() {
        return idRubrique1;
    }

    public void setIdRubrique1(String idRubrique1) {
        this.idRubrique1 = idRubrique1;
    }

    public String getIdRubrique2() {
        return idRubrique2;
    }

    public void setIdRubrique2(String idRubrique2) {
        this.idRubrique2 = idRubrique2;
    }

    public String getIdCaracteristiques1() {
        return idCaracteristiques1;
    }

    public void setIdCaracteristiques1(String idCaracteristiques1) {
        this.idCaracteristiques1 = idCaracteristiques1;
    }

    public String getIdCaracteristiques2() {
        return idCaracteristiques2;
    }

    public void setIdCaracteristiques2(String idCaracteristiques2) {
        this.idCaracteristiques2 = idCaracteristiques2;
    }

    public SigneTarif getSigneTarif1() {
        return SigneTarif1;
    }

    public void setSigneTarif1(SigneTarif SigneTarif1) {
        this.SigneTarif1 = SigneTarif1;
    }

    public SigneTarif getSigneTarif2() {
        return SigneTarif2;
    }

    public void setSigneTarif2(SigneTarif SigneTarif2) {
        this.SigneTarif2 = SigneTarif2;
    }

    public SigneTarif getSigneTarif3() {
        return SigneTarif3;
    }

    public void setSigneTarif3(SigneTarif SigneTarif3) {
        this.SigneTarif3 = SigneTarif3;
    }

    public SigneTarif getSigneTarif4() {
        return SigneTarif4;
    }

    public void setSigneTarif4(SigneTarif SigneTarif4) {
        this.SigneTarif4 = SigneTarif4;
    }

    public SigneTarif getSigneTarif5() {
        return SigneTarif5;
    }

    public void setSigneTarif5(SigneTarif SigneTarif5) {
        this.SigneTarif5 = SigneTarif5;
    }

    public SigneTarif getSigneTarif6() {
        return SigneTarif6;
    }

    public void setSigneTarif6(SigneTarif SigneTarif6) {
        this.SigneTarif6 = SigneTarif6;
    }

    public OperationsTarif getOperations() {
        return operations;
    }

    public void setOperations(OperationsTarif operations) {
        this.operations = operations;
    }

    public OperationsTarif getOperations1() {
        return operations1;
    }

    public void setOperations1(OperationsTarif operations1) {
        this.operations1 = operations1;
    }

    public BigDecimal getConstant1() {
        return constant1;
    }

    public void setConstant1(BigDecimal constant1) {
        this.constant1 = constant1;
    }

    public BigDecimal getConstant2() {
        return constant2;
    }

    public void setConstant2(BigDecimal constant2) {
        this.constant2 = constant2;
    }

    public BigDecimal getLimiteInferieur() {
        return limiteInferieur;
    }

    public void setLimiteInferieur(BigDecimal limiteInferieur) {
        this.limiteInferieur = limiteInferieur;
    }

    public BigDecimal getLimiteSuperieur() {
        return limiteSuperieur;
    }

    public void setLimiteSuperieur(BigDecimal limiteSuperieur) {
        this.limiteSuperieur = limiteSuperieur;
    }

    public BigDecimal getLimiteSupProrata() {
        return limiteSupProrata;
    }

    public void setLimiteSupProrata(BigDecimal limiteSupProrata) {
        this.limiteSupProrata = limiteSupProrata;
    }

    public BigDecimal getLimiteInfProrata() {
        return limiteInfProrata;
    }

    public void setLimiteInfProrata(BigDecimal limiteInfProrata) {
        this.limiteInfProrata = limiteInfProrata;
    }
    

    public Long getId() {
        return id;
    }

    public List<OrclassTarifCondition> getTarifConditions() {
        return tarifConditions;
    }

    public void setTarifConditions(List<OrclassTarifCondition> tarifConditions) {
        this.tarifConditions = tarifConditions;
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
        if (!(object instanceof OrclassTarif)) {
            return false;
        }
        OrclassTarif other = (OrclassTarif) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modele.OrclassTarif[ id=" + id + " ]";
    }

}
