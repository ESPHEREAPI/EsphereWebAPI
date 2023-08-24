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
public class OrclassGestionStockCompagnieDao extends AbstractJpaDAO<OrclassGestionStockCompagnie> {

    private static final long serialVersionUID = 1L;
    @PersistenceContext(unitName = AbstractJpaDAO.PersistanceUnit)
    private EntityManager em;
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    protected Class<OrclassGestionStockCompagnie> getEntityClass() {
        return OrclassGestionStockCompagnie.class;
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    /**
     * selection la derniere ligne de la gestion de stock compagnie
     */
//    public OrclassGestionStockCompagnie lastRowGestioCompagnie(OrclassEntreprises e) {
//        Query q;
//        q = em.createQuery("SELECT gc FROM OrclassGestionStockCompagnie gc where gc.id=(SELECT max(g.id) FROM OrclassGestionStockCompagnie g where g.idEntreprise= :e )")
//                .setParameter("e", e);
//        if (q.getResultList().isEmpty()) {
//            return null;
//        }
//        return (OrclassGestionStockCompagnie) q.getResultList().toArray()[0];
//    }
     public OrclassGestionStockCompagnie lastRowGestioCompagnie(OrclassEntreprises e,OrclassOperationStock op, OrclassNatureDocument ndoc, OrclassTypeDocument tdoc) {
        Query q;
        q = em.createQuery("SELECT gc FROM OrclassGestionStockCompagnie gc where gc.id=(SELECT max(g.id) FROM OrclassGestionStockCompagnie g where g.idEntreprise= :e  and g.idOperationStock= :op and g.idNatureDocument= :nd and g.idTypeDocument= :td)")
                .setParameter("e", e)
                .setParameter("op", op)
                .setParameter("nd", ndoc)
                .setParameter("td", tdoc)
                ;
        if (q.getResultList().isEmpty()) {
            return null;
        }
        return (OrclassGestionStockCompagnie) q.getResultList().toArray()[0];
    }
     /*
     cette fonction est appeler dans le cas d une affectation ne saurai inclut Operation puisque la reque se fait dans gestion Compagny et non dans gestion compagny agence 
     */
       public OrclassGestionStockCompagnie lastRowGestioCompagnie(OrclassEntreprises e, OrclassNatureDocument ndoc, OrclassTypeDocument tdoc) {
        Query q;
        q = em.createQuery("SELECT gc FROM OrclassGestionStockCompagnie gc where gc.id=(SELECT max(g.id) FROM OrclassGestionStockCompagnie g where g.idEntreprise= :e   and g.idNatureDocument= :nd and g.idTypeDocument= :td)")
                .setParameter("e", e)
//                .setParameter("op", op)
                .setParameter("nd", ndoc)
                .setParameter("td", tdoc)
                ;
        if (q.getResultList().isEmpty()) {
            return null;
        }
        return (OrclassGestionStockCompagnie) q.getResultList().toArray()[0];
    }

    /*
    verification d une ligne d enregistrement
     */
    public OrclassGestionStockCompagnie finKey(OrclassEntreprises e, Date effet, OrclassOperationStock op, OrclassNatureDocument ndoc, OrclassTypeDocument tdoc) {
        Query q;
        q = em.createQuery("SELECT g FROM OrclassGestionStockCompagnie g where g.idEntreprise= :e  and g.dateEffet= :effet and g.idNatureDocument= :nd and g.idTypeDocument= :td and g.idOperationStock= :op  ")
                .setParameter("e", e)
                .setParameter("effet", effet)
                .setParameter("nd", ndoc)
                .setParameter("td", tdoc)
                .setParameter("op", op);
        if (q.getResultList().isEmpty()) {
            return null;
        }
        return (OrclassGestionStockCompagnie) q.getResultList().toArray()[0];
    }

    public List<OrclassGestionStockCompagnie> listeGestionCompagnie(OrclassEntreprises e) {
        Query q;
        q = em.createQuery("SELECT g FROM  OrclassGestionStockCompagnie g WHERE g.idEntreprise= :e")
                .setParameter("e", e);
        return q.getResultList();
    }
}
