/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import enums.Entite_Emmettrice;
import java.math.BigInteger;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

/**
 *
 * @author JIATOU FRANCK
 */
@Entity
@Table(name = "ORCLASS_GEST_STOCK", uniqueConstraints = @UniqueConstraint(columnNames = {"ID_ENTREPRISE", "DATE_EFFET", "ID_OPER_STOCK", "ID_NAT_DOC", "ID_TYPE_DOC"}))
public class OrclassGestionStockCompagnie implements DAOEntry {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    @Column(name = "ID_GEST_STOCK")
    private Long id;
    @JoinColumn(name = "ID_ENTREPRISE", referencedColumnName = "ID_ENTREPRISE")
    @ManyToOne(optional = false)
    private OrclassEntreprises idEntreprise;
    @JoinColumn(name = "ID_OPER_STOCK", referencedColumnName = "ID_OPER_STOCK")
    @ManyToOne(optional = false)
    private OrclassOperationStock idOperationStock;
    @JoinColumn(name = "ID_NAT_DOC", referencedColumnName = "ID_NAT_DOC")
    @ManyToOne(optional = false)
    private OrclassNatureDocument idNatureDocument;
     @JoinColumn(name = "ID_TYPE_DOC", referencedColumnName = "ID_TYPE_DOC")
    @ManyToOne(optional = false)
    OrclassTypeDocument idTypeDocument;
    @Column(name = "ENTITE_EMETTRICE")
    @Enumerated(EnumType.STRING)
    private Entite_Emmettrice entite_Emmettrice;
    BigInteger debut_serie = BigInteger.ZERO;
    BigInteger fin_serie;
    BigInteger stockInitial = BigInteger.ZERO;
    BigInteger stockEntree = BigInteger.ZERO;
    BigInteger stockSortie=BigInteger.ZERO;
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

    public OrclassGestionStockCompagnie() {
        idNatureDocument=new OrclassNatureDocument();
        idOperationStock= new OrclassOperationStock();
        idTypeDocument=new OrclassTypeDocument();
    }

    public OrclassEntreprises getIdEntreprise() {
        return idEntreprise;
    }

    public void setIdEntreprise(OrclassEntreprises idEntreprise) {
        this.idEntreprise = idEntreprise;
    }

    public OrclassOperationStock getIdOperationStock() {
        return idOperationStock;
    }

    public void setIdOperationStock(OrclassOperationStock idOperationStock) {
        this.idOperationStock = idOperationStock;
    }

    public OrclassNatureDocument getIdNatureDocument() {
        return idNatureDocument;
    }

    public void setIdNatureDocument(OrclassNatureDocument idNatureDocument) {
        this.idNatureDocument = idNatureDocument;
    }

    public OrclassTypeDocument getIdTypeDocument() {
        return idTypeDocument;
    }

    public void setIdTypeDocument(OrclassTypeDocument idTypeDocument) {
        this.idTypeDocument = idTypeDocument;
    }

    public Entite_Emmettrice getEntite_Emmettrice() {
        return entite_Emmettrice;
    }

    public void setEntite_Emmettrice(Entite_Emmettrice entite_Emmettrice) {
        this.entite_Emmettrice = entite_Emmettrice;
    }

    public BigInteger getDebut_serie() {
        return debut_serie;
    }

    public void setDebut_serie(BigInteger debut_serie) {
        this.debut_serie = debut_serie;
    }

    public BigInteger getFin_serie() {
        return fin_serie;
    }

    public void setFin_serie(BigInteger fin_serie) {
        this.fin_serie = fin_serie;
    }

    public BigInteger getStockInitial() {
        return stockInitial;
    }

    public void setStockInitial(BigInteger stockInitial) {
        this.stockInitial = stockInitial;
    }

    public BigInteger getStockEntree() {
        return stockEntree;
    }

    public void setStockEntree(BigInteger stockEntree) {
        this.stockEntree = stockEntree;
    }

    public BigInteger getStockSortie() {
        return stockSortie;
    }

    public void setStockSortie(BigInteger stockSortie) {
        this.stockSortie = stockSortie;
    }

    public BigInteger getStockFinal() {
        return StockFinal;
    }

    public void setStockFinal(BigInteger StockFinal) {
        this.StockFinal = StockFinal;
    }

    public Date getDateEffet() {
        return dateEffet;
    }

    public void setDateEffet(Date dateEffet) {
        this.dateEffet = dateEffet;
    }

    public Date getDateModification() {
        return dateModification;
    }

    public void setDateModification(Date dateModification) {
        this.dateModification = dateModification;
    }

    public String getSaisir_par() {
        return saisir_par;
    }

    public void setSaisir_par(String saisir_par) {
        this.saisir_par = saisir_par;
    }

    public String getModifier_par() {
        return modifier_par;
    }

    public void setModifier_par(String modifier_par) {
        this.modifier_par = modifier_par;
    }

    public Boolean getPermission_modifier() {
        return permission_modifier;
    }

    public void setPermission_modifier(Boolean permission_modifier) {
        this.permission_modifier = permission_modifier;
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
        if (!(object instanceof OrclassGestionStockCompagnie)) {
            return false;
        }
        OrclassGestionStockCompagnie other = (OrclassGestionStockCompagnie) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modele.OrclassGestionStockCompagnie[ id=" + id + " ]";
    }

}
