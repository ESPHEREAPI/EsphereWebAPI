/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import modele.OrclassEntreprises;
import modele.OrclassRefGaranties;
import modele.OrclasseType_Garantie;

/**
 *
 * @author hp
 */
@Stateless
public class OrclassRefGarantiesDao extends AbstractJpaDAO<OrclassRefGaranties> {
      private static final long serialVersionUID = 1L;
    @PersistenceContext(unitName = AbstractJpaDAO.PersistanceUnit)
    private EntityManager em; 
    

    @Override
    protected Class<OrclassRefGaranties> getEntityClass() {
       return OrclassRefGaranties.class;
    }

    @Override
    protected EntityManager getEntityManager() {
       return em;
    }
               /*
    liste tous les OrclassRefGaranties visible par tous les companies
     */
    public List<OrclassRefGaranties> listAllRefGarantiesShowAllCompagnie() {
        Query q;
        q = em.createQuery("SELECT rg from OrclassRefGaranties rg WHERE rg.showAllCompagnies= :value  and rg.idEntreprise IS NULL  ")
                .setParameter("value", Boolean.TRUE);
        return q.getResultList();
    }

    /*
    lister tous les Type_Garantie pour une compagn,is precis
     */
    public List<OrclassRefGaranties> listAllRefGarantiesByCompagnie(OrclassEntreprises e) {
        Query q;
        q = em.createQuery("SELECT rg from OrclassRefGaranties rg WHERE rg.showAllCompagnies= :value  and rg.idEntreprise= :e ")
                .setParameter("value", Boolean.FALSE)
                .setParameter("e", e);
        return q.getResultList();
//        AND NOT EXISTS (select g from OrclassGarantie g where g.idRefGaranties.id=rg.id) 
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
