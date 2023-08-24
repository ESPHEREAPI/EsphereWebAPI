/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import enums.LibelleFrais;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import modele.OrclassCategories;
import modele.OrclassEntreprises;
import modele.OrclassRefTimbreGradue;
import modele.OrclassTimbre;

/**
 *
 * @author hp
 */
@Stateless
public class OrclassTimbreDao extends AbstractJpaDAO<OrclassTimbre> {

    private static final long serialVersionUID = 1L;
    @PersistenceContext(unitName = AbstractJpaDAO.PersistanceUnit)
    private EntityManager em;

    @Override
    protected Class<OrclassTimbre> getEntityClass() {
        return OrclassTimbre.class;
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public OrclassTimbre finKey(OrclassEntreprises e, OrclassRefTimbreGradue ref, Date effet, BigInteger puissanceMin, BigInteger puissanceMax) {
        Query q;
        q = em.createQuery("SELECT t FROM OrclassTimbre t WHERE t.idRefTimbreGradue= :ref and t.idEntreprises= :e  and t.date_effet= :effet and t.puissance_min= :pmin and t.puissance_max= :pmax and  t.idCategories is null")
                .setParameter("ref", ref)
                .setParameter("e", e)
                .setParameter("pmin", puissanceMin)
                .setParameter("pmax", puissanceMax)
                .setParameter("effet", effet);
        if (q.getResultList().isEmpty()) {
            return null;
        }
        return (OrclassTimbre) q.getResultList().toArray()[0];
    }

    public OrclassTimbre finKey(OrclassEntreprises e, OrclassRefTimbreGradue ref, Date effet, OrclassCategories cat, BigInteger puissanceMin, BigInteger puissanceMax) {
        Query q;
        q = em.createQuery("SELECT t FROM OrclassTimbre t WHERE t.idRefTimbreGradue= :ref and t.idEntreprises= :e  and t.date_effet= :effet and  t.idCategories= :cat and  t.puissance_min= :pmin and t.puissance_max= :pmax")
                .setParameter("ref", ref)
                .setParameter("e", e)
                .setParameter("pmin", puissanceMin)
                .setParameter("pmax", puissanceMax)
                .setParameter("cat", cat)
                .setParameter("effet", effet);
        if (q.getResultList().isEmpty()) {
            return null;
        }
        return (OrclassTimbre) q.getResultList().toArray()[0];
    }
       public OrclassTimbre returnRow(OrclassEntreprises e, OrclassRefTimbreGradue ref, BigInteger puissanceMin, BigInteger puissanceMax) {
        Query q;
        q = em.createQuery("SELECT t FROM OrclassTimbre t WHERE t.idRefTimbreGradue= :ref and t.idEntreprises= :e  and   t.puissance_min= :pmin and t.puissance_max= :pmax ORDER BY  t.date_effet DESC ")
                .setParameter("ref", ref)
                .setParameter("e", e)
                .setParameter("pmin", puissanceMin)
                .setParameter("pmax", puissanceMax)
              ;
        if (q.getResultList().isEmpty()) {
            return null;
        }
        return (OrclassTimbre) q.getResultList().toArray()[0];
    }
       public OrclassTimbre returnRow(OrclassEntreprises e, LibelleFrais ref, BigInteger puissanceMin, BigInteger puissanceMax) {
        Query q;
        q = em.createQuery("SELECT t FROM OrclassTimbre t WHERE t.idRefTimbreGradue.libelleFrais= :ref and t.idEntreprises= :e  and   t.puissance_min= :pmin and t.puissance_max= :pmax ORDER BY  t.date_effet DESC ")
                .setParameter("ref", ref)
                .setParameter("e", e)
                .setParameter("pmin", puissanceMin)
                .setParameter("pmax", puissanceMax)
              ;
        if (q.getResultList().isEmpty()) {
            return null;
        }
        return (OrclassTimbre) q.getResultList().toArray()[0];
    }

    public List<OrclassTimbre> listeTimbreByLibelleFrais(OrclassEntreprises e, LibelleFrais libelleFrais) {
        Query q;
        q = em.createQuery("SELECT t FROM OrclassTimbre t WHERE t.idEntreprises= :e and t.idRefTimbreGradue.libelleFrais= :frais")
                .setParameter("e", e)
                .setParameter("frais", libelleFrais);
        return q.getResultList();
    }

    public List<OrclassTimbre> listeTimbreByRefAndDateEffet(OrclassEntreprises e, OrclassRefTimbreGradue ref, Date effet) {
        Query q;
        q = em.createQuery("SELECT t FROM OrclassTimbre t WHERE t.idEntreprises= :e and t.idRefTimbreGradue= :ref and t.date_effet= :effet")
                .setParameter("effet", effet)
                .setParameter("e", e)
                .setParameter("ref", ref);
        return q.getResultList();
    }

    public List<OrclassTimbre> listeTimbreByRefAndDateEffet(OrclassEntreprises e, OrclassRefTimbreGradue ref, Date effet, OrclassCategories cat) {
        Query q;
        q = em.createQuery("SELECT t FROM OrclassTimbre t WHERE t.idEntreprises= :e and t.idRefTimbreGradue= :ref and t.date_effet= :effet and t.idCategories= :cat")
                .setParameter("effet", effet)
                .setParameter("e", e)
                .setParameter("cat", cat)
                .setParameter("ref", ref);
        return q.getResultList();
    }
    
       public List<OrclassTimbre> listeTimbreByRef(OrclassEntreprises e, OrclassRefTimbreGradue ref) {
        Query q;
        q = em.createQuery("SELECT t FROM OrclassTimbre t WHERE t.idEntreprises= :e and t.idRefTimbreGradue= :ref ")
               
                .setParameter("e", e)
                .setParameter("ref", ref);
        return q.getResultList();
    }

    public List<OrclassTimbre> listeTimbreByRef(OrclassEntreprises e, OrclassRefTimbreGradue ref, OrclassCategories cat) {
        Query q;
        q = em.createQuery("SELECT t FROM OrclassTimbre t WHERE t.idEntreprises= :e and t.idRefTimbreGradue= :ref and  t.idCategories= :cat")
                
                .setParameter("e", e)
                .setParameter("cat", cat)
                .setParameter("ref", ref);
        return q.getResultList();
    }

}
