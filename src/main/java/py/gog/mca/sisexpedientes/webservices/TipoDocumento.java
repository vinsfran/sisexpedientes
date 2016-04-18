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
public class TipoDocumento implements Serializable {

    private String indTipdocide;
    private String desTipdocide;

    /**
     * @return the indTipdocide
     */
    public String getIndTipdocide() {
        return indTipdocide;
    }

    /**
     * @param indTipdocide the indTipdocide to set
     */
    public void setIndTipdocide(String indTipdocide) {
        this.indTipdocide = indTipdocide;
    }

    /**
     * @return the desTipdocide
     */
    public String getDesTipdocide() {
        return desTipdocide;
    }

    /**
     * @param desTipdocide the desTipdocide to set
     */
    public void setDesTipdocide(String desTipdocide) {
        this.desTipdocide = desTipdocide;
    }
}
