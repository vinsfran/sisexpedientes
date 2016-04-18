package py.gog.mca.sisexpedientes.webservices;

import java.text.ParseException;
import java.util.List;
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

    @POST
    @Path(value = "/listarPersonasPorNroDocideIndTipdocide")
    @Consumes(value = {MediaType.APPLICATION_JSON})
    @Produces(value = {MediaType.APPLICATION_JSON})
    public List<Sempersona> listarPersonasPorNroDocideIndTipdocide(String json) throws JSONException, ParseException {
        JSONObject jsonObject = new JSONObject(json);
        return doListarPersonasPorNroDocideIndTipdocide(jsonObject.getString("nroDocide"), jsonObject.getString("indTipdocide"));
    }

    @POST
    @Path(value = "/listarExpedientesPorNroExpIndEjefisexp")
    @Consumes(value = {MediaType.APPLICATION_JSON})
    @Produces(value = {MediaType.APPLICATION_JSON})
    public List<Semexpediente> listarExpedientesPorNroExpIndEjefisexp(String json) throws JSONException, ParseException {
        JSONObject jsonObject = new JSONObject(json);
        return doListarExpedientesPorNroExpIndEjefisexp(jsonObject.getInt("nroExpediente"), jsonObject.getInt("indEjefisexp"));
    }

    @POST
    @Path(value = "/listarMovimientosPorNroCarpetaEjerFiscar")
    @Consumes(value = {MediaType.APPLICATION_JSON})
    @Produces(value = {MediaType.APPLICATION_JSON})
    public List<Sedmovexp> listarMovimientosPorNroCarpetaEjerFiscar(String json) throws JSONException, ParseException {
        JSONObject jsonObject = new JSONObject(json);
        return doListarMovimientosPorNroCarpetaEjerFiscar(jsonObject.getInt("nroCarpeta"), jsonObject.getInt("indEjefiscar"));
    }

    @GET
    @Path(value = "/listarPersonas")
    @Produces(value = {MediaType.APPLICATION_JSON})
    public List<Sempersona> listarPersonas() {
        return doListarPersonasPorNroDocideIndTipdocide("1682320", "CIPN");
    }

    @GET
    @Path(value = "/listarExpedientes")
    @Produces(value = {MediaType.APPLICATION_JSON})
    public List<Semexpediente> listarExpedientes() {
        return doListarExpedientesPorNroExpIndEjefisexp(9737, 2016);
    }

    @GET
    @Path(value = "/listarMovimientos")
    @Produces(value = {MediaType.APPLICATION_JSON})
    public List<Sedmovexp> listarMovimientos() {
        return doListarMovimientosPorNroCarpetaEjerFiscar(9737, 2016);
    }
    
    private List<Sempersona> doListarPersonasPorNroDocideIndTipdocide(String nroDocide, String indTipdocide) {
        listaPersonas = sempersonaCrud.listarPorNroDocideIndTipdocide(nroDocide, indTipdocide);
        return listaPersonas;
    }
    
    private List<Semexpediente> doListarExpedientesPorNroExpIndEjefisexp(Integer nroExpediente, Integer indEjefisexp) {
        listaExpedientes = semexpedienteCrud.listarPorNroExpedienteIndEjefisexp(nroExpediente, indEjefisexp);
        return listaExpedientes;
    }
    
    private List<Sedmovexp> doListarMovimientosPorNroCarpetaEjerFiscar(Integer nroCarpeta, Integer indEjefiscar) {
        listaMovExpedientes = sedmovexpCrud.listarPorNroCarpetaEjerFiscal(nroCarpeta, indEjefiscar);
        return listaMovExpedientes;
    }

}
