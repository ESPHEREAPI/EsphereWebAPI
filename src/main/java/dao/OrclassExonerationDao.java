/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import modele.OrclassEntreprises;
import modele.OrclassExoneration;

/**
 *
 * @author hp
 */
@Stateless
public class OrclassExonerationDao extends AbstractJpaDAO<OrclassExoneration> {

    private static final long serialVersionUID = 1L;
    @PersistenceContext(unitName = AbstractJpaDAO.PersistanceUnit)
    private EntityManager em;

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @Override
    protected Class<OrclassExoneration> getEntityClass() {
        return OrclassExoneration.class;
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public OrclassExoneration finKey(String code, String libelle) {
        Query q;
        q = em.createQuery("SELECT ex FROM OrclassExoneration ex WHERE ex.code= :code or ex.libelle= :libelle")
                .setParameter("code", code)
                .setParameter("libelle", libelle);
        if (q.getResultList().isEmpty()) {
            return null;
        }
        return (OrclassExoneration) q.getResultList().toArray()[0];
    }
    
      public List<String> getExonerationWithFilters( String Filter) {

        Map<String, Object> param = new HashMap<>();

        Query q = null;

        //si le filtre existe
        String request = "SELECT ex.code FROM OrclassExoneration ex  WHERE";
//        Query q;
        if (Filter != null && !Filter.trim().equals("")) {
            request += " ex.code like :filter or ex.libelle like :filter";

            q = em.createQuery(request)
                    
                    .setParameter("filter", "%" + Filter + "%") ;

        }

        return q.getResultList();

    }
       public List<String> getExonerationLibelleWithFilters( String Filter) {

        Map<String, Object> param = new HashMap<>();

        Query q = null;

        //si le filtre existe
        String request = "SELECT ex.libelle FROM OrclassExoneration ex  WHERE";
//        Query q;
        if (Filter != null && !Filter.trim().equals("")) {
            request += " ex.code like :filter or ex.libelle like :filter";

            q = em.createQuery(request)
                    
                    .setParameter("filter", "%" + Filter + "%") ;

        }

        return q.getResultList();

    }
       public List<OrclassExoneration> listeExonerationHaveExonerationTaxe(OrclassEntreprises en){
           Query q;
           q=em.createQuery("SELECT e FROM OrclassExoneration e WHERE EXISTS (SELECT et.idExoneration FROM OrclassExonerationTaxe et where et.idExoneration=e and et.idEntreprises= :en) ")
                .setParameter("en", en)
                   ;
           return q.getResultList();
       }
}
