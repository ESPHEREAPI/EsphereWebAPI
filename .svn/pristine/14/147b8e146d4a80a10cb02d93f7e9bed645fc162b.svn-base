/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modele;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author JIATOU FRANCK
 */
@Entity
public class ParametrageDonne implements DAOEntry {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @JoinColumn(name = "ID_TYPE_BUREAU", referencedColumnName = "ID_TYPE_BUREAU")
    @ManyToOne(optional = true)
    private OrclassTypeBureau idTypeBureau;
    @JoinColumn(name = "ID_TYPEAPPORTEUR", referencedColumnName = "ID")
    @ManyToOne(optional = true)
    private OrclassTypeApporteur idTypeApporteur;
    String numdebut;
    @JoinColumn(name = "ID_ENTREPRISE", referencedColumnName = "ID_ENTREPRISE")
    @ManyToOne(optional = false)
    private OrclassEntreprises idEntreprise;

    public OrclassTypeBureau getIdTypeBureau() {
        return idTypeBureau;
    }

    public void setIdTypeBureau(OrclassTypeBureau idTypeBureau) {
        this.idTypeBureau = idTypeBureau;
    }

    public OrclassTypeApporteur getIdTypeApporteur() {
        return idTypeApporteur;
    }

    public void setIdTypeApporteur(OrclassTypeApporteur idTypeApporteur) {
        this.idTypeApporteur = idTypeApporteur;
    }

    public String getNumdebut() {
        return numdebut;
    }

    public void setNumdebut(String numdebut) {
        this.numdebut = numdebut;
    }

    public OrclassEntreprises getIdEntreprise() {
        return idEntreprise;
    }

    public void setIdEntreprise(OrclassEntreprises idEntreprise) {
        this.idEntreprise = idEntreprise;
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
        if (!(object instanceof ParametrageDonne)) {
            return false;
        }
        ParametrageDonne other = (ParametrageDonne) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modele.ParametrageDonne[ id=" + id + " ]";
    }

}
