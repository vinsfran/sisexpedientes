package py.gog.mca.sisexpedientes.webservices;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
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
    @Path("/listarPersonas")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Sempersona> listarPersonas() {
        listaPersonas = sempersonaCrud.listarPorNroDocideIndTipdocide("3834015", "CIPN");
        
        List<Sempersona> listarPersonaAux = sempersonaCrud.listarPorNroDocideIndTipdocide("3834015", "CIPN");

        setListaPersonas(sempersonaCrud.listarPorNroDocideIndTipdocide("3834015", "CIPN"));
        List<Persona> listaPer = new ArrayList<>();
        for (int i = 0; i < listarPersonaAux.size(); i++) {
            System.out.println("PERSONA: " + listarPersonaAux.get(i).getDesPersona());
            Persona perAux = new Persona();
            perAux.setNroDocide(listarPersonaAux.get(i).getSempersonaPK().getNroDocide());
            perAux.setSebtipdocide(new TipoDocumento());
            perAux.getSebtipdocide().setIndTipdocide(listarPersonaAux.get(i).getSebtipdocide().getIndTipdocide());
            perAux.getSebtipdocide().setDesTipdocide(listarPersonaAux.get(i).getSebtipdocide().getDesTipdocide());
            perAux.setObsPersona(listarPersonaAux.get(i).getObsPersona());
            perAux.setIndTipper(listarPersonaAux.get(i).getIndTipper());
            perAux.setEmailPrincipal(listarPersonaAux.get(i).getEmailPrincipal());
            perAux.setIndSexo(listarPersonaAux.get(i).getIndSexo());
            perAux.setUsuAlta(listarPersonaAux.get(i).getUsuAlta());
            perAux.setTelPrincipal(listarPersonaAux.get(i).getTelPrincipal());
            perAux.setFecUltmod(listarPersonaAux.get(i).getFecUltmod());
            perAux.setDesPersona(listarPersonaAux.get(i).getDesPersona());
            perAux.setDirPrincipal(listarPersonaAux.get(i).getDirPrincipal());
            perAux.setIndEstciv(listarPersonaAux.get(i).getIndEstciv());
            perAux.setFecAlta(listarPersonaAux.get(i).getFecAlta());
            perAux.setFecNaccon(listarPersonaAux.get(i).getFecNaccon());
            perAux.setIndTipsoc(listarPersonaAux.get(i).getIndTipsoc());
            perAux.setIndActivo(listarPersonaAux.get(i).getIndActivo());
            perAux.setListaExpedientesDelTitular(new ArrayList<Expediente>());
            perAux.setListaExpedientesDelRepresentante(new ArrayList<Expediente>());
            perAux.setListaExpedientesDelFuncionario(new ArrayList<Expediente>());
            perAux.setListaMovimientosDelFuncionario(new ArrayList<Movimiento>());
            List<Semexpediente> listaExpeNroTitularAux = listarPersonaAux.get(i).getSemexpedienteListNroTitular();
            for (int j = 0; j < listaExpeNroTitularAux.size(); j++) {
                System.out.println("EXPE: " + listaExpeNroTitularAux.get(j).getDesExpediente());
                Expediente expAux = new Expediente();
                expAux.setNroExpediente(listaExpeNroTitularAux.get(j).getSemexpedientePK().getNroExpediente());
                expAux.setIndEjefisexp(listaExpeNroTitularAux.get(j).getSemexpedientePK().getIndEjefisexp());
                expAux.setNroEstexp(new EstadoExpediente());
                expAux.getNroEstexp().setNroEstexp(listaExpeNroTitularAux.get(j).getNroEstexp().getNroEstexp());
                expAux.getNroEstexp().setDesEstexp(listaExpeNroTitularAux.get(j).getNroEstexp().getDesEstexp());
                expAux.setCodDepen(new Dependencia());
                expAux.getCodDepen().setCodDepen(listaExpeNroTitularAux.get(j).getCodDepen().getCodDepen());
                expAux.getCodDepen().setDesDepen(listaExpeNroTitularAux.get(j).getCodDepen().getDesDepen());
                expAux.getCodDepen().setFecAlta(listaExpeNroTitularAux.get(j).getCodDepen().getFecAlta());
                expAux.getCodDepen().setFecUltmod(listaExpeNroTitularAux.get(j).getCodDepen().getFecUltmod());
                expAux.getCodDepen().setNroMesent(listaExpeNroTitularAux.get(j).getCodDepen().getNroMesent());
                expAux.getCodDepen().setUsuAlta(listaExpeNroTitularAux.get(j).getCodDepen().getUsuAlta());
                expAux.getCodDepen().setUsuUltmod(listaExpeNroTitularAux.get(j).getCodDepen().getUsuUltmod());
                expAux.setNroTitular(listaExpeNroTitularAux.get(j).getNroTitular());
                expAux.setNroRepresentante(listaExpeNroTitularAux.get(j).getNroRepresentante());
                expAux.setNroFuncionario(listaExpeNroTitularAux.get(j).getNroFuncionario());
                expAux.setFecUltmod(listaExpeNroTitularAux.get(j).getFecUltmod());
                expAux.setUsuUltmod(listaExpeNroTitularAux.get(j).getUsuUltmod());
                expAux.setFecIniexp(listaExpeNroTitularAux.get(j).getFecIniexp());
                expAux.setObsExpediente(listaExpeNroTitularAux.get(j).getObsExpediente());
                expAux.setIndEjefiscar(listaExpeNroTitularAux.get(j).getIndEjefiscar());
                expAux.setFecAlta(listaExpeNroTitularAux.get(j).getFecAlta());
                expAux.setUsuAlta(listaExpeNroTitularAux.get(j).getUsuAlta());
                expAux.setNroCarpeta(listaExpeNroTitularAux.get(j).getNroCarpeta());
                expAux.setIndPrioridad(listaExpeNroTitularAux.get(j).getIndPrioridad());
                expAux.setNroTarea(listaExpeNroTitularAux.get(j).getNroTarea());
                expAux.setFecUltmov(listaExpeNroTitularAux.get(j).getFecUltmov());
                expAux.setNroTipexp(listaExpeNroTitularAux.get(j).getNroTipexp());
                expAux.setDesExpediente(listaExpeNroTitularAux.get(j).getDesExpediente());
                expAux.setNroMesent(listaExpeNroTitularAux.get(j).getNroMesent());
                expAux.setListaMovimientosDelExpediente(new ArrayList<Movimiento>());

                List<Sedmovexp> listaMovAux = listaExpeNroTitularAux.get(j).getSedmovexpList();
                for (int k = 0; k < listaMovAux.size(); k++) {
                    System.out.println("MOV: " + listaMovAux.get(k).getNroTipmov().getDesTipmov());
                    Movimiento movAux = new Movimiento();
                    movAux.setNroSecuencia(listaMovAux.get(k).getNroSecuencia());
                    movAux.setNroExpediente(listaMovAux.get(k).getNroExpediente().getSemexpedientePK().getNroExpediente());
                    movAux.setIndEjefisexp(listaMovAux.get(k).getNroExpediente().getSemexpedientePK().getIndEjefisexp());
                    movAux.setNroCarpeta(listaMovAux.get(k).getNroCarpeta());
                    movAux.setIndEjefiscar(listaMovAux.get(k).getIndEjefiscar());
                    movAux.setFecMovexp(listaMovAux.get(k).getFecMovexp());
                    movAux.setNroTipmov(new TipoMovimiento());
                    movAux.getNroTipmov().setNroTipmov(listaMovAux.get(k).getNroTipmov().getNroTipmov());
                    movAux.getNroTipmov().setDesTipmov(listaMovAux.get(k).getNroTipmov().getDesTipmov());
                    movAux.setNroMesent(listaMovAux.get(k).getNroMesent());
                    movAux.setCodDepen(new Dependencia());
                    movAux.getCodDepen().setCodDepen(listaMovAux.get(j).getCodDepen().getCodDepen());
                    movAux.getCodDepen().setDesDepen(listaMovAux.get(j).getCodDepen().getDesDepen());
                    movAux.getCodDepen().setFecAlta(listaMovAux.get(j).getCodDepen().getFecAlta());
                    movAux.getCodDepen().setFecUltmod(listaMovAux.get(j).getCodDepen().getFecUltmod());
                    movAux.getCodDepen().setNroMesent(listaMovAux.get(j).getCodDepen().getNroMesent());
                    movAux.getCodDepen().setUsuAlta(listaMovAux.get(j).getCodDepen().getUsuAlta());
                    movAux.getCodDepen().setUsuUltmod(listaMovAux.get(j).getCodDepen().getUsuUltmod());
                    movAux.setNroFuncionario(listaMovAux.get(k).getNroFuncionario());
                    movAux.setNroTarea(listaMovAux.get(k).getNroTarea());                    
                    movAux.setNroEstexp(new EstadoExpediente());
                    movAux.getNroEstexp().setNroEstexp(listaMovAux.get(k).getNroEstexp().getNroEstexp());
                    movAux.getNroEstexp().setDesEstexp(listaMovAux.get(k).getNroEstexp().getDesEstexp());
                    movAux.setUsuAlta(listaMovAux.get(k).getUsuAlta());
                    movAux.setFecAlta(listaMovAux.get(k).getFecAlta());
                    expAux.getListaMovimientosDelExpediente().add(movAux);
                }
                perAux.getListaExpedientesDelTitular().add(expAux);
            }
            listaPer.add(perAux);
        }
        return listaPersonas;
    }
    

    @GET
    @Path("/listarMovimientos")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Sedmovexp> listarMovimientos() {
        listaExpedientes = semexpedienteCrud.listarPorNroExpedienteIndEjefisexp(9737, 2016);
        listaMovExpedientes = listaExpedientes.get(0).getSedmovexpList(); 
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
