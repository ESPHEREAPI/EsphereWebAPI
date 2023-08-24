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
import modele.OrclassType_Caracteristique;

/**
 *
 * @author admin
 */
@Stateless
public class OrclassTypeCaracteristiqueDao extends AbstractJpaDAO<OrclassType_Caracteristique> {
    
    private static final long serialVersionUID = 1L;
    @PersistenceContext(unitName = AbstractJpaDAO.PersistanceUnit)
    private EntityManager em;

    @Override
    protected Class<OrclassType_Caracteristique> getEntityClass() {
       return OrclassType_Caracteristique.class;
    }

    @Override
    protected EntityManager getEntityManager() {
      return em;
    }

    public OrclassType_Caracteristique finkey(String code){
        Query q;
        
    q=em.createQuery("SELECT t From OrclassTypeCaract t where t.code= :code ")
            .setParameter("code", code);
    if(q.getResultList().isEmpty()==Boolean.TRUE){
        return null;
    }
    return (OrclassType_Caracteristique) q.getResultList().toArray()[0];
    }
}
