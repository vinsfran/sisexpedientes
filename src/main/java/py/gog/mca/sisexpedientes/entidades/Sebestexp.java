/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.gog.mca.sisexpedientes.entidades;

import java.io.Serializable;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author vinsfran
 */
@Entity
@Table(name = "sebestexp")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sebestexp.findAll", query = "SELECT s FROM Sebestexp s"),
    @NamedQuery(name = "Sebestexp.findByDesEstexp", query = "SELECT s FROM Sebestexp s WHERE s.desEstexp = :desEstexp"),
    @NamedQuery(name = "Sebestexp.findByNroEstexp", query = "SELECT s FROM Sebestexp s WHERE s.nroEstexp = :nroEstexp")})
public class Sebestexp implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "des_estexp")
    private String desEstexp;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "nro_estexp")
    private Integer nroEstexp;

    public Sebestexp() {
    }

    public Sebestexp(Integer nroEstexp) {
        this.nroEstexp = nroEstexp;
    }

    public Sebestexp(Integer nroEstexp, String desEstexp) {
        this.nroEstexp = nroEstexp;
        this.desEstexp = desEstexp;
    }

    public String getDesEstexp() {
        return desEstexp;
    }

    public void setDesEstexp(String desEstexp) {
        this.desEstexp = desEstexp;
    }

    public Integer getNroEstexp() {
        return nroEstexp;
    }

    public void setNroEstexp(Integer nroEstexp) {
        this.nroEstexp = nroEstexp;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nroEstexp != null ? nroEstexp.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sebestexp)) {
            return false;
        }
        Sebestexp other = (Sebestexp) object;
        if ((this.nroEstexp == null && other.nroEstexp != null) || (this.nroEstexp != null && !this.nroEstexp.equals(other.nroEstexp))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "py.gog.mca.sisexpedientes.entidades.Sebestexp[ nroEstexp=" + nroEstexp + " ]";
    }

}
