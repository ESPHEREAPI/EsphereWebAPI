/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import modele.OrclassBranches;
import modele.OrclassCategories;
import modele.OrclassEntreprises;

/**
 *
 * @author hp
 */
@Stateless
public class OrclassCategoriesDao extends AbstractJpaDAO<OrclassCategories> {

    private static final long serialVersionUID = 1L;
    @PersistenceContext(unitName = AbstractJpaDAO.PersistanceUnit)
    private EntityManager em;

    @Override
    protected Class<OrclassCategories> getEntityClass() {
        return OrclassCategories.class;

    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public List<OrclassCategories> getAllCategorieByEntreprise(OrclassEntreprises e) {
        Query q;
        q = em.createQuery("SELECT c FROM OrclassCategories c WHERE c.idEntreprise.idEntreprise= :idEntreprise")
                .setParameter("idEntreprise", e.getIdEntreprise());
        return q.getResultList();
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    /*
    liste tous les Categories visible par tous les companies
     */
    public List<OrclassCategories> listAllCategoriesShowAllCompagnie() {
        Query q;
        q = em.createQuery("SELECT cat from OrclassCategories cat WHERE cat.showAllCompagnies= :value  and cat.idEntreprise IS NULL ")
                .setParameter("value", Boolean.TRUE);
        return q.getResultList();
    }

    /*
    lister tous les Categories pour une compagn,is precis
     */
    public List<OrclassCategories> listAllCategorieByCompagnie(OrclassEntreprises e) {
        Query q;
        q = em.createQuery("SELECT cat from OrclassCategories cat WHERE cat.showAllCompagnies= :value  and cat.idEntreprise= :e ")
                .setParameter("value", Boolean.FALSE)
                .setParameter("e", e);
        return q.getResultList();
    }

    public List<OrclassCategories> listAllCategoriesIsHaveElementsCategorie(OrclassEntreprises e) {
        Query q;
        q = em.createQuery("SELECT ets.idCategories  from  OrclassElt_Categorie_Compagnie ets  WHERE ets.idEntreprise.idEntreprise= :idEntreprise")
                .setParameter("idEntreprise", e.getIdEntreprise());
        return q.getResultList();
    }

    /*
    liste les produits pour une branche precise
     */
    public List<OrclassCategories> listeCategorieByBranche(OrclassBranches br, OrclassEntreprises e) {
        Query q;
        Query q2;
        List<OrclassCategories> listCategoriesByBranche = new ArrayList<>();
        q = em.createQuery("SELECT c FROM  OrclassCategories c WHERE c.idBranche.idBranche= :idBranche AND c.idEntreprise.idEntreprise= :idEntreprise")
                .setParameter("idBranche", br.getIdBranche())
                .setParameter("idEntreprise", e.getIdEntreprise());
        if (!q.getResultList().isEmpty()) {
            listCategoriesByBranche = q.getResultList();
        }
        q2 = em.createQuery("SELECT c FROM  OrclassCategories c WHERE c.idBranche.idBranche= :idBranche AND c.showAllCompagnies= :valeur and c.idEntreprise  IS NULL")
                .setParameter("idBranche", br.getIdBranche())
                .setParameter("valeur", Boolean.TRUE);
        if (!q2.getResultList().isEmpty()) {
            listCategoriesByBranche.addAll(q2.getResultList());
        }
        return listCategoriesByBranche;
    }

    /*
    lister les cartegories d une branche etant creer par le system et vu par toutes les compagnies
     */
    public List<OrclassCategories> listeCategorieByBrancheCreateBySysteme(OrclassBranches br) {
        Query q;
        q = em.createQuery("SELECT c FROM  OrclassCategories c WHERE c.idBranche.idBranche= :idBranche AND c.showAllCompagnies= :valeur and c.idEntreprise is null")
                .setParameter("idBranche", br.getIdBranche())
                .setParameter("valeur", Boolean.TRUE);
        return q.getResultList();
    }

    public List<OrclassCategories> allCategoriesHaveCodePrincipalNull() {
        Query q;
        q = em.createQuery("SELECT c FROM OrclassCategories c where c.codePrincipal is null");
        return q.getResultList();

    }

    public List<OrclassCategories> listeCategorieByBrancheHaveQuittance(OrclassBranches br, OrclassEntreprises e, Date debut, Date fin) {
        Query q;
        q = em.createQuery("SELECT DISTINCT q.idPolice.idCategories FROM OrclassQuitance q WHERE q.idEntreprise= :e and q.idPolice.idCategories.idBranche= :br and q.idPolice.date_effet BETWEEN :debut and :fin")
                .setParameter("e", e)
                .setParameter("br", br)
                .setParameter("fin", fin)
                .setParameter("debut", debut);
        return q.getResultList();
    }
    
    public List<OrclassCategories> listeCategorieByBrancheHaveQuittance( OrclassEntreprises e, Date debut, Date fin,BigInteger codePrincipal_1,BigInteger codePrincipal_2) {
        Query q;
        q = em.createQuery("SELECT DISTINCT q.idPolice.idCategories FROM OrclassQuitance q WHERE q.idEntreprise= :e  and q.idPolice.date_effet BETWEEN :debut and :fin and q.idPolice.idCategories.idBranche.codePrincipal BETWEEN :codePrincipal_1 and :codePrincipal_2")
                .setParameter("e", e)
//                .setParameter("br", br)
                .setParameter("fin", fin)
                .setParameter("debut", debut)
                .setParameter("codePrincipal_1", codePrincipal_1)
                .setParameter("codePrincipal_2", codePrincipal_2)
                ;
        return q.getResultList();
    }
    
    public List<OrclassCategories> listeCategorieByChoixPersonnaliser( OrclassEntreprises e, Date debut, Date fin,BigInteger codePrincipal_1,BigInteger codePrincipal_2) {
        Query q;
        q = em.createQuery("SELECT DISTINCT q.idPolice.idCategories FROM OrclassQuitance q WHERE q.idEntreprise= :e  and q.idPolice.date_effet BETWEEN :debut and :fin and q.idPolice.idCategories.codePrincipal BETWEEN :codePrincipal_1 and :codePrincipal_2")
                .setParameter("e", e)
//                .setParameter("br", br)
                .setParameter("fin", fin)
                .setParameter("debut", debut)
                .setParameter("codePrincipal_1", codePrincipal_1)
                .setParameter("codePrincipal_2", codePrincipal_2)
                ;
        return q.getResultList();
    }
}
