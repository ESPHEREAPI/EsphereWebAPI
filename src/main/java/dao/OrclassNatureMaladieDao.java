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
import modele.OrclassNatureMaladie;
import modele.OrclassRefNatureMaladie;

/**
 *
 * @author JIATOU FRANCK
 */
@Stateless
public class OrclassNatureMaladieDao extends AbstractJpaDAO<OrclassNatureMaladie> {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    private static final long serialVersionUID = 1L;
    @PersistenceContext(unitName = AbstractJpaDAO.PersistanceUnit)
    private EntityManager em;

    @Override
    protected Class<OrclassNatureMaladie> getEntityClass() {
        return OrclassNatureMaladie.class;
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    // verifier l existance d un prestataire
    public OrclassNatureMaladie finkey(OrclassRefNatureMaladie nm, OrclassEntreprises e) {
        Query q;
        q = em.createQuery("SELECT nm FROM OrclassNatureMaladie nm WHERE nm.idRefNatureMaladie= :idref and nm.idEntreprise= :e")
                .setParameter("idref", nm)
                .setParameter("e", e);
        if (q.getResultList().isEmpty()) {
            return null;
        }
        return (OrclassNatureMaladie) q.getResultList().toArray()[0];
    }

    public List<OrclassNatureMaladie> listeNatureMaladieByCompagnie(OrclassEntreprises e) {
        Query q;
        q = em.createQuery("SELECT nm FROM OrclassNatureMaladie nm WHERE nm.idEntreprise= :e")
                .setParameter("e", e);
        return q.getResultList();
    }

}
