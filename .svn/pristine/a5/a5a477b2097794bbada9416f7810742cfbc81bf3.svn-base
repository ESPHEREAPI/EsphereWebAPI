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
import modele.OrclassFamillePrestation;
import modele.OrclassGarantie;
import modele.OrclassRubrique;
import modele.OrclassRubriqueCategorie;
import modele.OrclassTypeTarif;

/**
 *
 * @author hp
 */
@Stateless
public class OrclassRubriqueCategorieDao extends AbstractJpaDAO<OrclassRubriqueCategorie> {

    private static final long serialVersionUID = 1L;
    @PersistenceContext(unitName = AbstractJpaDAO.PersistanceUnit)
    private EntityManager em;

    {

        // Add business logic below. (Right-click in editor and choose
        // "Insert Code > Add Business Method")
    }

    @Override
    protected Class<OrclassRubriqueCategorie> getEntityClass() {
        return OrclassRubriqueCategorie.class;
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    /*
    liste les rubrique consernant une categorie precise
     */
    public List<OrclassRubriqueCategorie> OrclassRubriqueCategorieDao(OrclassCategories cat, OrclassEntreprises e) {
        Query q;
        q = em.createQuery("SELECT rc  FROM OrclassRubriqueCategorie rc WHERE rc.idEntreprise.idEntreprise= :idEntreprise AND rc.idCategories.idCategorie= :idCategorie")
                .setParameter("idCategorie", cat.getIdCategorie())
                .setParameter("idEntreprise", e.getIdEntreprise());
        return q.getResultList();

    }

    public List<OrclassRubrique> OrclassRubriqueByCategorieDao(OrclassCategories cat, OrclassEntreprises e) {
        Query q;
        q = em.createQuery("SELECT rc.idRubrique  FROM OrclassRubriqueCategorie rc WHERE rc.idEntreprise.idEntreprise= :idEntreprise AND rc.idCategories.idCategorie= :idCategorie")
                .setParameter("idCategorie", cat.getIdCategorie())
                .setParameter("idEntreprise", e.getIdEntreprise());
        return q.getResultList();

    }

    public OrclassRubriqueCategorie OrclassRubriqueCategorieDao(OrclassCategories cat, OrclassRubrique r, OrclassEntreprises e) {
        Query q;
        q = em.createQuery("SELECT rc  FROM OrclassRubriqueCategorie rc WHERE rc.idEntreprise.idEntreprise= :idEntreprise AND rc.idCategories.idCategorie= :idCategorie and rc.idRubrique.id= :idRubrique")
                .setParameter("idCategorie", cat.getIdCategorie())
                .setParameter("idRubrique", r.getId())
                .setParameter("idEntreprise", e.getIdEntreprise());
        if (q.getResultList().isEmpty()) {
            return null;
        }
        return (OrclassRubriqueCategorie) q.getResultList().toArray()[0];

    }

    public List<OrclassCategories> listCategorieHaveRubrique(OrclassEntreprises e) {
        Query q;
        q = em.createQuery("SELECT DISTINCT rc.idCategories  FROM OrclassRubriqueCategorie rc WHERE rc.idEntreprise.idEntreprise= :idEntreprise ")
                //                .setParameter("idCategorie", cat.getIdCategorie())
                .setParameter("idEntreprise", e.getIdEntreprise());
        return q.getResultList();

    }
   
}
