/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.gog.mca.sisexpedientes.entidades;

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
    @NamedQuery(name = "Sebtipmov.findByDesTipmov", query = "SELECT s FROM Sebtipmov s WHERE s.desTipmov = :desTipmov"),
    @NamedQuery(name = "Sebtipmov.findByNroTipmov", query = "SELECT s FROM Sebtipmov s WHERE s.nroTipmov = :nroTipmov")})
public class Sebtipmov implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "nro_tipmov")
    private Integer nroTipmov;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "des_tipmov")
    private String desTipmov;
    
    @OneToMany(mappedBy = "nroTipmov")
    private List<Sedmovexp> sedmovexpList;

    public Sebtipmov() {
    }

    public Sebtipmov(Integer nroTipmov) {
        this.nroTipmov = nroTipmov;
    }

    public Sebtipmov(Integer nroTipmov, String desTipmov) {
        this.nroTipmov = nroTipmov;
        this.desTipmov = desTipmov;
    }

    public String getDesTipmov() {
        return desTipmov;
    }

    public void setDesTipmov(String desTipmov) {
        this.desTipmov = desTipmov;
    }

    public Integer getNroTipmov() {
        return nroTipmov;
    }

    public void setNroTipmov(Integer nroTipmov) {
        this.nroTipmov = nroTipmov;
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
        hash += (nroTipmov != null ? nroTipmov.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sebtipmov)) {
            return false;
        }
        Sebtipmov other = (Sebtipmov) object;
        if ((this.nroTipmov == null && other.nroTipmov != null) || (this.nroTipmov != null && !this.nroTipmov.equals(other.nroTipmov))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "py.gog.mca.sisexpedientes.entidades.Sebtipmov[ nroTipmov=" + nroTipmov + " ]";
    }

}
