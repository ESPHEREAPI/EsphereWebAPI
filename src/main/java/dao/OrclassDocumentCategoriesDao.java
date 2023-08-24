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
import modele.OrclassCategories;
import modele.OrclassDocumentCategories;
import modele.OrclassEntreprises;
import modele.OrclassNatureDocument;
import modele.OrclassTypeDocument;

/**
 *
 * @author JIATOU FRANCK
 */
@Stateless
public class OrclassDocumentCategoriesDao extends AbstractJpaDAO<OrclassDocumentCategories> {

    private static final long serialVersionUID = 1L;
    @PersistenceContext(unitName = AbstractJpaDAO.PersistanceUnit)
    private EntityManager em;

    @Override
    protected Class<OrclassDocumentCategories> getEntityClass() {
        return OrclassDocumentCategories.class;
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public OrclassDocumentCategories finKey(OrclassEntreprises e, OrclassCategories c, OrclassTypeDocument td, OrclassNatureDocument nd, Date effet) {
        Query q;
        q = em.createQuery("SELECT dc FROM OrclassDocumentCategories dc WHERE dc.idEntreprises= :e and dc.idCategories= :c and dc.date_effet= :d and dc.typeDocument= :td  and dc.natureDocuments= :nd  ")
                .setParameter("e", e)
                .setParameter("c", c)
                .setParameter("td", td)
                .setParameter("nd", nd)
                .setParameter("d", effet);
        if (q.getResultList().isEmpty()) {
            return null;
        }
        return (OrclassDocumentCategories) q.getResultList().toArray()[0];
    }
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    public List<OrclassDocumentCategories> listeDoucumentCategoriesByCompagnie(OrclassEntreprises e) {
        Query q;
        q = em.createQuery("SELECT dc FROM OrclassDocumentCategories dc WHERE dc.idEntreprises= :e ")
                .setParameter("e", e);

        return q.getResultList();
    }
    
    public List<OrclassDocumentCategories> listeDoucumentCategoriesByCompagnie(OrclassEntreprises e,OrclassCategories c) {
        Query q;
        q = em.createQuery("SELECT dc FROM OrclassDocumentCategories dc WHERE dc.idEntreprises= :e and dc.idCategories= :c ")
                .setParameter("e", e)
                 .setParameter("c", c)
                ;

        return q.getResultList();
    }
}
