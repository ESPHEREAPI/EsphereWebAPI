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
 * @author JIATOU FRANCK
 */
@Entity
@Table(name = "ORCLASS_GRP_CARACT_GARANT")
public class OrclassGroupCaracteristiqueGarantie implements DAOEntry {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @JoinColumn(name = "ID_ENTREPRISE", referencedColumnName = "ID_ENTREPRISE")
    @ManyToOne(optional = false)
    private OrclassEntreprises idEntreprise;
    @JoinColumn(name = "ID_CARACTERISTIQUE", referencedColumnName = "ID_CARACTERISTIQUE")
    @ManyToOne(optional = false)
    private OrclassCaracteristiques idCaracteristiques;
    @JoinColumn(name = "ID_GRPE_CAR_GAR", referencedColumnName = "ID_REF_GROUPE")
    @ManyToOne(optional = false)
    private OrclasseRefGroupe idGroup;
    @JoinColumn(name = "ID_GARANTIE", referencedColumnName = "ID_GARANTIE")
    @ManyToOne(optional = false)
    private OrclassGarantie idGarantie;

    public OrclassGroupCaracteristiqueGarantie() {
        idCaracteristiques=new OrclassCaracteristiques();
        idGarantie=new  OrclassGarantie();
        idGroup=new OrclasseRefGroupe();
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

    public OrclasseRefGroupe getIdGroup() {
        return idGroup;
    }

    public void setIdGroup(OrclasseRefGroupe idGroup) {
        this.idGroup = idGroup;
    }

    public OrclassGarantie getIdGarantie() {
        return idGarantie;
    }

    public void setIdGarantie(OrclassGarantie idGarantie) {
        this.idGarantie = idGarantie;
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
        if (!(object instanceof OrclassGroupCaracteristiqueGarantie)) {
            return false;
        }
        OrclassGroupCaracteristiqueGarantie other = (OrclassGroupCaracteristiqueGarantie) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modele.OrclassGroupCaracteristiqueGarantie[ id=" + id + " ]";
    }

}
