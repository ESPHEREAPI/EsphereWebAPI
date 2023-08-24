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
import modele.OrclassCaracteristiques;
import modele.OrclassCategories;
import modele.OrclassEntreprises;
import modele.OrclassSousCaracteristiqueProduit;

/**
 *
 * @author JIATOU FRANCK
 */
@Stateless
public class OrclassSousCaracteristiqueProduitDao extends AbstractJpaDAO<OrclassSousCaracteristiqueProduit> {

    private static final long serialVersionUID = 1L;
    @PersistenceContext(unitName = AbstractJpaDAO.PersistanceUnit)
    private EntityManager em;

    @Override
    protected Class<OrclassSousCaracteristiqueProduit> getEntityClass() {
        return OrclassSousCaracteristiqueProduit.class;
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public OrclassSousCaracteristiqueProduit finKey(OrclassEntreprises e, OrclassCaracteristiques c, OrclassCategories cat) {
        Query q;
        q = em.createQuery("SELECT sc FROM OrclassSousCaracteristiqueProduit sc WHERE sc.idEntreprise.idEntreprise= :ide and sc.idCaracteristiques.id= :idc and sc.idCategories.idCategorie= :idcat")
                .setParameter("ide", e.getIdEntreprise())
                .setParameter("idc", c.getId())
                .setParameter("idcat", cat.getIdCategorie());
        if (q.getResultList().isEmpty()) {
            return null;
        }
        return (OrclassSousCaracteristiqueProduit) q.getResultList().toArray()[0];

    }

    public List<OrclassSousCaracteristiqueProduit> listeSousCaracteristique(OrclassEntreprises e) {
        Query q;
        q = em.createQuery("SELECT sc FROM OrclassSousCaracteristiqueProduit sc WHERE sc.idEntreprise.idEntreprise= :ide ")
                .setParameter("ide", e.getIdEntreprise());

        return q.getResultList();
    }

    /**
     * liste des sous caracteristique d un produit precis
     *
     * @param e
     * @param cat
     * @return
     */
    public List<OrclassSousCaracteristiqueProduit> listeSousCaracteristiqueProduitByProduit(OrclassEntreprises e, OrclassCategories cat) {
        Query q;
        q = em.createQuery("SELECT sc FROM OrclassSousCaracteristiqueProduit sc WHERE sc.idEntreprise.idEntreprise= :ide and sc.idCategories.idCategorie= :idcat")
                .setParameter("ide", e.getIdEntreprise())
                .setParameter("idcat", cat.getIdCategorie());
        return q.getResultList();

    }
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
