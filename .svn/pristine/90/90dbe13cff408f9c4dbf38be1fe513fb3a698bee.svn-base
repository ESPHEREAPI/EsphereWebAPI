/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.math.BigInteger;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import modele.OrclassCategories;
import modele.OrclassEntreprises;
import modele.OrclassImageRisque;
import modele.OrclassIntermediaires;
import modele.OrclassPolice;
import modele.OrclassUtilisateurs;
import modele.OrclasseRefGroupe;

/**
 *
 * @author frankjiatou
 */
@Stateless
public class OrclassImageRisqueDao extends AbstractJpaDAO<OrclassImageRisque> {

    private static final long serialVersionUID = 1L;
    @PersistenceContext(unitName = AbstractJpaDAO.PersistanceUnit)
    private EntityManager em;

    @Override
    protected Class<OrclassImageRisque> getEntityClass() {
        return OrclassImageRisque.class;
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    public OrclassImageRisque finkey(OrclassEntreprises e, OrclasseRefGroupe g, String libelle, String matricule, Date dateNaissance, BigInteger numero_polic) {
        Query q;
        q = em.createQuery("SELECT ri FROM OrclassImageRisque ri WHERE ri.dateNaissance= :date and ri.idEntreprise.idEntreprise= :idEntreprise and ri.libelle= :lib and ri.matricule= :mat and ri.idGroup.id= :id and ri.numero_polic= :police")
                .setParameter("date", dateNaissance)
                .setParameter("idEntreprise", e.getIdEntreprise())
                .setParameter("lib", libelle)
                .setParameter("mat", matricule)
                .setParameter("police", numero_polic)
                .setParameter("id", g.getId());

        if (q.getResultList().isEmpty()) {
            return null;
        }
        return (OrclassImageRisque) q.getResultList().toArray()[0];
    }
    
        public OrclassImageRisque finkey(OrclassEntreprises e, OrclasseRefGroupe g, String libelle, String matricule, Date dateNaissance) {
        Query q;
        q = em.createQuery("SELECT ri FROM OrclassImageRisque ri WHERE ri.dateNaissance= :date and ri.idEntreprise.idEntreprise= :idEntreprise and ri.libelle= :lib and ri.matricule= :mat and ri.idGroup.id= :id")
                .setParameter("date", dateNaissance)
                .setParameter("idEntreprise", e.getIdEntreprise())
                .setParameter("lib", libelle)
                .setParameter("mat", matricule)
//                .setParameter("police", numero_polic)
                .setParameter("id", g.getId());

        if (q.getResultList().isEmpty()) {
            return null;
        }
        return (OrclassImageRisque) q.getResultList().toArray()[0];
    }

    public List<OrclassImageRisque> listeImageRisqueFamille(OrclassEntreprises e, OrclasseRefGroupe g, BigInteger numero_polic,String souscripteur) {
        Query q;
        q = em.createQuery("SELECT ri FROM OrclassImageRisque ri WHERE  ri.idEntreprise.idEntreprise= :idEntreprise and ri.idGroup.id= :id and ri.numero_polic= :police and ri.souscripteur= :souscripteur")
                .setParameter("idEntreprise", e.getIdEntreprise())
                .setParameter("police", numero_polic)
                .setParameter("souscripteur", souscripteur)
                 
                .setParameter("id", g.getId());
        return q.getResultList();
    }
    
    /*
    verifions si le numero de police a ete  proposer et effectuer par l utilisateur en question
    */
    public  List<OrclassImageRisque> listeImageRisqueByUserHaveDo(OrclassEntreprises e,OrclassCategories cat,OrclassIntermediaires agence,BigInteger numero_polic,OrclassUtilisateurs user){
        Query q;
        q=em.createQuery("SELECT ri FROM OrclassImageRisque ri WHERE ri.idEntreprise= :e and ri.idCategories= :cat and ri.idIntermediaire= :agence and ri.numero_polic= :numero and ri.idUtilisateur= :user")
                .setParameter("e", e)
                .setParameter("cat", cat)
                .setParameter("agence", agence)
                .setParameter("numero", numero_polic)
                .setParameter("user", user) 
                ;
        return q.getResultList();
    }
//    public  List<OrclassImageRisque> listeImageRisqueByNumeroPolice(OrclassEntreprises e, OrclassIntermediaires agence,OrclassCategories cat){
//        Query q;
//            q=em.createQuery("SELECT ri FROM OrclassImageRisque ri WHERE ri.idEntreprise= :e and ri.idCategories= :cat and ri.idIntermediaire= :agence ")
//                .setParameter("e", e)
//                .setParameter("cat", cat)
//                .setParameter("agence", agence)
//                .setParameter("numero", numero_polic);
//    }
    
    public Long nombreAssure(OrclassPolice police,OrclassEntreprises e,OrclasseRefGroupe g){
         Query q;
         Long nombreRisque=0L;
         q=em.createQuery("SELECT COUNT(r) FROM OrclassImageRisque r WHERE r.numero_polic= :np and r.idEntreprise.idEntreprise= :ide and r.idGroup.id= :idg ")
                 .setParameter("np", police.getNumero_police())
                  .setParameter("idg", g.getId())
                 .setParameter("ide", e.getIdEntreprise());
         nombreRisque=(Long) q.getSingleResult();
         return nombreRisque==null ? 0L:nombreRisque;
         
     }
       public List<String> getAssueRaisonSocialWithFilters(OrclassEntreprises e, String Filter) {

        Map<String, Object> param = new HashMap<>();

        Query q = null;

        //si le filtre existe
        String request = "SELECT distinct(ass.souscripteur) FROM OrclassImageRisque ass  WHERE ass.idEntreprise.idEntreprise= :idEntreprise ";
//        Query q;
        if (Filter != null && !Filter.trim().equals("")) {
            request += " AND ass.souscripteur like :filter ";

            q = em.createQuery(request)
                    .setParameter("idEntreprise", e.getIdEntreprise())
                    .setParameter("filter", "%" + Filter + "%") //                    .setMaxResults(end - start).setFirstResult(start)
                    ;

        }

        return q.getResultList();

    }


}
