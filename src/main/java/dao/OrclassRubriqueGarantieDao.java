/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import enums.NatureGarantie;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import modele.OrclassCategories;
import modele.OrclassEntreprises;
import modele.OrclassGarantie;
import modele.OrclassRubrique;
import modele.OrclassRubriqueCategorie;
import modele.OrclassRubriqueGarantie;
import modele.OrclassTypeTarif;
import modele.OrclasseRefGroupe;

/**
 *
 * @author hp
 */
@Stateless
public class OrclassRubriqueGarantieDao extends AbstractJpaDAO<OrclassRubriqueGarantie> {

    private static final long serialVersionUID = 1L;
    @PersistenceContext(unitName = AbstractJpaDAO.PersistanceUnit)
    private EntityManager em;

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @Override
    protected Class<OrclassRubriqueGarantie> getEntityClass() {
        return OrclassRubriqueGarantie.class;
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public OrclassRubriqueGarantie finkey(OrclassRubrique r, OrclassTypeTarif t, OrclassEntreprises e, OrclassGarantie g, Date effet, Date echeance) {
        Query q;
        q = em.createQuery("SELECT rg FROM OrclassRubriqueGarantie rg WHERE rg.dateEffet= :effet and rg.dateEcheance= :echeance and rg.idEntreprise.idEntreprise= :idEntreprise and rg.idRubrique.id= :id and rg.idGarantie.id= :id2 ")
                .setParameter("effet", effet)
                .setParameter("echeance", echeance)
                .setParameter("idEntreprise", e.getIdEntreprise())
                .setParameter("id", r.getId())
                .setParameter("id2", g.getId());
        if (q.getResultList().isEmpty()) {
            return null;
        }
        return (OrclassRubriqueGarantie) q.getResultList().toArray()[0];
    }

    public OrclassRubriqueGarantie lastRubriqueGarantieForCompagny(OrclassRubrique r, OrclassTypeTarif t, OrclassEntreprises e, OrclassGarantie g) {
        Query q;
        q = em.createQuery("SELECT rgg FROM OrclassRubriqueGarantie rgg WHERE rgg.id=(SELECT MAX (rg.id) FROM OrclassRubriqueGarantie rg WHERE  rg.idEntreprise.idEntreprise= :idEntreprise and rg.idRubrique.id= :id and rg.idGarantie.id= :id2 )")
                //                .setParameter("effet", effet)
                //                .setParameter("echeance", echeance)
                .setParameter("idEntreprise", e.getIdEntreprise())
                .setParameter("id", r.getId())
                .setParameter("id2", g.getId());
        if (q.getResultList().isEmpty()) {
            return null;
        }
        return (OrclassRubriqueGarantie) q.getResultList().toArray()[0];
    }

    public List<OrclassRubriqueGarantie> listeRubriqueGarantieByCategorie(OrclassCategories c, OrclassEntreprises e) {
        Query q;
        q = em.createQuery("SELECT rg FROM  OrclassRubriqueGarantie rg  WHERE rg.idGarantie.idCategories.idCategorie= :idCategorie and rg.idEntreprise.idEntreprise= :idEntreprise")
                .setParameter("idCategorie", c.getIdCategorie())
                .setParameter("idEntreprise", e.getIdEntreprise());
        return q.getResultList();
    }

    public List<OrclassRubriqueGarantie> listeRubriqueGarantieByCompagnies(OrclassEntreprises e) {
        Query q;
        q = em.createQuery("SELECT rg FROM  OrclassRubriqueGarantie rg  WHERE  rg.idEntreprise.idEntreprise= :idEntreprise")
                .setParameter("idEntreprise", e.getIdEntreprise());
        return q.getResultList();
    }

    public List<OrclassRubriqueGarantie> listeRubriqueGarantieByTarifAndGarantie(OrclassTypeTarif t, OrclassGarantie g, OrclassEntreprises e) {
        Query q;
        q = em.createQuery("SELECT rg FROM  OrclassRubriqueGarantie rg  WHERE rg.idGarantie.id= :id and rg.idEntreprise.idEntreprise= :idEntreprise and rg.idTypeTarif.id= :id2")
                .setParameter("id", g.getId())
                .setParameter("idEntreprise", e.getIdEntreprise())
                .setParameter("id2", t.getId());
        ;
        return q.getResultList();

    }

    public List<OrclassRubriqueGarantie> listeRubriqueGarantieByTarifAndGarantie(OrclassTypeTarif t, OrclassGarantie g) {
        Query q;
        q = em.createQuery("SELECT rg FROM  OrclassRubriqueGarantie rg  WHERE rg.idGarantie.id= :id  and rg.idTypeTarif.id= :id2 and (rg.idGarantie.globalCompagnie=1 or rg.idGarantie.globalCompagnie=true)")
                .setParameter("id", g.getId())
                //                .setParameter("idEntreprise", e.getIdEntreprise())
                .setParameter("id2", t.getId());
        ;
        return q.getResultList();
    }

    /*
      lister les rubriqueayant les garanties
     */
    public List<OrclassRubrique> listeRubriqueHaveGarantieByTarifAndGarantie(OrclassTypeTarif t, OrclassGarantie g, OrclassEntreprises e) {
        Query q;
        q = em.createQuery("SELECT rg.idRubrique FROM  OrclassRubriqueGarantie rg  WHERE rg.idGarantie.id= :id and rg.idEntreprise.idEntreprise= :idEntreprise and rg.idTypeTarif.id= :id2")
                .setParameter("id", g.getId())
                .setParameter("idEntreprise", e.getIdEntreprise())
                .setParameter("id2", t.getId());
        ;
        return q.getResultList();
    }

    public List<OrclassRubrique> listeRubriqueHaveGarantieByTarifAndGarantie(OrclassTypeTarif t, OrclassGarantie g) {
        Query q;
        q = em.createQuery("SELECT rg.idRubrique FROM  OrclassRubriqueGarantie rg  WHERE rg.idGarantie.id= :id  and rg.idTypeTarif.id= :id2")
                .setParameter("id", g.getId())
                //                .setParameter("idEntreprise", e.getIdEntreprise())
                .setParameter("id2", t.getId());
        ;
        return q.getResultList();
    }

    public List<OrclassGarantie> listeRubriqueGarantieByTarifAndCategorie(OrclassTypeTarif t, OrclassRubriqueCategorie rb, OrclassEntreprises e) {
        Query q;
        q = em.createQuery("SELECT DISTINCT rg.idGarantie FROM  OrclassRubriqueGarantie rg  WHERE rg.idGarantie.idCategories.idCategorie= :idCategorie and rg.idEntreprise.idEntreprise= :idEntreprise and rg.idTypeTarif.id= :id2 ")
                //                .setParameter("id", rb.getIdRubrique().getId())
                .setParameter("idEntreprise", e.getIdEntreprise())
                .setParameter("idCategorie", rb.getIdCategories().getIdCategorie())
                .setParameter("id2", t.getId());

        return q.getResultList();
    }

    public List<OrclassGarantie> listeRubriqueGarantieByTarifAndCategorie(OrclassTypeTarif t, OrclassCategories rb, OrclassEntreprises e) {
        Query q;
        q = em.createQuery("SELECT DISTINCT rg.idGarantie FROM  OrclassRubriqueGarantie rg  WHERE rg.idGarantie.idCategories.idCategorie= :idCategorie and rg.idEntreprise.idEntreprise= :idEntreprise and rg.idTypeTarif.id= :id2 ")
                //                .setParameter("id", rb.getIdRubrique().getId())
                .setParameter("idEntreprise", e.getIdEntreprise())
                .setParameter("idCategorie", rb.getIdCategorie())
                .setParameter("id2", t.getId());

        return q.getResultList();
    }

    /*
    retourne la derniere prime nette de la garantie
     */
    public OrclassRubriqueGarantie listeRubriqueGarantiePrimeNetteByTarifAndCategorieForCompagnie(OrclassTypeTarif t, OrclassCategories rb, OrclassGarantie g, OrclassEntreprises e) {
        Query q;
        q = em.createQuery("SELECT DISTINCT rg FROM  OrclassRubriqueGarantie rg  WHERE rg.idGarantie.idCategories.idCategorie= :idCategorie and rg.idEntreprise.idEntreprise= :idEntreprise and rg.idTypeTarif.id= :id2  and rg.idRubrique.primeNette= :prime and rg.idGarantie= :g ORDER BY rg.dateEffet DESC")
                .setParameter("prime", Boolean.TRUE)
                .setParameter("idEntreprise", e.getIdEntreprise())
                .setParameter("idCategorie", rb.getIdCategorie())
                .setParameter("g", g)
                .setParameter("id2", t.getId());
        if (q.getResultList().isEmpty()) {
            return null;
        }

        return (OrclassRubriqueGarantie) q.getResultList().toArray()[0];
    }

    public OrclassRubriqueGarantie listeRubriqueGarantiePrimeNetteByTarifAndCategorieForCompagnie(OrclassTypeTarif t, OrclassCategories rb, OrclassGarantie g) {
        Query q;
        q = em.createQuery("SELECT DISTINCT rg FROM  OrclassRubriqueGarantie rg  WHERE rg.idGarantie.idCategories.idCategorie= :idCategorie and  rg.idTypeTarif.id= :id2  and rg.idRubrique.primeNette= :prime and rg.idGarantie.globalCompagnie= :global and rg.idGarantie= :g ORDER BY rg.dateEffet DESC")
                .setParameter("prime", Boolean.TRUE)
                .setParameter("global", Boolean.TRUE)
                .setParameter("g", g)
                .setParameter("idCategorie", rb.getIdCategorie())
                .setParameter("id2", t.getId());
        if (q.getResultList().isEmpty()) {
            return null;
        }

        return (OrclassRubriqueGarantie) q.getResultList().toArray()[0];
    }

    public OrclassRubriqueGarantie listeRubriqueGarantieByTarifAndCategorieForCompagnie(OrclassTypeTarif t, OrclassCategories rb, OrclassEntreprises e) {
        Query q;
        q = em.createQuery("SELECT DISTINCT rg FROM  OrclassRubriqueGarantie rg  WHERE rg.idGarantie.idCategories.idCategorie= :idCategorie and rg.idEntreprise.idEntreprise= :idEntreprise and rg.idTypeTarif.id= :id2  and rg.idRubrique.primeNette= :prime ORDER BY rg.dateEffet DESC")
                .setParameter("prime", Boolean.FALSE)
                .setParameter("idEntreprise", e.getIdEntreprise())
                .setParameter("idCategorie", rb.getIdCategorie())
                .setParameter("id2", t.getId());
        if (q.getResultList().isEmpty()) {
            return null;
        }

        return (OrclassRubriqueGarantie) q.getResultList().toArray()[0];
    }

    public List<OrclassGarantie> listeRubriqueGarantieByTarifAndCategorieFprAllCompagnie(OrclassTypeTarif t, OrclassCategories rb) {
        Query q;
        q = em.createQuery("SELECT DISTINCT rg.idGarantie FROM  OrclassRubriqueGarantie rg  WHERE rg.idGarantie.idCategories.idCategorie= :idCategorie  and rg.idTypeTarif.id= :id2  and (rg.idGarantie.globalCompagnie=1 or rg.idGarantie.globalCompagnie=true)")
                //                .setParameter("id", rb.getIdRubrique().getId())
                //                .setParameter("idEntreprise", e.getIdEntreprise())
                .setParameter("idCategorie", rb.getIdCategorie())
                .setParameter("id2", t.getId());

        return q.getResultList();
    }

    public List<OrclassGarantie> listeRubriqueGarantieByTarifAndCategorieForGroup(OrclassTypeTarif t, OrclassCategories cat, OrclassEntreprises e, OrclasseRefGroupe group) {
        Query q;
        q = em.createQuery("SELECT DISTINCT rg.idGarantie FROM  OrclassRubriqueGarantie rg  WHERE NOT  EXISTS  (SELECT DISTINCT p.idGarantie FROM  OrclassPoliceGarantie p where  p.idGarantie= rg.idGarantie and p.idPolice.idTypeTarif= :t and p.idPolice.idCategories= :c and p.idEntreprise= :e and p.idGroup= :g) and rg.idGarantie.natureGarantie!= :n")
                //                .setParameter("id", rb.getIdRubrique().getId())
                .setParameter("e", e)
                .setParameter("c", cat)
                .setParameter("g", group)
                .setParameter("n", NatureGarantie.obligatoire)
                .setParameter("t", t);

        return q.getResultList();
    }

    public List<OrclassGarantie> listeRubriqueGarantieByTarifAndCategorieNOtExistePoliceGarantie(OrclassTypeTarif t, OrclassCategories cat, OrclassEntreprises e) {
        Query q;
        q = em.createQuery("SELECT DISTINCT rg.idGarantie FROM  OrclassRubriqueGarantie rg  WHERE NOT  EXISTS  (SELECT DISTINCT p.idGarantie FROM  OrclassPoliceGarantie p where  p.idGarantie= rg.idGarantie and p.idPolice.idTypeTarif= :t and p.idPolice.idCategories= :c and p.idEntreprise= :e  and p.idGroup is null) and rg.idGarantie.natureGarantie!= :n")
                //                .setParameter("id", rb.getIdRubrique().getId())
                .setParameter("e", e)
                .setParameter("c", cat)
                //                .setParameter("g", group)
                .setParameter("n", NatureGarantie.obligatoire)
                .setParameter("t", t);

        return q.getResultList();
    }
    
public List<OrclassGarantie> listeRubriqueGarantieByTarifAndCategorieExistePoliceGarantieOligatoire(OrclassTypeTarif t, OrclassCategories cat, OrclassEntreprises e) {
        Query q;
        q = em.createQuery("SELECT DISTINCT rg.idGarantie FROM  OrclassRubriqueGarantie rg  WHERE   EXISTS  (SELECT DISTINCT p.idGarantie FROM  OrclassPoliceGarantie p where  p.idGarantie= rg.idGarantie and p.idPolice.idTypeTarif= :t and p.idPolice.idCategories= :c and p.idEntreprise= :e  ) and rg.idGarantie.natureGarantie!= :n")
                //                .setParameter("id", rb.getIdRubrique().getId())
                .setParameter("e", e)
                .setParameter("c", cat)
                //                .setParameter("g", group)
                .setParameter("n", NatureGarantie.obligatoire)
                .setParameter("t", t);

        return q.getResultList();
    }
    public OrclassRubriqueGarantie listeRubriqueGarantieNotPrimeNetteByTarifAndCategorieForCompagnie(OrclassTypeTarif t, OrclassCategories rb, OrclassGarantie g, OrclassRubrique r) {
        Query q;
        List<OrclassRubriqueGarantie> listeRg = new ArrayList<>();
        q = em.createQuery("SELECT DISTINCT rg FROM  OrclassRubriqueGarantie rg  WHERE rg.idGarantie.idCategories.idCategorie= :idCategorie and  rg.idTypeTarif.id= :id2  and rg.idRubrique= :r and rg.idGarantie.globalCompagnie= :global and rg.idGarantie= :g ORDER BY rg.dateEffet DESC")
                .setParameter("r", r)
                .setParameter("global", Boolean.TRUE)
                .setParameter("g", g)
                .setParameter("idCategorie", rb.getIdCategorie())
                .setParameter("id2", t.getId());
        if (q.getResultList().isEmpty()) {
            return null;
        }
        listeRg = q.getResultList();
        for (OrclassRubriqueGarantie rg : listeRg) {
            System.out.println("rubrique:" + rg.getIdRubrique().getCode() + "-" + rg.getIdRubrique().getLibelle());
            System.out.println("date effett:" + rg.getDateEffet() + "- date echeance: " + rg.getDateEcheance());
            System.out.println("garantie: " + rg.getIdGarantie().getIdRefGaranties().getCode() + "- " + rg.getIdGarantie().getIdRefGaranties().getLibelle());
            System.out.println("id_rubrigueGarantie:" + rg.getId() );
        }

        return (OrclassRubriqueGarantie) q.getResultList().toArray()[0];
    }

    public OrclassRubriqueGarantie listeRubriqueGarantieNotPrimeNetteByTarifAndCategorieForCompagnie(OrclassTypeTarif t, OrclassCategories rb, OrclassGarantie g, OrclassRubrique r, OrclassEntreprises e) {
        Query q;
        List<OrclassRubriqueGarantie> listeRg = new ArrayList<>();
        q = em.createQuery("SELECT DISTINCT rg FROM  OrclassRubriqueGarantie rg  WHERE rg.idGarantie.idCategories.idCategorie= :idCategorie and  rg.idTypeTarif.id= :id2  and rg.idRubrique= :r and  rg.idGarantie= :g and rg.idEntreprise= :e ORDER BY rg.dateEffet DESC")
                .setParameter("r", r)
                //                 .setParameter("global", Boolean.TRUE)
                .setParameter("g", g)
                .setParameter("e", e)
                .setParameter("idCategorie", rb.getIdCategorie())
                .setParameter("id2", t.getId());
        if (q.getResultList().isEmpty()) {
            return null;
        }
           listeRg = q.getResultList();
        for (OrclassRubriqueGarantie rg : listeRg) {
            System.out.println("rubrique:" + rg.getIdRubrique().getCode() + "-" + rg.getIdRubrique().getLibelle());
            System.out.println("date effett:" + rg.getDateEffet() + "- date echeance: " + rg.getDateEcheance());
            System.out.println("garantie: " + rg.getIdGarantie().getIdRefGaranties().getCode() + "- " + rg.getIdGarantie().getIdRefGaranties().getLibelle());
            System.out.println("id_rubrigueGarantie:" + rg.getId() );
        }

        return (OrclassRubriqueGarantie) q.getResultList().toArray()[0];
    }
// public List<OrclassGarantie>  listeGarantieHaveNatureObligatoire(OrclassTypeTarif t, OrclassCategories rb, OrclassGarantie g, OrclassEntreprises e,NatureGarantie n){
//     Query q;
//        List<OrclassRubriqueGarantie> listeRg = new ArrayList<>();
//        q = em.createQuery("SELECT DISTINCT rg.idGarantie FROM  OrclassRubriqueGarantie rg  WHERE rg.idGarantie.idCategories.idCategorie= :idCat and  rg.idTypeTarif.id= :id2   and rg.idEntreprise= :e  ORDER BY rg.dateEffet DESC")
//         
// }

}
