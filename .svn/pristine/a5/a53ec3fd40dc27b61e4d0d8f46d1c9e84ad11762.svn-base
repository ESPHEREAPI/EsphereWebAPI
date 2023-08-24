/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.Collection;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import modele.OrclassEntreprises;
import modele.OrclassIntermediaires;
import modele.OrclassProfils;
import modele.OrclassUtilisateurs;
import utils.Crypto;

/**
 *
 * @author hp
 */
@Stateless
public class OrclassUtilisateursDao extends AbstractJpaDAO<OrclassUtilisateurs> {

    private static final long serialVersionUID = 1L;
    @PersistenceContext(unitName = AbstractJpaDAO.PersistanceUnit)
    private EntityManager em;

    @Override
    protected Class<OrclassUtilisateurs> getEntityClass() {

        return OrclassUtilisateurs.class;
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public Collection<OrclassUtilisateurs> listUtilisateurWithFilters(int start, int end, String filter, OrclassEntreprises e) {
        Query query;

        String stringQuery = "SELECT u FROM OrclassUtilisateurs u WHERE  u.idEntreprise= :identreprise and u.nom  like ? or u.prenom like ? ";
        Query q = getEntityManager().createQuery(stringQuery);
        q.setParameter(1, "%" + filter + "%");
        q.setParameter(2, "%" + filter + "%");
        q.setParameter("identreprise", e.getIdEntreprise());
        q.setMaxResults(end - start);
        q.setFirstResult(start);
        return q.getResultList();
    }

    public Long countUtilisateurWithFilters(String filter, OrclassEntreprises e) {
        String stringQuery = "select count(u) FROM OrclassUtilisateurs u WHERE  u.idEntreprise= :identreprise and u.nom  like ? or u.prenom like ?";
        Query q = getEntityManager().createQuery(stringQuery);
        q.setParameter(1, "%" + filter + "%");
        q.setParameter(2, "%" + filter + "%");
        q.setParameter("identreprise", e.getIdEntreprise());

        return (Long) q.getSingleResult();
    }

    public Collection<OrclassUtilisateurs> listUtilisateurWithFilters(OrclassEntreprises e) {
        Query query;

        String stringQuery = "SELECT u FROM OrclassUtilisateurs u WHERE  u.idEntreprise= :identreprise ";
        Query q = getEntityManager().createQuery(stringQuery);

        q.setParameter("identreprise", e);

        return q.getResultList();
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    /*
     lister les utilisateurs par profil
     */
    public List<OrclassUtilisateurs> userByProfil(OrclassProfils p) {
        Query q;
        q = em.createQuery("SELECT DISTINCT u.idUtilisateur FROM OrclassUtilisateursAcces u WHERE u.idProfil.idProfil= :idProfil ")
                .setParameter("idProfil", p.getIdProfil());
        return q.getResultList();
    }

    /*
        lister les utilisateur d une agence ou intermediaire
     */
    public List<OrclassUtilisateurs> listeUtilisateurByIntemediaire(OrclassIntermediaires in, OrclassEntreprises e) {
        Query q;
        q = em.createQuery("SELECT u FROM OrclassUtilisateurs u WHERE u.idIntermediaire.idIntermediaire= :idIntermediaire and u.idEntreprise.idEntreprise= :idEntreprise")
                .setParameter("idIntermediaire", in.getIdIntermediaire())
                .setParameter("idEntreprise", e.getIdEntreprise());

        return q.getResultList();

    }

    //verification de l existance de la cle de securite
    public Boolean cleSecuriteExiste(String cle, OrclassEntreprises e) {
        Query q;
        q = em.createQuery("SELECT u FROM OrclassUtilisateurs u WHERE u.cle_securite= :cle and u.idEntreprise= :e")
                .setParameter("cle", Crypto.sha256(cle).toUpperCase())
                .setParameter("e", e);
        if (q.getResultList().isEmpty()) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    public Boolean passWordExiste(String pass, OrclassEntreprises e) {
        Query q;
        q = em.createQuery("SELECT u FROM OrclassUtilisateurs u WHERE u.password= :cle and u.idEntreprise= :e")
                .setParameter("cle", Crypto.sha256(pass.toUpperCase()))
                .setParameter("e", e);
        if (q.getResultList().isEmpty()) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    public Boolean emailExiste(String email, OrclassEntreprises e) {
        Query q;
        q = em.createQuery("SELECT u FROM OrclassUtilisateurs u WHERE u.adresse.email = :email and u.idEntreprise= :e")
                .setParameter("email", email)
                .setParameter("e", e);
        if (q.getResultList().isEmpty()) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    public OrclassUtilisateurs emailExiste(String email) {
        Query q;
        q = em.createQuery("SELECT u FROM OrclassUtilisateurs u WHERE u.adresse.email = :email ")
                .setParameter("email", email);
//                .setParameter("e", e);
        if (q.getResultList().isEmpty()) {
            return null;
        }
        return (OrclassUtilisateurs) q.getResultList().toArray()[0];
    }

    public Long nbreUserCreateByCompagny(OrclassEntreprises e) {
        Query q;
        q = em.createQuery("SELECT COUNT(u.login) FROM OrclassUtilisateurs u WHERE u.idEntreprise= :idcomp")
                .setParameter("idcomp", e);
        return ((Long) q.getSingleResult());
    }

    public Boolean isexistEmail(String email) {
        Query q;
        q = em.createQuery("SELECT u FROM OrclassUtilisateurs u WHERE u.adresse.email= :email")
                .setParameter("email", email);
        return q.getResultList() == null ? Boolean.FALSE : q.getResultList().isEmpty() ? Boolean.FALSE : Boolean.TRUE;
    }
}
