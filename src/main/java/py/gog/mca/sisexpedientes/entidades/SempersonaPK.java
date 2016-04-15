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
import javax.validation.constraints.Size;

/**
 *
 * @author vinsfran
 */
@Embeddable
public class SempersonaPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "nro_docide")
    private String nroDocide;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "ind_tipdocide")
    private String indTipdocide;

    public SempersonaPK() {
    }

    public SempersonaPK(String nroDocide, String indTipdocide) {
        this.nroDocide = nroDocide;
        this.indTipdocide = indTipdocide;
    }

    public String getNroDocide() {
        return nroDocide;
    }

    public void setNroDocide(String nroDocide) {
        this.nroDocide = nroDocide;
    }

    public String getIndTipdocide() {
        return indTipdocide;
    }

    public void setIndTipdocide(String indTipdocide) {
        this.indTipdocide = indTipdocide;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nroDocide != null ? nroDocide.hashCode() : 0);
        hash += (indTipdocide != null ? indTipdocide.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SempersonaPK)) {
            return false;
        }
        SempersonaPK other = (SempersonaPK) object;
        if ((this.nroDocide == null && other.nroDocide != null) || (this.nroDocide != null && !this.nroDocide.equals(other.nroDocide))) {
            return false;
        }
        if ((this.indTipdocide == null && other.indTipdocide != null) || (this.indTipdocide != null && !this.indTipdocide.equals(other.indTipdocide))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "py.gog.mca.sisexpedientes.entidades.SempersonaPK[ nroDocide=" + nroDocide + ", indTipdocide=" + indTipdocide + " ]";
    }
    
}
