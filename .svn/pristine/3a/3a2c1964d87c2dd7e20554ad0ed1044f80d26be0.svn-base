/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import enums.LibelleBranche;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import modele.OrclassApporteur;
import modele.OrclassBranches;
import modele.OrclassClasses;
import modele.OrclassEntreprises;
import modele.OrclassIntermediaires;

/**
 *
 * @author hp
 */
@Stateless
public class OrclassBranchesDao extends AbstractJpaDAO<OrclassBranches>{
  private static final long serialVersionUID = 1L;
    @PersistenceContext(unitName = AbstractJpaDAO.PersistanceUnit)
    private EntityManager em;
    @Override
    protected Class<OrclassBranches> getEntityClass() {
    return OrclassBranches.class;
    }

    @Override
    protected EntityManager getEntityManager() {
      return em;
    }

      public List <OrclassBranches> getAllBrancheByEntreprise(OrclassEntreprises e){
        Query q;
        q=em.createQuery("SELECT c FROM OrclassBranches c WHERE c.idEntreprise.idEntreprise= :idEntreprise")
                .setParameter("idEntreprise", e.getIdEntreprise())
                ;
        return q.getResultList();
    }
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
      
      public OrclassBranches findBrancheByLibelleBranche(LibelleBranche lib){
        Query q;
        q=em.createQuery("select cl from OrclassBranches cl where cl.libelle= :lib")
                .setParameter("lib", lib);
        if (q.getResultList().isEmpty()) {
            return null;
        }
        return (OrclassBranches) q.getResultList().toArray()[0];
    }
      
         /*
    liste tous les classes visible par tous les companies
     */
    public List<OrclassBranches> listAllBrancheShowAllCompagnie() {
        Query q;
        q = em.createQuery("SELECT br from OrclassBranches br WHERE br.showAllCompagnies= :value  and br.idEntreprise IS NULL ")
                .setParameter("value", Boolean.TRUE);
        return q.getResultList();
    }

    /*
    lister tous les classes pour une compagn,is precis
     */
    public List<OrclassBranches> listAllBrancheByCompagnie(OrclassEntreprises e) {
        Query q;
        q = em.createQuery("SELECT br from OrclassBranches br WHERE br.showAllCompagnies= :value  and br.idEntreprise= :e ")
                .setParameter("value", Boolean.FALSE)
                .setParameter("e", e);
        return q.getResultList();
    }

     public List<OrclassBranches>listeBrancherByPeriode(OrclassEntreprises e,OrclassIntermediaires agence, Date debut, Date fin){
      Query q;
      q=em.createQuery("SELECT DISTINCT q.idPolice.idCategories.idBranche FROM OrclassQuitance q where q.idEntreprise.idEntreprise= :e  AND q.idPolice.idIntermediaire.idIntermediaire= :agence and q.dateEmission BETWEEN :debut and :fin and (q.idPolice.annulation=false or q.idPolice.annulation=0) and (q.idPolice.validation=1 or q.idPolice.validation=true)  " )
              .setParameter("e", e.getIdEntreprise())
              .setParameter("agence", agence.getIdIntermediaire())
              .setParameter("debut", debut)
              .setParameter("fin", fin);
      return q.getResultList();
  }
       public List<OrclassBranches>listeBrancherByPeriode(OrclassEntreprises e, Date debut, Date fin){
      Query q;
      q=em.createQuery("SELECT DISTINCT q.idPolice.idCategories.idBranche FROM OrclassQuitance q where q.idEntreprise.idEntreprise= :e   and q.dateEmission BETWEEN :debut and :fin and (q.idPolice.annulation=false or q.idPolice.annulation=0) and (q.idPolice.validation=1 or q.idPolice.validation=true)" )
              .setParameter("e", e.getIdEntreprise())
//              .setParameter("agence", agence)
              .setParameter("debut", debut)
              .setParameter("fin", fin);
      return q.getResultList();
  } 
     
     public List<OrclassBranches> allBranchesHaveCodePrincipalNull(){
      Query q;
      q=em.createQuery("SELECT b FROM OrclassBranches b where b.codePrincipal is null");
      return q.getResultList();
       
   }
        public List<OrclassBranches>listeBrancherByChoixPersonnalise(OrclassEntreprises e, Date debut, Date fin,BigInteger brancheDebut,BigInteger brancheFin){
      Query q;
      q=em.createQuery("SELECT DISTINCT q.idPolice.idCategories.idBranche FROM OrclassQuitance q where q.idEntreprise.idEntreprise= :e   and q.dateEmission BETWEEN :debut and :fin and (q.idPolice.annulation=false or q.idPolice.annulation=0) and (q.idPolice.validation=1 or q.idPolice.validation=true) and q.idPolice.idCategories.idBranche.codePrincipal BETWEEN :brch1 and :brch2 " )
              .setParameter("e", e.getIdEntreprise())
//              .setParameter("agence", agence)
              .setParameter("debut", debut)
              .setParameter("fin", fin)
              .setParameter("brch1", brancheDebut)
              .setParameter("brch2", brancheDebut)
              ;
      return q.getResultList();
  } 
     
 
}
