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
import modele.OrclassRubriqueGarantie;
import modele.OrclassTarif;
import modele.OrclassTarifCondition;
import modele.OrclassTypeTarif;

/**
 *
 * @author hp
 */
@Stateless
public class OrclassTarifDao extends AbstractJpaDAO<OrclassTarif> {

    private static final long serialVersionUID = 1L;
    @PersistenceContext(unitName = AbstractJpaDAO.PersistanceUnit)
    private EntityManager em;

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @Override
    protected Class<OrclassTarif> getEntityClass() {
        return OrclassTarif.class;
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    /*
    recuperation d un tarif unique 
     */
    public OrclassTarif finKey(OrclassRubriqueGarantie rg, OrclassEntreprises e) {
        Query q;
        q = em.createQuery("SELECT t FROM OrclassTarif t WHERE  t.idEntreprise.idEntreprise= :idEntreprise and t.idRubriqueGarantie.id= :id")
                .setParameter("id", rg.getId())
//                .setParameter("nbre", numero_Ordre)
                .setParameter("idEntreprise", e.getIdEntreprise());
        if (q.getResultList().isEmpty()) {
            return null;
        }
        return (OrclassTarif) q.getResultList().toArray()[0];
    }

    /*
    recuperation du dernier numero d ordre d une rubrique garantie dans une ligne de tarif
     */
    public BigInteger checkLastNumero8ordre(OrclassRubriqueGarantie rg, OrclassEntreprises e) {
        Query q;
        q = em.createQuery("SELECT t.numero_Ordre FROM OrclassTarif t WHERE t.idRubriqueGarantie.idRubrique.id= :id and t.idEntreprise.idEntreprise= :idEntreprise order By t.numero_Ordre DESC")
                .setParameter("id", rg.getIdRubrique().getId())
                .setParameter("idEntreprise", e.getIdEntreprise());
        if (q.getResultList().isEmpty()) {
            return BigInteger.ZERO;
        }
        return (BigInteger) q.getResultList().toArray()[0];
    }

    public OrclassTarif lastTarif(OrclassRubriqueGarantie rg, OrclassEntreprises e) {
        Query q;
        q = em.createQuery("SELECT t FROM OrclassTarif t WHERE  t.idEntreprise.idEntreprise= :idEntreprise and t.idRubriqueGarantie.id= :id")
                .setParameter("id", rg.getId())
                .setParameter("idEntreprise", e.getIdEntreprise());
        if (q.getResultList().isEmpty()) {
            return null;
        }
        return (OrclassTarif) q.getResultList().toArray()[0];
    }

    public OrclassTarif lastTarif(OrclassRubriqueGarantie rg) {
        Query q;
        q = em.createQuery("SELECT t FROM OrclassTarif t WHERE   t.idRubriqueGarantie.id= :id and t.idRubriqueGarantie.idGarantie.globalCompagnie= :global")
                .setParameter("id", rg.getId())
                .setParameter("global", Boolean.TRUE);
        if (q.getResultList().isEmpty()) {
            return null;
        }
        return (OrclassTarif) q.getResultList().toArray()[0];
    }
    
 public List<OrclassTarif> retourneTarifByVehicule(OrclassRisque vehicule, OrclassEntreprises compagnie, Integer categories, OrclassTypeTarif t){
   Query querry;
    List<OrclassTarif> listesOrclassTarif = new ArrayList<>();
    switch (categories) {
            case 1:
                /*
                dans ce cas comme parametre 
                -zone de circulation du vehicule
                -genre du vehicule 
                usage du vehicule
                -energie du vehicule et la puissance du vehicule
                avec ou sans remoque
                puissance du vehicul
                and (t.valeurMin <= :puissanceText and t.valeurMax >= :puissanceText) 
                 */
                querry = em.createQuery("SELECT ta FROM OrclassTarif ta JOIN ta.tarifConditions t WHERE ((t.idRubriqueCaracteristique.idCaracteristiques.libelle= :energie and  t.valeurTexte= :energieTexte) or (t.idRubriqueCaracteristique.idCaracteristiques.libelle= :zone and t.valeurTexte= :zoneTexte)  or (t.idRubriqueCaracteristique.idCaracteristiques.libelle= :genre and t.valeurTexte= :genreTexte ) or (t.idRubriqueCaracteristique.idCaracteristiques.libelle= :usage and t.valeurTexte= :usageTexte) or (t.idRubriqueCaracteristique.idCaracteristiques.libelle= :remoq and t.valeurBoolean= :remoqValue)  or (t.idRubriqueCaracteristique.idCaracteristiques.libelle= :puissance or t.valeurTexte is null and t.valeurMax!= :zerro) ) and (t.idEntreprise= :e and t.idRubriqueCaracteristique.idCategories.categoriesVehicule= :cat "
                        + "and t.idRubriqueCaracteristique.idRubriqueGarantie.idTypeTarif= :tp and (t.valeurMin<= :puissanceText and t.valeurMax>= :puissanceText))")
                        .setParameter("energie", VehiculeObjet.energie.name())
                        .setParameter("energieTexte", vehicule.getEnergie().name())
                        .setParameter("zone", VehiculeObjet.zone.name())
                        .setParameter("zoneTexte", String.valueOf(vehicule.getZone().name()))
                        .setParameter("genre", VehiculeObjet.genre.name())
                        .setParameter("genreTexte", vehicule.getGenre_vehicule())
                        .setParameter("usage", VehiculeObjet.usage.name())
                        .setParameter("usageTexte", vehicule.getUsage_vehicule())
                        .setParameter("remoq", VehiculeObjet.avec_remoque.name())
                        .setParameter("remoqValue", vehicule.getAvec_remoque() == null ? false : vehicule.getAvec_remoque())
                        .setParameter("puissance", VehiculeObjet.puissance.name())
                        .setParameter("puissanceText", vehicule.getPuissance_vehicule())
                        .setParameter("e", compagnie)
                        .setParameter("cat", categories)
                        .setParameter("tp", t)
                    .setParameter("zerro", BigInteger.ZERO);

                listesOrclassTarif = querry.getResultList();
                break;

            case 2:

                break;
            case 3:

                break;
            case 4:

                break;
            case 5:

                break;
            case 6:

                break;
            case 7:

                break;
            case 8:

                break;
            case 9:

                break;
            case 10:

                break;

        }
  return listesOrclassTarif;
 }
}
