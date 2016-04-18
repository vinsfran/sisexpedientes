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
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author vinsfran
 */
@Entity
@Table(name = "sempersona")

@XmlRootElement
@XmlAccessorType(XmlAccessType.PUBLIC_MEMBER)
@NamedQueries({
    @NamedQuery(name = "Sempersona.findAll", query = "SELECT s FROM Sempersona s"),
    @NamedQuery(name = "Sempersona.findByNroPersona", query = "SELECT s FROM Sempersona s WHERE s.nroPersona = :nroPersona"),
    @NamedQuery(name = "Sempersona.findByNroDocide", query = "SELECT s FROM Sempersona s WHERE s.nroDocide = :nroDocide"),
    @NamedQuery(name = "Sempersona.findByIndTipdocide", query = "SELECT s FROM Sempersona s WHERE s.indTipdocide = :indTipdocide"),
    @NamedQuery(name = "Sempersona.findByObsPersona", query = "SELECT s FROM Sempersona s WHERE s.obsPersona = :obsPersona"),
    @NamedQuery(name = "Sempersona.findByIndTipper", query = "SELECT s FROM Sempersona s WHERE s.indTipper = :indTipper"),
    @NamedQuery(name = "Sempersona.findByEmailPrincipal", query = "SELECT s FROM Sempersona s WHERE s.emailPrincipal = :emailPrincipal"),
    @NamedQuery(name = "Sempersona.findByIndSexo", query = "SELECT s FROM Sempersona s WHERE s.indSexo = :indSexo"),
    @NamedQuery(name = "Sempersona.findByUsuAlta", query = "SELECT s FROM Sempersona s WHERE s.usuAlta = :usuAlta"),
    @NamedQuery(name = "Sempersona.findByTelPrincipal", query = "SELECT s FROM Sempersona s WHERE s.telPrincipal = :telPrincipal"),
    @NamedQuery(name = "Sempersona.findByFecUltmod", query = "SELECT s FROM Sempersona s WHERE s.fecUltmod = :fecUltmod"),
    @NamedQuery(name = "Sempersona.findByNomFantasia", query = "SELECT s FROM Sempersona s WHERE s.nomFantasia = :nomFantasia"),
    @NamedQuery(name = "Sempersona.findByUsuUltmod", query = "SELECT s FROM Sempersona s WHERE s.usuUltmod = :usuUltmod"),
    @NamedQuery(name = "Sempersona.findByDesPersona", query = "SELECT s FROM Sempersona s WHERE s.desPersona = :desPersona"),
    @NamedQuery(name = "Sempersona.findByDirPrincipal", query = "SELECT s FROM Sempersona s WHERE s.dirPrincipal = :dirPrincipal"),
    @NamedQuery(name = "Sempersona.findByIndEstciv", query = "SELECT s FROM Sempersona s WHERE s.indEstciv = :indEstciv"),
    @NamedQuery(name = "Sempersona.findByFecAlta", query = "SELECT s FROM Sempersona s WHERE s.fecAlta = :fecAlta"),    
    @NamedQuery(name = "Sempersona.findByFecNaccon", query = "SELECT s FROM Sempersona s WHERE s.fecNaccon = :fecNaccon"),    
    @NamedQuery(name = "Sempersona.findByIndTipsoc", query = "SELECT s FROM Sempersona s WHERE s.indTipsoc = :indTipsoc"),
    @NamedQuery(name = "Sempersona.findByIndActivo", query = "SELECT s FROM Sempersona s WHERE s.indActivo = :indActivo")})
public class Sempersona implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "nro_persona")
    private int nroPersona;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "nro_docide")
    private String nroDocide;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "ind_tipdocide")
    private String indTipdocide;

    @JoinColumn(name = "ind_tipdocide", referencedColumnName = "ind_tipdocide", nullable = false, insertable = false, updatable = false)
    @ManyToOne
    private Sebtipdocide sebtipdocide;

    @Size(max = 120)
    @Column(name = "obs_persona")
    private String obsPersona;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "ind_tipper")
    private String indTipper;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "email_principal")
    private String emailPrincipal;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 9)
    @Column(name = "ind_sexo")
    private String indSexo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "usu_alta")
    private String usuAlta;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "tel_principal")
    private String telPrincipal;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fec_ultmod")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecUltmod;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "nom_fantasia")
    private String nomFantasia;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "usu_ultmod")
    private String usuUltmod;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "des_persona")
    private String desPersona;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "dir_principal")
    private String dirPrincipal;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "ind_estciv")
    private String indEstciv;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fec_alta")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecAlta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fec_naccon")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecNaccon;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "ind_tipsoc")
    private String indTipsoc;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "ind_activo")
    private String indActivo;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nroTitular")
    private List<Semexpediente> semexpedienteListNroTitular;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nroRepresentante")
    private List<Semexpediente> semexpedienteListNroRepresentante;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nroFuncionario")
    private List<Semexpediente> semexpedienteListNroFuncionario;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nroFuncionario")
    private List<Sedmovexp> sedmovexpListNroFuncionario;

    public Sempersona() {
    }

    public Sempersona(int nroPersona, String nroDocide, String indTipdocide, String indTipper, String emailPrincipal, String indSexo, String usuAlta, String telPrincipal, Date fecUltmod, String nomFantasia, String usuUltmod, String desPersona, String dirPrincipal, String indEstciv, Date fecAlta, Date fecNaccon, String indTipsoc, String indActivo) {
        this.nroPersona = nroPersona;
        this.nroDocide = nroDocide;
        this.indTipdocide = indTipdocide;
        this.indTipper = indTipper;
        this.emailPrincipal = emailPrincipal;
        this.indSexo = indSexo;
        this.usuAlta = usuAlta;
        this.telPrincipal = telPrincipal;
        this.fecUltmod = fecUltmod;
        this.nomFantasia = nomFantasia;
        this.usuUltmod = usuUltmod;
        this.desPersona = desPersona;
        this.dirPrincipal = dirPrincipal;
        this.indEstciv = indEstciv;
        this.fecAlta = fecAlta;
        this.fecNaccon = fecNaccon;
        this.indTipsoc = indTipsoc;
        this.indActivo = indActivo;
    }

    public int getNroPersona() {
        return nroPersona;
    }

    public void setNroPersona(int nroPersona) {
        this.nroPersona = nroPersona;
    }

    public String getNroDocide() {
        return nroDocide;
    }

    public void setNroDocide(String nroDocide) {
        this.nroDocide = nroDocide;
    }

    public String getIndTipdocide() {
        return indTipdocide;
    }

    public void setIndTipdocide(String indTipdocide) {
        this.indTipdocide = indTipdocide;
    }

    public String getObsPersona() {
        return obsPersona;
    }

    public void setObsPersona(String obsPersona) {
        this.obsPersona = obsPersona;
    }

    public String getIndTipper() {
        return indTipper;
    }

    public void setIndTipper(String indTipper) {
        this.indTipper = indTipper;
    }

    public String getEmailPrincipal() {
        return emailPrincipal;
    }

    public void setEmailPrincipal(String emailPrincipal) {
        this.emailPrincipal = emailPrincipal;
    }

    public String getIndSexo() {
        return indSexo;
    }

    public void setIndSexo(String indSexo) {
        this.indSexo = indSexo;
    }

    public String getUsuAlta() {
        return usuAlta;
    }

    public void setUsuAlta(String usuAlta) {
        this.usuAlta = usuAlta;
    }

    public String getTelPrincipal() {
        return telPrincipal;
    }

    public void setTelPrincipal(String telPrincipal) {
        this.telPrincipal = telPrincipal;
    }

    public Date getFecUltmod() {
        return fecUltmod;
    }

    public void setFecUltmod(Date fecUltmod) {
        this.fecUltmod = fecUltmod;
    }

    public String getNomFantasia() {
        return nomFantasia;
    }

    public void setNomFantasia(String nomFantasia) {
        this.nomFantasia = nomFantasia;
    }

    public String getUsuUltmod() {
        return usuUltmod;
    }

    public void setUsuUltmod(String usuUltmod) {
        this.usuUltmod = usuUltmod;
    }

    public String getDesPersona() {
        return desPersona;
    }

    public void setDesPersona(String desPersona) {
        this.desPersona = desPersona;
    }

    public String getDirPrincipal() {
        return dirPrincipal;
    }

    public void setDirPrincipal(String dirPrincipal) {
        this.dirPrincipal = dirPrincipal;
    }

    public String getIndEstciv() {
        return indEstciv;
    }

    public void setIndEstciv(String indEstciv) {
        this.indEstciv = indEstciv;
    }

    public Date getFecAlta() {
        return fecAlta;
    }

    public void setFecAlta(Date fecAlta) {
        this.fecAlta = fecAlta;
    }

    public Date getFecNaccon() {
        return fecNaccon;
    }

    public void setFecNaccon(Date fecNaccon) {
        this.fecNaccon = fecNaccon;
    }

    public String getIndTipsoc() {
        return indTipsoc;
    }

    public void setIndTipsoc(String indTipsoc) {
        this.indTipsoc = indTipsoc;
    }

    public String getIndActivo() {
        return indActivo;
    }

    public void setIndActivo(String indActivo) {
        this.indActivo = indActivo;
    }

    public Sebtipdocide getSebtipdocide() { 
        return sebtipdocide;
    }

    public void setSebtipdocide(Sebtipdocide sebtipdocide) {
        this.sebtipdocide = sebtipdocide;
    }

    @XmlTransient
    public List<Semexpediente> getSemexpedienteListNroTitular() {
        return semexpedienteListNroTitular;
    }

    public void setSemexpedienteListNroTitular(List<Semexpediente> semexpedienteListNroTitular) {
        this.semexpedienteListNroTitular = semexpedienteListNroTitular;
    }

    @XmlTransient
    public List<Semexpediente> getSemexpedienteListNroRepresentante() {
        return semexpedienteListNroRepresentante;
    }

    public void setSemexpedienteListNroRepresentante(List<Semexpediente> semexpedienteListNroRepresentante) {
        this.semexpedienteListNroRepresentante = semexpedienteListNroRepresentante;
    }

    @XmlTransient
    public List<Semexpediente> getSemexpedienteListNroFuncionario() {
        return semexpedienteListNroFuncionario;
    }

    public void setSemexpedienteListNroFuncionario(List<Semexpediente> semexpedienteListNroFuncionario) {
        this.semexpedienteListNroFuncionario = semexpedienteListNroFuncionario;
    }

    @XmlTransient
    public List<Sedmovexp> getSedmovexpListNroFuncionario() {
        return sedmovexpListNroFuncionario;
    }

    public void setSedmovexpListNroFuncionario(List<Sedmovexp> sedmovexpListNroFuncionario) {
        this.sedmovexpListNroFuncionario = sedmovexpListNroFuncionario;
    }

//    @Override
//    public int hashCode() {
//        int hash = 0;
//        hash += (nroPersona != null ? nroPersona.hashCode() : 0);
//        return hash;
//    }
//
//    @Override
//    public boolean equals(Object object) {
//        // TODO: Warning - this method won't work in the case the id fields are not set
//        if (!(object instanceof Sempersona)) {
//            return false;
//        }
//        Sempersona other = (Sempersona) object;
//        if ((this.nroPersona == null && other.nroPersona != null) || (this.nroPersona != null && !this.nroPersona.equals(other.nroPersona))) {
//            return false;
//        }
//        return true;
//    } 

    @Override
    public String toString() {
        return "py.gog.mca.sisexpedientes.entidades.Sempersona[ nroPersona=" + nroPersona + " ]";
    }

}
