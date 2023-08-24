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
import modele.OrclassAvenant;
import modele.OrclassEntreprises;
import modele.OrclassPolice;
import modele.OrclassQuitance;

/**
 *
 * @author hp
 */
@Stateless
public class OrclassQuitanceDao extends AbstractJpaDAO<OrclassQuitance>{

    private static final long serialVersionUID = 1L;
    @PersistenceContext(unitName = AbstractJpaDAO.PersistanceUnit)
    private EntityManager em;
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    protected Class<OrclassQuitance> getEntityClass() {
        return OrclassQuitance.class;
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    public OrclassQuitance quittanceByPoliceNotHaveAvenant(OrclassEntreprises e, OrclassPolice p){
        Query q;
        q=em.createQuery("SELECT q FROM OrclassQuitance q WHERE q.idEntreprise= :e and q.idPolice= :p and q.idAvenant is null").setParameter("e", e)
                .setParameter("p", p)
                ;
        if (q.getResultList().isEmpty()) {
            return null;
        }
        return (OrclassQuitance) q.getResultList().toArray()[0];
    }
    
    public OrclassQuitance quittanceForPoliceByAvenant(OrclassEntreprises e, OrclassPolice p,OrclassAvenant av){
        Query q;
        q=em.createQuery("SELECT q FROM OrclassQuitance q WHERE q.idEntreprise= :e and q.idPolice= :p and q.idAvenant= :av").setParameter("e", e)
                .setParameter("p", p)
                .setParameter("av", av)
                ;
        if (q.getResultList().isEmpty()) {
            return null;
        }
        return (OrclassQuitance) q.getResultList().toArray()[0];
    }
}
