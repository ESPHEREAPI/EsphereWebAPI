/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author JIATOU FRANCK
 */
@Entity
@Table(name = "ORCLASS_GEST_STOCK_AGEN", uniqueConstraints = @UniqueConstraint(columnNames = {"ID_ENTREPRISE", "ID_GEST_COAGEN", "DATE_EFFET", "ID_OPER_STOCK", "ID_NAT_DOC", "ID_TYPE_DOC", "ID_INTERMEDIAIRE"}))
public class OrclassGestionStockAgence implements DAOEntry {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_GEST_AGEN")
    private Long id;

    @JoinColumn(name = "ID_ENTREPRISE", referencedColumnName = "ID_ENTREPRISE")
    @ManyToOne(optional = false)
    private OrclassEntreprises idEntreprise;
    @JoinColumn(name = "ID_GEST_COAGEN", referencedColumnName = "ID_GEST_COAGEN")
    @ManyToOne(optional = false)
    private OrclassGestionCompagnieAgence idGestionCompagnieAgence;
    @JoinColumn(name = "ID_OPER_STOCK", referencedColumnName = "ID_OPER_STOCK")
    @ManyToOne(optional = false)
    private OrclassOperationStock idOperationStock;
    @JoinColumn(name = "ID_NAT_DOC", referencedColumnName = "ID_NAT_DOC")
    @ManyToOne(optional = false)
    private OrclassNatureDocument idNatureDocument;
    @JoinColumn(name = "ID_TYPE_DOC", referencedColumnName = "ID_TYPE_DOC")
    @ManyToOne(optional = false)
    OrclassTypeDocument idTypeDocument;
    @JoinColumn(name = "ID_INTERMEDIAIRE", referencedColumnName = "ID_INTERMEDIAIRE")
    @ManyToOne(optional = false)
    private OrclassIntermediaires idIntermediaire;
    BigInteger debut_serie = BigInteger.ZERO;
    BigInteger fin_serie;
    BigInteger stockInitial = BigInteger.ZERO;
    BigInteger stockEntree = BigInteger.ZERO;
    BigInteger stockSortie = BigInteger.ZERO;
    BigInteger StockFinal = BigInteger.ZERO;
    @Column(name = "DATE_EFFET")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateEffet;
    @Column(name = "DATE_MODIFICATION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateModification;
    private String saisir_par;
    private String modifier_par;
    private Boolean permission_modifier = Boolean.FALSE;

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
        if (!(object instanceof OrclassGestionStockAgence)) {
            return false;
        }
        OrclassGestionStockAgence other = (OrclassGestionStockAgence) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modele.OrclassGestionStockAgence[ id=" + id + " ]";
    }

}
