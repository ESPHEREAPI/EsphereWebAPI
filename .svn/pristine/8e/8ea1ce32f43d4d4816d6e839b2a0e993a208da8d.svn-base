package dao;

import java.util.List;
import java.util.Objects;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import modele.OrclassBranches;
import modele.OrclassCategories;
import modele.OrclassEntreprises;
import modele.Orclass_Access_Avenant;
import modele.Orclass_Objet;
import modele.Orclass_TypeAvenant;

@Stateless
public class Orclass_Access_AvenantDao extends AbstractJpaDAO<Orclass_Access_Avenant> {

    private static final long serialVersionUID = 1L;

    @PersistenceContext(unitName = "ESpherePU")
    private EntityManager em;

    protected Class<Orclass_Access_Avenant> getEntityClass() {
        return Orclass_Access_Avenant.class;
    }

    protected EntityManager getEntityManager() {
        return this.em;
    }

    public Orclass_Access_Avenant finKey(OrclassEntreprises e, OrclassBranches br, Orclass_Objet o, Orclass_TypeAvenant avenant, Boolean ajouter, Boolean modifier, Boolean supprimer) {
        Query q = this.em.createQuery("SELECT ac FROM Orclass_Access_Avenant ac WHERE ac.idEntreprises= :e and ac.idBranche= :br and ac.idObjet= :o and ac.idTypeAvenant= :av and ac.ajouter= :ajouter and ac.modifier= :modifier and ac.supprimer= :supprime").setParameter("e", e).setParameter("br", br).setParameter("o", o).setParameter("av", avenant).setParameter("ajouter", ajouter).setParameter("modifier", modifier).setParameter("supprime", supprimer);
        if (q.getResultList().isEmpty()) {
            return null;
        }
        return (Orclass_Access_Avenant) q.getResultList().toArray()[0];
    }
     public Orclass_Access_Avenant finKey(OrclassEntreprises e, OrclassBranches br, Orclass_Objet o, Orclass_TypeAvenant avenant) {
        Query q = this.em.createQuery("SELECT ac FROM Orclass_Access_Avenant ac WHERE ac.idEntreprises= :e and ac.idBranche= :br and ac.idObjet= :o and ac.idTypeAvenant= :av ").setParameter("e", e).setParameter("br", br).setParameter("o", o).setParameter("av", avenant);
        if (q.getResultList().isEmpty()) {
            return null;
        }
        return (Orclass_Access_Avenant) q.getResultList().toArray()[0];
    }

    public Orclass_Access_Avenant finKey(OrclassEntreprises e, OrclassBranches br, Orclass_Objet o, Orclass_TypeAvenant avenant, OrclassCategories cat, Boolean ajouter, Boolean modifier, Boolean supprimer) {
        Query q = this.em.createQuery("SELECT ac FROM Orclass_Access_Avenant ac WHERE ac.idEntreprises= :e and ac.idBranche= :br and ac.idObjet= :o and ac.idTypeAvenant= :av and ac.ajouter= :ajouter and ac.modifier= :modifier and ac.supprimer= :supprime and ac.idCategories= :cat").setParameter("e", e).setParameter("br", br).setParameter("o", o).setParameter("av", avenant).setParameter("ajouter", ajouter).setParameter("modifier", modifier).setParameter("supprime", supprimer).setParameter("cat", cat);
        if (q.getResultList().isEmpty()) {
            return null;
        }
        return (Orclass_Access_Avenant) q.getResultList().toArray()[0];
    }

    public List<Orclass_Access_Avenant> listeAccessAvenantByCompagnies(OrclassEntreprises e, OrclassBranches br) {
        Query q = this.em.createQuery("SELECT ac FROM Orclass_Access_Avenant ac WHERE ac.idEntreprises= :e and ac.idBranche= :br").setParameter("e", e).setParameter("br", br);
        return q.getResultList();
    }

    public List<Orclass_Access_Avenant> listeAccessAvenantByCompagnies(OrclassEntreprises e, OrclassBranches br, OrclassCategories cat) {
        Query q = this.em.createQuery("SELECT ac FROM Orclass_Access_Avenant ac WHERE ac.idEntreprises= :e and ac.idBranche= :br and ac.idCategories= :cat").setParameter("e", e).setParameter("br", br).setParameter("cat", cat);
        return q.getResultList();
    }
        public List<Orclass_Objet> listeAccessAvenantByCompagniesAndTypeAvenant(OrclassEntreprises e, OrclassBranches br,Orclass_TypeAvenant tp) {
        Query q = this.em.createQuery("SELECT DISTINCT ac.idObjet FROM Orclass_Access_Avenant ac WHERE ac.idEntreprises= :e and ac.idBranche= :br and ac.idTypeAvenant= :tpa").setParameter("e", e).setParameter("br", br).setParameter("tpa", tp);
        return q.getResultList();
    }

    /*
  supprimer un accessAvenant
     */
    public int deleteAccessAvenant(OrclassEntreprises e, Orclass_Access_Avenant acc) {
        Query query;
        int i = -1;
        if (acc != null && acc.getId() != null && Objects.equals(acc.getModifier(), Boolean.TRUE)) {
            query = em.createQuery(" DELETE ac FROM Orclass_AccessAvenat_Caracteristique ac WHERE ac.idAccess_Avenant= :access and ac.idEntreprise= :e")
                    .setParameter("e", e)
                    .setParameter("access", acc);
            i = (int) query.getSingleResult();
            if (i == -1) {
                return -1;

            }
            query = em.createQuery("DELETE ac FROM Orclass_Access_Avenant ac WHERE ac.idAccess_Avenant= :access and ac.idEntreprise= :e")
                    .setParameter("e", e)
                    .setParameter("access", acc.getId());
            i = (int) query.getSingleResult();

        }
        return i;
    }
}
