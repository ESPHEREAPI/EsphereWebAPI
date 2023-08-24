/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author hp
 */
@Entity
@Table(name = "ORCLASS_ETS_LIST_CARACT")
public class OrclassElement_Liste_Caracteristique implements DAOEntry {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String code;
    private String libelle;
    private int ordre;

    @JoinColumn(name = "ID_TYPE_CARACT", referencedColumnName = "ID_TYPE_CARACT")
    @ManyToOne(optional = true)
    private OrclassType_Caracteristique type_Caracteristique;
    @JoinColumn(name = "ID_UNITE_BUREAU", referencedColumnName = "ID_UNITE_BUREAU")
    @ManyToOne(optional = true)
    private OrclassUnite_Caracteristique unite_Caracteristique;
      @JoinColumn(name = "ID_ENTREPRISE", referencedColumnName = "ID_ENTREPRISE")
    @ManyToOne(optional = false)
    private OrclassEntreprises idEntreprise;
        @JoinColumn(name = "ID_CARACTERISTIQUE", referencedColumnName = "ID_CARACTERISTIQUE")
    @ManyToOne(optional = false)
    private OrclassCaracteristiques idCaracteristiques;

    public OrclassElement_Liste_Caracteristique() {
//        type_Caracteristique=new OrclassType_Caracteristique();
//        unite_Caracteristique=new OrclassUnite_Caracteristique();
        idCaracteristiques=new OrclassCaracteristiques();
        
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public int getOrdre() {
        return ordre;
    }

    public void setOrdre(int ordre) {
        this.ordre = ordre;
    }

    public OrclassType_Caracteristique getType_Caracteristique() {
        return type_Caracteristique;
    }

    public void setType_Caracteristique(OrclassType_Caracteristique type_Caracteristique) {
        this.type_Caracteristique = type_Caracteristique;
    }

    public OrclassUnite_Caracteristique getUnite_Caracteristique() {
        return unite_Caracteristique;
    }

    public void setUnite_Caracteristique(OrclassUnite_Caracteristique unite_Caracteristique) {
        this.unite_Caracteristique = unite_Caracteristique;
    }

    public OrclassEntreprises getIdEntreprise() {
        return idEntreprise;
    }

    public void setIdEntreprise(OrclassEntreprises idEntreprise) {
        this.idEntreprise = idEntreprise;
    }

    public OrclassCaracteristiques getIdCaracteristiques() {
        return idCaracteristiques;
    }

    public void setIdCaracteristiques(OrclassCaracteristiques idCaracteristiques) {
        this.idCaracteristiques = idCaracteristiques;
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
        if (!(object instanceof OrclassElement_Liste_Caracteristique)) {
            return false;
        }
        OrclassElement_Liste_Caracteristique other = (OrclassElement_Liste_Caracteristique) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modele.OrclassElement_Liste_Caracteristique[ id=" + id + " ]";
    }

}
