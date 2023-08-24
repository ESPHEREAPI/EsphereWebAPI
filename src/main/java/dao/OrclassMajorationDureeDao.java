package dao;
import dao.AbstractJpaDAO;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import modele.OrclassCategories;
import modele.OrclassDuree;
import modele.OrclassEntreprises;
import modele.OrclassMajorationDuree;

@Stateless
public class OrclassMajorationDureeDao extends AbstractJpaDAO<OrclassMajorationDuree> {
  private static final long serialVersionUID = 1L;
  
  @PersistenceContext(unitName = "ESpherePU")
  private EntityManager em;
  
  protected Class<OrclassMajorationDuree> getEntityClass() {
    return OrclassMajorationDuree.class;
  }
  
  protected EntityManager getEntityManager() {
    return this.em;
  }
  
  public List<OrclassMajorationDuree> listMajoration(OrclassEntreprises e, OrclassDuree d) {
    Query q = this.em.createQuery("SELECT m FROM OrclassMajorationDuree m WHERE m.idEntreprise.idEntreprise= :idEntreprise and m.idDuree.id= :id ").setParameter("idEntreprise", e.getIdEntreprise()).setParameter("id", d.getId());
    return q.getResultList();
  }
  
  public OrclassMajorationDuree finkey(OrclassEntreprises e, OrclassDuree d, OrclassCategories cat) {
    Query q = this.em.createQuery("SELECT m FROM OrclassMajorationDuree m WHERE m.idEntreprise.idEntreprise= :idEntreprise and m.idCategories.idCategorie= :idCategorie and m.idDuree.id= :id ").setParameter("idEntreprise", e.getIdEntreprise()).setParameter("idCategorie", cat.getIdCategorie()).setParameter("id", d.getId());
    if (q.getResultList().isEmpty())
      return null; 
    return (OrclassMajorationDuree)q.getResultList().toArray()[0];
  }
  
  public List<OrclassCategories> listMajorationWithCategories(OrclassEntreprises e, OrclassDuree d) {
    Query q = this.em.createQuery("SELECT m.idCategories FROM OrclassMajorationDuree m WHERE m.idEntreprise.idEntreprise= :idEntreprise and m.idDuree.id= :id ").setParameter("idEntreprise", e.getIdEntreprise()).setParameter("id", d.getId());
    return q.getResultList();
  }
  
  public List<OrclassMajorationDuree> listMajorationByCategories(OrclassEntreprises e, OrclassCategories cat) {
    Query q = this.em.createQuery("SELECT m FROM OrclassMajorationDuree m WHERE m.idEntreprise.idEntreprise= :idEntreprise and m.idCategories.idCategorie= :id ").setParameter("idEntreprise", e.getIdEntreprise()).setParameter("id", cat.getIdCategorie());
    return q.getResultList();
  }
  
  public List<OrclassDuree> listDureeHaveCategories(OrclassCategories cat, OrclassEntreprises e) {
    Query q = this.em.createQuery("SELECT DISTINCT md.idDuree FROM OrclassMajorationDuree md WHERE  md.idCategories.idCategorie= :idCategorie and md.idEntreprise.idEntreprise= :idEntreprise").setParameter("idCategorie", cat.getIdCategorie()).setParameter("idEntreprise", e.getIdEntreprise());
    return q.getResultList();
  }
  
  public OrclassMajorationDuree lastRowMajorationDuree(OrclassCategories cat, OrclassEntreprises e, OrclassDuree d) {
    Query q = this.em.createQuery("SELECT m FROM OrclassMajorationDuree m WHERE m.id=(SELECT MAX(md.id) FROM OrclassMajorationDuree md where md.idCategories.idCategorie= :idCategorie and md.idEntreprise.idEntreprise= :idEntreprise  and md.idDuree.id= :id)").setParameter("id", d.getId()).setParameter("idEntreprise", e.getIdEntreprise()).setParameter("idCategorie", cat.getIdCategorie());
    if (q.getResultList().isEmpty())
      return null; 
    return (OrclassMajorationDuree)q.getResultList().toArray()[0];
  }
}