package modele;

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

@Entity
@Table(name = "ORCLASS_ACCE_AVE_CARACT")
public class Orclass_AccessAvenat_Caracteristique implements DAOEntry {

    @JoinColumn(name = "ID_ACCESS_AVENANT", referencedColumnName = "ID_ACCESS_AVENANT")
    @ManyToOne(optional = false)
    private Orclass_Access_Avenant idAccess_Avenant = new Orclass_Access_Avenant();

    @JoinColumn(name = "ID_CARACTERISTIQUE", referencedColumnName = "ID_CARACTERISTIQUE")
    @ManyToOne(optional = false)
    private OrclassCaracteristiques idCaracteristiques = new OrclassCaracteristiques();

    @JoinColumn(name = "ID_ENTREPRISE", referencedColumnName = "ID_ENTREPRISE")
    @ManyToOne(optional = false)
    private OrclassEntreprises idEntreprise;
    @Transient
    private List<OrclassCaracteristiques> listeCaracteristiqueSelect = new ArrayList<>();

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_ACCE_AVE_CARACT")
    private Long id;

    private static final long serialVersionUID = 1L;

    public OrclassEntreprises getIdEntreprise() {
        return this.idEntreprise;
    }

    public void setIdEntreprise(OrclassEntreprises idEntreprise) {
        this.idEntreprise = idEntreprise;
    }

    public OrclassCaracteristiques getIdCaracteristiques() {
        return this.idCaracteristiques;
    }

    public void setIdCaracteristiques(OrclassCaracteristiques idCaracteristiques) {
        this.idCaracteristiques = idCaracteristiques;
    }

    public Orclass_Access_Avenant getIdAccess_Avenant() {
        return this.idAccess_Avenant;
    }

    public void setIdAccess_Avenant(Orclass_Access_Avenant idAccess_Avenant) {
        this.idAccess_Avenant = idAccess_Avenant;
    }

    public List<OrclassCaracteristiques> getListeCaracteristiqueSelect() {
        return listeCaracteristiqueSelect;
    }

    public void setListeCaracteristiqueSelect(List<OrclassCaracteristiques> listeCaracteristiqueSelect) {
        this.listeCaracteristiqueSelect = listeCaracteristiqueSelect;
    }
    
    

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int hashCode() {
        int hash = 0;
        hash += (this.id != null) ? this.id.hashCode() : 0;
        return hash;
    }

    public boolean equals(Object object) {
        if (!(object instanceof Orclass_AccessAvenat_Caracteristique)) {
            return false;
        }
        Orclass_AccessAvenat_Caracteristique other = (Orclass_AccessAvenat_Caracteristique) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    public String toString() {
        return "modele.Orclass_AccessAvenat_Caracteristique[ id=" + this.id + " ]";
    }
}
