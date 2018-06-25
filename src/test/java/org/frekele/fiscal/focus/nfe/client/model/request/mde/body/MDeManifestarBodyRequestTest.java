package org.frekele.fiscal.focus.nfe.client.model.request.mde.body;

import org.frekele.fiscal.focus.nfe.client.enumeration.MDeTipoManifestacaoEnum;
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
public class MDeManifestarBodyRequestTest {

    @Test
    public void testNewInstance() throws Exception {
        MDeTipoManifestacaoEnum tipo = MDeTipoManifestacaoEnum.CIENCIA;
        String justificativa = "bla bla bla bla bla bla bla bla";

        MDeManifestarBodyRequest entity = new MDeManifestarBodyRequest();
        entity.setTipo(tipo);
        entity.setJustificativa(justificativa);

        assertNotNull(entity);
        assertEquals(tipo, entity.getTipo());
        assertEquals(justificativa, entity.getJustificativa());

        entity = MDeManifestarBodyRequest.newBuilder()
            .withTipo(tipo)
            .withJustificativa(justificativa)
            .build();

        assertNotNull(entity);
        assertEquals(tipo, entity.getTipo());
        assertEquals(justificativa, entity.getJustificativa());
    }

    @Test
    public void testBeanValidation() throws Exception {
        MDeTipoManifestacaoEnum tipo = MDeTipoManifestacaoEnum.CIENCIA;
        String justificativa = "bla bla bla bla bla bla bla bla";

        MDeManifestarBodyRequest entity = new MDeManifestarBodyRequest(tipo);
        FocusNFeUtils.throwBeanValidation(entity);

        entity = new MDeManifestarBodyRequest(tipo, justificativa);
        FocusNFeUtils.throwBeanValidation(entity);
    }

    @Test(expectedExceptions = {ConstraintViolationException.class})
    public void testBeanValidationWithError() throws Exception {
        MDeManifestarBodyRequest entity = new MDeManifestarBodyRequest();
        FocusNFeUtils.throwBeanValidation(entity);
    }
}
