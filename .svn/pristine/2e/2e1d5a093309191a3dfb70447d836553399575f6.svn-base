/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

/**
 *
 * @author hp
 */
@Entity
@Table(name = "ORCLASS_POLICE_GARAN")
public class OrclassPoliceGarantie implements DAOEntry {
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    @Column(name = "ID_POLI_CARC")
    private Long id;
    
    @JoinColumn(name = "ID_POLICE", referencedColumnName = "ID_POLICE")
    
    @ManyToOne
    private OrclassPolice idPolice;
    @JoinColumn(name = "ID_ENTREPRISE", referencedColumnName = "ID_ENTREPRISE")
    @ManyToOne(optional = false)
    private OrclassEntreprises idEntreprise;
    @JoinColumn(name = "ID_GARANTIE", referencedColumnName = "ID_GARANTIE")
    @ManyToOne(optional = false)
    private OrclassGarantie idGarantie;
    @JoinColumn(name = "ID_AVENANT", referencedColumnName = "ID_AVENANT")
    @ManyToOne(optional = true)
    private OrclassAvenant idAvenant;
    @JoinColumn(name = "ID_GRP_GAR", referencedColumnName = "ID_REF_GROUPE")
    @ManyToOne(optional = true)
    private OrclasseRefGroupe idGroup;
    BigDecimal capital;
    BigDecimal taux;
    BigInteger pourcentage;
    BigDecimal prime;
    BigDecimal prorata;
    BigDecimal primeAnnuelle;
    @Transient
    Boolean afficher = Boolean.TRUE;
    @Transient
    Boolean editer = Boolean.FALSE;
    @Transient
    Orclass_TypeAvenant typeAvenant;
    private Boolean modifier, ajouter, retire_de_la_police = Boolean.FALSE;
    private Long codeid_retirer;
    @Column(name = "PRIME_NOT_TX")
    BigDecimal prime_sans_reduction_ou_operation = BigDecimal.ZERO;
    @Transient
    private List<OrclassGroupeGarantiePolice> listeGroupGrantitePolice;
    @Transient
    String libelleCapital;
     @Transient
   String  libellePrime;
     @Transient
     String libelleTaux;
      @Transient
     String libellePourcentage;
    
    @Column(name = "TAUX_MAJ_RED")
    BigDecimal taux_Majoration_reduction;// represente le taux sur donnees speciales il peut etre positive onparlera de majoration/negatif on parlera de reduction

    @Transient
    String franchise = "NEANT";

    public OrclassPoliceGarantie() {
        idGarantie = new OrclassGarantie();
        idPolice = new OrclassPolice();
        listeGroupGrantitePolice = new ArrayList<>();
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
    
    public OrclassGarantie getIdGarantie() {
        return idGarantie;
    }
    
    public void setIdGarantie(OrclassGarantie idGarantie) {
        this.idGarantie = idGarantie;
    }
    
    public BigDecimal getCapital() {
        return capital;
    }
    
    public void setCapital(BigDecimal capital) {
        this.capital = capital;
    }
    
    public BigDecimal getTaux() {
        return taux;
    }
    
    public void setTaux(BigDecimal taux) {
        this.taux = taux;
    }
    
    public BigInteger getPourcentage() {
        return pourcentage;
    }
    
    public void setPourcentage(BigInteger pourcentage) {
        this.pourcentage = pourcentage;
    }
    
    public BigDecimal getPrime() {
        return prime;
    }
    
    public void setPrime(BigDecimal prime) {
        this.prime = prime;
    }
    
    public BigDecimal getProrata() {
        return prorata;
    }
    
    public void setProrata(BigDecimal prorata) {
        this.prorata = prorata;
    }
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public Boolean getEditer() {
        return editer;
    }
    
    public void setEditer(Boolean editer) {
        this.editer = editer;
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
    
    public List<OrclassGroupeGarantiePolice> getListeGroupGrantitePolice() {
        return listeGroupGrantitePolice;
    }
    
    public void setListeGroupGrantitePolice(List<OrclassGroupeGarantiePolice> listeGroupGrantitePolice) {
        this.listeGroupGrantitePolice = listeGroupGrantitePolice;
    }
    
    public OrclasseRefGroupe getIdGroup() {
        return idGroup;
    }
    
    public void setIdGroup(OrclasseRefGroupe idGroup) {
        this.idGroup = idGroup;
    }
    
    public Boolean getAfficher() {
        return afficher;
    }
    
    public void setAfficher(Boolean afficher) {
        this.afficher = afficher;
    }
    
    public BigDecimal getTaux_Majoration_reduction() {
        return taux_Majoration_reduction;
    }
    
    public void setTaux_Majoration_reduction(BigDecimal taux_Majoration_reduction) {
        this.taux_Majoration_reduction = taux_Majoration_reduction;
    }
    
    public BigDecimal getPrimeAnnuelle() {
        return primeAnnuelle;
    }
    
    public void setPrimeAnnuelle(BigDecimal primeAnnuelle) {
        this.primeAnnuelle = primeAnnuelle;
    }
    
    public BigDecimal getPrime_sans_reduction_ou_operation() {
        return prime_sans_reduction_ou_operation;
    }
    
    public void setPrime_sans_reduction_ou_operation(BigDecimal prime_sans_reduction_ou_operation) {
        this.prime_sans_reduction_ou_operation = prime_sans_reduction_ou_operation;
    }
    
    public String getFranchise() {
        return franchise;
    }
    
    public void setFranchise(String franchise) {
        this.franchise = franchise;
    }
    
    public String getLibelleCapital() {
        if (capital == null || capital == BigDecimal.ZERO) {
            return "";
        }
        return libelleCapital;
    }

    public String getLibellePrime() {
        return libellePrime;
    }

    public void setLibellePrime(String libellePrime) {
        this.libellePrime = libellePrime;
    }
    
    public void setLibelleCapital(String libelleCapital) {
        this.libelleCapital = libelleCapital;
    }

    public String getLibelleTaux() {
        return libelleTaux;
    }

    public void setLibelleTaux(String libelleTaux) {
        this.libelleTaux = libelleTaux;
    }

    public String getLibellePourcentage() {
        return libellePourcentage;
    }

    public void setLibellePourcentage(String libellePourcentage) {
        this.libellePourcentage = libellePourcentage;
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
        if (!(object instanceof OrclassPoliceGarantie)) {
            return false;
        }
        OrclassPoliceGarantie other = (OrclassPoliceGarantie) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
        return "modele.OrclassPoliceGarantie[ id=" + id + " ]";
    }
    
}
