/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import controllers.SecurityController;
import enums.DomaineApplication;
import enums.ModeCalculDetailMaladie;
import enums.ModeControle;
import enums.TypeDetailMaladie;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Comparator;
import java.util.Locale;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import utils.GlobalFonctions;
import utils.LocaleHelper;

/**
 *
 * @author hp
 */
@Entity
@Table(name = "ORCLASS_DET_POL_PLAF")
public class OrclassDetailPolicePlafond implements DAOEntry {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    @Column(name = "ID_DET_POL_PLAF")
    private Long id;

    @JoinColumn(name = "ID_POLICE_PLAFOND", referencedColumnName = "ID_POLICE_PLAFOND")
    @ManyToOne(optional = false)
    private OrclassPolicePlafond idPolicePlafond;
    @JoinColumn(name = "ID_AVENANT", referencedColumnName = "ID_AVENANT")
    @ManyToOne(optional = true)
    private OrclassAvenant idAvenant;
    @JoinColumn(name = "ID_ENTREPRISE", referencedColumnName = "ID_ENTREPRISE")
    @ManyToOne(optional = false)
    private OrclassEntreprises idEntreprise;
    @JoinColumn(name = "ID_PRESTATION", referencedColumnName = "ID_PRESTATION")
    @ManyToOne(optional = false)
    private OrclassPrestation idPrestation;
    @JoinColumn(name = "ID_RUBRIQUE", referencedColumnName = "ID_RUBRIQUE")
    @ManyToOne(optional = false)
    private OrclassRubrique idRubrique;
    @JoinColumn(name = "ID_GR_DE", referencedColumnName = "ID_REF_GROUPE")
    @ManyToOne(optional = true)
    private OrclasseRefGroupe idGroup;

    BigDecimal forfait;
    BigDecimal taux;
    BigDecimal barem;
    BigDecimal plafond;
    String code_ss;

    @Enumerated(EnumType.STRING)
    @Column(name = "TYPE_DETAIL_MALADIE")
    private TypeDetailMaladie typeDetailMaladie;
    @Enumerated(EnumType.STRING)
    @Column(name = "MODE_CALCUL_MALADIE")
    private ModeCalculDetailMaladie modeCalculDetailMaladie;
    @Transient
    Orclass_TypeAvenant typeAvenant;
    private Boolean modifier, ajouter, retire_de_la_police = Boolean.FALSE;
    private Long codeid_retirer;
    @Transient
    OrclassPlafondMaladie plafondMaladie;
    @Transient
    Boolean afficher = Boolean.TRUE;
    @Transient
    String texte;
    @Transient
    String valueType;

    public OrclassDetailPolicePlafond() {
        idPrestation = new OrclassPrestation();
        idRubrique = new OrclassRubrique();
    }

    public OrclassPolicePlafond getIdPolicePlafond() {
        return idPolicePlafond;
    }

    public void setIdPolicePlafond(OrclassPolicePlafond idPolicePlafond) {
        this.idPolicePlafond = idPolicePlafond;
    }

    public OrclassEntreprises getIdEntreprise() {
        return idEntreprise;
    }

    public void setIdEntreprise(OrclassEntreprises idEntreprise) {
        this.idEntreprise = idEntreprise;
    }

    public OrclassPrestation getIdPrestation() {
        return idPrestation;
    }

    public void setIdPrestation(OrclassPrestation idPrestation) {
        this.idPrestation = idPrestation;
    }

    public BigDecimal getForfait() {
        return forfait;
    }

    public void setForfait(BigDecimal forfait) {
        this.forfait = forfait;
    }

    public BigDecimal getTaux() {
        return taux;
    }

    public void setTaux(BigDecimal taux) {
        this.taux = taux;
    }

    public BigDecimal getBarem() {
        return barem;
    }

    public void setBarem(BigDecimal barem) {
        this.barem = barem;
    }

    public BigDecimal getPlafond() {
        return plafond;
    }

    public void setPlafond(BigDecimal plafond) {
        this.plafond = plafond;
    }

    public String getCode_ss() {
        return code_ss;
    }

    public void setCode_ss(String code_ss) {
        this.code_ss = code_ss;
    }

    public TypeDetailMaladie getTypeDetailMaladie() {
//        if (this.typeDetailMaladie==null) {
//            return ;
//        }
        return typeDetailMaladie;
    }

    public void setTypeDetailMaladie(TypeDetailMaladie typeDetailMaladie) {
        this.typeDetailMaladie = typeDetailMaladie;
    }

    public ModeCalculDetailMaladie getModeCalculDetailMaladie() {
        return modeCalculDetailMaladie;
    }

    public void setModeCalculDetailMaladie(ModeCalculDetailMaladie modeCalculDetailMaladie) {
        this.modeCalculDetailMaladie = modeCalculDetailMaladie;
    }

    public OrclassRubrique getIdRubrique() {
        return idRubrique;
    }

    public void setIdRubrique(OrclassRubrique idRubrique) {
        this.idRubrique = idRubrique;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Orclass_TypeAvenant getTypeAvenant() {
        return typeAvenant;
    }

    public void setTypeAvenant(Orclass_TypeAvenant typeAvenant) {
        this.typeAvenant = typeAvenant;
    }

    public OrclassAvenant getIdAvenant() {
        return idAvenant;
    }

    public void setIdAvenant(OrclassAvenant idAvenant) {
        this.idAvenant = idAvenant;
    }

    public Boolean getModifier() {
        return modifier;
    }

    public void setModifier(Boolean modifier) {
        this.modifier = modifier;
    }

    public Boolean getAjouter() {
        return ajouter;
    }

    public void setAjouter(Boolean ajouter) {
        this.ajouter = ajouter;
    }

    public Boolean getRetire_de_la_police() {
        return retire_de_la_police;
    }

    public void setRetire_de_la_police(Boolean retire_de_la_police) {
        this.retire_de_la_police = retire_de_la_police;
    }

    public Long getCodeid_retirer() {
        return codeid_retirer;
    }

    public void setCodeid_retirer(Long codeid_retirer) {
        this.codeid_retirer = codeid_retirer;
    }

    public OrclasseRefGroupe getIdGroup() {
        return idGroup;
    }

    public void setIdGroup(OrclasseRefGroupe idGroup) {
        this.idGroup = idGroup;
    }

    public OrclassPlafondMaladie getPlafondMaladie() {
        return plafondMaladie;
    }

    public void setPlafondMaladie(OrclassPlafondMaladie plafondMaladie) {
        this.plafondMaladie = plafondMaladie;
    }

    public Boolean getAfficher() {
        return afficher;
    }

    public void setAfficher(Boolean afficher) {
        this.afficher = afficher;
    }

    public String getTexte() {
        if (this.idPolicePlafond != null && this.idPolicePlafond.getId() != null && this.idPolicePlafond.getIdPlafondMaladie().getModeControle().equals(ModeControle.periode_couverture)) {
            texte = "Prestation(s) au dessous remboursable(s) à concurence de " + GlobalFonctions.formatNumberGeneral(this.idPolicePlafond.getIdPlafondMaladie().getMontant().longValue()) + " " + this.idPolicePlafond.getIdPolice().getIdDevise().getCode().toUpperCase() + " pour une periode de " + GlobalFonctions.formatNumberGeneral(this.idPolicePlafond.getIdPlafondMaladie().getPriode().longValue()) + " " + valueObject(this.idPolicePlafond.getIdPlafondMaladie().getUniteDuree()) + " " + " consécutifs appliquées";

            if (this.idPolicePlafond.getIdPlafondMaladie().getDomaine_application().equals(DomaineApplication.adherent)) {
                texte += " à l' Adherent";
            } else if (this.idPolicePlafond.getIdPlafondMaladie().getDomaine_application().equals(DomaineApplication.famille)) {
                texte += " à la Famille";
            } else if (this.idPolicePlafond.getIdPlafondMaladie().getDomaine_application().equals(DomaineApplication.groupe)) {
                texte += " au Groupe";
            } else if (this.idPolicePlafond.getIdPlafondMaladie().getDomaine_application().equals(DomaineApplication.membre)) {
                texte += " au Membre";
            } else if (this.idPolicePlafond.getIdPlafondMaladie().getDomaine_application().equals(DomaineApplication.personne)) {
                texte += " au Personne";
            } else if (this.idPolicePlafond.getIdPlafondMaladie().getDomaine_application().equals(DomaineApplication.police)) {
                texte += " à la Police";
            }else if (this.idPolicePlafond.getIdPlafondMaladie().getDomaine_application().equals(DomaineApplication.adherent_membre)) {
                String texte_initial=texte;
                texte+=" au Membre";
                texte+="\n";
                texte+=texte_initial+" à l'Adherent";
            }
        } else if (this.idPolicePlafond != null && this.idPolicePlafond.getId() != null && this.idPolicePlafond.getIdPlafondMaladie().getModeControle().equals(ModeControle.Normal)) {
            texte = "Prestation(s) au dessous remboursable(s) à concurence de " + GlobalFonctions.formatNumberGeneral(this.idPolicePlafond.getIdPlafondMaladie().getMontant().longValue()) + " " + this.idPolicePlafond.getIdPolice().getIdDevise().getCode().toUpperCase() + " pour une periode de Couverture Normal" + " " + " consécutifs appliquées";

            if (this.idPolicePlafond.getIdPlafondMaladie().getDomaine_application().equals(DomaineApplication.adherent)) {
                texte += " à l' Adherent";
            } else if (this.idPolicePlafond.getIdPlafondMaladie().getDomaine_application().equals(DomaineApplication.famille)) {
                texte += " à la Famille";
            } else if (this.idPolicePlafond.getIdPlafondMaladie().getDomaine_application().equals(DomaineApplication.groupe)) {
                texte += " au Groupe";
            } else if (this.idPolicePlafond.getIdPlafondMaladie().getDomaine_application().equals(DomaineApplication.membre)) {
                texte += " au Membre";
            } else if (this.idPolicePlafond.getIdPlafondMaladie().getDomaine_application().equals(DomaineApplication.personne)) {
                texte += " au Personne";
            } else if (this.idPolicePlafond.getIdPlafondMaladie().getDomaine_application().equals(DomaineApplication.police)) {
                texte += " à la Police";
            }else if (this.idPolicePlafond.getIdPlafondMaladie().getDomaine_application().equals(DomaineApplication.adherent_membre)) {
                String texte_initial=texte;
                texte+=" au Membre";
                texte+="\n";
              texte+=texte_initial+" à l'Adherent";
            }
        }

        return texte;
    }

    public void setTexte(String texte) {
        this.texte = texte;
    }

    public String getValueType() {
        if (this.typeDetailMaladie == null) {
            return "";
        } else {
            System.out.println("" + this.typeDetailMaladie.toString());
            return valueObject(this.typeDetailMaladie);
        }
//        return valueType;
    }

    public void setValueType(String valueType) {
        this.valueType = valueType;
    }

    public String valueObject(Object t) {
//        FacesContext ctx = FacesContext.getCurrentInstance();
        Locale myLoc = new Locale("fr");

        if (t != null) {
            return LocaleHelper.getLocaleString("langue.welcome", t.toString(), null, myLoc);
        }
        return "";
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrclassDetailPolicePlafond)) {
            return false;
        }
        OrclassDetailPolicePlafond other = (OrclassDetailPolicePlafond) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modele.OrclassDetailPolicePlafond[ id=" + id + " ]";
    }

    public static Comparator<OrclassDetailPolicePlafond> ByRubriqueASC = new Comparator<OrclassDetailPolicePlafond>() {
        public int compare(OrclassDetailPolicePlafond o1, OrclassDetailPolicePlafond o2) {
            return o1.idRubrique.getCode().compareTo(o2.idRubrique.getCode());
        }
    };
}
