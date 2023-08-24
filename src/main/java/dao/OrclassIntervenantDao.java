/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import modele.OrclassIntervenant;

/**
 *
 * @author JIATOU FRANCK
 */
@Stateless
public class OrclassIntervenantDao extends AbstractJpaDAO<OrclassIntervenant>{

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
     @PersistenceContext(unitName = AbstractJpaDAO.PersistanceUnit)
    private EntityManager em;

    @Override
    protected Class<OrclassIntervenant> getEntityClass() {
       return OrclassIntervenant.class;
    }

    @Override
    protected EntityManager getEntityManager() {
      return em;
    }
}
