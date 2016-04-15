/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bdprueba;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author vinsfran
 */
@Entity
@Table(name = "semexpediente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Semexpediente.findAll", query = "SELECT s FROM Semexpediente s"),
    @NamedQuery(name = "Semexpediente.findByNroExpediente", query = "SELECT s FROM Semexpediente s WHERE s.semexpedientePK.nroExpediente = :nroExpediente"),
    @NamedQuery(name = "Semexpediente.findByIndEjefisexp", query = "SELECT s FROM Semexpediente s WHERE s.semexpedientePK.indEjefisexp = :indEjefisexp")})
public class Semexpediente implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected SemexpedientePK semexpedientePK;
    @JoinColumn(name = "nro_estexp", referencedColumnName = "nro_estexp")
    @ManyToOne
    private Sebestexp nroEstexp;
    @JoinColumn(name = "cod_depen", referencedColumnName = "cod_depen")
    @ManyToOne
    private Semdepen codDepen;
    @JoinColumn(name = "nro_titular", referencedColumnName = "nro_persona")
    @ManyToOne
    private Sempersona nroTitular;
    @JoinColumn(name = "nro_representante", referencedColumnName = "nro_persona")
    @ManyToOne
    private Sempersona nroRepresentante;
    @JoinColumn(name = "nro_funcionario", referencedColumnName = "nro_persona")
    @ManyToOne
    private Sempersona nroFuncionario;
    @OneToMany(mappedBy = "semexpediente")
    private List<Sedmovexp> sedmovexpList;

    public Semexpediente() {
    }

    public Semexpediente(SemexpedientePK semexpedientePK) {
        this.semexpedientePK = semexpedientePK;
    }

    public Semexpediente(int nroExpediente, int indEjefisexp) {
        this.semexpedientePK = new SemexpedientePK(nroExpediente, indEjefisexp);
    }

    public SemexpedientePK getSemexpedientePK() {
        return semexpedientePK;
    }

    public void setSemexpedientePK(SemexpedientePK semexpedientePK) {
        this.semexpedientePK = semexpedientePK;
    }

    public Sebestexp getNroEstexp() {
        return nroEstexp;
    }

    public void setNroEstexp(Sebestexp nroEstexp) {
        this.nroEstexp = nroEstexp;
    }

    public Semdepen getCodDepen() {
        return codDepen;
    }

    public void setCodDepen(Semdepen codDepen) {
        this.codDepen = codDepen;
    }

    public Sempersona getNroTitular() {
        return nroTitular;
    }

    public void setNroTitular(Sempersona nroTitular) {
        this.nroTitular = nroTitular;
    }

    public Sempersona getNroRepresentante() {
        return nroRepresentante;
    }

    public void setNroRepresentante(Sempersona nroRepresentante) {
        this.nroRepresentante = nroRepresentante;
    }

    public Sempersona getNroFuncionario() {
        return nroFuncionario;
    }

    public void setNroFuncionario(Sempersona nroFuncionario) {
        this.nroFuncionario = nroFuncionario;
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
        hash += (semexpedientePK != null ? semexpedientePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Semexpediente)) {
            return false;
        }
        Semexpediente other = (Semexpediente) object;
        if ((this.semexpedientePK == null && other.semexpedientePK != null) || (this.semexpedientePK != null && !this.semexpedientePK.equals(other.semexpedientePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "py.gog.mca.mavenproject2.Semexpediente[ semexpedientePK=" + semexpedientePK + " ]";
    }
    
}
