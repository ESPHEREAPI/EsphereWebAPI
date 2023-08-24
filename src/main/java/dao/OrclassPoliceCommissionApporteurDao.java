/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import modele.OrclassApporteur;
import modele.OrclassEntreprises;
import modele.OrclassPolice;
//import modele.OrclassPolicesss;
import modele.OrclassPoliceCommissionApporteur;

/**
 *
 * @author hp
 */
@Stateless
public class OrclassPoliceCommissionApporteurDao extends AbstractJpaDAO<OrclassPoliceCommissionApporteur>{
      private static final long serialVersionUID = 1L;
    @PersistenceContext(unitName = AbstractJpaDAO.PersistanceUnit)
    private EntityManager em;

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    protected Class<OrclassPoliceCommissionApporteur> getEntityClass() {
       return OrclassPoliceCommissionApporteur.class;
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    public OrclassPoliceCommissionApporteur findKey(OrclassPolice p,OrclassApporteur ap,OrclassEntreprises e){
        Query q = null;
      q=  em.createQuery("SELECT pca FROM OrclassPoliceCommissionApporteur pca WHERE pca.idEntreprise.idEntreprise= :idEntreprise and pca.idPolice= :p and pca.idCommission_Prime_ApporteurCommission_Prime_Apporteur.idApporteur= :idApporteur")
                .setParameter("idEntreprise", e.getIdEntreprise())
                .setParameter("p", p)
                .setParameter("idApporteur", ap.getIdApporteur());
        if (q.getResultList().isEmpty()) {
           return null;
        }
         return (OrclassPoliceCommissionApporteur) q.getResultList().toArray()[0];
    }
}
