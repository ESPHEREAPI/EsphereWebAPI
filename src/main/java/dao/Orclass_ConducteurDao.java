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
import modele.OrclassEntreprises;
import modele.OrclassConducteur;
import modele.OrclassRisque;

/**
 *
 * @author JIATOU FRANCK
 */
@Stateless
public class Orclass_ConducteurDao extends AbstractJpaDAO<OrclassConducteur>{
    @PersistenceContext(unitName=AbstractJpaDAO.PersistanceUnit)
    private EntityManager em;

    @Override
    protected Class<OrclassConducteur> getEntityClass() {
       return OrclassConducteur.class;
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    public OrclassConducteur finKey(OrclassEntreprises e,String nom,OrclassRisque risque){
        Query q;
        q=em.createQuery("SELECT c FROM OrclassConducteur c WHERE c.idEntreprise= :e and c.idRisque= :r and c.nomComplet= :nom ")
                .setParameter("e", e)
                .setParameter("r", risque)
                .setParameter("nom", nom)
                ;
        if (q.getResultList().isEmpty()) {
            return null;
        }
        return (OrclassConducteur) q.getResultList().toArray()[0];

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
    
        public OrclassConducteur finKey(OrclassEntreprises e,OrclassRisque risque){
        Query q;
        q=em.createQuery("SELECT c FROM OrclassConducteur c WHERE c.idEntreprise= :e and c.idRisque= :r  ")
                .setParameter("e", e)
                .setParameter("r", risque)
              
                ;
        if (q.getResultList().isEmpty()) {
            return null;
        }
        return (OrclassConducteur) q.getResultList().toArray()[0];

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
    
}
