package py.gog.mca.sisexpedientes.webservices;

import java.text.ParseException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.primefaces.json.JSONException;
import org.primefaces.json.JSONObject;
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
@Stateless
@Path("/expedientes")
public class SisExpedientesWS {

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
    

//    @POST
//    @Path("/btnBuscarPorNroExpediente")
//    @Consumes({MediaType.APPLICATION_JSON})
//    @Produces({MediaType.APPLICATION_JSON})
//    public String btnBuscarPorNroExpediente(String json) throws JSONException, ParseException {
//        //System.out.println("JSON: " + json);
//        JSONObject jsonObject = new JSONObject(json);
//        String nroExpeFormExpediente = jsonObject.get("nroExpeFormExpediente").toString();
//        String anioFormExpediente = jsonObject.get("anioFormExpediente").toString();
//        setListaExpedientes(semexpedienteCrud.listarPorNroExpedienteIndEjefisexp(Integer.parseInt(nroExpeFormExpediente), Integer.parseInt(anioFormExpediente)));
//        setSemexpediente(listaExpedientes.get(0));
//        setSempersona(sempersonaCrud.consultarPorNroPersona(getSemexpediente().getNroTitular()));
//        listaMovExpedientes = sedmovexpCrud.listarPorNroCarpetaEjerFiscal(Integer.parseInt(nroExpeFormExpediente), Integer.parseInt(anioFormExpediente));
//        
//        return tiposReclamosSB.crearTiposReclamos(tiposReclamos);
//    }
//
//    @POST
//    @Path("/actualizarTiposReclamos")
//    @Consumes({MediaType.APPLICATION_JSON})
//    @Produces({MediaType.APPLICATION_JSON})
//    public String actualizarTiposReclamos(String json) throws JSONException, ParseException {
//        JSONObject jsonObject = new JSONObject(json);
//        TiposReclamos tiposReclamos = new TiposReclamos();
//        tiposReclamos.setFkCodDependencia(new Dependencias());
//        tiposReclamos.setCodTipoReclamo(jsonObject.getInt("codTipoReclamo"));
//        tiposReclamos.setNombreTipoReclamo(jsonObject.get("nombreTipoReclamo").toString());
//        tiposReclamos.setDiasMaximoPendientes(jsonObject.getInt("diasMaximoPendientes"));
//        tiposReclamos.setDiasMaximoFinalizados(jsonObject.getInt("diasMaximoFinalizados"));
//        tiposReclamos.getFkCodDependencia().setCodDependencia(jsonObject.getInt("codDependencia"));
//        return tiposReclamosSB.actualizarTiposReclamos(tiposReclamos);
//    }
//
//    @POST
//    @Path("/consultarTiposReclamos")
//    @Consumes({MediaType.APPLICATION_JSON})
//    @Produces({MediaType.APPLICATION_JSON})
//    public TiposReclamos consultarTiposReclamos(String json) throws JSONException, ParseException {
//        JSONObject jsonObject = new JSONObject(json);
//        TiposReclamos tiposReclamos = tiposReclamosSB.consultarTipoReclamo(jsonObject.getInt("codTipoReclamo"));
//        return tiposReclamos;
//    }

    @GET
    @Path("/listarMovimientos")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Sedmovexp> listarMovimientos() {
        
        setListaMovExpedientes(sedmovexpCrud.listarPorNroCarpetaEjerFiscal(9737, 2016));
        
        return listaMovExpedientes;
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
     * @return the listaTipoDocumentos
     */
    public List<Sebtipdocide> getListaTipoDocumentos() {
        return listaTipoDocumentos;
    }

    /**
     * @param listaTipoDocumentos the listaTipoDocumentos to set
     */
    public void setListaTipoDocumentos(List<Sebtipdocide> listaTipoDocumentos) {
        this.listaTipoDocumentos = listaTipoDocumentos;
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
}
