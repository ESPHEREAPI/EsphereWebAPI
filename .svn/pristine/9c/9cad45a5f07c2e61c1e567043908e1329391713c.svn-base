/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import modele.OrclassAssure;
import modele.OrclassEntreprises;
import modele.OrclassIntermediaires;

/**
 *
 * @author hp
 */
@Stateless
public class OrclassAssureDao extends AbstractJpaDAO< OrclassAssure> {

    private static final long serialVersionUID = 1L;
    @PersistenceContext(unitName = AbstractJpaDAO.PersistanceUnit)
    private EntityManager em;

    @Override
    protected Class<OrclassAssure> getEntityClass() {
        return OrclassAssure.class;
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public OrclassAssure finKeyAssure(String valeur, OrclassEntreprises e) {
        Query q;
        q = em.createQuery("SELECT a FROM OrclassAssure a WHERE (a.raison_social= :valeur or a.nom= :valeur) and a.idEntreprise.idEntreprise= :idEntreprise")
                .setParameter("valeur", valeur)
                .setParameter("idEntreprise", e.getIdEntreprise());
        if (q.getResultList().isEmpty()) {
            return null;
        }
        return (OrclassAssure) q.getResultList().toArray()[0];
    }

    public OrclassAssure getLastRowForAgence(OrclassIntermediaires agence, OrclassEntreprises e) {
        Query q;
        q = em.createQuery("SELECT a FROM OrclassAssure a WHERE a.id= (SELECT Max(ass.id) FROM OrclassAssure ass where ass.idEntreprise.idEntreprise= :idEntreprise and ass.idIntermediaire.idIntermediaire= :idIntermediaire )")
                .setParameter("idIntermediaire", agence.getIdIntermediaire())
                .setParameter("idEntreprise", e.getIdEntreprise());
        if (q.getResultList().isEmpty()) {
            return null;
        }
        return (OrclassAssure) q.getResultList().toArray()[0];
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    public Long nbreLigne(OrclassIntermediaires agence, OrclassEntreprises e) {
        Query q;
        q = em.createQuery("SELECT COUNT (ass) FROM OrclassAssure ass WHERE ass.idEntreprise.idEntreprise= :idEntreprise and ass.idIntermediaire.idIntermediaire= :idIntermediaire ")
                .setParameter("idIntermediaire", agence.getIdIntermediaire())
                .setParameter("idEntreprise", e.getIdEntreprise());
        if (q.getResultList().isEmpty()) {
            return 0L;
        }
        return (Long) q.getResultList().toArray()[0];
    }

    public List<String> getAssuerCodeWithFilters(OrclassEntreprises e, String Filter) {

        Map<String, Object> param = new HashMap<>();

        Query q = null;

        //si le filtre existe
        String request = "SELECT ass.nom FROM OrclassAssure ass  WHERE ass.idEntreprise.idEntreprise= :idEntreprise  ";
//        Query q;
        if (Filter != null && !Filter.trim().equals("")) {
            request += " AND ass.nom like :filter ";

            q = em.createQuery(request)
                    .setParameter("idEntreprise", e.getIdEntreprise())
                    .setParameter("filter", "%" + Filter + "%") ;

        }

        return q.getResultList();

    }

    public List<String> getAssueRaisonSocialWithFilters(OrclassEntreprises e, String Filter) {

        Map<String, Object> param = new HashMap<>();

        Query q = null;

        //si le filtre existe
        String request = "SELECT ass.raison_social FROM OrclassAssure ass  WHERE ass.idEntreprise.idEntreprise= :idEntreprise  ";
//        Query q;
        if (Filter != null && !Filter.trim().equals("")) {
            request += " AND ass.raison_social like :filter ";

            q = em.createQuery(request)
                    .setParameter("idEntreprise", e.getIdEntreprise())
                    .setParameter("filter", "%" + Filter + "%") //                    .setMaxResults(end - start).setFirstResult(start)
                    ;

        }

        return q.getResultList();

    }

}
