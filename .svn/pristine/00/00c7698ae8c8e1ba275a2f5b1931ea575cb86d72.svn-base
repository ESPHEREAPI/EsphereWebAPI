/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author hp
 */
@Embeddable
public class OrclassEntreprisesModulesPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_MODULE")
    private short idModule;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_ENTREPRISE")
    private short idEntreprise;

    public OrclassEntreprisesModulesPK() {
    }

    public OrclassEntreprisesModulesPK(short idModule, short idEntreprise) {
        this.idModule = idModule;
        this.idEntreprise = idEntreprise;
    }

    public short getIdModule() {
        return idModule;
    }

    public void setIdModule(short idModule) {
        this.idModule = idModule;
    }

    public short getIdEntreprise() {
        return idEntreprise;
    }

    public void setIdEntreprise(short idEntreprise) {
        this.idEntreprise = idEntreprise;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idModule;
        hash += (int) idEntreprise;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrclassEntreprisesModulesPK)) {
            return false;
        }
        OrclassEntreprisesModulesPK other = (OrclassEntreprisesModulesPK) object;
        if (this.idModule != other.idModule) {
            return false;
        }
        if (this.idEntreprise != other.idEntreprise) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modele.OrclassEntreprisesModulesPK[ idModule=" + idModule + ", idEntreprise=" + idEntreprise + " ]";
    }
    
}
