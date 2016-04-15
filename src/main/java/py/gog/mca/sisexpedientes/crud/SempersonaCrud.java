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

    @SuppressWarnings("unchecked")
    public List<Sempersona> listarPorNroDocideIndTipdocide(String nroDocide, String indTipdocide) {

        StringBuilder jpql = new StringBuilder();

        jpql.append("SELECT e ");
        jpql.append("FROM Sempersona e ");
        jpql.append("WHERE e.sempersonaPK.nroDocide = :paramNroDocide ");
        jpql.append("AND e.sempersonaPK.indTipdocide = :paramIndTipdocide ");

        //jpql.append("WHERE e.persona.nombre LIKE '%:paramNombre%'");
        Query q = em.createQuery(jpql.toString());
        q.setParameter("paramNroDocide", nroDocide);
        q.setParameter("paramIndTipdocide", indTipdocide);
        if(q.getResultList().isEmpty()){
            return null;
        }else{
            return q.getResultList();
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
}
