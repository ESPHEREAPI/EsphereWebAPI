/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quittance;

import enums.TypeActe;
import enums.TypeQuittance;
import java.util.Date;
import java.util.List;
import javax.ejb.Local;
import modele.OrclassApporteur;
import modele.OrclassBranches;
import modele.OrclassCategories;
import modele.OrclassEntreprises;
import modele.OrclassIntermediaires;
import modele.OrclassQuitance;

/**
 *
 * @author JIATOU FRANCK
 */
@Local
public interface IQuittance {

    /*
    ici le choix est basé sur une agence unique avec le choix de un ou pluisieur apporteurs,branche,categories 
     */
    public List<OrclassQuitance> listeQuittanceByAgenceOrChoixMultiple(OrclassIntermediaires agence,List<OrclassApporteur> listeSelecteApporteur,List<OrclassBranches> listeSelecteBranche,List<OrclassCategories> listeSelecteCategories,TypeActe typeActe,TypeQuittance typeQuittance);
    
     public void chargePeriode(OrclassEntreprises e,Date debut,Date fin);
      public List<OrclassQuitance> listeQuittanceByAllAgenceOrChoixMultiple(List<OrclassIntermediaires> listeAgence,List<OrclassApporteur> listeSelecteApporteur,List<OrclassBranches> listeSelecteBranche,List<OrclassCategories> listeSelecteCategories,TypeActe typeActe,TypeQuittance typeQuittance);
   
}
