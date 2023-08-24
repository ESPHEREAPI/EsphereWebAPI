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
import modele.OrclassPolice;
import modele.OrclassPrestation;
import modele.OrclassRubriqueCategorie;
import modele.OrclasseRefGroupe;

/**
 *
 * @author hp
 */
@Stateless
public class OrclassPrestationDao extends AbstractJpaDAO<OrclassPrestation> {

    private static final long serialVersionUID = 1L;
    @PersistenceContext(unitName = AbstractJpaDAO.PersistanceUnit)
    private EntityManager em;

    @Override
    protected Class<OrclassPrestation> getEntityClass() {
        return OrclassPrestation.class;
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    /*
    lister  les prestations pour une compagnie precis
     */
    public List<OrclassPrestation> listePrestationByCompagnie(OrclassEntreprises e) {
        Query q;
        q = em.createQuery("SELECT p FROM  OrclassPrestation p WHERE p.idEntreprise.idEntreprise= :idEntreprise and p.showAllCompagnies= :valeur")
                .setParameter("idEntreprise", e.getIdEntreprise())
                .setParameter("valeur",Boolean.FALSE)
                ;
        return q.getResultList();
    }
    
     public List<OrclassPrestation> listePrestationForAllCompagnie() {
        Query q;
        q = em.createQuery("SELECT p FROM  OrclassPrestation p WHERE  p.showAllCompagnies= :valeur and p.idEntreprise is null")
                
                .setParameter("valeur",Boolean.TRUE)
                ;
        return q.getResultList();
    }

    /*
    liste les prestation n existant pas dans rubrique prestation
     */
    public List<OrclassPrestation> listePrestationtNotExisteForRubriquePrestation(OrclassRubriqueCategorie rc, OrclassEntreprises e) {
        Query q;
        q = em.createQuery("SELECT rp.idPrestation FROM OrclassRubriquePrestation rp WHERE  NOT EXISTS  (SELECT dp.idPrestation From OrclassDetailPolicePlafond dp where rp.idPrestation = dp.idPrestation and dp.idEntreprise.idEntreprise= :idEntreprise and dp.idPolicePlafond.idPolice.idCategories.idCategorie= :idRubriqueCategorie and dp.idGroup is null)")
                .setParameter("idRubriqueCategorie", rc.getIdCategories().getIdCategorie())
                .setParameter("idEntreprise", e.getIdEntreprise());
        return q.getResultList();
    }
    
    /*
    liste les prestation n ayant pas de rubrique
    */
    public List<OrclassPrestation> listePrestationtNaotHaveRubrique(OrclassRubriqueCategorie rc, OrclassEntreprises e) {
        Query q;
        q = em.createQuery("SELECT p FROM OrclassPrestation p WHERE  NOT EXISTS  (SELECT rp.idPrestation From OrclassRubriquePrestation rp  where rp.idPrestation = p and rp.idEntreprise.idEntreprise= :idEntreprise and rp.idRubriqueCategorie.id= :idRp)")
                .setParameter("idRp", rc.getId())
                .setParameter("idEntreprise", e.getIdEntreprise());
        return q.getResultList();
    }
    
    /*
    selection tous les prestation pour une rubrique categorie
    */
     public List<OrclassPrestation> listePrestationByCompagnie(OrclassRubriqueCategorie rc,OrclassEntreprises e) {
        Query q;
        q = em.createQuery("SELECT p.idPrestation FROM  OrclassRubriquePrestation p WHERE p.idEntreprise.idEntreprise= :idEntreprise AND p.idRubriqueCategorie.id= :id")
                .setParameter("idEntreprise", e.getIdEntreprise())
                .setParameter("id", rc.getId())
                ;
        return q.getResultList();
    }
      public List<OrclassPrestation> listePrestationByCompagnie(OrclassEntreprises e,OrclassPolice p,OrclasseRefGroupe group) {
        Query q;
        q = em.createQuery("SELECT  DISTINCT p.idPrestation FROM  OrclassRubriquePrestation p WHERE NOT EXISTS (select Distinct pp.idPrestation from OrclassDetailPolicePlafond pp where pp.idPrestation=p.idPrestation and pp.idPolicePlafond.idPolice= :p and pp.idEntreprise= :e and pp.idGroup= :g)")
                .setParameter("e", e)
                .setParameter("p", p)
                .setParameter("g", group)
                ;
        return q.getResultList();
    }
      public List<OrclassPrestation> listePrestationByCompagnieNotHaveGroupe(OrclassEntreprises e,OrclassPolice p) {
        Query q;
        q = em.createQuery("SELECT  DISTINCT p.idPrestation FROM  OrclassRubriquePrestation p WHERE NOT EXISTS (select Distinct pp.idPrestation from OrclassDetailPolicePlafond pp where pp.idPrestation=p.idPrestation and pp.idPolicePlafond.idPolice= :p and pp.idEntreprise= :e)")
                .setParameter("e", e)
                .setParameter("p", p)
//                .setParameter("g", group)
                ;
        return q.getResultList();
    }
     
     //liste des prestations n ayant pas encore ete affecter detailPolicePrestaion
     
      public List<OrclassPrestation> listePrestationByCompagnieNotHavePolicePlafond(OrclassRubriqueCategorie rc,OrclassEntreprises e,OrclassPolice police) {
        Query q;
        q = em.createQuery("SELECT DISTINCT p.idPrestation FROM  OrclassRubriquePrestation p WHERE NOT EXISTS (SELECT DISTINCT dp.idPrestation FROM OrclassDetailPolicePlafond dp where dp.idRubrique= :rub and dp.idEntreprise= :e and dp.idPolicePlafond.idPolice= :police and dp.idPrestation=p.idPrestation )")
                .setParameter("e", e)
                .setParameter("police", police)
                 .setParameter("rub", rc.getIdRubrique())
                ;
        return q.getResultList();
    }
      public List<OrclassPrestation> listePrestationByCompagnieNotHavePolicePlafond(OrclassRubriqueCategorie rc,OrclassEntreprises e,OrclassPolice police,OrclasseRefGroupe g) {
        Query q;
        q = em.createQuery("SELECT DISTINCT p.idPrestation FROM  OrclassRubriquePrestation p WHERE NOT EXISTS (SELECT DISTINCT dp.idPrestation FROM OrclassDetailPolicePlafond dp where dp.idRubrique= :rub and dp.idEntreprise= :e and dp.idPolicePlafond.idPolice= :police and dp.idPrestation=p.idPrestation and dp.idGroup= :idg)")
                .setParameter("e", e)
                 .setParameter("idg", g)
                .setParameter("police", police)
                 .setParameter("rub", rc.getIdRubrique())
                ;
        return q.getResultList();
    }
}
