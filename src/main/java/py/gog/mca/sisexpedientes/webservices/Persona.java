/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.gog.mca.sisexpedientes.webservices;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 *
 * @author vinsfran
 */
public class Persona implements Serializable{
    
    private String nroDocide;
    private TipoDocumento sebtipdocide;
    private String obsPersona;
    private String indTipper;
    private String emailPrincipal;
    private String indSexo;
    private String usuAlta;
    private String telPrincipal;
    private Date fecUltmod;
    private String nomFantasia;
    private String usuUltmod;
    private String desPersona;
    private String dirPrincipal;
    private String indEstciv;
    private Date fecAlta;
    private Date fecNaccon;
    private String indTipsoc;
    private String indActivo;
    private List<Expediente> listaExpedientesDelTitular;
    private List<Expediente> listaExpedientesDelRepresentante;
    private List<Expediente> listaExpedientesDelFuncionario;
    private List<Movimiento> listaMovimientosDelFuncionario;

    public Persona() {
    }
    
    /**
     * @return the nroDocide
     */
    public String getNroDocide() {
        return nroDocide;
    }

    /**
     * @param nroDocide the nroDocide to set
     */
    public void setNroDocide(String nroDocide) {
        this.nroDocide = nroDocide;
    }

    /**
     * @return the sebtipdocide
     */
    public TipoDocumento getSebtipdocide() {
        return sebtipdocide;
    }

    /**
     * @param sebtipdocide the sebtipdocide to set
     */
    public void setSebtipdocide(TipoDocumento sebtipdocide) {
        this.sebtipdocide = sebtipdocide;
    }

    /**
     * @return the obsPersona
     */
    public String getObsPersona() {
        return obsPersona;
    }

    /**
     * @param obsPersona the obsPersona to set
     */
    public void setObsPersona(String obsPersona) {
        this.obsPersona = obsPersona;
    }

    /**
     * @return the indTipper
     */
    public String getIndTipper() {
        return indTipper;
    }

    /**
     * @param indTipper the indTipper to set
     */
    public void setIndTipper(String indTipper) {
        this.indTipper = indTipper;
    }

    /**
     * @return the emailPrincipal
     */
    public String getEmailPrincipal() {
        return emailPrincipal;
    }

    /**
     * @param emailPrincipal the emailPrincipal to set
     */
    public void setEmailPrincipal(String emailPrincipal) {
        this.emailPrincipal = emailPrincipal;
    }

    /**
     * @return the indSexo
     */
    public String getIndSexo() {
        return indSexo;
    }

    /**
     * @param indSexo the indSexo to set
     */
    public void setIndSexo(String indSexo) {
        this.indSexo = indSexo;
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
     * @return the telPrincipal
     */
    public String getTelPrincipal() {
        return telPrincipal;
    }

    /**
     * @param telPrincipal the telPrincipal to set
     */
    public void setTelPrincipal(String telPrincipal) {
        this.telPrincipal = telPrincipal;
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

    /**
     * @return the nomFantasia
     */
    public String getNomFantasia() {
        return nomFantasia;
    }

    /**
     * @param nomFantasia the nomFantasia to set
     */
    public void setNomFantasia(String nomFantasia) {
        this.nomFantasia = nomFantasia;
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
     * @return the desPersona
     */
    public String getDesPersona() {
        return desPersona;
    }

    /**
     * @param desPersona the desPersona to set
     */
    public void setDesPersona(String desPersona) {
        this.desPersona = desPersona;
    }

    /**
     * @return the dirPrincipal
     */
    public String getDirPrincipal() {
        return dirPrincipal;
    }

    /**
     * @param dirPrincipal the dirPrincipal to set
     */
    public void setDirPrincipal(String dirPrincipal) {
        this.dirPrincipal = dirPrincipal;
    }

    /**
     * @return the indEstciv
     */
    public String getIndEstciv() {
        return indEstciv;
    }

    /**
     * @param indEstciv the indEstciv to set
     */
    public void setIndEstciv(String indEstciv) {
        this.indEstciv = indEstciv;
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
     * @return the fecNaccon
     */
    public Date getFecNaccon() {
        return fecNaccon;
    }

    /**
     * @param fecNaccon the fecNaccon to set
     */
    public void setFecNaccon(Date fecNaccon) {
        this.fecNaccon = fecNaccon;
    }

    /**
     * @return the indTipsoc
     */
    public String getIndTipsoc() {
        return indTipsoc;
    }

    /**
     * @param indTipsoc the indTipsoc to set
     */
    public void setIndTipsoc(String indTipsoc) {
        this.indTipsoc = indTipsoc;
    }

    /**
     * @return the indActivo
     */
    public String getIndActivo() {
        return indActivo;
    }

    /**
     * @param indActivo the indActivo to set
     */
    public void setIndActivo(String indActivo) {
        this.indActivo = indActivo;
    }

    /**
     * @return the listaExpedientesDelTitular
     */
    public List<Expediente> getListaExpedientesDelTitular() {
        return listaExpedientesDelTitular;
    }

    /**
     * @param listaExpedientesDelTitular the listaExpedientesDelTitular to set
     */
    public void setListaExpedientesDelTitular(List<Expediente> listaExpedientesDelTitular) {
        this.listaExpedientesDelTitular = listaExpedientesDelTitular;
    }

    /**
     * @return the listaExpedientesDelRepresentante
     */
    public List<Expediente> getListaExpedientesDelRepresentante() {
        return listaExpedientesDelRepresentante;
    }

    /**
     * @param listaExpedientesDelRepresentante the listaExpedientesDelRepresentante to set
     */
    public void setListaExpedientesDelRepresentante(List<Expediente> listaExpedientesDelRepresentante) {
        this.listaExpedientesDelRepresentante = listaExpedientesDelRepresentante;
    }

    /**
     * @return the listaExpedientesDelFuncionario
     */
    public List<Expediente> getListaExpedientesDelFuncionario() {
        return listaExpedientesDelFuncionario;
    }

    /**
     * @param listaExpedientesDelFuncionario the listaExpedientesDelFuncionario to set
     */
    public void setListaExpedientesDelFuncionario(List<Expediente> listaExpedientesDelFuncionario) {
        this.listaExpedientesDelFuncionario = listaExpedientesDelFuncionario;
    }

    /**
     * @return the listaMovimientosDelFuncionario
     */
    public List<Movimiento> getListaMovimientosDelFuncionario() {
        return listaMovimientosDelFuncionario;
    }

    /**
     * @param listaMovimientosDelFuncionario the listaMovimientosDelFuncionario to set
     */
    public void setListaMovimientosDelFuncionario(List<Movimiento> listaMovimientosDelFuncionario) {
        this.listaMovimientosDelFuncionario = listaMovimientosDelFuncionario;
    }

  


    
}
