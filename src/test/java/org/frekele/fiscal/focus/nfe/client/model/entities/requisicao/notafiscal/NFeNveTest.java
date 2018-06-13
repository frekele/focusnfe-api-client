package org.frekele.fiscal.focus.nfe.client.model.entities.requisicao.notafiscal;

import org.frekele.fiscal.focus.nfe.client.model.entities.requisicao.notafiscal.NFeNve;
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
public class NFeNveTest {

    @Test
    public void testNewInstance() throws Exception {
        String nve = "FR3476";

        NFeNve entity = new NFeNve();
        entity.setNve(nve);

        assertNotNull(entity);
        assertEquals(nve, entity.getNve());

        entity = NFeNve.newBuilder()
            .withNve(nve)
            .build();

        assertNotNull(entity);
        assertEquals(nve, entity.getNve());
    }

    @Test
    public void testBeanValidation() throws Exception {
        NFeNve entity = new NFeNve("TG5676");
        FocusNFeUtils.throwBeanValidation(entity);
    }

    @Test(expectedExceptions = {ConstraintViolationException.class})
    public void testBeanValidationWithError() throws Exception {
        NFeNve entity = new NFeNve("TG56761");
        FocusNFeUtils.throwBeanValidation(entity);
    }
}
