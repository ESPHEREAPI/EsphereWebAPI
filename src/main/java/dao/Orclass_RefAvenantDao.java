package dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import modele.Orclass_RefAvenant;

@Stateless
public class Orclass_RefAvenantDao extends AbstractJpaDAO<Orclass_RefAvenant> {
  private static final long serialVersionUID = 1L;
  
  @PersistenceContext(unitName = "ESpherePU")
  private EntityManager em;
  
  protected Class<Orclass_RefAvenant> getEntityClass() {
    return Orclass_RefAvenant.class;
  }
  
  protected EntityManager getEntityManager() {
    return this.em;
  }
  
  public String getcodeRefAvenant() {
    Orclass_RefAvenant ref = null;
    Long code = Long.valueOf(0L);
    Query q = this.em.createQuery("SELECT r FROM Orclass_RefAvenant r WHERE r.id=(SELECT MAX(rr.id) FROM Orclass_RefAvenant rr )");
    if (q.getResultList().isEmpty())
      return "1"; 
    ref = (Orclass_RefAvenant)q.getResultList().toArray()[0];
    code = new Long("" + ref.getCode());
    code = Long.valueOf(code.longValue() + 1L);
    while (findEntityHavingValue("code", "" + code.intValue()) != null)
      code = Long.valueOf(code.longValue() + 1L); 
    return "" + code.intValue();
  }
  
  public List<String> getRefApporteurCodeWithFilters(String Filter) {
    Map<String, Object> param = new HashMap<>();
    Query q = null;
    String request = "SELECT ref.libelle FROM Orclass_RefAvenant ref  WHERE";
    if (Filter != null && !Filter.trim().equals("")) {
      request = request + " ref.libelle like :filter ";
      q = this.em.createQuery(request).setParameter("filter", "%" + Filter + "%");
    } 
    return q.getResultList();
  }
}
