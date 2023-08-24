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
import modele.OrclassCaracteristiques;
import modele.OrclassElement_Liste_Caracteristique;
import modele.OrclassEntreprises;

/**
 *
 * @author hp
 */
@Stateless
public class OrclassElement_Liste_CaracteristiqueDao extends AbstractJpaDAO<OrclassElement_Liste_Caracteristique>{

private static final long serialVersionUID = 1L;
    @PersistenceContext(unitName = AbstractJpaDAO.PersistanceUnit)
    private EntityManager em;

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    protected Class<OrclassElement_Liste_Caracteristique> getEntityClass() {
      return  OrclassElement_Liste_Caracteristique.class;
    }

    @Override
    protected EntityManager getEntityManager() {
   return em;
    }
  public List<OrclassElement_Liste_Caracteristique> listCaracteristiqueByCompagnieHaveListeElment(OrclassCaracteristiques c,OrclassEntreprises e) {
        Query q;
        q = em.createQuery("SELECT c FROM OrclassElement_Liste_Caracteristique c WHERE c.idEntreprise.idEntreprise= :idEntreprise and c.idCaracteristiques.id= :id")
                .setParameter("idEntreprise", e.getIdEntreprise())
                .setParameter("id",c.getId());
        return q.getResultList();
    }
  
    public List<OrclassElement_Liste_Caracteristique> listCaracteristiqueByCompagnieHaveListeElment(OrclassCaracteristiques c) {
        Query q;
        q = em.createQuery("SELECT c FROM OrclassElement_Liste_Caracteristique c WHERE c.idEntreprise.idEntreprise is null and c.idCaracteristiques.id= :id")
//                .setParameter("idEntreprise", e.getIdEntreprise())
                .setParameter("id",c.getId());
        return q.getResultList();
    }
  public OrclassElement_Liste_Caracteristique finKey(OrclassCaracteristiques c,OrclassEntreprises e,String libelle){
      Query q;
      q=em.createQuery("SELECT elt from  OrclassElement_Liste_Caracteristique elt WHERE elt.idEntreprise.idEntreprise= :idEntreprise AND elt.idCaracteristiques.id= :id and elt.libelle= :lib ")
                .setParameter("idEntreprise", e.getIdEntreprise())
              .setParameter("lib", libelle)
                .setParameter("id",c.getId());
      if (q.getResultList().isEmpty()) {
          return null;
      }
      return (OrclassElement_Liste_Caracteristique) q.getResultList().toArray()[0];
  }
   
}
