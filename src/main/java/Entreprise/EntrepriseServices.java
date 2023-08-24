package Entreprise;

import dao.AnneeDao;
import dao.EntrepriseDao;
import dao.ORCLASS_PROFILS_UTILISATEURSDao;
import dao.OrclassEntreprisesModulesDao;
import dao.OrclassModulesDao;
import dao.OrclassProfilsAccesDao;
import dao.OrclassProfilsDao;
import dao.OrclassUtilisateursAccesDao;
import dao.OrclassUtilisateursDao;
import enums.TypeUtilisateur;
import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;
import modele.ORCLASS_PROFILS_UTILISATEURS;
import modele.OrclassEntreprises;
import modele.OrclassEntreprisesModules;
import modele.OrclassEntreprisesModulesPK;
import modele.OrclassModules;
import modele.OrclassProfils;
import modele.OrclassProfilsAcces;
import modele.OrclassUtilisateurs;
import modele.OrclassUtilisateursAcces;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.Crypto;

@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
public class EntrepriseServices implements IEntreprise {
  public static final Logger logger = LoggerFactory.getLogger(EntrepriseServices.class);
  
  @PersistenceContext(unitName = "ESpherePU")
  private EntityManager em;
  
  @Resource
  UserTransaction tx;
  
  @EJB
  private AnneeDao anneeDao;
  
  @EJB
  private EntrepriseDao entrepriseDao;
  
  @EJB
  private OrclassModulesDao orclassModulesDao;
  
  @EJB
  OrclassProfilsDao profilsDao;
  
  @EJB
  OrclassProfilsAccesDao profilsAccesDao;
  
  @EJB
  OrclassUtilisateursAccesDao utilisateursAccesDao;
  
  @EJB
  OrclassUtilisateursDao utilisateursDao;
  
  @EJB
  OrclassEntreprisesModulesDao entreprisesModulesDao;
  
  @EJB
  ORCLASS_PROFILS_UTILISATEURSDao pROFILS_UTILISATEURSDao;
  
  public OrclassEntreprises addEntreprise(List<OrclassModules> collModules, OrclassEntreprises entreprise, Date debut, Date fin, OrclassUtilisateurs utilisateur) {
    OrclassEntreprises e = null;
    ORCLASS_PROFILS_UTILISATEURS pu = null;
    try {
      this.tx.begin();
      OrclassProfils profil = null;
      e = this.entrepriseDao.finkey(entreprise.getCode());
      if (e == null) {
        e = new OrclassEntreprises();
        e.setChemin_logo(entreprise.getChemin_logo());
        e.setCode(entreprise.getCode().toUpperCase());
        e.setDateCreation(new Date());
        e.setImage(entreprise.getImage());
        e.setImmatriculation(entreprise.getImmatriculation());
        e.setNoContribuable(entreprise.getNoContribuable());
        e.setRaisonSociale(entreprise.getRaisonSociale().toUpperCase());
        e.setAdresse(entreprise.getAdresse());
        e.setResponsable(entreprise.getResponsable());
        e.setTypeResponsabilite(entreprise.getTypeResponsabilite());
        e.setSiteWeb(entreprise.getSiteWeb());
        this.em.persist(e);
      } 
      e = (OrclassEntreprises)this.em.merge(e);
      for (OrclassModules m : collModules) {
        OrclassEntreprisesModules me = null;
        me = (OrclassEntreprisesModules)this.entreprisesModulesDao.find(new OrclassEntreprisesModulesPK(m.getIdModule().shortValue(), e.getIdEntreprise().shortValue()));
        if (me == null) {
          OrclassEntreprisesModules mes = new OrclassEntreprisesModules(m.getIdModule().shortValue(), e.getIdEntreprise().shortValue());
          mes.setOrclassModules(m);
          mes.setOrclassEntreprises(e);
          mes.setDateDebut(debut);
          mes.setDateFin(fin);
          this.em.persist(mes);
        } 
      } 
      profil = (OrclassProfils)this.profilsDao.findEntityHavingValue("code", "admin");
      OrclassUtilisateursAcces ua = null;
      OrclassUtilisateurs user = null;
      if (profil != null && profil.getIdProfil() != null) {
        user = (OrclassUtilisateurs)this.utilisateursDao.findEntityHavingValue("login", utilisateur.getLogin().toUpperCase());
        if (user == null) {
          user = new OrclassUtilisateurs();
          user.setLogin(utilisateur.getLogin().toUpperCase());
          user.setNom(utilisateur.getNom());
          user.setPrenom(utilisateur.getPrenom());
          user.setActif(Boolean.TRUE);
          user.setLangue(utilisateur.getLangue());
          user.setIdEntreprise(e);
          user.setAdresse(utilisateur.getAdresse());
//          user.setActif(Boolean.TRUE);
//          user.setPassword(Crypto.sha256(utilisateur.getPassword().toUpperCase()));
          user.setTypeUtilisateur(TypeUtilisateur.UTILISATEUR_ENTITE);
          this.em.persist(user);
        } 
        user = (OrclassUtilisateurs)this.em.merge(user);
        for (OrclassProfilsAcces pa : this.profilsAccesDao.getAllAccesByProfil(profil)) {
          if (this.utilisateursAccesDao.finKey(pa, user) == null) {
            ua = new OrclassUtilisateursAcces();
            ua.setAutorisation_principal(Boolean.TRUE);
            ua.setAutorisation_fonctionnalite(Boolean.TRUE);
            ua.setAutorisation_action(Boolean.TRUE);
            ua.setIdAction(pa.getIdAction());
            ua.setIdFonctionnalite(pa.getIdFonctionnalite());
            ua.setIdModule(pa.getIdModule());
            ua.setIdProfil(profil);
            ua.setIdUtilisateur(user);
            this.em.persist(ua);
          } 
        } 
        if (this.pROFILS_UTILISATEURSDao.finkey(user, profil) == null) {
          pu = new ORCLASS_PROFILS_UTILISATEURS();
          pu.setIdProfil(profil);
          pu.setIdUtilisateur(user);
          this.em.persist(pu);
        } 
      } 
      this.tx.commit();
    } catch (IllegalStateException|SecurityException|javax.transaction.HeuristicMixedException|javax.transaction.HeuristicRollbackException|javax.transaction.NotSupportedException|javax.transaction.RollbackException|javax.transaction.SystemException ex) {
      System.err.println("message error : " + ex.getMessage() + " localisation " + ex.getLocalizedMessage() + " " + ex.toString());
    } 
    return e;
  }
}
