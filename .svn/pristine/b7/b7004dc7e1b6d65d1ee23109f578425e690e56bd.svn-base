/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import modele.OrclassEntreprises;
import modele.OrclassGarantie;
import modele.OrclassGroupeGarantiePolice;
import modele.OrclassPolice;
import modele.OrclasseRefGroupe;

/**
 *
 * @author JIATOU FRANCK
 */
@Stateless
public class OrclassGroupeGarantiePoliceDao extends AbstractJpaDAO<OrclassGroupeGarantiePolice> {

    @PersistenceContext(unitName = "ESpherePU")
    private EntityManager em;

    @Override
    protected Class<OrclassGroupeGarantiePolice> getEntityClass() {
       return OrclassGroupeGarantiePolice.class;
    }

    @Override
    protected EntityManager getEntityManager() {
       return em;
    }
    public OrclassGroupeGarantiePolice finKey(OrclassEntreprises e, OrclassPolice police,OrclasseRefGroupe group,OrclassGarantie garantie){
        Query q;
        q=em.createQuery("SELECT ggp FROM OrclassGroupeGarantiePolice ggp WHERE ggp.idEntreprise= :e and ggp.idGroupePolice.idPolice= :p and ggp.idGarantie= :g and ggp.idGroupePolice.idRefGroupe= :gr")
                .setParameter("e", e)
                .setParameter("g", garantie)
                .setParameter("gr", group)
                .setParameter("p", police)
                ;
        if (q.getResultList().isEmpty()) {
            return null;
        }
        return (OrclassGroupeGarantiePolice) q.getResultList().toArray()[0];
        
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
