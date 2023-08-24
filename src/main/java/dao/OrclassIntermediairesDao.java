package dao;
import dao.AbstractJpaDAO;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import modele.OrclassEntreprises;
import modele.OrclassIntermediaires;
import modele.OrclassRefIntermediaire;
import modele.OrclassTypeBureau;
import modele.OrclassVille;

@Stateless

public class OrclassIntermediairesDao extends AbstractJpaDAO<OrclassIntermediaires> {
  private static final long serialVersionUID = 1L;
  
  @PersistenceContext(unitName = AbstractJpaDAO.PersistanceUnit)
    private EntityManager em;
  
  protected Class<OrclassIntermediaires> getEntityClass() {
    return OrclassIntermediaires.class;
  }
  
  protected EntityManager getEntityManager() {
    return this.em;
  }
  
  public List<OrclassIntermediaires> listeIntermediaireByEntreprise(OrclassEntreprises e) {
    Query q = this.em.createQuery("SELECT i FROM OrclassIntermediaires i WHERE i.idEntreprise.idEntreprise= :idEntreprise").setParameter("idEntreprise", e.getIdEntreprise());
    return q.getResultList();
  }
  
  public List<OrclassIntermediaires> IntermediaireByCompagnies(OrclassEntreprises e, OrclassTypeBureau tb) {
    Query q = this.em.createQuery("SELECT ap FROM OrclassIntermediaires ap WHERE ap.idEntreprise.idEntreprise= :id and ap.idTypeBureau.id= :ids").setParameter("id", e.getIdEntreprise()).setParameter("ids", tb.getId());
    return q.getResultList();
  }
  
  public OrclassIntermediaires IntermediaireByCompagnies(OrclassEntreprises e, OrclassRefIntermediaire ref, OrclassVille ville) {
    Query q = this.em.createQuery("SELECT ap FROM OrclassIntermediaires ap WHERE ap.idEntreprise.idEntreprise= :id and ap.idVille.id= :ids and ap.idRefIntermediaire= :ref").setParameter("id", e.getIdEntreprise()).setParameter("ref", ref).setParameter("ids", ville.getId());
    if (q.getResultList().isEmpty())
      return null; 
    return (OrclassIntermediaires)q.getResultList().toArray()[0];
  }
  // liste d intermediaire existance dans la quittance pendant une periode precis
   public List<OrclassIntermediaires> listeIntermediaireBYPeriode(OrclassEntreprises e, Date debut, Date fin){
       Query q;
       q=em.createQuery("SELECT DISTINCT q.idPolice.idIntermediaire FROM OrclassQuitance q WHERE q.idEntreprise.idEntreprise= :e AND q.idPolice.date_effet BETWEEN :debut and :fin and (q.idPolice.annulation=false or q.idPolice.annulation=0) and (q.idPolice.validation=1 or q.idPolice.validation=true)  "  )
               .setParameter("debut", debut)
               .setParameter("fin", fin)
               .setParameter("e", e.getIdEntreprise());
       if (q.getResultList().isEmpty()) {
           return new ArrayList<>();
       }
       return q.getResultList();
   }
   
}
