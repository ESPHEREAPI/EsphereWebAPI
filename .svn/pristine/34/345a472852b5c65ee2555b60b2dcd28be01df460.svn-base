/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import controllers.adp.AvenantCongtroller;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import modele.OrclassAvenant;
import modele.OrclassCategories;
import modele.OrclassEntreprises;
import modele.OrclassPolice;
//import modele.OrclassPolicesss;
import modele.OrclassRisque;
import modele.OrclasseRefGroupe;

/**
 *
 * @author hp
 */
@Stateless
public class OrclassRisqueDao extends AbstractJpaDAO<OrclassRisque> {

    private static final long serialVersionUID = 1L;
    @PersistenceContext(unitName = AbstractJpaDAO.PersistanceUnit)
    private EntityManager em;
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    protected Class<OrclassRisque> getEntityClass() {
        return OrclassRisque.class;
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public List<OrclassRisque> listeRisqueByGroupe(OrclassEntreprises e, OrclasseRefGroupe g, OrclassPolice police) {
        Query q;
        q = em.createQuery("select r FROM  OrclassRisque r WHERE r.idEntreprise.idEntreprise= :ide and r.idGroup.id=:idg and r.idPolice.id= :police ")
                .setParameter("ide", e.getIdEntreprise())
                .setParameter("idg", g.getId())
                .setParameter("police", police.getId()) //                .setParameter("num", police.getNumero_police())
                //                .setParameter("agence", police.getIdIntermediaire())
                ;
        return q.getResultList();
    }
    public List<OrclassRisque> listeRisqueByGroupe(OrclassEntreprises e, OrclasseRefGroupe g, OrclassPolice police,OrclassAvenant avenant) {
        Query q;
        q = em.createQuery("select r FROM  OrclassRisque r WHERE r.idEntreprise.idEntreprise= :ide and r.idGroup.id=:idg and r.idPolice.id= :police and r.idAvenant= :avenat ")
                .setParameter("ide", e.getIdEntreprise())
                .setParameter("idg", g.getId())
                .setParameter("police", police.getId()) 
                 .setParameter("avenant", avenant) 
//                .setParameter("num", police.getNumero_police())
                //                .setParameter("agence", police.getIdIntermediaire())
                ;
        return q.getResultList();
    }
    
        public List<OrclasseRefGroupe> listeGroupeForRisque(OrclassEntreprises e, OrclassPolice police) {
        Query q;
        q = em.createQuery("select DISTINCT r.idGroup FROM  OrclassRisque r WHERE r.idEntreprise.idEntreprise= :ide  and r.idPolice.id= :police ")
                .setParameter("ide", e.getIdEntreprise())
//                .setParameter("idg", g.getId())
                .setParameter("police", police.getId()) //                .setParameter("num", police.getNumero_police())
                //                .setParameter("agence", police.getIdIntermediaire())
                ;
        return q.getResultList();
    }

    public List<OrclassRisque> listeRisqueByPolice(OrclassEntreprises e, OrclassPolice police) {
        Query q;
        q = em.createQuery("select r FROM  OrclassRisque r WHERE r.idEntreprise.idEntreprise= :ide  and r.idPolice.id= :police and r.idAvenant is null ORDER BY r.libelle")
                .setParameter("ide", e.getIdEntreprise())
                .setParameter("police", police.getId()) //                .setParameter("num", police.getNumero_police())
                //                .setParameter("agence", police.getIdIntermediaire())
                ;
        return q.getResultList();
    }

    public List<OrclassRisque> listeRisqueByPoliceHaveGroup(OrclassEntreprises e, OrclassPolice police) {
        Query q;
        q = em.createQuery("select r FROM  OrclassRisque r WHERE r.idEntreprise.idEntreprise= :ide  and r.idPolice.id= :police and r.idAvenant is null ORDER BY r.idGroup.libelle")
                .setParameter("ide", e.getIdEntreprise())
                .setParameter("police", police.getId()) //                .setParameter("num", police.getNumero_police())
                //                .setParameter("agence", police.getIdIntermediaire())
                ;
        return q.getResultList();
    }

    public OrclassRisque risqueByPolice(OrclassEntreprises e, OrclassPolice police) {
        Query q;
        OrclassRisque risque = null;
        q = em.createQuery("select r FROM  OrclassRisque r WHERE r.idEntreprise.idEntreprise= :ide  and r.idPolice.id = :police  and   r.idGroup is null and r.idAvenant is null")
                .setParameter("ide", e.getIdEntreprise())
                //                .setParameter("num", police.getNumero_police())
                //                .setParameter("agence", police.getIdIntermediaire())
                .setParameter("police", police.getId());
        if (q.getResultList().isEmpty()) {
            risque = new OrclassRisque();
            return risque;
        }
        return (OrclassRisque) q.getResultList().toArray()[0];
    }

    public List<OrclasseRefGroupe> listeRiefeGrouByPolice(OrclassEntreprises e, OrclassPolice police, OrclassCategories cat) {
        Query q;
        q = em.createQuery("select distinct r.idGroup FROM  OrclassRisque r WHERE r.idEntreprise.idEntreprise= :ide  and r.idPolice.id= :police   and r.idPolice.idCategories= :cat and r.idAvenant is null")
                .setParameter("ide", e.getIdEntreprise())
                .setParameter("police", police.getId())
                .setParameter("cat", cat) //                .setParameter("agence", police.getIdIntermediaire())
                ;
        return q.getResultList();
    }
     public List<OrclasseRefGroupe> listeRiefeGrouByPoliceINRisqueHaveAvenant(OrclassEntreprises e, OrclassPolice police, OrclassCategories cat) {
        Query q;
        q = em.createQuery("select distinct r.idGroup FROM  OrclassRisque r WHERE r.idEntreprise.idEntreprise= :ide  and r.idPolice.id= :police   and r.idPolice.idCategories= :cat")
                .setParameter("ide", e.getIdEntreprise())
                .setParameter("police", police.getId())
                .setParameter("cat", cat) //                .setParameter("agence", police.getIdIntermediaire())
                ;
        return q.getResultList();
    }
    
    
      public List<OrclasseRefGroupe> allReffeGrouByPolice(OrclassEntreprises e, OrclassPolice police, OrclassCategories cat) {
        Query q;
        q = em.createQuery("select distinct r.idGroup FROM  OrclassRisque r WHERE r.idEntreprise.idEntreprise= :ide  and r.idPolice.id= :police   and r.idPolice.idCategories= :cat")
                .setParameter("ide", e.getIdEntreprise())
                .setParameter("police", police.getId())
                .setParameter("cat", cat) //                .setParameter("agence", police.getIdIntermediaire())
                ;
        return q.getResultList();
    }
    

    public List<OrclassRisque> listeRisqueByPoliceHaveAvenant(OrclassEntreprises e, OrclassPolice police, OrclassAvenant avenant) {
        Query q;
        q = em.createQuery("select r FROM  OrclassRisque r WHERE r.idEntreprise.idEntreprise= :ide  and r.idPolice.id= :police and r.idAvenant= :avenant  ORDER BY r.id")
                .setParameter("ide", e.getIdEntreprise())
                .setParameter("police", police.getId())
                .setParameter("avenant", avenant) //                .setParameter("agence", police.getIdIntermediaire())
                ;
        return q.getResultList();
    }

    public OrclassRisque risqueByLibelle(OrclassEntreprises e, OrclassPolice police, String libelle) {
        Query q;
        OrclassRisque risque = null;
        q = em.createQuery("select r FROM  OrclassRisque r WHERE r.idEntreprise.idEntreprise= :ide  and r.idPolice.id = :police  and r.libelle= :libelle and r.idAvenant is null")
                .setParameter("ide", e.getIdEntreprise())
                //                .setParameter("num", police.getNumero_police())
                .setParameter("libelle", libelle)
                .setParameter("police", police.getId());
        if (q.getResultList().isEmpty()) {
            risque = new OrclassRisque();
            return risque;
        }
        return (OrclassRisque) q.getResultList().toArray()[0];
    }
    
     public OrclassRisque risqueByHaveAvenant(OrclassEntreprises e, OrclassPolice police, OrclassAvenant av) {
        Query q;
        OrclassRisque risque = null;
        q = em.createQuery("select r FROM  OrclassRisque r WHERE r.idEntreprise.idEntreprise= :ide  and r.idPolice.id = :police  and r.idAvenant= :av")
                .setParameter("ide", e.getIdEntreprise())
                //                .setParameter("num", police.getNumero_police())
                .setParameter("av", av)
                .setParameter("police", police.getId());
        if (q.getResultList().isEmpty()) {
//            risque = new OrclassRisque();
            return null;
        }
        return (OrclassRisque) q.getResultList().toArray()[0];
    }
     public Long nombreAssure(OrclassPolice police,OrclassEntreprises e,OrclasseRefGroupe g){
         Query q;
         Long nombreRisque=0L;
         q=em.createQuery("SELECT COUNT(r) FROM OrclassRisque r WHERE r.idPolice.id= :idp and r.idEntreprise.idEntreprise= :ide and r.idGroup.id= :idg and r.codeid_retirer is null")
                 .setParameter("idp", police.getId())
                 .setParameter("idg", g.getId())
                 .setParameter("ide", e.getIdEntreprise());
         nombreRisque=(Long) q.getSingleResult();
         return nombreRisque==null ? 0L:nombreRisque;
         
     }
}
