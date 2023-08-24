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
import modele.OrclasseType_Garantie;

/**
 *
 * @author hp
 */
@Stateless
public class OrclasseType_GarantieDao extends AbstractJpaDAO<OrclasseType_Garantie>  {
     private static final long serialVersionUID = 1L;
    @PersistenceContext(unitName = AbstractJpaDAO.PersistanceUnit)
    private EntityManager em; 
    

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    protected Class<OrclasseType_Garantie> getEntityClass() {
     return OrclasseType_Garantie.class;
    }

    @Override
    protected EntityManager getEntityManager() {
       return em;
    }
    
              /*
    liste tous les Type_Garantie visible par tous les companies
     */
    public List<OrclasseType_Garantie> listAllType_GarantieShowAllCompagnie() {
        Query q;
        q = em.createQuery("SELECT tg from OrclasseType_Garantie tg WHERE tg.showAllCompagnies= :value  and tg.idEntreprise IS NULL ")
                .setParameter("value", Boolean.TRUE);
        return q.getResultList();
    }

    /*
    lister tous les Type_Garantie pour une compagn,is precis
     */
    public List<OrclasseType_Garantie> listAllType_GarantieByCompagnie(OrclassEntreprises e) {
        Query q;
        q = em.createQuery("SELECT tg from OrclasseType_Garantie tg WHERE tg.showAllCompagnies= :value  and tg.idEntreprise= :e ")
                .setParameter("value", Boolean.FALSE)
                .setParameter("e", e);
        return q.getResultList();
    }
}
