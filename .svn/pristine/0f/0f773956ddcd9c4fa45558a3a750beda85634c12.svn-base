/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sante;

import dao.OrclassGroupePoliceDao;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import modele.OrclassDetailPolicePlafond;
import modele.OrclassGroupePolice;
import modele.OrclassPoliceCaracteristique;
import modele.OrclassPoliceGarantie;
import modele.OrclassRisqueFamille;

/**
 *
 * @author hp
 */
public class Contrat_Sante {

    String  codeAgence, refPolice, libelleAgence, codeAssure, adresseBpAgence, telAgence, faxAgence, villeAgence,
            nomComplet, adresseBp, activite, tel, mail, dateDebut, dateFin, contrat, devise, fax, dateNaissance, sexe;
    String garantie, capital, taux, pourcentage, prime, accessoire, totalTaxe, total_a_paye, prorate;
    String libelleCaracteristique, valeurCaracteristique;
    String libelleGroup, adresseGroup, villeGroup,observation;
    int ordre_groupe=0;

    String libellePlafondMaladie, domaineApplication, montant, acte, periodeCouverture, modeControle;
    String categorie;
    String dateDebutGarantie, dateFinGarantie, dureGarantie, contratGarantie;
    List<OrclassPoliceCaracteristique> colCaracteristiquePrint = new ArrayList<>();
    List<OrclassRisqueFamille> colFamille = new ArrayList<>();
    List<OrclassDetailPolicePlafond> colPrestation = new ArrayList<>();
    List<OrclassPoliceGarantie> colGarantiePrint = new ArrayList<>();
    String taxe_prime;
    String primeNetteQuittance;
    OrclassGroupePolice groupePolice;
    BigDecimal police;
    String user,charger_client;

    public Contrat_Sante() {
        groupePolice = new OrclassGroupePolice();

    }

    public BigDecimal getPolice() {
        return police;
    }

    public void setPolice(BigDecimal police) {
        this.police = police;
    }

    public String getCodeAgence() {
        return codeAgence;
    }

    public void setCodeAgence(String codeAgence) {
        this.codeAgence = codeAgence;
    }

    public String getRefPolice() {
        return refPolice;
    }

    public void setRefPolice(String refPolice) {
        this.refPolice = refPolice;
    }

    public String getLibelleAgence() {
        return libelleAgence;
    }

    public void setLibelleAgence(String libelleAgence) {
        this.libelleAgence = libelleAgence;
    }

    public String getCodeAssure() {
        return codeAssure;
    }

    public void setCodeAssure(String codeAssure) {
        this.codeAssure = codeAssure;
    }

    public String getAdresseBpAgence() {
        return adresseBpAgence;
    }

    public void setAdresseBpAgence(String adresseBpAgence) {
        this.adresseBpAgence = adresseBpAgence;
    }

    public String getTelAgence() {
        return telAgence;
    }

    public void setTelAgence(String telAgence) {
        this.telAgence = telAgence;
    }

    public String getFaxAgence() {
        return faxAgence;
    }

    public void setFaxAgence(String faxAgence) {
        this.faxAgence = faxAgence;
    }

    public String getVilleAgence() {
        return villeAgence;
    }

    public void setVilleAgence(String villeAgence) {
        this.villeAgence = villeAgence;
    }

    public String getNomComplet() {
        return nomComplet;
    }

    public void setNomComplet(String nomComplet) {
        this.nomComplet = nomComplet;
    }

    public String getAdresseBp() {
        return adresseBp;
    }

    public void setAdresseBp(String adresseBp) {
        this.adresseBp = adresseBp;
    }

    public String getActivite() {
        return activite;
    }

    public void setActivite(String activite) {
        this.activite = activite;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(String dateDebut) {
        this.dateDebut = dateDebut;
    }

    public String getDateFin() {
        return dateFin;
    }

    public void setDateFin(String dateFin) {
        this.dateFin = dateFin;
    }

    public String getContrat() {
        return contrat;
    }

    public void setContrat(String contrat) {
        this.contrat = contrat;
    }

    public String getDevise() {
        return devise;
    }

    public void setDevise(String devise) {
        this.devise = devise;
    }

    public String getGarantie() {
        return garantie;
    }

    public void setGarantie(String garantie) {
        this.garantie = garantie;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public String getTaux() {
        return taux;
    }

    public void setTaux(String taux) {
        this.taux = taux;
    }

    public String getPourcentage() {
        return pourcentage;
    }

    public void setPourcentage(String pourcentage) {
        this.pourcentage = pourcentage;
    }

    public String getPrime() {
        return prime;
    }

    public void setPrime(String prime) {
        this.prime = prime;
    }

    public String getAccessoire() {
        return accessoire;
    }

    public void setAccessoire(String accessoire) {
        this.accessoire = accessoire;
    }

    public String getTotalTaxe() {
        return totalTaxe;
    }

    public void setTotalTaxe(String totalTaxe) {
        this.totalTaxe = totalTaxe;
    }

    public String getTotal_a_paye() {
        return total_a_paye;
    }

    public void setTotal_a_paye(String total_a_paye) {
        this.total_a_paye = total_a_paye;
    }

    public String getLibelleCaracteristique() {
        return libelleCaracteristique;
    }

    public void setLibelleCaracteristique(String libelleCaracteristique) {
        this.libelleCaracteristique = libelleCaracteristique;
    }

    public String getValeurCaracteristique() {
        return valeurCaracteristique;
    }

    public void setValeurCaracteristique(String valeurCaracteristique) {
        this.valeurCaracteristique = valeurCaracteristique;
    }

    public String getLibellePlafondMaladie() {
        return libellePlafondMaladie;
    }

    public void setLibellePlafondMaladie(String libellePlafondMaladie) {
        this.libellePlafondMaladie = libellePlafondMaladie;
    }

    public String getDomaineApplication() {
        return domaineApplication;
    }

    public void setDomaineApplication(String domaineApplication) {
        this.domaineApplication = domaineApplication;
    }

    public String getMontant() {
        return montant;
    }

    public void setMontant(String montant) {
        this.montant = montant;
    }

    public String getActe() {
        return acte;
    }

    public void setActe(String acte) {
        this.acte = acte;
    }

    public String getPeriodeCouverture() {
        return periodeCouverture;
    }

    public void setPeriodeCouverture(String periodeCouverture) {
        this.periodeCouverture = periodeCouverture;
    }

    public String getModeControle() {
        return modeControle;
    }

    public void setModeControle(String modeControle) {
        this.modeControle = modeControle;
    }

    public String getDateDebutGarantie() {
        return dateDebutGarantie;
    }

    public void setDateDebutGarantie(String dateDebutGarantie) {
        this.dateDebutGarantie = dateDebutGarantie;
    }

    public String getDateFinGarantie() {
        return dateFinGarantie;
    }

    public void setDateFinGarantie(String dateFinGarantie) {
        this.dateFinGarantie = dateFinGarantie;
    }

    public String getDureGarantie() {
        return dureGarantie;
    }

    public void setDureGarantie(String dureGarantie) {
        this.dureGarantie = dureGarantie;
    }

    public String getContratGarantie() {
        return contratGarantie;
    }

    public void setContratGarantie(String contratGarantie) {
        this.contratGarantie = contratGarantie;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

//    public List<CaracteristiquePrint> getColCaracteristiquePrint() {
//        return colCaracteristiquePrint;
//    }
//
//    public void setColCaracteristiquePrint(List<CaracteristiquePrint> colCaracteristiquePrint) {
//        this.colCaracteristiquePrint = colCaracteristiquePrint;
//    }
//
//  
//
//    public List<FamillePrint> getColFamille() {
//        return colFamille;
//    }
//
//    public void setColFamille(List<FamillePrint> colFamille) {
//        this.colFamille = colFamille;
//    }
//
//    public List<PrestationPrints> getColPrestation() {
//        return colPrestation;
//    }
//
//    public void setColPrestation(List<PrestationPrints> colPrestation) {
//        this.colPrestation = colPrestation;
//    }
    public String getProrate() {
        return prorate;
    }

    public void setProrate(String prorate) {
        this.prorate = prorate;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public String getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(String dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public String getTaxe_prime() {
        return taxe_prime;
    }

    public void setTaxe_prime(String taxe_prime) {
        this.taxe_prime = taxe_prime;
    }

    public String getPrimeNetteQuittance() {
        return primeNetteQuittance;
    }

    public void setPrimeNetteQuittance(String primeNetteQuittance) {
        this.primeNetteQuittance = primeNetteQuittance;
    }

    public String getLibelleGroup() {
        return libelleGroup;
    }

    public void setLibelleGroup(String libelleGroup) {
        this.libelleGroup = libelleGroup;
    }

    public String getAdresseGroup() {
        return adresseGroup;
    }

    public void setAdresseGroup(String adresseGroup) {
        this.adresseGroup = adresseGroup;
    }

    public String getVilleGroup() {
        return villeGroup;
    }

    public void setVilleGroup(String villeGroup) {
        this.villeGroup = villeGroup;
    }

    public List<OrclassPoliceCaracteristique> getColCaracteristiquePrint() {
        return colCaracteristiquePrint;
    }

    public void setColCaracteristiquePrint(List<OrclassPoliceCaracteristique> colCaracteristiquePrint) {
        this.colCaracteristiquePrint = colCaracteristiquePrint;
    }

    public List<OrclassRisqueFamille> getColFamille() {
        return colFamille;
    }

    public void setColFamille(List<OrclassRisqueFamille> colFamille) {
        this.colFamille = colFamille;
    }

    public List<OrclassDetailPolicePlafond> getColPrestation() {
        return colPrestation;
    }

    public void setColPrestation(List<OrclassDetailPolicePlafond> colPrestation) {
        this.colPrestation = colPrestation;
    }

    

    public List<OrclassPoliceGarantie> getColGarantiePrint() {
        return colGarantiePrint;
    }

    public void setColGarantiePrint(List<OrclassPoliceGarantie> colGarantiePrint) {
        this.colGarantiePrint = colGarantiePrint;
    }

    

    public OrclassGroupePolice getGroupePolice() {
        return groupePolice;
    }

    public void setGroupePolice(OrclassGroupePolice groupePolice) {
        this.groupePolice = groupePolice;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getCharger_client() {
        return charger_client;
    }

    public void setCharger_client(String charger_client) {
        this.charger_client = charger_client;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }

    public int getOrdre_groupe() {
        return ordre_groupe;
    }

    public void setOrdre_groupe(int ordre_groupe) {
        this.ordre_groupe = ordre_groupe;
    }
    

}
