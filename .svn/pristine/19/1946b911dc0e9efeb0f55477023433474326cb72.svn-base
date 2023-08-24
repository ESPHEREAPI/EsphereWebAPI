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
import modele.OrclassClasses;
import modele.OrclassDuree;
import modele.OrclassEntreprises;

/**
 *
 * @author hp
 */
@Stateless
public class OrclassDureeDao extends AbstractJpaDAO<OrclassDuree>{
      private static final long serialVersionUID = 1L;
    @PersistenceContext(unitName = AbstractJpaDAO.PersistanceUnit)
    private EntityManager em;

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
  /*
    liste tous les Duree visible par tous les companies
     */
    public List<OrclassDuree> listAllClassesShowAllCompagnie() {
        Query q;
        q = em.createQuery("SELECT d from OrclassDuree d WHERE d.showAllCompagnies= :value  and d.idEntreprise IS NULL ")
                .setParameter("value", Boolean.TRUE);
        return q.getResultList();
    }

    /*
    lister tous les Duree pour une compagn,is precis
     */
    public List<OrclassDuree> listAllClassesByCompagnie(OrclassEntreprises e) {
        Query q;
        q = em.createQuery("SELECT d from OrclassDuree d WHERE d.showAllCompagnies= :value  and d.idEntreprise= :e ")
                .setParameter("value", Boolean.FALSE)
                .setParameter("e", e);
        return q.getResultList();
    }

    @Override
    protected Class<OrclassDuree> getEntityClass() {
        return OrclassDuree.class;
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
}
