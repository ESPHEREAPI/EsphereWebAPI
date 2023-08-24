/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reference;

import dao.OrclassExonerationDao;
import dao.OrclassExonerationTaxeDao;
import dao.OrclassTypeTaxeDao;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;
import modele.OrclassEntreprises;
import modele.OrclassExoneration;
import modele.OrclassExonerationTaxe;
import modele.OrclassRefTimbreGradue;
import modele.OrclassTimbre;
import modele.OrclassTypeTaxe;

/**
 *
 * @author JIATOU FRANCK
 */
@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
public class ServiceExonerationTaxe implements IExoneration {

    @PersistenceContext(unitName = "ESpherePU")
    private EntityManager em;
    @Resource
    UserTransaction tx;
    @EJB
    OrclassExonerationDao exonerationDao;
    @EJB
    OrclassTypeTaxeDao typeTaxeDao;
    @EJB
    OrclassExonerationTaxeDao exonerationTaxeDao;

    @Override
    public OrclassExonerationTaxe addExonerationTaxe(OrclassExoneration ex, OrclassTypeTaxe typeTaxe, OrclassRefTimbreGradue ref, OrclassEntreprises en) {
        OrclassExoneration e = null;
        OrclassTypeTaxe t = null;
        OrclassRefTimbreGradue ref_timbre = null;
        OrclassExonerationTaxe exTax = null;

        try {
            tx.begin();

//            e = exonerationDao.finKey(ex.getCode(), ex.getLibelle());
//            if (e == null) {
//                e = new OrclassExoneration();
//                e.setCode(ex.getCode());
//                e.setLibelle(ex.getLibelle());
//                em.persist(e);
//            } else {
//                e = em.merge(ex);
//            }
//            t = typeTaxeDao.finKey(typeTaxe.getCode(), typeTaxe.getLibelle());
//            if (t == null) {
//                t = new OrclassTypeTaxe();
//                t.setCode(typeTaxe.getCode());
//                t.setLibelle(typeTaxe.getLibelle());
//                em.persist(t);
//            } else if (typeTaxe != null && typeTaxe.getIdTypeTaxe() != null) {
//                t = em.merge(typeTaxe);
//            }
            exTax = exonerationTaxeDao.finKey(ex, typeTaxe, ref, en);
            if (exTax == null) {
                exTax = new OrclassExonerationTaxe();
                exTax.setIdExoneration(ex);
                if (typeTaxe != null && typeTaxe.getIdTypeTaxe() != null) {
                    exTax.setIdTypeTaxe(typeTaxe);
                } 
                if (ref != null && ref.getId() != null) {
                    exTax.setIdRefTimbreGradue(ref);
                }

                exTax.setIdEntreprises(en);
                em.persist(exTax);
            }
            tx.commit();

        } catch (IllegalStateException | SecurityException | HeuristicMixedException | HeuristicRollbackException | NotSupportedException | RollbackException | SystemException exc) {
            try {
//                tx.rollback();
                throw exc;
//                  System.err.println("message error : " + exc.getMessage() + " localisation " + exc.getLocalizedMessage() + " " + exc.toString());
            } catch (Exception excep) {
            }
        }
        return exTax;
    }

    @Override
    public Boolean updateExoneration(OrclassExonerationTaxe etax) {
        Boolean resultat = Boolean.FALSE;
        OrclassExoneration ex = null;
        OrclassTypeTaxe t = null;
        try {
            tx.begin();
            if (exonerationTaxeDao.finKeyByUpdate(etax.getIdExoneration(), etax.getIdTypeTaxe()) == null) {
                if (exonerationDao.finKey(etax.getIdExoneration().getCode(), etax.getIdExoneration().getLibelle()) == null) {
                    ex = new OrclassExoneration(etax.getIdExoneration().getCode(), etax.getIdExoneration().getLibelle());
                    em.persist(ex);
                    etax.setIdExoneration(ex);
                }
                if (typeTaxeDao.finKey(etax.getIdTypeTaxe().getCode(), etax.getIdTypeTaxe().getLibelle()) == null) {
                    t = new OrclassTypeTaxe();
                    t.setCode(etax.getIdTypeTaxe().getCode());
                    t.setLibelle(etax.getIdTypeTaxe().getLibelle());
                    em.persist(t);
                    etax.setIdTypeTaxe(t);
                }
                em.merge(etax);
                resultat = Boolean.TRUE;
            }
            tx.commit();
        } catch (IllegalStateException | SecurityException | HeuristicMixedException | HeuristicRollbackException | NotSupportedException | RollbackException | SystemException e) {
            try {
                tx.rollback();
                resultat = Boolean.FALSE;
                throw e;
            } catch (Exception exx) {

            }

        }

        return resultat;
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
