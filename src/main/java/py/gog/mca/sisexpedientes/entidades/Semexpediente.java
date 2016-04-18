/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.gog.mca.sisexpedientes.entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author vinsfran
 */
@Entity
@Table(name = "semexpediente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Semexpediente.findAll", query = "SELECT s FROM Semexpediente s"),
    @NamedQuery(name = "Semexpediente.findByFecUltmod", query = "SELECT s FROM Semexpediente s WHERE s.fecUltmod = :fecUltmod"),
    @NamedQuery(name = "Semexpediente.findByUsuUltmod", query = "SELECT s FROM Semexpediente s WHERE s.usuUltmod = :usuUltmod"),
    @NamedQuery(name = "Semexpediente.findByNroEstexp", query = "SELECT s FROM Semexpediente s WHERE s.nroEstexp = :nroEstexp"),
    @NamedQuery(name = "Semexpediente.findByFecIniexp", query = "SELECT s FROM Semexpediente s WHERE s.fecIniexp = :fecIniexp"),
    @NamedQuery(name = "Semexpediente.findByNroExpediente", query = "SELECT s FROM Semexpediente s WHERE s.semexpedientePK.nroExpediente = :nroExpediente"),
    @NamedQuery(name = "Semexpediente.findByNroTitular", query = "SELECT s FROM Semexpediente s WHERE s.nroTitular = :nroTitular"),
    @NamedQuery(name = "Semexpediente.findByObsExpediente", query = "SELECT s FROM Semexpediente s WHERE s.obsExpediente = :obsExpediente"),
    @NamedQuery(name = "Semexpediente.findByIndEjefiscar", query = "SELECT s FROM Semexpediente s WHERE s.indEjefiscar = :indEjefiscar"),
    @NamedQuery(name = "Semexpediente.findByNroFuncionario", query = "SELECT s FROM Semexpediente s WHERE s.nroFuncionario = :nroFuncionario"),
    @NamedQuery(name = "Semexpediente.findByFecAlta", query = "SELECT s FROM Semexpediente s WHERE s.fecAlta = :fecAlta"),
    @NamedQuery(name = "Semexpediente.findByUsuAlta", query = "SELECT s FROM Semexpediente s WHERE s.usuAlta = :usuAlta"),
    @NamedQuery(name = "Semexpediente.findByNroCarpeta", query = "SELECT s FROM Semexpediente s WHERE s.nroCarpeta = :nroCarpeta"),
    @NamedQuery(name = "Semexpediente.findByIndPrioridad", query = "SELECT s FROM Semexpediente s WHERE s.indPrioridad = :indPrioridad"),
    @NamedQuery(name = "Semexpediente.findByNroRepresentante", query = "SELECT s FROM Semexpediente s WHERE s.nroRepresentante = :nroRepresentante"),
    @NamedQuery(name = "Semexpediente.findByNroTarea", query = "SELECT s FROM Semexpediente s WHERE s.nroTarea = :nroTarea"),
    @NamedQuery(name = "Semexpediente.findByFecUltmov", query = "SELECT s FROM Semexpediente s WHERE s.fecUltmov = :fecUltmov"),
    @NamedQuery(name = "Semexpediente.findByIndEjefisexp", query = "SELECT s FROM Semexpediente s WHERE s.semexpedientePK.indEjefisexp = :indEjefisexp"),
    @NamedQuery(name = "Semexpediente.findByNroTipexp", query = "SELECT s FROM Semexpediente s WHERE s.nroTipexp = :nroTipexp"),
    @NamedQuery(name = "Semexpediente.findByCodDepen", query = "SELECT s FROM Semexpediente s WHERE s.codDepen = :codDepen"),
    @NamedQuery(name = "Semexpediente.findByDesExpediente", query = "SELECT s FROM Semexpediente s WHERE s.desExpediente = :desExpediente"),
    @NamedQuery(name = "Semexpediente.findByNroMesent", query = "SELECT s FROM Semexpediente s WHERE s.nroMesent = :nroMesent")})
public class Semexpediente implements Serializable {

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    protected SemexpedientePK semexpedientePK;

    @JoinColumn(name = "nro_estexp", referencedColumnName = "nro_estexp")
    @ManyToOne(optional = false)
    private Sebestexp nroEstexp;

    @JoinColumn(name = "cod_depen", referencedColumnName = "cod_depen")
    @ManyToOne(optional = false)
    private Semdepen codDepen;

    @Basic(optional = false)
    @NotNull
    @Column(name = "nro_titular")
    private int nroTitular;

    //@JoinColumns(
    //        { @JoinColumn(name = "nro_titular", referencedColumnName = "nro_persona", nullable = false) }
    //)
    //@JoinColumn(name = "nro_titular", referencedColumnName = "nro_persona")
    //@ManyToOne
    @Transient
    private Sempersona nroTitularJava;

    @Basic(optional = false)
    @NotNull
    @Column(name = "nro_representante")
    private int nroRepresentante;

    //@JoinColumn(name = "nro_representante", referencedColumnName = "nro_persona")
    //@ManyToOne
    @Transient
    private Sempersona nroRepresentanteJava;

    @Basic(optional = false)
    @NotNull
    @Column(name = "nro_funcionario")
    private int nroFuncionario;

    //@JoinColumn(name = "nro_funcionario", referencedColumnName = "nro_persona")
    //@ManyToOne
    @Transient
    private Sempersona nroFuncionarioJava;

    @Basic(optional = false)
    @NotNull
    @Column(name = "fec_ultmod")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecUltmod;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "usu_ultmod")
    private String usuUltmod;

    @Basic(optional = false)
    @NotNull
    @Column(name = "fec_iniexp")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecIniexp;

    @Size(max = 120)
    @Column(name = "obs_expediente")
    private String obsExpediente;

    @Basic(optional = false)
    @NotNull
    @Column(name = "ind_ejefiscar")
    private int indEjefiscar;

    @Basic(optional = false)
    @NotNull
    @Column(name = "fec_alta")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecAlta;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "usu_alta")
    private String usuAlta;

    @Basic(optional = false)
    @NotNull
    @Column(name = "nro_carpeta")
    private int nroCarpeta;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "ind_prioridad")
    private String indPrioridad;

    @Basic(optional = false)
    @NotNull
    @Column(name = "nro_tarea")
    private int nroTarea;

    @Basic(optional = false)
    @NotNull
    @Column(name = "fec_ultmov")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecUltmov;

    @Basic(optional = false)
    @NotNull
    @Column(name = "nro_tipexp")
    private int nroTipexp;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "des_expediente")
    private String desExpediente;

    @Basic(optional = false)
    @NotNull
    @Column(name = "nro_mesent")
    private int nroMesent;

    //@OneToMany(mappedBy = "semexpediente")
    @Transient
    private List<Sedmovexp> sedmovexpList;

    public Semexpediente() {
    }

    public Semexpediente(SemexpedientePK semexpedientePK) {
        this.semexpedientePK = semexpedientePK;
    }

    // INICIO ESTADO ANTERIOR
    /*public Semexpediente(SemexpedientePK semexpedientePK, Date fecUltmod, String usuUltmod, Sebestexp nroEstexp, Date fecIniexp, int nroTitular, int indEjefiscar, int nroFuncionario, Date fecAlta, String usuAlta, int nroCarpeta, String indPrioridad, int nroRepresentante, int nroTarea, Date fecUltmov, int nroTipexp, Semdepen codDepen, String desExpediente, int nroMesent) {
     this.semexpedientePK = semexpedientePK;
     this.fecUltmod = fecUltmod;
     this.usuUltmod = usuUltmod;
     this.nroEstexp = nroEstexp;
     this.fecIniexp = fecIniexp;
     this.nroTitular = nroTitular;
     this.indEjefiscar = indEjefiscar;
     this.nroFuncionario = nroFuncionario;
     this.fecAlta = fecAlta;
     this.usuAlta = usuAlta;
     this.nroCarpeta = nroCarpeta;
     this.indPrioridad = indPrioridad;
     this.nroRepresentante = nroRepresentante;
     this.nroTarea = nroTarea;
     this.fecUltmov = fecUltmov;
     this.nroTipexp = nroTipexp;
     this.codDepen = codDepen;
     this.desExpediente = desExpediente;
     this.nroMesent = nroMesent;
     }
    
     public int getNroTitular() {
     return nroTitular;
     }

     public void setNroTitular(int nroTitular) {
     this.nroTitular = nroTitular;
     }
    
     public int getNroRepresentante() {
     return nroRepresentante;
     }

     public void setNroRepresentante(int nroRepresentante) {
     this.nroRepresentante = nroRepresentante;
     }
    
     public int getNroFuncionario() {
     return nroFuncionario;
     }

     public void setNroFuncionario(int nroFuncionario) {
     this.nroFuncionario = nroFuncionario;
     }*/
    // FIN ESTADO ANTERIOR
    // INICIO ESTADO ACTUAL
    public Semexpediente(SemexpedientePK semexpedientePK, int nroTitular, int nroRepresentante, int nroFuncionario, Date fecUltmod, String usuUltmod, Sebestexp nroEstexp, Date fecIniexp, int indEjefiscar, Date fecAlta, String usuAlta, int nroCarpeta, String indPrioridad, int nroTarea, Date fecUltmov, int nroTipexp, Semdepen codDepen, String desExpediente, int nroMesent) {
        this.semexpedientePK = semexpedientePK;
        this.nroTitular = nroTitular;
        this.nroRepresentante = nroRepresentante;
        this.nroFuncionario = nroFuncionario;
        this.fecUltmod = fecUltmod;
        this.usuUltmod = usuUltmod;
        this.nroEstexp = nroEstexp;
        this.fecIniexp = fecIniexp;
        this.indEjefiscar = indEjefiscar;
        this.fecAlta = fecAlta;
        this.usuAlta = usuAlta;
        this.nroCarpeta = nroCarpeta;
        this.indPrioridad = indPrioridad;
        this.nroTarea = nroTarea;
        this.fecUltmov = fecUltmov;
        this.nroTipexp = nroTipexp;
        this.codDepen = codDepen;
        this.desExpediente = desExpediente;
        this.nroMesent = nroMesent;
    }

    public int getNroTitular() {
        return nroTitular;
    }

    public void setNroTitular(int nroTitular) {
        this.nroTitular = nroTitular;
    }

    //@XmlTransient
    public Sempersona getNroTitularJava() {
        return nroTitularJava;
    }

    public void setNroTitularJava(Sempersona nroTitularJava) {
        this.nroTitularJava = nroTitularJava;
    }

    public int getNroRepresentante() {
        return nroRepresentante;
    }

    public void setNroRepresentante(int nroRepresentante) {
        this.nroRepresentante = nroRepresentante;
    }

    //@XmlTransient
    public Sempersona getNroRepresentanteJava() {
        return nroRepresentanteJava;
    }

    public void setNroRepresentanteJava(Sempersona nroRepresentanteJava) {
        this.nroRepresentanteJava = nroRepresentanteJava;
    }

    public int getNroFuncionario() {
        return nroFuncionario;
    }

    public void setNroFuncionario(int nroFuncionario) {
        this.nroFuncionario = nroFuncionario;
    }

    //@XmlTransient
    public Sempersona getNroFuncionarioJava() {
        return nroFuncionarioJava;
    }

    public void setNroFuncionarioJava(Sempersona nroFuncionarioJava) {
        this.nroFuncionarioJava = nroFuncionarioJava;
    }
    //FIN ESTADO ACTUAL

    public Semexpediente(int nroExpediente, int indEjefisexp) {
        this.semexpedientePK = new SemexpedientePK(nroExpediente, indEjefisexp);
    }

    public SemexpedientePK getSemexpedientePK() {
        return semexpedientePK;
    }

    public void setSemexpedientePK(SemexpedientePK semexpedientePK) {
        this.semexpedientePK = semexpedientePK;
    }

    public Date getFecUltmod() {
        return fecUltmod;
    }

    public void setFecUltmod(Date fecUltmod) {
        this.fecUltmod = fecUltmod;
    }

    public String getUsuUltmod() {
        return usuUltmod;
    }

    public void setUsuUltmod(String usuUltmod) {
        this.usuUltmod = usuUltmod;
    }

    public Sebestexp getNroEstexp() {
        return nroEstexp;
    }

    public void setNroEstexp(Sebestexp nroEstexp) {
        this.nroEstexp = nroEstexp;
    }

    public Date getFecIniexp() {
        return fecIniexp;
    }

    public void setFecIniexp(Date fecIniexp) {
        this.fecIniexp = fecIniexp;
    }

    public String getObsExpediente() {
        return obsExpediente;
    }

    public void setObsExpediente(String obsExpediente) {
        this.obsExpediente = obsExpediente;
    }

    public int getIndEjefiscar() {
        return indEjefiscar;
    }

    public void setIndEjefiscar(int indEjefiscar) {
        this.indEjefiscar = indEjefiscar;
    }

    public Date getFecAlta() {
        return fecAlta;
    }

    public void setFecAlta(Date fecAlta) {
        this.fecAlta = fecAlta;
    }

    public String getUsuAlta() {
        return usuAlta;
    }

    public void setUsuAlta(String usuAlta) {
        this.usuAlta = usuAlta;
    }

    public int getNroCarpeta() {
        return nroCarpeta;
    }

    public void setNroCarpeta(int nroCarpeta) {
        this.nroCarpeta = nroCarpeta;
    }

    public String getIndPrioridad() {
        return indPrioridad;
    }

    public void setIndPrioridad(String indPrioridad) {
        this.indPrioridad = indPrioridad;
    }

    public int getNroTarea() {
        return nroTarea;
    }

    public void setNroTarea(int nroTarea) {
        this.nroTarea = nroTarea;
    }

    public Date getFecUltmov() {
        return fecUltmov;
    }

    public void setFecUltmov(Date fecUltmov) {
        this.fecUltmov = fecUltmov;
    }

    public int getNroTipexp() {
        return nroTipexp;
    }

    public void setNroTipexp(int nroTipexp) {
        this.nroTipexp = nroTipexp;
    }

    public Semdepen getCodDepen() {
        return codDepen;
    }

    public void setCodDepen(Semdepen codDepen) {
        this.codDepen = codDepen;
    }

    public String getDesExpediente() {
        return desExpediente;
    }

    public void setDesExpediente(String desExpediente) {
        this.desExpediente = desExpediente;
    }

    public int getNroMesent() {
        return nroMesent;
    }

    public void setNroMesent(int nroMesent) {
        this.nroMesent = nroMesent;
    }

    //@XmlTransient
    public List<Sedmovexp> getSedmovexpList() {
        return sedmovexpList;
    }

    public void setSedmovexpList(List<Sedmovexp> sedmovexpList) {
        this.sedmovexpList = sedmovexpList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (semexpedientePK != null ? semexpedientePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Semexpediente)) {
            return false;
        }
        Semexpediente other = (Semexpediente) object;
        if ((this.semexpedientePK == null && other.semexpedientePK != null) || (this.semexpedientePK != null && !this.semexpedientePK.equals(other.semexpedientePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "py.gog.mca.sisexpedientes.entidades.Semexpediente[ semexpedientePK=" + semexpedientePK + " ]";
    }

}
