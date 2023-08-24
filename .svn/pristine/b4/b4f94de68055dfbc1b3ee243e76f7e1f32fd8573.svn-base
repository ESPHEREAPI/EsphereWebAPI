/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import modele.OrclassProfession;

/**
 *
 * @author hp
 */
@Stateless
public class OrclassProfessionDao extends AbstractJpaDAO<OrclassProfession>{
  private static final long serialVersionUID = 1L;
    @PersistenceContext(unitName = AbstractJpaDAO.PersistanceUnit)
    private EntityManager em;

    @Override
    protected Class<OrclassProfession> getEntityClass() {
       return OrclassProfession.class;
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
