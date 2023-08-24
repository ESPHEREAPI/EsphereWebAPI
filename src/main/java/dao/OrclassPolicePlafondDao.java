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
import modele.OrclassPlafondMaladie;
import modele.OrclassPolice;
//import modele.OrclassPolicesss;
import modele.OrclassPolicePlafond;
import modele.OrclasseRefGroupe;

/**
 *
 * @author hp
 */
@Stateless
public class OrclassPolicePlafondDao extends AbstractJpaDAO<OrclassPolicePlafond> {

    private static final long serialVersionUID = 1L;
    @PersistenceContext(unitName = AbstractJpaDAO.PersistanceUnit)
    private EntityManager em;
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    protected Class<OrclassPolicePlafond> getEntityClass() {
        return OrclassPolicePlafond.class;
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public OrclassPlafondMaladie chargePlafonMaladie(OrclassPolice police, OrclassEntreprises e) {
        Query q;
        q = em.createQuery("SELECT p.idPlafondMaladie FROM OrclassPolicePlafond p WHERE p.idPolice= :police and p.idEntreprise= :entreprise and p.idAvenant is null")
                .setParameter("police", police)
                .setParameter("entreprise", e);
        if (q.getResultList().isEmpty()) {
            return null;
        }
        return (OrclassPlafondMaladie) q.getResultList().toArray()[0];

    }

    public OrclassPlafondMaladie chargePlafonMaladie(OrclassPolice police, OrclassEntreprises e, OrclasseRefGroupe g) {
        Query q;
        q = em.createQuery("SELECT p.idPlafondMaladie FROM OrclassPolicePlafond p WHERE p.idPolice= :police and p.idEntreprise= :entreprise and p.idGroup= :g and  p.idAvenant is null")
                .setParameter("police", police)
                .setParameter("g", g)
                .setParameter("entreprise", e);
        if (q.getResultList().isEmpty()) {
            return null;
        }
        return (OrclassPlafondMaladie) q.getResultList().toArray()[0];

    }
//    public OrclassPolicePlafond finKey(Orclasspolic)

    public OrclassPolicePlafond chargePolicePlafonMaladie(OrclassPolice police, OrclassEntreprises e) {
        Query q;
        q = em.createQuery("SELECT p FROM OrclassPolicePlafond p WHERE p.idPolice= :police and p.idEntreprise= :entreprise and p.idAvenant is null")
                .setParameter("police", police)
                .setParameter("entreprise", e);
        if (q.getResultList().isEmpty()) {
            return null;
        }
        return (OrclassPolicePlafond) q.getResultList().toArray()[0];

    }

    public OrclassPolicePlafond chargePolicePlafonMaladie(OrclassPolice police, OrclassEntreprises e, OrclasseRefGroupe group,OrclassPlafondMaladie maladie) {
        Query q;
        q = em.createQuery("SELECT p FROM OrclassPolicePlafond p WHERE p.idPolice= :police and p.idEntreprise= :entreprise  and p.idGroup= :g and p.idPlafondMaladie= :pm and p.idAvenant is null")
                .setParameter("police", police)
                .setParameter("g", group)
                   .setParameter("pm", maladie)
                .setParameter("entreprise", e);
        if (q.getResultList().isEmpty()) {
            return null;
        }
        return (OrclassPolicePlafond) q.getResultList().toArray()[0];

    }
}
