/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import modele.DAOEntry;
import modele.GenreAuto;

/**
 *
 * @author JIATOU FRANCK
 */
@Stateless
public class GenreAutoDao extends AbstractJpaDAO<GenreAuto> {

    private static final long serialVersionUID = 1L;
    @PersistenceContext(unitName = AbstractJpaDAO.PersistanceUnit)
    private EntityManager em;

    @Override
    protected Class<GenreAuto> getEntityClass() {
        return GenreAuto.class;
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
      public List<String>listeGenre_vehicule(){
        Query q;
        q=em.createQuery("SELECT  DISTINCT g.libelle FROM GenreAuto g ");
        return q.getResultList();
    }

}
