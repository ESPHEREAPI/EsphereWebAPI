/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import enums.LienParente;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import modele.OrclassEntreprises;
import modele.OrclassImageFamilleRisque;
import modele.OrclassImageRisque;
import modele.OrclassPolice;
import modele.OrclasseRefGroupe;

/**
 *
 * @author frankjiatou
 */
@Stateless
public class OrclassImageFamilleRisqueDao extends AbstractJpaDAO<OrclassImageFamilleRisque>{

       private static final long serialVersionUID = 1L;
    @PersistenceContext(unitName = AbstractJpaDAO.PersistanceUnit)
    private EntityManager em;
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    protected Class<OrclassImageFamilleRisque> getEntityClass() {
        return OrclassImageFamilleRisque.class;
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
   
    }
    public OrclassImageFamilleRisque finKey(OrclassImageRisque r,String nom_membre,Date dateNaissance){
        Query q;
        q=em.createQuery("SELECT rf  FROM OrclassImageFamilleRisque rf WHERE rf.dateNaissance= :date and rf.idRisque= :risque and rf.nom_membre= :membre ")
                .setParameter("date", dateNaissance)
                .setParameter("risque", r)
                .setParameter("membre", nom_membre);
        if (q.getResultList().isEmpty()) {
            return null;
        }
        return (OrclassImageFamilleRisque) q.getResultList().toArray()[0];
    }
    public List<OrclassImageFamilleRisque>listeImageFamilleRisqueByImageRisque(OrclassImageRisque r){
        Query q;
         q=em.createQuery("SELECT rf  FROM OrclassImageFamilleRisque rf WHERE  rf.idRisque= :risque ")
                
                .setParameter("risque", r)
               ;
         return q.getResultList();
    }

    public Long nombreMembre(OrclassPolice police,OrclassEntreprises e,OrclasseRefGroupe g){
         Query q;
         Long nombreRisque=0L;
         q=em.createQuery("SELECT COUNT(rf.nom_membre) FROM OrclassImageFamilleRisque rf  WHERE     rf.lienParente= :c and rf.idRisque.numero_polic= :np and rf.idRisque.idGroup.id= :idg")
                 .setParameter("np", police.getNumero_police())
                 .setParameter("idg", g.getId())
                  .setParameter("c", LienParente.conjoint)
                 ;
         nombreRisque=(Long) q.getSingleResult();
         return nombreRisque;
         
     }
     public Long nombreEnfant(OrclassPolice police,OrclassEntreprises e,OrclasseRefGroupe g){
         Query q;
         Long nombreRisque=0L;
         q=em.createQuery("SELECT COUNT(rf) FROM OrclassImageFamilleRisque rf WHERE rf.idRisque.numero_polic= :np  and rf.lienParente= :c and rf.idRisque.idGroup.id= :idg")
                 .setParameter("np", police.getNumero_police())
                 .setParameter("idg", g.getId())
                  .setParameter("c", LienParente.enfant)
                 ;
         nombreRisque=(Long) q.getSingleResult();
         return nombreRisque==null ? 0L:nombreRisque;
         
     }
    
}
