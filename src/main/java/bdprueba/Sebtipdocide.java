/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bdprueba;

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
@Table(name = "sebtipdocide")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sebtipdocide.findAll", query = "SELECT s FROM Sebtipdocide s"),
    @NamedQuery(name = "Sebtipdocide.findByIndTipdocide", query = "SELECT s FROM Sebtipdocide s WHERE s.indTipdocide = :indTipdocide"),
    @NamedQuery(name = "Sebtipdocide.findByDesTipdocide", query = "SELECT s FROM Sebtipdocide s WHERE s.desTipdocide = :desTipdocide")})
public class Sebtipdocide implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "ind_tipdocide")
    private String indTipdocide;
    @Size(max = 2147483647)
    @Column(name = "des_tipdocide")
    private String desTipdocide;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "indTipdocide")
    private List<Sempersona> sempersonaList;

    public Sebtipdocide() {
    }

    public Sebtipdocide(String indTipdocide) {
        this.indTipdocide = indTipdocide;
    }

    public String getIndTipdocide() {
        return indTipdocide;
    }

    public void setIndTipdocide(String indTipdocide) {
        this.indTipdocide = indTipdocide;
    }

    public String getDesTipdocide() {
        return desTipdocide;
    }

    public void setDesTipdocide(String desTipdocide) {
        this.desTipdocide = desTipdocide;
    }

    @XmlTransient
    public List<Sempersona> getSempersonaList() {
        return sempersonaList;
    }

    public void setSempersonaList(List<Sempersona> sempersonaList) {
        this.sempersonaList = sempersonaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (indTipdocide != null ? indTipdocide.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sebtipdocide)) {
            return false;
        }
        Sebtipdocide other = (Sebtipdocide) object;
        if ((this.indTipdocide == null && other.indTipdocide != null) || (this.indTipdocide != null && !this.indTipdocide.equals(other.indTipdocide))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "py.gog.mca.mavenproject2.Sebtipdocide[ indTipdocide=" + indTipdocide + " ]";
    }
    
}
