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

/**
 *
 * @author vinsfran
 */
@Stateless
public class SedmovexpCrud {
    
    @PersistenceContext(unitName = "sisexpedientesPU")
    private EntityManager em;
    
    
    @SuppressWarnings("unchecked")
    public List<Sedmovexp> listarTodo() {
        Query q = em.createNamedQuery("Sedmovexp.findAll");
        return q.getResultList();
    }
    
    @SuppressWarnings("unchecked")
    public List<Sedmovexp> listarPorNroCarpetaEjerFiscal(Integer nroCarpeta, Integer indEjefiscar) {
        
        StringBuilder jpql = new StringBuilder();

        jpql.append("SELECT e ");
        jpql.append("FROM Sedmovexp e ");
        jpql.append("WHERE e.nroCarpeta = :paramNroCarpeta ");
        jpql.append("AND e.indEjefiscar = :paramIndEjefiscar ");
        jpql.append("ORDER BY e.fecAlta");

        //jpql.append("WHERE e.persona.nombre LIKE '%:paramNombre%'");
        Query q = em.createQuery(jpql.toString());
        q.setParameter("paramNroCarpeta", nroCarpeta);
        q.setParameter("paramIndEjefiscar", indEjefiscar);
        return q.getResultList();
    }
    
}
