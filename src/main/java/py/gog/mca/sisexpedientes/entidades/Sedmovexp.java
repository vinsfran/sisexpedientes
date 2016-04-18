/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.gog.mca.sisexpedientes.entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author vinsfran
 */
@Entity
@Table(name = "sedmovexp")
@XmlRootElement
@XmlAccessorType(XmlAccessType.PUBLIC_MEMBER)
@NamedQueries({
    @NamedQuery(name = "Sedmovexp.findAll", query = "SELECT s FROM Sedmovexp s"),
    @NamedQuery(name = "Sedmovexp.findByFecAlta", query = "SELECT s FROM Sedmovexp s WHERE s.fecAlta = :fecAlta"),
    @NamedQuery(name = "Sedmovexp.findByNroFuncionario", query = "SELECT s FROM Sedmovexp s WHERE s.nroFuncionario = :nroFuncionario"),
    @NamedQuery(name = "Sedmovexp.findByNroTipmov", query = "SELECT s FROM Sedmovexp s WHERE s.nroTipmov = :nroTipmov"),
    @NamedQuery(name = "Sedmovexp.findByNroSecuencia", query = "SELECT s FROM Sedmovexp s WHERE s.nroSecuencia = :nroSecuencia"),
    @NamedQuery(name = "Sedmovexp.findByNroCarpeta", query = "SELECT s FROM Sedmovexp s WHERE s.nroCarpeta = :nroCarpeta"),
    @NamedQuery(name = "Sedmovexp.findByCodDepen", query = "SELECT s FROM Sedmovexp s WHERE s.codDepen = :codDepen"),
    @NamedQuery(name = "Sedmovexp.findByNroMesent", query = "SELECT s FROM Sedmovexp s WHERE s.nroMesent = :nroMesent"),
    @NamedQuery(name = "Sedmovexp.findByUsuAlta", query = "SELECT s FROM Sedmovexp s WHERE s.usuAlta = :usuAlta"),
    @NamedQuery(name = "Sedmovexp.findByNroTarea", query = "SELECT s FROM Sedmovexp s WHERE s.nroTarea = :nroTarea"),
    @NamedQuery(name = "Sedmovexp.findByNroExpediente", query = "SELECT s FROM Sedmovexp s WHERE s.nroExpediente = :nroExpediente"),
    @NamedQuery(name = "Sedmovexp.findByFecMovexp", query = "SELECT s FROM Sedmovexp s WHERE s.fecMovexp = :fecMovexp"),
    @NamedQuery(name = "Sedmovexp.findByNroEstexp", query = "SELECT s FROM Sedmovexp s WHERE s.nroEstexp = :nroEstexp"),
    @NamedQuery(name = "Sedmovexp.findByIndEjefiscar", query = "SELECT s FROM Sedmovexp s WHERE s.indEjefiscar = :indEjefiscar")})
public class Sedmovexp implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "nro_secuencia")
    private Integer nroSecuencia;

    /*   @Basic(optional = false)
     @NotNull
     @Column(name = "nro_expediente")
     private int nroExpediente;
     @Basic(optional = false)
     @NotNull
     @Column(name = "ind_ejefisexp")
     private int indEjefisexp;*/
    @JoinColumns({
        @JoinColumn(name = "nro_expediente", referencedColumnName = "nro_expediente"),
        @JoinColumn(name = "ind_ejefisexp", referencedColumnName = "ind_ejefisexp")})
    @ManyToOne
    private Semexpediente nroExpediente;

    @Basic(optional = false)
    @NotNull
    @Column(name = "nro_carpeta")
    private int nroCarpeta;

    @Basic(optional = false)
    @NotNull
    @Column(name = "ind_ejefiscar")
    private int indEjefiscar;

    @Basic(optional = false)
    @NotNull
    @Column(name = "fec_movexp")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecMovexp;

    @JoinColumn(name = "nro_tipmov", referencedColumnName = "nro_tipmov")
    @ManyToOne(optional = false)
    private Sebtipmov nroTipmov;

    @Basic(optional = false)
    @NotNull
    @Column(name = "nro_mesent")
    private int nroMesent;

    @JoinColumn(name = "cod_depen", referencedColumnName = "cod_depen")
    @ManyToOne(optional = false)
    private Semdepen codDepen;

    @JoinColumn(name = "nro_funcionario", referencedColumnName = "nro_persona")
    @ManyToOne(optional = false)
    private Sempersona nroFuncionario;

    @Basic(optional = false)
    @NotNull
    @Column(name = "nro_tarea")
    private int nroTarea;

    @JoinColumn(name = "nro_estexp", referencedColumnName = "nro_estexp")
    @ManyToOne(optional = false)
    private Sebestexp nroEstexp;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "usu_alta")
    private String usuAlta;

    @Basic(optional = false)
    @NotNull
    @Column(name = "fec_alta")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecAlta;

    public Sedmovexp() {
    }

    public Sedmovexp(Integer nroSecuencia) {
        this.nroSecuencia = nroSecuencia;
    }

    public Sedmovexp(Integer nroSecuencia, Date fecAlta, Sempersona nroFuncionario, Sebtipmov nroTipmov, int nroCarpeta, Semdepen codDepen, int nroMesent, String usuAlta, int nroTarea, Semexpediente nroExpediente, Date fecMovexp, Sebestexp nroEstexp, int indEjefiscar) {
        this.nroSecuencia = nroSecuencia;
        this.fecAlta = fecAlta;
        this.nroFuncionario = nroFuncionario;
        this.nroTipmov = nroTipmov;
        this.nroCarpeta = nroCarpeta;
        this.codDepen = codDepen;
        this.nroExpediente = nroExpediente;
        this.nroMesent = nroMesent;
        this.usuAlta = usuAlta;
        this.nroTarea = nroTarea;
        this.fecMovexp = fecMovexp;
        this.nroEstexp = nroEstexp;
        this.indEjefiscar = indEjefiscar;
    }

    public Date getFecAlta() {
        return fecAlta;
    }

    public void setFecAlta(Date fecAlta) {
        this.fecAlta = fecAlta;
    }

    public Sempersona getNroFuncionario() {
        return nroFuncionario;
    }

    public void setNroFuncionario(Sempersona nroFuncionario) {
        this.nroFuncionario = nroFuncionario;
    }

    public Sebtipmov getNroTipmov() {
        return nroTipmov;
    }

    public void setNroTipmov(Sebtipmov nroTipmov) {
        this.nroTipmov = nroTipmov;
    }

    public Integer getNroSecuencia() {
        return nroSecuencia;
    }

    public void setNroSecuencia(Integer nroSecuencia) {
        this.nroSecuencia = nroSecuencia;
    }

    public int getNroCarpeta() {
        return nroCarpeta;
    }

    public void setNroCarpeta(int nroCarpeta) {
        this.nroCarpeta = nroCarpeta;
    }

    public Semdepen getCodDepen() {
        return codDepen;
    }

    public void setCodDepen(Semdepen codDepen) {
        this.codDepen = codDepen;
    }

    public Semexpediente getNroExpediente() {
        return nroExpediente;
    }

    public void setNroExpediente(Semexpediente nroExpediente) {
        this.nroExpediente = nroExpediente;
    }

    public int getNroMesent() {
        return nroMesent;
    }

    public void setNroMesent(int nroMesent) {
        this.nroMesent = nroMesent;
    }

    public String getUsuAlta() {
        return usuAlta;
    }

    public void setUsuAlta(String usuAlta) {
        this.usuAlta = usuAlta;
    }

    public int getNroTarea() {
        return nroTarea;
    }

    public void setNroTarea(int nroTarea) {
        this.nroTarea = nroTarea;
    }

    public Date getFecMovexp() {
        return fecMovexp;
    }

    public void setFecMovexp(Date fecMovexp) {
        this.fecMovexp = fecMovexp;
    }

    public Sebestexp getNroEstexp() {
        return nroEstexp;
    }

    public void setNroEstexp(Sebestexp nroEstexp) {
        this.nroEstexp = nroEstexp;
    }

    public int getIndEjefiscar() {
        return indEjefiscar;
    }

    public void setIndEjefiscar(int indEjefiscar) {
        this.indEjefiscar = indEjefiscar;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nroSecuencia != null ? nroSecuencia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sedmovexp)) {
            return false;
        }
        Sedmovexp other = (Sedmovexp) object;
        if ((this.nroSecuencia == null && other.nroSecuencia != null) || (this.nroSecuencia != null && !this.nroSecuencia.equals(other.nroSecuencia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "py.gog.mca.sisexpedientes.entidades.Sedmovexp[ nroSecuencia=" + nroSecuencia + " ]";
    }

}
