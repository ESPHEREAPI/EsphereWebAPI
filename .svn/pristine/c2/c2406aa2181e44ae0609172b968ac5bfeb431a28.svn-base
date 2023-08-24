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
import modele.OrclassFamillePrestation;

/**
 *
 * @author hp
 */
@Stateless
public class OrclassFamillePrestationDao extends AbstractJpaDAO<OrclassFamillePrestation> {
      private static final long serialVersionUID = 1L;
    @PersistenceContext(unitName = AbstractJpaDAO.PersistanceUnit)
    private EntityManager em;

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    protected Class<OrclassFamillePrestation> getEntityClass() {
     return OrclassFamillePrestation.class;
    }

    @Override
    protected EntityManager getEntityManager() {
      return em;
    }
    /*
    lister les familles de prestation pour un compagnie precis
    */
    
    public List<OrclassFamillePrestation> listeFamillePrestationByCompagnie(OrclassEntreprises e){
        Query q;
        q=em.createQuery("SELECT f FROM OrclassFamillePrestation f where f.idEntreprise.idEntreprise= :idEntreprise AND f.showAllCompagnies= :valeur")
                .setParameter("idEntreprise", e.getIdEntreprise())
                .setParameter("valeur", Boolean.FALSE)
                ;
        return q.getResultList();
    }
    
    public List<OrclassFamillePrestation> listeFamillePrestationForAllCompagnie(){
        Query q;
        q=em.createQuery("SELECT f FROM OrclassFamillePrestation f where f.showAllCompagnies= :valeur and f.idEntreprise is null")
         
                .setParameter("valeur", Boolean.TRUE)
                ;
        return q.getResultList();
    }
}
