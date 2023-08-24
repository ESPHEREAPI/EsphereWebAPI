/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import modele.DAOEntry;
import modele.ParametrageDonne;

/**
 *
 * @author JIATOU FRANCK
 */
@Stateless
public class ParametrageDonneDao extends AbstractJpaDAO<ParametrageDonne>{
  private static final long serialVersionUID = 1L;
    @PersistenceContext(unitName = AbstractJpaDAO.PersistanceUnit)
    private EntityManager em;
    @Override
    protected Class<ParametrageDonne> getEntityClass() {
      return ParametrageDonne.class;
    }

    @Override
    protected EntityManager getEntityManager() {
    return em;
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
