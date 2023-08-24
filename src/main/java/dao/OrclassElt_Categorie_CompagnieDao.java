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
import modele.OrclassBranches;
import modele.OrclassCategories;
import modele.OrclassElt_Categorie_Compagnie;
import modele.OrclassEntreprises;
import modele.OrclassRegistreProduction;
import modele.OrclassRegistreSinistre;

/**
 *
 * @author hp
 */
@Stateless
public class OrclassElt_Categorie_CompagnieDao extends AbstractJpaDAO<OrclassElt_Categorie_Compagnie> {

    private static final long serialVersionUID = 1L;
    @PersistenceContext(unitName = AbstractJpaDAO.PersistanceUnit)
    private EntityManager em;

    @Override
    protected Class<OrclassElt_Categorie_Compagnie> getEntityClass() {
        return OrclassElt_Categorie_Compagnie.class;
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public OrclassElt_Categorie_Compagnie finkey(OrclassCategories cat, OrclassEntreprises e) {
        Query q;
        q = em.createQuery("SELECT ets FROM OrclassElt_Categorie_Compagnie ets WHERE ets.idEntreprise.idEntreprise = :e and ets.idCategories.idCategorie= :idCategorie")
                .setParameter("e", e.getIdEntreprise())
                .setParameter("idCategorie", cat.getIdCategorie());
        if (q.getResultList()==null || q.getResultList().isEmpty()) {
            return null;
        }
        return (OrclassElt_Categorie_Compagnie) q.getResultList().toArray()[0];
    }

    public OrclassElt_Categorie_Compagnie finkey(OrclassRegistreProduction pr, OrclassEntreprises e) {
        Query q;
        q = em.createQuery("SELECT ets FROM OrclassElt_Categorie_Compagnie ets WHERE ets.idEntreprise.idEntreprise = :e and ets.idRegistreProduction.id= :idCategorie")
                .setParameter("e", e.getIdEntreprise())
                .setParameter("idCategorie", pr.getId());
        if (q.getResultList().isEmpty()) {
            return null;
        }
        return (OrclassElt_Categorie_Compagnie) q.getResultList().toArray()[0];
    }

    public OrclassElt_Categorie_Compagnie finkeyForRegistreSinistre(OrclassRegistreSinistre rs, OrclassEntreprises e) {
        Query q;
        q = em.createQuery("SELECT ets FROM OrclassElt_Categorie_Compagnie ets WHERE ets.idEntreprise.idEntreprise = :e and ets.idRegistreSinistre.Code= :code")
                .setParameter("e", e.getIdEntreprise())
                .setParameter("code", rs.getCode());
        if (q.getResultList().isEmpty()) {
            return null;
        }
        return (OrclassElt_Categorie_Compagnie) q.getResultList().toArray()[0];
    }

    /*
     lister les categories ayant deja un registre de production
     */
    public List<OrclassCategories> listeCategoriesHaveRegistreProductionByCompagnie(OrclassEntreprises e) {
        Query q;
        q = em.createQuery("SELECT e.idCategories FROM OrclassElt_Categorie_Compagnie e WHERE e.idEntreprise= :en and e.idRegistreProduction IS NOT NULL")
                .setParameter("en", e);
        return q.getResultList();
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    //lister tous les produits dune branche n ayant pas de registre
    public List<OrclassCategories> listeCategoriesNotHaveRegistreSinistre(OrclassEntreprises e, OrclassBranches br) {
        Query q;
        q = em.createQuery("SELECT c FROM OrclassCategories c where  not exists (SELECT e.idCategories FROM OrclassElt_Categorie_Compagnie e WHERE e.idCategories=c and  e.idEntreprise= :en and e.idRegistreSinistre is not null) and c.idBranche= :br")
                .setParameter("en", e)
                .setParameter("br", br);
        return q.getResultList();
    }
}
