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
import modele.OrclassEntreprises;
import modele.OrclassGestionCompagnieAgence;
import modele.OrclassGestionStockAgence;
import modele.OrclassIntermediaires;
import modele.OrclassNatureDocument;
import modele.OrclassOperationStock;
import modele.OrclassTypeDocument;

/**
 *
 * @author JIATOU FRANCK
 */
@Stateless
public class OrclassGestionStockAgenceDao extends AbstractJpaDAO<OrclassGestionStockAgence> {

    private static final long serialVersionUID = 1L;
    @PersistenceContext(unitName = AbstractJpaDAO.PersistanceUnit)
    private EntityManager em;

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @Override
    protected Class<OrclassGestionStockAgence> getEntityClass() {
        return OrclassGestionStockAgence.class;
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    /*
    recupera de la dernier ligne gestion compagnie agence dans gestion stock agent
     */
    public OrclassGestionStockAgence lasteStockAgenceByGestionCompagnieAgence(OrclassEntreprises e, OrclassGestionCompagnieAgence gcag) {
        Query q;
        q = em.createQuery("SELECT g FROM OrclassGestionStockAgence g WHERE g.id=(SELECT max(gc.id) FROM OrclassGestionStockAgence gc where gc.idEntreprise= :e and gc.idGestionCompagnieAgence= :gca")
                .setParameter("e", e)
                .setParameter("gca", gcag);
        if (q.getResultList().isEmpty()) {
            return null;
        }
        return (OrclassGestionStockAgence) q.getResultList().toArray()[0];
    }
    
    /*
    verification d une ligne d ecriture dans la gestion des stock agence pour agence
    */
 public OrclassGestionStockAgence finKey(OrclassEntreprises e,OrclassGestionCompagnieAgence gcag,Date effet,OrclassOperationStock op,OrclassNatureDocument ndoc,OrclassTypeDocument tdoc,OrclassIntermediaires agence){
    Query q;
    q=em.createQuery("SELECT g FROM OrclassGestionStockAgence g where g.idEntreprise= :e and g.idGestionCompagnieAgence= :cg and g.dateEffet= :effet and g.idNatureDocument= :nd and g.idTypeDocument= td and g.idOperationStock= :op and g.idIntermediaire= :ag ")
            .setParameter("e", e)
            .setParameter("cg", gcag)
             .setParameter("effet", effet)
             .setParameter("nd", ndoc)
             .setParameter("td", tdoc)
             .setParameter("op", op)
             .setParameter("ag", agence);
     if (q.getResultList().isEmpty()) {
         return null;
     }
     return (OrclassGestionStockAgence) q.getResultList().toArray()[0];
 }
 /*
 liste operation de gestion agence par agence
 */
 public List<OrclassGestionStockAgence>listeGestionAgenceByAgenceForCompagnie(OrclassEntreprises e){
  Query q;   
  q=em.createQuery("SELECT g FROM  OrclassGestionStockAgence g WHERE g.idEntreprise= :e")
          .setParameter("e", e);
  return q.getResultList();
 }
 //verification de l existance du numero du papier par raport au document concernant la categories
  public OrclassGestionStockAgence testExistantNumeroByAgence(OrclassEntreprises e ,OrclassNatureDocument ndoc,OrclassTypeDocument tdoc,OrclassIntermediaires agence){
    Query q;
    OrclassGestionStockAgence gsag=null;
    q=em.createQuery("SELECT gsa FROM OrclassGestionStockAgence gsa WHERE id=(SELECT max(g.id) FROM OrclassGestionStockAgence g where g.idEntreprise= :e and g.idNatureDocument= :nd and g.idTypeDocument= td and  g.idIntermediaire= :ag)  ")
            .setParameter("e", e)
     
             .setParameter("nd", ndoc)
             .setParameter("td", tdoc)
        
             .setParameter("ag", agence);
     if (q.getResultList().isEmpty()) {
         return null;
     }
   return (OrclassGestionStockAgence) q.getResultList().toArray()[0];
      
 
     
 }
}
