/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.gog.mca.sisexpedientes.webservices;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author vinsfran
 */
public class Dependencia implements Serializable {

    private String codDepen;
    private String desDepen;
    private int nroMesent;
    private String usuAlta;
    private Date fecAlta;
    private String usuUltmod;
    private Date fecUltmod;

    /**
     * @return the codDepen
     */
    public String getCodDepen() {
        return codDepen;
    }

    /**
     * @param codDepen the codDepen to set
     */
    public void setCodDepen(String codDepen) {
        this.codDepen = codDepen;
    }

    /**
     * @return the desDepen
     */
    public String getDesDepen() {
        return desDepen;
    }

    /**
     * @param desDepen the desDepen to set
     */
    public void setDesDepen(String desDepen) {
        this.desDepen = desDepen;
    }

    /**
     * @return the nroMesent
     */
    public int getNroMesent() {
        return nroMesent;
    }

    /**
     * @param nroMesent the nroMesent to set
     */
    public void setNroMesent(int nroMesent) {
        this.nroMesent = nroMesent;
    }

    /**
     * @return the usuAlta
     */
    public String getUsuAlta() {
        return usuAlta;
    }

    /**
     * @param usuAlta the usuAlta to set
     */
    public void setUsuAlta(String usuAlta) {
        this.usuAlta = usuAlta;
    }

    /**
     * @return the fecAlta
     */
    public Date getFecAlta() {
        return fecAlta;
    }

    /**
     * @param fecAlta the fecAlta to set
     */
    public void setFecAlta(Date fecAlta) {
        this.fecAlta = fecAlta;
    }

    /**
     * @return the usuUltmod
     */
    public String getUsuUltmod() {
        return usuUltmod;
    }

    /**
     * @param usuUltmod the usuUltmod to set
     */
    public void setUsuUltmod(String usuUltmod) {
        this.usuUltmod = usuUltmod;
    }

    /**
     * @return the fecUltmod
     */
    public Date getFecUltmod() {
        return fecUltmod;
    }

    /**
     * @param fecUltmod the fecUltmod to set
     */
    public void setFecUltmod(Date fecUltmod) {
        this.fecUltmod = fecUltmod;
    }
    
}
