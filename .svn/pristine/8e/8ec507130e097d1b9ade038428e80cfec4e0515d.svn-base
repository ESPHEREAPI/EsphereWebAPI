/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

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
@Table(name = "ORCLASS_POLICE_PLAFOND")
public class OrclassPolicePlafond implements DAOEntry {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    @Column(name = "ID_POLICE_PLAFOND")
    private Long id;

    @JoinColumn(name = "ID_POLICE", referencedColumnName = "ID_POLICE")
    @ManyToOne
    private OrclassPolice idPolice;
    @JoinColumn(name = "ID_PLAFOND", referencedColumnName = "ID_PLAFOND")
    @ManyToOne(optional = false)
    private OrclassPlafondMaladie idPlafondMaladie;
    @JoinColumn(name = "ID_CATEGORIE", referencedColumnName = "ID_CATEGORIE")
    @ManyToOne(optional = false)
    private OrclassCategories idCategories;
    @JoinColumn(name = "ID_ENTREPRISE", referencedColumnName = "ID_ENTREPRISE")
    @ManyToOne(optional = false)
    private OrclassEntreprises idEntreprise;
    @JoinColumn(name = "ID_AVENANT", referencedColumnName = "ID_AVENANT")
    @ManyToOne(optional = true)
    private OrclassAvenant idAvenant;
      @JoinColumn(name = "ID_GROUPE_PLAFOND", referencedColumnName = "ID_REF_GROUPE")
    @ManyToOne(optional = true)
    private OrclasseRefGroupe idGroup;
    private Boolean modifier, ajouter, retire_de_la_police = Boolean.FALSE;
    private Long codeid_retirer;

    @Transient
    Orclass_TypeAvenant typeAvenant;
    private Boolean print = Boolean.FALSE;

    public OrclassPolicePlafond() {
        idCategories = new OrclassCategories();
        idPlafondMaladie = new OrclassPlafondMaladie();
        idPolice = new OrclassPolice();
    }

    public OrclassPolice getIdPolice() {
        return idPolice;
    }

    public void setIdPolice(OrclassPolice idPolice) {
        this.idPolice = idPolice;
    }

    public OrclassPlafondMaladie getIdPlafondMaladie() {
        return idPlafondMaladie;
    }

    public void setIdPlafondMaladie(OrclassPlafondMaladie idPlafondMaladie) {
        this.idPlafondMaladie = idPlafondMaladie;
    }

    public OrclassCategories getIdCategories() {
        return idCategories;
    }

    public void setIdCategories(OrclassCategories idCategories) {
        this.idCategories = idCategories;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public OrclassEntreprises getIdEntreprise() {
        return idEntreprise;
    }

    public void setIdEntreprise(OrclassEntreprises idEntreprise) {
        this.idEntreprise = idEntreprise;
    }

    public OrclassAvenant getIdAvenant() {
        return idAvenant;
    }

    public void setIdAvenant(OrclassAvenant idAvenant) {
        this.idAvenant = idAvenant;
    }

    public Orclass_TypeAvenant getTypeAvenant() {
        return typeAvenant;
    }

    public void setTypeAvenant(Orclass_TypeAvenant typeAvenant) {
        this.typeAvenant = typeAvenant;
    }

    public Boolean getPrint() {
        return print;
    }

    public void setPrint(Boolean print) {
        this.print = print;
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

    public OrclasseRefGroupe getIdGroup() {
        return idGroup;
    }

    public void setIdGroup(OrclasseRefGroupe idGroup) {
        this.idGroup = idGroup;
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
        if (!(object instanceof OrclassPolicePlafond)) {
            return false;
        }
        OrclassPolicePlafond other = (OrclassPolicePlafond) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modele.OrclassPolicePlafond[ id=" + id + " ]";
    }

}
