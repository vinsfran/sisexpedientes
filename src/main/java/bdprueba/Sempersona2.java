/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bdprueba;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author vinsfran
 */
@Entity
@Table(name = "sempersona")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sempersona2.findAll", query = "SELECT s FROM Sempersona2 s"),
    @NamedQuery(name = "Sempersona2.findByNroDocide", query = "SELECT s FROM Sempersona2 s WHERE s.nroDocide = :nroDocide"),
    @NamedQuery(name = "Sempersona2.findByObsPersona", query = "SELECT s FROM Sempersona2 s WHERE s.obsPersona = :obsPersona"),
    @NamedQuery(name = "Sempersona2.findByNroPersona", query = "SELECT s FROM Sempersona2 s WHERE s.nroPersona = :nroPersona")})
public class Sempersona2 implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "nro_persona")
    private Integer nroPersona;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "nro_docide")
    private String nroDocide;

    @JoinColumn(name = "ind_tipdocide", referencedColumnName = "ind_tipdocide")
    @ManyToOne(optional = false)
    private Sebtipdocide2 indTipdocide;

    @Size(max = 2147483647)
    @Column(name = "obs_persona")
    private String obsPersona;

    @OneToMany(mappedBy = "nroTitular")
    private List<Semexpediente2> semexpedienteList;
    @OneToMany(mappedBy = "nroRepresentante")
    private List<Semexpediente2> semexpedienteList1;
    @OneToMany(mappedBy = "nroFuncionario")
    private List<Semexpediente2> semexpedienteList2;
    @OneToMany(mappedBy = "nroFuncionario")
    private List<Sedmovexp2> sedmovexpList;

    public Sempersona2() {
    }

    public Sempersona2(Integer nroPersona) {
        this.nroPersona = nroPersona;
    }

    public Sempersona2(Integer nroPersona, String nroDocide) {
        this.nroPersona = nroPersona;
        this.nroDocide = nroDocide;
    }

    public String getNroDocide() {
        return nroDocide;
    }

    public void setNroDocide(String nroDocide) {
        this.nroDocide = nroDocide;
    }

    public String getObsPersona() {
        return obsPersona;
    }

    public void setObsPersona(String obsPersona) {
        this.obsPersona = obsPersona;
    }

    public Integer getNroPersona() {
        return nroPersona;
    }

    public void setNroPersona(Integer nroPersona) {
        this.nroPersona = nroPersona;
    }

    @XmlTransient
    public List<Semexpediente2> getSemexpedienteList() {
        return semexpedienteList;
    }

    public void setSemexpedienteList(List<Semexpediente2> semexpedienteList) {
        this.semexpedienteList = semexpedienteList;
    }

    @XmlTransient
    public List<Semexpediente2> getSemexpedienteList1() {
        return semexpedienteList1;
    }

    public void setSemexpedienteList1(List<Semexpediente2> semexpedienteList1) {
        this.semexpedienteList1 = semexpedienteList1;
    }

    @XmlTransient
    public List<Semexpediente2> getSemexpedienteList2() {
        return semexpedienteList2;
    }

    public void setSemexpedienteList2(List<Semexpediente2> semexpedienteList2) {
        this.semexpedienteList2 = semexpedienteList2;
    }

    @XmlTransient
    public List<Sedmovexp2> getSedmovexpList() {
        return sedmovexpList;
    }

    public void setSedmovexpList(List<Sedmovexp2> sedmovexpList) {
        this.sedmovexpList = sedmovexpList;
    }

    public Sebtipdocide2 getIndTipdocide() {
        return indTipdocide;
    }

    public void setIndTipdocide(Sebtipdocide2 indTipdocide) {
        this.indTipdocide = indTipdocide;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nroPersona != null ? nroPersona.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sempersona2)) {
            return false;
        }
        Sempersona2 other = (Sempersona2) object;
        if ((this.nroPersona == null && other.nroPersona != null) || (this.nroPersona != null && !this.nroPersona.equals(other.nroPersona))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "py.gog.mca.mavenproject2.Sempersona[ nroPersona=" + nroPersona + " ]";
    }

}
