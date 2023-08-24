/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import enums.LibelleClasse;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import modele.OrclassClasses;
import modele.OrclassEntreprises;

/**
 *
 * @author hp
 */
@Stateless
public class OrclassClassesDao extends AbstractJpaDAO<OrclassClasses>{
  private static final long serialVersionUID = 1L;
    @PersistenceContext(unitName = AbstractJpaDAO.PersistanceUnit)
    private EntityManager em;
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    protected Class<OrclassClasses> getEntityClass() {
        return OrclassClasses.class;
    }

    @Override
    protected EntityManager getEntityManager() {
     return em;
    }
    public List <OrclassClasses> getAllClasseByEntreprise(OrclassEntreprises e){
        Query q;
        q=em.createQuery("SELECT c FROM OrclassClasses c WHERE c.idEntreprise.idEntreprise= :idEntreprise")
                .setParameter("idEntreprise", e.getIdEntreprise())
                ;
        return q.getResultList();
    }
    public OrclassClasses findClasseByLibelleClass(LibelleClasse lib){
        Query q;
        q=em.createQuery("select cl from OrclassClasses cl where cl.libelle= :lib")
                .setParameter("lib", lib);
        try {
             if (q.getResultList().isEmpty()) {
            return null;
        }
        } catch (Exception e) {
            return null;
        }
       
        return (OrclassClasses) q.getResultList().toArray()[0];
    }
    
     /*
    liste tous les classes visible par tous les companies
     */
    public List<OrclassClasses> listAllClassesShowAllCompagnie() {
        Query q;
        q = em.createQuery("SELECT cl from OrclassClasses cl WHERE cl.showAllCompagnies= :value  and cl.idEntreprise IS NULL ")
                .setParameter("value", Boolean.TRUE);
        return q.getResultList();
    }

    /*
    lister tous les classes pour une compagn,is precis
     */
    public List<OrclassClasses> listAllClassesByCompagnie(OrclassEntreprises e) {
        Query q;
        q = em.createQuery("SELECT cl from OrclassClasses cl WHERE cl.showAllCompagnies= :value  and cl.idEntreprise= :e ")
                .setParameter("value", Boolean.FALSE)
                .setParameter("e", e);
        return q.getResultList();
    }

}
