/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import modele.OrclassCategories;
import modele.OrclassEntreprises;
import modele.OrclassFractionnement;
import modele.OrclassFractionnementCategories;

/**
 *
 * @author hp
 */
@Stateless
public class OrclassFractionnementCategoriesDao extends AbstractJpaDAO<OrclassFractionnementCategories> {

    private static final long serialVersionUID = 1L;
    @PersistenceContext(unitName = AbstractJpaDAO.PersistanceUnit)
    private EntityManager em;

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @Override
    protected Class<OrclassFractionnementCategories> getEntityClass() {
        return OrclassFractionnementCategories.class;
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    /*
    liste les fractionnement pour une categories precis avec une date d effet effective
    */
    public  List<OrclassFractionnementCategories> listeFractionnementByCategorie(OrclassCategories cat,OrclassEntreprises e){
       Query q; 
       List<OrclassFractionnementCategories> listeFraction=new ArrayList<>();
       List<Object> listObjet=new ArrayList<>();
       q=em.createQuery("SELECT  MAX(f.dateeffet),f.idFractionnemente as fractionnement   FROM OrclassFractionnementCategories f WHERE f.idCategories.idCategorie= :idCategorie ")
               .setParameter("idCategorie", cat.getIdCategorie())
//               .setParameter("idEntreprise", e.getIdEntreprise())
               ;
        if (q.getResultList().isEmpty()) {
            return null;
        }
        int taille=q.getResultList().size();
        int taille_table=taille*2;
        Object t[]=new Object[2];
        listObjet=q.getResultList();
        for (int i = 0; i < taille; i++) {
            
            t=(Object[]) listObjet.toArray()[0];
            System.out.println(" date :"+t[0]);
             System.out.println(" date :"+t[1]);
        }
        return listeFraction;
    }
    
    public  List<OrclassFractionnement> listFractionnementHaveCategories(OrclassCategories cat,OrclassEntreprises e){
        Query q;
        q=em.createQuery("SELECT DISTINCT fr.idFractionnemente FROM OrclassFractionnementCategories fr WHERE  fr.idCategories.idCategorie= :idCategorie and fr.idEntreprise.idEntreprise= :idEntreprise")
                .setParameter("idCategorie", cat.getIdCategorie())
                .setParameter("idEntreprise", e.getIdEntreprise())
                ;
        return q.getResultList();
    }
    
        public  List<OrclassFractionnementCategories> listeFractionnementHaveCategories(OrclassCategories cat,OrclassEntreprises e){
        Query q;
        q=em.createQuery("SELECT DISTINCT fr FROM OrclassFractionnementCategories fr WHERE  fr.idCategories.idCategorie= :idCategorie and fr.idEntreprise.idEntreprise= :idEntreprise")
                .setParameter("idCategorie", cat.getIdCategorie())
                .setParameter("idEntreprise", e.getIdEntreprise())
                ;
        return q.getResultList();
    }
    
    /*
    retourne la dernier ligne d une fractionnement en fonction de sa date d effette
    */
    public OrclassFractionnementCategories lastRowFractionnement(OrclassCategories cat,OrclassEntreprises e,OrclassFractionnement fr){
        Query q;
        q=em.createQuery("SELECT fr FROM OrclassFractionnementCategories fr WHERE fr.id=(SELECT MAX(f.id) FROM OrclassFractionnementCategories f where f.idCategories.idCategorie= :idCategorie and f.idEntreprise.idEntreprise= :idEntreprise  and f.idFractionnemente.id= :id)")
                .setParameter("id", fr.getId())
                .setParameter("idEntreprise", e.getIdEntreprise())
                .setParameter("idCategorie", cat.getIdCategorie());
        if (q.getResultList().isEmpty()) {
            return null;
        }
        
      return (OrclassFractionnementCategories) q.getResultList().toArray()[0];
    }
}
