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
import modele.UsageAuto;

/**
 *
 * @author JIATOU FRANCK
 */
@Stateless
public class UsageAutoDao extends AbstractJpaDAO<UsageAuto> {

    @PersistenceContext(unitName = AbstractJpaDAO.PersistanceUnit)
    private EntityManager em;

    @Override
    protected Class<UsageAuto> getEntityClass() {
        return UsageAuto.class;
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    public List<String>listeUsage_vehicule(){
        Query q;
        q=em.createQuery("SELECT  DISTINCT u.libelle FROM UsageAuto u ");
        return q.getResultList();
    }

}
