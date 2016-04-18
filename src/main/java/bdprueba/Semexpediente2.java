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
    @NamedQuery(name = "Semexpediente2.findAll", query = "SELECT s FROM Semexpediente2 s"),
    @NamedQuery(name = "Semexpediente2.findByNroExpediente", query = "SELECT s FROM Semexpediente2 s WHERE s.semexpedientePK.nroExpediente = :nroExpediente"),
    @NamedQuery(name = "Semexpediente2.findByIndEjefisexp", query = "SELECT s FROM Semexpediente2 s WHERE s.semexpedientePK.indEjefisexp = :indEjefisexp")})
public class Semexpediente2 implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @EmbeddedId
    protected SemexpedientePK2 semexpedientePK;
    
    @JoinColumn(name = "nro_estexp", referencedColumnName = "nro_estexp")
    @ManyToOne
    private Sebestexp2 nroEstexp;
    
    @JoinColumn(name = "cod_depen", referencedColumnName = "cod_depen")
    @ManyToOne
    private Semdepen2 codDepen;
    
    @JoinColumn(name = "nro_titular", referencedColumnName = "nro_persona")
    @ManyToOne
    private Sempersona2 nroTitular;
    
    @JoinColumn(name = "nro_representante", referencedColumnName = "nro_persona")
    @ManyToOne
    private Sempersona2 nroRepresentante;
    
    @JoinColumn(name = "nro_funcionario", referencedColumnName = "nro_persona")
    @ManyToOne
    private Sempersona2 nroFuncionario;
    
    @OneToMany(mappedBy = "semexpediente")
    private List<Sedmovexp2> sedmovexpList;

    public Semexpediente2() {
    }

    public Semexpediente2(SemexpedientePK2 semexpedientePK) {
        this.semexpedientePK = semexpedientePK;
    }

    public Semexpediente2(int nroExpediente, int indEjefisexp) {
        this.semexpedientePK = new SemexpedientePK2(nroExpediente, indEjefisexp);
    }

    public SemexpedientePK2 getSemexpedientePK() {
        return semexpedientePK;
    }

    public void setSemexpedientePK(SemexpedientePK2 semexpedientePK) {
        this.semexpedientePK = semexpedientePK;
    }

    public Sebestexp2 getNroEstexp() {
        return nroEstexp;
    }

    public void setNroEstexp(Sebestexp2 nroEstexp) {
        this.nroEstexp = nroEstexp;
    }

    public Semdepen2 getCodDepen() {
        return codDepen;
    }

    public void setCodDepen(Semdepen2 codDepen) {
        this.codDepen = codDepen;
    }

    public Sempersona2 getNroTitular() {
        return nroTitular;
    }

    public void setNroTitular(Sempersona2 nroTitular) {
        this.nroTitular = nroTitular;
    }

    public Sempersona2 getNroRepresentante() {
        return nroRepresentante;
    }

    public void setNroRepresentante(Sempersona2 nroRepresentante) {
        this.nroRepresentante = nroRepresentante;
    }

    public Sempersona2 getNroFuncionario() {
        return nroFuncionario;
    }

    public void setNroFuncionario(Sempersona2 nroFuncionario) {
        this.nroFuncionario = nroFuncionario;
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
        hash += (semexpedientePK != null ? semexpedientePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Semexpediente2)) {
            return false;
        }
        Semexpediente2 other = (Semexpediente2) object;
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
