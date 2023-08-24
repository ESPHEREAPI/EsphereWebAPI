/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import modele.OrclassUnite_Caracteristique;

/**
 *
 * @author hp
 */
@Stateless
public class OrclassUnite_CaracteristiqueDao extends AbstractJpaDAO<OrclassUnite_Caracteristique> {
   private static final long serialVersionUID = 1L;
    @PersistenceContext(unitName = AbstractJpaDAO.PersistanceUnit)
    private EntityManager em;
    @Override
    protected Class<OrclassUnite_Caracteristique> getEntityClass() {
        return OrclassUnite_Caracteristique.class;
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
