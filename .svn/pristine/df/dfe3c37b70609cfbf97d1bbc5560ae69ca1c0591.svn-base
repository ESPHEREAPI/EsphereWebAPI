/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quittance;


import enums.TypeActe;
import enums.TypeQuittance;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.UserTransaction;
import modele.OrclassApporteur;
import modele.OrclassBranches;
import modele.OrclassCategories;
import modele.OrclassEntreprises;
import modele.OrclassIntermediaires;
import modele.OrclassQuitance;

/**
 *
 * @author JIATOU FRANCK
 */
@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
public class ServiceQuittance implements IQuittance {

    @PersistenceContext(unitName = "ESpherePU")
    private EntityManager em;
    @Resource
    UserTransaction tx;
    private OrclassEntreprises entreprises;
    private Date debu, fin;

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @Override
    public List<OrclassQuitance> listeQuittanceByAgenceOrChoixMultiple(OrclassIntermediaires agence, List<OrclassApporteur> listeSelecteApporteur, List<OrclassBranches> listeSelecteBranche, List<OrclassCategories> listeSelecteCategories, TypeActe typeActe, TypeQuittance typeQuittance) {
        List<OrclassQuitance> listeQuittance = new ArrayList<>();
        Set<OrclassQuitance> listeAllQuitances = new HashSet<>();
        if (agence != null && agence.getIdIntermediaire() != null) {
            // on parcour les branche
            for (OrclassBranches br : listeSelecteBranche) {
                for (OrclassApporteur ap : listeSelecteApporteur) {

                    for (OrclassCategories c : listeSelecteCategories) {
                        

                        if (typeActe.equals(TypeActe.tout) && typeQuittance.equals(TypeQuittance.tout)) {
                            listeQuittance = this.listeQuittanceAllTypeActeAllTypeQuittance(agence, br, ap, c);

                        } else if (typeActe.equals(TypeActe.tout) && !typeQuittance.equals(TypeQuittance.tout)) {
                            listeQuittance = this.listeQuittanceAllTypeActe(agence, br, ap, c, typeQuittance);
                        } else if (!typeActe.equals(TypeActe.tout) && typeQuittance.equals(TypeQuittance.tout)) {
                            listeQuittance = this.listeQuittanceAllTypeQuittance(agence, br, ap, c, typeActe);

                        } else if (!typeActe.equals(TypeActe.tout) && !typeQuittance.equals(TypeQuittance.tout)) {
                            listeQuittance = this.listeQuittanceNotAllTypeQuittanceNotAllTypeActe(agence, br, ap, c, typeActe, typeQuittance);
                        }
                         listeAllQuitances.addAll(listeQuittance);

                    }
                }
               

            }

        }
        return (new ArrayList<>(listeAllQuitances)) ;
    }

    public List<OrclassQuitance> listeQuittanceAllTypeActeAllTypeQuittance(OrclassIntermediaires agence, OrclassBranches br, OrclassApporteur ap, OrclassCategories cat) {
        Query q;
        q = em.createQuery("SELECT q FROM OrclassQuitance q WHERE q.idPolice.idIntermediaire= :agence and q.idPolice.idCategories= :cat and q.idPolice.idCategories.idBranche= :br and (q.idPolice.validation=1 or q.idPolice.validation=true) and (q.idPolice.annulation=0 or q.idPolice.annulation=false) and q.idEntreprise= :e and q.idPolice.idApporteur= :ap and q.idPolice.date_effet BETWEEN :debut and :fin ")
                .setParameter("agence", agence)
                .setParameter("cat", cat)
                .setParameter("br", br)
                .setParameter("ap", ap)
                .setParameter("debut", this.debu)
                .setParameter("fin", this.fin)
                .setParameter("e", this.entreprises);
        return q.getResultList();
    }

    public List<OrclassQuitance> listeQuittanceAllTypeActe(OrclassIntermediaires agence, OrclassBranches br, OrclassApporteur ap, OrclassCategories cat, TypeQuittance tq) {
        Query q;
        q = em.createQuery("SELECT q FROM OrclassQuitance q WHERE q.idPolice.idIntermediaire= :agence and q.idPolice.idCategories= :cat and q.idPolice.idCategories.idBranche= :br and (q.idPolice.validation=1 or q.idPolice.validation=true) and (q.idPolice.annulation=0 or q.idPolice.annulation=false) and q.idEntreprise= :e and q.idPolice.idApporteur= :ap and q.idPolice.date_effet BETWEEN :debut and :fin and q.typQuittance= :tq ")
                .setParameter("agence", agence)
                .setParameter("cat", cat)
                .setParameter("br", br)
                .setParameter("ap", ap)
                .setParameter("debut", this.debu)
                .setParameter("fin", this.fin)
                .setParameter("e", this.entreprises)
                .setParameter("tq", tq);
        return q.getResultList();
    }

    public List<OrclassQuitance> listeQuittanceAllTypeQuittance(OrclassIntermediaires agence, OrclassBranches br, OrclassApporteur ap, OrclassCategories cat, TypeActe ta) {
        Query q = null;
        if (ta.equals(TypeActe.affaire_nouvelle)) {
            q = em.createQuery("SELECT q FROM OrclassQuitance q WHERE q.idPolice.idIntermediaire= :agence and q.idPolice.idCategories= :cat and q.idPolice.idCategories.idBranche= :br and (q.idPolice.validation=1 or q.idPolice.validation=true) and (q.idPolice.annulation=0 or q.idPolice.annulation=false) and q.idEntreprise= :e and q.idPolice.idApporteur= :ap and q.idPolice.date_effet BETWEEN :debut and :fin and q.idAvenant is null ")
                    .setParameter("agence", agence)
                    .setParameter("cat", cat)
                    .setParameter("br", br)
                    .setParameter("ap", ap)
                    .setParameter("debut", this.debu)
                    .setParameter("fin", this.fin)
                    .setParameter("e", this.entreprises)
//                    .setParameter("ta", ta)
                    ;
        } else if (ta.equals(TypeActe.avenant)) {

            q = em.createQuery("SELECT q FROM OrclassQuitance q WHERE q.idPolice.idIntermediaire= :agence and q.idPolice.idCategories= :cat and q.idPolice.idCategories.idBranche= :br and (q.idPolice.validation=1 or q.idPolice.validation=true) and (q.idPolice.annulation=0 or q.idPolice.annulation=false) and q.idEntreprise= :e and q.idPolice.idApporteur= :ap and q.idPolice.date_effet BETWEEN :debut and :fin  and   q.idAvenant is not null ")
                    .setParameter("agence", agence)
                    .setParameter("cat", cat)
                    .setParameter("br", br)
                    .setParameter("ap", ap)
                    .setParameter("debut", this.debu)
                    .setParameter("fin", this.fin)
                    .setParameter("e", this.entreprises)
//                    .setParameter("ta", ta)
                    ;
        }

        return q.getResultList();
    }

    public List<OrclassQuitance> listeQuittanceNotAllTypeQuittanceNotAllTypeActe(OrclassIntermediaires agence, OrclassBranches br, OrclassApporteur ap, OrclassCategories cat, TypeActe ta, TypeQuittance tq) {
        Query q = null;
        if (ta.equals(TypeActe.affaire_nouvelle)) {
            q = em.createQuery("SELECT q FROM OrclassQuitance q WHERE q.idPolice.idIntermediaire= :agence and q.idPolice.idCategories= :cat and q.idPolice.idCategories.idBranche= :br and (q.idPolice.validation=1 or q.idPolice.validation=true) and (q.idPolice.annulation=0 or q.idPolice.annulation=false) and q.idEntreprise= :e and q.idPolice.idApporteur= :ap and q.idPolice.date_effet BETWEEN :debut and :fin and q.typQuittance= :tq  and q.idAvenant is null ")
                    .setParameter("agence", agence)
                    .setParameter("cat", cat)
                    .setParameter("br", br)
                    .setParameter("ap", ap)
                    .setParameter("debut", this.debu)
                    .setParameter("fin", this.fin)
                    .setParameter("e", this.entreprises)
//                    .setParameter("ta", ta)
                    .setParameter("tq", tq);
        } else if (ta.equals(TypeActe.avenant)) {

            q = em.createQuery("SELECT q FROM OrclassQuitance q WHERE q.idPolice.idIntermediaire= :agence and q.idPolice.idCategories= :cat and q.idPolice.idCategories.idBranche= :br and (q.idPolice.validation=1 or q.idPolice.validation=true) and (q.idPolice.annulation=0 or q.idPolice.annulation=false) and q.idEntreprise= :e and q.idPolice.idApporteur= :ap and q.idPolice.date_effet BETWEEN :debut and :fin and q.typQuittance= :tq  and q.idAvenant is not null ")
                    .setParameter("agence", agence)
                    .setParameter("cat", cat)
                    .setParameter("br", br)
                    .setParameter("ap", ap)
                    .setParameter("debut", this.debu)
                    .setParameter("fin", this.fin)
                    .setParameter("e", this.entreprises)
//                    .setParameter("ta", ta)
                    .setParameter("tq", tq);
        }

        return q.getResultList();
    }

    public OrclassEntreprises getEntreprises() {
        return entreprises;
    }

    public void setEntreprises(OrclassEntreprises entreprises) {
        this.entreprises = entreprises;
    }

    public Date getDebu() {
        return debu;
    }

    public void setDebu(Date debu) {
        this.debu = debu;
    }

    public Date getFin() {
        return fin;
    }

    public void setFin(Date fin) {
        this.fin = fin;
    }

    @Override
    public void chargePeriode(OrclassEntreprises e, Date debut, Date fin) {
      this.setEntreprises(e);
      this.setDebu(debut);
      this.setFin(fin);
    }
    @Override
     public List<OrclassQuitance> listeQuittanceByAllAgenceOrChoixMultiple(List<OrclassIntermediaires> listeAgence,List<OrclassApporteur> listeSelecteApporteur,List<OrclassBranches> listeSelecteBranche,List<OrclassCategories> listeSelecteCategories,TypeActe typeActe,TypeQuittance typeQuittance){
           List<OrclassQuitance> listeQuittance = new ArrayList<>();
        Set<OrclassQuitance> listeAllQuitances = new HashSet<>();
        if (!listeAgence.isEmpty() ) {
             for (OrclassIntermediaires ag : listeAgence) {
                 
           
            // on parcour les branche
            for (OrclassBranches br : listeSelecteBranche) {
                for (OrclassApporteur ap : listeSelecteApporteur) {

                    for (OrclassCategories c : listeSelecteCategories) {
                        

                        if (typeActe.equals(TypeActe.tout) && typeQuittance.equals(TypeQuittance.tout)) {
                            listeQuittance = this.listeQuittanceAllTypeActeAllTypeQuittance(ag, br, ap, c);

                        } else if (typeActe.equals(TypeActe.tout) && !typeQuittance.equals(TypeQuittance.tout)) {
                            listeQuittance = this.listeQuittanceAllTypeActe(ag, br, ap, c, typeQuittance);
                        } else if (!typeActe.equals(TypeActe.tout) && typeQuittance.equals(TypeQuittance.tout)) {
                            listeQuittance = this.listeQuittanceAllTypeQuittance(ag, br, ap, c, typeActe);

                        } else if (!typeActe.equals(TypeActe.tout) && !typeQuittance.equals(TypeQuittance.tout)) {
                            listeQuittance = this.listeQuittanceNotAllTypeQuittanceNotAllTypeActe(ag, br, ap, c, typeActe, typeQuittance);
                        }
                         listeAllQuitances.addAll(listeQuittance);

                    }
                }
               

            }
              }

        }
        return (new ArrayList<>(listeAllQuitances)) ;
     }
   

}
