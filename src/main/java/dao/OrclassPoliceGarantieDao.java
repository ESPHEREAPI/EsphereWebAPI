/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import modele.OrclassAvenant;
import modele.OrclassEntreprises;
import modele.OrclassGarantie;
import modele.OrclassPolice;
import modele.OrclassPoliceGarantie;
import modele.OrclasseRefGroupe;

/**
 *
 * @author hp
 */
@Stateless
public class OrclassPoliceGarantieDao extends AbstractJpaDAO<OrclassPoliceGarantie>{

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
       @PersistenceContext(unitName = AbstractJpaDAO.PersistanceUnit)
    private EntityManager em;

    @Override
    protected Class<OrclassPoliceGarantie> getEntityClass() {
    return OrclassPoliceGarantie.class;
    
    }

    @Override
    protected EntityManager getEntityManager() {
       return em;
    
    }
    public List<OrclassPoliceGarantie> listeGarantiesByPoliceNotHaveAvenant(OrclassEntreprises e ,OrclassPolice p){
      Query q;
      q=em.createQuery("SELECT g FROM OrclassPoliceGarantie g WHERE g.idEntreprise= :e and g.idPolice= :p and g.idAvenant is null")
              .setParameter("e", e)
              .setParameter("p", p)
              ;
        if (q.getResultList().isEmpty()) {
            return new ArrayList<>();
        }
        return q.getResultList();
    }
     public List<OrclassPoliceGarantie> allGarantiesByPolice(OrclassEntreprises e ,OrclassPolice p){
      Query q;
      q=em.createQuery("SELECT g FROM OrclassPoliceGarantie g WHERE g.idEntreprise= :e and g.idPolice= :p ")
              .setParameter("e", e)
              .setParameter("p", p)
              ;
        if (q.getResultList().isEmpty()) {
            return new ArrayList<>();
        }
        return q.getResultList();
    }
       public List<OrclassGarantie> allGarantiesHavePolice(OrclassEntreprises e ,OrclassPolice p){
      Query q;
      q=em.createQuery("SELECT DISTINCT g.idGarantie FROM OrclassPoliceGarantie g WHERE g.idEntreprise= :e and g.idPolice= :p ")
              .setParameter("e", e)
              .setParameter("p", p)
              ;
        if (q.getResultList().isEmpty()) {
            return new ArrayList<>();
        }
        return q.getResultList();
    }
     
     
     
      public List<OrclassPoliceGarantie> allGarantiesByPolice(OrclassEntreprises e ,OrclassPolice p,OrclasseRefGroupe g){
      Query q;
      q=em.createQuery("SELECT g FROM OrclassPoliceGarantie g WHERE g.idEntreprise= :e and g.idPolice= :p and g.idGroup= :g")
              .setParameter("e", e)
              .setParameter("p", p)
              .setParameter("g", g)
              ;
        if (q.getResultList().isEmpty()) {
            return new ArrayList<>();
        }
        return q.getResultList();
    }
    
      public List<OrclassPoliceGarantie> listeGarantiesByPoliceNotHaveAvenant(OrclassEntreprises e ,OrclassPolice p,OrclasseRefGroupe group){
      Query q;
      q=em.createQuery("SELECT g FROM OrclassPoliceGarantie g WHERE g.idEntreprise= :e and g.idPolice= :p and g.idGroup= :g and g.idAvenant is null")
              .setParameter("e", e)
              .setParameter("g", group)
              .setParameter("p", p)
              ;
        if (q.getResultList().isEmpty()) {
            return new ArrayList<>();
        }
        return q.getResultList();
    }
      public List<OrclassGarantie> listeGarantiesByPoliceGarantiesNotHaveAvenant(OrclassEntreprises e ,OrclassPolice p,OrclasseRefGroupe group){
      Query q;
      q=em.createQuery("SELECT g.idGarantie FROM OrclassPoliceGarantie g WHERE g.idEntreprise= :e and g.idPolice= :p and g.idGroup= :g and g.idAvenant is null")
              .setParameter("e", e)
              .setParameter("g", group)
              .setParameter("p", p)
              ;
        if (q.getResultList().isEmpty()) {
            return new ArrayList<>();
        }
        return q.getResultList();
    }
        public List<OrclassGarantie> listeGarantiesByPoliceGarantiesNotHaveAvenant(OrclassEntreprises e ,OrclassPolice p,OrclasseRefGroupe group,OrclassAvenant av){
      Query q;
      q=em.createQuery("SELECT g.idGarantie FROM OrclassPoliceGarantie g WHERE g.idEntreprise= :e and g.idPolice= :p and g.idGroup= :g and g.idAvenant= :av")
              .setParameter("e", e)
              .setParameter("g", group)
              .setParameter("p", p)
              .setParameter("av",av);
              ;
        if (q.getResultList().isEmpty()) {
            return new ArrayList<>();
        }
        return q.getResultList();
    }
    
      public List<OrclassGarantie> listeGarantiesHavePoliceGarantie(OrclassEntreprises e ,OrclassPolice p){
      Query q;
      q=em.createQuery("SELECT  g.idGarantie FROM OrclassPoliceGarantie g WHERE g.idEntreprise= :e and g.idPolice= :p and g.idAvenant is null")
              .setParameter("e", e)
              .setParameter("p", p)
              ;
        if (q.getResultList().isEmpty()) {
            return new ArrayList<>();
        }
        return q.getResultList();
    }
      
       public List<OrclassGarantie> listeGarantiesHavePoliceGarantie(OrclassEntreprises e ,OrclassPolice p,OrclasseRefGroupe g){
      Query q;
      q=em.createQuery("SELECT  g.idGarantie FROM OrclassPoliceGarantie g WHERE g.idEntreprise= :e and g.idPolice= :p and g.idGroup= :idg")
              .setParameter("e", e)
               .setParameter("idg", g)
              .setParameter("p", p)
              ;
        if (q.getResultList().isEmpty()) {
            return new ArrayList<>();
        }
        return q.getResultList();
    }
    
     public List<OrclassPoliceGarantie> listeGarantiesForPoliceHaveAvenant(OrclassEntreprises e ,OrclassPolice p,OrclassAvenant av){
      Query q;
      q=em.createQuery("SELECT g FROM OrclassPoliceGarantie g WHERE g.idEntreprise= :e and g.idPolice= :p and g.idAvenant= :av")
              .setParameter("e", e)
              .setParameter("p", p)
              .setParameter("av", av)
              ;
        if (q.getResultList().isEmpty()) {
            return new ArrayList<>();
        }
        return q.getResultList();
    }
     
      public List<OrclassGarantie> listeGarantiesHaveAvenant(OrclassEntreprises e ,OrclassPolice p,OrclassAvenant av){
      Query q;
      q=em.createQuery("SELECT g.idGarantie FROM OrclassPoliceGarantie g WHERE g.idEntreprise= :e and g.idPolice= :p and g.idAvenant= :av")
              .setParameter("e", e)
              .setParameter("p", p)
              .setParameter("av", av)
              ;
        if (q.getResultList().isEmpty()) {
            return new ArrayList<>();
        }
        return q.getResultList();
    }
       public List<OrclassGarantie> listeGarantiesNotHaveAvenant(OrclassEntreprises e ,OrclassPolice p){
      Query q;
      q=em.createQuery("SELECT g.idGarantie FROM OrclassPoliceGarantie g WHERE g.idEntreprise= :e and g.idPolice= :p and g.idAvenant is null")
              .setParameter("e", e)
              .setParameter("p", p)
//              .setParameter("av", av)
              ;
        if (q.getResultList().isEmpty()) {
            return new ArrayList<>();
        }
        return q.getResultList();
    }
     
      public BigDecimal sommePrimeByPoliceNotHaveAvenant(OrclassEntreprises e ,OrclassPolice p){
      Query q;
      q=em.createQuery("SELECT SUM(g.prime) FROM OrclassPoliceGarantie g WHERE g.idEntreprise= :e and g.idPolice= :p and g.idAvenant is null ")
              .setParameter("e", e)
              .setParameter("p", p)
              ;
        if (q.getResultList().isEmpty()) {
            return BigDecimal.ZERO;
        }
        return (BigDecimal) q.getSingleResult();
    }
        public OrclassPoliceGarantie OrclassPoliceGarantieByLibelle(OrclassEntreprises e ,OrclassPolice p,OrclassGarantie g){
      Query q;
      q=em.createQuery("SELECT g FROM OrclassPoliceGarantie g WHERE g.idEntreprise= :e and g.idPolice= :p  and g.idGarantie= :g and g.idAvenant is null ")
              .setParameter("e", e)
              .setParameter("p", p)
                .setParameter("g", g)
              ;
        if (q.getResultList().isEmpty()) {
            return null;
        }
        return (OrclassPoliceGarantie) q.getResultList().toArray()[0];
    }
        
           public OrclassPoliceGarantie OrclassPoliceGarantieByLibelle(OrclassEntreprises e ,OrclassPolice p,OrclassGarantie g,OrclasseRefGroupe gr){
      Query q;
      q=em.createQuery("SELECT g FROM OrclassPoliceGarantie g WHERE g.idEntreprise= :e and g.idPolice= :p  and g.idGarantie= :g and g.idGroup= :gr and  g.idAvenant is null ")
              .setParameter("e", e)
              .setParameter("p", p)
                .setParameter("g", g)
              .setParameter("gr", gr)
              ;
        if (q.getResultList().isEmpty()) {
            return null;
        }
        return (OrclassPoliceGarantie) q.getResultList().toArray()[0];
    }
    
}
