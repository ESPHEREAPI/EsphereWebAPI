/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sante;

import dao.AbstractJpaDAO;
import dao.OrclassAssureDao;
import dao.OrclassAvenantDao;
import dao.OrclassGroupePoliceDao;
import dao.OrclassImageFamilleRisqueDao;
import dao.OrclassPoliceCaracteristiqueDao;
import dao.OrclassPoliceDao;
import dao.OrclassPoliceGarantieDao;
import dao.OrclassPolicePlafondDao;
import enums.UniteDuree;
import exception.GlobalException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;
import modele.OrclassAssure;
import modele.OrclassAvenant;
import modele.OrclassDetailPolicePlafond;
import modele.OrclassEntreprises;
//import modele.OrclassGroupeGarantiePolice;
import modele.OrclassGroupePolice;
import modele.OrclassImageFamilleRisque;
import modele.OrclassImageRisque;
import modele.OrclassIntermediaires;
import modele.OrclassPlafondMaladie;
import modele.OrclassPolice;
//import modele.OrclassPolicesss;
import modele.OrclassPoliceCaracteristique;
import modele.OrclassPoliceCommissionApporteur;
import modele.OrclassPoliceGarantie;
import modele.OrclassPolicePlafond;
import modele.OrclassQuitance;
import modele.OrclassRisque;
import modele.OrclassRisqueFamille;
import modele.OrclassUtilisateurs;
import modele.Orclass_TypeAvenant;
import modele.OrclasseRefGroupe;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author hp
 */
@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
public class Sante implements ISante {

    @Resource
    private UserTransaction tx;
    @PersistenceContext(unitName = AbstractJpaDAO.PersistanceUnit)
    private EntityManager em;
    Logger logger = LoggerFactory.getLogger(Sante.class);
    @EJB
    OrclassAssureDao assureDao;
    @EJB
    OrclassPoliceDao policeDao;
    OrclassEntreprises entreprises;
    @EJB
    OrclassPolicePlafondDao policePlafondDao;
    @EJB
    OrclassImageFamilleRisqueDao imageFamilleRisqueDao;
    @EJB
    OrclassAvenantDao avenantDao;
    @EJB
    OrclassPoliceCaracteristiqueDao policeCaracteristiqueDao;
    @EJB
    OrclassPoliceGarantieDao policeGarantieDao;
    @EJB
    OrclassGroupePoliceDao groupePoliceDao;

    private List arrays_Tab2[][];

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @Override
    public Boolean addProjetSanteByMaladieFamille(OrclassAssure assure, OrclassPolice police, OrclassRisque risque, List<OrclassRisqueFamille> famille, OrclassPlafondMaladie plafondMaladie, List<OrclassDetailPolicePlafond> detailPolicePlafonds, List<OrclassPoliceCaracteristique> policeCaracteristiques, List<OrclassPoliceGarantie> policeGaranties, OrclassQuitance quitance, List<OrclassPoliceCommissionApporteur> commissionApporteurs, OrclassEntreprises entreprises, OrclassUtilisateurs user, Boolean print, Boolean valide) throws GlobalException {
        Boolean valider = Boolean.FALSE;
        this.setEntreprises(entreprises);
        String code;
        try {
            tx.begin();

            OrclassPolice newPolice;
            OrclassAssure newAssuerer;
            OrclassRisque newrisque;
            if (assureDao.finKeyAssure(assure.getNom(), entreprises) == null) {
                code = this.codeAssurer(police.getIdIntermediaire());
                System.out.println("Code Assure:" + code);
                newAssuerer = new OrclassAssure();
                newAssuerer.setCode(code);
                newAssuerer.setNom(assure.getNom().toUpperCase());
                newAssuerer.setPrenom(assure.getPrenom());
                newAssuerer.setAdresse(assure.getAdresse());
                newAssuerer.setDateCreation(new Date());
                newAssuerer.setDate_naissance(assure.getDate_naissance());
                newAssuerer.setDate_saisie(police.getDate_saisie());
                newAssuerer.setIdActivite(assure.getIdActivite());
                newAssuerer.setIdEntreprise(entreprises);
                newAssuerer.setIdIntermediaire(police.getIdIntermediaire());
                newAssuerer.setIdProfession(assure.getIdProfession());
                newAssuerer.setIdQualite(assure.getIdQualite());
                newAssuerer.setIdVille(assure.getIdVille());
                newAssuerer.setLieu_naissance(assure.getLieu_naissance());
                newAssuerer.setNum_cni(assure.getNum_cni());
                newAssuerer.setNumero_piece(assure.getNumero_piece());

                newAssuerer.setSexe(assure.getSexe());
                newAssuerer.setTypePieces(assure.getTypePieces());
//                newAssuerer.setDate_saisie(assure.getDate_saisie());
                newAssuerer.setSaisir_par(user.getNom() + " " + user.getPrenom());
                em.persist(newAssuerer);
            } else {
                newAssuerer = assureDao.finKeyAssure(assure.getNom(), entreprises);
            }
            /*
                creation de la police
             */

            if (policeDao.finKey(police.getIdIntermediaire(), police.getNumero_police(), entreprises, police.getIdCategories()) != null) {
                throw new GlobalException("THE POLICE NUMBER EXISTS TRY A NEW PROJECT OR CONSULT YOUR ADMINISTRATOR " + " FATAL ERROR");

            }
            newPolice = new OrclassPolice();
//            OrclassPolicePK policePK = new OrclassPolicePK(police.getNumero_police(), police.getIdIntermediaire().getIdIntermediaire());
            newPolice.setNumero_police(police.getNumero_police());
            newPolice.setAccessoir(police.getAccessoir());
            newPolice.setContrat(police.getContrat());
            newPolice.setCoursDevise(police.getCoursDevise());
            newPolice.setCoursDeviseApplique(police.getCoursDeviseApplique());
            newPolice.setCptg(police.getCptg());
            newPolice.setDateCreation(new Date());
            newPolice.setDate_cours_devise(police.getDate_cours_devise());
            newPolice.setDate_echeance(police.getDate_echeance());
            newPolice.setDate_effet(police.getDate_effet());
            newPolice.setDate_saisie(police.getDate_saisie());
            if (Objects.equals(valide, Boolean.TRUE)) {
                newPolice.setValidation(valider);
                newPolice.setValider_par(user.getNom() + " " + user.getPrenom());
                newPolice.setDate_validation(new Date());

            }
            if (Objects.equals(print, Boolean.TRUE)) {
                newPolice.setImprimer(Boolean.TRUE);

            }
            newPolice.setIdApporteur(police.getIdApporteur());
            newPolice.setIdAssure(newAssuerer);
            newPolice.setIdCategories(police.getIdCategories());
            newPolice.setIdConvention(police.getIdConvention());
            newPolice.setIdDevise(police.getIdDevise());
            newPolice.setIdEntreprises(entreprises);
            newPolice.setIdExoneration(police.getIdExoneration());
            newPolice.setIdFractionnementCategories(police.getIdFractionnementCategories());
            newPolice.setIdIntermediaire(police.getIdIntermediaire());
            newPolice.setIdMajorationDuree(police.getIdMajorationDuree());
            newPolice.setIdReduction(police.getIdReduction());
            newPolice.setIdTimbre(police.getIdTimbre());
            newPolice.setIdTimbreDimension(police.getIdTimbreDimension());
            newPolice.setIdTypeTarif(police.getIdTypeTarif());
            newPolice.setMontantaccessoir(police.getMontantaccessoir());
            newPolice.setNatureContrat(police.getNatureContrat());
            newPolice.setNombre_timbre(police.getNombre_timbre());
            newPolice.setNumero_Borderau(police.getNumero_Borderau());
            newPolice.setObservation(police.getObservation());
            newPolice.setRef_intermediaire(police.getRef_intermediaire());
            newPolice.setSaisir_par(user.getNom() + " " + user.getPrenom());
            newPolice.setTaux_echange(police.getTaux_echange());
            newPolice.setTitre(police.getTitre());
            newPolice.setUniteDuree(police.getUniteDuree());
            newPolice.setValeurDuree(police.getValeurDuree());
            newPolice.setValeur_Devis(police.getValeur_Devis());
            newPolice.setValeur_timbre(police.getValeur_timbre());
            newPolice.setIdUtilisateur(user);
            newPolice.setDesignationPlafonMaladie(police.getDesignationPlafonMaladie());

            em.persist(newPolice);
            /*
                creation du risque
             */

            newrisque = new OrclassRisque();
            newrisque.setAdresse(risque.getAdresse());
            newrisque.setDateCreation(new Date());
            newrisque.setDateEntree(risque.getDateEntree());
            newrisque.setDateNaissance(risque.getDateNaissance());
            newrisque.setIdEntreprise(entreprises);
            newrisque.setIdPolice(newPolice);
            newrisque.setIdVille(risque.getIdVille());
            newrisque.setLibelle(risque.getLibelle());
            newrisque.setLibelleActivite(risque.getLibelleActivite());
            newrisque.setLibelleProfession(risque.getLibelleProfession());
            newrisque.setLieu_naissance(risque.getLieu_naissance());
            newrisque.setModeCalcul(risque.getModeCalcul());
            newrisque.setSexe(risque.getSexe());
            newrisque.setSaisir_par(user.getNom() + " " + user.getPrenom());
            newrisque.setDateSortie(risque.getDateSortie());
            em.persist(newrisque);

            /*
                enregistrement de risque famille
             */
            OrclassRisqueFamille risqueFamille;
            for (OrclassRisqueFamille rf : famille) {
                if (rf.getNom_membre() == null || "".equals(rf.getNom_membre())) {
                    continue;
                }
                risqueFamille = new OrclassRisqueFamille();
                risqueFamille.setDateEntree(rf.getDateEntree());
                risqueFamille.setDateNaissance(rf.getDateNaissance());
                risqueFamille.setIdEntreprise(entreprises);
                risqueFamille.setIdPolice(newPolice);
                risqueFamille.setIdRisque(newrisque);
                risqueFamille.setIdVille(newAssuerer.getIdVille());
                risqueFamille.setLienParente(rf.getLienParente());
                risqueFamille.setNom_membre(rf.getNom_membre());
                risqueFamille.setDateSortie(rf.getDateSortie());
                risqueFamille.setSexe(rf.getSexe());
                em.persist(risqueFamille);
            }

            /*
                enregistrement police plafond
             */
            OrclassPolicePlafond newPlafondMaladie;
            newPlafondMaladie = new OrclassPolicePlafond();
            newPlafondMaladie.setIdCategories(newPolice.getIdCategories());
            newPlafondMaladie.setIdPlafondMaladie(plafondMaladie);
            newPlafondMaladie.setIdPolice(newPolice);
            newPlafondMaladie.setIdEntreprise(entreprises);

            em.persist(newPlafondMaladie);
            /*
                enregistrement detail police plafond
             */
            OrclassDetailPolicePlafond newDetailPolicePlafond;
            for (OrclassDetailPolicePlafond dppf : detailPolicePlafonds) {
                if (dppf.getIdPrestation() == null || dppf.getIdPrestation().getId() == null) {
                    continue;
                }
                newDetailPolicePlafond = new OrclassDetailPolicePlafond();
                newDetailPolicePlafond.setIdEntreprise(entreprises);
                newDetailPolicePlafond.setBarem(dppf.getBarem());
                newDetailPolicePlafond.setCode_ss(dppf.getCode_ss());
                newDetailPolicePlafond.setForfait(dppf.getForfait());
                newDetailPolicePlafond.setIdPolicePlafond(newPlafondMaladie);
                newDetailPolicePlafond.setIdPrestation(dppf.getIdPrestation());
                newDetailPolicePlafond.setIdRubrique(dppf.getIdRubrique());
                newDetailPolicePlafond.setModeCalculDetailMaladie(dppf.getModeCalculDetailMaladie());
                newDetailPolicePlafond.setPlafond(dppf.getPlafond());
                newDetailPolicePlafond.setTaux(dppf.getTaux());
                newDetailPolicePlafond.setTypeDetailMaladie(dppf.getTypeDetailMaladie());
                em.persist(newDetailPolicePlafond);

            }

            OrclassPoliceCaracteristique newPoliceCaracteristique;

            for (OrclassPoliceCaracteristique pc : policeCaracteristiques) {
                if (pc.getIdCaracteristiques() == null || pc.getIdCaracteristiques().getId() == null) {
                    continue;
                }
                if (pc.getValeurBoolean() == null && pc.getDateValeur() == null && pc.getValeurCaracteristique() == null && pc.getValeurCode() == null && (pc.getValeurNumerique() == null || pc.getValeurNumerique().intValue() == 0) && pc.getValeurTexte() == null) {
                    continue;
                }
                newPoliceCaracteristique = new OrclassPoliceCaracteristique();

                newPoliceCaracteristique.setIdCaracteristiques(pc.getIdCaracteristiques());
                newPoliceCaracteristique.setIdPolice(newPolice);
                newPoliceCaracteristique.setIdEntreprise(entreprises);
                if (pc.getDateValeur() != null) {
                    newPoliceCaracteristique.setDateValeur(pc.getDateValeur());
                }
                if (pc.getValeurBoolean() != null) {
                    newPoliceCaracteristique.setValeurBoolean(pc.getValeurBoolean());
                }
                if (pc.getValeurCode() != null) {
                    newPoliceCaracteristique.setValeurCode(pc.getValeurCode());
                }
                if (pc.getValeurCaracteristique() != null) {
                    pc.setValeurCaracteristique(pc.getValeurCaracteristique());
                }
                if (pc.getValeurTexte() != null) {
                    newPoliceCaracteristique.setValeurTexte(pc.getValeurTexte());
                }
                if (pc.getValeurNumerique() != null && pc.getValeurNumerique() != null && pc.getValeurNumerique().intValue() != 0) {
                    newPoliceCaracteristique.setValeurNumerique(pc.getValeurNumerique());
                }
                newPoliceCaracteristique.setIdCategories(police.getIdCategories());
                em.persist(newPoliceCaracteristique);

            }
            /*
                enregistrement des garenties polices
             */
            OrclassPoliceGarantie newPoliceGarantie;
            for (OrclassPoliceGarantie pg : policeGaranties) {
                if (pg.getIdGarantie() == null || pg.getIdGarantie().getId() == null) {
                    continue;
                }
                newPoliceGarantie = new OrclassPoliceGarantie();
                newPoliceGarantie.setCapital(pg.getCapital());
                newPoliceGarantie.setIdEntreprise(entreprises);
                newPoliceGarantie.setIdGarantie(pg.getIdGarantie());
                newPoliceGarantie.setIdPolice(newPolice);
                newPoliceGarantie.setPourcentage(pg.getPourcentage());
                newPoliceGarantie.setPrime(pg.getPrime());
                newPoliceGarantie.setProrata(pg.getProrata());
                newPoliceGarantie.setTaux(pg.getTaux());
                em.persist(newPoliceGarantie);

            }

            /*
                creation quittance
             */
            OrclassQuitance newQuittance = new OrclassQuitance();
            newQuittance.setAccessoirTaxe(quitance.getAccessoirTaxe());
            newQuittance.setDateCreation(new Date());
            newQuittance.setDateEmission(quitance.getDateEmission());

            newQuittance.setDate_saisie(quitance.getDate_saisie());
            if (Objects.equals(valider, Boolean.TRUE)) {
                newQuittance.setValidation(valider);
                newQuittance.setDate_validation(quitance.getDate_validation());
                newQuittance.setValider_par(user.getNom() + " " + user.getPrenom());

            }
            newQuittance.setDate_echeance(quitance.getDate_echeance());
            newQuittance.setDate_effet(quitance.getDate_effet());
            newQuittance.setIdDevise(police.getIdDevise());
            newQuittance.setIdEntreprise(entreprises);
            newQuittance.setIdPolice(newPolice);
            newQuittance.setIdTimbreDimension(quitance.getIdTimbreDimension());
            newQuittance.setTypQuittance(quitance.getTypQuittance());
            newQuittance.setMontantApport(quitance.getMontantApport());
            newQuittance.setMontantCommision(quitance.getMontantCommision());
            newQuittance.setMontantGestion(quitance.getMontantGestion());
            newQuittance.setMontant_Accessoire(quitance.getMontant_Accessoire());
            newQuittance.setPrimeNette(quitance.getPrimeNette());
            newQuittance.setPrimeTaxe(quitance.getPrimeTaxe());
            newQuittance.setTaxePrime(quitance.getTaxePrime());
            newQuittance.setSaisir_par(user.getNom() + " " + user.getPrenom());
            newQuittance.setTaxeAccessoir(quitance.getTaxeAccessoir());
            newQuittance.setTaxeCommision(quitance.getTotalCommision());
            newQuittance.setTimbreDimension(quitance.getTimbreDimension());
            newQuittance.setTimbreGradue(quitance.getTimbreGradue());
            newQuittance.setTotalCommision(quitance.getTotalCommision());
            newQuittance.setTotalTaxes(quitance.getTotalTaxes());
            newQuittance.setTotalTimb(quitance.getTotalTimb());
            newQuittance.setTotal_a_paye(quitance.getTotal_a_paye());
//            newQuittance.setTaxesAccessoires(quitance.getTaxeAccessoir());
            newQuittance.setTypQuittance(quitance.getTypQuittance());
            newQuittance.setTaux_apport(quitance.getTaux_apport());
            newQuittance.setTaux_gestion(quitance.getTaux_gestion());
            em.persist(newQuittance);
            /*
               commission prime apporteur
             */
            OrclassPoliceCommissionApporteur apporteur = null;
            for (OrclassPoliceCommissionApporteur commissionApporteur : commissionApporteurs) {
                apporteur = new OrclassPoliceCommissionApporteur();
                apporteur.setIdCommission_Prime_Apporteur(commissionApporteur.getIdCommission_Prime_Apporteur());
                apporteur.setTaux_apport(commissionApporteur.getTaux_apport());
                apporteur.setTaux_gestion(commissionApporteur.getTaux_gestion());
                apporteur.setIdEntreprise(entreprises);
                apporteur.setIdPolice(newPolice);
                em.persist(apporteur);

            }

            tx.commit();
            valider = Boolean.TRUE;
        } catch (GlobalException | NotSupportedException | SystemException | RollbackException | HeuristicMixedException | HeuristicRollbackException | SecurityException ex) {
            try {
                tx.rollback();
                throw ex;
            } catch (Exception e) {
            }
            valider = Boolean.FALSE;
        }
        return valider;
    }

    @Override
    public Boolean addProjetSanteByIndividuel(OrclassAssure assure, OrclassPolice police, OrclassRisque risque, OrclassPlafondMaladie plafondMaladie, List<OrclassDetailPolicePlafond> detailPolicePlafonds, List<OrclassPoliceCaracteristique> policeCaracteristiques, List<OrclassPoliceGarantie> policeGaranties, OrclassQuitance quitance, BigDecimal apport, BigDecimal gestion, OrclassEntreprises entreprises, OrclassUtilisateurs user, Boolean print, Boolean valide) throws GlobalException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String codeAssurer(OrclassIntermediaires agence) {
        BigInteger valeur = BigInteger.ZERO;
        BigInteger nombre = BigInteger.ZERO;
        int taille = 4;
        StringBuilder genCode = new StringBuilder();
        Long nbre = assureDao.nbreLigne(agence, this.getEntreprises());
        genCode.append(this.getEntreprises().getRaisonSociale().substring(0, 3));
        genCode.append(agence.getIdRefIntermediaire().getCode());
        genCode.append("-");
        if (nbre == 0L) {
//            valeur = BigInteger.ONE;

            for (int i = 0; i < 4; i++) {
                genCode.append(0);
            }
            genCode.append(BigInteger.ONE);
            nombre = BigInteger.ONE;
            while (assureDao.findEntityHavingValue("code", genCode.toString()) != null) {
                nombre = nombre.add(BigInteger.ONE);
                genCode = new StringBuilder();
                for (int i = 0; i < 4; i++) {
                    genCode.append(0);
                }
                genCode.append(nombre.toString());
            }
//            genCode = new StringBuilder();
//             for (int i = 0; i < 4; i++) {
//                genCode.append(0);
//            }
//              genCode.append(nombre.toString());

        } else {
//            Double stringValeur = Double.parseDouble(a.getCode());
            valeur = BigInteger.valueOf(nbre);

            valeur = valeur.add(BigInteger.ONE);
            for (int i = 0; i < 4; i++) {
                genCode.append(0);
            }
            genCode.append(valeur.toString());
            nombre = valeur;
            while (assureDao.findEntityHavingValue("code", genCode.toString()) != null) {
                nombre = nombre.add(BigInteger.ONE);
                genCode = new StringBuilder();
                for (int i = 0; i < 4; i++) {
                    genCode.append(0);
                }
                genCode.append(nombre.toString());
            }

        }
        //generation du numero

        return genCode.toString();

    }

    public OrclassEntreprises getEntreprises() {
        return entreprises;
    }

    public void setEntreprises(OrclassEntreprises entreprises) {
        this.entreprises = entreprises;
    }

    @Override
    public Boolean addProjetSanteByMaladieGroup(OrclassAssure assure, OrclassPolice police, List<OrclassImageRisque> listeImagineRisque, OrclassPlafondMaladie plafondMaladie, List<OrclassDetailPolicePlafond> detailPolicePlafonds, List<OrclassPoliceCaracteristique> policeCaracteristiques, List<OrclassPoliceGarantie> policeGaranties, OrclassQuitance quitance, List<OrclassPoliceCommissionApporteur> commissionApporteurs, OrclassEntreprises entreprises, OrclassUtilisateurs user, Boolean print, Boolean valide) throws GlobalException {
        Boolean valider = Boolean.FALSE;
        this.setEntreprises(entreprises);
        List<OrclasseRefGroupe> listRefGroup = new ArrayList<>();
        String code;
        try {
            tx.begin();

            OrclassPolice newPolice;
            OrclassAssure newAssuerer;
            OrclassRisque newrisque;
            if (assureDao.finKeyAssure(assure.getNom(), entreprises) == null) {
                code = this.codeAssurer(police.getIdIntermediaire());
                System.out.println("Code Assure:" + code);
                newAssuerer = new OrclassAssure();
                newAssuerer.setCode(code);
                newAssuerer.setRaison_social(assure.getRaison_social().toUpperCase());
                newAssuerer.setIdQualite(assure.getIdQualite());

                newAssuerer.setAdresse(assure.getAdresse());
                newAssuerer.setDateCreation(new Date());
//                newAssuerer.setDate_naissance(assure.getDate_naissance());
                newAssuerer.setDate_saisie(assure.getDate_saisie());
                newAssuerer.setIdActivite(assure.getIdActivite());
                newAssuerer.setIdEntreprise(entreprises);
                newAssuerer.setIdIntermediaire(police.getIdIntermediaire());
//                newAssuerer.setIdProfession(assure.getIdProfession());
                newAssuerer.setIdQualite(assure.getIdQualite());
                newAssuerer.setIdVille(assure.getIdVille());
//                newAssuerer.setLieu_naissance(assure.getLieu_naissance());
                newAssuerer.setPatente(assure.getPatente());
//                newAssuerer.setNumero_piece(assure.getNumero_piece());

//                newAssuerer.setSexe(assure.getSexe());
//                newAssuerer.setTypePieces(assure.getTypePieces());
                newAssuerer.setDate_saisie(assure.getDate_saisie());
                newAssuerer.setSaisir_par(user.getNom() + " " + user.getPrenom());
                em.persist(newAssuerer);
            } else {
                newAssuerer = assureDao.finKeyAssure(assure.getNom(), entreprises);
            }
            /*
                creation de la police
             */

            if (policeDao.finKey(police.getIdIntermediaire(), police.getNumero_police(), entreprises, police.getIdCategories()) != null) {
                throw new GlobalException("THE POLICE NUMBER EXISTS TRY A NEW PROJECT OR CONSULT YOUR ADMINISTRATOR " + " FATAL ERROR");

            }
            newPolice = new OrclassPolice();
//            OrclassPolicePK policePK = new OrclassPolicePK();
//            newPolice.setPolicePK(policePK);
            newPolice.setNumero_police(police.getNumero_police());
            newPolice.setAccessoir(police.getAccessoir());
            newPolice.setContrat(police.getContrat());
            newPolice.setCoursDevise(police.getCoursDevise());
            newPolice.setCoursDeviseApplique(police.getCoursDeviseApplique());
            newPolice.setCptg(police.getCptg());
            newPolice.setDateCreation(new Date());
            newPolice.setDate_cours_devise(police.getDate_cours_devise());
            newPolice.setDate_echeance(police.getDate_echeance());
            newPolice.setDate_effet(police.getDate_effet());
            newPolice.setDate_saisie(police.getDate_saisie());
            if (Objects.equals(valide, Boolean.TRUE)) {
                newPolice.setValidation(valider);
                newPolice.setValider_par(user.getNom() + " " + user.getPrenom());
                newPolice.setDate_validation(new Date());

            }
            if (Objects.equals(print, Boolean.TRUE)) {
                newPolice.setImprimer(Boolean.TRUE);

            }
            newPolice.setIdApporteur(police.getIdApporteur());
            newPolice.setIdAssure(newAssuerer);
            newPolice.setIdCategories(police.getIdCategories());
            newPolice.setIdConvention(police.getIdConvention());
            newPolice.setIdDevise(police.getIdDevise());
            newPolice.setIdEntreprises(entreprises);
            newPolice.setIdExoneration(police.getIdExoneration());
            newPolice.setIdFractionnementCategories(police.getIdFractionnementCategories());
            newPolice.setIdIntermediaire(police.getIdIntermediaire());
            newPolice.setIdMajorationDuree(police.getIdMajorationDuree());
            newPolice.setIdReduction(police.getIdReduction());
            newPolice.setIdTimbre(police.getIdTimbre());
            newPolice.setIdTimbreDimension(police.getIdTimbreDimension());
            newPolice.setIdTypeTarif(police.getIdTypeTarif());
            newPolice.setMontantaccessoir(police.getMontantaccessoir());
            newPolice.setNatureContrat(police.getNatureContrat());
            newPolice.setNombre_timbre(police.getNombre_timbre());
            newPolice.setNumero_Borderau(police.getNumero_Borderau());
            newPolice.setObservation(police.getObservation());
            newPolice.setRef_intermediaire(police.getRef_intermediaire());
            newPolice.setSaisir_par(user.getNom() + " " + user.getPrenom());
            newPolice.setTaux_echange(police.getTaux_echange());
            newPolice.setTitre(police.getTitre());
            newPolice.setUniteDuree(police.getUniteDuree());
            newPolice.setValeurDuree(police.getValeurDuree());
            newPolice.setValeur_Devis(police.getValeur_Devis());
            newPolice.setValeur_timbre(police.getValeur_timbre());
            newPolice.setDesignationPlafonMaladie(police.getDesignationPlafonMaladie());
            newPolice.setIdUtilisateur(user);

            em.persist(newPolice);
            /*
                creation du risque
             */
            OrclassRisqueFamille risqueFamille;
            for (OrclassImageRisque risque : listeImagineRisque) {
                newrisque = new OrclassRisque();
                newrisque.setDateCreation(new Date());
                newrisque.setMatricule(risque.getMatricule());
                newrisque.setDateEntree(risque.getDateEntree());
                newrisque.setDateNaissance(risque.getDateNaissance());
                newrisque.setIdEntreprise(entreprises);
                newrisque.setIdPolice(newPolice);
                newrisque.setLibelle(risque.getLibelle());
                newrisque.setSexe(risque.getSexe());
                newrisque.setIdGroup(risque.getIdGroup());
                newrisque.setIdVille(assure.getIdVille());
                newrisque.setSaisir_par(user.getNom() + " " + user.getPrenom());

                em.persist(newrisque);
                /*
                enregistrement de risque famille
                 */
                for (OrclassImageFamilleRisque rf : imageFamilleRisqueDao.listeImageFamilleRisqueByImageRisque(risque)) {
                    risqueFamille = new OrclassRisqueFamille();
                    risqueFamille.setDateEntree(rf.getDateEntree());
                    risqueFamille.setDateNaissance(rf.getDateNaissance());
                    risqueFamille.setIdEntreprise(entreprises);
                    risqueFamille.setIdPolice(newPolice);
                    risqueFamille.setIdRisque(newrisque);
                    risqueFamille.setIdVille(newAssuerer.getIdVille());
                    risqueFamille.setLienParente(rf.getLienParente());
                    risqueFamille.setNom_membre(rf.getNom_membre());

                    risqueFamille.setSexe(rf.getSexe());
                    em.persist(risqueFamille);
                }

            }

            /*
                enregistrement police plafond
             */
//            OrclassPolicePlafond newPlafondMaladie;
//            newPlafondMaladie = new OrclassPolicePlafond();
//            newPlafondMaladie.setIdCategories(newPolice.getIdCategories());
//            newPlafondMaladie.setIdPlafondMaladie(plafondMaladie);
//            newPlafondMaladie.setIdPolice(newPolice);
//            newPlafondMaladie.setIdEntreprise(entreprises);
//
//            em.persist(newPlafondMaladie);
            /*
                enregistrement detail police plafond
             */
            OrclassDetailPolicePlafond newDetailPolicePlafond;
            OrclassPolicePlafond newPlafondMaladie = null;
            for (OrclassDetailPolicePlafond dppf : detailPolicePlafonds) {
                if (dppf.getIdPrestation() == null || dppf.getIdPrestation().getId() == null) {
                    continue;
                }
                if (policePlafondDao.chargePolicePlafonMaladie(newPolice, entreprises, dppf.getIdGroup(), dppf.getPlafondMaladie()) == null) {
                    newPlafondMaladie = new OrclassPolicePlafond();
                    newPlafondMaladie.setIdCategories(newPolice.getIdCategories());
                    newPlafondMaladie.setIdPlafondMaladie(dppf.getPlafondMaladie());
                    newPlafondMaladie.setIdPolice(newPolice);
                    newPlafondMaladie.setIdEntreprise(entreprises);
                    newPlafondMaladie.setIdGroup(dppf.getIdGroup());

                    em.persist(newPlafondMaladie);

                }

                newDetailPolicePlafond = new OrclassDetailPolicePlafond();
                newDetailPolicePlafond.setIdEntreprise(entreprises);
                newDetailPolicePlafond.setBarem(dppf.getBarem());
                newDetailPolicePlafond.setCode_ss(dppf.getCode_ss());
                newDetailPolicePlafond.setForfait(dppf.getForfait());
                newDetailPolicePlafond.setIdPolicePlafond(newPlafondMaladie);
                newDetailPolicePlafond.setIdPrestation(dppf.getIdPrestation());
                newDetailPolicePlafond.setIdRubrique(dppf.getIdRubrique());
                newDetailPolicePlafond.setModeCalculDetailMaladie(dppf.getModeCalculDetailMaladie());
                newDetailPolicePlafond.setPlafond(dppf.getPlafond());
                newDetailPolicePlafond.setTaux(dppf.getTaux());
                newDetailPolicePlafond.setTypeDetailMaladie(dppf.getTypeDetailMaladie());
                newDetailPolicePlafond.setIdGroup(dppf.getIdGroup());
                em.persist(newDetailPolicePlafond);

                if (listRefGroup.contains(dppf.getIdGroup()) == Boolean.FALSE) {
                    listRefGroup.add(dppf.getIdGroup());
                }

            }

            OrclassPoliceCaracteristique newPoliceCaracteristique;

            for (OrclassPoliceCaracteristique pc : policeCaracteristiques) {
                if (pc.getIdCaracteristiques() == null || pc.getIdCaracteristiques().getId() == null) {
                    continue;
                }
                if (pc.getValeurBoolean() == null && pc.getDateValeur() == null && pc.getValeurCaracteristique() == null && pc.getValeurCode() == null && (pc.getValeurNumerique() == null || pc.getValeurNumerique().intValue() == 0) && pc.getValeurTexte() == null) {
                    continue;
                }

//                if (policeCaracteristiqueDao.listeCaracteristiqueByPoliceNotHaveAvenant(entreprises, newPolice, pc.getIdGroup()) != null) {
//
//                    continue;
//                }
                newPoliceCaracteristique = new OrclassPoliceCaracteristique();

                newPoliceCaracteristique.setIdCaracteristiques(pc.getIdCaracteristiques());
                newPoliceCaracteristique.setIdPolice(newPolice);
                newPoliceCaracteristique.setIdEntreprise(entreprises);
                if (pc.getDateValeur() != null) {
                    newPoliceCaracteristique.setDateValeur(pc.getDateValeur());
                }
                if (pc.getValeurBoolean() != null) {
                    newPoliceCaracteristique.setValeurBoolean(pc.getValeurBoolean());
                }
                if (pc.getValeurCode() != null) {
                    newPoliceCaracteristique.setValeurCode(pc.getValeurCode());
                }
                if (pc.getValeurCaracteristique() != null) {
                    pc.setValeurCaracteristique(pc.getValeurCaracteristique());
                }
                if (pc.getValeurTexte() != null) {
                    newPoliceCaracteristique.setValeurTexte(pc.getValeurTexte());
                }
                if (pc.getValeurNumerique() != null && pc.getValeurNumerique() != null && pc.getValeurNumerique().intValue() != 0) {
                    newPoliceCaracteristique.setValeurNumerique(pc.getValeurNumerique());
                }
                newPoliceCaracteristique.setIdCategories(police.getIdCategories());
                newPoliceCaracteristique.setIdGroup(pc.getIdGroup());
                em.persist(newPoliceCaracteristique);

                if (listRefGroup.contains(pc.getIdGroup()) == Boolean.FALSE) {
                    listRefGroup.add(pc.getIdGroup());
                }

            }
            /*
                enregistrement des garenties polices
             */
            OrclassPoliceGarantie newPoliceGarantie;
            OrclassGroupePolice groupePolice;
//            OrclassGroupeGarantiePolice groupeGarantiePolice;
            for (OrclassPoliceGarantie pg : policeGaranties) {
                if (pg.getIdGarantie() == null || pg.getIdGarantie().getId() == null) {
                    continue;
                }
                if (pg.getPrime() == null || pg.getPrime().intValue() == 0) {
                    continue;
                }
//                if (policeGarantieDao.listeGarantiesByPoliceNotHaveAvenant(entreprises, newPolice, pg.getIdGroup()) != null) {
//                    continue;
//                }
                newPoliceGarantie = new OrclassPoliceGarantie();
                newPoliceGarantie.setCapital(pg.getCapital());
                newPoliceGarantie.setIdEntreprise(entreprises);
                newPoliceGarantie.setIdGarantie(pg.getIdGarantie());
                newPoliceGarantie.setIdPolice(newPolice);
                newPoliceGarantie.setIdGroup(pg.getIdGroup());
                newPoliceGarantie.setPourcentage(pg.getPourcentage());
                newPoliceGarantie.setPrime(pg.getPrime());
                newPoliceGarantie.setProrata(pg.getProrata());
                newPoliceGarantie.setTaux(pg.getTaux());
                em.persist(newPoliceGarantie);
//                for (OrclassGroupeGarantiePolice ggp : pg.getListeGroupGrantitePolice()) {
//                    groupePolice=new OrclassGroupePolice();
//                    groupePolice.setDateCreation(new Date());
//                    groupePolice.setIdEntreprise(entreprises);
//                    groupePolice.setIdPolice(newPolice);
//                    groupePolice.setIdRefGroupe(ggp.getIdGroupePolice().getIdRefGroupe());
//                    groupePolice.set
//                }

                if (listRefGroup.contains(pg.getIdGroup()) == Boolean.FALSE) {
                    listRefGroup.add(pg.getIdGroup());
                }

            }

            // creation des groupes des compagnies 
            OrclassGroupePolice newGroupePolice = null;
            for (OrclasseRefGroupe refG : listRefGroup) {
                if (groupePoliceDao.finKey(entreprises, newPolice, refG) != null) {
                    continue;
                }
                newGroupePolice = new OrclassGroupePolice();
                newGroupePolice.setDateCreation(new Date());
                newGroupePolice.setIdEntreprise(entreprises);
                newGroupePolice.setIdPolice(newPolice);
                newGroupePolice.setIdRefGroupe(refG);
                newGroupePolice.setIdVille(refG.getVille());
                newGroupePolice.setAdresseGroup(refG.getAdresseGroup());
                newGroupePolice.setObservation(refG.getObservation());
                em.persist(newGroupePolice);

            }

            /*
                creation quittance
             */
            OrclassQuitance newQuittance = new OrclassQuitance();
            newQuittance.setAccessoirTaxe(quitance.getAccessoirTaxe());
            newQuittance.setDateCreation(new Date());
            newQuittance.setDateEmission(quitance.getDateEmission());

            newQuittance.setDate_saisie(quitance.getDate_saisie());
            if (Objects.equals(valider, Boolean.TRUE)) {
                newQuittance.setValidation(valider);
                newQuittance.setDate_validation(quitance.getDate_validation());
                newQuittance.setValider_par(user.getNom() + " " + user.getPrenom());

            }
            newQuittance.setDate_echeance(quitance.getDate_echeance());
            newQuittance.setDate_effet(quitance.getDate_effet());
            newQuittance.setIdDevise(police.getIdDevise());
            newQuittance.setIdEntreprise(entreprises);
            newQuittance.setIdPolice(newPolice);
            newQuittance.setIdTimbreDimension(quitance.getIdTimbreDimension());
            newQuittance.setTypQuittance(quitance.getTypQuittance());
            newQuittance.setMontantApport(quitance.getMontantApport());
            newQuittance.setMontantCommision(quitance.getMontantCommision());
            newQuittance.setMontantGestion(quitance.getMontantGestion());
            newQuittance.setMontant_Accessoire(quitance.getMontant_Accessoire());
            newQuittance.setPrimeNette(quitance.getPrimeNette());
            newQuittance.setPrimeTaxe(quitance.getPrimeTaxe());
            newQuittance.setTaxePrime(quitance.getTaxePrime());
            newQuittance.setSaisir_par(user.getNom() + " " + user.getPrenom());
            newQuittance.setTaxeAccessoir(quitance.getTaxeAccessoir());
            newQuittance.setTaxeCommision(quitance.getTotalCommision());
            newQuittance.setTimbreDimension(quitance.getTimbreDimension());
            newQuittance.setTimbreGradue(quitance.getTimbreGradue());
            newQuittance.setTotalCommision(quitance.getTotalCommision());
            newQuittance.setTotalTaxes(quitance.getTotalTaxes());
            newQuittance.setTotalTimb(quitance.getTotalTimb());
            newQuittance.setTotal_a_paye(quitance.getTotal_a_paye());
//            newQuittance.setTaxesAccessoires(quitance.getTaxesAccessoires());
            newQuittance.setTypQuittance(quitance.getTypQuittance());
            newQuittance.setTaux_apport(quitance.getTaux_apport());
            newQuittance.setTaux_gestion(quitance.getTaux_gestion());
            em.persist(newQuittance);
            /*
               commission prime apporteur
             */
            OrclassPoliceCommissionApporteur apporteur = null;
            for (OrclassPoliceCommissionApporteur commissionApporteur : commissionApporteurs) {
                apporteur = new OrclassPoliceCommissionApporteur();
                apporteur.setIdCommission_Prime_Apporteur(commissionApporteur.getIdCommission_Prime_Apporteur());
                apporteur.setTaux_apport(commissionApporteur.getTaux_apport());
                apporteur.setTaux_gestion(commissionApporteur.getTaux_gestion());
                apporteur.setIdEntreprise(entreprises);
                apporteur.setIdPolice(newPolice);
                em.persist(apporteur);

            }

            tx.commit();
            valider = Boolean.TRUE;
        } catch (GlobalException | NotSupportedException | SystemException | RollbackException | HeuristicMixedException | HeuristicRollbackException | SecurityException ex) {
            try {
                tx.rollback();
                throw ex;
            } catch (Exception e) {
            }
            valider = Boolean.FALSE;
        }
        return valider;
    }

    @Override
    public Boolean addAenant(Orclass_TypeAvenant tpa, OrclassAssure assure, OrclassPolice police, List<OrclassRisque> listeRisque, List<OrclassRisqueFamille> famille, OrclassPolicePlafond policePlafond, List<OrclassDetailPolicePlafond> detailPolicePlafonds, List<OrclassPoliceCaracteristique> policeCaracteristiques, List<OrclassPoliceGarantie> policeGaranties, OrclassQuitance quitance, List<OrclassPoliceCommissionApporteur> commissionApporteurs, OrclassEntreprises entreprises, OrclassUtilisateurs user) throws GlobalException {
        this.setEntreprises(entreprises);
        Boolean resultat = Boolean.FALSE;
        try {
            tx.begin();

            OrclassPolice oldPolice = policeDao.find(police.getId());
            OrclassAssure oldAssure = assureDao.find(assure.getId());
            OrclassAvenant avenant = new OrclassAvenant();
            if (oldPolice.getContrat() != police.getContrat()) {
                avenant.setContrat(police.getContrat());
            }
            if (oldPolice.getDate_echeance().compareTo(police.getDate_echeance()) != 0) {
                avenant.setDate_echeance(police.getDate_echeance());
            }
            if (oldPolice.getDate_effet().compareTo(police.getDate_effet()) != 0) {
                avenant.setDate_effet(police.getDate_effet());
            }

//            if (!oldPolice.getDesignationPlafonMaladie().equals(police.getDesignationPlafonMaladie())) {
//                avenant.setDesignationPlafonMaladie(police.getDesignationPlafonMaladie());
//            }
            if (oldPolice.getIdConvention() != null && (oldPolice.getIdConvention().getId().compareTo(police.getIdConvention().getId()) != 0)) {
                avenant.setIdConvention(police.getIdConvention());
            } else if (oldPolice.getIdConvention() == null) {
                if (police.getIdConvention() != null && police.getIdConvention().getId() != null) {
                    avenant.setIdConvention(police.getIdConvention());
                }

            }

            if (oldPolice.getIdExoneration() != null && oldPolice.getIdExoneration().getIdExoneration().compareTo(police.getIdExoneration().getIdExoneration()) != 0) {
                avenant.setIdExoneration(police.getIdExoneration());
            } else if (oldPolice.getIdExoneration() == null) {
                if (police.getIdExoneration() != null && police.getIdExoneration().getIdExoneration() != null) {
                    avenant.setIdExoneration(police.getIdExoneration());
                }
            }

            if (oldPolice.getIdFractionnementCategories() != null && oldPolice.getIdFractionnementCategories().getId().compareTo(police.getIdFractionnementCategories().getId()) != 0) {
                avenant.setIdFractionnementCategories(police.getIdFractionnementCategories());
            } else if (oldPolice.getIdFractionnementCategories() == null) {
                if (police.getIdFractionnementCategories() != null && police.getIdFractionnementCategories().getId() != null) {
                    avenant.setIdFractionnementCategories(police.getIdFractionnementCategories());
                }

            }
            if (oldPolice.getIdMajorationDuree() != null && (oldPolice.getIdMajorationDuree().getId().compareTo(police.getIdMajorationDuree().getId()) != 0)) {
                avenant.setIdMajorationDuree(police.getIdMajorationDuree());
            } else if (oldPolice.getIdMajorationDuree() == null) {
                if (police.getIdMajorationDuree() != null && police.getIdMajorationDuree().getId() != null) {
                    avenant.setIdMajorationDuree(police.getIdMajorationDuree());
                }

            }
            if (oldPolice.getIdReduction() != null && oldPolice.getIdReduction().getId().compareTo(police.getIdReduction().getId()) != 0) {
                avenant.setIdReduction(police.getIdReduction());
            } else if (oldPolice.getIdReduction() == null) {
                if (police.getIdReduction() != null && police.getIdReduction().getId() != null) {
                    avenant.setIdReduction(police.getIdReduction());
                }

            }
            if (oldPolice.getIdTimbre() != null && oldPolice.getIdTimbre().getId().compareTo(police.getIdTimbre().getId()) != 0) {
                avenant.setIdTimbre(police.getIdTimbre());
            }
            if (oldPolice.getIdTimbreDimension() != null && oldPolice.getIdTimbreDimension().getId().compareTo(police.getIdTimbreDimension().getId()) != 0) {
                avenant.setIdTimbreDimension(police.getIdTimbreDimension());
            } else if (oldPolice.getIdTimbre() == null) {
                if (police.getIdTimbreDimension() != null && police.getIdTimbreDimension().getId() != null) {
                    avenant.setIdTimbreDimension(police.getIdTimbreDimension());
                }

            }
            if (oldPolice.getIdTimbreDimension() != null && oldPolice.getIdTimbreDimension().getId().compareTo(police.getIdTimbreDimension().getId()) != 0) {
                avenant.setIdTimbreDimension(police.getIdTimbreDimension());
            } else if (oldPolice.getIdTimbreDimension() == null) {
                if (police.getIdTimbreDimension() != null && police.getIdTimbreDimension().getId() != null) {
                    avenant.setIdTimbreDimension(police.getIdTimbreDimension());
                }
            }
            if (oldPolice.getIdTypeTarif() != null && oldPolice.getIdTypeTarif().getId().compareTo(police.getIdTypeTarif().getId()) != 0) {
                avenant.setIdTypeTarif(police.getIdTypeTarif());
            }
            if (oldPolice.getMontantaccessoir() != null && oldPolice.getMontantaccessoir().compareTo(police.getMontantaccessoir()) != 0) {
                avenant.setMontantaccessoir(police.getMontantaccessoir());
            } else if (oldPolice.getMontantaccessoir() == BigDecimal.ZERO || oldPolice.getMontantaccessoir() == null) {
                if (police.getMontantaccessoir() != null && police.getMontantaccessoir() != BigDecimal.ZERO) {
                    avenant.setMontantaccessoir(police.getMontantaccessoir());
                }
            }
            if (oldPolice.getNatureContrat() != police.getNatureContrat()) {
                avenant.setNatureContrat(police.getNatureContrat());
            }
            if (oldPolice.getNombre_timbre() != null && (oldPolice.getNombre_timbre().compareTo(police.getNombre_timbre()) != 0)) {
                avenant.setNombre_timbre(police.getNombre_timbre());
            } else if (oldPolice.getNombre_timbre() == null) {
                if (police.getNombre_timbre() != null && police.getNombre_timbre() != BigInteger.ZERO) {
                    avenant.setNombre_timbre(police.getNombre_timbre());
                }

            }

//            if (oldPolice.getNombre_timbre().compareTo(police.getNombre_timbre()) !=0 ) {
//                avenant.setNombre_timbre(police.getNombre_timbre());
//            }
            if (oldPolice.getNumero_Borderau() != null && (oldPolice.getNumero_Borderau() != (police.getNumero_Borderau()))) {
                avenant.setNumero_Borderau(police.getNumero_Borderau());
            } else if (oldPolice.getNumero_Borderau() == null) {
                if (police.getNumero_Borderau() != null && police.getNumero_Borderau() != "") {
                    avenant.setNumero_Borderau(police.getNumero_Borderau());
                }
            }
            if (oldPolice.getRef_intermediaire() != null && (oldPolice.getRef_intermediaire() != (police.getRef_intermediaire()))) {
                avenant.setRef_intermediaire(police.getRef_intermediaire());
            } else if (oldPolice.getRef_intermediaire() == null) {
                if (police.getRef_intermediaire() != null && police.getRef_intermediaire() != "") {
                    avenant.setRef_intermediaire(police.getRef_intermediaire());
                }
            }

            if (oldPolice.getUniteDuree() != null && (oldPolice.getUniteDuree().compareTo(police.getUniteDuree()) != 0)) {
                avenant.setUniteDuree(police.getUniteDuree());
            }
            if (oldPolice.getValeurDuree() != null && (oldPolice.getValeurDuree().compareTo(police.getValeurDuree()) != 0)) {
                avenant.setValeurDuree(police.getValeurDuree());
            }
            if (oldPolice.getValeur_Devis() != null && oldPolice.getValeur_Devis().compareTo(police.getValeur_Devis()) != 0) {
                avenant.setValeur_Devis(police.getValeur_Devis());
            }
            if (oldPolice.getValeur_timbre() != null && (oldPolice.getValeur_timbre().compareTo(police.getValeur_timbre()) != 0)) {
                avenant.setValeur_timbre(police.getValeur_timbre());
            }
            // verifions au niveau du souscripteur
            if (oldAssure.getAdresse() != null) {

                if (oldAssure.getAdresse().getBp() != null && !oldAssure.getAdresse().getBp().equals(assure.getAdresse().getBp())) {
                    avenant.getAdresse().setBp(assure.getAdresse().getBp());
                }
                if (oldAssure.getAdresse().getEmail() != null && !oldAssure.getAdresse().getEmail().equals(assure.getAdresse().getEmail())) {
                    avenant.getAdresse().setEmail(assure.getAdresse().getEmail());
                }
                if (oldAssure.getAdresse().getTel() != null && !oldAssure.getAdresse().getTel().equals(assure.getAdresse().getTel())) {
                    avenant.getAdresse().setTel(assure.getAdresse().getTel());
                }
                if (oldAssure.getAdresse().getQuartier() != null && (!oldAssure.getAdresse().getQuartier().equals(assure.getAdresse().getQuartier()))) {
                    avenant.getAdresse().setQuartier(assure.getAdresse().getQuartier());
                }
                if (oldAssure.getAdresse().getVille() != null && (!oldAssure.getAdresse().getVille().equals(assure.getAdresse().getVille()))) {
                    avenant.getAdresse().setVille(assure.getAdresse().getVille());
                }

            }
            if (oldAssure.getDate_naissance() != null && (oldAssure.getDate_naissance().compareTo(assure.getDate_naissance()) != 0)) {
                avenant.setDate_naissance(assure.getDate_naissance());
            }
//            if (!oldAssure.getGsm().equals(assure.getGsm())) {
//                avenant.setGsm(assure.getGsm());
//            }
            if (oldAssure.getIdActivite() != null && (oldAssure.getIdActivite().getId().compareTo(assure.getIdActivite().getId()) != 0)) {
                avenant.setIdActivite(assure.getIdActivite());
            }
            if (oldAssure.getIdProfession() != null && (oldAssure.getIdProfession().getId().compareTo(assure.getIdProfession().getId()) != 0)) {
                avenant.setIdProfession(assure.getIdProfession());
            }

            if (oldAssure.getIdQualite() != null && (oldAssure.getIdQualite().getId().compareTo(assure.getIdQualite().getId()) != 0)) {
                avenant.setIdQualite(assure.getIdQualite());
            }
            if (oldAssure.getIdVille() != null && (oldAssure.getIdVille().getId().compareTo(assure.getIdVille().getId()) != 0)) {
                avenant.setIdVille(assure.getIdVille());
            }

            if (oldAssure.getLieu_naissance() != null && !oldAssure.getLieu_naissance().equals(assure.getLieu_naissance())) {
                avenant.setLieu_naissance(assure.getLieu_naissance());
            }

            if (oldAssure.getNom() != null && !oldAssure.getNom().equals(assure.getNom())) {
                avenant.setNom(assure.getNom());
            }
            if (oldAssure.getNum_cni() != null && !oldAssure.getNum_cni().equals(assure.getNum_cni())) {
                avenant.setNum_cni(assure.getNum_cni());
            }
            if (oldAssure.getNumero_piece() != null && !oldAssure.getNumero_piece().equals(assure.getNumero_piece())) {
                avenant.setNumero_piece(assure.getNumero_piece());
            }
            if (oldAssure.getPatente() != null && !oldAssure.getPatente().equals(assure.getPatente())) {
                avenant.setPatente(assure.getPatente());
            }
            if (oldAssure.getPrenom() != null && !oldAssure.getPrenom().equals(assure.getPrenom())) {
                avenant.setPrenom(assure.getPrenom());
            }
            if (oldAssure.getRaison_social() != null && !oldAssure.getRaison_social().equals(assure.getRaison_social())) {
                avenant.setRaison_social(assure.getRaison_social());
            }
            if (oldAssure.getRegistre_commercial() != null && !oldAssure.getRegistre_commercial().equals(assure.getRegistre_commercial())) {
                avenant.setRegistre_commercial(assure.getRegistre_commercial());
            }
            if (oldAssure.getSexe() != null && oldAssure.getSexe() != assure.getSexe()) {
                avenant.setSexe(assure.getSexe());
            }

            if (oldAssure.getTypePieces() != null && oldAssure.getTypePieces() != assure.getTypePieces()) {
                avenant.setTypePieces(assure.getTypePieces());
            }
            //
            BigInteger lastNumberForAvenant = avenantDao.lastNumeroAvenantByPolice(police, entreprises);
            if (lastNumberForAvenant == BigInteger.ZERO) {
                lastNumberForAvenant = lastNumberForAvenant.add(BigInteger.ONE);

            } else {
                lastNumberForAvenant = lastNumberForAvenant.add(BigInteger.ONE);
            }
            avenant.setNumero_avenant(lastNumberForAvenant);
            avenant.setIdTypeAvenant(tpa);
            avenant.setDateCreation(new Date());
            avenant.setIdUtilisateur(user);
            avenant.setIdEntreprises(entreprises);
            avenant.setIdPolice(oldPolice);
            em.persist(avenant);

            //risque
            OrclassRisque newrisque = null;
            OrclassRisque r = null;
            OrclassRisqueFamille risqueFamille = null;
            OrclassRisqueFamille rf = null;
            if (listeRisque.size() == 1 && (famille == null || famille.isEmpty())) {
                // il  s agit de l indivisuel

                r = (OrclassRisque) listeRisque.toArray()[0];
                if (r != null && r.getTypeAvenant() != null && r.getTypeAvenant().getId() != null && r.getId() != null) {
                    // ici on suppose qu il ya eut modification sur un champ precis
//                    newrisque = new OrclassRisque();
//                    newrisque.setDateCreation(new Date());
//                    newrisque.setMatricule(r.getMatricule());
//                    newrisque.setDateEntree(r.getDateEntree());
//                    newrisque.setDateNaissance(r.getDateNaissance());
//                    newrisque.setIdEntreprise(entreprises);
//                    newrisque.setIdPolice(oldPolice);
//                    newrisque.setLibelle(r.getLibelle());
//                    newrisque.setSexe(r.getSexe());
//                    newrisque.setIdGroup(r.getIdGroup());
                    r.setIdVille(assure.getIdVille());
                    r.setModifier(Boolean.TRUE);
//                    newrisque.setIdAvenant(avenant);
//                    newrisque.setSaisir_par(user.getNom() + " " + user.getPrenom());
//                    em.persist(newrisque);
                    em.merge(r);
                } else if (r.getTypeAvenant() != null && r.getTypeAvenant().getId() != null && r.getId() == null) {
                    newrisque = new OrclassRisque();
                    newrisque.setDateCreation(new Date());
                    newrisque.setMatricule(r.getMatricule());
                    newrisque.setDateEntree(r.getDateEntree());
                    newrisque.setDateNaissance(r.getDateNaissance());
                    newrisque.setIdEntreprise(entreprises);
                    newrisque.setIdPolice(oldPolice);
                    newrisque.setLibelle(r.getLibelle());
                    newrisque.setSexe(r.getSexe());
                    newrisque.setIdGroup(r.getIdGroup());
                    newrisque.setIdVille(assure.getIdVille());
                    newrisque.setIdGroup(r.getIdGroup());
                    newrisque.setAjouter(Boolean.TRUE);
                    newrisque.setIdAvenant(avenant);
                    newrisque.setSaisir_par(user.getNom() + " " + user.getPrenom());
                    em.persist(newrisque);
                } else if (r != null && r.getTypeAvenant() != null && r.getTypeAvenant().getId() != null && r.getId() != null && Objects.equals(r.getRetire_de_la_police(), Boolean.TRUE)) {
                    newrisque = new OrclassRisque();
                    newrisque.setDateCreation(new Date());
                    newrisque.setMatricule(r.getMatricule());
                    newrisque.setDateEntree(r.getDateEntree());
                    newrisque.setDateNaissance(r.getDateNaissance());
                    newrisque.setIdEntreprise(entreprises);
                    newrisque.setIdPolice(oldPolice);
                    newrisque.setLibelle(r.getLibelle());
                    newrisque.setSexe(r.getSexe());
                    newrisque.setIdGroup(r.getIdGroup());
                    newrisque.setIdVille(assure.getIdVille());
                    newrisque.setRetire_de_la_police(Boolean.TRUE);
                    newrisque.setCodeid_retirer(r.getId());
                    newrisque.setIdAvenant(avenant);
                    newrisque.setSaisir_par(user.getNom() + " " + user.getPrenom());
                    em.persist(newrisque);
                } else if (r != null & r.getId() != null && r.getIdAvenant() != null && r.getIdAvenant().getId() != null) {
//                    newrisque = new OrclassRisque();
//                    newrisque.setDateCreation(new Date());
//                    newrisque.setMatricule(r.getMatricule());
//                    newrisque.setDateEntree(r.getDateEntree());
//                    newrisque.setDateNaissance(r.getDateNaissance());
//                    newrisque.setIdEntreprise(entreprises);
//                    newrisque.setIdPolice(oldPolice);
//                    newrisque.setLibelle(r.getLibelle());
//                    newrisque.setSexe(r.getSexe());
//                    newrisque.setIdGroup(r.getIdGroup());
                    r.setIdVille(assure.getIdVille());
//                    newrisque.setAjouter(Boolean.TRUE);
//                    newrisque.setIdAvenant(avenant);
//                    newrisque.setSaisir_par(user.getNom() + " " + user.getPrenom());
//                    newrisque.setAjouter(r.getAjouter());
//                    newrisque.setModifier(r.getModifier());
//                    newrisque.setRetire_de_la_police(r.getRetire_de_la_police());
//                    newrisque.setCodeid_retirer(r.getCodeid_retirer());
                    em.merge(r);

                }

            } else if (listeRisque.size() == 1 && (famille != null && !famille.isEmpty())) {
                if (r != null && r.getTypeAvenant() != null && r.getTypeAvenant().getId() != null && r.getId() != null) {
//                    newrisque = new OrclassRisque();
//                    newrisque.setDateCreation(new Date());
//                    newrisque.setMatricule(r.getMatricule());
//                    newrisque.setDateEntree(r.getDateEntree());
//                    newrisque.setDateNaissance(r.getDateNaissance());
//                    newrisque.setIdEntreprise(entreprises);
//                    newrisque.setIdPolice(oldPolice);
//                    newrisque.setLibelle(r.getLibelle());
//                    newrisque.setSexe(r.getSexe());
//                    newrisque.setIdGroup(r.getIdGroup());
                    r.setIdVille(assure.getIdVille());
//                    r.setModifier(r.getModifier());
//                    newrisque.setIdAvenant(avenant);
//                    newrisque.setSaisir_par(user.getNom() + " " + user.getPrenom());
                    em.merge(r);
                } else if (r != null && r.getId() != null && r.getIdAvenant() != null && r.getIdAvenant().getId() != null) {
//                    newrisque = new OrclassRisque();
//                    newrisque.setDateCreation(new Date());
//                    newrisque.setMatricule(r.getMatricule());
//                    newrisque.setDateEntree(r.getDateEntree());
//                    newrisque.setDateNaissance(r.getDateNaissance());
//                    newrisque.setIdEntreprise(entreprises);
//                    newrisque.setIdPolice(oldPolice);
//                    newrisque.setLibelle(r.getLibelle());
//                    newrisque.setSexe(r.getSexe());
//                    newrisque.setIdGroup(r.getIdGroup());
                    r.setIdVille(assure.getIdVille());
//                    newrisque.setModifier(Boolean.TRUE);
//                    newrisque.setIdAvenant(avenant);
//                    newrisque.setSaisir_par(user.getNom() + " " + user.getPrenom());
//                    newrisque.setAjouter(r.getAjouter());
//                    newrisque.setRetire_de_la_police(r.getRetire_de_la_police());
//                    newrisque.setCodeid_retirer(r.getCodeid_retirer());

                    em.merge(r);
                }

                for (OrclassRisqueFamille rfs : famille) {
                    rf = rfs;
                    if (newrisque == null || newrisque.getId() == null) {
                        newrisque = rfs.getIdRisque();

                    }
                    if (rf != null && rf.getId() != null && rf.getTypeAvenant() != null && rf.getTypeAvenant().getId() != null) {
                        risqueFamille = rf;
//                        risqueFamille.setDateEntree(rf.getDateEntree());
//                        risqueFamille.setDateNaissance(rf.getDateNaissance());
//                        risqueFamille.setIdEntreprise(entreprises);
//                        risqueFamille.setIdPolice(oldPolice);
//                        risqueFamille.setIdRisque(newrisque);
                        risqueFamille.setIdVille(assure.getIdVille());
//                        risqueFamille.setLienParente(rf.getLienParente());
//                        risqueFamille.setNom_membre(rf.getNom_membre());
//                        risqueFamille.setIdAvenant(avenant);
//                        risqueFamille.setModifier(Boolean.TRUE);

//                        risqueFamille.setSexe(rf.getSexe());
                        em.merge(risqueFamille);
                    } else if ((rf == null || rf.getId() == null) && rf.getTypeAvenant() != null && rf.getTypeAvenant().getId() != null) {

                        risqueFamille = new OrclassRisqueFamille();
                        risqueFamille.setDateEntree(rf.getDateEntree());
                        risqueFamille.setDateNaissance(rf.getDateNaissance());
                        risqueFamille.setIdEntreprise(entreprises);
                        risqueFamille.setIdPolice(oldPolice);
                        risqueFamille.setIdRisque(newrisque);
                        risqueFamille.setIdVille(assure.getIdVille());
                        risqueFamille.setLienParente(rf.getLienParente());
                        risqueFamille.setNom_membre(rf.getNom_membre());
                        risqueFamille.setIdAvenant(avenant);
                        risqueFamille.setAjouter(Boolean.TRUE);

                        risqueFamille.setSexe(rf.getSexe());
                        em.persist(risqueFamille);
                    } else if (rf != null && rf.getId() != null && rf.getTypeAvenant() != null && rf.getTypeAvenant().getId() != null && Objects.equals(rf.getRetire_de_la_police(), Boolean.TRUE)) {

                        risqueFamille = new OrclassRisqueFamille();
                        risqueFamille.setDateEntree(rf.getDateEntree());
                        risqueFamille.setDateNaissance(rf.getDateNaissance());
                        risqueFamille.setIdEntreprise(entreprises);
                        risqueFamille.setIdPolice(oldPolice);
                        risqueFamille.setIdRisque(newrisque);
                        risqueFamille.setIdVille(assure.getIdVille());
                        risqueFamille.setLienParente(rf.getLienParente());
                        risqueFamille.setNom_membre(rf.getNom_membre());
                        risqueFamille.setIdAvenant(avenant);
                        risqueFamille.setRetire_de_la_police(Boolean.TRUE);
                        risqueFamille.setCodeid_retirer(rf.getId());
                        risqueFamille.setSexe(rf.getSexe());
                        em.persist(risqueFamille);
                    } else if (rf != null && rf.getId() != null && rf.getIdAvenant() != null && rf.getIdAvenant().getId() != null) {
                        risqueFamille = rf;
//                        risqueFamille.setDateEntree(rf.getDateEntree());
//                        risqueFamille.setDateNaissance(rf.getDateNaissance());
//                        risqueFamille.setIdEntreprise(entreprises);
//                        risqueFamille.setIdPolice(oldPolice);
//                        risqueFamille.setIdRisque(newrisque);
                        risqueFamille.setIdVille(assure.getIdVille());
//                        risqueFamille.setLienParente(rf.getLienParente());
//                        risqueFamille.setNom_membre(rf.getNom_membre());
//                        risqueFamille.setIdAvenant(avenant);
//                        risqueFamille.setRetire_de_la_police(Boolean.TRUE);
//                        risqueFamille.setCodeid_retirer(rf.getId());
//                        risqueFamille.setSexe(rf.getSexe());
//                        risqueFamille.setAjouter(rf.getAjouter());
//                        risqueFamille.setRetire_de_la_police(rf.getRetire_de_la_police());
//                        risqueFamille.setCodeid_retirer(rf.getCodeid_retirer());
//                        risqueFamille.setModifier(rf.getModifier());
                        em.merge(risqueFamille);
                    }

                }

            } else if (listeRisque.size() >= 1 && (famille == null || famille.isEmpty())) {
                for (OrclassRisque rq : listeRisque) {
                    r = rq;
                    if (rq != null && rq.getId() != null) {
                        newrisque = rq;
                    }

                    if (r != null && r.getTypeAvenant() != null && r.getTypeAvenant().getId() != null && r.getId() != null && Objects.equals(r.getRetire_de_la_police(), Boolean.FALSE)) {
                        newrisque = r;
//                        newrisque.setDateCreation(new Date());
//                        newrisque.setMatricule(r.getMatricule());
//                        newrisque.setDateEntree(r.getDateEntree());
//                        newrisque.setDateNaissance(r.getDateNaissance());
//                        newrisque.setIdEntreprise(entreprises);
//                        newrisque.setIdPolice(oldPolice);
//                        newrisque.setLibelle(r.getLibelle());
//                        newrisque.setSexe(r.getSexe());
//                        newrisque.setIdGroup(r.getIdGroup());
                        newrisque.setIdVille(assure.getIdVille());
//                        newrisque.setModifier(Boolean.TRUE);
//                        newrisque.setIdAvenant(avenant);
                        newrisque.setSaisir_par(user.getNom() + " " + user.getPrenom());
                        em.merge(newrisque);
                    } else if (r.getTypeAvenant() != null && r.getTypeAvenant().getId() != null && r.getId() == null) {
                        newrisque = new OrclassRisque();
                        newrisque.setDateCreation(new Date());
                        newrisque.setMatricule(r.getMatricule());
                        newrisque.setDateEntree(r.getDateEntree());
                        newrisque.setDateNaissance(r.getDateNaissance());
                        newrisque.setIdEntreprise(entreprises);
                        newrisque.setIdPolice(oldPolice);
                        newrisque.setLibelle(r.getLibelle());
                        newrisque.setSexe(r.getSexe());
                        newrisque.setIdGroup(r.getIdGroup());
                        newrisque.setIdVille(assure.getIdVille());
                        newrisque.setAjouter(Boolean.TRUE);
                        newrisque.setIdAvenant(avenant);
                        newrisque.setSaisir_par(user.getNom() + " " + user.getPrenom());
                        em.persist(newrisque);
                    } else if (r != null && r.getTypeAvenant() != null && r.getTypeAvenant().getId() != null && r.getId() != null && Objects.equals(r.getRetire_de_la_police(), Boolean.TRUE)) {
                        newrisque = new OrclassRisque();
                        newrisque.setDateCreation(new Date());
                        newrisque.setMatricule(r.getMatricule());
                        newrisque.setDateEntree(r.getDateEntree());
                        newrisque.setDateNaissance(r.getDateNaissance());
                        newrisque.setIdEntreprise(entreprises);
                        newrisque.setIdPolice(oldPolice);
                        newrisque.setLibelle(r.getLibelle());
                        newrisque.setSexe(r.getSexe());
                        newrisque.setIdGroup(r.getIdGroup());
                        newrisque.setIdVille(assure.getIdVille());
                        newrisque.setRetire_de_la_police(Boolean.TRUE);
                        newrisque.setIdAvenant(avenant);
                        newrisque.setCodeid_retirer(r.getId());
                        newrisque.setSaisir_par(user.getNom() + " " + user.getPrenom());
                        em.persist(newrisque);
                    } else if (r != null && r.getId() != null && r.getIdAvenant() != null && r.getIdAvenant().getId() != null) {
                        newrisque = r;
//                        newrisque.setDateCreation(new Date());
//                        newrisque.setMatricule(r.getMatricule());
//                        newrisque.setDateEntree(r.getDateEntree());
//                        newrisque.setDateNaissance(r.getDateNaissance());
//                        newrisque.setIdEntreprise(entreprises);
//                        newrisque.setIdPolice(oldPolice);
//                        newrisque.setLibelle(r.getLibelle());
//                        newrisque.setSexe(r.getSexe());
//                        newrisque.setIdGroup(r.getIdGroup());
                        newrisque.setIdVille(assure.getIdVille());
//                        newrisque.setRetire_de_la_police(r.getRetire_de_la_police());
//                        newrisque.setIdAvenant(avenant);
//                        newrisque.setCodeid_retirer(r.getCodeid_retirer());
//                        newrisque.setAjouter(r.getAjouter());
//                        newrisque.setModifier(r.getModifier());
//                        newrisque.setSaisir_par(user.getNom() + " " + user.getPrenom());

                        em.merge(newrisque);

                    }
                    for (OrclassRisqueFamille rfm : r.getListeRisqueFamille()) {
                        rf = rfm;
                        if (newrisque == null || newrisque.getId() == null) {
                            newrisque = rfm.getIdRisque();
                        }
                        if (rf != null && rf.getId() != null && rf.getTypeAvenant() != null && rf.getTypeAvenant().getId() != null) {
                            risqueFamille = rf;
//                            risqueFamille.setDateEntree(rf.getDateEntree());
//                            risqueFamille.setDateNaissance(rf.getDateNaissance());
//                            risqueFamille.setIdEntreprise(entreprises);
//                            risqueFamille.setIdPolice(oldPolice);
//                            risqueFamille.setIdRisque(newrisque);
                            risqueFamille.setIdVille(assure.getIdVille());
//                            risqueFamille.setLienParente(rf.getLienParente());
//                            risqueFamille.setNom_membre(rf.getNom_membre());
//                            risqueFamille.setIdAvenant(avenant);
//                            risqueFamille.setModifier(Boolean.TRUE);

//                            risqueFamille.setSexe(rf.getSexe());
                            em.merge(risqueFamille);
                        } else if ((rf == null || rf.getId() == null) && rf.getTypeAvenant() != null && rf.getTypeAvenant().getId() != null) {

                            risqueFamille = new OrclassRisqueFamille();
                            risqueFamille.setDateEntree(rf.getDateEntree());
                            risqueFamille.setDateNaissance(rf.getDateNaissance());
                            risqueFamille.setIdEntreprise(entreprises);
                            risqueFamille.setIdPolice(oldPolice);
                            risqueFamille.setIdRisque(newrisque);
                            risqueFamille.setIdVille(assure.getIdVille());
                            risqueFamille.setLienParente(rf.getLienParente());
                            risqueFamille.setNom_membre(rf.getNom_membre());
                            risqueFamille.setIdAvenant(avenant);
                            risqueFamille.setAjouter(Boolean.TRUE);

                            risqueFamille.setSexe(rf.getSexe());
                            em.persist(risqueFamille);
                        } else if (rf != null && rf.getId() != null && rf.getTypeAvenant() != null && rf.getTypeAvenant().getId() != null && Objects.equals(rf.getRetire_de_la_police(), Boolean.TRUE)) {

                            risqueFamille = new OrclassRisqueFamille();
                            risqueFamille.setDateEntree(rf.getDateEntree());
                            risqueFamille.setDateNaissance(rf.getDateNaissance());
                            risqueFamille.setIdEntreprise(entreprises);
                            risqueFamille.setIdPolice(oldPolice);
                            risqueFamille.setIdRisque(newrisque);
                            risqueFamille.setIdVille(assure.getIdVille());
                            risqueFamille.setLienParente(rf.getLienParente());
                            risqueFamille.setNom_membre(rf.getNom_membre());
                            risqueFamille.setIdAvenant(avenant);
                            risqueFamille.setRetire_de_la_police(Boolean.TRUE);
                            risqueFamille.setCodeid_retirer(rf.getId());
                            risqueFamille.setSexe(rf.getSexe());
                            em.persist(risqueFamille);
                        } else if (rf != null && rf.getId() != null && rf.getIdAvenant() != null && rf.getIdAvenant().getId() != null) {
                            risqueFamille = rf;
//                            risqueFamille.setDateEntree(rf.getDateEntree());
//                            risqueFamille.setDateNaissance(rf.getDateNaissance());
//                            risqueFamille.setIdEntreprise(entreprises);
//                            risqueFamille.setIdPolice(oldPolice);
//                            risqueFamille.setIdRisque(newrisque);
                            risqueFamille.setIdVille(assure.getIdVille());
//                            risqueFamille.setLienParente(rf.getLienParente());
//                            risqueFamille.setNom_membre(rf.getNom_membre());
//                            risqueFamille.setIdAvenant(avenant);
//                            risqueFamille.setRetire_de_la_police(Boolean.TRUE);
//                            risqueFamille.setCodeid_retirer(rf.getId());
//                            risqueFamille.setSexe(rf.getSexe());
//                            risqueFamille.setAjouter(rf.getAjouter());
//                            risqueFamille.setRetire_de_la_police(rf.getRetire_de_la_police());
//                            risqueFamille.setCodeid_retirer(rf.getCodeid_retirer());
//                            risqueFamille.setModifier(rf.getModifier());
                            em.merge(risqueFamille);
                        }
                    }
                }
            }

            /*
                enregistrement police plafond
             */
            OrclassPolicePlafond newPlafondMaladie = null;
//            newPlafondMaladie=policePlafondDao.chargePolicePlafonMaladie(police, entreprises)
            if ((policePlafond == null || policePlafond.getId() == null) && policePlafond.getTypeAvenant() != null && policePlafond.getId() != null) {
                newPlafondMaladie = new OrclassPolicePlafond();
                newPlafondMaladie.setIdCategories(oldPolice.getIdCategories());
                newPlafondMaladie.setIdPlafondMaladie(policePlafond.getIdPlafondMaladie());
                newPlafondMaladie.setIdPolice(oldPolice);
                newPlafondMaladie.setIdGroup(policePlafond.getIdGroup());
                newPlafondMaladie.setIdEntreprise(entreprises);
                newPlafondMaladie.setAjouter(Boolean.TRUE);
                newPlafondMaladie.setIdAvenant(avenant);

                em.persist(newPlafondMaladie);
            }


            /*
                enregistrement detail police plafond
             */
            OrclassDetailPolicePlafond newDetailPolicePlafond;
            for (OrclassDetailPolicePlafond dppf : detailPolicePlafonds) {
                if (dppf.getIdPrestation() == null || dppf.getIdPrestation().getId() == null) {
                    continue;
                }
                if (dppf != null && dppf.getId() != null && dppf.getTypeAvenant() != null && dppf.getTypeAvenant().getId() != null && dppf.getRetire_de_la_police() == Boolean.FALSE) {
                    newDetailPolicePlafond = dppf;
//                    newDetailPolicePlafond.setIdEntreprise(entreprises);
//                    newDetailPolicePlafond.setBarem(dppf.getBarem());
//                    newDetailPolicePlafond.setCode_ss(dppf.getCode_ss());
//                    newDetailPolicePlafond.setForfait(dppf.getForfait());
//                    newDetailPolicePlafond.setIdPolicePlafond(dppf.getIdPolicePlafond());
//                    newDetailPolicePlafond.setIdPrestation(dppf.getIdPrestation());
//                    newDetailPolicePlafond.setIdRubrique(dppf.getIdRubrique());
//                    newDetailPolicePlafond.setModeCalculDetailMaladie(dppf.getModeCalculDetailMaladie());
//                    newDetailPolicePlafond.setPlafond(dppf.getPlafond());
//                    newDetailPolicePlafond.setTaux(dppf.getTaux());
//                    newDetailPolicePlafond.setTypeDetailMaladie(dppf.getTypeDetailMaladie());
//                    newDetailPolicePlafond.setModifier(Boolean.TRUE);
//                    newDetailPolicePlafond.setIdAvenant(avenant);

                    em.merge(newDetailPolicePlafond);
                } else if (dppf != null && dppf.getId() != null && dppf.getTypeAvenant() != null && dppf.getTypeAvenant().getId() != null && dppf.getRetire_de_la_police() == Boolean.TRUE) {
                    newDetailPolicePlafond = new OrclassDetailPolicePlafond();
                    newDetailPolicePlafond.setIdEntreprise(entreprises);
                    newDetailPolicePlafond.setBarem(dppf.getBarem());
                    newDetailPolicePlafond.setCode_ss(dppf.getCode_ss());
                    newDetailPolicePlafond.setForfait(dppf.getForfait());
                    newDetailPolicePlafond.setIdPolicePlafond(dppf.getIdPolicePlafond());
                    newDetailPolicePlafond.setIdPrestation(dppf.getIdPrestation());
                    newDetailPolicePlafond.setIdRubrique(dppf.getIdRubrique());
                    newDetailPolicePlafond.setModeCalculDetailMaladie(dppf.getModeCalculDetailMaladie());
                    newDetailPolicePlafond.setPlafond(dppf.getPlafond());
                    newDetailPolicePlafond.setTaux(dppf.getTaux());
                    newDetailPolicePlafond.setTypeDetailMaladie(dppf.getTypeDetailMaladie());
                    newDetailPolicePlafond.setRetire_de_la_police(Boolean.TRUE);
                    newDetailPolicePlafond.setCodeid_retirer(dppf.getId());
                    newDetailPolicePlafond.setIdGroup(dppf.getIdGroup());
                    newDetailPolicePlafond.setIdAvenant(avenant);

                    em.persist(newDetailPolicePlafond);
                } else if ((dppf == null || dppf.getId() == null) && dppf.getTypeAvenant() != null && dppf.getTypeAvenant().getId() != null) {
                    newDetailPolicePlafond = new OrclassDetailPolicePlafond();
                    newDetailPolicePlafond.setIdEntreprise(entreprises);
                    newDetailPolicePlafond.setBarem(dppf.getBarem());
                    newDetailPolicePlafond.setCode_ss(dppf.getCode_ss());
                    newDetailPolicePlafond.setForfait(dppf.getForfait());
                    if (newPlafondMaladie != null && newDetailPolicePlafond.getId() != null) {
                        newDetailPolicePlafond.setIdPolicePlafond(newPlafondMaladie);
                    } else if (dppf.getIdPolicePlafond() != null && dppf.getIdPolicePlafond().getId() != null) {
                        newDetailPolicePlafond.setIdPolicePlafond(dppf.getIdPolicePlafond());
                    } else {
                        newDetailPolicePlafond.setIdPolicePlafond(policePlafondDao.chargePolicePlafonMaladie(oldPolice, entreprises));
                    }

                    newDetailPolicePlafond.setIdPrestation(dppf.getIdPrestation());
                    newDetailPolicePlafond.setIdRubrique(dppf.getIdRubrique());
                    newDetailPolicePlafond.setModeCalculDetailMaladie(dppf.getModeCalculDetailMaladie());
                    newDetailPolicePlafond.setPlafond(dppf.getPlafond());
                    newDetailPolicePlafond.setTaux(dppf.getTaux());
                    newDetailPolicePlafond.setTypeDetailMaladie(dppf.getTypeDetailMaladie());
                    newDetailPolicePlafond.setAjouter(Boolean.TRUE);
                    newDetailPolicePlafond.setIdAvenant(avenant);
                    newDetailPolicePlafond.setIdGroup(dppf.getIdGroup());
                    em.persist(newDetailPolicePlafond);

                } else if (dppf != null && dppf.getId() != null && dppf.getIdAvenant() != null && dppf.getIdAvenant().getId() != null) {
                    newDetailPolicePlafond = dppf;
//                    newDetailPolicePlafond.setIdEntreprise(entreprises);
//                    newDetailPolicePlafond.setBarem(dppf.getBarem());
//                    newDetailPolicePlafond.setCode_ss(dppf.getCode_ss());
//                    newDetailPolicePlafond.setForfait(dppf.getForfait());
//                    if (newPlafondMaladie != null && newDetailPolicePlafond.getId() != null) {
//                        newDetailPolicePlafond.setIdPolicePlafond(newPlafondMaladie);
//                    } else if (dppf.getIdPolicePlafond() != null && dppf.getIdPolicePlafond().getId() != null) {
//                        newDetailPolicePlafond.setIdPolicePlafond(dppf.getIdPolicePlafond());
//                    } else {
//                        newDetailPolicePlafond.setIdPolicePlafond(policePlafondDao.chargePolicePlafonMaladie(oldPolice, entreprises));
//                    }
//
//                    newDetailPolicePlafond.setIdPrestation(dppf.getIdPrestation());
//                    newDetailPolicePlafond.setIdRubrique(dppf.getIdRubrique());
//                    newDetailPolicePlafond.setModeCalculDetailMaladie(dppf.getModeCalculDetailMaladie());
//                    newDetailPolicePlafond.setPlafond(dppf.getPlafond());
//                    newDetailPolicePlafond.setTaux(dppf.getTaux());
//                    newDetailPolicePlafond.setTypeDetailMaladie(dppf.getTypeDetailMaladie());
//                    newDetailPolicePlafond.setAjouter(dppf.getAjouter());
//                    newDetailPolicePlafond.setRetire_de_la_police(dppf.getRetire_de_la_police());
//                    newDetailPolicePlafond.setModifier(dppf.getModifier());
//                    newDetailPolicePlafond.setIdAvenant(avenant);
                    em.merge(newDetailPolicePlafond);
                }

            }

            OrclassPoliceCaracteristique newPoliceCaracteristique;

            for (OrclassPoliceCaracteristique pc : policeCaracteristiques) {
                if (pc.getIdCaracteristiques() == null || pc.getIdCaracteristiques().getId() == null) {
                    continue;
                }
                if (pc != null && pc.getId() != null && pc.getTypeAvenant() != null && pc.getTypeAvenant().getId() != null) {
                    if (pc.getValeurBoolean() == null && pc.getDateValeur() == null && pc.getValeurCaracteristique() == null && pc.getValeurCode() == null && (pc.getValeurNumerique() == null || pc.getValeurNumerique().intValue() == 0) && pc.getValeurTexte() == null) {
                        continue;
                    }
                    newPoliceCaracteristique = pc;

//                    newPoliceCaracteristique.setIdCaracteristiques(pc.getIdCaracteristiques());
//                    newPoliceCaracteristique.setIdPolice(oldPolice);
//                    newPoliceCaracteristique.setIdEntreprise(entreprises);
//                    if (pc.getDateValeur() != null) {
//                        newPoliceCaracteristique.setDateValeur(pc.getDateValeur());
//                    }
//                    if (pc.getValeurBoolean() != null) {
//                        newPoliceCaracteristique.setValeurBoolean(pc.getValeurBoolean());
//                    }
//                    if (pc.getValeurCode() != null) {
//                        newPoliceCaracteristique.setValeurCode(pc.getValeurCode());
//                    }
//                    if (pc.getValeurCaracteristique() != null) {
//                        pc.setValeurCaracteristique(pc.getValeurCaracteristique());
//                    }
//                    if (pc.getValeurTexte() != null) {
//                        newPoliceCaracteristique.setValeurTexte(pc.getValeurTexte());
//                    }
//                    if (pc.getValeurNumerique() != null && pc.getValeurNumerique() != null && pc.getValeurNumerique().intValue() != 0) {
//                        newPoliceCaracteristique.setValeurNumerique(pc.getValeurNumerique());
//                    }
//                    newPoliceCaracteristique.setIdCategories(police.getIdCategories());
                    newPoliceCaracteristique.setModifier(Boolean.TRUE);
//                    newPoliceCaracteristique.setIdAvenant(avenant);
                    em.merge(newPoliceCaracteristique);
                } else if (pc != null && pc.getId() != null && pc.getTypeAvenant() != null && pc.getTypeAvenant().getId() != null && pc.getRetire_de_la_police() == Boolean.TRUE) {
                    if (pc.getValeurBoolean() == null && pc.getDateValeur() == null && pc.getValeurCaracteristique() == null && pc.getValeurCode() == null && (pc.getValeurNumerique() == null || pc.getValeurNumerique().intValue() == 0) && pc.getValeurTexte() == null) {
                        continue;
                    }
                    newPoliceCaracteristique = new OrclassPoliceCaracteristique();

                    newPoliceCaracteristique.setIdCaracteristiques(pc.getIdCaracteristiques());
                    newPoliceCaracteristique.setIdPolice(oldPolice);
                    newPoliceCaracteristique.setIdEntreprise(entreprises);
                    if (pc.getDateValeur() != null) {
                        newPoliceCaracteristique.setDateValeur(pc.getDateValeur());
                    }
                    if (pc.getValeurBoolean() != null) {
                        newPoliceCaracteristique.setValeurBoolean(pc.getValeurBoolean());
                    }
                    if (pc.getValeurCode() != null) {
                        newPoliceCaracteristique.setValeurCode(pc.getValeurCode());
                    }
                    if (pc.getValeurCaracteristique() != null) {
                        pc.setValeurCaracteristique(pc.getValeurCaracteristique());
                    }
                    if (pc.getValeurTexte() != null) {
                        newPoliceCaracteristique.setValeurTexte(pc.getValeurTexte());
                    }
                    if (pc.getValeurNumerique() != null && pc.getValeurNumerique() != null && pc.getValeurNumerique().intValue() != 0) {
                        newPoliceCaracteristique.setValeurNumerique(pc.getValeurNumerique());
                    }
                    newPoliceCaracteristique.setIdCategories(police.getIdCategories());
                    newPoliceCaracteristique.setRetire_de_la_police(Boolean.TRUE);
                    newPoliceCaracteristique.setCodeid_retirer(pc.getId());
                    newPoliceCaracteristique.setIdAvenant(avenant);
                    newPoliceCaracteristique.setIdGroup(pc.getIdGroup());
                    em.persist(newPoliceCaracteristique);

                } else if ((pc == null || pc.getId() == null) && pc.getTypeAvenant() != null && pc.getTypeAvenant().getId() != null) {

                    if (pc.getValeurBoolean() == null && pc.getDateValeur() == null && pc.getValeurCaracteristique() == null && pc.getValeurCode() == null && (pc.getValeurNumerique() == null || pc.getValeurNumerique().intValue() == 0) && pc.getValeurTexte() == null) {
                        continue;
                    }
                    newPoliceCaracteristique = new OrclassPoliceCaracteristique();

                    newPoliceCaracteristique.setIdCaracteristiques(pc.getIdCaracteristiques());
                    newPoliceCaracteristique.setIdPolice(oldPolice);
                    newPoliceCaracteristique.setIdEntreprise(entreprises);
                    if (pc.getDateValeur() != null) {
                        newPoliceCaracteristique.setDateValeur(pc.getDateValeur());
                    }
                    if (pc.getValeurBoolean() != null) {
                        newPoliceCaracteristique.setValeurBoolean(pc.getValeurBoolean());
                    }
                    if (pc.getValeurCode() != null) {
                        newPoliceCaracteristique.setValeurCode(pc.getValeurCode());
                    }
                    if (pc.getValeurCaracteristique() != null) {
                        pc.setValeurCaracteristique(pc.getValeurCaracteristique());
                    }
                    if (pc.getValeurTexte() != null) {
                        newPoliceCaracteristique.setValeurTexte(pc.getValeurTexte());
                    }
                    if (pc.getValeurNumerique() != null && pc.getValeurNumerique() != null && pc.getValeurNumerique().intValue() != 0) {
                        newPoliceCaracteristique.setValeurNumerique(pc.getValeurNumerique());
                    }
                    newPoliceCaracteristique.setIdCategories(police.getIdCategories());
                    newPoliceCaracteristique.setAjouter(Boolean.TRUE);

                    newPoliceCaracteristique.setIdAvenant(avenant);
                    newPoliceCaracteristique.setIdGroup(pc.getIdGroup());
                    em.persist(newPoliceCaracteristique);
                } else if (pc != null && pc.getId() != null && pc.getIdAvenant() != null && pc.getIdAvenant().getId() != null) {
                    if (pc.getValeurBoolean() == null && pc.getDateValeur() == null && pc.getValeurCaracteristique() == null && pc.getValeurCode() == null && (pc.getValeurNumerique() == null || pc.getValeurNumerique().intValue() == 0) && pc.getValeurTexte() == null) {
                        continue;
                    }
                    newPoliceCaracteristique = pc;

//                    newPoliceCaracteristique.setIdCaracteristiques(pc.getIdCaracteristiques());
//                    newPoliceCaracteristique.setIdPolice(oldPolice);
//                    newPoliceCaracteristique.setIdEntreprise(entreprises);
//                    if (pc.getDateValeur() != null) {
//                        newPoliceCaracteristique.setDateValeur(pc.getDateValeur());
//                    }
//                    if (pc.getValeurBoolean() != null) {
//                        newPoliceCaracteristique.setValeurBoolean(pc.getValeurBoolean());
//                    }
//                    if (pc.getValeurCode() != null) {
//                        newPoliceCaracteristique.setValeurCode(pc.getValeurCode());
//                    }
//                    if (pc.getValeurCaracteristique() != null) {
//                        pc.setValeurCaracteristique(pc.getValeurCaracteristique());
//                    }
//                    if (pc.getValeurTexte() != null) {
//                        newPoliceCaracteristique.setValeurTexte(pc.getValeurTexte());
//                    }
//                    if (pc.getValeurNumerique() != null && pc.getValeurNumerique() != null && pc.getValeurNumerique().intValue() != 0) {
//                        newPoliceCaracteristique.setValeurNumerique(pc.getValeurNumerique());
//                    }
//                    newPoliceCaracteristique.setIdCategories(police.getIdCategories());
//                    newPoliceCaracteristique.setAjouter(pc.getAjouter());
//                    newPoliceCaracteristique.setRetire_de_la_police(pc.getRetire_de_la_police());
//                    newPoliceCaracteristique.setCodeid_retirer(pc.getCodeid_retirer());
//                    newPoliceCaracteristique.setModifier(pc.getModifier());
//
//                    newPoliceCaracteristique.setIdAvenant(avenant);
                    em.merge(newPoliceCaracteristique);
                }

            }
            /*
                enregistrement des garenties polices
             */
            OrclassPoliceGarantie newPoliceGarantie = new OrclassPoliceGarantie();
            for (OrclassPoliceGarantie pg : policeGaranties) {
                if (pg.getIdGarantie() == null || pg.getIdGarantie().getId() == null) {
                    continue;
                }
                if (pg != null && pg.getId() != null && pg.getTypeAvenant() != null && pg.getTypeAvenant().getId() != null && Objects.equals(pg.getRetire_de_la_police(), Boolean.FALSE)) {
                    newPoliceGarantie = pg;
//                    newPoliceGarantie.setCapital(pg.getCapital());
//                    newPoliceGarantie.setIdEntreprise(entreprises);
//                    newPoliceGarantie.setIdGarantie(pg.getIdGarantie());
//                    newPoliceGarantie.setIdPolice(oldPolice);
//                    newPoliceGarantie.setPourcentage(pg.getPourcentage());
//                    newPoliceGarantie.setPrime(pg.getPrime());
//                    newPoliceGarantie.setProrata(pg.getProrata());
//                    newPoliceGarantie.setTaux(pg.getTaux());
//                    newPoliceGarantie.setModifier(Boolean.TRUE);
//                    newPoliceGarantie.setIdAvenant(avenant);
                    em.merge(newPoliceGarantie);
                } else if (pg != null && pg.getId() != null && pg.getTypeAvenant() != null && pg.getTypeAvenant().getId() != null && Objects.equals(pg.getRetire_de_la_police(), Boolean.TRUE)) {
                    newPoliceGarantie = new OrclassPoliceGarantie();
                    newPoliceGarantie.setCapital(pg.getCapital());
                    newPoliceGarantie.setIdEntreprise(entreprises);
                    newPoliceGarantie.setIdGarantie(pg.getIdGarantie());
                    newPoliceGarantie.setIdPolice(oldPolice);
                    newPoliceGarantie.setPourcentage(pg.getPourcentage());
                    newPoliceGarantie.setPrime(pg.getPrime());
                    newPoliceGarantie.setProrata(pg.getProrata());
                    newPoliceGarantie.setTaux(pg.getTaux());
                    newPoliceGarantie.setRetire_de_la_police(Boolean.TRUE);
                    newPoliceGarantie.setCodeid_retirer(pg.getCodeid_retirer());
                    newPoliceGarantie.setIdGroup(pg.getIdGroup());
                    newPoliceGarantie.setIdAvenant(avenant);
                    em.persist(newPoliceGarantie);
                } else if ((pg == null || pg.getId() == null) && pg.getTypeAvenant() != null && pg.getTypeAvenant().getId() != null) {
                    newPoliceGarantie = new OrclassPoliceGarantie();
                    newPoliceGarantie.setCapital(pg.getCapital());
                    newPoliceGarantie.setIdEntreprise(entreprises);
                    newPoliceGarantie.setIdGarantie(pg.getIdGarantie());
                    newPoliceGarantie.setIdPolice(oldPolice);
                    newPoliceGarantie.setPourcentage(pg.getPourcentage());
                    newPoliceGarantie.setPrime(pg.getPrime());
                    newPoliceGarantie.setProrata(pg.getProrata());
                    newPoliceGarantie.setTaux(pg.getTaux());
                    newPoliceGarantie.setAjouter(Boolean.TRUE);

                    newPoliceGarantie.setIdAvenant(avenant);
                    newPoliceGarantie.setIdGroup(pg.getIdGroup());
                    em.persist(newPoliceGarantie);
                } else if (pg != null && pg.getId() != null && pg.getIdAvenant() != null && pg.getIdAvenant().getId() != null) {
                    newPoliceGarantie = pg;
//                    newPoliceGarantie.setCapital(pg.getCapital());
//                    newPoliceGarantie.setIdEntreprise(entreprises);
//                    newPoliceGarantie.setIdGarantie(pg.getIdGarantie());
//                    newPoliceGarantie.setIdPolice(oldPolice);
//                    newPoliceGarantie.setPourcentage(pg.getPourcentage());
//                    newPoliceGarantie.setPrime(pg.getPrime());
//                    newPoliceGarantie.setProrata(pg.getProrata());
//                    newPoliceGarantie.setTaux(pg.getTaux());
//                    newPoliceGarantie.setAjouter(pg.getAjouter());
//                    newPoliceGarantie.setRetire_de_la_police(pg.getRetire_de_la_police());
//                    newPoliceGarantie.setCodeid_retirer(pg.getCodeid_retirer());
//                    newPoliceGarantie.setModifier(pg.getModifier());
//                    newPoliceGarantie.setIdAvenant(avenant);
                    em.merge(newPoliceGarantie);
                }

            }

            /*
                creation quittance
             */
            OrclassQuitance newQuittance = new OrclassQuitance();
            newQuittance.setAccessoirTaxe(quitance.getAccessoirTaxe());
            newQuittance.setDateCreation(new Date());
            newQuittance.setDateEmission(quitance.getDateEmission());

            newQuittance.setDate_saisie(quitance.getDate_saisie());

            newQuittance.setDate_echeance(quitance.getDate_echeance());
            newQuittance.setDate_effet(quitance.getDate_effet());
            newQuittance.setIdDevise(police.getIdDevise());
            newQuittance.setIdEntreprise(entreprises);
            newQuittance.setIdPolice(oldPolice);
            newQuittance.setIdTimbreDimension(quitance.getIdTimbreDimension());
            newQuittance.setTypQuittance(quitance.getTypQuittance());
            newQuittance.setMontantApport(quitance.getMontantApport());
            newQuittance.setMontantCommision(quitance.getMontantCommision());
            newQuittance.setMontantGestion(quitance.getMontantGestion());

            newQuittance.setMontant_Accessoire(quitance.getMontant_Accessoire());

            newQuittance.setPrimeNette(quitance.getPrimeNette());
            newQuittance.setPrimeTaxe(quitance.getPrimeTaxe());
            newQuittance.setTaxePrime(quitance.getTaxePrime());
            newQuittance.setSaisir_par(user.getNom() + " " + user.getPrenom());
            newQuittance.setTaxeAccessoir(quitance.getTaxeAccessoir());
            newQuittance.setTaxeCommision(quitance.getTotalCommision());
            newQuittance.setTimbreDimension(quitance.getTimbreDimension());
            newQuittance.setTimbreGradue(quitance.getTimbreGradue());
            newQuittance.setTotalCommision(quitance.getTotalCommision());
            newQuittance.setTotalTaxes(quitance.getTotalTaxes());
            newQuittance.setTotalTimb(quitance.getTotalTimb());
            newQuittance.setTotal_a_paye(quitance.getTotal_a_paye());
//            newQuittance.setTaxesAccessoires(quitance.getTaxesAccessoires());
            newQuittance.setTypQuittance(quitance.getTypQuittance());
            newQuittance.setTaux_apport(quitance.getTaux_apport());
            newQuittance.setTaux_gestion(quitance.getTaux_gestion());
            newQuittance.setIdAvenant(avenant);
            newQuittance.setValider_par(user.getNom() + " " + user.getPrenom());
            newQuittance.setDateEmission(quitance.getDateEmission());
            em.persist(newQuittance);
            /*
               commission prime apporteur
             */

            tx.commit();
            resultat = Boolean.TRUE;
        } catch (GlobalException | NotSupportedException | SystemException | RollbackException | HeuristicMixedException | HeuristicRollbackException | SecurityException ex) {
            try {
                resultat = Boolean.FALSE;
                tx.rollback();
                throw ex;
            } catch (Exception e) {

            }

        }
        resultat = Boolean.TRUE;
        return resultat;
    }

    @Override
    public Boolean addAvenantGroupMaladie(OrclassEntreprises e, OrclassAssure assure, OrclassPolice police, Orclass_TypeAvenant tpa, OrclassQuitance quitance, OrclassPolicePlafond policePlafond, List<OrclasseRefGroupe> listeRefGroup, OrclassUtilisateurs user) {
        this.setEntreprises(e);
        Boolean resultat = Boolean.FALSE;
        try {
            tx.begin();

            OrclassPolice oldPolice = policeDao.find(police.getId());
            OrclassAssure oldAssure = assureDao.find(assure.getId());
            OrclassAvenant avenant = new OrclassAvenant();
            if (oldPolice.getContrat() != police.getContrat()) {
                avenant.setContrat(police.getContrat());
            }
            if (oldPolice.getDate_echeance().compareTo(police.getDate_echeance()) != 0) {
                avenant.setDate_echeance(police.getDate_echeance());
            }
            if (oldPolice.getDate_effet().compareTo(police.getDate_effet()) != 0) {
                avenant.setDate_effet(police.getDate_effet());
            }

//            if (!oldPolice.getDesignationPlafonMaladie().equals(police.getDesignationPlafonMaladie())) {
//                avenant.setDesignationPlafonMaladie(police.getDesignationPlafonMaladie());
//            }
            if (oldPolice.getIdConvention() != null && (oldPolice.getIdConvention().getId().compareTo(police.getIdConvention().getId()) != 0)) {
                avenant.setIdConvention(police.getIdConvention());
            } else if (oldPolice.getIdConvention() == null) {
                if (police.getIdConvention() != null && police.getIdConvention().getId() != null) {
                    avenant.setIdConvention(police.getIdConvention());
                }

            }

            if (oldPolice.getIdExoneration() != null && oldPolice.getIdExoneration().getIdExoneration().compareTo(police.getIdExoneration().getIdExoneration()) != 0) {
                avenant.setIdExoneration(police.getIdExoneration());
            } else if (oldPolice.getIdExoneration() == null) {
                if (police.getIdExoneration() != null && police.getIdExoneration().getIdExoneration() != null) {
                    avenant.setIdExoneration(police.getIdExoneration());
                }
            }

            if (oldPolice.getIdFractionnementCategories() != null && oldPolice.getIdFractionnementCategories().getId().compareTo(police.getIdFractionnementCategories().getId()) != 0) {
                avenant.setIdFractionnementCategories(police.getIdFractionnementCategories());
            } else if (oldPolice.getIdFractionnementCategories() == null) {
                if (police.getIdFractionnementCategories() != null && police.getIdFractionnementCategories().getId() != null) {
                    avenant.setIdFractionnementCategories(police.getIdFractionnementCategories());
                }

            }
            if (oldPolice.getIdMajorationDuree() != null && (oldPolice.getIdMajorationDuree().getId().compareTo(police.getIdMajorationDuree().getId()) != 0)) {
                avenant.setIdMajorationDuree(police.getIdMajorationDuree());
            } else if (oldPolice.getIdMajorationDuree() == null) {
                if (police.getIdMajorationDuree() != null && police.getIdMajorationDuree().getId() != null) {
                    avenant.setIdMajorationDuree(police.getIdMajorationDuree());
                }

            }
            if (oldPolice.getIdReduction() != null && oldPolice.getIdReduction().getId().compareTo(police.getIdReduction().getId()) != 0) {
                avenant.setIdReduction(police.getIdReduction());
            } else if (oldPolice.getIdReduction() == null) {
                if (police.getIdReduction() != null && police.getIdReduction().getId() != null) {
                    avenant.setIdReduction(police.getIdReduction());
                }

            }
            if (oldPolice.getIdTimbre() != null && oldPolice.getIdTimbre().getId().compareTo(police.getIdTimbre().getId()) != 0) {
                avenant.setIdTimbre(police.getIdTimbre());
            }
            if (oldPolice.getIdTimbreDimension() != null && oldPolice.getIdTimbreDimension().getId().compareTo(police.getIdTimbreDimension().getId()) != 0) {
                avenant.setIdTimbreDimension(police.getIdTimbreDimension());
            } else if (oldPolice.getIdTimbre() == null) {
                if (police.getIdTimbreDimension() != null && police.getIdTimbreDimension().getId() != null) {
                    avenant.setIdTimbreDimension(police.getIdTimbreDimension());
                }

            }
            if (oldPolice.getIdTimbreDimension() != null && oldPolice.getIdTimbreDimension().getId().compareTo(police.getIdTimbreDimension().getId()) != 0) {
                avenant.setIdTimbreDimension(police.getIdTimbreDimension());
            } else if (oldPolice.getIdTimbreDimension() == null) {
                if (police.getIdTimbreDimension() != null && police.getIdTimbreDimension().getId() != null) {
                    avenant.setIdTimbreDimension(police.getIdTimbreDimension());
                }
            }
            if (oldPolice.getIdTypeTarif() != null && oldPolice.getIdTypeTarif().getId().compareTo(police.getIdTypeTarif().getId()) != 0) {
                avenant.setIdTypeTarif(police.getIdTypeTarif());
            }
            if (oldPolice.getMontantaccessoir() != null && oldPolice.getMontantaccessoir().compareTo(police.getMontantaccessoir()) != 0) {
                avenant.setMontantaccessoir(police.getMontantaccessoir());
            } else if (oldPolice.getMontantaccessoir() == BigDecimal.ZERO || oldPolice.getMontantaccessoir() == null) {
                if (police.getMontantaccessoir() != null && police.getMontantaccessoir() != BigDecimal.ZERO) {
                    avenant.setMontantaccessoir(police.getMontantaccessoir());
                }
            }
            if (oldPolice.getNatureContrat() != police.getNatureContrat()) {
                avenant.setNatureContrat(police.getNatureContrat());
            }
            if (oldPolice.getNombre_timbre() != null && (oldPolice.getNombre_timbre().compareTo(police.getNombre_timbre()) != 0)) {
                avenant.setNombre_timbre(police.getNombre_timbre());
            } else if (oldPolice.getNombre_timbre() == null) {
                if (police.getNombre_timbre() != null && police.getNombre_timbre() != BigInteger.ZERO) {
                    avenant.setNombre_timbre(police.getNombre_timbre());
                }

            }

//            if (oldPolice.getNombre_timbre().compareTo(police.getNombre_timbre()) !=0 ) {
//                avenant.setNombre_timbre(police.getNombre_timbre());
//            }
            if (oldPolice.getNumero_Borderau() != null && (oldPolice.getNumero_Borderau() != (police.getNumero_Borderau()))) {
                avenant.setNumero_Borderau(police.getNumero_Borderau());
            } else if (oldPolice.getNumero_Borderau() == null) {
                if (police.getNumero_Borderau() != null && police.getNumero_Borderau() != "") {
                    avenant.setNumero_Borderau(police.getNumero_Borderau());
                }
            }
            if (oldPolice.getRef_intermediaire() != null && (oldPolice.getRef_intermediaire() != (police.getRef_intermediaire()))) {
                avenant.setRef_intermediaire(police.getRef_intermediaire());
            } else if (oldPolice.getRef_intermediaire() == null) {
                if (police.getRef_intermediaire() != null && !"".equals(police.getRef_intermediaire())) {
                    avenant.setRef_intermediaire(police.getRef_intermediaire());
                }
            }

            if (oldPolice.getUniteDuree() != null && (oldPolice.getUniteDuree().compareTo(police.getUniteDuree()) != 0)) {
                avenant.setUniteDuree(police.getUniteDuree());
            }
            if (oldPolice.getValeurDuree() != null && (oldPolice.getValeurDuree().compareTo(police.getValeurDuree()) != 0)) {
                avenant.setValeurDuree(police.getValeurDuree());
            }
            if (oldPolice.getValeur_Devis() != null && oldPolice.getValeur_Devis().compareTo(police.getValeur_Devis()) != 0) {
                avenant.setValeur_Devis(police.getValeur_Devis());
            }
            if (oldPolice.getValeur_timbre() != null && (oldPolice.getValeur_timbre().compareTo(police.getValeur_timbre()) != 0)) {
                avenant.setValeur_timbre(police.getValeur_timbre());
            }
            // verifions au niveau du souscripteur
            if (oldAssure.getAdresse() != null) {

                if (oldAssure.getAdresse().getBp() != null && !oldAssure.getAdresse().getBp().equals(assure.getAdresse().getBp())) {
                    avenant.getAdresse().setBp(assure.getAdresse().getBp());
                }
                if (oldAssure.getAdresse().getEmail() != null && !oldAssure.getAdresse().getEmail().equals(assure.getAdresse().getEmail())) {
                    avenant.getAdresse().setEmail(assure.getAdresse().getEmail());
                }
                if (oldAssure.getAdresse().getTel() != null && !oldAssure.getAdresse().getTel().equals(assure.getAdresse().getTel())) {
                    avenant.getAdresse().setTel(assure.getAdresse().getTel());
                }
                if (oldAssure.getAdresse().getQuartier() != null && (!oldAssure.getAdresse().getQuartier().equals(assure.getAdresse().getQuartier()))) {
                    avenant.getAdresse().setQuartier(assure.getAdresse().getQuartier());
                }
                if (oldAssure.getAdresse().getVille() != null && (!oldAssure.getAdresse().getVille().equals(assure.getAdresse().getVille()))) {
                    avenant.getAdresse().setVille(assure.getAdresse().getVille());
                }

            }
            if (oldAssure.getDate_naissance() != null && (oldAssure.getDate_naissance().compareTo(assure.getDate_naissance()) != 0)) {
                avenant.setDate_naissance(assure.getDate_naissance());
            }
//            if (!oldAssure.getGsm().equals(assure.getGsm())) {
//                avenant.setGsm(assure.getGsm());
//            }
            if (oldAssure.getIdActivite() != null && (oldAssure.getIdActivite().getId().compareTo(assure.getIdActivite().getId()) != 0)) {
                avenant.setIdActivite(assure.getIdActivite());
            }
            if (oldAssure.getIdProfession() != null && (oldAssure.getIdProfession().getId().compareTo(assure.getIdProfession().getId()) != 0)) {
                avenant.setIdProfession(assure.getIdProfession());
            }

            if (oldAssure.getIdQualite() != null && (oldAssure.getIdQualite().getId().compareTo(assure.getIdQualite().getId()) != 0)) {
                avenant.setIdQualite(assure.getIdQualite());
            }
            if (oldAssure.getIdVille() != null && (oldAssure.getIdVille().getId().compareTo(assure.getIdVille().getId()) != 0)) {
                avenant.setIdVille(assure.getIdVille());
            }

            if (oldAssure.getLieu_naissance() != null && !oldAssure.getLieu_naissance().equals(assure.getLieu_naissance())) {
                avenant.setLieu_naissance(assure.getLieu_naissance());
            }

            if (oldAssure.getNom() != null && !oldAssure.getNom().equals(assure.getNom())) {
                avenant.setNom(assure.getNom());
            }
            if (oldAssure.getNum_cni() != null && !oldAssure.getNum_cni().equals(assure.getNum_cni())) {
                avenant.setNum_cni(assure.getNum_cni());
            }
            if (oldAssure.getNumero_piece() != null && !oldAssure.getNumero_piece().equals(assure.getNumero_piece())) {
                avenant.setNumero_piece(assure.getNumero_piece());
            }
            if (oldAssure.getPatente() != null && !oldAssure.getPatente().equals(assure.getPatente())) {
                avenant.setPatente(assure.getPatente());
            }
            if (oldAssure.getPrenom() != null && !oldAssure.getPrenom().equals(assure.getPrenom())) {
                avenant.setPrenom(assure.getPrenom());
            }
            if (oldAssure.getRaison_social() != null && !oldAssure.getRaison_social().equals(assure.getRaison_social())) {
                avenant.setRaison_social(assure.getRaison_social());
            }
            if (oldAssure.getRegistre_commercial() != null && !oldAssure.getRegistre_commercial().equals(assure.getRegistre_commercial())) {
                avenant.setRegistre_commercial(assure.getRegistre_commercial());
            }
            if (oldAssure.getSexe() != null && oldAssure.getSexe() != assure.getSexe()) {
                avenant.setSexe(assure.getSexe());
            }

            if (oldAssure.getTypePieces() != null && oldAssure.getTypePieces() != assure.getTypePieces()) {
                avenant.setTypePieces(assure.getTypePieces());
            }
            //
            BigInteger lastNumberForAvenant = avenantDao.lastNumeroAvenantByPolice(police, entreprises);
            if (lastNumberForAvenant == BigInteger.ZERO) {
                lastNumberForAvenant = lastNumberForAvenant.add(BigInteger.ONE);

            } else {
                lastNumberForAvenant = lastNumberForAvenant.add(BigInteger.ONE);
            }
            avenant.setNumero_avenant(lastNumberForAvenant);
            avenant.setIdTypeAvenant(tpa);
            avenant.setDateCreation(new Date());
            avenant.setIdUtilisateur(user);
            avenant.setIdEntreprises(entreprises);
            avenant.setIdPolice(oldPolice);
            em.persist(avenant);
            OrclasseRefGroupe groupe;
            HashMap<Long, List[]> mapForObjetGroupe = new HashMap<Long, List[]>();
            List arrays[] = new List[5];
            OrclassRisque newrisque = null;
            OrclassRisque r = null;
            OrclassRisqueFamille risqueFamille = null;
            OrclassRisqueFamille rf = null;
            List<OrclassRisque> listeRisque = new ArrayList<>();
            List<OrclassRisqueFamille> famille = new ArrayList<>();
            OrclassDetailPolicePlafond newDetailPolicePlafond;
            List<OrclassDetailPolicePlafond> detailPolicePlafonds = new ArrayList<>();
            List<OrclassPoliceCaracteristique> policeCaracteristiques = new ArrayList<>();
            List<OrclassPoliceGarantie> policeGaranties = new ArrayList<>();

            OrclassPoliceCaracteristique newPoliceCaracteristique;
            OrclassPoliceGarantie newPoliceGarantie = new OrclassPoliceGarantie();

            for (int i = 0; i < listeRefGroup.size(); i++) {
                groupe = listeRefGroup.get(i);
//                mapForObjetGroupe = groupe.getMapForObjetGroupe();

//                for (Map.Entry<Long, List[]> entry : groupe.getMapForObjetGroupe().entrySet()) {
//                    if (Boolean.FALSE == entry.getKey().equals(groupe.getId())) {
//                        continue;
//                    }
//                    arrays = entry.getValue();
                if (groupe.getIndice_tab2() == -1) {
                    continue;
                }
                listeRisque = new ArrayList<>(this.arrays_Tab2[groupe.getIndice_tab2()][0]);
//                    famille = new ArrayList<>(arrays[1]);
                detailPolicePlafonds = new ArrayList<>(this.arrays_Tab2[groupe.getIndice_tab2()][2]);
                policeCaracteristiques = new ArrayList<>(this.arrays_Tab2[groupe.getIndice_tab2()][3]);
                policeGaranties = new ArrayList<>(this.arrays_Tab2[groupe.getIndice_tab2()][4]);

                //risque
                for (OrclassRisque riq : listeRisque) {
                    if ("".equals(riq.getLibelle()) || riq.getLibelle() == null) {
                        continue;

                    }
                    if (riq.getId() != null && Objects.equals(riq.getAjouter(), Boolean.TRUE) && (riq.getRetire_de_la_police() == null || Objects.equals(riq.getRetire_de_la_police(), Boolean.FALSE)) && (riq.getModifier() == null || Objects.equals(riq.getModifier(), Boolean.FALSE))) {
                        if (!riq.getListeRisqueFamille().isEmpty()) {
                            famille.clear();
                            famille = riq.getListeRisqueFamille();
                            for (OrclassRisqueFamille rfs : famille) {
                                if (rfs.getId() != null && Objects.equals(rfs.getAjouter(), Boolean.TRUE) && (rfs.getRetire_de_la_police() == null || Objects.equals(rfs.getRetire_de_la_police(), Boolean.FALSE)) && (rfs.getModifier() == null || Objects.equals(rfs.getModifier(), Boolean.FALSE))) {
                                    continue;
                                }
                                rf = rfs;
//                                if (newrisque == null || newrisque.getId() == null) {
                                    newrisque = rfs.getIdRisque();
//
//                                }
                                if (Objects.equals(rf.getModifier(), Boolean.TRUE)) {
                                    risqueFamille = rf;

                                    risqueFamille.setIdVille(assure.getIdVille());

                                    em.merge(risqueFamille);
                                } else if (Objects.equals(rf.getAjouter(), Boolean.TRUE)) {

                                    risqueFamille = new OrclassRisqueFamille();
                                    risqueFamille.setDateEntree(rf.getDateEntree());
                                    risqueFamille.setDateNaissance(rf.getDateNaissance());
                                    risqueFamille.setIdEntreprise(entreprises);
                                    risqueFamille.setIdPolice(oldPolice);
                                    risqueFamille.setIdRisque(newrisque);
                                    risqueFamille.setIdVille(assure.getIdVille());
                                    risqueFamille.setLienParente(rf.getLienParente());
                                    risqueFamille.setNom_membre(rf.getNom_membre());
                                    risqueFamille.setIdAvenant(avenant);
                                    risqueFamille.setAjouter(Boolean.TRUE);

                                    risqueFamille.setSexe(rf.getSexe());
                                    em.persist(risqueFamille);
                                } else if (Objects.equals(rf.getRetire_de_la_police(), Boolean.TRUE)) {

                                    risqueFamille = new OrclassRisqueFamille();
                                    risqueFamille.setDateEntree(rf.getDateEntree());
                                    risqueFamille.setDateNaissance(rf.getDateNaissance());
                                    risqueFamille.setIdEntreprise(entreprises);
                                    risqueFamille.setIdPolice(oldPolice);
                                    risqueFamille.setIdRisque(newrisque);
                                    risqueFamille.setIdVille(assure.getIdVille());
                                    risqueFamille.setLienParente(rf.getLienParente());
                                    risqueFamille.setNom_membre(rf.getNom_membre());
                                    risqueFamille.setIdAvenant(avenant);
                                    risqueFamille.setRetire_de_la_police(Boolean.TRUE);
                                    risqueFamille.setCodeid_retirer(rf.getId());
                                    risqueFamille.setSexe(rf.getSexe());
                                    em.persist(risqueFamille);
                                }

                            }
                        }
                        continue;
                    }
                    r = riq;
                    famille.clear();
                    if (riq.getListeRisqueFamille() != null && !riq.getListeRisqueFamille().isEmpty()) {
                        famille = riq.getListeRisqueFamille();
                      
                    }
                    if (Objects.equals(r.getAjouter(), Boolean.TRUE)) {
                        newrisque = new OrclassRisque();
                        newrisque.setDateCreation(new Date());
                        newrisque.setMatricule(r.getMatricule());
                        newrisque.setDateEntree(r.getDateEntree());
                        newrisque.setDateNaissance(r.getDateNaissance());
                        newrisque.setIdEntreprise(entreprises);
                        newrisque.setIdPolice(oldPolice);
                        newrisque.setLibelle(r.getLibelle());
                        newrisque.setSexe(r.getSexe());
                        newrisque.setIdGroup(r.getIdGroup());
                        newrisque.setIdVille(assure.getIdVille());
                        newrisque.setAjouter(Boolean.TRUE);
                        newrisque.setIdAvenant(avenant);
                        newrisque.setSaisir_par(user.getNom() + " " + user.getPrenom());
                        em.persist(newrisque);
                    } else if (Objects.equals(r.getRetire_de_la_police(), Boolean.TRUE)) {
                        newrisque = new OrclassRisque();
                        newrisque.setDateCreation(new Date());
                        newrisque.setMatricule(r.getMatricule());
                        newrisque.setDateEntree(r.getDateEntree());
                        newrisque.setDateNaissance(r.getDateNaissance());
                        newrisque.setIdEntreprise(entreprises);
                        newrisque.setIdPolice(oldPolice);
                        newrisque.setLibelle(r.getLibelle());
                        newrisque.setSexe(r.getSexe());
                        newrisque.setIdGroup(r.getIdGroup());
                        newrisque.setIdVille(assure.getIdVille());
                        newrisque.setRetire_de_la_police(Boolean.TRUE);
                        newrisque.setIdAvenant(avenant);
                        newrisque.setCodeid_retirer(r.getId());
                        newrisque.setSaisir_par(user.getNom() + " " + user.getPrenom());
                        em.persist(newrisque);
                    } else if (Objects.equals(r.getModifier(), Boolean.TRUE)) {
                        r.setIdVille(assure.getIdVille());
                        em.merge(r);
                    }
                    for (OrclassRisqueFamille rfs : famille) {
                        if (rfs.getId() != null && Objects.equals(rfs.getAjouter(), Boolean.TRUE) && (rfs.getRetire_de_la_police() == null || Objects.equals(rfs.getRetire_de_la_police(), Boolean.FALSE)) && (rfs.getModifier() == null || Objects.equals(rfs.getModifier(), Boolean.FALSE))) {
                            continue;
                        }
                        rf = rfs;
                        if (newrisque == null || newrisque.getId() == null) {
                            newrisque = rfs.getIdRisque();

                        }
                        if (Objects.equals(rf.getModifier(), Boolean.TRUE)) {
                            risqueFamille = rf;

                            risqueFamille.setIdVille(assure.getIdVille());

                            em.merge(risqueFamille);
                        } else if (Objects.equals(rf.getAjouter(), Boolean.TRUE)) {

                            risqueFamille = new OrclassRisqueFamille();
                            risqueFamille.setDateEntree(rf.getDateEntree());
                            risqueFamille.setDateNaissance(rf.getDateNaissance());
                            risqueFamille.setIdEntreprise(entreprises);
                            risqueFamille.setIdPolice(oldPolice);
                            risqueFamille.setIdRisque(newrisque);
                            risqueFamille.setIdVille(assure.getIdVille());
                            risqueFamille.setLienParente(rf.getLienParente());
                            risqueFamille.setNom_membre(rf.getNom_membre());
                            risqueFamille.setIdAvenant(avenant);
                            risqueFamille.setAjouter(Boolean.TRUE);

                            risqueFamille.setSexe(rf.getSexe());
                            em.persist(risqueFamille);
                        } else if (Objects.equals(rf.getRetire_de_la_police(), Boolean.TRUE)) {

                            risqueFamille = new OrclassRisqueFamille();
                            risqueFamille.setDateEntree(rf.getDateEntree());
                            risqueFamille.setDateNaissance(rf.getDateNaissance());
                            risqueFamille.setIdEntreprise(entreprises);
                            risqueFamille.setIdPolice(oldPolice);
                            risqueFamille.setIdRisque(newrisque);
                            risqueFamille.setIdVille(assure.getIdVille());
                            risqueFamille.setLienParente(rf.getLienParente());
                            risqueFamille.setNom_membre(rf.getNom_membre());
                            risqueFamille.setIdAvenant(avenant);
                            risqueFamille.setRetire_de_la_police(Boolean.TRUE);
                            risqueFamille.setCodeid_retirer(rf.getId());
                            risqueFamille.setSexe(rf.getSexe());
                            em.persist(risqueFamille);
                        }

                    }
                    newrisque=new OrclassRisque();
                }

//                }

                /*
                enregistrement police plafond
                 */
                OrclassPolicePlafond newPlafondMaladie = null;
                if (groupe.getPolicePlafond() != null && groupe.getPolicePlafond().getIdPlafondMaladie() != null) {
                    newPlafondMaladie = new OrclassPolicePlafond();
                    newPlafondMaladie.setIdCategories(oldPolice.getIdCategories());
                    newPlafondMaladie.setIdPlafondMaladie(policePlafond.getIdPlafondMaladie());
                    newPlafondMaladie.setIdPolice(oldPolice);
                    newPlafondMaladie.setIdGroup(groupe);
                    newPlafondMaladie.setIdEntreprise(entreprises);
                    newPlafondMaladie.setAjouter(Boolean.TRUE);
                    newPlafondMaladie.setIdAvenant(avenant);
                    em.persist(newPlafondMaladie);
                }

//            newPlafondMaladie=policePlafondDao.chargePolicePlafonMaladie(police, entreprises)
//                if ((policePlafond == null || policePlafond.getId() == null) && policePlafond.getTypeAvenant() != null && policePlafond.getId() != null) {
//                    newPlafondMaladie = new OrclassPolicePlafond();
//                    newPlafondMaladie.setIdCategories(oldPolice.getIdCategories());
//                    newPlafondMaladie.setIdPlafondMaladie(policePlafond.getIdPlafondMaladie());
//                    newPlafondMaladie.setIdPolice(oldPolice);
//                    newPlafondMaladie.setIdGroup(policePlafond.getIdGroup());
//                    newPlafondMaladie.setIdEntreprise(entreprises);
//                    newPlafondMaladie.setAjouter(Boolean.TRUE);
//                    newPlafondMaladie.setIdAvenant(avenant);
//
//                    em.persist(newPlafondMaladie);
//                }
                /*
                enregistrement detail police plafond
                 */
                for (OrclassDetailPolicePlafond dppf : detailPolicePlafonds) {
                    if (dppf.getId() != null && Objects.equals(dppf.getAjouter(), Boolean.TRUE) && (dppf.getRetire_de_la_police() == null || Objects.equals(dppf.getRetire_de_la_police(), Boolean.FALSE)) && (dppf.getModifier() == null || Objects.equals(dppf.getModifier(), Boolean.FALSE))) {
                        continue;
                    }
                    if (dppf.getIdPrestation() == null || dppf.getIdPrestation().getId() == null) {
                        continue;
                    }
                    if (dppf.getId() != null && Objects.equals(dppf.getAjouter(), Boolean.TRUE)) {
                        continue;
                    }
//                    if (dppf.getIdPrestation() != null && dppf.getIdPrestation().getId() != null && dppf.getTypeAvenant()==null) {
//                        continue;
//                    }
                    if (Objects.equals(dppf.getModifier(), Boolean.TRUE)) {
                        newDetailPolicePlafond = dppf;

                        em.merge(newDetailPolicePlafond);
                    } else if (Objects.equals(dppf.getRetire_de_la_police(), Boolean.TRUE) && (dppf.getModifier() == null || dppf.getModifier() == Boolean.FALSE) && (dppf.getAjouter() == null || dppf.getAjouter() == Boolean.FALSE)) {
                        newDetailPolicePlafond = new OrclassDetailPolicePlafond();
                        newDetailPolicePlafond.setIdEntreprise(entreprises);
                        newDetailPolicePlafond.setBarem(dppf.getBarem());
                        newDetailPolicePlafond.setCode_ss(dppf.getCode_ss());
                        newDetailPolicePlafond.setForfait(dppf.getForfait());
                        newDetailPolicePlafond.setIdPolicePlafond(dppf.getIdPolicePlafond());
                        newDetailPolicePlafond.setIdPrestation(dppf.getIdPrestation());
                        newDetailPolicePlafond.setIdRubrique(dppf.getIdRubrique());
                        newDetailPolicePlafond.setModeCalculDetailMaladie(dppf.getModeCalculDetailMaladie());
                        newDetailPolicePlafond.setPlafond(dppf.getPlafond());
                        newDetailPolicePlafond.setTaux(dppf.getTaux());
                        newDetailPolicePlafond.setTypeDetailMaladie(dppf.getTypeDetailMaladie());
                        newDetailPolicePlafond.setRetire_de_la_police(Boolean.TRUE);
                        newDetailPolicePlafond.setCodeid_retirer(dppf.getId());
                        newDetailPolicePlafond.setIdGroup(dppf.getIdGroup());
                        newDetailPolicePlafond.setIdAvenant(avenant);

                        em.persist(newDetailPolicePlafond);
                    } else if (Objects.equals(dppf.getAjouter(), Boolean.TRUE) && (dppf.getModifier() == null || dppf.getModifier() == Boolean.FALSE) && (dppf.getRetire_de_la_police() == null || dppf.getRetire_de_la_police() == Boolean.FALSE)) {
                        newDetailPolicePlafond = new OrclassDetailPolicePlafond();
                        newDetailPolicePlafond.setIdEntreprise(entreprises);
                        newDetailPolicePlafond.setBarem(dppf.getBarem());
                        newDetailPolicePlafond.setCode_ss(dppf.getCode_ss());
                        newDetailPolicePlafond.setForfait(dppf.getForfait());
                        if (newPlafondMaladie != null && newDetailPolicePlafond.getId() != null) {
                            newDetailPolicePlafond.setIdPolicePlafond(newPlafondMaladie);
                        } else if (dppf.getIdPolicePlafond() != null && dppf.getIdPolicePlafond().getId() != null) {
                            newDetailPolicePlafond.setIdPolicePlafond(dppf.getIdPolicePlafond());
                        } else {
                            newDetailPolicePlafond.setIdPolicePlafond(policePlafondDao.chargePolicePlafonMaladie(oldPolice, entreprises));
                        }

                        newDetailPolicePlafond.setIdPrestation(dppf.getIdPrestation());
                        newDetailPolicePlafond.setIdRubrique(dppf.getIdRubrique());
                        newDetailPolicePlafond.setModeCalculDetailMaladie(dppf.getModeCalculDetailMaladie());
                        newDetailPolicePlafond.setPlafond(dppf.getPlafond());
                        newDetailPolicePlafond.setTaux(dppf.getTaux());
                        newDetailPolicePlafond.setTypeDetailMaladie(dppf.getTypeDetailMaladie());
                        newDetailPolicePlafond.setAjouter(Boolean.TRUE);
                        newDetailPolicePlafond.setIdAvenant(avenant);
                        newDetailPolicePlafond.setIdGroup(dppf.getIdGroup());
                        em.persist(newDetailPolicePlafond);

                    } else if (Objects.equals(dppf.getModifier(), Boolean.TRUE) && (dppf.getAjouter() == null || Objects.equals(dppf.getAjouter(), Boolean.FALSE)) && (dppf.getRetire_de_la_police() == null || Objects.equals(dppf.getRetire_de_la_police(), Boolean.FALSE))) {
                        newDetailPolicePlafond = dppf;

                        em.merge(newDetailPolicePlafond);
                    }

                }

                for (OrclassPoliceCaracteristique pc : policeCaracteristiques) {
                    if (pc.getId() != null && Objects.equals(pc.getAjouter(), Boolean.TRUE) && (pc.getRetire_de_la_police() == null || Objects.equals(pc.getRetire_de_la_police(), Boolean.FALSE)) && (pc.getModifier() == null || Objects.equals(pc.getModifier(), Boolean.FALSE))) {
                        continue;
                    }
                    if (pc.getIdCaracteristiques() == null || pc.getIdCaracteristiques().getId() == null) {
                        continue;
                    }
                    if (pc.getId() != null && Objects.equals(pc.getAjouter(), Boolean.TRUE)) {
                        continue;
                    }
                    if (Objects.equals(pc.getModifier(), Boolean.TRUE) && (pc.getAjouter() == null || Objects.equals(pc.getAjouter(), Boolean.FALSE)) && (pc.getRetire_de_la_police() == null || Objects.equals(pc.getRetire_de_la_police(), Boolean.FALSE))) {
                        if (pc.getValeurBoolean() == null && pc.getDateValeur() == null && pc.getValeurCaracteristique() == null && pc.getValeurCode() == null && (pc.getValeurNumerique() == null || pc.getValeurNumerique().intValue() == 0) && pc.getValeurTexte() == null) {
                            continue;
                        }
                        newPoliceCaracteristique = pc;

                        newPoliceCaracteristique.setModifier(Boolean.TRUE);

                        em.merge(newPoliceCaracteristique);
                    } else if (Objects.equals(pc.getRetire_de_la_police(), Boolean.TRUE) && (pc.getModifier() == null || pc.getModifier() == Boolean.FALSE) && (pc.getAjouter() == null || pc.getAjouter() == Boolean.FALSE)) {
                        if (pc.getValeurBoolean() == null && pc.getDateValeur() == null && pc.getValeurCaracteristique() == null && pc.getValeurCode() == null && (pc.getValeurNumerique() == null || pc.getValeurNumerique().intValue() == 0) && pc.getValeurTexte() == null) {
                            continue;
                        }
                        newPoliceCaracteristique = new OrclassPoliceCaracteristique();

                        newPoliceCaracteristique.setIdCaracteristiques(pc.getIdCaracteristiques());
                        newPoliceCaracteristique.setIdPolice(oldPolice);
                        newPoliceCaracteristique.setIdEntreprise(entreprises);
                        if (pc.getDateValeur() != null) {
                            newPoliceCaracteristique.setDateValeur(pc.getDateValeur());
                        }
                        if (pc.getValeurBoolean() != null) {
                            newPoliceCaracteristique.setValeurBoolean(pc.getValeurBoolean());
                        }
                        if (pc.getValeurCode() != null) {
                            newPoliceCaracteristique.setValeurCode(pc.getValeurCode());
                        }
                        if (pc.getValeurCaracteristique() != null) {
                            pc.setValeurCaracteristique(pc.getValeurCaracteristique());
                        }
                        if (pc.getValeurTexte() != null) {
                            newPoliceCaracteristique.setValeurTexte(pc.getValeurTexte());
                        }
                        if (pc.getValeurNumerique() != null && pc.getValeurNumerique() != null && pc.getValeurNumerique().intValue() != 0) {
                            newPoliceCaracteristique.setValeurNumerique(pc.getValeurNumerique());
                        }
                        newPoliceCaracteristique.setIdCategories(police.getIdCategories());
                        newPoliceCaracteristique.setRetire_de_la_police(Boolean.TRUE);
                        newPoliceCaracteristique.setCodeid_retirer(pc.getId());
                        newPoliceCaracteristique.setIdAvenant(avenant);
                        newPoliceCaracteristique.setIdGroup(pc.getIdGroup());
                        em.persist(newPoliceCaracteristique);

                    } else if (Objects.equals(pc.getAjouter(), Boolean.TRUE) && (pc.getModifier() == null || Objects.equals(pc.getModifier(), Boolean.FALSE)) && (pc.getRetire_de_la_police() == null || Objects.equals(pc.getRetire_de_la_police(), Boolean.FALSE))) {

                        if (pc.getValeurBoolean() == null && pc.getDateValeur() == null && pc.getValeurCaracteristique() == null && pc.getValeurCode() == null && (pc.getValeurNumerique() == null || pc.getValeurNumerique().intValue() == 0) && pc.getValeurTexte() == null) {
                            continue;
                        }
                        newPoliceCaracteristique = new OrclassPoliceCaracteristique();

                        newPoliceCaracteristique.setIdCaracteristiques(pc.getIdCaracteristiques());
                        newPoliceCaracteristique.setIdPolice(oldPolice);
                        newPoliceCaracteristique.setIdEntreprise(entreprises);
                        if (pc.getDateValeur() != null) {
                            newPoliceCaracteristique.setDateValeur(pc.getDateValeur());
                        }
                        if (pc.getValeurBoolean() != null) {
                            newPoliceCaracteristique.setValeurBoolean(pc.getValeurBoolean());
                        }
                        if (pc.getValeurCode() != null) {
                            newPoliceCaracteristique.setValeurCode(pc.getValeurCode());
                        }
                        if (pc.getValeurCaracteristique() != null) {
                            pc.setValeurCaracteristique(pc.getValeurCaracteristique());
                        }
                        if (pc.getValeurTexte() != null) {
                            newPoliceCaracteristique.setValeurTexte(pc.getValeurTexte());
                        }
                        if (pc.getValeurNumerique() != null && pc.getValeurNumerique() != null && pc.getValeurNumerique().intValue() != 0) {
                            newPoliceCaracteristique.setValeurNumerique(pc.getValeurNumerique());
                        }
                        newPoliceCaracteristique.setIdCategories(police.getIdCategories());
                        newPoliceCaracteristique.setAjouter(Boolean.TRUE);

                        newPoliceCaracteristique.setIdAvenant(avenant);
                        newPoliceCaracteristique.setIdGroup(pc.getIdGroup());
                        em.persist(newPoliceCaracteristique);
                    }
//                    else if (pc != null && pc.getId() != null && pc.getIdAvenant() != null && pc.getIdAvenant().getId() != null) {
//                        if (pc.getValeurBoolean() == null && pc.getDateValeur() == null && pc.getValeurCaracteristique() == null && pc.getValeurCode() == null && (pc.getValeurNumerique() == null || pc.getValeurNumerique().intValue() == 0) && pc.getValeurTexte() == null) {
//                            continue;
//                        }
//                        newPoliceCaracteristique = pc;
//
//                        em.merge(newPoliceCaracteristique);
//                    }

                }
                /*
                enregistrement des garenties polices
                 */

                for (OrclassPoliceGarantie pg : policeGaranties) {

                    if (pg.getId() != null && Objects.equals(pg.getAjouter(), Boolean.TRUE) && (pg.getRetire_de_la_police() == null || Objects.equals(pg.getRetire_de_la_police(), Boolean.FALSE)) && (pg.getModifier() == null || Objects.equals(pg.getModifier(), Boolean.FALSE))) {
                        continue;
                    }
                    if (pg.getIdGarantie() == null || pg.getIdGarantie().getId() == null) {
                        continue;
                    }
                    if (pg.getId() != null && Objects.equals(pg.getAjouter(), Boolean.TRUE)) {
                        continue;
                    }
                    if ((Objects.equals(pg.getAjouter(), Boolean.FALSE || pg.getAjouter() == null)) && (Objects.equals(pg.getModifier(), Boolean.TRUE)) && Objects.equals(pg.getRetire_de_la_police(), Boolean.FALSE)) {
                        newPoliceGarantie = pg;

                        em.merge(newPoliceGarantie);
                    } else if ((Objects.equals(pg.getAjouter(), Boolean.FALSE || pg.getAjouter() == null)) && (pg.getModifier() == null || Objects.equals(pg.getModifier(), Boolean.FALSE)) && Objects.equals(pg.getRetire_de_la_police(), Boolean.TRUE)) {
                        newPoliceGarantie = new OrclassPoliceGarantie();
                        newPoliceGarantie.setCapital(pg.getCapital());
                        newPoliceGarantie.setIdEntreprise(entreprises);
                        newPoliceGarantie.setIdGarantie(pg.getIdGarantie());
                        newPoliceGarantie.setIdPolice(oldPolice);
                        newPoliceGarantie.setPourcentage(pg.getPourcentage());
                        newPoliceGarantie.setPrime(pg.getPrime());
                        newPoliceGarantie.setProrata(pg.getProrata());
                        newPoliceGarantie.setTaux(pg.getTaux());
                        newPoliceGarantie.setRetire_de_la_police(Boolean.TRUE);
                        newPoliceGarantie.setCodeid_retirer(pg.getCodeid_retirer());
                        newPoliceGarantie.setIdGroup(pg.getIdGroup());
                        newPoliceGarantie.setIdAvenant(avenant);
                        em.persist(newPoliceGarantie);
                    } else if (Objects.equals(pg.getAjouter(), Boolean.TRUE) && (pg.getModifier() == null || Objects.equals(pg.getModifier(), Boolean.FALSE)) && (pg.getRetire_de_la_police() == null || Objects.equals(pg.getRetire_de_la_police(), Boolean.FALSE))) {
                        newPoliceGarantie = new OrclassPoliceGarantie();
                        newPoliceGarantie.setCapital(pg.getCapital());
                        newPoliceGarantie.setIdEntreprise(entreprises);
                        newPoliceGarantie.setIdGarantie(pg.getIdGarantie());
                        newPoliceGarantie.setIdPolice(oldPolice);
                        newPoliceGarantie.setPourcentage(pg.getPourcentage());
                        newPoliceGarantie.setPrime(pg.getPrime());
                        newPoliceGarantie.setProrata(pg.getProrata());
                        newPoliceGarantie.setTaux(pg.getTaux());
                        newPoliceGarantie.setAjouter(Boolean.TRUE);

                        newPoliceGarantie.setIdAvenant(avenant);
                        newPoliceGarantie.setIdGroup(pg.getIdGroup());
                        em.persist(newPoliceGarantie);
                    }
//                    else if (pg != null && pg.getId() != null && pg.getIdAvenant() != null && pg.getIdAvenant().getId() != null) {
//                        newPoliceGarantie = pg;
//
//                        em.merge(newPoliceGarantie);
//                    }

                }

//                //police groupe
//                OrclassGroupePolice groupePolice=null;
//                if (groupePoliceDao.finKey(e, police, groupe)==null) {
//                    groupePolice=new OrclassGroupePolice();
//                    groupePolice.setIdRefGroupe(groupe);
//                    groupePolice.setIdAvenant(avenant);
//                    groupePolice.setIdPolice(oldPolice);
//                    groupePolice.setAdresseGroup(groupe.getAdresseGroup());
//                    groupePolice.setIdEntreprise(entreprises);
//                    groupePolice.setObservation(groupe.getObservation());
//                    groupePolice.setIdVille(groupe.getVille()==null ? assure.getIdVille():groupe.getVille());
//                    groupePolice.setSaisir_par(user.getNom()+" "+user.getPrenom());
//                    em.persist(groupePolice);
//                }
            }

            /*
                creation quittance
             */
            OrclassQuitance newQuittance = new OrclassQuitance();
            newQuittance.setAccessoirTaxe(quitance.getAccessoirTaxe());
            newQuittance.setDateCreation(new Date());
            newQuittance.setDateEmission(quitance.getDateEmission());

            newQuittance.setDate_saisie(quitance.getDate_saisie());

            newQuittance.setDate_echeance(quitance.getDate_echeance());
            newQuittance.setDate_effet(quitance.getDate_effet());
            newQuittance.setIdDevise(police.getIdDevise());
            newQuittance.setIdEntreprise(entreprises);
            newQuittance.setIdPolice(oldPolice);
            newQuittance.setIdTimbreDimension(quitance.getIdTimbreDimension());
            newQuittance.setTypQuittance(quitance.getTypQuittance());
            newQuittance.setMontantApport(quitance.getMontantApport());
            newQuittance.setMontantCommision(quitance.getMontantCommision());
            newQuittance.setMontantGestion(quitance.getMontantGestion());

            newQuittance.setMontant_Accessoire(quitance.getMontant_Accessoire());

            newQuittance.setPrimeNette(quitance.getPrimeNette());
            newQuittance.setPrimeTaxe(quitance.getPrimeTaxe());
            newQuittance.setTaxePrime(quitance.getTaxePrime());
            newQuittance.setSaisir_par(user.getNom() + " " + user.getPrenom());
            newQuittance.setTaxeAccessoir(quitance.getTaxeAccessoir());
            newQuittance.setTaxeCommision(quitance.getTotalCommision());
            newQuittance.setTimbreDimension(quitance.getTimbreDimension());
            newQuittance.setTimbreGradue(quitance.getTimbreGradue());
            newQuittance.setTotalCommision(quitance.getTotalCommision());
            newQuittance.setTotalTaxes(quitance.getTotalTaxes());
            newQuittance.setTotalTimb(quitance.getTotalTimb());
            newQuittance.setTotal_a_paye(quitance.getTotal_a_paye());
//            newQuittance.setTaxesAccessoires(quitance.getTaxesAccessoires());
            newQuittance.setTypQuittance(quitance.getTypQuittance());
            newQuittance.setTaux_apport(quitance.getTaux_apport());
            newQuittance.setTaux_gestion(quitance.getTaux_gestion());
            newQuittance.setIdAvenant(avenant);
            newQuittance.setValider_par(user.getNom() + " " + user.getPrenom());
            newQuittance.setDateEmission(quitance.getDateEmission());
            em.persist(newQuittance);
            /*
               commission prime apporteur
             */

            tx.commit();
            resultat = Boolean.TRUE;
        } catch (GlobalException | NotSupportedException | SystemException | RollbackException | HeuristicMixedException | HeuristicRollbackException | SecurityException ex) {
            try {
                resultat = Boolean.FALSE;
                tx.rollback();
                throw ex;
            } catch (Exception e2) {

            }

        }
        resultat = Boolean.TRUE;
        return resultat;

    }

    @Override
    public void chargeElementsTab(List[][] lists) {
        this.arrays_Tab2 = lists;
    }

}
