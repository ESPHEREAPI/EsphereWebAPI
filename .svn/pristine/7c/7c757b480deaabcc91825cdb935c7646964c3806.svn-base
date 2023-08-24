/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.math.BigInteger;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author hp
 */
@Entity
@Table(name = "ORCLASS_REG_SINI", uniqueConstraints = @UniqueConstraint(columnNames = {"ID_ENTREPRISE", "ID_INTERMEDIAIRE", "CODE_EXERCICE", "ID_BRANCHE"}))
public class OrclassRegistreSinistre implements DAOEntry {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_REG_SIN")
    private Long id;

    String Code;
    @Column(name = "REGISTRE")
    String prefixe;//corespond au registre ex P1,A5
    Integer plage_numero;
    Integer num_debut;
    Integer num_fin;
    BigInteger num_Registre = BigInteger.ZERO;
    @JoinColumn(name = "ID_ENTREPRISE", referencedColumnName = "ID_ENTREPRISE")
    @ManyToOne(optional = false)
    private OrclassEntreprises idEntreprise;
    @JoinColumn(name = "CODE_EXERCICE", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private OrclassExercice idExercice;

    @JoinColumn(name = "ID_UTILISATEUR", referencedColumnName = "ID_UTILISATEUR")
    @ManyToOne(optional = false)
    private OrclassUtilisateurs idUtilisateur;
    @JoinColumn(name = "ID_BRANCHE", referencedColumnName = "ID_BRANCHE")
    @ManyToOne(optional = false)
    private OrclassBranches idBranche;

    @JoinColumn(name = "ID_INTERMEDIAIRE", referencedColumnName = "ID_INTERMEDIAIRE")
    @ManyToOne(optional = false)
    private OrclassIntermediaires idIntermediaire;

    public OrclassIntermediaires getIdIntermediaire() {
        return idIntermediaire;
    }

    public void setIdIntermediaire(OrclassIntermediaires idIntermediaire) {
        this.idIntermediaire = idIntermediaire;
    }

    public BigInteger getNum_Registre() {
        return num_Registre;
    }

    public void setNum_Registre(BigInteger num_Registre) {
        this.num_Registre = num_Registre;
    }

    public OrclassExercice getIdExercice() {
        return idExercice;
    }

    public void setIdExercice(OrclassExercice idExercice) {
        this.idExercice = idExercice;
    }

//    public List<OrclassElt_Categorie_Compagnie> getOrclassElt_Categorie_CompagnieList() {
//        return orclassElt_Categorie_CompagnieList;
//    }
//
//    public void setOrclassElt_Categorie_CompagnieList(List<OrclassElt_Categorie_Compagnie> orclassElt_Categorie_CompagnieList) {
//        this.orclassElt_Categorie_CompagnieList = orclassElt_Categorie_CompagnieList;
//    }
    public OrclassUtilisateurs getIdUtilisateur() {
        return idUtilisateur;
    }

    public void setIdUtilisateur(OrclassUtilisateurs idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }

    public OrclassRegistreSinistre() {
        idEntreprise = new OrclassEntreprises();
//        idIntermediaire = new OrclassIntermediaires();
        idExercice = new OrclassExercice();
        idBranche = new OrclassBranches();
    }

    public OrclassEntreprises getIdEntreprise() {
        return idEntreprise;
    }

    public void setIdEntreprise(OrclassEntreprises idEntreprise) {
        this.idEntreprise = idEntreprise;
    }

    public String getCode() {
        return Code;
    }

    public void setCode(String Code) {
        this.Code = Code;
    }

    public String getPrefixe() {
        return prefixe;
    }

    public void setPrefixe(String prefixe) {
        this.prefixe = prefixe;
    }

    public Integer getPlage_numero() {
        return plage_numero;
    }

    public void setPlage_numero(Integer plage_numero) {
        this.plage_numero = plage_numero;
    }

    public Integer getNum_debut() {
        return num_debut;
    }

    public void setNum_debut(Integer num_debut) {
        this.num_debut = num_debut;
    }

    public Integer getNum_fin() {
        return num_fin;
    }

    public void setNum_fin(Integer num_fin) {
        this.num_fin = num_fin;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public OrclassBranches getIdBranche() {
        return idBranche;
    }

    public void setIdBranche(OrclassBranches idBranche) {
        this.idBranche = idBranche;
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
        if (!(object instanceof OrclassRegistreSinistre)) {
            return false;
        }
        OrclassRegistreSinistre other = (OrclassRegistreSinistre) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modele.OrclassRegistreSinistre[ id=" + id + " ]";
    }

}
