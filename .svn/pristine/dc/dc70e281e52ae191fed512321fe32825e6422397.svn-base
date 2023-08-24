/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import modele.OrclassTypeDocument;

/**
 *
 * @author JIATOU FRANCK
 */
@Stateless
public class OrclassTypeDocumentDao extends AbstractJpaDAO<OrclassTypeDocument> {

    private static final long serialVersionUID = 1L;
    @PersistenceContext(unitName = AbstractJpaDAO.PersistanceUnit)
    private EntityManager em;
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    protected Class<OrclassTypeDocument> getEntityClass() {
        return OrclassTypeDocument.class;
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

}
