/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import enums.VehiculeObjet;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import modele.OrclassEntreprises;
import modele.OrclassRisque;
import modele.OrclassRubriqueCaracteristique;
import modele.OrclassTarif;
import modele.OrclassTarifCondition;
import modele.OrclassTypeTarif;

/**
 *
 * @author hp frank jiatou
 */
@Stateless
public class OrclassTarifConditionDao extends AbstractJpaDAO<OrclassTarifCondition> {

    private static final long serialVersionUID = 1L;
    @PersistenceContext(unitName = AbstractJpaDAO.PersistanceUnit)
    private EntityManager em;
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    protected Class<OrclassTarifCondition> getEntityClass() {
        return OrclassTarifCondition.class;
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    /*
    liste les condition d une tarif
     */
    public List<OrclassTarifCondition> listConditionByTarif(OrclassTarif t, OrclassEntreprises e) {

        Query q;
        q = em.createQuery("SELECT c FROM OrclassTarifCondition c WHERE c.idTarif.id= :id and c.idEntreprise.idEntreprise= :idEntreprise")
                .setParameter("id", t.getId())
                .setParameter("idEntreprise", e.getIdEntreprise());
        return q.getResultList();
    }

    public List<OrclassRubriqueCaracteristique> listRubriqueCaracteristiqueByTarif(OrclassTarif t, OrclassEntreprises e) {

        Query q;
        q = em.createQuery("SELECT c.idRubriqueCaracteristique FROM OrclassTarifCondition c WHERE c.idTarif.id= :id and c.idEntreprise.idEntreprise= :idEntreprise ")
                .setParameter("id", t.getId())
                .setParameter("idEntreprise", e.getIdEntreprise());
        return q.getResultList();
    }

    public OrclassTarifCondition finKey(OrclassTarif t, OrclassRubriqueCaracteristique rc, OrclassEntreprises e) {
        Query q;
        q = em.createQuery("SELECT t FROM OrclassTarifCondition t WHERE t.idRubriqueCaracteristique.id= :id and t.idTarif.id= :id2 and t.idEntreprise.idEntreprise= :idEntreprise")
                .setParameter("id", rc.getId())
                .setParameter("id2", t.getId())
                .setParameter("idEntreprise", e.getIdEntreprise());
        if (q.getResultList().isEmpty()) {
            return null;
        }
        return (OrclassTarifCondition) q.getResultList().toArray()[0];
    }

    public OrclassTarifCondition tarificationConditionWithCaracteristiqueAndTarif(OrclassTarif t, String libelleTexte, OrclassEntreprises e) {
        Query q;
        OrclassTarifCondition tc = null;
        q = em.createQuery("SELECT t FROM OrclassTarifCondition t WHERE t.idTarif= :t and t.valeurTexte= :energieTexte and t.idEntreprise= :e")
                .setParameter("energieTexte", libelleTexte)
                .setParameter("t", t)
                .setParameter("e", e);
        if (q.getResultList().isEmpty()) {
            return null;
        }
        tc = (OrclassTarifCondition) q.getResultList().get(0);
        
        return  tc;
    }
     public OrclassTarifCondition tarificationConditionWithCaracteristiqueAndTarif(OrclassTarif t, String libelleTexte,Boolean value, OrclassEntreprises e) {
        Query q;
        OrclassTarifCondition tc = null;
        q = em.createQuery("SELECT t FROM OrclassTarifCondition t WHERE t.idTarif= :t and t.idRubriqueCaracteristique.idCaracteristiques.libelle= :energieTexte and t.idEntreprise= :e and t.valeurBoolean= :value")
                .setParameter("energieTexte", libelleTexte)
                .setParameter("t", t)
                 .setParameter("value", value)
                .setParameter("e", e);
        if (q.getResultList().isEmpty()) {
            return null;
        }
        tc = (OrclassTarifCondition) q.getResultList().get(0);
        
        return  tc;
    }
     
      public OrclassTarifCondition tarificationConditionWithCaracteristiqueAndTarifForPuissance(OrclassTarif t, String libelleTexte,BigInteger puissance, OrclassEntreprises e) {
        Query q;
        OrclassTarifCondition tc = null;
        q = em.createQuery("SELECT t FROM OrclassTarifCondition t WHERE t.idTarif= :t and t.idRubriqueCaracteristique.idCaracteristiques.libelle= :energieTexte and t.idEntreprise= :e and (t.valeurMin<= :puissance and t.valeurMax>= :puissance) and t.valeurTexte is null")
                .setParameter("energieTexte", libelleTexte)
                .setParameter("t", t)
                .setParameter("puissance", puissance)
                .setParameter("e", e);
        if (q.getResultList().isEmpty()) {
            return null;
        }
        tc = (OrclassTarifCondition) q.getResultList().get(0);
        
        return  tc;
    }

    /*
    recuperation de la ligne de tarification pour vehicule categorie2
     */
//    public OrclassTarifCondition tarificationByVehiculeCategorie2(OrclassEntreprises e,OrclassRisque vehicule){
//         Query query;
//    query=em.createQuery("SELECT ")
//    }
    //recupere la ligne considerantpour avoir la prime
//    public List<OrclassTarifCondition> retourneTarifConditionByVehicule(OrclassRisque vehicule, OrclassEntreprises compagnie, Integer categories, OrclassTypeTarif t) {
//        Query querry;
//        List<OrclassTarifCondition> listesTarificationCondition = new ArrayList<>();
//        switch (categories) {
//            case 1:
//                /*
//                dans ce cas comme parametre 
//                -zone de circulation du vehicule
//                -genre du vehicule 
//                usage du vehicule
//                -energie du vehicule et la puissance du vehicule
//                avec ou sans remoque
//                puissance du vehicul
//                and (t.valeurMin <= :puissanceText and t.valeurMax >= :puissanceText) 
//                 */
//                querry = em.createQuery("SELECT t FROM OrclassTarifCondition t WHERE ((t.idRubriqueCaracteristique.idCaracteristiques.libelle= :energie and  t.valeurTexte= :energieTexte) or (t.idRubriqueCaracteristique.idCaracteristiques.libelle= :zone and t.valeurTexte= :zoneTexte)  or (t.idRubriqueCaracteristique.idCaracteristiques.libelle= :genre and t.valeurTexte= :genreTexte ) or (t.idRubriqueCaracteristique.idCaracteristiques.libelle= :usage and t.valeurTexte= :usageTexte) or (t.idRubriqueCaracteristique.idCaracteristiques.libelle= :remoq and t.valeurBoolean= :remoqValue)  or (t.idRubriqueCaracteristique.idCaracteristiques.libelle= :puissance or t.valeurTexte is null and t.valeurMax!= :zerro)) and t.idEntreprise= :e and t.idRubriqueCaracteristique.idCategories.categoriesVehicule= :cat and t.idTarif= :t and (t.valeurMin<= :puissanceText and t.valeurMax>= :puissanceText)")
//                        .setParameter("energie", VehiculeObjet.energie.name())
//                        .setParameter("energieTexte", vehicule.getEnergie().name())
//                        .setParameter("zone", VehiculeObjet.zone.name())
//                        .setParameter("zoneTexte", String.valueOf(vehicule.getZone().name()))
//                        .setParameter("genre", VehiculeObjet.genre.name())
//                        .setParameter("genreTexte", vehicule.getGenre_vehicule())
//                        .setParameter("usage", VehiculeObjet.usage.name())
//                        .setParameter("usageTexte", vehicule.getUsage_vehicule())
//                        .setParameter("remoq", VehiculeObjet.avec_remoque.name())
//                        .setParameter("remoqValue", vehicule.getAvec_remoque() == null ? false : vehicule.getAvec_remoque())
//                        .setParameter("puissance", VehiculeObjet.puissance.name())
//                        .setParameter("puissanceText", vehicule.getPuissance_vehicule())
//                        .setParameter("e", compagnie)
//                        .setParameter("cat", categories)
//                        .setParameter("t", t)
//                    .setParameter("zerro", BigInteger.ZERO);
//
//                listesTarificationCondition = querry.getResultList();
//                break;
//
//            case 2:
//
//                break;
//            case 3:
//
//                break;
//            case 4:
//
//                break;
//            case 5:
//
//                break;
//            case 6:
//
//                break;
//            case 7:
//
//                break;
//            case 8:
//
//                break;
//            case 9:
//
//                break;
//            case 10:
//
//                break;
//
//        }
//
//        return listesTarificationCondition;
//    }
}
