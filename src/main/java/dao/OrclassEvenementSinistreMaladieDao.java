/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package dao;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import modele.OrclassEntreprises;
import modele.OrclassEvenement;
import modele.OrclassEvenementSinistreMaladie;
import modele.OrclassIntervenant;
import modele.OrclassIntervenantSinistreMaladie;
import modele.OrclassSinistre;
import modele.OrclassSinistreMaladie;

/**
 *
 * @author JIATOU FRANCK
 */
@Stateless
public class OrclassEvenementSinistreMaladieDao extends AbstractJpaDAO<OrclassEvenementSinistreMaladie> {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @PersistenceContext(unitName = AbstractJpaDAO.PersistanceUnit)
    private EntityManager em;

    @Override
    protected Class<OrclassEvenementSinistreMaladie> getEntityClass() {
        return OrclassEvenementSinistreMaladie.class;
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public List<OrclassEvenementSinistreMaladie> listEnementBySinistreMaladie(OrclassEntreprises e, OrclassSinistreMaladie sinMad) {
        Query q;
        q = em.createQuery("SELECT se FROM OrclassEvenementSinistreMaladie se WHERE se.idEntreprise= :e and se.idSinistreMaladie= :sinmad")
                .setParameter("e", e)
                .setParameter("sinmad", sinMad);
        return q.getResultList();
    }

    public List<OrclassEvenementSinistreMaladie> listEnementBySinistreMaladie(OrclassEntreprises e, OrclassSinistre sinMad) {
        Query q;
        q = em.createQuery("SELECT se FROM OrclassEvenementSinistreMaladie se WHERE se.idEntreprise= :e and se.idSinistreMaladie.idSinistre= :sinmad")
                .setParameter("e", e)
                .setParameter("sinmad", sinMad);
        return q.getResultList();
    }

    public OrclassEvenementSinistreMaladie evenementBySinistreMaladie(OrclassEntreprises e, OrclassSinistreMaladie sinMad,  OrclassEvenement event) {
        Query q;
        q = em.createQuery("SELECT es FROM OrclassEvenementSinistreMaladie es WHERE es.idEntreprise= :e and es.idSinistreMaladie= :sinmad and es.idEvenement.id= :idevent")
                .setParameter("e", e)
                .setParameter("sinmad", sinMad)
                .setParameter("idevent", event.getId());
        if (q.getResultList().isEmpty()) {
            return null;
        }
        return (OrclassEvenementSinistreMaladie) q.getResultList().toArray()[0];
    }
}
