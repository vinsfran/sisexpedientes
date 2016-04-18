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
public class EstadoExpediente implements Serializable {
    
    private Integer nroEstexp;
    private String desEstexp;

    public EstadoExpediente() {
    }

    /**
     * @return the nroEstexp
     */
    public Integer getNroEstexp() {
        return nroEstexp;
    }

    /**
     * @param nroEstexp the nroEstexp to set
     */
    public void setNroEstexp(Integer nroEstexp) {
        this.nroEstexp = nroEstexp;
    }

    /**
     * @return the desEstexp
     */
    public String getDesEstexp() {
        return desEstexp;
    }

    /**
     * @param desEstexp the desEstexp to set
     */
    public void setDesEstexp(String desEstexp) {
        this.desEstexp = desEstexp;
    }

}
