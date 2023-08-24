package dao;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import modele.OrclassEntreprises;
import modele.OrclassModules;

@Stateless
public class OrclassModulesDao extends AbstractJpaDAO<OrclassModules> {
  private static final long serialVersionUID = 1L;
  
  @PersistenceContext(unitName = "ESpherePU")
  private EntityManager em;
  
  protected Class<OrclassModules> getEntityClass() {
    return OrclassModules.class;
  }
  
  protected EntityManager getEntityManager() {
    return this.em;
  }
  
  public List<OrclassModules> listeModulesNotHaveEntreprise(OrclassEntreprises e) {
    Query q = this.em.createQuery("SELECT  m FROM OrclassModules m WHERE not exists(select me.orclassModules from OrclassEntreprisesModules me where me.orclassEntreprises= :e and me.orclassModules= m)  ").setParameter("e", e);
    return q.getResultList();
  }
  
  public List<OrclassModules> listeModulesByEntreprise(OrclassEntreprises e) {
    Query q = this.em.createQuery("SELECT me.orclassModules FROM  OrclassEntreprisesModules me WHERE me.orclassEntreprises= :e").setParameter("e", e);
    return q.getResultList();
  }
}
