/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sante;

import enums.ModeCalculDetailMaladie;
import enums.TypeDetailMaladie;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import modele.OrclassDetailPolicePlafond;
import modele.OrclassPlafondMaladie;
import modele.OrclassPoliceCaracteristique;
import modele.OrclassPoliceGarantie;
import modele.OrclassRubriqueCategorie;
import modele.OrclasseRefGroupe;

/**
 *
 * @author JIATOU FRANCK
 */
public class GroupeSanteElement {

   OrclassDetailPolicePlafond listePrestation[];
    OrclasseRefGroupe groupe;
    List< OrclassPoliceCaracteristique> listeCaracteristique;
    List< OrclassPoliceGarantie> listeGarantie;
    OrclassRubriqueCategorie rubriqueCategorie;
    OrclassPlafondMaladie plafondMaladie;
//     BigDecimal forfait;
//    BigDecimal taux;
//    BigDecimal barem;
//    BigDecimal plafond;
//    String code_ss;


    private TypeDetailMaladie typeDetailMaladie;

    private ModeCalculDetailMaladie modeCalculDetailMaladie;

    public GroupeSanteElement() {
        listePrestation = new OrclassDetailPolicePlafond[100];
        listeCaracteristique = new ArrayList<>();
        listeGarantie = new ArrayList<>();
        groupe = new OrclasseRefGroupe();
        rubriqueCategorie = new OrclassRubriqueCategorie();
        plafondMaladie = new OrclassPlafondMaladie();

    }

    public OrclassDetailPolicePlafond[] getListePrestation() {
        return listePrestation;
    }

    public void setListePrestation(OrclassDetailPolicePlafond[] listePrestation) {
        this.listePrestation = listePrestation;
    }


    public OrclasseRefGroupe getGroupe() {
        return groupe;
    }

    public void setGroupe(OrclasseRefGroupe groupe) {
        this.groupe = groupe;
    }

    public List<OrclassPoliceCaracteristique> getListeCaracteristique() {
        return listeCaracteristique;
    }

    public void setListeCaracteristique(List<OrclassPoliceCaracteristique> listeCaracteristique) {
        this.listeCaracteristique = listeCaracteristique;
    }

    public List<OrclassPoliceGarantie> getListeGarantie() {
        return listeGarantie;
    }

    public void setListeGarantie(List<OrclassPoliceGarantie> listeGarantie) {
        this.listeGarantie = listeGarantie;
    }

    public OrclassRubriqueCategorie getRubriqueCategorie() {
        return rubriqueCategorie;
    }

    public void setRubriqueCategorie(OrclassRubriqueCategorie rubriqueCategorie) {
        this.rubriqueCategorie = rubriqueCategorie;
    }

    public OrclassPlafondMaladie getPlafondMaladie() {
        return plafondMaladie;
    }

    public void setPlafondMaladie(OrclassPlafondMaladie plafondMaladie) {
        this.plafondMaladie = plafondMaladie;
    }

}
