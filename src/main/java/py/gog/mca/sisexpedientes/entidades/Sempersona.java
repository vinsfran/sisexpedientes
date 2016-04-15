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
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
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
@Table(name = "sempersona")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sempersona.findAll", query = "SELECT s FROM Sempersona s"),
    @NamedQuery(name = "Sempersona.findByObsPersona", query = "SELECT s FROM Sempersona s WHERE s.obsPersona = :obsPersona"),
    @NamedQuery(name = "Sempersona.findByIndTipper", query = "SELECT s FROM Sempersona s WHERE s.indTipper = :indTipper"),
    @NamedQuery(name = "Sempersona.findByEmailPrincipal", query = "SELECT s FROM Sempersona s WHERE s.emailPrincipal = :emailPrincipal"),
    @NamedQuery(name = "Sempersona.findByIndSexo", query = "SELECT s FROM Sempersona s WHERE s.indSexo = :indSexo"),
    @NamedQuery(name = "Sempersona.findByUsuAlta", query = "SELECT s FROM Sempersona s WHERE s.usuAlta = :usuAlta"),
    @NamedQuery(name = "Sempersona.findByNroDocide", query = "SELECT s FROM Sempersona s WHERE s.sempersonaPK.nroDocide = :nroDocide"),
    @NamedQuery(name = "Sempersona.findByTelPrincipal", query = "SELECT s FROM Sempersona s WHERE s.telPrincipal = :telPrincipal"),
    @NamedQuery(name = "Sempersona.findByFecUltmod", query = "SELECT s FROM Sempersona s WHERE s.fecUltmod = :fecUltmod"),
    @NamedQuery(name = "Sempersona.findByNomFantasia", query = "SELECT s FROM Sempersona s WHERE s.nomFantasia = :nomFantasia"),
    @NamedQuery(name = "Sempersona.findByUsuUltmod", query = "SELECT s FROM Sempersona s WHERE s.usuUltmod = :usuUltmod"),
    @NamedQuery(name = "Sempersona.findByDesPersona", query = "SELECT s FROM Sempersona s WHERE s.desPersona = :desPersona"),
    @NamedQuery(name = "Sempersona.findByDirPrincipal", query = "SELECT s FROM Sempersona s WHERE s.dirPrincipal = :dirPrincipal"),
    @NamedQuery(name = "Sempersona.findByIndEstciv", query = "SELECT s FROM Sempersona s WHERE s.indEstciv = :indEstciv"),
    @NamedQuery(name = "Sempersona.findByFecAlta", query = "SELECT s FROM Sempersona s WHERE s.fecAlta = :fecAlta"),
    @NamedQuery(name = "Sempersona.findByIndTipdocide", query = "SELECT s FROM Sempersona s WHERE s.sempersonaPK.indTipdocide = :indTipdocide"),
    @NamedQuery(name = "Sempersona.findByFecNaccon", query = "SELECT s FROM Sempersona s WHERE s.fecNaccon = :fecNaccon"),
    @NamedQuery(name = "Sempersona.findByNroPersona", query = "SELECT s FROM Sempersona s WHERE s.nroPersona = :nroPersona"),
    @NamedQuery(name = "Sempersona.findByIndTipsoc", query = "SELECT s FROM Sempersona s WHERE s.indTipsoc = :indTipsoc"),
    @NamedQuery(name = "Sempersona.findByIndActivo", query = "SELECT s FROM Sempersona s WHERE s.indActivo = :indActivo")})
public class Sempersona implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected SempersonaPK sempersonaPK;

    @JoinColumn(name = "ind_tipdocide", referencedColumnName = "ind_tipdocide", insertable = false, updatable = false)
    @ManyToOne(optional = false)
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
    @Column(name = "nro_persona")
    private int nroPersona;
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

    public Sempersona() {
    }

    public Sempersona(SempersonaPK sempersonaPK) {
        this.sempersonaPK = sempersonaPK;
    }

    public Sempersona(SempersonaPK sempersonaPK, String indTipper, String emailPrincipal, String indSexo, String usuAlta, String telPrincipal, Date fecUltmod, String nomFantasia, String usuUltmod, String desPersona, String dirPrincipal, String indEstciv, Date fecAlta, Date fecNaccon, int nroPersona, String indTipsoc, String indActivo) {
        this.sempersonaPK = sempersonaPK;
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
        this.nroPersona = nroPersona;
        this.indTipsoc = indTipsoc;
        this.indActivo = indActivo;
    }

    public Sempersona(String nroDocide, String indTipdocide) {
        this.sempersonaPK = new SempersonaPK(nroDocide, indTipdocide);
    }

    public SempersonaPK getSempersonaPK() {
        return sempersonaPK;
    }

    public void setSempersonaPK(SempersonaPK sempersonaPK) {
        this.sempersonaPK = sempersonaPK;
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

    public int getNroPersona() {
        return nroPersona;
    }

    public void setNroPersona(int nroPersona) {
        this.nroPersona = nroPersona;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sempersonaPK != null ? sempersonaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sempersona)) {
            return false;
        }
        Sempersona other = (Sempersona) object;
        if ((this.sempersonaPK == null && other.sempersonaPK != null) || (this.sempersonaPK != null && !this.sempersonaPK.equals(other.sempersonaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "py.gog.mca.sisexpedientes.entidades.Sempersona[ sempersonaPK=" + sempersonaPK + " ]";
    }

}
