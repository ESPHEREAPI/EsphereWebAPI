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
import modele.OrclassCategories;
import modele.OrclassEntreprises;
import modele.OrclassRegistreProduction;
import modele.OrclassRegistreSinistre;

/**
 *
 * @author hp
 */
@Stateless
public class OrclassRegistreProductionDao extends AbstractJpaDAO< OrclassRegistreProduction> {

    private static final long serialVersionUID = 1L;
    @PersistenceContext(unitName = AbstractJpaDAO.PersistanceUnit)
    private EntityManager em;

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @Override
    protected Class<OrclassRegistreProduction> getEntityClass() {
        return OrclassRegistreProduction.class;

    }

    @Override
    protected EntityManager getEntityManager() {
        return em;

    }
    
      public OrclassRegistreProduction finKeyRegistreProductionByCompagnie(OrclassEntreprises e, String code){
        Query q;
        q=em.createQuery("SELECT rp FROM OrclassRegistreProduction rp WHERE rp.idEntreprise.idEntreprise= :idEntreprise AND rp.code= :code")
                .setParameter("code", code)
                .setParameter("idEntreprise", e.getIdEntreprise());
        if (q.getResultList().isEmpty()) {
            return null;
        }
        return (OrclassRegistreProduction) q.getResultList().toArray()[0];
                
    }
       public OrclassRegistreProduction finKeyRegistreProductionByCompagnieWithPrefixe(OrclassEntreprises e, String prefixe){
        Query q;
        q=em.createQuery("SELECT rp FROM OrclassRegistreProduction rp WHERE rp.idEntreprise.idEntreprise= :idEntreprise AND rp.prefixe= :pr")
                .setParameter("pr", prefixe)
                .setParameter("idEntreprise", e.getIdEntreprise());
        if (q.getResultList().isEmpty()) {
            return null;
        }
        return (OrclassRegistreProduction) q.getResultList().toArray()[0];
                
    }
        public List<OrclassRegistreProduction>getAllRegistreProductionByCompagnie(OrclassEntreprises e){
        Query q;
        q=em.createQuery("SELECT rp FROM OrclassRegistreProduction rp WHERE rp.idEntreprise.idEntreprise= :idEntreprise ")
              
                .setParameter("idEntreprise", e.getIdEntreprise());
       
        return q.getResultList();
                
    }
         public List<OrclassCategories> listeCategoriesHaveRegistreProductionByCompagnie(OrclassEntreprises e) {
        Query q;
        q = em.createQuery("SELECT ets.idCategories FROM OrclassRegistreProduction e JOIN e.orclassElt_Categorie_CompagnieList ets  WHERE ets.idEntreprise= :en and e.idEntreprise= :en")
                .setParameter("en", e);
        return q.getResultList();
    }
}

