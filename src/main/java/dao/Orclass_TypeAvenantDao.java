package dao;

import enums.NatureAvenant;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import modele.OrclassEntreprises;
import modele.Orclass_RefAvenant;
import modele.Orclass_TypeAvenant;

@Stateless
public class Orclass_TypeAvenantDao extends AbstractJpaDAO<Orclass_TypeAvenant> {
  private static final long serialVersionUID = 1L;
  
  @PersistenceContext(unitName = "ESpherePU")
  private EntityManager em;
  
  protected Class<Orclass_TypeAvenant> getEntityClass() {
    return Orclass_TypeAvenant.class;
  }
  
  protected EntityManager getEntityManager() {
    return this.em;
  }
  
  public Orclass_TypeAvenant finKey(OrclassEntreprises e, Orclass_RefAvenant ref, NatureAvenant nav) {
    Query q = this.em.createQuery("SELECT tav FROM Orclass_TypeAvenant tav WHERE tav.idEntreprise= :e  and tav.idRefAvenant= :ref and tav.natureAvenant= :nav ").setParameter("e", e).setParameter("ref", ref).setParameter("nav", nav);
    if (q.getResultList().isEmpty())
      return null; 
    return (Orclass_TypeAvenant)q.getResultList().toArray()[0];
  }
  
  public List<Orclass_TypeAvenant> listeTypeAvenantByCompagnie(OrclassEntreprises e) {
    Query q = this.em.createQuery("SELECT t FROM Orclass_TypeAvenant t WHERE t.idEntreprise= :e").setParameter("e", e);
    return q.getResultList();
  }
}
