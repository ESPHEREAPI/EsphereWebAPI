package dao;

import dao.AbstractJpaDAO;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import modele.OrclassEntreprises;
import modele.OrclassExoneration;
import modele.OrclassExonerationTaxe;
import modele.OrclassRefTimbreGradue;
import modele.OrclassTimbre;
import modele.OrclassTypeTaxe;

@Stateless
public class OrclassExonerationTaxeDao extends AbstractJpaDAO<OrclassExonerationTaxe> {

    private static final long serialVersionUID = 1L;

    @PersistenceContext(unitName = "ESpherePU")
    private EntityManager em;

    protected Class<OrclassExonerationTaxe> getEntityClass() {
        return OrclassExonerationTaxe.class;
    }

    protected EntityManager getEntityManager() {
        return this.em;
    }

    public List<OrclassExonerationTaxe> listExonerationTaxes(OrclassExoneration e, OrclassEntreprises en) {
        Query q = this.em.createQuery("SELECT et FROM OrclassExonerationTaxe et WHERE et.idExoneration.idExoneration = :id and et.idEntreprises= :en")
                .setParameter("id", e.getIdExoneration())
                .setParameter("en", en);
        return q.getResultList();
    }

    public OrclassExonerationTaxe listExonerationTaxe(OrclassExoneration e, OrclassEntreprises en) {
        Query q = this.em.createQuery("SELECT et FROM OrclassExonerationTaxe et WHERE et.idExoneration.idExoneration = :id and et.idEntreprises= :en")
                .setParameter("id", e.getIdExoneration())
                .setParameter("en", en);
        if (q.getResultList().isEmpty()) {
            return null;
        }
        return (OrclassExonerationTaxe) q.getResultList().toArray()[0];
    }

    public List<OrclassExonerationTaxe> listExonerationTaxe(OrclassEntreprises en) {
        Query q = this.em.createQuery("SELECT et FROM OrclassExonerationTaxe et WHERE  et.idEntreprises= :en")
                .setParameter("en", en);
        return q.getResultList();
    }

    public OrclassExonerationTaxe finKey(OrclassExoneration ex, OrclassTypeTaxe tt, OrclassRefTimbreGradue refT, OrclassEntreprises en) {

        Query q = em.createQuery("SELECT ext FROM OrclassExonerationTaxe ext where ext.idExoneration= :e and ext.idTypeTaxe= :t and ext.idEntreprises= :en and ext.idRefTimbreGradue= :reft")
                .setParameter("e", ex)
                .setParameter("t", (tt == null || tt.getIdTypeTaxe() == null ? null : tt))
                .setParameter("reft", (refT == null || refT.getId() == null ? null : refT))
                .setParameter("en", en);
        if (q.getResultList().isEmpty()) {
            return null;
        }
        return (OrclassExonerationTaxe) q.getResultList().toArray()[0];
    }

    public OrclassExonerationTaxe finKeyByUpdate(OrclassExoneration ex, OrclassTypeTaxe tt) {
        Query q = em.createQuery("SELECT ext FROM OrclassExonerationTaxe ext where ext.idExoneration.code= :code and ext.idTypeTaxe.code= :code2")
                .setParameter("code", ex.getCode())
                .setParameter("code2", tt.getCode());
        if (q.getResultList().isEmpty()) {
            return null;
        }
        return (OrclassExonerationTaxe) q.getResultList().toArray()[0];
    }
}
