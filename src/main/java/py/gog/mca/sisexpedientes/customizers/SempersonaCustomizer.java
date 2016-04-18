/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.gog.mca.sisexpedientes.customizers;

import org.eclipse.persistence.config.DescriptorCustomizer;
import org.eclipse.persistence.descriptors.ClassDescriptor;
import org.eclipse.persistence.expressions.Expression;
import org.eclipse.persistence.expressions.ExpressionBuilder;
import org.eclipse.persistence.mappings.OneToManyMapping;

/**
 *
 * @author vinsfran
 */
public class SempersonaCustomizer implements DescriptorCustomizer {     
	@Override     
	public void customize(ClassDescriptor descriptor) throws Exception {
         OneToManyMapping mapping = (OneToManyMapping)descriptor.getMappingForAttributeName("nro_persona");
         ExpressionBuilder builder = new ExpressionBuilder();
         Expression expression = builder.getField("CONTATTO.ID").equal(builder.getParameter("RECAPITO.ID_CONTATTO"));
         mapping.setSelectionCriteria(expression);
    } 
}  

