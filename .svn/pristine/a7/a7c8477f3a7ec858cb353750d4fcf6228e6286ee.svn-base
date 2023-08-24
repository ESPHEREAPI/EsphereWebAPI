/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modele;

import java.io.Serializable;
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
 * @author JIATOU FRANCK
 */
@Entity
@Table(name = "ORCLASS_CARACT_SIN", uniqueConstraints = @UniqueConstraint(columnNames = {"ID_ENTREPRISE", "ID_CARACTERISTIQUE", "ID_SIN_MAL"}))
public class OrclassCaracteristiqueSinistreMaladie implements DAOEntry {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_CARA_SIN")
    private Long id;
    @JoinColumn(name = "ID_ENTREPRISE", referencedColumnName = "ID_ENTREPRISE")
    @ManyToOne(optional = false)
    private OrclassEntreprises idEntreprise;
    @JoinColumn(name = "ID_SIN_MAL", referencedColumnName = "ID_SIN_MAL")
    @ManyToOne(optional = false)
    private OrclassSinistreMaladie idSinistreMaladie;
    @JoinColumn(name = "ID_CARACTERISTIQUE", referencedColumnName = "ID_CARACTERISTIQUE")
    @ManyToOne(optional = false)
    private OrclassCaracteristiques idCaracteristiques;

    public OrclassCaracteristiqueSinistreMaladie() {
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
        if (!(object instanceof OrclassCaracteristiqueSinistreMaladie)) {
            return false;
        }
        OrclassCaracteristiqueSinistreMaladie other = (OrclassCaracteristiqueSinistreMaladie) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modele.OrclassCaracteristiqueSinistreMaladie[ id=" + id + " ]";
    }

}
