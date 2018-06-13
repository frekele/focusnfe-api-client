package org.frekele.fiscal.focus.nfe.client.model.request.nfe.body;

import org.frekele.fiscal.focus.nfe.client.model.entities.requisicao.notafiscal.NFeEnvioRequisicaoNotaFiscal;
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
public class NFeAutorizarBodyRequestTest {

    @Test
    public void testNewInstance() throws Exception {
        NFeEnvioRequisicaoNotaFiscal nFeRequisicao = new NFeEnvioRequisicaoNotaFiscal();

        NFeAutorizarBodyRequest entity = new NFeAutorizarBodyRequest();
        entity.setNfe(nFeRequisicao);

        assertNotNull(entity);
        assertEquals(nFeRequisicao, entity.getNfe());

        entity = NFeAutorizarBodyRequest.newBuilder()
            .withNfe(nFeRequisicao)
            .build();

        assertNotNull(entity);
        assertEquals(nFeRequisicao, entity.getNfe());
    }

    @Test
    public void testBeanValidation() throws Exception {
        NFeAutorizarBodyRequest entity = new NFeAutorizarBodyRequest(new NFeEnvioRequisicaoNotaFiscal());
        FocusNFeUtils.throwBeanValidation(entity);
    }

    @Test(expectedExceptions = {ConstraintViolationException.class})
    public void testBeanValidationWithError() throws Exception {
        NFeAutorizarBodyRequest entity = new NFeAutorizarBodyRequest();
        FocusNFeUtils.throwBeanValidation(entity);
    }
}
