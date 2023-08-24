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
import modele.OrclassEntreprises;
import modele.OrclassIntermediaires;
import modele.OrclassSuspensionBrancheIntemediaire;
import modele.OrclassSuspensionCategorieIntermediaire;

/**
 *
 * @author hp
 */
@Stateless
public class OrclassSuspensionCategorieIntermediaireDao extends AbstractJpaDAO<OrclassSuspensionCategorieIntermediaire>{
    
 private static final long serialVersionUID = 1L;
    @PersistenceContext(unitName = AbstractJpaDAO.PersistanceUnit)
    private EntityManager em;
    @Override
    protected Class<OrclassSuspensionCategorieIntermediaire> getEntityClass() {
       return OrclassSuspensionCategorieIntermediaire.class;
    }

    @Override
    protected EntityManager getEntityManager() {
     return em;
    }
    
  /*
    lister les categories suspendue pour un intermeiare d une compagnie precis
     */
    public List<OrclassCategories> listeBrancheSuspendueForIntermediaire(OrclassIntermediaires agence, OrclassEntreprises e) {
        Query q;
        q = em.createQuery("SELECT s.idCategories FROM OrclassSuspensionCategorieIntermediaire s WHERE s.idIntermediaire.idIntermediaire= :idIntermediaire AND s.idEntreprise.idEntreprise= :idEntreprise")
                .setParameter("idIntermediaire", agence.getIdIntermediaire())
                .setParameter("idEntreprise", e.getIdEntreprise());
        return q.getResultList();

    }
     public List<OrclassCategories> listeBrancheSuspendueForIntermediaire(OrclassIntermediaires agence, OrclassEntreprises e,OrclassBranches br) {
        Query q;
        q = em.createQuery("SELECT s.idCategories FROM OrclassSuspensionCategorieIntermediaire s WHERE s.idIntermediaire.idIntermediaire= :idIntermediaire AND s.idEntreprise.idEntreprise= :idEntreprise and s.idCategories.idBranche.idBranche= :idBranche")
                .setParameter("idIntermediaire", agence.getIdIntermediaire())
                .setParameter("idBranche", br.getIdBranche())
                .setParameter("idEntreprise", e.getIdEntreprise());
        return q.getResultList();

    }
    
    /*
    fonctionnalite  pour teste l unicite de l entite SuspensionCategoriesIntemediaire
    */
    public OrclassSuspensionCategorieIntermediaire finKey(OrclassIntermediaires agence, OrclassEntreprises e,OrclassCategories cat){
        Query q;
        q=em.createQuery("SELECT s FROM OrclassSuspensionCategorieIntermediaire s WHERE s.idCategories.idCategorie= :idCategorie AND s.idEntreprise.idEntreprise= :idEntreprise and s.idIntermediaire.idIntermediaire= :idIntermediaire")
                .setParameter("idCategorie", cat.getIdCategorie())
               .setParameter("idEntreprise", e.getIdEntreprise())
                .setParameter("idIntermediaire", agence.getIdIntermediaire());
        if (q.getResultList().isEmpty()) {
            return null;
        }
        return (OrclassSuspensionCategorieIntermediaire) q.getResultList().toArray()[0];
    }
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
