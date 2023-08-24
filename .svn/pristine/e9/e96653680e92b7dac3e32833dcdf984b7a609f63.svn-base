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
import modele.OrclassFamillePrestation;
import modele.OrclassRubrique;

/**
 *
 * @author hp
 */
@Stateless
public class OrclassRubriqueDao extends AbstractJpaDAO< OrclassRubrique> {

    private static final long serialVersionUID = 1L;
    @PersistenceContext(unitName = AbstractJpaDAO.PersistanceUnit)
    private EntityManager em;

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @Override
    protected Class<OrclassRubrique> getEntityClass() {
        return OrclassRubrique.class;
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    /*
    lister les rubrique pour unre cmpagnie precis
     */
    public List<OrclassRubrique> liteRubriqueByCompagnie(OrclassEntreprises e) {
        Query q;
        q = em.createQuery("SELECT r from OrclassRubrique r WHERE r.idEntreprise.idEntreprise= :idEntreprise and r.showAllCompagnies= :valeur")
                .setParameter("idEntreprise", e.getIdEntreprise())
                .setParameter("valeur", Boolean.FALSE);
        return q.getResultList();
    }

    public List<OrclassRubrique> liteRubriqueForAllCompagnie() {
        Query q;
        q = em.createQuery("SELECT r from OrclassRubrique r WHERE  r.showAllCompagnies= :valeur and r.idEntreprise is null")
//                .setParameter("idEntreprise", e.getIdEntreprise())
                  .setParameter("valeur", Boolean.TRUE);
        return q.getResultList();
    }
    public OrclassRubrique finkey(OrclassEntreprises e,String code){
          Query q;
        q = em.createQuery("SELECT r from OrclassRubrique r WHERE r.idEntreprise.idEntreprise= :idEntreprise and r.code= :code")
                .setParameter("idEntreprise", e.getIdEntreprise())
                .setParameter("code", code);
        if (q.getResultList().isEmpty()) {
            return null;
        }
        return (OrclassRubrique) q.getResultList().toArray()[0];
    }
}
