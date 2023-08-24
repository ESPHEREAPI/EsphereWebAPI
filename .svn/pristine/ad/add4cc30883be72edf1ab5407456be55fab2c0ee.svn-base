/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.math.BigInteger;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import modele.OrclassAvenant;
import modele.OrclassEntreprises;
import modele.OrclassPolice;
import modele.Orclass_TypeAvenant;

/**
 *
 * @author E-SPHERE
 */
@Stateless
public class OrclassAvenantDao extends AbstractJpaDAO<OrclassAvenant>{

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
       private static final long serialVersionUID = 1L;
    @PersistenceContext(unitName = AbstractJpaDAO.PersistanceUnit)
    private EntityManager em;

    @Override
    protected Class<OrclassAvenant> getEntityClass() {
       return OrclassAvenant.class;
    }

    @Override
    protected EntityManager getEntityManager() {
      return em;
    }
    
    /*
    recupere le nombre d avenant utliser pour une police precis
    */
    public BigInteger lastNumeroAvenantByPolice(OrclassPolice police,OrclassEntreprises e){
        Query q;
        BigInteger ave=BigInteger.ZERO;
        q=em.createQuery("SELECT a.numero_avenant FROM OrclassAvenant a WHERE id=(SELECT MAX (av.id) FROM OrclassAvenant av where av.idPolice= :police and av.idEntreprises= :e)")
                .setParameter("police", police )
                .setParameter("e", e);
        if (q.getResultList().isEmpty()) {
            return BigInteger.ZERO;
        }
        ave= (BigInteger) q.getResultList().toArray()[0];
        return ave;
    }
    
      public List<OrclassAvenant>  listeAvenantByPolice(OrclassPolice police,OrclassEntreprises e){
        Query q;
        BigInteger ave=BigInteger.ZERO;
        q=em.createQuery("SELECT av FROM OrclassAvenant av where av.idPolice= :police and av.idEntreprises= :e")
                .setParameter("police", police )
                .setParameter("e", e);
        
       return q.getResultList();
    }
    
     public OrclassAvenant lastAvenantByPolice(OrclassPolice police,OrclassEntreprises e){
        Query q;
        OrclassAvenant ave=null;
        q=em.createQuery("SELECT a FROM OrclassAvenant a WHERE id=(SELECT MAX (av.id) FROM OrclassAvenant av where av.idPolice= :police and av.idEntreprises= :e)")
                .setParameter("police", police )
                .setParameter("e", e);
        if (q.getResultList().isEmpty()) {
            return null;
        }
      return (OrclassAvenant) q.getResultList().toArray()[0];
      
    }
    /*
    verification d une ligne por un avenant
    */
    public OrclassAvenant finkey(OrclassEntreprises e,Orclass_TypeAvenant tav,OrclassPolice p,BigInteger numero_avenant){
        Query q;
        q=em.createQuery("SELECT av FROM OrclassAvenant av WHERE av.idEntreprises= :e and av.idPolice= :p and av.idTypeAvenant= tav and av.numero_avenant= :nav")
                .setParameter("e", e)
                .setParameter("tav", tav)
                .setParameter("nav", numero_avenant);
        if (q.getResultList().isEmpty()) {
           return null;
        }
        return (OrclassAvenant) q.getResultList().toArray()[0];
        
    }
}
