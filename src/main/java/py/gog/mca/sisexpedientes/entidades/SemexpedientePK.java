/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.gog.mca.sisexpedientes.entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author vinsfran
 */
@Embeddable
public class SemexpedientePK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "nro_expediente")
    private int nroExpediente;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ind_ejefisexp")
    private int indEjefisexp;

    public SemexpedientePK() {
    }

    public SemexpedientePK(int nroExpediente, int indEjefisexp) {
        this.nroExpediente = nroExpediente;
        this.indEjefisexp = indEjefisexp;
    }

    public int getNroExpediente() {
        return nroExpediente;
    }

    public void setNroExpediente(int nroExpediente) {
        this.nroExpediente = nroExpediente;
    }

    public int getIndEjefisexp() {
        return indEjefisexp;
    }

    public void setIndEjefisexp(int indEjefisexp) {
        this.indEjefisexp = indEjefisexp;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) nroExpediente;
        hash += (int) indEjefisexp;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SemexpedientePK)) {
            return false;
        }
        SemexpedientePK other = (SemexpedientePK) object;
        if (this.nroExpediente != other.nroExpediente) {
            return false;
        }
        if (this.indEjefisexp != other.indEjefisexp) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "py.gog.mca.sisexpedientes.entidades.SemexpedientePK[ nroExpediente=" + nroExpediente + ", indEjefisexp=" + indEjefisexp + " ]";
    }
    
}
