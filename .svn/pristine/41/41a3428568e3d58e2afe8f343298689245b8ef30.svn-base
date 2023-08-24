/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import enums.StatutCaracteristique;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import modele.OrclassCaracteristiques;
import modele.OrclassCategories;
import modele.OrclassEntreprises;
import modele.OrclassGarantie;
import modele.OrclassPolice;
import modele.OrclassRubrique;
import modele.OrclassRubriqueCaracteristique;
import modele.OrclassRubriqueGarantie;
import modele.OrclasseRefGroupe;

/**
 *
 * @author hp
 */
@Stateless
public class OrclassRubriqueCaracteristiqueDao extends AbstractJpaDAO<OrclassRubriqueCaracteristique> {

    private static final long serialVersionUID = 1L;
    @PersistenceContext(unitName = AbstractJpaDAO.PersistanceUnit)
    private EntityManager em;

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @Override
    protected Class<OrclassRubriqueCaracteristique> getEntityClass() {
        return OrclassRubriqueCaracteristique.class;
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public OrclassRubriqueCaracteristique finKey(OrclassEntreprises e, OrclassCategories cat, OrclassCaracteristiques ca, OrclassRubriqueGarantie rg) {
        Query q;
        q = em.createQuery("SELECT rc FROM OrclassRubriqueCaracteristique rc WHERE rc.idCaracteristiques.id= :idCaracteristiques and rc.idCategories.idCategorie= :idCategorie and rc.idEntreprise.idEntreprise= :idEntreprise  and rc.idRubriqueGarantie.id= :idRG")
                .setParameter("idRG", rg.getId())
                //                .setParameter("idGarantie", g.getId())
                .setParameter("idCategorie", cat.getIdCategorie())
                .setParameter("idEntreprise", e.getIdEntreprise())
                .setParameter("idCaracteristiques", ca.getId());
        if (q.getResultList().isEmpty()) {
            return null;
        }
        return (OrclassRubriqueCaracteristique) q.getResultList();
    }

    public OrclassCaracteristiques caracteristiqueByByRubrique(OrclassEntreprises e, OrclassCategories cat, String codeCaracteristique, OrclassRubriqueGarantie rg) {
        Query q;
        q = em.createQuery("SELECT rc.idCaracteristiques FROM OrclassRubriqueCaracteristique rc WHERE rc.idCaracteristiques.code= :code and rc.idCategories.idCategorie= :idCategorie and rc.idEntreprise.idEntreprise= :idEntreprise  and rc.idRubriqueGarantie.id= :idRG")
                .setParameter("idRG", rg.getId())
                //                .setParameter("idGarantie", g.getId())
                .setParameter("idCategorie", cat.getIdCategorie())
                .setParameter("idEntreprise", e.getIdEntreprise())
                .setParameter("code", codeCaracteristique);
        if (q.getResultList().isEmpty()) {
            return null;
        }
        return (OrclassCaracteristiques) q.getResultList().toArray()[0];
    }

    /*
    liste lesrubrique caracteristiques By compagnie
     */
    public List<OrclassRubriqueCaracteristique> listeRubriqueCaracteristiqueByCompagnies(OrclassEntreprises e, OrclassCategories cat, OrclassRubriqueGarantie rg) {
        Query q;
        q = em.createQuery("SELECT rc FROM OrclassRubriqueCaracteristique rc WHERE rc.idCategories.idCategorie= :idCategorie and rc.idEntreprise.idEntreprise= :idEntreprise and rc.idRubriqueGarantie.id= :id ORDER BY  rc.idRubriqueGarantie.dateEffet DESC")
                .setParameter("idCategorie", cat.getIdCategorie())
                .setParameter("idEntreprise", e.getIdEntreprise())
                .setParameter("id", rg.getId()) //                .setParameter("idRubrique", r.getId())
                ;
        return q.getResultList();
    }

    public List<OrclassRubriqueCaracteristique> listeRubriqueCaracteristiqueByCompagnies(OrclassEntreprises e, OrclassCategories cat, OrclassRubrique rg, OrclassGarantie g) {
        Query q;
        q = em.createQuery("SELECT rc FROM OrclassRubriqueCaracteristique rc WHERE rc.idCategories.idCategorie= :idCategorie and rc.idEntreprise.idEntreprise= :idEntreprise and rc.idRubriqueGarantie.idRubrique.id= :id and rc.idRubriqueGarantie.idGarantie.id= :idg")
                .setParameter("idCategorie", cat.getIdCategorie())
                .setParameter("idEntreprise", e.getIdEntreprise())
                .setParameter("id", rg.getId())
                .setParameter("idg", g.getId()) //                .setParameter("idRubrique", r.getId())
                ;
        return q.getResultList();
    }

    /*
    liste des rubriques carcteriqtique By compagne  and statut
     */

    public List<OrclassCaracteristiques> listeRubriqueCaracteristiqueByCompagnies(OrclassEntreprises e, OrclassCategories cat, StatutCaracteristique statut) {
        Query q;
        q = em.createQuery("SELECT DISTINCT rc.idCaracteristiques FROM OrclassRubriqueCaracteristique rc WHERE rc.idCategories.idCategorie= :idCategorie and rc.idEntreprise.idEntreprise= :idEntreprise and rc.statutCaracteristique= :statut ")
                .setParameter("idCategorie", cat.getIdCategorie())
                .setParameter("idEntreprise", e.getIdEntreprise())
                .setParameter("statut", statut);
//                .setParameter("idRubrique", r.getId());
        return q.getResultList();
    }

//        public List<OrclassCaracteristiques> listeRubriqueCaracteristiqueByCompagnies(OrclassEntreprises e, OrclassCategories cat, StatutCaracteristique statut) {
//        Query q;
//        q = em.createQuery("SELECT DISTINCT rc.idCaracteristiques FROM OrclassRubriqueCaracteristique rc WHERE rc.idCategories.idCategorie= :idCategorie and rc.idEntreprise.idEntreprise= :idEntreprise and rc.statutCaracteristique= :statut ")
//                .setParameter("idCategorie", cat.getIdCategorie())
//                .setParameter("idEntreprise", e.getIdEntreprise())
//                .setParameter("statut", statut);
////                .setParameter("idRubrique", r.getId());
//        return q.getResultList();
//    }
    public List<OrclassCaracteristiques> listeRubriqueCaracteristiqueByCompagnies(OrclassEntreprises e, OrclassCategories cat, OrclassRubrique r) {
        Query q;
        q = em.createQuery("SELECT DISTINCT rc.idCaracteristiques FROM OrclassRubriqueCaracteristique rc WHERE rc.idCategories.idCategorie= :idCategorie and rc.idEntreprise.idEntreprise= :idEntreprise ")
                .setParameter("idCategorie", cat.getIdCategorie())
                .setParameter("idEntreprise", e.getIdEntreprise()) //                .setParameter("statut", statut)
                ;
//                .setParameter("idRubrique", r.getId());
        return q.getResultList();
    }

    //lister tous les caracteristiques n existant pas dans la policarateristique
    public List<OrclassCaracteristiques> listeCaracteristiqueNotHavePoliceCaracteristique(OrclassEntreprises e, OrclassPolice police) {
        Query q;
        q = em.createQuery("SELECT DISTINCT rc.idCaracteristiques FROM OrclassRubriqueCaracteristique rc WHERE NOT EXISTS (SELECT pc.idCaracteristiques FROM OrclassPoliceCaracteristique pc WHERE pc.idCategories= :cat and pc.idEntreprise= :e  AND pc.idPolice= :police and pc.idCaracteristiques=rc.idCaracteristiques  )  ")
                .setParameter("cat", police.getIdCategories())
                .setParameter("e", e)
                .setParameter("police", police);
        return q.getResultList();

    }

    public List<OrclassCaracteristiques> listeRubriqueCaracteristiqueByCompagniesNotSatutObligatoire(OrclassEntreprises e, OrclassCategories cat, OrclassRubrique r, StatutCaracteristique statut) {
        Query q;
        q = em.createQuery("SELECT DISTINCT rc.idCaracteristiques FROM OrclassRubriqueCaracteristique rc WHERE rc.idCategories.idCategorie= :idCategorie and rc.idEntreprise.idEntreprise= :idEntreprise and rc.statutCaracteristique != :statut  ")
                .setParameter("idCategorie", cat.getIdCategorie())
                .setParameter("idEntreprise", e.getIdEntreprise())
                .setParameter("statut", statut) //                .setParameter("idRubrique", r.getId())
                ;
        return q.getResultList();
    }

    public List<OrclassCaracteristiques> listeRubriqueCaracteristiqueByCompagniesNotSatutObligatoire(OrclassEntreprises e, OrclassCategories cat, StatutCaracteristique statut) {
        Query q;
        q = em.createQuery("SELECT DISTINCT rc.idCaracteristiques FROM OrclassRubriqueCaracteristique rc WHERE rc.idCategories.idCategorie= :idCategorie and rc.idEntreprise.idEntreprise= :idEntreprise and rc.statutCaracteristique != :statut  ")
                .setParameter("idCategorie", cat.getIdCategorie())
                .setParameter("idEntreprise", e.getIdEntreprise())
                .setParameter("statut", statut) //                .setParameter("idRubrique", r.getId())
                ;
        return q.getResultList();
    }

    public List<OrclassCaracteristiques> listeRubriqueCaracteristiqueByCompagniesNotHave(OrclassEntreprises e, OrclassPolice p, OrclasseRefGroupe group) {
        Query q;
        q = em.createQuery("SELECT DISTINCT rc.idCaracteristiques FROM OrclassRubriqueCaracteristique rc WHERE NOT EXISTS (select DISTINCT pc.idCaracteristiques from OrclassPoliceCaracteristique pc where pc.idCaracteristiques= rc.idCaracteristiques and pc.idPolice= :p and pc.idEntreprise= :e and pc.idGroup= :g)  and rc.statutCaracteristique!= :statut")
                .setParameter("p", p)
                .setParameter("g", group)
                .setParameter("e", e)
                .setParameter("statut", StatutCaracteristique.obligatoire) //                .setParameter("idRubrique", r.getId())
                ;
        return q.getResultList();
    }

    public List<OrclassCaracteristiques> listeRubriqueCaracteristiqueByCompagniesNotHave(OrclassEntreprises e, OrclassPolice p, OrclassCategories cat) {
        Query q;
        q = em.createQuery("SELECT DISTINCT rc.idCaracteristiques FROM OrclassRubriqueCaracteristique rc WHERE NOT EXISTS (select DISTINCT pc.idCaracteristiques from OrclassPoliceCaracteristique pc where pc.idCaracteristiques= rc.idCaracteristiques and pc.idPolice= :p and pc.idEntreprise= :e and pc.idGroup is null) and rc.idCategories= :cat")
                .setParameter("p", p)
                .setParameter("cat", cat)
                .setParameter("e", e) //                .setParameter("statut", StatutCaracteristique.obligatoire)
                //                .setParameter("idRubrique", r.getId())
                ;
        return q.getResultList();
    }

    // appelle les caracteristique  n existant pas dans la rubrique ce conserne les les garanties pour le mode de calcul manuel
    public List<OrclassCaracteristiques> listeCaracteristiqueByCompagniesNotHave(OrclassEntreprises e, OrclassCategories cat) {
        Query q;
        q = em.createQuery("SELECT c FROM OrclassCaracteristiques c WHERE NOT EXISTS (select DISTINCT rc.idCaracteristiques from OrclassRubriqueCaracteristique rc where rc.idCaracteristiques= c and rc.idCategories= :cat and rc.idEntreprise= :e ) ")
                .setParameter("cat", cat)
                .setParameter("e", e);
        return q.getResultList();
    }

}
