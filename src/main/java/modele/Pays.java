package modele;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author fabrice
 */
@Entity
@Table(name = "orclass_pays")
@NamedQueries({
    @NamedQuery(name = Pays.FIND_ALL, query = "SELECT p FROM Pays p")
    ,
    @NamedQuery(name = Pays.FIND_BY_CODE, query = "SELECT p FROM Pays p WHERE p.code = :code")
    ,
    @NamedQuery(name = Pays.FIND_BY_LIBELLE, query = "SELECT p FROM Pays p WHERE p.libelle = :libelle")
    ,
    @NamedQuery(name = Pays.FIND_BY_LIBELLE_ANGLAIS, query = "SELECT p FROM Pays p WHERE p.libelleAnglais = :libelleAnglais")
    ,
    @NamedQuery(name = Pays.FIND_BY_CONTINENT, query = "SELECT p FROM Pays p WHERE p.continent = :continent")})
public class Pays implements DAOEntry {

    public static final String FIND_ALL = "Pays.findAll";
    public static final String FIND_BY_CODE = "Pays.findByCode";
    public static final String FIND_BY_LIBELLE = "Pays.findByLibelle";
    public static final String FIND_BY_LIBELLE_ANGLAIS = "Pays.findByLibelleAnglais";
    public static final String FIND_BY_CONTINENT = "Pays.Continent";
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id")
    private Long id;

    @Size(max = 50)
    @Column(name = "Code", unique = true, nullable = false)
    private String code;
    @Size(max = 255)
    @Column(name = "Libelle")
    private String libelle;
    @Size(max = 255)
    @Column(name = "LibelleAnglais")
    private String libelleAnglais;
    @Size(max = 50)
    @Column(name = "Continent")
    private String continent;
     @OneToMany(cascade = CascadeType.ALL, mappedBy = "codePays")
    private List<OrclassEntreprises> orclassEntreprisesList;

    public Pays() {
    }

    public Pays(String code) {
        this.code = code;
    }

    public Pays(String code, String libelle, String libelleAnglais, String continent) {
        this.code = code;
        this.libelle = libelle;
        this.libelleAnglais = libelleAnglais;
        this.continent = continent;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getLibelleAnglais() {
        return libelleAnglais;
    }

    public void setLibelleAnglais(String libelleAnglais) {
        this.libelleAnglais = libelleAnglais;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public List<OrclassEntreprises> getOrclassEntreprisesList() {
        return orclassEntreprisesList;
    }

    public void setOrclassEntreprisesList(List<OrclassEntreprises> orclassEntreprisesList) {
        this.orclassEntreprisesList = orclassEntreprisesList;
    }

    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (code != null ? code.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pays)) {
            return false;
        }
        Pays other = (Pays) object;
        if ((this.code == null && other.code != null) || (this.code != null && !this.code.equals(other.code))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.better.modele.Pays[ code=" + code + " ]";
    }

}
