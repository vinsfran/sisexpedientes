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
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
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
@Table(name = "semdepen")
@XmlRootElement
@XmlAccessorType(XmlAccessType.PUBLIC_MEMBER)
@NamedQueries({
    @NamedQuery(name = "Semdepen.findAll", query = "SELECT s FROM Semdepen s"),
    @NamedQuery(name = "Semdepen.findByFecUltmod", query = "SELECT s FROM Semdepen s WHERE s.fecUltmod = :fecUltmod"),
    @NamedQuery(name = "Semdepen.findByUsuAlta", query = "SELECT s FROM Semdepen s WHERE s.usuAlta = :usuAlta"),
    @NamedQuery(name = "Semdepen.findByCodDepen", query = "SELECT s FROM Semdepen s WHERE s.codDepen = :codDepen"),
    @NamedQuery(name = "Semdepen.findByNroMesent", query = "SELECT s FROM Semdepen s WHERE s.nroMesent = :nroMesent"),
    @NamedQuery(name = "Semdepen.findByUsuUltmod", query = "SELECT s FROM Semdepen s WHERE s.usuUltmod = :usuUltmod"),
    @NamedQuery(name = "Semdepen.findByDesDepen", query = "SELECT s FROM Semdepen s WHERE s.desDepen = :desDepen"),
    @NamedQuery(name = "Semdepen.findByFecAlta", query = "SELECT s FROM Semdepen s WHERE s.fecAlta = :fecAlta")})
public class Semdepen implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 14)
    @Column(name = "cod_depen")
    private String codDepen;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "des_depen")
    private String desDepen;

    @Basic(optional = false)
    @NotNull
    @Column(name = "nro_mesent")
    private int nroMesent;

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

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "usu_ultmod")
    private String usuUltmod;

    @Basic(optional = false)
    @NotNull
    @Column(name = "fec_ultmod")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecUltmod;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codDepen")
    private List<Semexpediente> semexpedienteList;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codDepen")
    private List<Sedmovexp> sedmovexpList;

    public Semdepen() {
    }

    public Semdepen(String codDepen) {
        this.codDepen = codDepen;
    }

    public Semdepen(String codDepen, Date fecUltmod, String usuAlta, int nroMesent, String usuUltmod, String desDepen, Date fecAlta) {
        this.codDepen = codDepen;
        this.fecUltmod = fecUltmod;
        this.usuAlta = usuAlta;
        this.nroMesent = nroMesent;
        this.usuUltmod = usuUltmod;
        this.desDepen = desDepen;
        this.fecAlta = fecAlta;
    }

    public Date getFecUltmod() {
        return fecUltmod;
    }

    public void setFecUltmod(Date fecUltmod) {
        this.fecUltmod = fecUltmod;
    }

    public String getUsuAlta() {
        return usuAlta;
    }

    public void setUsuAlta(String usuAlta) {
        this.usuAlta = usuAlta;
    }

    public String getCodDepen() {
        return codDepen;
    }

    public void setCodDepen(String codDepen) {
        this.codDepen = codDepen;
    }

    public int getNroMesent() {
        return nroMesent;
    }

    public void setNroMesent(int nroMesent) {
        this.nroMesent = nroMesent;
    }

    public String getUsuUltmod() {
        return usuUltmod;
    }

    public void setUsuUltmod(String usuUltmod) {
        this.usuUltmod = usuUltmod;
    }

    public String getDesDepen() {
        return desDepen;
    }

    public void setDesDepen(String desDepen) {
        this.desDepen = desDepen;
    }

    public Date getFecAlta() {
        return fecAlta;
    }

    public void setFecAlta(Date fecAlta) {
        this.fecAlta = fecAlta;
    }

    @XmlTransient
    public List<Semexpediente> getSemexpedienteList() {
        return semexpedienteList;
    }

    public void setSemexpedienteList(List<Semexpediente> semexpedienteList) {
        this.semexpedienteList = semexpedienteList;
    }

    @XmlTransient
    public List<Sedmovexp> getSedmovexpList() {
        return sedmovexpList;
    }

    public void setSedmovexpList(List<Sedmovexp> sedmovexpList) {
        this.sedmovexpList = sedmovexpList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codDepen != null ? codDepen.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Semdepen)) {
            return false;
        }
        Semdepen other = (Semdepen) object;
        if ((this.codDepen == null && other.codDepen != null) || (this.codDepen != null && !this.codDepen.equals(other.codDepen))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "py.gog.mca.sisexpedientes.entidades.Semdepen[ codDepen=" + codDepen + " ]";
    }

}
