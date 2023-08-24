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
import modele.OrclassPrestation;
import modele.OrclassSinistre;
import modele.OrclassSinistreMaladie;

/**
 *
 * @author JIATOU FRANCK
 */
@Stateless
public class OrclassSinistreMaladieDao extends AbstractJpaDAO<OrclassSinistreMaladie> {

    private static final long serialVersionUID = 1L;
    @PersistenceContext(unitName = AbstractJpaDAO.PersistanceUnit)
    private EntityManager em;

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @Override
    protected Class<OrclassSinistreMaladie> getEntityClass() {
        return OrclassSinistreMaladie.class;
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    //liste un ensemble de sinistre malaladie pour une compagnie precis et un sinsitre bien determiner
    public List<OrclassSinistreMaladie> listeSinistreMaladieByCompagnieForSinistre(OrclassEntreprises e, OrclassSinistre sin) {
        Query q;
        q = em.createQuery("SELECT sm FROM OrclassSinistreMaladie sm WHERE sm.idEntreprise= :e and sm.idSinistre= :sin ")
                .setParameter("e", e)
                .setParameter("sin", sin);
        return q.getResultList();

    }
    // verification de l enregistrement d une ligne de sinistre maladie
    public OrclassSinistreMaladie finKey(OrclassEntreprises e, OrclassSinistre sin, OrclassPrestation p){
        Query q;
        q=em.createQuery("SELECT sm FROM OrclassSinistreMaladie sm WHERE sm.idEntreprise= :e and sm.idSinistre= :sin and sm.idPrestation= :p")
                .setParameter("e", e)
                .setParameter("sin", sin)
                .setParameter("p", p)
                ;
        if (q.getResultList().isEmpty()) {
            return null;
        }
        return (OrclassSinistreMaladie) q.getResultList().toArray()[0];
                
    }
}
