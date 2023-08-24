package modele;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "ORCLASS_REF_AVENANT")
public class Orclass_RefAvenant implements DAOEntry {
  private static final long serialVersionUID = 1L;
  
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @NotNull
  @Column(name = "ID_REF_AVENANT")
  private Long id;
  
  private String code;
  
  private String libelle;
  
  public Orclass_RefAvenant() {}
  
  public Orclass_RefAvenant(String code) {
    this.code = code;
  }
  
  public String getCode() {
    return this.code;
  }
  
  public void setCode(String code) {
    this.code = code;
  }
  
  public String getLibelle() {
    return this.libelle;
  }
  
  public void setLibelle(String libelle) {
    this.libelle = libelle;
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
    if (!(object instanceof Orclass_RefAvenant))
      return false; 
    Orclass_RefAvenant other = (Orclass_RefAvenant)object;
    if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)))
      return false; 
    return true;
  }
  
  public String toString() {
    return "modele.Orclass_RefAvenant[ id=" + this.id + " ]";
  }
}
