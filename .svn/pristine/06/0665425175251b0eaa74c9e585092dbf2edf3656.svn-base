/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sante;

import exception.GlobalException;
import java.util.List;
import modele.OrclassAvenant;
import modele.OrclassCaracteristiques;
import modele.OrclassEntreprises;
import modele.OrclassEvenement;
import modele.OrclassGarantie;
import modele.OrclassGroupePolice;
import modele.OrclassIntervenant;
import modele.OrclassMedicamentSinistreMaladie;
import modele.OrclassNatureMaladie;
import modele.OrclassPolice;
import modele.OrclassPrestataire;
import modele.OrclassRefNatureMaladie;
import modele.OrclassRisque;
import modele.OrclassRisqueFamille;
import modele.OrclassRubrique;
import modele.OrclassSinistre;
import modele.OrclassSinistreMaladie;
import modele.OrclassUtilisateurs;
import modele.orclassRefPrestataire;

/**
 *
 * @author JIATOU FRANCK
 */
public interface ISinistre {

    public String creationPrestataire(OrclassEntreprises e, orclassRefPrestataire ref, OrclassPrestataire p);

    public String creationNatureMaladie(OrclassEntreprises e, OrclassRefNatureMaladie ref, OrclassNatureMaladie p);
    public Boolean createSinistreMaladie(OrclassEntreprises e,OrclassPolice p,OrclassAvenant avenant,OrclassSinistre sinistre,OrclassRisque risque,OrclassRisqueFamille risqueFamille,OrclassPrestataire prestataire,OrclassNatureMaladie natureMaladie, OrclassRubrique rubrique
    ,OrclassGarantie garantie,OrclassGroupePolice gp,List<OrclassSinistreMaladie> listeSinistreMaladie,List<OrclassMedicamentSinistreMaladie> listesMedicamentSinistreMaladie,List<OrclassIntervenant> listesIntervenant,List<OrclassEvenement> listesEvenement,List<OrclassCaracteristiques> listesCaracteristiques,Boolean valide_pec,OrclassUtilisateurs user)
            throws GlobalException;
     public Boolean updateSinistreMaladie(OrclassEntreprises e,OrclassPolice p,OrclassAvenant avenant,OrclassSinistre sinistre,OrclassRisque risque,OrclassRisqueFamille risqueFamille,OrclassPrestataire prestataire,OrclassNatureMaladie natureMaladie, OrclassRubrique rubrique
    ,OrclassGarantie garantie,OrclassGroupePolice gp,List<OrclassSinistreMaladie> listeSinistreMaladie,List<OrclassMedicamentSinistreMaladie> listesMedicamentSinistreMaladie,List<OrclassIntervenant> listesIntervenant,List<OrclassEvenement> listesEvenement,List<OrclassCaracteristiques> listesCaracteristiques,Boolean valide_pec,OrclassUtilisateurs user)
            throws GlobalException;
}
