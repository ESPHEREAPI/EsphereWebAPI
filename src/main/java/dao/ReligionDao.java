/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import modele.Religion;

/**
 *
 * @author hypoass
 */
@Stateless
@LocalBean
public class ReligionDao extends AbstractJpaDAO<Religion> {
    private static final long serialVersionUID = 1L;
     
    @PersistenceContext(unitName=AbstractJpaDAO.PersistanceUnit)
    private EntityManager em;

    @Override
    protected Class<Religion> getEntityClass() {
        return Religion.class;
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    public Collection <Religion> getAllReligion(){
    return super.findAll();
    }
    
    public Religion getReligionByCode(String code){
          Map<String,Object> params=new HashMap<>();
        params.put("code", code);
        return super.findEntityByUsingQueryName(Religion.FIND_BY_CODE, params);
    }
}
