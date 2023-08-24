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
import modele.OrclassExoneration;
import modele.OrclassExonerationTaxe;
import modele.OrclassRefTimbreGradue;

/**
 *
 * @author JIATOU FRANCK
 */
@Stateless
public class OrclassRefTimbreGradueDao extends AbstractJpaDAO<OrclassRefTimbreGradue>{

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
      @PersistenceContext(unitName = AbstractJpaDAO.PersistanceUnit)
    private EntityManager em;

    @Override
    protected Class<OrclassRefTimbreGradue> getEntityClass() {
       return OrclassRefTimbreGradue.class;
      
    }

    @Override
    protected EntityManager getEntityManager() {
       return em;
    }
    
     public List<OrclassRefTimbreGradue> listeTimbreGradueNotExisteForExonerationTaxe(OrclassExoneration ex,OrclassEntreprises en) {
        Query q;
       q = em.createQuery("SELECT r FROM OrclassRefTimbreGradue r WHERE  NOT EXISTS (SELECT e.idRefTimbreGradue FROM OrclassExonerationTaxe e where e.idRefTimbreGradue.id= r.id AND  e.idEntreprises.idEntreprise= :idEntreprise and e.idExoneration= :ex)")
                .setParameter("idEntreprise", en.getIdEntreprise())
               .setParameter("ex", ex)
               ;
        return q.getResultList();
    }
}
