/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import modele.OrclassEvenement;

/**
 *
 * @author JIATOU FRANCK
 */
@Stateless
public class OrclassEvenementDao extends AbstractJpaDAO<OrclassEvenement>{

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
     private static final long serialVersionUID = 1L;
  
  @PersistenceContext(unitName = AbstractJpaDAO.PersistanceUnit)
    private EntityManager em;

    @Override
    protected Class<OrclassEvenement> getEntityClass() {
        return OrclassEvenement.class;
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
}
