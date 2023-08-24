/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import enums.TypeApporteur;
import java.util.List;
import javax.persistence.CascadeType;
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

/**
 *
 * @author hp
 */
@Entity
public class OrclassTypeApporteur implements DAOEntry {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    String code;
    String libelle;
    @Column(name = "TYPE_APPORTEUR")
    @Enumerated(EnumType.STRING)
    private TypeApporteur typeApporteur;
    Boolean showAllCompagnies = Boolean.FALSE;

    @JoinColumn(name = "ID_ENTREPRISE", referencedColumnName = "ID_ENTREPRISE")
    @ManyToOne(optional = true)
    private OrclassEntreprises idEntreprise;
         @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTypeApporteur")
    private List<OrclassCommission_Prime_Apporteur> commission_Prime_ApporteurList;

    public OrclassTypeApporteur(String code, TypeApporteur typeApporteur) {
        this.code = code;
        this.typeApporteur = typeApporteur;
    }

    public OrclassTypeApporteur() {
//        idEntreprise=new OrclassEntreprises();

    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public Boolean getShowAllCompagnies() {
        return showAllCompagnies;
    }

    public void setShowAllCompagnies(Boolean showAllCompagnies) {
        this.showAllCompagnies = showAllCompagnies;
    }

    public OrclassEntreprises getIdEntreprise() {
        return idEntreprise;
    }

    public void setIdEntreprise(OrclassEntreprises idEntreprise) {
        this.idEntreprise = idEntreprise;
    }

    
    
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public TypeApporteur getTypeApporteur() {
        return typeApporteur;
    }

    public void setTypeApporteur(TypeApporteur typeApporteur) {
        this.typeApporteur = typeApporteur;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<OrclassCommission_Prime_Apporteur> getCommission_Prime_ApporteurList() {
        return commission_Prime_ApporteurList;
    }

    public void setCommission_Prime_ApporteurList(List<OrclassCommission_Prime_Apporteur> commission_Prime_ApporteurList) {
        this.commission_Prime_ApporteurList = commission_Prime_ApporteurList;
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
        if (!(object instanceof OrclassTypeApporteur)) {
            return false;
        }
        OrclassTypeApporteur other = (OrclassTypeApporteur) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modele.OrclassApporteur[ id=" + id + " ]";
    }
    
    

}
