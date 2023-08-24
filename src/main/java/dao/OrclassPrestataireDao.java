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
import modele.OrclassPrestataire;
import modele.orclassRefPrestataire;

/**
 *
 * @author JIATOU FRANCK
 */
@Stateless
public class OrclassPrestataireDao extends AbstractJpaDAO<OrclassPrestataire>{

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    	private static final long serialVersionUID = 1L;
	@PersistenceContext(unitName=AbstractJpaDAO.PersistanceUnit)
    private EntityManager em;

    @Override
    protected Class<OrclassPrestataire> getEntityClass() {
        return OrclassPrestataire.class;
    }

    @Override
    protected EntityManager getEntityManager() {
       return em;
    }
    
    // verifier l existance d un prestataire
    public OrclassPrestataire finkey(orclassRefPrestataire rp, OrclassEntreprises e){
        Query q;
        q=em.createQuery("SELECT p FROM OrclassPrestataire p WHERE p.idRefPrestataire= :idref and p.idEntreprise= :e")
                .setParameter("idref", rp)
                .setParameter("e", e);
        if (q.getResultList().isEmpty()) {
            return null;
        }
    return (OrclassPrestataire) q.getResultList().toArray()[0];
    }
    
    public List<OrclassPrestataire> listePrstataireByCompagnie(OrclassEntreprises e){
        Query q;
        q=em.createQuery("SELECT p FROM OrclassPrestataire p WHERE p.idEntreprise= :e")
                .setParameter("e", e);
        return q.getResultList();
    }
    
}
