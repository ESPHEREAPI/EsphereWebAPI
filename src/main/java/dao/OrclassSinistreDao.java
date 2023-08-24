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
import modele.OrclassExercice;
import modele.OrclassIntermediaires;
import modele.OrclassPolice;
import modele.OrclassSinistre;

/**
 *
 * @author JIATOU FRANCK
 */
@Stateless
public class OrclassSinistreDao extends AbstractJpaDAO<OrclassSinistre>{

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    private static final long serialVersionUID = 1L;
    @PersistenceContext(unitName = AbstractJpaDAO.PersistanceUnit)
    private EntityManager em;

    @Override
    protected Class<OrclassSinistre> getEntityClass() {
        return OrclassSinistre.class;
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    // recuperation des sinistres d une compagnyù
    public List<OrclassSinistre> listeSinistreByCompagnie(OrclassEntreprises e){
        Query q;
        q=em.createQuery("SELECT s FROM OrclassSinistre s WHERE s.idEntreprise= :e")
                .setParameter("e", e);
        return q.getResultList();
    }
    
    //recuperation d un sinistre pour une compagnie precise
    public OrclassSinistre finKey(OrclassEntreprises e ,String numero_registre,OrclassPolice p){
        Query q;
        q=em.createQuery("SELECT s FROM OrclassSinistre s WHERE s.idEntreprise= :e and s.numero_sinistre= :num and s.idPolice= :p")
                .setParameter("e", e)
                .setParameter("num", numero_registre)
                 .setParameter("p", p);
        if (q.getResultList().isEmpty()) {
            return null;
        }
        return (OrclassSinistre) q.getResultList().toArray()[0];
    }
     public OrclassSinistre finKey(OrclassEntreprises e ,String numero_registre,int code_exercice,String code_agence){
        Query q;
        q=em.createQuery("SELECT s FROM OrclassSinistre s WHERE s.idEntreprise= :e and s.numero_sinistre= :num and s.idRegistreSinistre.idExercice.code= :exercice and s.idIntermediaire.idRefIntermediaire.code= :agence")
                .setParameter("e", e)
                .setParameter("agence", code_agence)
                  .setParameter("exercice", code_exercice)
                .setParameter("num", numero_registre)
//                 .setParameter("p", p)
                ;
        if (q.getResultList().isEmpty()) {
            return null;
        }
        return (OrclassSinistre) q.getResultList().toArray()[0];
    }
    // recuration de la dernier ligne d enregistrement d un sinistre pour une compagny
    public OrclassSinistre selectLastSinistreByCompagnieForPolice(OrclassEntreprises e, OrclassPolice p){
      Query q;
      q=em.createQuery("SELECT s FROM OrclassSinistre s WHERE s.id=(SELECT MAX (si.id) FROM OrclassSinistre si where si.idEntreprise= :e and si.idPolice.idCategories.idBranche= :br and si.idIntermediaire.idIntermediaire= :idagence )")
              .setParameter("e", e)
              .setParameter("br", p.getIdCategories().getIdBranche())
               .setParameter("idagence", p.getIdIntermediaire().getIdIntermediaire());
        if (q.getResultList().isEmpty()) {
            return null;
        }
        return (OrclassSinistre) q.getResultList().toArray()[0];
    }
    
  
    
}
