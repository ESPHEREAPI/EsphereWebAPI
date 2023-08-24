/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import enums.ModeCalculRubrique;
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
 * @author hp
 */
@Entity
@Table(name = "ORCLASS_RUB_GARA")
//, uniqueConstraints = @UniqueConstraint(columnNames = {"ID_ENTREPRISE", "ID_GARANTIE", "ID_RUBRIQUE", "ID_TYPE_TARIF", "DATE_EFFET","DATE_ECHEANCE"})
public class OrclassRubriqueGarantie implements DAOEntry {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    @NotNull
    @Column(name = "ID_RUB_GAR")
    private Long id;
    @Column(name = "DATE_EFFET")
    @Temporal(TemporalType.DATE)
    private Date dateEffet;
    @Column(name = "DATE_ECHEANCE")
    @Temporal(TemporalType.DATE)
    private Date dateEcheance;
    @Column(name = "DATE_CREATION")
    @Temporal(TemporalType.DATE)
    private Date datecreation;
    @JoinColumn(name = "ID_ENTREPRISE", referencedColumnName = "ID_ENTREPRISE")
    @ManyToOne(optional = false)
    private OrclassEntreprises idEntreprise;
    @JoinColumn(name = "ID_GARANTIE", referencedColumnName = "ID_GARANTIE")// la garantie a deja un mode  de calcukl
    @ManyToOne(optional = false)
    private OrclassGarantie idGarantie;
    @JoinColumn(name = "ID_RUBRIQUE", referencedColumnName = "ID_RUBRIQUE")
    @ManyToOne(optional = false)
    private OrclassRubrique idRubrique;
    @JoinColumn(name = "ID_CARACTERISTIQUE", referencedColumnName = "ID_CARACTERISTIQUE")// 
    @ManyToOne(optional = true)
    private OrclassCaracteristiques idCaracteristiques;
    @JoinColumn(name = "ID_TYPE_TARIF", referencedColumnName = "ID_TYPE_TARIF")
    @ManyToOne(optional = false)
    private OrclassTypeTarif idTypeTarif;
    @JoinColumn(name = "ID_UNITE_BUREAU", referencedColumnName = "ID_UNITE_BUREAU")
    @ManyToOne(optional = true)
    private OrclassUnite_Caracteristique unite_Caracteristique;
     @Enumerated(EnumType.STRING)
    @Column(name = "MODE_CALCUL")
    private ModeCalculRubrique modeCalcul;

    String Observation;

    public OrclassRubriqueGarantie() {
        idGarantie=new OrclassGarantie();
        idRubrique=new OrclassRubrique();
        
        
    }
    
    

    public Date getDateEffet() {
        return dateEffet;
    }

    public void setDateEffet(Date dateEffet) {
        this.dateEffet = dateEffet;
    }

    public Date getDateEcheance() {
        return dateEcheance;
    }

    public void setDateEcheance(Date dateEcheance) {
        this.dateEcheance = dateEcheance;
    }

    public OrclassEntreprises getIdEntreprise() {
        return idEntreprise;
    }

    public void setIdEntreprise(OrclassEntreprises idEntreprise) {
        this.idEntreprise = idEntreprise;
    }

    public OrclassGarantie getIdGarantie() {
        return idGarantie;
    }

    public void setIdGarantie(OrclassGarantie idGarantie) {
        this.idGarantie = idGarantie;
    }

    public OrclassRubrique getIdRubrique() {
        return idRubrique;
    }

    public void setIdRubrique(OrclassRubrique idRubrique) {
        this.idRubrique = idRubrique;
    }

    public OrclassCaracteristiques getIdCaracteristiques() {
        return idCaracteristiques;
    }

    public void setIdCaracteristiques(OrclassCaracteristiques idCaracteristiques) {
        this.idCaracteristiques = idCaracteristiques;
    }

    public OrclassTypeTarif getIdTypeTarif() {
        return idTypeTarif;
    }

    public void setIdTypeTarif(OrclassTypeTarif idTypeTarif) {
        this.idTypeTarif = idTypeTarif;
    }

    public OrclassUnite_Caracteristique getUnite_Caracteristique() {
        return unite_Caracteristique;
    }

    public void setUnite_Caracteristique(OrclassUnite_Caracteristique unite_Caracteristique) {
        this.unite_Caracteristique = unite_Caracteristique;
    }

    public ModeCalculRubrique getModeCalcul() {
        return modeCalcul;
    }

    public void setModeCalcul(ModeCalculRubrique modeCalcul) {
        this.modeCalcul = modeCalcul;
    }

  


    public String getObservation() {
        return Observation;
    }

    public void setObservation(String Observation) {
        this.Observation = Observation;
    }
    
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDatecreation() {
        return datecreation;
    }

    public void setDatecreation(Date datecreation) {
        this.datecreation = datecreation;
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
        if (!(object instanceof OrclassRubriqueGarantie)) {
            return false;
        }
        OrclassRubriqueGarantie other = (OrclassRubriqueGarantie) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modele.OrclassRubriqueGarantie[ id=" + id + " ]";
    }

}
