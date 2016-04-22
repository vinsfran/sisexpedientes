package py.gog.mca.sisexpedientes.webservices;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
import py.gog.mca.sisexpedientes.utiles.EnviarCorreos;

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

    @EJB
    private EnviarCorreos enviarCorreos;

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
    @Path(value = "/listarExpedientesPorNroDocideIndTipdocide")
    @Consumes(value = {MediaType.APPLICATION_JSON})
    @Produces(value = {MediaType.APPLICATION_JSON})
    public List<Semexpediente> listarExpedientesPorNroDocideIndTipdocide(String json) throws JSONException, ParseException {
        JSONObject jsonObject = new JSONObject(json);
        listaPersonas = doListarPersonasPorNroDocideIndTipdocide(jsonObject.getString("nroDocide"), jsonObject.getString("indTipdocide"));
        listaExpedientes = new ArrayList<>();
        if(listaPersonas != null){
            listaExpedientes = semexpedienteCrud.listarPorNroTitular(listaPersonas.get(0).getNroPersona());
            if(listaExpedientes == null){
                listaExpedientes = new ArrayList<>();
            }
        }
        return listaExpedientes;
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
        System.out.println("JSON: " + json);
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

    @POST
    @Path(value = "/enviarCorreo")
    @Consumes(value = {MediaType.APPLICATION_JSON})
    @Produces(value = {MediaType.APPLICATION_JSON})
    public String enviarCorreo(String json) throws JSONException, ParseException {
        SimpleDateFormat diaMesAnio = new SimpleDateFormat("dd/MM/yyyy");
        JSONObject jsonObject = new JSONObject(json);
        String mail = jsonObject.getString("mail");
        Integer nroCarpeta = jsonObject.getInt("nroCarpeta");
        Integer indEjefiscar = jsonObject.getInt("indEjefiscar");
        listaMovExpedientes = doListarMovimientosPorNroCarpetaEjerFiscar(nroCarpeta, indEjefiscar);

        String asunto = "RESPUESTA SOBRE EXPEDIENTE: " + nroCarpeta + "/" + indEjefiscar;
        String mensaje = "<html>"
                + "     <head>"
                + "         <meta charset=\"UTF-8\">"
                + "         <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n"
                + "     </head>"
                + "     <body style='background-color: #ffffff'>"
                + "       <div style='text-align: center;'>"
                + "            <img alt='logo' src=\"http://appserver.mca.gov.py/reclamosmca/faces/resources/images/logo_3.jpg\"> "
                + "       </div> "
                + "       <div> "
                + "             <p>"
                + "                Estimado/a: <i>" + mail + "</i>"
                + "             </p> "
                + "             <p>"
                + "                Le informamos que su expediente se encuentra en la siguiente situación: "
                + "             </p> "
                + "<table align=\"center\" cellpadding=\"0\" cellspacing=\"0\">\n"
                + "                <thead >\n"
                + "                    <tr style=\"background-color: #699f39\" >\n"
                + "                        <th style=\"color: #ffffff\" colspan=\"3\">\n"
                + "                            <span>Resultado de la busqueda</span>\n"
                + "                        </th>\n"
                + "                    </tr>\n"
                + "                    <tr>\n"
                + "                        <td colspan=\"3\">\n"
                + "                            <table width=\"100%\" border=\"0\">\n"
                + "                                <tr>\n"
                + "                                    <td><strong>N° Exp. / Año:&nbsp;</strong></td>\n"
                + "                                    <td>" + listaMovExpedientes.get(0).getNroExpediente().getNroCarpeta() + " / " + listaMovExpedientes.get(0).getNroExpediente().getIndEjefiscar() + "</td>\n"
                + "                                </tr>\n"
                + "                                <tr>\n"
                + "                                    <td><strong>Nro. Documento:&nbsp;</strong></td>\n"
                + "                                    <td>" + listaMovExpedientes.get(0).getNroExpediente().getNroTitular().getNroDocide() + "</td>\n"
                + "                                </tr>\n"
                + "                                <tr>\n"
                + "                                    <td><strong>Recurrente:&nbsp;</strong></td>\n"
                + "                                    <td>" + listaMovExpedientes.get(0).getNroExpediente().getNroTitular().getDesPersona() + "</td>\n"
                + "                                </tr>\n"
                + "                                <tr>\n"
                + "                                    <td><strong>Des. Exp.:&nbsp;</strong></td>\n"
                + "                                    <td>" + listaMovExpedientes.get(0).getNroExpediente().getDesExpediente() + "</td>\n"
                + "                                </tr>\n"
                + "                                <tr>\n"
                + "                                    <td><strong>Estado:&nbsp;</strong></td>\n"
                + "                                    <td>" + listaMovExpedientes.get(0).getNroExpediente().getNroEstexp().getDesEstexp() + "</td>\n"
                + "                                </tr>\n"
                + "                            </table>\n"
                + "                        </td>\n"
                + "                    </tr>\n"
                + "                    <tr style=\"background-color: #699f39\" >\n"
                + "                        <th style=\"color: #ffffff\" colspan=\"3\">\n"
                + "                            <span>Movimientos del Expediente</span>\n"
                + "                        </th>\n"
                + "                    </tr>\n"
                + "                    <tr style=\"background-color: #8bc34a\">\n"
                + "                        <th style=\"color: #ffffff\">\n"
                + "                            <span>Dependencia</span>\n"
                + "                        </th>\n"
                + "                        <th style=\"color: #ffffff\">\n"
                + "                            <span>Movimiento</span>\n"
                + "                        </th>\n"
                + "                        <th style=\"color: #ffffff\">\n"
                + "                            <span>Fecha</span>\n"
                + "                        </th>\n"
                + "                    </tr>\n"
                + "                </thead>\n"
                + "                <tbody >\n";

        for (int i = 0; i < listaMovExpedientes.size(); i++) {
            mensaje = mensaje
                    + " <tr >\n"
                    + "   <td >" + listaMovExpedientes.get(i).getCodDepen().getDesDepen() + "&nbsp;</td>\n"
                    + "   <td>" + listaMovExpedientes.get(i).getNroTipmov().getDesTipmov() + "&nbsp;</td>\n"
                    + "   <td >" + diaMesAnio.format(listaMovExpedientes.get(i).getFecMovexp()) + "&nbsp;</td>\n"
                    + " </tr>\n";
        }

        mensaje = mensaje
                + "                </tbody>\n"
                + "            </table>"
                + "             <p>"
                + "                Gracias por utilizar el Sistema de Consultas de Expedientes de la Municipalidad de Asunción."
                + "             </p>"
                + "        </div>"
                + "     </body>"
                + "</html>";

        mensaje = enviarCorreos.enviarMail(jsonObject.getString("mail"), asunto, mensaje);
        if (mensaje.equals("OK")) {
            return "{\"status\":\"OK\", \"mensaje\":\"Correo enviado.\"}";
        } else {
            return "{\"status\":\"ERROR\", \"mensaje\":\"" + mensaje + "\"}";
        }
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
