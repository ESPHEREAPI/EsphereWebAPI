/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import modele.OrclassEntreprises;
import modele.OrclasseRefGroupe;

/**
 *
 * @author hp
 */
@Stateless
public class OrclasseRefGroupeDao extends AbstractJpaDAO<OrclasseRefGroupe> {

    private static final long serialVersionUID = 1L;
    @PersistenceContext(unitName = AbstractJpaDAO.PersistanceUnit)
    private EntityManager em;

    @Override
    protected Class<OrclasseRefGroupe> getEntityClass() {
        return OrclasseRefGroupe.class; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected EntityManager getEntityManager() {
        return em; //To change body of generated methods, choose Tools | Templates.
    }

    public List<String> getReferenceGroupByLibelleithFilters(String Filter) {

        Map<String, Object> param = new HashMap<>();

        Query q = null;

        //si le filtre existe
        String request = "SELECT g.libelle FROM OrclasseRefGroupe g  WHERE";
//        Query q;
        if (Filter != null && !Filter.trim().equals("")) {
            request += "  g.libelle like :filter ";

            q = em.createQuery(request)
                    .setParameter("filter", "%" + Filter + "%");

        }

        return q.getResultList();

    }

    public BigInteger getlastNumeroOrder() {
        Query q;
        q = em.createQuery("SELECT rg.numero_ordre from OrclasseRefGroupe rg WHERE rg.id=(SELECT MAX(r.id) from OrclasseRefGroupe r)");
        if (q.getResultList().isEmpty()) {
            return BigInteger.ZERO;
        }
        return (BigInteger) q.getResultList().toArray()[0];
    }

}
