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
import modele.orclassRefPrestataire;

/**
 *
 * @author JIATOU FRANCK
 */
@Stateless
public class orclassRefPrestataireDao extends  AbstractJpaDAO<orclassRefPrestataire>{

    	private static final long serialVersionUID = 1L;
	@PersistenceContext(unitName=AbstractJpaDAO.PersistanceUnit)
    private EntityManager em;

    @Override
    protected Class<orclassRefPrestataire> getEntityClass() {
       return orclassRefPrestataire.class;
    }

    @Override
    protected EntityManager getEntityManager() {
       return em;
    }
    
     public List<String> getRefPrestataireCodeWithFilters( String Filter) {

        Map<String, Object> param = new HashMap<>();

        Query q = null;

        //si le filtre existe
        String request = "SELECT ref.code FROM orclassRefPrestataire ref  WHERE";
//        Query q;
        if (Filter != null && !Filter.trim().equals("")) {
            request += " ref.code like :filter ";

            q = em.createQuery(request)
                    
                    .setParameter("filter", "%" + Filter + "%") ;

        }

        return q.getResultList();

    }
}
