/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

/**
 *
 * @author fabrice
 */
@Entity
@Table(name = "orclass_religion")
@NamedQueries({
    @NamedQuery(name = Religion.FIND_ALL, query = "SELECT r FROM Religion r"),
   @NamedQuery(name = Religion.FIND_BY_CODE, query = "SELECT r FROM Religion r WHERE r.code = :code")
})
public class Religion implements DAOEntry {
    public static final String FIND_ALL="Religion.findAll";
    public static final String FIND_BY_CODE="Religion.findByCode";
    private static final long serialVersionUID = 1L;
   
    @Id @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "Id")
    private Long id;
     
    @Size(max = 50)     @Column(name = "Code",unique=true,nullable=false)
    private String code;
    @Size(max = 255)
    @Column(name = "Notes")
    private String notes;
    @Column(name = "DateEnregistrement")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateEnregistrement;
    @OneToMany( mappedBy = "codeReligion")
    private Collection<Personne> personneCollection;

    public Religion() {
    }

    public Religion(String code, String notes, Date dateEnregistrement) {
        this.code = code;
        this.notes = notes;
        this.dateEnregistrement = dateEnregistrement;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Religion(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Date getDateEnregistrement() {
        return dateEnregistrement;
    }

    public void setDateEnregistrement(Date dateEnregistrement) {
        this.dateEnregistrement = dateEnregistrement;
    }

    public Collection<Personne> getPersonneCollection() {
        return personneCollection;
    }

    public void setPersonneCollection(Collection<Personne> personneCollection) {
        this.personneCollection = personneCollection;
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
        if (!(object instanceof Religion)) {
            return false;
        }
        Religion other = (Religion) object;
        if ((this.code == null && other.code != null) || (this.code != null && !this.code.equals(other.code))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.better.modele.Religion[ code=" + code + " ]";
    }
    
}
