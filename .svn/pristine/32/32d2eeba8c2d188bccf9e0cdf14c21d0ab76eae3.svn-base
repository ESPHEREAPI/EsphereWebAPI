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
import modele.OrclassRegimeTaxe;
import modele.OrclassTaxePrime;
import modele.OrclassTypeTaxe;

/**
 *
 * @author JIATOU FRANCK
 */
@Stateless
public class OrclassTaxePrimeDao extends AbstractJpaDAO<OrclassTaxePrime>{

    private static final long serialVersionUID = 1L;
    @PersistenceContext(unitName = AbstractJpaDAO.PersistanceUnit)
    private EntityManager em;

    @Override
    protected Class<OrclassTaxePrime> getEntityClass() {
     return OrclassTaxePrime.class;
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    public OrclassTaxePrime finkey(OrclassEntreprises e,OrclassCategories c,OrclassRegimeTaxe r ,OrclassTypeTaxe t,Date effet){
        Query q;
       q=em.createQuery("SELECT tp FROM OrclassTaxePrime tp WHERE tp.date_effet= :effet and tp.idEntreprise= :e and tp.idCategories= :c and tp.idRegimeTaxe= :r and tp.idTypeTaxe= :t")
               .setParameter("effet", effet)
               .setParameter("e", e)
               .setParameter("c", c)
               .setParameter("r", r)
               .setParameter("t", t)
               .setParameter("effet", effet)
               ;
        if (q.getResultList().isEmpty()) {
            return null;
        }
        return (OrclassTaxePrime) q.getResultList().toArray()[0];
    }
      public OrclassTaxePrime finkey(OrclassEntreprises e,OrclassCategories c,OrclassRegimeTaxe r ,OrclassTypeTaxe t,Date effet,OrclassGarantie g){
        Query q;
       q=em.createQuery("SELECT tp FROM OrclassTaxePrime tp WHERE tp.date_effet= :effet and tp.idEntreprise= :e and tp.idCategories= :c and tp.idRegimeTaxe= :r and tp.idTypeTaxe= :t and tp.idGarantie= :g")
               .setParameter("effet", effet)
               .setParameter("e", e)
               .setParameter("c", c)
               .setParameter("r", r)
               .setParameter("t", t)
               .setParameter("effet", effet)
               .setParameter("g", g)
               ;
        if (q.getResultList().isEmpty()) {
            return null;
        }
        return (OrclassTaxePrime) q.getResultList().toArray()[0];
    }
      
      public List<OrclassTaxePrime> listeTaxePrimeByCategories(OrclassEntreprises e,OrclassCategories c){
          Query q;
          q=em.createQuery("SELECT tp FROM OrclassTaxePrime tp WHERE tp.idEntreprise= :e and tp.idCategories= :c ORDER BY tp.date_effet DESC")
                  .setParameter("c", c)
                  .setParameter("e", e);
          return q.getResultList();
      }
       public List<OrclassTaxePrime> listeTaxePrimeByCategories(OrclassEntreprises e,OrclassCategories c,OrclassRegimeTaxe r,Date effet){
          Query q;
          q=em.createQuery("SELECT tp FROM OrclassTaxePrime tp WHERE tp.idEntreprise= :e and tp.idCategories= :c and tp.idRegimeTaxe= :r and tp.date_effet= :effet ORDER BY tp.idTypeTaxe.registreTaxe ASC")
                  .setParameter("c", c)
                  .setParameter("r", r)
                    .setParameter("effet", effet)
                  .setParameter("e", e);
          return q.getResultList();
      }
    
         public List<OrclassTaxePrime> listeTaxePrimeByCategories(OrclassEntreprises e,OrclassCategories c,OrclassRegimeTaxe r){
          Query q;
          q=em.createQuery("SELECT tp FROM OrclassTaxePrime tp WHERE tp.idEntreprise= :e and tp.idCategories= :c and tp.idRegimeTaxe= :r  ORDER BY tp.idTypeTaxe.registreTaxe ASC")
                  .setParameter("c", c)
                  .setParameter("r", r)
//                    .setParameter("effet", effet)
                  .setParameter("e", e);
          return q.getResultList();
      }
}
