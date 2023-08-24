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
import modele.OrclassEntreprises;
import modele.OrclassVille;

/**
 *
 * @author hp
 */
@Stateless
public class OrclassVilleDao  extends AbstractJpaDAO<OrclassVille>{

      private static final long serialVersionUID = 1L;
    @PersistenceContext(unitName = AbstractJpaDAO.PersistanceUnit)
    private EntityManager em;
    @Override
    protected Class<OrclassVille> getEntityClass() {
      return OrclassVille.class;
    }

    @Override
    protected EntityManager getEntityManager() {
       return em;
    }

    /*
    recuperer les villes d une compagnies 
    */
    
    public List<OrclassVille> listeByCompagnie(OrclassEntreprises e){
        Query q;
        q=em.createQuery("SELECT v FROM OrclassVille v WHERE v.idEntreprise.idEntreprise= :id")
                .setParameter("id", e.getIdEntreprise());
        return q.getResultList();
    }
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
