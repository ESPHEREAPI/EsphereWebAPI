/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import modele.OrclassActivite;

/**
 *
 * @author hp
 */
@Stateless
public class OrclassActiviteDao extends AbstractJpaDAO<OrclassActivite> {

    private static final long serialVersionUID = 1L;
    @PersistenceContext(unitName = AbstractJpaDAO.PersistanceUnit)
    private EntityManager em;

    @Override
    protected Class<OrclassActivite> getEntityClass() {
        return OrclassActivite.class;
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
