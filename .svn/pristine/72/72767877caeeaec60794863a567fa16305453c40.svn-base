package modele;

import enums.ClasseObjet;
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
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "ORCLASS_OBJET", uniqueConstraints = {@UniqueConstraint(columnNames = { "ID_BRANCHE", "CLASSE_OBJET"})})
public class Orclass_Objet implements DAOEntry {
  private static final long serialVersionUID = 1L;
  
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "ID_OBJET")
  private Long id;
  
    @JoinColumn(name = "ID_BRANCHE", referencedColumnName = "ID_BRANCHE")
    @ManyToOne(optional = false)
    private OrclassBranches idBranche;
  
  @JoinColumn(name = "ID_ENTREPRISE", referencedColumnName = "ID_ENTREPRISE")
  @ManyToOne(optional = true)
  private OrclassEntreprises idEntreprises;
  
  @Column(name = "CODE")
  private String code;
  
  @Column(name = "LIBELLE")
  private String LIBELLE;
  
  @Column(name = "CLASSE_OBJET")
  @Enumerated(EnumType.STRING)
  private ClasseObjet classeObjet;

    public OrclassBranches getIdBranche() {
        return idBranche;
    }

    public void setIdBranche(OrclassBranches idBranche) {
        this.idBranche = idBranche;
    }
  

  public OrclassEntreprises getIdEntreprises() {
    return this.idEntreprises;
  }
  
  public void setIdEntreprises(OrclassEntreprises idEntreprises) {
    this.idEntreprises = idEntreprises;
  }
  
  public String getCode() {
    return this.code;
  }
  
  public void setCode(String code) {
    this.code = code;
  }
  
  public String getLIBELLE() {
    return this.LIBELLE;
  }
  
  public void setLIBELLE(String LIBELLE) {
    this.LIBELLE = LIBELLE;
  }
  
  public ClasseObjet getClasseObjet() {
    return this.classeObjet;
  }
  
  public void setClasseObjet(ClasseObjet classeObjet) {
    this.classeObjet = classeObjet;
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
    if (!(object instanceof Orclass_Objet))
      return false; 
    Orclass_Objet other = (Orclass_Objet)object;
    if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)))
      return false; 
    return true;
  }
  
  public String toString() {
    return "modele.Orclass_Objet[ id=" + this.id + " ]";
  }
}
