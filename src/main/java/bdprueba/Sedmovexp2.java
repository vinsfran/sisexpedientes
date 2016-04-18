/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bdprueba;

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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author vinsfran
 */
@Entity
@Table(name = "sedmovexp")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sedmovexp2.findAll", query = "SELECT s FROM Sedmovexp s"),
    @NamedQuery(name = "Sedmovexp2.findByNroSecuencia", query = "SELECT s FROM Sedmovexp2 s WHERE s.nroSecuencia = :nroSecuencia"),
    @NamedQuery(name = "Sedmovexp2.findByNroCarpeta", query = "SELECT s FROM Sedmovexp2 s WHERE s.nroCarpeta = :nroCarpeta"),
    @NamedQuery(name = "Sedmovexp2.findByIndEjefiscar", query = "SELECT s FROM Sedmovexp2 s WHERE s.indEjefiscar = :indEjefiscar"),
    @NamedQuery(name = "Sedmovexp2.findByFecMovexp", query = "SELECT s FROM Sedmovexp2 s WHERE s.fecMovexp = :fecMovexp"),
    @NamedQuery(name = "Sedmovexp2.findByNroMesent", query = "SELECT s FROM Sedmovexp2 s WHERE s.nroMesent = :nroMesent"),
    @NamedQuery(name = "Sedmovexp2.findByNroTarea", query = "SELECT s FROM Sedmovexp2 s WHERE s.nroTarea = :nroTarea"),
    @NamedQuery(name = "Sedmovexp2.findByUsuAlta", query = "SELECT s FROM Sedmovexp2 s WHERE s.usuAlta = :usuAlta"),
    @NamedQuery(name = "Sedmovexp2.findByFecAlta", query = "SELECT s FROM Sedmovexp2 s WHERE s.fecAlta = :fecAlta")})
public class Sedmovexp2 implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "nro_secuencia")
    private Integer nroSecuencia;

    @JoinColumns({
        @JoinColumn(name = "nro_expediente", referencedColumnName = "nro_expediente"),
        @JoinColumn(name = "ind_ejefisexp", referencedColumnName = "ind_ejefisexp")})
    @ManyToOne
    private Semexpediente2 semexpediente;

    @Column(name = "nro_carpeta")
    private Integer nroCarpeta;

    @Column(name = "ind_ejefiscar")
    private Integer indEjefiscar;

    @Column(name = "fec_movexp")
    @Temporal(TemporalType.DATE)
    private Date fecMovexp;

    @JoinColumn(name = "nro_tipmov", referencedColumnName = "nro_tipmov")
    @ManyToOne
    private Sebtipmov2 nroTipmov;

    @Column(name = "nro_mesent")
    private Integer nroMesent;

    @JoinColumn(name = "cod_depen", referencedColumnName = "cod_depen")
    @ManyToOne
    private Semdepen2 codDepen;

    @JoinColumn(name = "nro_funcionario", referencedColumnName = "nro_persona")
    @ManyToOne
    private Sempersona2 nroFuncionario;

    @Column(name = "nro_tarea")
    private Integer nroTarea;

    @JoinColumn(name = "nro_estexp", referencedColumnName = "nro_estexp")
    @ManyToOne
    private Sebestexp2 nroEstexp;

    @Size(max = 2147483647)
    @Column(name = "usu_alta")
    private String usuAlta;

    @Column(name = "fec_alta")
    @Temporal(TemporalType.DATE)
    private Date fecAlta;

    public Sedmovexp2() {
    }

    public Sedmovexp2(Integer nroSecuencia) {
        this.nroSecuencia = nroSecuencia;
    }

    public Integer getNroSecuencia() {
        return nroSecuencia;
    }

    public void setNroSecuencia(Integer nroSecuencia) {
        this.nroSecuencia = nroSecuencia;
    }

    public Integer getNroCarpeta() {
        return nroCarpeta;
    }

    public void setNroCarpeta(Integer nroCarpeta) {
        this.nroCarpeta = nroCarpeta;
    }

    public Integer getIndEjefiscar() {
        return indEjefiscar;
    }

    public void setIndEjefiscar(Integer indEjefiscar) {
        this.indEjefiscar = indEjefiscar;
    }

    public Date getFecMovexp() {
        return fecMovexp;
    }

    public void setFecMovexp(Date fecMovexp) {
        this.fecMovexp = fecMovexp;
    }

    public Integer getNroMesent() {
        return nroMesent;
    }

    public void setNroMesent(Integer nroMesent) {
        this.nroMesent = nroMesent;
    }

    public Integer getNroTarea() {
        return nroTarea;
    }

    public void setNroTarea(Integer nroTarea) {
        this.nroTarea = nroTarea;
    }

    public String getUsuAlta() {
        return usuAlta;
    }

    public void setUsuAlta(String usuAlta) {
        this.usuAlta = usuAlta;
    }

    public Date getFecAlta() {
        return fecAlta;
    }

    public void setFecAlta(Date fecAlta) {
        this.fecAlta = fecAlta;
    }

    public Sebestexp2 getNroEstexp() {
        return nroEstexp;
    }

    public void setNroEstexp(Sebestexp2 nroEstexp) {
        this.nroEstexp = nroEstexp;
    }

    public Sebtipmov2 getNroTipmov() {
        return nroTipmov;
    }

    public void setNroTipmov(Sebtipmov2 nroTipmov) {
        this.nroTipmov = nroTipmov;
    }

    public Semdepen2 getCodDepen() {
        return codDepen;
    }

    public void setCodDepen(Semdepen2 codDepen) {
        this.codDepen = codDepen;
    }

    public Semexpediente2 getSemexpediente() {
        return semexpediente;
    }

    public void setSemexpediente(Semexpediente2 semexpediente) {
        this.semexpediente = semexpediente;
    }

    public Sempersona2 getNroFuncionario() {
        return nroFuncionario;
    }

    public void setNroFuncionario(Sempersona2 nroFuncionario) {
        this.nroFuncionario = nroFuncionario;
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
        if (!(object instanceof Sedmovexp2)) {
            return false;
        }
        Sedmovexp2 other = (Sedmovexp2) object;
        if ((this.nroSecuencia == null && other.nroSecuencia != null) || (this.nroSecuencia != null && !this.nroSecuencia.equals(other.nroSecuencia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "py.gog.mca.mavenproject2.Sedmovexp[ nroSecuencia=" + nroSecuencia + " ]";
    }

}
