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
import modele.OrclassGroupCaracteristiqueGarantie;
import modele.OrclassGroupPlafondPrestation;
import modele.OrclasseRefGroupe;

/**
 *
 * @author JIATOU FRANCK
 */
@Stateless
public class OrclassGroupPlafondPrestationDao extends AbstractJpaDAO<OrclassGroupPlafondPrestation> {

    private static final long serialVersionUID = 1L;
  
  @PersistenceContext(unitName = "ESpherePU")
  private EntityManager em;
    @Override
    protected Class<OrclassGroupPlafondPrestation> getEntityClass() {
       return OrclassGroupPlafondPrestation.class;
    }

    @Override
    protected EntityManager getEntityManager() {
      return em;
    }
    
      // selecte liste by Group Compagny
    public  List <OrclassGroupPlafondPrestation> listeGroupePlafondPrestation(OrclassEntreprises e,OrclasseRefGroupe g){
      Query q;
      q=em.createQuery("SELECT gpp FROM OrclassGroupPlafondPrestation gpp WHERE gpp.idGroup= :g and gpp.idEntreprise= :e")
              .setParameter("e", e)
              .setParameter("g", g)
              ;
     return q.getResultList();
    }


    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
