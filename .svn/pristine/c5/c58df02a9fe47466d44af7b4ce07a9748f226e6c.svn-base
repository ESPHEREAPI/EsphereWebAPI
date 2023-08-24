package modele;

import enums.Contrat;
import enums.GenreAvenant;
import enums.NatureAvenant;
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

@Entity
@Table(name = "ORCLASS_TYPE_AVENANT", uniqueConstraints = {@UniqueConstraint(columnNames = {"ID_ENTREPRISE", "ID_REF_AVENANT", "NATURE", "GENRE"})})
public class Orclass_TypeAvenant implements DAOEntry {
  private static final long serialVersionUID = 1L;
  
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "ID_TYPE_AVENANT")
  private Long id;
  
  @Column(name = "DATE_CREATION")
  @Temporal(TemporalType.TIMESTAMP)
  private Date dateCreation;
  
  @Column(name = "DATE_MODIFICATION")
  @Temporal(TemporalType.TIMESTAMP)
  private Date dateModification;
  
  @JoinColumn(name = "ID_REF_AVENANT", referencedColumnName = "ID_REF_AVENANT")
  @ManyToOne(optional = false)
  private Orclass_RefAvenant idRefAvenant;
  
  @JoinColumn(name = "ID_ENTREPRISE", referencedColumnName = "ID_ENTREPRISE")
  @ManyToOne(optional = false)
  private OrclassEntreprises idEntreprise;
  
  @Enumerated(EnumType.STRING)
  @Column(name = "NATURE")
  private NatureAvenant natureAvenant;
  
  @Enumerated(EnumType.STRING)
  @Column(name = "GENRE")
  private GenreAvenant genreAvenant;
  
  @Enumerated(EnumType.STRING)
  @Column(name = "CONTRAT")
  private Contrat contrat;
  
  public Date getDateCreation() {
    return this.dateCreation;
  }
  
  public void setDateCreation(Date dateCreation) {
    this.dateCreation = dateCreation;
  }
  
  public Date getDateModification() {
    return this.dateModification;
  }
  
  public void setDateModification(Date dateModification) {
    this.dateModification = dateModification;
  }
  
  public Orclass_RefAvenant getIdRefAvenant() {
    return this.idRefAvenant;
  }
  
  public void setIdRefAvenant(Orclass_RefAvenant idRefAvenant) {
    this.idRefAvenant = idRefAvenant;
  }
  
  public OrclassEntreprises getIdEntreprise() {
    return this.idEntreprise;
  }
  
  public void setIdEntreprise(OrclassEntreprises idEntreprise) {
    this.idEntreprise = idEntreprise;
  }
  
  public NatureAvenant getNatureAvenant() {
    return this.natureAvenant;
  }
  
  public void setNatureAvenant(NatureAvenant natureAvenant) {
    this.natureAvenant = natureAvenant;
  }
  
  public GenreAvenant getGenreAvenant() {
    return this.genreAvenant;
  }
  
  public void setGenreAvenant(GenreAvenant genreAvenant) {
    this.genreAvenant = genreAvenant;
  }
  
  public Contrat getContrat() {
    return this.contrat;
  }
  
  public void setContrat(Contrat contrat) {
    this.contrat = contrat;
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
    if (!(object instanceof Orclass_TypeAvenant))
      return false; 
    Orclass_TypeAvenant other = (Orclass_TypeAvenant)object;
    if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)))
      return false; 
    return true;
  }
  
  public String toString() {
    return "modele.Orclass_TypeAvenant[ id=" + this.id + " ]";
  }
}
