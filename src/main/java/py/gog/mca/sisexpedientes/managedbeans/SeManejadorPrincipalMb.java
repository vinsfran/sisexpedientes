/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.gog.mca.sisexpedientes.managedbeans;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import py.gog.mca.sisexpedientes.crud.SebtipdocideCrud;
import py.gog.mca.sisexpedientes.crud.SedmovexpCrud;
import py.gog.mca.sisexpedientes.crud.SemexpedienteCrud;
import py.gog.mca.sisexpedientes.crud.SempersonaCrud;
import py.gog.mca.sisexpedientes.entidades.Sebtipdocide;
import py.gog.mca.sisexpedientes.entidades.Sedmovexp;
import py.gog.mca.sisexpedientes.entidades.Semexpediente;
import py.gog.mca.sisexpedientes.entidades.Sempersona;

/**
 *
 * @author vinsfran
 */
@ManagedBean(name = "seManejadorPrincipalMb")
@SessionScoped
public class SeManejadorPrincipalMb implements Serializable {

    @Inject
    private SedmovexpCrud sedmovexpCrud;
    @Inject
    private SempersonaCrud sempersonaCrud;
    @Inject
    private SemexpedienteCrud semexpedienteCrud;
    @Inject
    private SebtipdocideCrud sebtipdocideCrud;

    private List<Sempersona> listaPersonas;
    private List<Semexpediente> listaExpedientes;
    private List<Sedmovexp> listaMovExpedientes;
    private List<Sebtipdocide> listaTipoDocumentos;

    private Sempersona sempersona;
    private Semexpediente semexpediente;

    private String cedulaFormPersona;
    private String tipoDocFormPersona;
    private String anioActual;
    private String nroExpeFormExpediente;
    private String anioFormExpediente;
    private boolean mostrarBtnVolverListaExpedientes;

    @PostConstruct
    public void init() {
        this.cedulaFormPersona = "";
        this.tipoDocFormPersona = "";
        this.nroExpeFormExpediente = "";
        this.anioFormExpediente = "";
    }

    public SeManejadorPrincipalMb() {

    }

    public String menuPrincipal(String pagina) {
        this.cedulaFormPersona = "";
        this.tipoDocFormPersona = "";
        this.nroExpeFormExpediente = "";
        this.anioFormExpediente = "";
        listaTipoDocumentos = sebtipdocideCrud.listarTodo();
        return pagina;
    }

    public String btnBuscarPorNroExpediente() {
        mostrarBtnVolverListaExpedientes = false;
        listaExpedientes = semexpedienteCrud.listarPorNroExpedienteIndEjefisexp(Integer.parseInt(nroExpeFormExpediente), Integer.parseInt(anioFormExpediente));
        semexpediente = listaExpedientes.get(0);
        sempersona = semexpediente.getNroTitular();
        //listaMovExpedientes = sedmovexpCrud.listarPorNroCarpetaEjerFiscal(Integer.parseInt(nroExpeFormExpediente), Integer.parseInt(anioFormExpediente));
        listaMovExpedientes = listaExpedientes.get(0).getSedmovexpList();
        return "movimientos_expe";
    }

    public String btnBuscarPorCedulaTipoDoc() {
        if (cedulaFormPersona.equals("0")) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "No existe persona", ""));
            return "index";
        } else {
            listaPersonas = sempersonaCrud.listarPorNroDocideIndTipdocide(cedulaFormPersona, tipoDocFormPersona);
            if (listaPersonas == null) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "No existe persona", ""));
                return "index";
            } else if (listaPersonas.size() > 1) {
                return "personas";
            } else {
                sempersona = listaPersonas.get(0);
                //listaExpedientes = semexpedienteCrud.listarPorNroTitular(sempersona.getNroPersona());
                //sempersona.setSemexpedienteListNroTitular(semexpedienteCrud.listarPorNroTitular(sempersona.getNroPersona()));
                listaExpedientes = sempersona.getSemexpedienteListNroTitular();
                if (listaExpedientes == null) {
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "No tiene expedientes", ""));
                    return "index";
                } else if (listaExpedientes.size() > 1) {
                    mostrarBtnVolverListaExpedientes = true;
                    return "expedientes";
                } else {
                    mostrarBtnVolverListaExpedientes = false;
                    semexpediente = listaExpedientes.get(0);
                    //listaMovExpedientes = sedmovexpCrud.listarPorNroCarpetaEjerFiscal(semexpediente.getNroCarpeta(), semexpediente.getIndEjefiscar());
                    listaMovExpedientes = semexpediente.getSedmovexpList();
                    return "movimientos_expe";
                }
            }
        }
    }

    public String btnSeleccionarPersona(Integer nroTitular) {
        for (Sempersona listaPersona : listaPersonas) {
            if (listaPersona.getNroPersona() == nroTitular) {
                sempersona = listaPersona;
                listaExpedientes = sempersona.getSemexpedienteListNroFuncionario();
            }
        }
        //listaExpedientes = semexpedienteCrud.listarPorNroTitular(nroTitular);
        return "expedientes";
    }

    public String btnSeleccionarExpediente(Integer nroCarpeta, Integer ejerFiscal) {
        for (Semexpediente listaExpediente : listaExpedientes) {
            if (listaExpediente.getNroCarpeta() == nroCarpeta && listaExpediente.getIndEjefiscar() == ejerFiscal) {
                semexpediente = listaExpediente;
            }
        }
        listaMovExpedientes = sedmovexpCrud.listarPorNroCarpetaEjerFiscal(nroCarpeta, ejerFiscal);
        return "movimientos_expe";
    }

    /**
     * @return the listaMovExpedientes
     */
    public List<Sedmovexp> getListaMovExpedientes() {
        return listaMovExpedientes;
    }

    /**
     * @param listaMovExpedientes the listaMovExpedientes to set
     */
    public void setListaMovExpedientes(List<Sedmovexp> listaMovExpedientes) {
        this.listaMovExpedientes = listaMovExpedientes;
    }

    /**
     * @return the listaPersonas
     */
    public List<Sempersona> getListaPersonas() {
        return listaPersonas;
    }

    /**
     * @param listaPersonas the listaPersonas to set
     */
    public void setListaPersonas(List<Sempersona> listaPersonas) {
        this.listaPersonas = listaPersonas;
    }

    /**
     * @return the listaExpedientes
     */
    public List<Semexpediente> getListaExpedientes() {
        return listaExpedientes;
    }

    /**
     * @param listaExpedientes the listaExpedientes to set
     */
    public void setListaExpedientes(List<Semexpediente> listaExpedientes) {
        this.listaExpedientes = listaExpedientes;
    }

    /**
     * @return the cedulaFormPersona
     */
    public String getCedulaFormPersona() {
        return cedulaFormPersona;
    }

    /**
     * @param cedulaFormPersona the cedulaFormPersona to set
     */
    public void setCedulaFormPersona(String cedulaFormPersona) {
        this.cedulaFormPersona = cedulaFormPersona;
    }

    /**
     * @return the listaTipoDocumentos
     */
    public List<Sebtipdocide> getListaTipoDocumentos() {
        listaTipoDocumentos = sebtipdocideCrud.listarTodo();
        return listaTipoDocumentos;
    }

    /**
     * @param listaTipoDocumentos the listaTipoDocumentos to set
     */
    public void setListaTipoDocumentos(List<Sebtipdocide> listaTipoDocumentos) {
        this.listaTipoDocumentos = listaTipoDocumentos;
    }

    /**
     * @return the tipoDocFormPersona
     */
    public String getTipoDocFormPersona() {
        return tipoDocFormPersona;
    }

    /**
     * @param tipoDocFormPersona the tipoDocFormPersona to set
     */
    public void setTipoDocFormPersona(String tipoDocFormPersona) {
        this.tipoDocFormPersona = tipoDocFormPersona;
    }

    /**
     * @return the anioActual
     */
    public String getAnioActual() {
        Calendar c = Calendar.getInstance();
        anioActual = Integer.toString(c.get(Calendar.YEAR));
        return anioActual;
    }

    /**
     * @param anioActual the anioActual to set
     */
    public void setAnioActual(String anioActual) {
        this.anioActual = anioActual;
    }

    /**
     * @return the nroExpeFormExpediente
     */
    public String getNroExpeFormExpediente() {
        return nroExpeFormExpediente;
    }

    /**
     * @param nroExpeFormExpediente the nroExpeFormExpediente to set
     */
    public void setNroExpeFormExpediente(String nroExpeFormExpediente) {
        this.nroExpeFormExpediente = nroExpeFormExpediente;
    }

    /**
     * @return the anioFormExpediente
     */
    public String getAnioFormExpediente() {
        return anioFormExpediente;
    }

    /**
     * @param anioFormExpediente the anioFormExpediente to set
     */
    public void setAnioFormExpediente(String anioFormExpediente) {
        this.anioFormExpediente = anioFormExpediente;
    }

    /**
     * @return the sempersona
     */
    public Sempersona getSempersona() {
        return sempersona;
    }

    /**
     * @param sempersona the sempersona to set
     */
    public void setSempersona(Sempersona sempersona) {
        this.sempersona = sempersona;
    }

    /**
     * @return the semexpediente
     */
    public Semexpediente getSemexpediente() {
        return semexpediente;
    }

    /**
     * @param semexpediente the semexpediente to set
     */
    public void setSemexpediente(Semexpediente semexpediente) {
        this.semexpediente = semexpediente;
    }

    /**
     * @return the mostrarBtnVolverListaExpedientes
     */
    public boolean isMostrarBtnVolverListaExpedientes() {
        return mostrarBtnVolverListaExpedientes;
    }

    /**
     * @param mostrarBtnVolverListaExpedientes the mostrarBtnVolverListaExpedientes to set
     */
    public void setMostrarBtnVolverListaExpedientes(boolean mostrarBtnVolverListaExpedientes) {
        this.mostrarBtnVolverListaExpedientes = mostrarBtnVolverListaExpedientes;
    }

}
