/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package dao;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import modele.DAOEntry;
import modele.OrclassCaracteristiqueSinistreMaladie;
import modele.OrclassCaracteristiques;
import modele.OrclassEntreprises;
import modele.OrclassEvenement;
import modele.OrclassEvenementSinistreMaladie;
import modele.OrclassSinistreMaladie;

/**
 *
 * @author JIATOU FRANCK
 */
@Stateless
public class OrclassCaracteristiqueSinistreMaladieDao extends AbstractJpaDAO<OrclassCaracteristiqueSinistreMaladie> {

    @PersistenceContext(unitName = AbstractJpaDAO.PersistanceUnit)
    private EntityManager em;

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @Override
    protected Class<OrclassCaracteristiqueSinistreMaladie> getEntityClass() {
        return OrclassCaracteristiqueSinistreMaladie.class;
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    public List<OrclassCaracteristiqueSinistreMaladie> listCaractreristiqueBySinistreMaladie(OrclassEntreprises e,OrclassSinistreMaladie sinMad){
        Query q;
        q=em.createQuery("SELECT sc FROM OrclassCaracteristiqueSinistreMaladie sc WHERE sc.idEntreprise= :e and sc.idSinistreMaladie= :sinmad")
                .setParameter("e", e)
                .setParameter("sinmad", sinMad)
                ;
        return q.getResultList();
    }
    
     public OrclassCaracteristiqueSinistreMaladie caracteristiqueBySinistreMaladie(OrclassEntreprises e, OrclassSinistreMaladie sinMad,  OrclassCaracteristiques c) {
        Query q;
        q = em.createQuery("SELECT sc FROM OrclassCaracteristiqueSinistreMaladie sc WHERE sc.idEntreprise= :e and sc.idSinistreMaladie= :sinmad and sc.idCaracteristiques.id= :idcaract")
                .setParameter("e", e)
                .setParameter("sinmad", sinMad)
                .setParameter("idcaract", c.getId());
        if (q.getResultList().isEmpty()) {
            return null;
        }
        return (OrclassCaracteristiqueSinistreMaladie) q.getResultList().toArray()[0];
    }
}
