package Entreprise;

import java.util.Date;
import java.util.List;
import modele.OrclassEntreprises;
import modele.OrclassModules;
import modele.OrclassUtilisateurs;

public interface IEntreprise {
  OrclassEntreprises addEntreprise(List<OrclassModules> paramList, OrclassEntreprises paramOrclassEntreprises, Date paramDate1, Date paramDate2, OrclassUtilisateurs paramOrclassUtilisateurs);
}
