/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.gog.mca.sisexpedientes.webservices;

import java.io.Serializable;

/**
 *
 * @author vinsfran
 */
public class TipoMovimiento implements Serializable {
    
    private Integer nroTipmov;
    private String desTipmov;

    public TipoMovimiento() {
    }

    /**
     * @return the nroTipmov
     */
    public Integer getNroTipmov() {
        return nroTipmov;
    }

    /**
     * @param nroTipmov the nroTipmov to set
     */
    public void setNroTipmov(Integer nroTipmov) {
        this.nroTipmov = nroTipmov;
    }

    /**
     * @return the desTipmov
     */
    public String getDesTipmov() {
        return desTipmov;
    }

    /**
     * @param desTipmov the desTipmov to set
     */
    public void setDesTipmov(String desTipmov) {
        this.desTipmov = desTipmov;
    }
}
