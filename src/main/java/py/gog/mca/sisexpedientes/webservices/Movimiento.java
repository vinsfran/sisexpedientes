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
public class Movimiento implements Serializable {

    private int nroSecuencia;
    private int nroExpediente;
    private int indEjefisexp;
    private int nroCarpeta;
    private int indEjefiscar;
    private Date fecMovexp;
    private TipoMovimiento nroTipmov;
    private int nroMesent;
    private Dependencia codDepen;
    private int nroFuncionario;
    private int nroTarea;
    private EstadoExpediente nroEstexp;
    private String usuAlta;
    private Date fecAlta;

    public Movimiento() {
    }

    /**
     * @return the nroSecuencia
     */
    public int getNroSecuencia() {
        return nroSecuencia;
    }

    /**
     * @param nroSecuencia the nroSecuencia to set
     */
    public void setNroSecuencia(int nroSecuencia) {
        this.nroSecuencia = nroSecuencia;
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
     * @return the fecMovexp
     */
    public Date getFecMovexp() {
        return fecMovexp;
    }

    /**
     * @param fecMovexp the fecMovexp to set
     */
    public void setFecMovexp(Date fecMovexp) {
        this.fecMovexp = fecMovexp;
    }

    /**
     * @return the nroTipmov
     */
    public TipoMovimiento getNroTipmov() {
        return nroTipmov;
    }

    /**
     * @param nroTipmov the nroTipmov to set
     */
    public void setNroTipmov(TipoMovimiento nroTipmov) {
        this.nroTipmov = nroTipmov;
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

    

}
