/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.math.BigInteger;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author hp
 */
@Entity
@Table(name = "ORCLASS_REGISTRE_PRODUCTION", uniqueConstraints = @UniqueConstraint(columnNames = {"ID_ENTREPRISE", "CODE"}))
public class OrclassRegistreProduction implements DAOEntry {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_REGISTRE_PRODUCTION")
    private Long id;
    @Column(name = "CODE")
    String code;
    @Column(name = "PREFIXE")
    String prefixe;
    Integer plage_numero;
    BigInteger num_debut;
    BigInteger num_fin;
    @JoinColumn(name = "ID_ENTREPRISE", referencedColumnName = "ID_ENTREPRISE")
    @ManyToOne(optional = false)
    private OrclassEntreprises idEntreprise;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idRegistreProduction")
    private List<OrclassElt_Categorie_Compagnie> orclassElt_Categorie_CompagnieList;

    public OrclassRegistreProduction() {
        plage_numero = 0;
        num_debut = BigInteger.ZERO;
        num_fin = BigInteger.ZERO;
        idEntreprise = new OrclassEntreprises();

    }

    public OrclassRegistreProduction(String Code, String prefixe) {
        this.code = Code;
        this.prefixe = prefixe;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String Code) {
        this.code = Code;
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

    public BigInteger getNum_debut() {
        return num_debut;
    }

    public void setNum_debut(BigInteger num_debut) {
        this.num_debut = num_debut;
    }

    public BigInteger getNum_fin() {
        return num_fin;
    }

    public void setNum_fin(BigInteger num_fin) {
        this.num_fin = num_fin;
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

    public List<OrclassElt_Categorie_Compagnie> getOrclassElt_Categorie_CompagnieList() {
        return orclassElt_Categorie_CompagnieList;
    }

    public void setOrclassElt_Categorie_CompagnieList(List<OrclassElt_Categorie_Compagnie> orclassElt_Categorie_CompagnieList) {
        this.orclassElt_Categorie_CompagnieList = orclassElt_Categorie_CompagnieList;
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
        if (!(object instanceof OrclassRegistreProduction)) {
            return false;
        }
        OrclassRegistreProduction other = (OrclassRegistreProduction) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modele.Registre[ id=" + id + " ]";
    }

}
