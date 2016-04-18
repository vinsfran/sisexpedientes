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
public class Expediente implements Serializable{
    
    private int nroExpediente;
    private int indEjefisexp;
    private EstadoExpediente nroEstexp;
    private Dependencia codDepen;
    private int nroTitular;
    private int nroRepresentante;
    private int nroFuncionario;
    private Date fecUltmod;
    private String usuUltmod;
    private Date fecIniexp;
    private String obsExpediente;
    private int indEjefiscar;
    private Date fecAlta;
    private String usuAlta;
    private int nroCarpeta;
    private String indPrioridad;
    private int nroTarea;
    private Date fecUltmov;
    private int nroTipexp;
    private String desExpediente;
    private int nroMesent;
    private List<Movimiento> listaMovimientosDelExpediente;
    

    public Expediente() {
    }

    /**
     * @return the nroExpediente
     */
    public int getNroExpediente() {
        return nroExpediente;
    }

    /**
     * @param nroExpediente the nroExpediente to set
     */
    public void setNroExpediente(int nroExpediente) {
        this.nroExpediente = nroExpediente;
    }

    /**
     * @return the indEjefisexp
     */
    public int getIndEjefisexp() {
        return indEjefisexp;
    }

    /**
     * @param indEjefisexp the indEjefisexp to set
     */
    public void setIndEjefisexp(int indEjefisexp) {
        this.indEjefisexp = indEjefisexp;
    }

    /**
     * @return the nroEstexp
     */
    public EstadoExpediente getNroEstexp() {
        return nroEstexp;
    }

    /**
     * @param nroEstexp the nroEstexp to set
     */
    public void setNroEstexp(EstadoExpediente nroEstexp) {
        this.nroEstexp = nroEstexp;
    }

    /**
     * @return the codDepen
     */
    public Dependencia getCodDepen() {
        return codDepen;
    }

    /**
     * @param codDepen the codDepen to set
     */
    public void setCodDepen(Dependencia codDepen) {
        this.codDepen = codDepen;
    }

    /**
     * @return the nroTitular
     */
    public int getNroTitular() {
        return nroTitular;
    }

    /**
     * @param nroTitular the nroTitular to set
     */
    public void setNroTitular(int nroTitular) {
        this.nroTitular = nroTitular;
    }

    /**
     * @return the nroRepresentante
     */
    public int getNroRepresentante() {
        return nroRepresentante;
    }

    /**
     * @param nroRepresentante the nroRepresentante to set
     */
    public void setNroRepresentante(int nroRepresentante) {
        this.nroRepresentante = nroRepresentante;
    }

    /**
     * @return the nroFuncionario
     */
    public int getNroFuncionario() {
        return nroFuncionario;
    }

    /**
     * @param nroFuncionario the nroFuncionario to set
     */
    public void setNroFuncionario(int nroFuncionario) {
        this.nroFuncionario = nroFuncionario;
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
     * @return the fecIniexp
     */
    public Date getFecIniexp() {
        return fecIniexp;
    }

    /**
     * @param fecIniexp the fecIniexp to set
     */
    public void setFecIniexp(Date fecIniexp) {
        this.fecIniexp = fecIniexp;
    }

    /**
     * @return the obsExpediente
     */
    public String getObsExpediente() {
        return obsExpediente;
    }

    /**
     * @param obsExpediente the obsExpediente to set
     */
    public void setObsExpediente(String obsExpediente) {
        this.obsExpediente = obsExpediente;
    }

    /**
     * @return the indEjefiscar
     */
    public int getIndEjefiscar() {
        return indEjefiscar;
    }

    /**
     * @param indEjefiscar the indEjefiscar to set
     */
    public void setIndEjefiscar(int indEjefiscar) {
        this.indEjefiscar = indEjefiscar;
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
     * @return the nroCarpeta
     */
    public int getNroCarpeta() {
        return nroCarpeta;
    }

    /**
     * @param nroCarpeta the nroCarpeta to set
     */
    public void setNroCarpeta(int nroCarpeta) {
        this.nroCarpeta = nroCarpeta;
    }

    /**
     * @return the indPrioridad
     */
    public String getIndPrioridad() {
        return indPrioridad;
    }

    /**
     * @param indPrioridad the indPrioridad to set
     */
    public void setIndPrioridad(String indPrioridad) {
        this.indPrioridad = indPrioridad;
    }

    /**
     * @return the nroTarea
     */
    public int getNroTarea() {
        return nroTarea;
    }

    /**
     * @param nroTarea the nroTarea to set
     */
    public void setNroTarea(int nroTarea) {
        this.nroTarea = nroTarea;
    }

    /**
     * @return the fecUltmov
     */
    public Date getFecUltmov() {
        return fecUltmov;
    }

    /**
     * @param fecUltmov the fecUltmov to set
     */
    public void setFecUltmov(Date fecUltmov) {
        this.fecUltmov = fecUltmov;
    }

    /**
     * @return the nroTipexp
     */
    public int getNroTipexp() {
        return nroTipexp;
    }

    /**
     * @param nroTipexp the nroTipexp to set
     */
    public void setNroTipexp(int nroTipexp) {
        this.nroTipexp = nroTipexp;
    }

    /**
     * @return the desExpediente
     */
    public String getDesExpediente() {
        return desExpediente;
    }

    /**
     * @param desExpediente the desExpediente to set
     */
    public void setDesExpediente(String desExpediente) {
        this.desExpediente = desExpediente;
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
     * @return the listaMovimientosDelExpediente
     */
    public List<Movimiento> getListaMovimientosDelExpediente() {
        return listaMovimientosDelExpediente;
    }

    /**
     * @param listaMovimientosDelExpediente the listaMovimientosDelExpediente to set
     */
    public void setListaMovimientosDelExpediente(List<Movimiento> listaMovimientosDelExpediente) {
        this.listaMovimientosDelExpediente = listaMovimientosDelExpediente;
    }

    
}
