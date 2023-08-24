/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import modele.OrclassRegimeTaxe;
import modele.OrclassTypeTaxe;

/**
 *
 * @author JIATOU FRANCK
 */
@Stateless
public class OrclassRegimeTaxeDao  extends AbstractJpaDAO<OrclassRegimeTaxe>{
     @PersistenceContext(unitName = AbstractJpaDAO.PersistanceUnit)
    private EntityManager em;

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    protected Class<OrclassRegimeTaxe> getEntityClass() {
       return OrclassRegimeTaxe.class;
    }

    @Override
    protected EntityManager getEntityManager() {
     return em;
    }
    
      public OrclassRegimeTaxe finKey(String code, String libelle) {
        Query q;
        q = em.createQuery("SELECT r FROM OrclassRegimeTaxe r WHERE r.code= :code or r.libelle= :libelle")
                .setParameter("code", code)
                .setParameter("libelle", libelle);
        if (q.getResultList().isEmpty()) {
            return null;
        }
        return (OrclassRegimeTaxe) q.getResultList().toArray()[0];
    }
}
