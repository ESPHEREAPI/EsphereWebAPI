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
import modele.OrclassTypeApporteur;
import modele.OrclassEntreprises;

/**
 *
 * @author hp
 */
@Stateless
public class OrclassTypeApporteurDao extends AbstractJpaDAO<OrclassTypeApporteur> {

    private static final long serialVersionUID = 1L;
    @PersistenceContext(unitName = AbstractJpaDAO.PersistanceUnit)
    private EntityManager em;

    @Override
    protected Class<OrclassTypeApporteur> getEntityClass() {
        return OrclassTypeApporteur.class;
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    /*
    liste tous les apporteurs visible par tous les companies
     */
    public List<OrclassTypeApporteur> listAllApporteurShowAllCompagnie() {
        Query q;
        q = em.createQuery("SELECT ap from OrclassTypeApporteur ap WHERE ap.showAllCompagnies= :value  and ap.idEntreprise IS NULL ")
                .setParameter("value", Boolean.TRUE);
        return q.getResultList();
    }

    /*
    lister tous les apporteur pour une compag,is precis
     */
    public List<OrclassTypeApporteur> listAllApporteurByCompagnie(OrclassEntreprises e) {
        Query q;
        q = em.createQuery("SELECT ap from OrclassTypeApporteur ap WHERE ap.showAllCompagnies= :value  and ap.idEntreprise= :e ")
                .setParameter("value", Boolean.FALSE)
                .setParameter("e", e);
        return q.getResultList();
    }
    

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
