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
public class SempersonaCrud {

    @PersistenceContext(unitName = "sisexpedientesPU")
    private EntityManager em;

    @SuppressWarnings("unchecked")
    public List<Sempersona> listarTodo() {
        Query q = em.createNamedQuery("Sempersona.findAll");
        return q.getResultList();
    }

    //Metodo que debe usar el ws para devolver las personas
    @SuppressWarnings("unchecked")
    public List<Sempersona> listarPorNroDocideIndTipdocide(String nroDocide, String indTipdocide) {
        StringBuilder jpql = new StringBuilder();
        jpql.append("SELECT e ");
        jpql.append("FROM Sempersona e ");
        jpql.append("WHERE e.sempersonaPK.nroDocide = :paramNroDocide ");
        jpql.append("AND e.sempersonaPK.indTipdocide = :paramIndTipdocide ");
        Query q = em.createQuery(jpql.toString());
        q.setParameter("paramNroDocide", nroDocide);
        q.setParameter("paramIndTipdocide", indTipdocide);
        if (q.getResultList().isEmpty()) {
            return null;
        } else {
            List<Sempersona> listaPersonas = q.getResultList();
            for (Sempersona listaPersona : listaPersonas) {
                listaPersona.setSemexpedienteListNroTitular(listarExpedientesPorNroPersona(listaPersona.getNroPersona()));
                for(int i=0; i < listaPersona.getSemexpedienteListNroTitular().size(); i++){
                    listaPersona.getSemexpedienteListNroTitular().get(i).setSedmovexpList(listarMovimientosExpedientePorNroCarpetaEjerFiscal(listaPersona.getSemexpedienteListNroTitular().get(i).getNroCarpeta(), listaPersona.getSemexpedienteListNroTitular().get(i).getIndEjefiscar()));
                }
            }
            return listaPersonas;
        }
    }

    @SuppressWarnings("unchecked")
    public List<Sempersona> listarPorNroDocide(String nroDocide) {
        StringBuilder jpql = new StringBuilder();
        jpql.append("SELECT e ");
        jpql.append("FROM Sempersona e ");
        jpql.append("WHERE e.sempersonaPK.nroDocide = :paramNroDocide ");
        //jpql.append("WHERE e.persona.nombre LIKE '%:paramNombre%'");
        Query q = em.createQuery(jpql.toString());
        q.setParameter("paramNroDocide", nroDocide);
        return q.getResultList();
    }

    @SuppressWarnings("unchecked")
    public Sempersona consultarPorNroPersona(Integer nroPersona) {
        Query q = em.createNamedQuery("Sempersona.findByNroPersona");
        q.setParameter("nroPersona", nroPersona);
        if (q.getResultList().isEmpty()) {
            return null;
        } else {
            return (Sempersona) q.getResultList().get(0);
        }

    }

    @SuppressWarnings("unchecked")
    private List<Semexpediente> listarExpedientesPorNroPersona(Integer nroTitular) {
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
