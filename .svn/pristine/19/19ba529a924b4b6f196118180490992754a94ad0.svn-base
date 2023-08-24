/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import enums.SortSinistreMaladie;
import java.io.Serializable;
import java.math.BigDecimal;
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
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

/**
 *
 * @author JIATOU FRANCK
 */
@Entity
@Table(name = "ORCLASS_MEDI_SIN", uniqueConstraints = @UniqueConstraint(columnNames = {"ID_ENTREPRISE", "ID_SIN_MAL", "ID_MEDICAMENT"}))
public class OrclassMedicamentSinistreMaladie implements DAOEntry {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    @Column(name = "ID_MEDI_SIN")
    private Long id;
    @JoinColumn(name = "ID_ENTREPRISE", referencedColumnName = "ID_ENTREPRISE")
    @ManyToOne(optional = false)
    private OrclassEntreprises idEntreprise;
    @JoinColumn(name = "ID_SIN_MAL", referencedColumnName = "ID_SIN_MAL")
    @ManyToOne(optional = false)
    private OrclassSinistreMaladie idSinistreMaladie;

    @JoinColumn(name = "ID_MEDICAMENT", referencedColumnName = "ID_MEDICAMENT")
    @ManyToOne(optional = false)
    private OrclassMedicament idMedicament;

    private BigDecimal quantie = BigDecimal.ZERO;
    private BigDecimal cout = BigDecimal.ZERO;
    private BigDecimal taux;
    private BigDecimal montant;
        private BigDecimal montant_remb;
    @Enumerated(EnumType.STRING)
    @Column(name = "SORT")
    private SortSinistreMaladie sort;
    private String motif;
    @Transient
    Boolean afficher=Boolean.FALSE;

    public OrclassMedicamentSinistreMaladie() {
        idMedicament=new OrclassMedicament();
        idSinistreMaladie=new OrclassSinistreMaladie();
    }

    public OrclassEntreprises getIdEntreprise() {
        return idEntreprise;
    }

    public void setIdEntreprise(OrclassEntreprises idEntreprise) {
        this.idEntreprise = idEntreprise;
    }

    public OrclassSinistreMaladie getIdSinistreMaladie() {
        return idSinistreMaladie;
    }

    public void setIdSinistreMaladie(OrclassSinistreMaladie idSinistreMaladie) {
        this.idSinistreMaladie = idSinistreMaladie;
    }

    public OrclassMedicament getIdMedicament() {
        return idMedicament;
    }

    public void setIdMedicament(OrclassMedicament idMedicament) {
        this.idMedicament = idMedicament;
    }

    public BigDecimal getQuantie() {
        return quantie;
    }

    public void setQuantie(BigDecimal quantie) {
        this.quantie = quantie;
    }

    public BigDecimal getCout() {
        return cout;
    }

    public void setCout(BigDecimal cout) {
        this.cout = cout;
    }

    public BigDecimal getTaux() {
        return taux;
    }

    public void setTaux(BigDecimal taux) {
        this.taux = taux;
    }

    public BigDecimal getMontant() {
        return montant;
    }

    public void setMontant(BigDecimal montant) {
        this.montant = montant;
    }

    public SortSinistreMaladie getSort() {
        return sort;
    }

    public void setSort(SortSinistreMaladie sort) {
        this.sort = sort;
    }

    public String getMotif() {
        return motif;
    }

    public void setMotif(String motif) {
        this.motif = motif;
    }

    public BigDecimal getMontant_remb() {
        return montant_remb;
    }

    public void setMontant_remb(BigDecimal montant_remb) {
        this.montant_remb = montant_remb;
    }

    public Boolean getAfficher() {
        return afficher;
    }

    public void setAfficher(Boolean afficher) {
        this.afficher = afficher;
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
        if (!(object instanceof OrclassMedicamentSinistreMaladie)) {
            return false;
        }
        OrclassMedicamentSinistreMaladie other = (OrclassMedicamentSinistreMaladie) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modele.OrclassMedicamentSinistreMaladie[ id=" + id + " ]";
    }

}
