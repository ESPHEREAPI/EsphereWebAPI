package dao;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import modele.OrclassBranches;
import modele.OrclassCaracteristiques;
import modele.OrclassEntreprises;
import modele.Orclass_AccessAvenat_Caracteristique;
import modele.Orclass_Access_Avenant;
import modele.Orclass_Objet;

@Stateless
public class Orclass_AccessAvenat_CaracteristiqueDao extends AbstractJpaDAO<Orclass_AccessAvenat_Caracteristique> {

    private static final long serialVersionUID = 1L;

    @PersistenceContext(unitName = "ESpherePU")
    private EntityManager em;

    protected Class<Orclass_AccessAvenat_Caracteristique> getEntityClass() {
        return Orclass_AccessAvenat_Caracteristique.class;
    }

    protected EntityManager getEntityManager() {
        return this.em;
    }

    public Orclass_AccessAvenat_Caracteristique finKey(OrclassEntreprises e, Orclass_Access_Avenant ac, OrclassCaracteristiques c) {
        Query q = this.em.createQuery("SELECT ac FROM Orclass_AccessAvenat_Caracteristique ac WHERE ac.idAccess_Avenant= :acc and ac.idCaracteristiques= :c and ac.idEntreprise= :e").setParameter("e", e).setParameter("acc", ac).setParameter("c", c);
        if (q.getResultList().isEmpty()) {
            return null;
        }
        return (Orclass_AccessAvenat_Caracteristique) q.getResultList().toArray()[0];
    }

    public List<Orclass_AccessAvenat_Caracteristique> listCaracteristiqueByAccessAvenant(Orclass_Access_Avenant ac, OrclassEntreprises e) {
        Query q = this.em.createQuery("SELECT ac FROM Orclass_AccessAvenat_Caracteristique ac where ac.idAccess_Avenant= :acc and ac.idEntreprise= :e").setParameter("e", e).setParameter("acc", ac);
        return q.getResultList();
    }

    public List<OrclassCaracteristiques> listCaracteristiqueByObjet(OrclassEntreprises e, Orclass_Objet objet) {
        Query q = this.em.createQuery("SELECT DISTINCT ac.idCaracteristiques FROM Orclass_AccessAvenat_Caracteristique ac where ac.idCaracteristiques.orclass_Objet= :ob and ac.idEntreprise= :e").setParameter("e", e).setParameter("ob", objet);
        return q.getResultList();
    }
    
     public List<OrclassCaracteristiques> listCaracteristiqueByObjet(OrclassEntreprises e, Orclass_Objet objet,Orclass_Access_Avenant acc) {
        Query q = this.em.createQuery("SELECT DISTINCT ac.idCaracteristiques FROM Orclass_AccessAvenat_Caracteristique ac where ac.idCaracteristiques.orclass_Objet= :ob and ac.idEntreprise= :e and ac.idAccess_Avenant.idTypeAvenant= :acc").setParameter("e", e).setParameter("ob", objet).setParameter("acc", acc.getIdTypeAvenant());
        return q.getResultList();
    }

    public List<Orclass_AccessAvenat_Caracteristique> listCaracteristiqueWithTypeAvenant(OrclassEntreprises e) {
        Query q = this.em.createQuery("SELECT ac FROM Orclass_AccessAvenat_Caracteristique ac where  ac.idEntreprise= :e ORDER BY ac.idAccess_Avenant.idTypeAvenant.idRefAvenant.code").setParameter("e", e);
        return q.getResultList();
    }

    public List<Orclass_AccessAvenat_Caracteristique> listAccessAvenat_Caracteristique(OrclassEntreprises e, OrclassBranches br) {
        Query q = this.em.createQuery("SELECT ac FROM Orclass_AccessAvenat_Caracteristique ac where  ac.idEntreprise= :e and ac.idAccess_Avenant.idBranche= :branche ORDER BY ac.idAccess_Avenant.idTypeAvenant.idRefAvenant.code").setParameter("e", e)
                .setParameter("branche", br);
        return q.getResultList();
    }
}
