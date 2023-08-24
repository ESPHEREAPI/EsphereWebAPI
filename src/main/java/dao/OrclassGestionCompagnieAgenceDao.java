/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import modele.OrclassEntreprises;
import modele.OrclassGestionCompagnieAgence;
import modele.OrclassGestionStockCompagnie;
import modele.OrclassIntermediaires;
import modele.OrclassNatureDocument;
import modele.OrclassOperationStock;
import modele.OrclassTypeDocument;

/**
 *
 * @author JIATOU FRANCK
 */
@Stateless
public class OrclassGestionCompagnieAgenceDao extends AbstractJpaDAO<OrclassGestionCompagnieAgence> {

    private static final long serialVersionUID = 1L;
    @PersistenceContext(unitName = AbstractJpaDAO.PersistanceUnit)
    private EntityManager em;

    @Override
    protected Class<OrclassGestionCompagnieAgence> getEntityClass() {
        return OrclassGestionCompagnieAgence.class;
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    /*
    recupera de la dernier ligne gestion compagnie agence dans gestion stock agent
     */
    public OrclassGestionCompagnieAgence lasteStockCompagnieAgence(OrclassEntreprises e, OrclassGestionStockCompagnie gsc, OrclassOperationStock op, OrclassNatureDocument ndoc, OrclassTypeDocument tdoc,OrclassIntermediaires agence) {
        Query q;
        q = em.createQuery("SELECT g FROM OrclassGestionCompagnieAgence g WHERE g.id=(SELECT max(gc.id) FROM OrclassGestionCompagnieAgence gc where gc.idEntreprise= :e and gc.idGestionStockCompagnie= :gsc and gc.idIntermediaire= :ag and gc.idNatureDocument= :nd and gc.idOperationStock= :op and gc.idTypeDocument= :td)")
                .setParameter("e", e)
                .setParameter("nd", ndoc)
                .setParameter("op", op)
                .setParameter("td", tdoc)
                .setParameter("ag", agence)
                .setParameter("gsc", gsc);
        if (q.getResultList().isEmpty()) {
            return null;
        }
        return (OrclassGestionCompagnieAgence) q.getResultList().toArray()[0];
    }

    /*
    verification d une ligne d ecriture dans la gestion des stock agence pour agence
     */
    public OrclassGestionCompagnieAgence finKey(OrclassEntreprises e, OrclassGestionStockCompagnie gcag, Date effet, OrclassOperationStock op, OrclassNatureDocument ndoc, OrclassTypeDocument tdoc, OrclassIntermediaires agence) {
        Query q;
        q = em.createQuery("SELECT g FROM OrclassGestionCompagnieAgence g where g.idEntreprise= :e and g.idGestionStockCompagnie= :cg and g.dateEffet= :effet and g.idNatureDocument= :nd and g.idTypeDocument= :td and g.idOperationStock= :op and g.idIntermediaire= :ag ")
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
        return (OrclassGestionCompagnieAgence) q.getResultList().toArray()[0];
    }

    /*
 liste operation de gestion agence par agence
     */
    public List<OrclassGestionCompagnieAgence> listeGestionCompagnieByAgence(OrclassEntreprises e) {
        Query q;
        q = em.createQuery("SELECT g FROM  OrclassGestionCompagnieAgence g WHERE g.idEntreprise= :e")
                .setParameter("e", e);
        return q.getResultList();
    }
    //verification de l existance du numero du papier par raport au document concernant la categories
 public OrclassGestionCompagnieAgence lasteStockCompagnieAgence(OrclassEntreprises e, OrclassNatureDocument ndoc, OrclassTypeDocument tdoc,OrclassIntermediaires agence) {
        Query q;
        q = em.createQuery("SELECT g FROM OrclassGestionCompagnieAgence g WHERE g.id=(SELECT max(gc.id) FROM OrclassGestionCompagnieAgence gc where gc.idEntreprise= :e and  gc.idIntermediaire= :ag and gc.idNatureDocument= :nd  and gc.idTypeDocument= :td)")
                .setParameter("e", e)
                .setParameter("nd", ndoc)
             
                .setParameter("td", tdoc)
                .setParameter("ag", agence)
               
                ;
        if (q.getResultList().isEmpty()) {
            return null;
        }
        return (OrclassGestionCompagnieAgence) q.getResultList().toArray()[0];
    }
}
