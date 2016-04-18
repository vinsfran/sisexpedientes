/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.gog.mca.sisexpedientes.crud;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import py.gog.mca.sisexpedientes.entidades.Sedmovexp;
import py.gog.mca.sisexpedientes.entidades.Semexpediente;
import py.gog.mca.sisexpedientes.entidades.Sempersona;

/**
 *
 * @author vinsfran
 */
@Stateless
public class SemexpedienteCrud {

    @PersistenceContext(unitName = "sisexpedientesPU")
    private EntityManager em;

    @SuppressWarnings("unchecked")
    public List<Semexpediente> listarTodo() {
        Query q = em.createNamedQuery("Semexpediente.findAll");
        return q.getResultList();
    }
    
    
    @SuppressWarnings("unchecked")
    public List<Semexpediente> listarPorNroTitular(Integer nroTitular) {
        StringBuilder jpql = new StringBuilder();
        jpql.append("SELECT e ");
        jpql.append("FROM Semexpediente e ");
        jpql.append("WHERE e.nroTitular = :paramNroTitular ");
        //jpql.append("WHERE e.persona.nombre LIKE '%:paramNombre%'");
        Query q = em.createQuery(jpql.toString());
        q.setParameter("paramNroTitular", nroTitular);
        if (q.getResultList().isEmpty()) {
            return null;
        } else {
            return q.getResultList();
        }
    }

    //Metodo que debe usar el ws para devolver los expedientes
    @SuppressWarnings("unchecked")
    public List<Semexpediente> listarPorNroExpedienteIndEjefisexp(Integer nroExpediente, Integer indEjefisexp) {
        StringBuilder jpql = new StringBuilder();
        jpql.append("SELECT e ");
        jpql.append("FROM Semexpediente e ");
        jpql.append("WHERE e.semexpedientePK.nroExpediente = :paramNroExpediente ");
        jpql.append("AND e.semexpedientePK.indEjefisexp = :paramIndEjefisexp ");
        Query q = em.createQuery(jpql.toString());
        q.setParameter("paramNroExpediente", nroExpediente);
        q.setParameter("paramIndEjefisexp", indEjefisexp);
        if (q.getResultList().isEmpty()) {
            return null;
        } else {
            List<Semexpediente> listaExpedientes = q.getResultList();
            for (Semexpediente listaExpediente : listaExpedientes) {
                listaExpediente.setNroTitularJava(consultarPorNroPersona(listaExpediente.getNroTitular()));
                listaExpediente.setSedmovexpList(listarMovimientosExpedientePorNroCarpetaEjerFiscal(listaExpediente.getSemexpedientePK().getNroExpediente(), listaExpediente.getSemexpedientePK().getIndEjefisexp()));
            }
            return listaExpedientes;
        }
    }

    @SuppressWarnings("unchecked")
    private Sempersona consultarPorNroPersona(Integer nroPersona) {
        Query q = em.createNamedQuery("Sempersona.findByNroPersona");
        q.setParameter("nroPersona", nroPersona);
        if (q.getResultList().isEmpty()) {
            return null;
        } else {
            return (Sempersona) q.getResultList().get(0);
        }
    }

    @SuppressWarnings("unchecked")
    private List<Sedmovexp> listarMovimientosExpedientePorNroCarpetaEjerFiscal(Integer nroCarpeta, Integer indEjefiscar) {
        StringBuilder jpql = new StringBuilder();
        jpql.append("SELECT e ");
        jpql.append("FROM Sedmovexp e ");
        jpql.append("WHERE e.nroCarpeta = :paramNroCarpeta ");
        jpql.append("AND e.indEjefiscar = :paramIndEjefiscar ");
        jpql.append("ORDER BY e.fecAlta");
        Query q = em.createQuery(jpql.toString());
        q.setParameter("paramNroCarpeta", nroCarpeta);
        q.setParameter("paramIndEjefiscar", indEjefiscar);
        return q.getResultList();
    }
}
