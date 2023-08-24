package dao;

import enums.ClasseObjet;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import modele.OrclassBranches;
import modele.OrclassCaracteristiques;
import modele.OrclassEntreprises;
import modele.OrclassIntermediaires;
import modele.Orclass_Access_Avenant;
import modele.Orclass_Objet;
import modele.Orclass_RefAvenant;
import modele.Orclass_TypeAvenant;

@Stateless
public class Orclass_ObjetDao extends AbstractJpaDAO<Orclass_Objet> {
  @PersistenceContext(unitName = "ESpherePU")
  private EntityManager em;
  
  protected Class<Orclass_Objet> getEntityClass() {
    return Orclass_Objet.class;
  }
  
  protected EntityManager getEntityManager() {
    return this.em;
  }
  
  public Orclass_Objet finKey( ClasseObjet objet, OrclassBranches br) {
    Query q = this.em.createQuery("SELECT c FROM  Orclass_Objet c WHERE c.classeObjet= :objet and  c.idBranche= :branche").setParameter("branche", br).setParameter("objet", objet);
    if (q.getResultList().isEmpty())
      return null; 
    return (Orclass_Objet)q.getResultList().toArray()[0];
  }
  
    public String getcodeObjet() {
    Orclass_Objet ref = null;
    Long code = Long.valueOf(0L);
    Query q = this.em.createQuery("SELECT o FROM Orclass_Objet o WHERE o.id=(SELECT MAX(ob.id) FROM Orclass_Objet ob )");
    if (q.getResultList().isEmpty())
      return "1"; 
    ref = (Orclass_Objet)q.getResultList().toArray()[0];
    code = new Long("" + ref.getCode());
    code = Long.valueOf(code.longValue() + 1L);
    while (findEntityHavingValue("code", "" + code.intValue()) != null)
      code = Long.valueOf(code.longValue() + 1L); 
    return "" + code.intValue();
  }
    
   /*
      liste les caracteristique d objet n ayant pas ete affecter a un avenant
     */
    public List<Orclass_Objet> listObjetNotHaveAccessCompagnie(OrclassEntreprises e, Orclass_TypeAvenant typeAvenant,OrclassBranches br) {
        Query q;
        q = em.createQuery("SELECT  c FROM Orclass_Objet c WHERE  NOT EXISTS (SELECT acc.idObjet FROM Orclass_Access_Avenant  acc where acc.idEntreprises.idEntreprise= :idEntreprise and acc.idBranche= :br and acc.idTypeAvenant= :ta)")
                .setParameter("idEntreprise", e.getIdEntreprise())
                .setParameter("br", br)
                .setParameter("ta", typeAvenant)
                ;

        return q.getResultList();
    }  
    
}
