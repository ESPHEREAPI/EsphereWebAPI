/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import enums.CategorieDocument;
import enums.GenreDocument;
import enums.NiveauGestionDocument;
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

/**
 *
 * @author JIATOU FRANCK
 */
@Entity
@Table(name = "ORCLASS_TYPE_DOC")
public class OrclassTypeDocument implements DAOEntry {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_TYPE_DOC")
    private Long id;
    @Column(name = "CODE", unique = true)
    private String code;
    @Column(name = "LIBELLE", unique = true)
    private String libelle;
    @Column(name = "CATEGORIE_DOC")
    @Enumerated(EnumType.STRING)
    private CategorieDocument categorieDocument;
    @Column(name = "NIVEAU_GEST_DOC")
    @Enumerated(EnumType.STRING)
    private NiveauGestionDocument niveauGestionDocument;
    @Column(name = "GGENRE_DOC")
    @Enumerated(EnumType.STRING)
    private GenreDocument genreDocument;
    private Boolean stockPapier = Boolean.FALSE;
    private Boolean doc_remorque = Boolean.FALSE;
    private Boolean allBranches = Boolean.FALSE;
    @JoinColumn(name = "ID_BRANCHE", referencedColumnName = "ID_BRANCHE")
    @ManyToOne(optional = true)
    private OrclassBranches idBranche;

    public OrclassTypeDocument(String code, String libelle) {
        this.code = code;
        this.libelle = libelle;
    }

    public OrclassTypeDocument() {
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

    public CategorieDocument getCategorieDocument() {
        return categorieDocument;
    }

    public void setCategorieDocument(CategorieDocument categorieDocument) {
        this.categorieDocument = categorieDocument;
    }

    public NiveauGestionDocument getNiveauGestionDocument() {
        return niveauGestionDocument;
    }

    public void setNiveauGestionDocument(NiveauGestionDocument niveauGestionDocument) {
        this.niveauGestionDocument = niveauGestionDocument;
    }

    public GenreDocument getGenreDocument() {
        return genreDocument;
    }

    public void setGenreDocument(GenreDocument genreDocument) {
        this.genreDocument = genreDocument;
    }

    public Boolean getStockPapier() {
        return stockPapier;
    }

    public void setStockPapier(Boolean stockPapier) {
        this.stockPapier = stockPapier;
    }

    public Boolean getDoc_remorque() {
        return doc_remorque;
    }

    public void setDoc_remorque(Boolean doc_remorque) {
        this.doc_remorque = doc_remorque;
    }

    public OrclassBranches getIdBranche() {
        return idBranche;
    }

    public void setIdBranche(OrclassBranches idBranche) {
        this.idBranche = idBranche;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getAllBranches() {
        return allBranches;
    }

    public void setAllBranches(Boolean allBranches) {
        this.allBranches = allBranches;
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
        if (!(object instanceof OrclassTypeDocument)) {
            return false;
        }
        OrclassTypeDocument other = (OrclassTypeDocument) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modele.OrclassTypeDocument[ id=" + id + " ]";
    }

}
