/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
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
import javax.validation.constraints.Size;

/**
 *
 * @author hp
 */
@Entity
@Table(name = "ORCLASS_APPORTEUR", uniqueConstraints = @UniqueConstraint(columnNames = {"ID_ENTREPRISE", "ID_REF_APPORTEUR","ID_VILLE"}))
public class OrclassApporteur implements DAOEntry {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    @Column(name = "ID_APPORTEUR")
    private Long idApporteur;

    @JoinColumn(name = "ID_REF_APPORTEUR", referencedColumnName = "ID_REF_APPORTEUR")
    @ManyToOne(optional = false)
    private OrclassRefApporteur idRefApporteur;
    @Column(name = "DATE_CREATION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreation;
    @Column(name = "DATE_MODIFICATION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateModification;
    @JoinColumn(name = "ID_ENTREPRISE", referencedColumnName = "ID_ENTREPRISE")
    @ManyToOne(optional = false)
    private OrclassEntreprises idEntreprise;
    @JoinColumn(name = "ID_VILLE", referencedColumnName = "ID_VILLE")
    @ManyToOne(optional = false)
    private OrclassVille idVille;
    @JoinColumn(name = "ID_TYPEAPPORTEUR", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private OrclassTypeApporteur idTypeApporteur;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idApporteur")
    private List<OrclassCommission_Prime_Apporteur> commission_Prime_ApporteurList;
    private BigInteger codePrincipal=BigInteger.ZERO;

    public OrclassApporteur() {
        idVille = new OrclassVille();
        idTypeApporteur = new OrclassTypeApporteur();
        dateCreation = new Date();
        idRefApporteur = new OrclassRefApporteur();

    }

    public Long getIdApporteur() {
        return idApporteur;
    }

    public void setIdApporteur(Long idApporteur) {
        this.idApporteur = idApporteur;
    }

    public OrclassRefApporteur getIdRefApporteur() {
        return idRefApporteur;
    }

    public void setIdRefApporteur(OrclassRefApporteur idRefApporteur) {
        this.idRefApporteur = idRefApporteur;
    }

    public OrclassEntreprises getIdEntreprise() {
        return idEntreprise;
    }

    public void setIdEntreprise(OrclassEntreprises idEntreprise) {
        this.idEntreprise = idEntreprise;
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


    public List<OrclassCommission_Prime_Apporteur> getCommission_Prime_ApporteurList() {
        return commission_Prime_ApporteurList;
    }

    public void setCommission_Prime_ApporteurList(List<OrclassCommission_Prime_Apporteur> commission_Prime_ApporteurList) {
        this.commission_Prime_ApporteurList = commission_Prime_ApporteurList;
    }

    public OrclassVille getIdVille() {
        return idVille;
    }

    public void setIdVille(OrclassVille idVille) {
        this.idVille = idVille;
    }

    public OrclassTypeApporteur getIdTypeApporteur() {
        return idTypeApporteur;
    }

    public void setIdTypeApporteur(OrclassTypeApporteur idTypeApporteur) {
        this.idTypeApporteur = idTypeApporteur;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idApporteur != null ? idApporteur.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrclassApporteur)) {
            return false;
        }
        OrclassApporteur other = (OrclassApporteur) object;
        if ((this.idApporteur == null && other.idApporteur != null) || (this.idApporteur != null && !this.idApporteur.equals(other.idApporteur))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modele.OrclassApporteur[ id=" + idApporteur + " ]";
    }

    public BigInteger getCodePrincipal() {
        return codePrincipal;
    }

    public void setCodePrincipal(BigInteger codePrincipal) {
        this.codePrincipal = codePrincipal;
    }
    

}
