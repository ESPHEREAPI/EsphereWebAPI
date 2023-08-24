/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

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
import javax.validation.constraints.NotNull;

/**
 *
 * @author JIATOU FRANCK
 */
@Entity
@Table(name = "ORCLASS_DOC_CATEGORIES", uniqueConstraints = @UniqueConstraint(columnNames = {"ID_ENTREPRISE", "ID_CATEGORIE", "DATE_EFFET", "ID_TYPE_DOC", "ID_NAT_DOC"}))
public class OrclassDocumentCategories implements DAOEntry {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    @Column(name = "ID_DOC_CAT")
    private Long id;

    @JoinColumn(name = "ID_ENTREPRISE", referencedColumnName = "ID_ENTREPRISE")
    @ManyToOne(optional = false)
    private OrclassEntreprises idEntreprises;
    @JoinColumn(name = "ID_CATEGORIE", referencedColumnName = "ID_CATEGORIE")
    @ManyToOne(optional = false)
    private OrclassCategories idCategories;
    @JoinColumn(name = "ID_TYPE_DOC", referencedColumnName = "ID_TYPE_DOC")
    @ManyToOne(optional = false)
    OrclassTypeDocument typeDocument;
    @JoinColumn(name = "ID_NAT_DOC", referencedColumnName = "ID_NAT_DOC")
    @ManyToOne(optional = false)
    private OrclassNatureDocument natureDocuments;
    @Column(name = "DATE_EFFET")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date_effet;
    private Boolean stockLogique;
    private Boolean stockPapier;
    @Column(name = "DATE_CREATION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreation;
    @Column(name = "DATE_MODIFICATION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateModification;
    private String saisir_par;
    private String modifier_par;

    public OrclassDocumentCategories() {
        idCategories = new OrclassCategories();
        typeDocument = new OrclassTypeDocument();
        natureDocuments = new OrclassNatureDocument();
    }

    public OrclassEntreprises getIdEntreprises() {
        return idEntreprises;
    }

    public void setIdEntreprises(OrclassEntreprises idEntreprises) {
        this.idEntreprises = idEntreprises;
    }

    public OrclassCategories getIdCategories() {
        return idCategories;
    }

    public void setIdCategories(OrclassCategories idCategories) {
        this.idCategories = idCategories;
    }

    public Date getDate_effet() {
        return date_effet;
    }

    public void setDate_effet(Date date_effet) {
        this.date_effet = date_effet;
    }

    public OrclassTypeDocument getTypeDocument() {
        return typeDocument;
    }

    public void setTypeDocument(OrclassTypeDocument typeDocument) {
        this.typeDocument = typeDocument;
    }

    public OrclassNatureDocument getNatureDocuments() {
        return natureDocuments;
    }

    public void setNatureDocuments(OrclassNatureDocument natureDocuments) {
        this.natureDocuments = natureDocuments;
    }

    public Boolean getStockLogique() {
        return stockLogique;
    }

    public void setStockLogique(Boolean stockLogique) {
        this.stockLogique = stockLogique;
    }

    public Boolean getStockPapier() {
        return stockPapier;
    }

    public void setStockPapier(Boolean stockPapier) {
        this.stockPapier = stockPapier;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
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
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrclassDocumentCategories)) {
            return false;
        }
        OrclassDocumentCategories other = (OrclassDocumentCategories) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modele.OrclassDocumentCategories[ id=" + id + " ]";
    }

}
