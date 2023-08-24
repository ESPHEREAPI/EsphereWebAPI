package dao;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import modele.OrclassEntreprises;
import modele.OrclassPlafondMaladie;

@Stateless
public class OrclassPlafondMaladieDao extends AbstractJpaDAO<OrclassPlafondMaladie> {
  private static final long serialVersionUID = 1L;
  
  @PersistenceContext(unitName = "ESpherePU")
  private EntityManager em;
  
  protected Class<OrclassPlafondMaladie> getEntityClass() {
    return OrclassPlafondMaladie.class;
  }
  
  protected EntityManager getEntityManager() {
    return this.em;
  }
  
  public OrclassPlafondMaladie finkey(String code, OrclassEntreprises e) {
    Query q = this.em.createQuery("SELECT pm FROM OrclassPlafondMaladie pm WHERE pm.code= :code and pm.idEntreprise.idEntreprise= :idEntreprise").setParameter("code", code).setParameter("idEntreprise", e.getIdEntreprise());
    if (q.getResultList().isEmpty())
      return null; 
    return (OrclassPlafondMaladie)q.getResultList().toArray()[0];
  }
  
  public List<OrclassPlafondMaladie> listePlafondMaladie(OrclassEntreprises e) {
    Query q = this.em.createQuery("SELECT pm FROM OrclassPlafondMaladie pm WHERE pm.idEntreprise.idEntreprise= :idEntreprise").setParameter("idEntreprise", e.getIdEntreprise());
    return q.getResultList();
  }
}
