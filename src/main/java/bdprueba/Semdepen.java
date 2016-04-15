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
@Table(name = "semdepen")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Semdepen.findAll", query = "SELECT s FROM Semdepen s"),
    @NamedQuery(name = "Semdepen.findByCodDepen", query = "SELECT s FROM Semdepen s WHERE s.codDepen = :codDepen"),
    @NamedQuery(name = "Semdepen.findByDesDepen", query = "SELECT s FROM Semdepen s WHERE s.desDepen = :desDepen")})
public class Semdepen implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "cod_depen")
    private String codDepen;
    @Size(max = 2147483647)
    @Column(name = "des_depen")
    private String desDepen;
    @OneToMany(mappedBy = "codDepen")
    private List<Semexpediente> semexpedienteList;
    @OneToMany(mappedBy = "codDepen")
    private List<Sedmovexp> sedmovexpList;

    public Semdepen() {
    }

    public Semdepen(String codDepen) {
        this.codDepen = codDepen;
    }

    public String getCodDepen() {
        return codDepen;
    }

    public void setCodDepen(String codDepen) {
        this.codDepen = codDepen;
    }

    public String getDesDepen() {
        return desDepen;
    }

    public void setDesDepen(String desDepen) {
        this.desDepen = desDepen;
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
        return "py.gog.mca.mavenproject2.Semdepen[ codDepen=" + codDepen + " ]";
    }
    
}
