/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import modele.OrclassApporteur;
import modele.OrclassEntreprises;
import modele.OrclassIntermediaires;
import modele.OrclassRefApporteur;
import modele.OrclassTypeApporteur;
import modele.OrclassVille;

/**
 *
 * @author hp
 */
@Stateless
public class OrclassApporteurDao extends AbstractJpaDAO<OrclassApporteur> {

    private static final long serialVersionUID = 1L;
    @PersistenceContext(unitName = AbstractJpaDAO.PersistanceUnit)
    private EntityManager em;

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @Override
    protected Class<OrclassApporteur> getEntityClass() {
        return OrclassApporteur.class;
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    /*
    lister les apporteur d une compagnies 
     */
    public List<OrclassApporteur> apporteurByCompagnies(OrclassEntreprises e) {
        Query q;
        q = em.createQuery("SELECT ap FROM OrclassApporteur ap WHERE ap.idEntreprise.idEntreprise= :id")
                .setParameter("id", e.getIdEntreprise());
        return q.getResultList();
    }

    public List<OrclassApporteur> apporteurByCompagnies(OrclassEntreprises e, OrclassTypeApporteur tp) {
        Query q;
        q = em.createQuery("SELECT ap FROM OrclassApporteur ap WHERE  ap.idTypeApporteur.id= :ids")
//                .setParameter("id", e.getIdEntreprise())
                .setParameter("ids", tp.getId());
        return q.getResultList();
    }
        public OrclassApporteur appoteurByCompagnies(OrclassEntreprises e, OrclassRefApporteur  ref, OrclassVille ville) {
        Query q;
        q = em.createQuery("SELECT ap FROM OrclassApporteur ap WHERE ap.idEntreprise.idEntreprise= :id and ap.idVille.id= :ids and ap.idRefApporteur= :ref")
                .setParameter("id", e.getIdEntreprise())
                .setParameter("ref", ref)
                .setParameter("ids", ville.getId());
        if (q.getResultList().isEmpty()) {
            return null;
        }
        return (OrclassApporteur) q.getResultList().toArray()[0];
    }
    
  public List<OrclassApporteur>listeApporteurByPeriode(OrclassEntreprises e,OrclassIntermediaires agence, Date debut, Date fin){
      Query q;
      q=em.createQuery("SELECT DISTINCT q.idPolice.idApporteur FROM OrclassQuitance q where q.idEntreprise.idEntreprise= :e  AND q.idPolice.idIntermediaire.idIntermediaire= :agence and q.idPolice.date_effet BETWEEN :debut and :fin and (q.idPolice.annulation=false or q.idPolice.annulation=0) and (q.idPolice.validation=1 or q.idPolice.validation=true)" )
              .setParameter("e", e.getIdEntreprise())
              .setParameter("agence", agence.getIdIntermediaire())
              .setParameter("debut", debut)
              .setParameter("fin", fin);
      return q.getResultList();
  }
  
   public List<OrclassApporteur>listeApporteurByPeriode(OrclassEntreprises e, Date debut, Date fin){
      Query q;
      q=em.createQuery("SELECT DISTINCT q.idPolice.idApporteur FROM OrclassQuitance q where q.idEntreprise.idEntreprise= :e   and q.idPolice.date_effet BETWEEN :debut and :fin and (q.idPolice.annulation=false or q.idPolice.annulation=0) and (q.idPolice.validation=1 or q.idPolice.validation=true)" )
              .setParameter("e", e.getIdEntreprise())
//              .setParameter("agence", agence)
              .setParameter("debut", debut)
              .setParameter("fin", fin);
      return q.getResultList();
  }
   
  public List<OrclassApporteur> allApporteurHaveCodePrincipalNull(){
      Query q;
      q=em.createQuery("SELECT ap FROM OrclassApporteur ap where ap.codePrincipal is null");
      return q.getResultList();
       
   }
  
    public List<OrclassApporteur>listeApporteurBetweenCodePrincipale(OrclassEntreprises e, Date debut, Date fin,BigInteger apporteurdebut,BigInteger appoteurFin){
      Query q;
      q=em.createQuery("SELECT DISTINCT q.idPolice.idApporteur FROM OrclassQuitance q where q.idEntreprise.idEntreprise= :e   and q.idPolice.date_effet BETWEEN :debut and :fin and (q.idPolice.annulation=false or q.idPolice.annulation=0) and (q.idPolice.validation=1 or q.idPolice.validation=true) and q.idPolice.idApporteur.codePrincipal BETWEEN :app1 and :app2" )
              .setParameter("e", e.getIdEntreprise())
//              .setParameter("agence", agence)
              .setParameter("debut", debut)
              .setParameter("fin", fin)
              .setParameter("app1", apporteurdebut)
              .setParameter("app2", appoteurFin)
              ;
      return q.getResultList();
  }
}
