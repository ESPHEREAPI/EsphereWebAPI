/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import javax.ejb.StatefulTimeout;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import modele.OrclassBranches;
import modele.OrclassCaracteristiques;
import modele.OrclassEntreprises;
import modele.OrclassRegistreProduction;
import modele.OrclassRubriqueGarantie;
import modele.Orclass_Access_Avenant;
import modele.Orclass_Objet;

/**
 *
 * @author hp
 */
@Stateless
//@StatefulTimeout(36000)
public class OrclassCaracteristiquesDao extends AbstractJpaDAO<OrclassCaracteristiques> {

    private static final long serialVersionUID = 1L;
    @PersistenceContext(unitName = AbstractJpaDAO.PersistanceUnit)
    private EntityManager em;

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @Override
    protected Class<OrclassCaracteristiques> getEntityClass() {
        return OrclassCaracteristiques.class;
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    /*
    liste les caracteristiques visible par tous les compagnies
     */
    public List<OrclassCaracteristiques> listeCaracteristiqueForAllCompagnies() {
        Query q;
        q = em.createQuery("SELECT c FROM OrclassCaracteristiques c WHERE  c.showAllCompagnies= :value and c.idEntreprise is null")
                .setParameter("value", Boolean.TRUE);
        return q.getResultList();
    }

    /*
    liste les caracterisques pour une entreprise prise
     */
    public List<OrclassCaracteristiques> listCaracteristiqueByCompagnie(OrclassEntreprises e) {
        Query q;
        q = em.createQuery("SELECT c FROM OrclassCaracteristiques c WHERE c.idEntreprise.idEntreprise= :idEntreprise and c.showAllCompagnies= :value")
                .setParameter("idEntreprise", e.getIdEntreprise())
                .setParameter("value", Boolean.FALSE);
        return q.getResultList();
    }

    /*
    lister les caracteristique   n existant pas dans la rubriqueCaracteristique
     */
    public List<OrclassCaracteristiques> listCaracteristiqueNotHaveRubriqueByCompagnie(OrclassEntreprises e) {
        Query q;
        q = em.createQuery("SELECT c FROM OrclassCaracteristiques c WHERE  NOT EXISTS (SELECT rc.idCaracteristiques FROM OrclassRubriqueCaracteristique rc where rc.idEntreprise.idEntreprise= :idEntreprise)")
                .setParameter("idEntreprise", e.getIdEntreprise());

        return q.getResultList();
    }

    public List<OrclassCaracteristiques> listCaracteristiqueHaveRubriqueByCompagnie(OrclassEntreprises e, OrclassRubriqueGarantie rg) {
        Query q;
        q = em.createQuery("SELECT rc.idCaracteristiques FROM OrclassRubriqueCaracteristique rc where rc.idEntreprise.idEntreprise= :idEntreprise and rc.idRubriqueGarantie.id= :idG and rc.idCategories.idCategorie= :idCategorie")
                .setParameter("idEntreprise", e.getIdEntreprise())
                .setParameter("idG", rg.getId())
//                .setParameter("idRb", rg.getIdRubrique().getId())
                .setParameter("idCategorie", rg.getIdGarantie().getIdCategories().getIdCategorie());

        return q.getResultList();
    }

    public List<OrclassCaracteristiques> listCaracteristiqueHaveByCompagnieByObjet(OrclassEntreprises e, Orclass_Objet objet) {
        Query q;
        q = em.createQuery("SELECT c FROM OrclassCaracteristiques c where c.showAllCompagnies= :valeur and  c.orclass_Objet= :ob and  c.idEntreprise is null ")
                .setParameter("valeur", Boolean.TRUE)
                .setParameter("ob", objet);

        return q.getResultList();
    }

    /*
      liste les caracteristique d objet n ayant pas ete affecter a un avenant
     */
    public List<OrclassCaracteristiques> listCaracteristiqueNotHaveAccessCompagnie(OrclassEntreprises e, Orclass_Access_Avenant access_Avenant) {
        Query q;
        q = em.createQuery("SELECT c FROM OrclassCaracteristiques c WHERE  NOT EXISTS (SELECT acc.idCaracteristiques FROM Orclass_AccessAvenat_Caracteristique acc where acc.idEntreprise.idEntreprise= :idEntreprise and acc.idAccess_Avenant.idObjet= :objet)")
                .setParameter("idEntreprise", e.getIdEntreprise())
                .setParameter("objet", access_Avenant.getIdObjet());

        return q.getResultList();
    }
    public OrclassCaracteristiques finKeyByObjet(String libelle,Orclass_Objet objet){
        Query q;
        q=em.createQuery("SELECT c FROM OrclassCaracteristiques c WHERE c.orclass_Objet= :objet and c.libelle= :lib and c.showAllCompagnies= :value and c.idEntreprise is null")
                .setParameter("lib", libelle)
                .setParameter("value", Boolean.TRUE)
                .setParameter("objet", objet);
        if (q.getResultList().isEmpty()) {
            return null;
        }
        return  (OrclassCaracteristiques) q.getResultList().toArray()[0];
    }
    
       public List<Orclass_Objet> listeObjetNotHaveCaracteristiqueByBranche(OrclassBranches br) {
        Query q;
        q = em.createQuery("SELECT o FROM Orclass_Objet o WHERE  NOT EXISTS (SELECT c.orclass_Objet FROM OrclassCaracteristiques c where c.orclass_Objet= :o and c.orclass_Objet.idBranche= :br)")
                .setParameter("br", br)
                ;

        return q.getResultList();
    }
       
          public List<String> finKeyCaracteristideByLibelleWithfilter(String filter){
        Query q = null;
          String request = "SELECT c.libelle FROM OrclassCaracteristiques c WHERE ";

         if (filter != null && !filter.trim().equals("")) {
            request += "c.libelle like :filter ";

            q = em.createQuery(request)
//                    .setParameter("idEntreprise", e.getIdEntreprise())
                    .setParameter("filter", "%" + filter + "%") ;

        }

        return q.getResultList();
                
    }
           public OrclassCaracteristiques finKeyBylibelle(String libelle){
        Query q;
        q=em.createQuery("SELECT c FROM OrclassCaracteristiques c WHERE c.libelle= :lib ")
                .setParameter("lib", libelle)
//                .setParameter("value", Boolean.TRUE)
//                .setParameter("objet", objet)
                ;
        if (q.getResultList().isEmpty()) {
            return null;
        }
        return  (OrclassCaracteristiques) q.getResultList().toArray()[0];
    }
}
