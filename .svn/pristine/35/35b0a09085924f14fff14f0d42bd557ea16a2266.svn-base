/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package dao;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import modele.OrclassCaracteristiqueSinistreMaladie;
import modele.OrclassEntreprises;
import modele.OrclassIntervenant;
import modele.OrclassIntervenantSinistreMaladie;
import modele.OrclassSinistreMaladie;

/**
 *
 * @author JIATOU FRANCK
 */
@Stateless
public class OrclassIntervenantSinistreMaladieDao extends AbstractJpaDAO<OrclassIntervenantSinistreMaladie>{

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    @PersistenceContext(unitName = AbstractJpaDAO.PersistanceUnit)
    private EntityManager em;

    @Override
    protected Class<OrclassIntervenantSinistreMaladie> getEntityClass() {
     return OrclassIntervenantSinistreMaladie.class;
    }

    @Override
    protected EntityManager getEntityManager() {
        
     return em;
    }
    
      public List<OrclassIntervenantSinistreMaladie> listIntervenantsBySinistreMaladie(OrclassEntreprises e,OrclassSinistreMaladie sinMad){
        Query q;
        q=em.createQuery("SELECT si FROM OrclassIntervenantSinistreMaladie si WHERE si.idEntreprise= :e and si.idSinistreMaladie= :sinmad")
                .setParameter("e", e)
                .setParameter("sinmad", sinMad)
                ;
        return q.getResultList();
    }
      public OrclassIntervenantSinistreMaladie intervenantsBySinistreMaladie(OrclassEntreprises e,OrclassSinistreMaladie sinMad,OrclassIntervenant intv){
        Query q;
        q=em.createQuery("SELECT si FROM OrclassIntervenantSinistreMaladie si WHERE si.idEntreprise= :e and si.idSinistreMaladie= :sinmad and si.idIntervenant.id= :idintv")
                .setParameter("e", e)
                .setParameter("sinmad", sinMad)
                .setParameter("idintv", intv.getId())
                ;
          if (q.getResultList().isEmpty()) {
              return null;
          }
        return (OrclassIntervenantSinistreMaladie) q.getResultList().toArray()[0];
    }
}
