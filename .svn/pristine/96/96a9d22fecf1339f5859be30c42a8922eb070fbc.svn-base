/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import modele.OrclassCategories;
import modele.OrclassEntreprises;
import modele.OrclassGarantie;
import modele.OrclassReduction;
import modele.OrclassRefReduction;

/**
 *
 * @author hp
 */
@Stateless
public class OrclassReductionDao extends AbstractJpaDAO<OrclassReduction> {

    private static final long serialVersionUID = 1L;
    @PersistenceContext(unitName = AbstractJpaDAO.PersistanceUnit)
    private EntityManager em;

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @Override
    protected Class<OrclassReduction> getEntityClass() {
        return OrclassReduction.class;
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public OrclassReduction finKey(OrclassEntreprises e, OrclassRefReduction rd, Date effet, OrclassGarantie g) {
        Query q;
        q = em.createQuery("SELECT r from  OrclassReduction r WHERE r.idRefReduction= :rfd and r.dateEffet= :effet and r.idGarantie= :g ")
                .setParameter("rfd", rd)
                .setParameter("effet", effet)
                .setParameter("g", g);
        if (q.getResultList().isEmpty()) {
            return null;
        }
        return (OrclassReduction) q.getResultList().toArray()[0];
    }

    // lister les reductions d une compagnie
    public List<OrclassReduction> listeReductionByCompagnie(OrclassEntreprises e) {
        Query q;
        q = em.createQuery("SELECT r FROM OrclassReduction r where r.idEntreprise= :e ")
                .setParameter("e", e);
        return q.getResultList();

    }
     public List<OrclassReduction> listeReductionByCompagnie(OrclassEntreprises e,OrclassRefReduction ref) {
        Query q;
        q = em.createQuery("SELECT r FROM OrclassReduction r where r.idEntreprise= :e  and r.idRefReduction= :r")
                .setParameter("e", e)
                .setParameter("r", ref);
        return q.getResultList();

    }
        public List<OrclassReduction> listeReductionByCompagnieForCategorie(OrclassEntreprises e,OrclassCategories cat) {
        Query q;
        q = em.createQuery("SELECT r FROM OrclassReduction r where r.idEntreprise= :e  and r.idGarantie.idCategories= :cat")
                .setParameter("e", e)
                .setParameter("cat", cat);
        return q.getResultList();

    }
     public Boolean reductionUseForPolice(OrclassEntreprises e,OrclassReduction red){
         Query q;
         q=em.createQuery("SELECT p FROM OrclassPolice p where p.idEntreprises= :e and p.idReduction= :r ")
                 .setParameter("r", red)
                 .setParameter("e", e);
         if (q.getResultList().isEmpty()) {
             return  Boolean.FALSE;
         }
         
         return Boolean.TRUE;
     }
     
}
