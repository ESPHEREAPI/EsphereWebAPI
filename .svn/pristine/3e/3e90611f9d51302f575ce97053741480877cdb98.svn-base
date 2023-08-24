/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import modele.OrclassApporteur;
import modele.OrclassCategories;
import modele.OrclassCommission_Prime_Apporteur;
import modele.OrclassEntreprises;
import modele.OrclassGarantie;
import modele.OrclassRefApporteur;
import modele.OrclassTypeApporteur;

/**
 *
 * @author hp
 */
@Stateless
public class OrclassCommission_Prime_ApporteurDao extends AbstractJpaDAO<OrclassCommission_Prime_Apporteur> {

    private static final long serialVersionUID = 1L;
    @PersistenceContext(unitName = AbstractJpaDAO.PersistanceUnit)
    private EntityManager em;

    @Override
    protected Class<OrclassCommission_Prime_Apporteur> getEntityClass() {
        return OrclassCommission_Prime_Apporteur.class;
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    /*
    recuperer les primes d un apporteur specifique
     */
    public OrclassCommission_Prime_Apporteur getPrimeCommissionByApporteur(OrclassApporteur ap, OrclassCategories cat, OrclassEntreprises e) {
        Query q;
        q = em.createQuery("SELECT cpa FROM OrclassCommission_Prime_Apporteur cpa WHERE cpa.idApporteur.idApporteur= :idApporteur AND cpa.idCategories.idCategorie= :idCategorie AND cpa.idEntreprise.idEntreprise= :idEntreprise and cpa.actif= :actif and cpa.idGarantie is null")
                .setParameter("idApporteur", ap.getIdApporteur())
                .setParameter("idCategorie", cat.getIdCategorie())
                .setParameter("idEntreprise", e.getIdEntreprise())
                .setParameter("actif", Boolean.TRUE);
        if (q.getResultList().isEmpty()) {
            return null;
        }
        return (OrclassCommission_Prime_Apporteur) q.getResultList().toArray()[0];

    }

    /*
    lister tous les primes des apporteurs lier a une categorie
     */
    public List<OrclassCommission_Prime_Apporteur> getPrimeCommissionByCategories(OrclassCategories cat, OrclassEntreprises e) {
        Query q;
        q = em.createQuery("SELECT cpa FROM OrclassCommission_Prime_Apporteur cpa WHERE cpa.idCategories.idCategorie= :idCategorie AND cpa.idEntreprise.idEntreprise= :idEntreprise and cpa.actif= :actif")
                .setParameter("idCategorie", cat.getIdCategorie())
                .setParameter("idEntreprise", e.getIdEntreprise())
                .setParameter("actif", Boolean.TRUE);
        if (q.getResultList().isEmpty()) {
            return null;
        }
        return q.getResultList();

    }

    /*
    recupere la prime d un type d apporteur
     */
    public OrclassCommission_Prime_Apporteur getPrimeCommissionByTypeApporteur(OrclassTypeApporteur tp, OrclassCategories cat, OrclassEntreprises e) {
        Query q;
        q = em.createQuery("SELECT cpa FROM OrclassCommission_Prime_Apporteur cpa WHERE cpa.idTypeApporteur.typeApporteur= :idApporteur AND cpa.idCategories.idCategorie= :idCategorie AND cpa.idEntreprise.idEntreprise= :idEntreprise and cpa.actif= :actif and cpa.idApporteur is null and cpa.idGarantie is null")
                .setParameter("idApporteur", tp.getTypeApporteur())
                .setParameter("idCategorie", cat.getIdCategorie())
                .setParameter("idEntreprise", e.getIdEntreprise())
                .setParameter("actif", Boolean.TRUE);
        if (q.getResultList().isEmpty()) {
            return null;
        }
        return (OrclassCommission_Prime_Apporteur) q.getResultList().toArray()[0];

    }

    /*
      recuperer la prime d un type Apporteur pour une garantie precis
     */
    public OrclassCommission_Prime_Apporteur getPrimeCommissionByTypeApporteurHaveGarantie(OrclassTypeApporteur tp, OrclassCategories cat, OrclassGarantie ga, OrclassEntreprises e) {
        Query q;
        q = em.createQuery("SELECT cpa FROM OrclassCommission_Prime_Apporteur cpa WHERE cpa.idTypeApporteur.typeApporteur= :idApporteur AND cpa.idCategories.idCategorie= :idCategorie AND cpa.idEntreprise.idEntreprise= :idEntreprise and cpa.actif= :actif and cpa.idApporteur is null and cpa.idGarantie.id= :id and cpa.idApporteur is null")
                .setParameter("idApporteur", tp.getTypeApporteur())
                .setParameter("idCategorie", cat.getIdCategorie())
                .setParameter("idEntreprise", e.getIdEntreprise())
                .setParameter("id", ga.getId())
                .setParameter("actif", Boolean.TRUE);
        if (q.getResultList().isEmpty()) {
            return null;
        }
        return (OrclassCommission_Prime_Apporteur) q.getResultList().toArray()[0];

    }

    /*
       recuperer la prime pour une garantie lier a un apporteur
     */
    public OrclassCommission_Prime_Apporteur getPrimeCommissionByApporteurHaveGarantie(OrclassApporteur ap, OrclassCategories cat, OrclassGarantie ga, OrclassEntreprises e) {
        Query q;
        q = em.createQuery("SELECT cpa FROM OrclassCommission_Prime_Apporteur cpa WHERE cpa.idApporteur.idApporteur= :idApporteur AND cpa.idCategories.idCategorie= :idCategorie AND cpa.idEntreprise.idEntreprise= :idEntreprise and cpa.actif= :actif and cpa.idGarantie.id= :id")
                .setParameter("idApporteur", ap.getIdApporteur())
                .setParameter("idCategorie", cat.getIdCategorie())
                .setParameter("idEntreprise", e.getIdEntreprise())
                .setParameter("id", ga.getId())
                .setParameter("actif", Boolean.TRUE);
        if (q.getResultList().isEmpty()) {
            return null;
        }
        return (OrclassCommission_Prime_Apporteur) q.getResultList().toArray()[0];

    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    /*
         lister tous commission primze actif d une compagnie
     */
    public List<OrclassCommission_Prime_Apporteur> listeCommisionPrimeCompagnieIsActi(OrclassEntreprises e) {
        Query q;
        q = em.createQuery("SELECT p FROM OrclassCommission_Prime_Apporteur p WHERE p.idEntreprise.idEntreprise= :idEntreprise and p.actif= :value")
                .setParameter("idEntreprise", e.getIdEntreprise())
                .setParameter("value", Boolean.TRUE);
        return q.getResultList();
    }

    public List<OrclassApporteur> listeApporteurHaveCommissionByEntreprise(OrclassEntreprises e) {
        Query q;
        q = em.createQuery("SELECT DISTINCT ap FROM OrclassApporteur ap  JOIN ap.idTypeApporteur.commission_Prime_ApporteurList c   WHERE c.idEntreprise.idEntreprise= :idEntreprise and c.actif= :value")
                .setParameter("idEntreprise", e.getIdEntreprise())
                .setParameter("value", Boolean.TRUE);
        return q.getResultList();
    }

    /*
    lister les apporteur pour une compagnies precis et pour un produit precis
     */
    public List<OrclassApporteur> listeApporteurHavePrimeIsActi(OrclassEntreprises e, OrclassCategories cat) {
        Query q;
        List<OrclassApporteur> listeApproteur = new ArrayList<>();
        List<OrclassApporteur> listeApproteurFinal = new ArrayList<>();
        List<OrclassRefApporteur> listeRefApporteur = new ArrayList<>();
        q = em.createQuery("SELECT DISTINCT p.idApporteur FROM OrclassCommission_Prime_Apporteur p WHERE p.idEntreprise.idEntreprise= :idEntreprise and p.actif= :value and p.idCategories.idCategorie= :idCategorie")
                .setParameter("idEntreprise", e.getIdEntreprise())
                .setParameter("idCategorie", cat.getIdCategorie())
                .setParameter("value", Boolean.TRUE);
        listeApproteur = q.getResultList();
        for (OrclassApporteur ap : listeApproteur) {
            if (listeApproteurFinal.isEmpty()) {
                listeApproteurFinal.add(ap);
                listeRefApporteur.add(ap.getIdRefApporteur());
            } else {
                if (listeRefApporteur.contains(ap.getIdRefApporteur()) == Boolean.FALSE) {
                    listeApproteurFinal.add(ap);
                }
            }
        }
        return listeApproteurFinal;
    }
}
