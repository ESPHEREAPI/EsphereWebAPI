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
import modele.OrclassCategories;
import modele.OrclassEntreprises;
import modele.OrclassExercice;
import modele.OrclassIntermediaires;
import modele.OrclassRegistreSinistre;

/**
 *
 * @author hp
 */
@Stateless
public class OrclassRegistreSinistreDao extends AbstractJpaDAO<OrclassRegistreSinistre> {

    private static final long serialVersionUID = 1L;
    @PersistenceContext(unitName = AbstractJpaDAO.PersistanceUnit)
    private EntityManager em;

    @Override
    protected Class<OrclassRegistreSinistre> getEntityClass() {
        return OrclassRegistreSinistre.class;
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    public OrclassRegistreSinistre finKeyRegistreSinistreByCompagnie(OrclassEntreprises e, String code) {
        Query q;
        q = em.createQuery("SELECT rs FROM OrclassRegistreSinistre rs WHERE rs.idEntreprise.idEntreprise= :idEntreprise AND rs.Code= :code")
                .setParameter("code", code)
                .setParameter("idEntreprise", e.getIdEntreprise());
        if (q.getResultList().isEmpty()) {
            return null;
        }
        return (OrclassRegistreSinistre) q.getResultList().toArray()[0];

    }

    public List<OrclassRegistreSinistre> getAllRegistreSinistreByCompagnie(OrclassEntreprises e) {
        Query q;
        q = em.createQuery("SELECT rs FROM OrclassRegistreSinistre rs WHERE rs.idEntreprise.idEntreprise= :idEntreprise ")
                .setParameter("idEntreprise", e.getIdEntreprise());

        return q.getResultList();

    }

    public List<OrclassCategories> listeCategoriesHaveRegistreSinistreByCompagnie(OrclassEntreprises e) {
        Query q;
        q = em.createQuery("SELECT ets.idCategories FROM OrclassRegistreSinistre e JOIN e.orclassElt_Categorie_CompagnieList ets  WHERE ets.idEntreprise= :en and e.idEntreprise= :en")
                .setParameter("en", e);
        return q.getResultList();
    }

    public OrclassRegistreSinistre finKeyRegistreSinistre(String code, OrclassEntreprises e, OrclassExercice ex) {
        Query q;
        q = em.createQuery("SELECT r from OrclassRegistreSinistre r where r.Code= :code  and r.idEntreprise= :e and r.idExercice= :ex ")
                .setParameter("code", code)
                .setParameter("e", e)
                //                 .setParameter("num", numRegistre)
                .setParameter("ex", ex);
        if (q.getResultList().isEmpty()) {
            return null;
        }
        return (OrclassRegistreSinistre) q.getResultList().toArray()[0];
    }

    public OrclassRegistreSinistre finKeyRegistreSinistre(String code, OrclassEntreprises e, OrclassExercice ex, OrclassIntermediaires agence) {
        Query q;
        q = em.createQuery("SELECT r from OrclassRegistreSinistre r where r.Code= :code  and r.idEntreprise= :e and r.idExercice= :ex and r.idIntermediaire.idIntermediaire= :id_agence ")
                .setParameter("code", code)
                .setParameter("e", e)
                .setParameter("id_agence", agence.getIdIntermediaire())
                .setParameter("ex", ex);
        if (q.getResultList().isEmpty()) {
            return null;
        }
        return (OrclassRegistreSinistre) q.getResultList().toArray()[0];
    }
    
     public OrclassRegistreSinistre registreSinistreByExerciceAndAgence( OrclassEntreprises e, OrclassExercice ex, OrclassIntermediaires agence) {
        Query q;
        q = em.createQuery("SELECT r from OrclassRegistreSinistre r where  r.idEntreprise= :e and r.idExercice= :ex and r.idIntermediaire.idIntermediaire= :id_agence ")
//                .setParameter("code", code)
                .setParameter("e", e)
                .setParameter("id_agence", agence.getIdIntermediaire())
                .setParameter("ex", ex);
        if (q.getResultList().isEmpty()) {
            return null;
        }
        return (OrclassRegistreSinistre) q.getResultList().toArray()[0];
    }

}
