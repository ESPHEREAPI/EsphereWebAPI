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
import modele.OrclassEntreprises;
import modele.OrclassExoneration;
import modele.OrclassTypeTaxe;

/**
 *
 * @author hp
 */
@Stateless
public class OrclassTypeTaxeDao extends AbstractJpaDAO<OrclassTypeTaxe> {

    private static final long serialVersionUID = 1L;
    @PersistenceContext(unitName = AbstractJpaDAO.PersistanceUnit)
    private EntityManager em;

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @Override
    protected Class<OrclassTypeTaxe> getEntityClass() {
        return OrclassTypeTaxe.class;
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    /*liste les type taxe n existant pas dans exoneration taxe     */
    public List<OrclassTypeTaxe> listeTypeTaxeNotExisteForExonerationTaxe(OrclassExoneration ex, OrclassEntreprises en) {
//        Query q;
//        q = em.createQuery("SELECT t FROM OrclassTypeTaxe t WHERE t.idTypeTaxe not in  (SELECT et.idTypeTaxe From OrclassExonerationTaxe et, OrclassTypeTaxe tt where et.idTypeTaxe.idTypeTaxe = tt.idTypeTaxe and et.idExoneration.idExoneration= :idExoneration)")
//                .setParameter("idExoneration", e.getIdExoneration());
//        return q.getResultList();
        Query q;
        q = em.createQuery("SELECT t FROM OrclassTypeTaxe t WHERE  NOT EXISTS (SELECT e.idTypeTaxe FROM OrclassExonerationTaxe e where e.idTypeTaxe= t  AND  e.idEntreprises.idEntreprise= :idEntreprise and e.idExoneration= :ex)")
                .setParameter("idEntreprise", en.getIdEntreprise())
                .setParameter("ex", ex);
        return q.getResultList();

    }

    public OrclassTypeTaxe finKey(String code, String libelle) {
        Query q;
        q = em.createQuery("SELECT t FROM OrclassTypeTaxe t WHERE t.code= :code or t.libelle= :libelle")
                .setParameter("code", code)
                .setParameter("libelle", libelle);
        if (q.getResultList().isEmpty()) {
            return null;
        }
        return (OrclassTypeTaxe) q.getResultList().toArray()[0];
    }

    public List<String> getTypeTaxeWithFilters(String Filter) {

        Map<String, Object> param = new HashMap<>();

        Query q = null;

        //si le filtre existe
        String request = "SELECT t.code FROM OrclassTypeTaxe t  WHERE";
//        Query q;
        if (Filter != null && !Filter.trim().equals("")) {
            request += " t.code like :filter or t.libelle like :filter";

            q = em.createQuery(request)
                    .setParameter("filter", "%" + Filter + "%");

        }

        return q.getResultList();

    }

    public List<String> getTypeTaxeLibelleWithFilters(String Filter) {

        Map<String, Object> param = new HashMap<>();

        Query q = null;

        //si le filtre existe
        String request = "SELECT t.libelle FROM OrclassTypeTaxe t  WHERE";
//        Query q;
        if (Filter != null && !Filter.trim().equals("")) {
            request += " t.code like :filter or t.libelle like :filter";

            q = em.createQuery(request)
                    .setParameter("filter", "%" + Filter + "%");

        }

        return q.getResultList();

    }
}
