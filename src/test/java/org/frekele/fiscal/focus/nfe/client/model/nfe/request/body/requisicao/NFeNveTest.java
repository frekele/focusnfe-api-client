package org.frekele.fiscal.focus.nfe.client.model.nfe.request.body.requisicao;

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

        NFeNve nFeNve = new NFeNve();
        nFeNve.setNve(nve);

        assertNotNull(nFeNve);
        assertEquals(nve, nFeNve.getNve());

        nFeNve = NFeNve.newBuilder()
            .withNve(nve)
            .build();

        assertNotNull(nFeNve);
        assertEquals(nve, nFeNve.getNve());
    }

    @Test
    public void testBeanValidation() throws Exception {
        NFeNve nFeNve = new NFeNve("TG5676");
        FocusNFeUtils.throwBeanValidation(nFeNve);
    }

    @Test(expectedExceptions = {ConstraintViolationException.class})
    public void testBeanValidationWithError() throws Exception {
        NFeNve nFeNve = new NFeNve("TG56761");
        FocusNFeUtils.throwBeanValidation(nFeNve);
    }
}
