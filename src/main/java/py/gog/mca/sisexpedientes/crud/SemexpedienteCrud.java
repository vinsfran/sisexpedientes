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
import py.gog.mca.sisexpedientes.entidades.Semexpediente;

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
        if(q.getResultList().isEmpty()){
            return null;
        }else{
            return q.getResultList();
        }
    }

    @SuppressWarnings("unchecked")
    public List<Semexpediente> listarPorNroExpedienteIndEjefisexp(Integer nroExpediente, Integer indEjefisexp) {

        StringBuilder jpql = new StringBuilder();

        jpql.append("SELECT e ");
        jpql.append("FROM Semexpediente e ");
        jpql.append("WHERE e.semexpedientePK.nroExpediente = :paramNroExpediente ");
        jpql.append("AND e.semexpedientePK.indEjefisexp = :paramIndEjefisexp ");

        //jpql.append("WHERE e.persona.nombre LIKE '%:paramNombre%'");
        Query q = em.createQuery(jpql.toString());
        q.setParameter("paramNroExpediente", nroExpediente);
        q.setParameter("paramIndEjefisexp", indEjefisexp);
        return q.getResultList();
    }
}
