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
import py.gog.mca.sisexpedientes.entidades.Sebtipdocide;

/**
 *
 * @author vinsfran
 */
@Stateless
public class SebtipdocideCrud {
    
    @PersistenceContext(unitName = "sisexpedientesPU")
    private EntityManager em;
    
    
    @SuppressWarnings("unchecked")
    public List<Sebtipdocide> listarTodo() {
        Query q = em.createNamedQuery("Sebtipdocide.findAll");
        return q.getResultList();
    }
    
}
