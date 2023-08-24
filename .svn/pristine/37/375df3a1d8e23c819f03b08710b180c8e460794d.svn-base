/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import enums.TypeBureau;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import modele.OrclassEntreprises;
import modele.OrclassTypeBureau;

/**
 *
 * @author hp
 */
@Stateless
public class OrclassTypeBureauDao extends AbstractJpaDAO<OrclassTypeBureau> {

    private static final long serialVersionUID = 1L;
    @PersistenceContext(unitName = AbstractJpaDAO.PersistanceUnit)
    private EntityManager em;

    @Override
    protected Class<OrclassTypeBureau> getEntityClass() {
        return OrclassTypeBureau.class;

    }

    @Override
    protected EntityManager getEntityManager() {
        return em;

    }

    public List<OrclassTypeBureau> listTypeBureauByAutre() {
        Query q;
        q = em.createQuery("SELECT tb FROM OrclassTypeBureau tb WHERE tb.typeBureau= :t")
                .setParameter("t", TypeBureau.Autre);
        return q.getResultList();
    }

    /*
    liste tous les types bureaux pour tous les compagnies
     */
    public List<OrclassTypeBureau> listeTypeBureauShowAllCompagnie() {
        Query q;
        q = em.createQuery("SELECT tb FROM OrclassTypeBureau tb WHERE tb.showAllCompagnies= :value AND tb.idEntreprise is null")
                .setParameter("value", Boolean.TRUE);
        return q.getResultList();
    }

    /*
    lister tous les types bureau pour une compagnies prcise
     */
    public List<OrclassTypeBureau> listeTypeByCompagnie(OrclassEntreprises e) {
        Query q;
        q = em.createQuery("SELECT tb FROM OrclassTypeBureau tb WHERE tb.showAllCompagnies= :value AND tb.idEntreprise= :e")
                .setParameter("value", Boolean.FALSE)
                .setParameter("e", e);

        return q.getResultList();
    }
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
