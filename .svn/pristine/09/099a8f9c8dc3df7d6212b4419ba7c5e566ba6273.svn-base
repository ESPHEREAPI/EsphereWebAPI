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
import modele.OrclassRefApporteur;

/**
 *
 * @author frankjiatou
 */
@Stateless
public class OrclassRefApporteurDao extends AbstractJpaDAO<OrclassRefApporteur>{

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
        @PersistenceContext(unitName = AbstractJpaDAO.PersistanceUnit)
    private EntityManager em;

    @Override
    protected Class<OrclassRefApporteur> getEntityClass() {
       return OrclassRefApporteur.class;
    }

    @Override
    protected EntityManager getEntityManager() {
      return em;
    }
    
     public List<String> getRefApporteurCodeWithFilters( String Filter) {

        Map<String, Object> param = new HashMap<>();

        Query q = null;

        //si le filtre existe
        String request = "SELECT ref.code FROM OrclassRefApporteur ref  WHERE";
//        Query q;
        if (Filter != null && !Filter.trim().equals("")) {
            request += " ref.code like :filter ";

            q = em.createQuery(request)
                    
                    .setParameter("filter", "%" + Filter + "%") ;

        }

        return q.getResultList();

    }
}
