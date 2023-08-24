/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import enums.LibelleBranche;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import modele.OrclassCategories;
import modele.OrclassEntreprises;
import modele.OrclassPrestation;
import modele.OrclassRubriqueCategorie;
import modele.OrclassRubriquePrestation;

/**
 *
 * @author hp
 */
@Stateless
public class OrclassRubriquePrestationDao extends AbstractJpaDAO<OrclassRubriquePrestation> {

    private static final long serialVersionUID = 1L;
    @PersistenceContext(unitName = AbstractJpaDAO.PersistanceUnit)
    private EntityManager em;

    @Override
    protected Class<OrclassRubriquePrestation> getEntityClass() {
        return OrclassRubriquePrestation.class;
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    /*
    recupere une ligne iddentitaire pour teste l existance
     */
    public OrclassRubriquePrestation finKey(OrclassRubriqueCategorie rc, OrclassPrestation p, OrclassEntreprises e) {
        Query q;
        q = em.createQuery("SELECT rp FROM OrclassRubriquePrestation rp WHERE rp.idRubriqueCategorie.id= :idRubriqueCategorie and rp.idPrestation.id= :idPrestation and rp.idEntreprise.idEntreprise= :idEntreprise")
                .setParameter("idEntreprise", e.getIdEntreprise())
                .setParameter("idRubriqueCategorie", rc.getId())
                .setParameter("idPrestation", p.getId());
        if (q.getResultList().isEmpty()) {
            return null;
        }
        return (OrclassRubriquePrestation) q.getResultList().toArray()[0];
    }

    public List<OrclassRubriquePrestation> listeRubriPrestationByRubriqueCategorie(OrclassRubriqueCategorie rc, OrclassEntreprises e) {
        Query q;
        q = em.createQuery("SELECT rp FROM OrclassRubriquePrestation rp WHERE rp.idRubriqueCategorie.id= :idRubriqueCategorie and  rp.idEntreprise.idEntreprise= :idEntreprise")
                .setParameter("idEntreprise", e.getIdEntreprise())
                .setParameter("idRubriqueCategorie", rc.getId());
        return q.getResultList();
    }
    /*
    liste les categories pour la branche sante
    */
    
     public List<OrclassCategories> listeCategorieSanteByCompagnies(OrclassEntreprises e) {
        Query q;
        q = em.createQuery("SELECT distinct rp.idRubriqueCategorie.idCategories FROM OrclassRubriquePrestation rp WHERE   rp.idEntreprise.idEntreprise= :idEntreprise and rp.idRubriqueCategorie.idCategories.idBranche.libelle= :sante")
                .setParameter("idEntreprise", e.getIdEntreprise())
                .setParameter("sante", LibelleBranche.sante);
        return q.getResultList();
    }
     
      public List<OrclassRubriquePrestation> listeRubriPrestationByCategorie(OrclassCategories cat, OrclassEntreprises e) {
        Query q;
        q = em.createQuery("SELECT rp FROM OrclassRubriquePrestation rp WHERE rp.idRubriqueCategorie.idCategories.idCategorie= :idCategorie and  rp.idEntreprise.idEntreprise= :idEntreprise")
                .setParameter("idEntreprise", e.getIdEntreprise())
                .setParameter("idCategorie", cat.getIdCategorie());
        return q.getResultList();
    }
}
