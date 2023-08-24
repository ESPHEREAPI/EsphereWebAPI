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
import modele.OrclassDetailPlafondMaladie;
import modele.OrclassEntreprises;
import modele.OrclassPlafondMaladie;
import modele.OrclassRubriquePrestation;

/**
 *
 * @author hp
 */
@Stateless
public class OrclassDetailPlafondMaladieDao extends AbstractJpaDAO<OrclassDetailPlafondMaladie> {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    private static final long serialVersionUID = 1L;
    @PersistenceContext(unitName = AbstractJpaDAO.PersistanceUnit)
    private EntityManager em;

    @Override
    protected Class<OrclassDetailPlafondMaladie> getEntityClass() {
        return OrclassDetailPlafondMaladie.class;
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    /*
    controller une ligne d enregistrement
     */
    public OrclassDetailPlafondMaladie finKey(OrclassPlafondMaladie pm, OrclassRubriquePrestation rp, OrclassEntreprises e) {
        Query q;
        q = em.createQuery("SELECT dpm FROM OrclassDetailPlafondMaladie dpm WHERE dpm.idEntreprise.idEntreprise= :idEntreprise and dpm.idPlafondMaladie.id= :idpm and dpm.idRubriquePrestation.id= :idrp")
                .setParameter("idEntreprise", e.getIdEntreprise())
                .setParameter("idpm", pm.getId())
                .setParameter("idrp", rp.getId());
        if (q.getResultList().isEmpty()) {
            return null;
        }
        return (OrclassDetailPlafondMaladie) q.getResultList().toArray()[0];
    }

    /*
    liste les detail plafons maladie pour un plafond maladie fixe
     */
    public List<OrclassDetailPlafondMaladie> listeDetailPlafondMaladieByPlafondMalaide(OrclassPlafondMaladie pm, OrclassEntreprises e) {
        Query q;
        q = em.createQuery("SELECT dpm FROM OrclassDetailPlafondMaladie dpm WHERE dpm.idEntreprise.idEntreprise= :idEntreprise and dpm.idPlafondMaladie.id= :id")
                .setParameter("idEntreprise", e.getIdEntreprise())
                .setParameter("id", pm.getId());
        return q.getResultList();
    }
    
    
}
