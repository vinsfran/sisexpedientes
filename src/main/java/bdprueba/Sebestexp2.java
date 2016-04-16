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
@Table(name = "sebestexp")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sebestexp.findAll", query = "SELECT s FROM Sebestexp s"),
    @NamedQuery(name = "Sebestexp.findByNroEstexp", query = "SELECT s FROM Sebestexp s WHERE s.nroEstexp = :nroEstexp"),
    @NamedQuery(name = "Sebestexp.findByDesEstexp", query = "SELECT s FROM Sebestexp s WHERE s.desEstexp = :desEstexp")})
public class Sebestexp2 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "nro_estexp")
    private Integer nroEstexp;
    @Size(max = 2147483647)
    @Column(name = "des_estexp")
    private String desEstexp;
    @OneToMany(mappedBy = "nroEstexp")
    private List<Semexpediente2> semexpedienteList;
    @OneToMany(mappedBy = "nroEstexp")
    private List<Sedmovexp2> sedmovexpList;

    public Sebestexp2() {
    }

    public Sebestexp2(Integer nroEstexp) {
        this.nroEstexp = nroEstexp;
    }

    public Integer getNroEstexp() {
        return nroEstexp;
    }

    public void setNroEstexp(Integer nroEstexp) {
        this.nroEstexp = nroEstexp;
    }

    public String getDesEstexp() {
        return desEstexp;
    }

    public void setDesEstexp(String desEstexp) {
        this.desEstexp = desEstexp;
    }

    @XmlTransient
    public List<Semexpediente2> getSemexpedienteList() {
        return semexpedienteList;
    }

    public void setSemexpedienteList(List<Semexpediente2> semexpedienteList) {
        this.semexpedienteList = semexpedienteList;
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
        hash += (nroEstexp != null ? nroEstexp.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sebestexp2)) {
            return false;
        }
        Sebestexp2 other = (Sebestexp2) object;
        if ((this.nroEstexp == null && other.nroEstexp != null) || (this.nroEstexp != null && !this.nroEstexp.equals(other.nroEstexp))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "py.gog.mca.mavenproject2.Sebestexp[ nroEstexp=" + nroEstexp + " ]";
    }
    
}
