/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.math.BigInteger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import modele.OrclassCategories;
import modele.OrclassEntreprises;
import modele.OrclassIntermediaires;
import modele.OrclassPolice;
//import modele.OrclassPolicesss;
import modele.OrclassProposition;

/**
 *
 * @author frankjiatou
 */
@Stateless
public class OrclassPropositionDao extends AbstractJpaDAO<OrclassProposition> {

    @PersistenceContext(unitName = AbstractJpaDAO.PersistanceUnit)
    private EntityManager em;

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @Override
    protected Class<OrclassProposition> getEntityClass() {
        return OrclassProposition.class;
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public OrclassProposition recuperLapoliceProser(BigInteger police_proposition, OrclassIntermediaires agence, OrclassEntreprises e, OrclassCategories cat) {
        Query q;
        q = em.createQuery("SELECT p FROM OrclassProposition p WHERE p.police_proposition= :police and p.idIntermediaire= :agence and p.idCategories= :cat and p.idEntreprises= :e")
                .setParameter("police", police_proposition)
                .setParameter("agence", agence)
                .setParameter("cat", cat)
                .setParameter("e", e);
        if (q.getResultList().isEmpty()) {
            return null;
        }
        return (OrclassProposition) q.getResultList().toArray()[0];
    }

    public OrclassProposition recuperLapoliceValider(BigInteger police_Valider, OrclassIntermediaires agence, OrclassEntreprises e, OrclassCategories cat, OrclassPolice p) {
        Query q;
        q = em.createQuery("SELECT p FROM OrclassProposition p WHERE p.police= :police and p.idIntermediaire= :agence and p.idCategories= :cat and p.idEntreprises= :e and p.idPolice= :pol")
                .setParameter("police", police_Valider)
                .setParameter("agence", agence)
                .setParameter("cat", cat)
                .setParameter("pol", p)
                .setParameter("e", e);
        if (q.getResultList().isEmpty()) {
            return null;
        }
        return (OrclassProposition) q.getResultList().toArray()[0];
    }
}
