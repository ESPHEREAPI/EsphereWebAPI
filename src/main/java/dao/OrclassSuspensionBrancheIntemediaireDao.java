/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import modele.OrclassBranches;
import modele.OrclassEntreprises;
import modele.OrclassIntermediaires;


import modele.OrclassSuspensionBrancheIntemediaire;

/**
 *
 * @author hp
 */
@Stateless
public class OrclassSuspensionBrancheIntemediaireDao extends AbstractJpaDAO<OrclassSuspensionBrancheIntemediaire> {

    private static final long serialVersionUID = 1L;
    @PersistenceContext(unitName = AbstractJpaDAO.PersistanceUnit)
    private EntityManager em;
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    protected Class<OrclassSuspensionBrancheIntemediaire> getEntityClass() {
        return OrclassSuspensionBrancheIntemediaire.class;
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    /*
    lister les branches suspendue pour un intermeiare d une compagnie precis
     */
    public List<OrclassBranches> listeBrancheSuspendueForIntermediaire(OrclassIntermediaires agence, OrclassEntreprises e) {
        Query q;
        q = em.createQuery("SELECT s.idBranche FROM OrclassSuspensionBrancheIntemediaire s WHERE s.idIntermediaire.idIntermediaire= :idIntermediaire AND s.idEntreprise.idEntreprise= :idEntreprise")
                .setParameter("idIntermediaire", agence.getIdIntermediaire())
                .setParameter("idEntreprise", e.getIdEntreprise());
        return q.getResultList();

    }
    
    /*
    fonctionnalite  pour teste l unicite de l entite SuspensionBrancheIntemediaire
    */
    public OrclassSuspensionBrancheIntemediaire finKey(OrclassIntermediaires agence, OrclassEntreprises e,OrclassBranches b){
        Query q;
        q=em.createQuery("SELECT s FROM OrclassSuspensionBrancheIntemediaire s WHERE s.idBranche.idBranche= :idBranche AND s.idEntreprise.idEntreprise= :idEntreprise and s.idIntermediaire.idIntermediaire= :idIntermediaire")
                .setParameter("idBranche", b.getIdBranche())
               .setParameter("idEntreprise", e.getIdEntreprise())
                .setParameter("idIntermediaire", agence.getIdIntermediaire());
        if (q.getResultList().isEmpty()) {
            return null;
        }
        return (OrclassSuspensionBrancheIntemediaire) q.getResultList().toArray()[0];
    }
}
