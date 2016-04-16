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
@Table(name = "sebtipmov")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sebtipmov.findAll", query = "SELECT s FROM Sebtipmov s"),
    @NamedQuery(name = "Sebtipmov.findByNroTipmov", query = "SELECT s FROM Sebtipmov s WHERE s.nroTipmov = :nroTipmov"),
    @NamedQuery(name = "Sebtipmov.findByDesTipmov", query = "SELECT s FROM Sebtipmov s WHERE s.desTipmov = :desTipmov")})
public class Sebtipmov2 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "nro_tipmov")
    private Integer nroTipmov;
    @Size(max = 2147483647)
    @Column(name = "des_tipmov")
    private String desTipmov;
    @OneToMany(mappedBy = "nroTipmov")
    private List<Sedmovexp2> sedmovexpList;

    public Sebtipmov2() {
    }

    public Sebtipmov2(Integer nroTipmov) {
        this.nroTipmov = nroTipmov;
    }

    public Integer getNroTipmov() {
        return nroTipmov;
    }

    public void setNroTipmov(Integer nroTipmov) {
        this.nroTipmov = nroTipmov;
    }

    public String getDesTipmov() {
        return desTipmov;
    }

    public void setDesTipmov(String desTipmov) {
        this.desTipmov = desTipmov;
    }

    @XmlTransient
    public List<Sedmovexp2> getSedmovexpList() {
        return sedmovexpList;
    }

    public void setSedmovexpList(List<Sedmovexp2> sedmovexpList) {
        this.sedmovexpList = sedmovexpList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nroTipmov != null ? nroTipmov.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sebtipmov2)) {
            return false;
        }
        Sebtipmov2 other = (Sebtipmov2) object;
        if ((this.nroTipmov == null && other.nroTipmov != null) || (this.nroTipmov != null && !this.nroTipmov.equals(other.nroTipmov))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "py.gog.mca.mavenproject2.Sebtipmov[ nroTipmov=" + nroTipmov + " ]";
    }
    
}
