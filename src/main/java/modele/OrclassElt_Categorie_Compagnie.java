/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import enums.LibelleRisque;
import java.io.Serializable;
import java.util.Comparator;
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

/**
 *
 * @author hp
 */
@Entity
@Table(name = "ORCLASS_ELT_CATEGORIE", uniqueConstraints = @UniqueConstraint(columnNames = {"ID_ENTREPRISE", "ID_CATEGORIE"}))
public class OrclassElt_Categorie_Compagnie implements DAOEntry {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;

    @JoinColumn(name = "ID_ENTREPRISE", referencedColumnName = "ID_ENTREPRISE")
    @ManyToOne(optional = false)
    private OrclassEntreprises idEntreprise;

    @JoinColumn(name = "ID_REGISTRE_PRODUCTION", referencedColumnName = "ID_REGISTRE_PRODUCTION")
    @ManyToOne(optional = true)
    private OrclassRegistreProduction idRegistreProduction;
//    @JoinColumn(name = "ID_REGISTRE_SINISTRE", referencedColumnName = "ID_REGISTRE_SINISTRE")
//    @ManyToOne(optional = true)
//    private OrclassRegistreSinistre idRegistreSinistre;
    @JoinColumn(name = "ID_CATEGORIE", referencedColumnName = "ID_CATEGORIE")
    @ManyToOne(optional = false)
    private OrclassCategories idCategories;
    @Transient
    int index = 0;

    int min, max = 0;
    int min_garantie = 0;
    @Enumerated(EnumType.STRING)
    @Column(name = "RISQUE")
    private LibelleRisque risque;

    public OrclassElt_Categorie_Compagnie() {
        idCategories = new OrclassCategories();
        min = 0;
        max = 0;
        min_garantie = 0;
//        idRegistreProduction=new OrclassRegistreProduction();
//        idRegistreSinistre=new OrclassRegistreSinistre();
    }

    public OrclassEntreprises getIdEntreprise() {
        return idEntreprise;
    }

    public void setIdEntreprise(OrclassEntreprises idEntreprise) {
        this.idEntreprise = idEntreprise;
    }

    public OrclassRegistreProduction getIdRegistreProduction() {
        return idRegistreProduction;
    }

    public void setIdRegistreProduction(OrclassRegistreProduction idRegistreProduction) {
        this.idRegistreProduction = idRegistreProduction;
    }

//    public OrclassRegistreSinistre getIdRegistreSinistre() {
//        return idRegistreSinistre;
//    }
//
//    public void setIdRegistreSinistre(OrclassRegistreSinistre idRegistreSinistre) {
//        this.idRegistreSinistre = idRegistreSinistre;
//    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public int getMin_garantie() {
        return min_garantie;
    }

    public void setMin_garantie(int min_garantie) {
        this.min_garantie = min_garantie;
    }

    public LibelleRisque getRisque() {
        return risque;
    }

    public void setRisque(LibelleRisque risque) {
        this.risque = risque;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public OrclassCategories getIdCategories() {
        return idCategories;
    }

    public void setIdCategories(OrclassCategories idCategories) {
        this.idCategories = idCategories;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
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
        if (!(object instanceof OrclassElt_Categorie_Compagnie)) {
            return false;
        }
        OrclassElt_Categorie_Compagnie other = (OrclassElt_Categorie_Compagnie) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modele.Elt_Categorie_Compagnie[ id=" + id + " ]";
    }

    public static Comparator<OrclassElt_Categorie_Compagnie> ByCodeASC = new Comparator<OrclassElt_Categorie_Compagnie>() {

        @Override
        public int compare(OrclassElt_Categorie_Compagnie o1, OrclassElt_Categorie_Compagnie o2) {
            return o1.idCategories.getCode().compareTo(o2.idCategories.getCode());
        }

    };
    public int writeIndexRow(int rowIndex){
        this.setIndex(rowIndex);
        return rowIndex;
    }

}
