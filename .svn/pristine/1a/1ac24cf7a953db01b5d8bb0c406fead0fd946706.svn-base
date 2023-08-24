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
import modele.OrclassText;

/**
 *
 * @author hp
 */
@Stateless
public class OrclassTextDao extends AbstractJpaDAO<OrclassText> {

    private static final long serialVersionUID = 1L;
    @PersistenceContext(unitName = AbstractJpaDAO.PersistanceUnit)
    private EntityManager em;

    @Override
    protected Class<OrclassText> getEntityClass() {
        return OrclassText.class;
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;

        // Add business logic below. (Right-click in editor and choose
        // "Insert Code > Add Business Method")
    }
    
    
}
