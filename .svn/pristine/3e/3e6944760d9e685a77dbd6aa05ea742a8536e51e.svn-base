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
import modele.OrclassAttestationAssurance;
import modele.OrclassEntreprises;
import modele.OrclassPolice;
import modele.OrclassRisque;

/**
 *
 * @author JIATOU FRANCK
 */
@Stateless
public class OrclassAttestationAssuranceDao extends AbstractJpaDAO<OrclassAttestationAssurance> {

    private static final long serialVersionUID = 1L;
    @PersistenceContext(unitName = AbstractJpaDAO.PersistanceUnit)
    private EntityManager em;

    @Override
    protected Class<OrclassAttestationAssurance> getEntityClass() {
        return OrclassAttestationAssurance.class;
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    /*
    recuperation d une attestaion assurance pour une police valider
     */
    public OrclassAttestationAssurance attestationByPoliceValide(OrclassEntreprises e, OrclassPolice p, OrclassRisque r) {
        Query q;
        q = em.createQuery("SELECT att FROM OrclassAttestationAssurance att where att.idPolice= :police and att.idRisque= :risque and att.idEntreprises= :e")
                .setParameter("police", p)
                .setParameter("risque", r)
                .setParameter("e", e);
        if (q.getResultList().isEmpty()) {
            return null;
        }
        return (OrclassAttestationAssurance) q.getResultList().toArray()[0];
    }
}
