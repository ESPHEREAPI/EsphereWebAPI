/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import modele.OrclassSousUsageTPV;

/**
 *
 * @author JIATOU FRANCK
 */
@Stateless
public class OrclassSousUsageTPVDao extends AbstractJpaDAO<OrclassSousUsageTPV>{
  @PersistenceContext(unitName = AbstractJpaDAO.PersistanceUnit)
    private EntityManager em;
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    protected Class<OrclassSousUsageTPV> getEntityClass() {
       return OrclassSousUsageTPV.class;
    }

    @Override
    protected EntityManager getEntityManager() {
      return em;
    }
    
}
