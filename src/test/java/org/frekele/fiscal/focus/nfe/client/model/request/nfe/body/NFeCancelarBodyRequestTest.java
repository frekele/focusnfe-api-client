package org.frekele.fiscal.focus.nfe.client.model.request.nfe.body;

import org.frekele.fiscal.focus.nfe.client.model.request.nfe.body.NFeCancelarBodyRequest;
import org.frekele.fiscal.focus.nfe.client.testng.InvokedMethodListener;
import org.frekele.fiscal.focus.nfe.client.util.FocusNFeUtils;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import javax.validation.ConstraintViolationException;

import static org.testng.Assert.*;

/**
 * @author frekele - Leandro Kersting de Freitas
 */
@Listeners(InvokedMethodListener.class)
public class NFeCancelarBodyRequestTest {

    @Test
    public void testNewInstance() throws Exception {
        String justificativa = "d fdghjdfhjsd gfjsd fjhdf hsjf dsjfh dsf";

        NFeCancelarBodyRequest entity = new NFeCancelarBodyRequest();
        entity.setJustificativa(justificativa);

        assertNotNull(entity);
        assertEquals(justificativa, entity.getJustificativa());

        entity = NFeCancelarBodyRequest.newBuilder()
            .withJustificativa(justificativa)
            .build();

        assertNotNull(entity);
        assertEquals(justificativa, entity.getJustificativa());
    }

    @Test
    public void testBeanValidation() throws Exception {
        NFeCancelarBodyRequest entity = new NFeCancelarBodyRequest("jdk fkjsdfkjsdfhk jsdfhkdjf hksdj sdjkfsdj");
        FocusNFeUtils.throwBeanValidation(entity);
    }

    @Test(expectedExceptions = {ConstraintViolationException.class})
    public void testBeanValidationWithError() throws Exception {
        NFeCancelarBodyRequest entity = new NFeCancelarBodyRequest();
        FocusNFeUtils.throwBeanValidation(entity);
    }
}
