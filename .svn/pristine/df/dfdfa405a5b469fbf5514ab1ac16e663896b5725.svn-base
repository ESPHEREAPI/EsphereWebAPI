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
import modele.OrclassApporteur;
import modele.OrclassCategories;
import modele.OrclassCommission_Prime_Apporteur;
import modele.OrclassCommission_Prime_Intermediaire;
import modele.OrclassEntreprises;
import modele.OrclassGarantie;
import modele.OrclassIntermediaires;
import modele.OrclassTypeApporteur;
import modele.OrclassTypeBureau;

/**
 *
 * @author hp
 */
@Stateless
public class OrclassCommission_Prime_IntermediaireDao extends AbstractJpaDAO<OrclassCommission_Prime_Intermediaire> {
    
      private static final long serialVersionUID = 1L;
    @PersistenceContext(unitName = AbstractJpaDAO.PersistanceUnit)
    private EntityManager em;

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    protected Class<OrclassCommission_Prime_Intermediaire> getEntityClass() {
      return OrclassCommission_Prime_Intermediaire.class;
    }

    @Override
    protected EntityManager getEntityManager() {
      return em;
    }
    
    /*
    recuperer les primes d un apporteur specifique
     */
    public OrclassCommission_Prime_Intermediaire getPrimeCommissionByIntermediaire(OrclassIntermediaires i, OrclassCategories cat, OrclassEntreprises e) {
        Query q;
        q = em.createQuery("SELECT cpa FROM OrclassCommission_Prime_Intermediaire cpa WHERE cpa.idIntermediaire.idIntermediaire= :idIntermediaire AND cpa.idCategories.idCategorie= :idCategorie AND cpa.idEntreprise.idEntreprise= :idEntreprise and cpa.actif= :actif")
                .setParameter("idIntermediaire", i.getIdIntermediaire())
                .setParameter("idCategorie", cat.getIdCategorie())
                .setParameter("idEntreprise", e.getIdEntreprise())
                .setParameter("actif", Boolean.TRUE);
        if (q.getResultList().isEmpty()) {
            return null;
        }
        return (OrclassCommission_Prime_Intermediaire) q.getResultList().toArray()[0];

    }
    
    /*
    lister tous les primes des intermediaires lier a une categorie
    */

     public List<OrclassCommission_Prime_Intermediaire> getPrimeCommissionByCategories( OrclassCategories cat, OrclassEntreprises e) {
        Query q;
        q = em.createQuery("SELECT cpa FROM OrclassCommission_Prime_Intermediaire cpa WHERE cpa.idCategories.idCategorie= :idCategorie AND cpa.idEntreprise.idEntreprise= :idEntreprise and cpa.actif= :actif")
              
                .setParameter("idCategorie", cat.getIdCategorie())
                .setParameter("idEntreprise", e.getIdEntreprise())
                .setParameter("actif", Boolean.TRUE);
        if (q.getResultList().isEmpty()) {
            return null;
        }
        return  q.getResultList();

    }
    
    /*
    recupere la prime d un type de bureau
     */
    public OrclassCommission_Prime_Intermediaire getPrimeCommissionByTypeBureau(OrclassTypeBureau tp, OrclassCategories cat, OrclassEntreprises e) {
        Query q;
        q = em.createQuery("SELECT cpa FROM OrclassCommission_Prime_Intermediaire cpa WHERE cpa.idTypeBureau.id= :idTypeBureau AND cpa.idCategories.idCategorie= :idCategorie AND cpa.idEntreprise.idEntreprise= :idEntreprise and cpa.actif= :actif and cpa.idIntermediaire is null and cpa.idGarantie is null")
                .setParameter("idTypeBureau", tp.getId())
                .setParameter("idCategorie", cat.getIdCategorie())
                .setParameter("idEntreprise", e.getIdEntreprise())
                .setParameter("actif", Boolean.TRUE);
        if (q.getResultList().isEmpty()) {
            return null;
        }
        return (OrclassCommission_Prime_Intermediaire) q.getResultList().toArray()[0];

    }

    /*
      recuperer la prime d un type bureau pour une garantie precis
     */
    public OrclassCommission_Prime_Intermediaire getPrimeCommissionByTypeBureauHaveGarantie(OrclassTypeBureau tp, OrclassCategories cat, OrclassGarantie ga, OrclassEntreprises e) {
        Query q;
        q = em.createQuery("SELECT cpa FROM OrclassCommission_Prime_Intermediaire cpa WHERE cpa.idTypeBureau.id= :idTypeBureau AND cpa.idCategories.idCategorie= :idCategorie AND cpa.idEntreprise.idEntreprise= :idEntreprise and cpa.actif= :actif and cpa.idIntermediaire is null and cpa.idGarantie.id= :id")
                .setParameter("idTypeBureau", tp.getId())
                .setParameter("idCategorie", cat.getIdCategorie())
                .setParameter("idEntreprise", e.getIdEntreprise())
                .setParameter("id", ga.getId())
                .setParameter("actif", Boolean.TRUE);
        if (q.getResultList().isEmpty()) {
            return null;
        }
        return (OrclassCommission_Prime_Intermediaire) q.getResultList().toArray()[0];

    }

    /*
       recuperer la prime pour une garantie lier a un apporteur
     */
    public OrclassCommission_Prime_Intermediaire getPrimeCommissionByIntermediaireHaveGarantie(OrclassIntermediaires i, OrclassCategories cat, OrclassGarantie ga, OrclassEntreprises e) {
        Query q;
        q = em.createQuery("SELECT cpa FROM OrclassCommission_Prime_Intermediaire cpa WHERE cpa.idIntermediaire.idIntermediaire= :idIntermediaire AND cpa.idCategories.idCategorie= :idCategorie AND cpa.idEntreprise.idEntreprise= :idEntreprise and cpa.actif= :actif and cpa.idGarantie.id= :id")
                .setParameter("idIntermediaire", i.getIdIntermediaire())
                .setParameter("idCategorie", cat.getIdCategorie())
                .setParameter("idEntreprise", e.getIdEntreprise())
                .setParameter("id", ga.getId())
                .setParameter("actif", Boolean.TRUE);
        if (q.getResultList().isEmpty()) {
            return null;
        }
        return (OrclassCommission_Prime_Intermediaire) q.getResultList().toArray()[0];

    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    /*
         lister tous commission primze actif d une compagnie
     */
    public List<OrclassCommission_Prime_Intermediaire> listeCommisionPrimeCompagnieIsActi(OrclassEntreprises e) {
        Query q;
        q = em.createQuery("SELECT p FROM OrclassCommission_Prime_Intermediaire p WHERE p.idEntreprise.idEntreprise= :idEntreprise and p.actif= :value")
                .setParameter("idEntreprise", e.getIdEntreprise())
                .setParameter("value", Boolean.TRUE);
        return q.getResultList();
    }
    
}
