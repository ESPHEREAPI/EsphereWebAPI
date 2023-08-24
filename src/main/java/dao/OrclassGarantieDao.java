package dao;

import dao.AbstractJpaDAO;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import modele.OrclassCategories;
import modele.OrclassEntreprises;
import modele.OrclassGarantie;
import modele.OrclassPolice;
import modele.OrclassRefGaranties;
import modele.OrclassTypeTarif;

@Stateless
public class OrclassGarantieDao extends AbstractJpaDAO<OrclassGarantie> {

    private static final long serialVersionUID = 1L;

    @PersistenceContext(unitName = "ESpherePU")
    private EntityManager em;

    protected Class<OrclassGarantie> getEntityClass() {
        return OrclassGarantie.class;
    }

    protected EntityManager getEntityManager() {
        return this.em;
    }

    public OrclassGarantie finKeyGaranties(OrclassCategories cat, OrclassRefGaranties refG, OrclassEntreprises e) {
        Query q = this.em.createQuery("SELECT g FROM OrclassGarantie g WHERE g.idCategories.idCategorie= :idCategorie AND g.idRefGaranties.id= :id AND g.idEntreprise.idEntreprise= :idEntreprise ").setParameter("idCategorie", cat.getIdCategorie()).setParameter("id", refG.getId()).setParameter("idEntreprise", e.getIdEntreprise());
        if (q.getResultList().isEmpty()) {
            return null;
        }
        return (OrclassGarantie) q.getResultList().toArray()[0];
    }

    public List<OrclassGarantie> getallGarantieByCompagnoe(OrclassEntreprises e) {
        Query q = this.em.createQuery("SELECT g FROM OrclassGarantie g  WHERE g.idEntreprise.idEntreprise= :idEntreprise").setParameter("idEntreprise", e.getIdEntreprise());
        return q.getResultList();
    }

    public List<OrclassGarantie> getallGarantieByCategorieByCompagnie(OrclassEntreprises e, OrclassCategories cat) {
        Query q = this.em.createQuery("SELECT g FROM OrclassGarantie g  WHERE g.idEntreprise.idEntreprise= :idEntreprise AND g.idCategories.idCategorie= :idCategorie ").setParameter("idEntreprise", e.getIdEntreprise()).setParameter("idCategorie", cat.getIdCategorie());
        return q.getResultList();
    }

    public List<OrclassGarantie> getallGarantieByCategorieByCompagnie(OrclassCategories cat) {
        Query q = this.em.createQuery("SELECT g FROM OrclassGarantie g  WHERE  g.idCategories.idCategorie= :idCategorie and ( g.globalCompagnie is null or (g.globalCompagnie=0 or g.globalCompagnie=false))").setParameter("idCategorie", cat.getIdCategorie());
        return q.getResultList();
    }

    public List<OrclassRefGaranties> getRefGarantieByCategorieByCompagnie(OrclassEntreprises e, OrclassCategories cat) {
        Query q = this.em.createQuery("SELECT g.idRefGaranties FROM OrclassGarantie g  WHERE g.idEntreprise.idEntreprise= :idEntreprise AND g.idCategories.idCategorie= :idCategorie and (g.globalCompagnie is null or (g.globalCompagnie=0 or g.globalCompagnie=false))").setParameter("idEntreprise", e.getIdEntreprise()).setParameter("idCategorie", cat.getIdCategorie());
        return q.getResultList();
    }

    public List<OrclassCategories> listeCategoriesHaveGarantie(OrclassEntreprises e) {
        Query q = this.em.createQuery("SELECT DISTINCT rg.idCategories FROM OrclassGarantie rg WHERE rg.idEntreprise.idEntreprise= :idEntreprise ").setParameter("idEntreprise", e.getIdEntreprise());
        return q.getResultList();
    }

    public List<OrclassCategories> listeCategoriesHaveGarantie() {
        Query q = this.em.createQuery("SELECT DISTINCT rg.idCategories FROM OrclassGarantie rg WHERE (rg.globalCompagnie=1 or rg.globalCompagnie=true)");
        return q.getResultList();
    }

    public List<OrclassGarantie> listeGarantieHaveGratuitOrForfair(OrclassEntreprises e, OrclassCategories cat) {
        Query q = this.em.createQuery("SELECT g FROM OrclassGarantie g  WHERE g.idEntreprise.idEntreprise= :idEntreprise AND g.idCategories.idCategorie= :idCategorie and ((g.gratuit=1 or  g.gratuit=true) or (g.forfaire=1 or g.forfaire=true)) ")
                .setParameter("idEntreprise", e.getIdEntreprise())
                .setParameter("idCategorie", cat.getIdCategorie());
        return q.getResultList();
    }

    public List<OrclassGarantie> listeGarantieHaveGratuitOrForfair(OrclassTypeTarif tarif, OrclassEntreprises e, OrclassCategories cat) {
        Query q = this.em.createQuery("SELECT DISTINCT rg.idGarantie FROM OrclassRubriqueGarantie rg  WHERE rg.idEntreprise.idEntreprise= :idEntreprise AND rg.idGarantie.idCategories.idCategorie= :idCategorie  and rg.idTypeTarif.id= :tarif and ((rg.idGarantie.gratuit=1 or  rg.idGarantie.gratuit=true) or (rg.idGarantie.forfaire=1 or rg.idGarantie.forfaire=true))")
                .setParameter("idEntreprise", e.getIdEntreprise())
                .setParameter("tarif", tarif.getId())
                .setParameter("idCategorie", cat.getIdCategorie());
        return q.getResultList();
    }
    //recuperation des garanties non editable par une compagnie

    public List<OrclassRefGaranties> listeGarantieNonEditable() {
        Query q = this.em.createQuery("SELECT DISTINCT g.idRefGaranties FROM OrclassGarantie g  WHERE (g.globalCompagnie=1 or g.globalCompagnie=true)");
        return q.getResultList();
    }

    public List<OrclassRefGaranties> listeGarantieNonEditable(OrclassCategories cat) {
        Query q = this.em.createQuery("SELECT DISTINCT g.idRefGaranties FROM OrclassGarantie g  WHERE (g.globalCompagnie=1 or g.globalCompagnie=true) and g.idCategories= :c")
                .setParameter("c", cat);
        ;
        return q.getResultList();
    }

    /*
    lister les garanties  d une categories n ayant pas ete ajouter 
     */

    public List<OrclassGarantie> listeGarantiesNotAddPoliceGatie(OrclassEntreprises e, OrclassCategories cat, OrclassPolice p) {
        Query q;
        q = em.createQuery("SELECT DISTINCT rg.idGarantie FROM OrclassRubriqueGarantie rg WHERE Not Exists (Select pg.idGarantie FROM OrclassPoliceGarantie pg where pg.idGarantie= rg.idGarantie and pg.idEntreprise= :e and pg.idPolice= :p and pg.idGarantie.idCategories= :cat) and rg.idGarantie.idCategories= :cat")
                .setParameter("e", e)
                .setParameter("p", p)
                .setParameter("cat", cat);
        return q.getResultList();
    }
}
