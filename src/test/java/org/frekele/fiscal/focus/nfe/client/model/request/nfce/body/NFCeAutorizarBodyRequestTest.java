package org.frekele.fiscal.focus.nfe.client.model.request.nfce.body;

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
public class NFCeAutorizarBodyRequestTest {

    @Test
    public void testNewInstance() throws Exception {
        NFeEnvioRequisicaoNotaFiscal nfceRequisicao = new NFeEnvioRequisicaoNotaFiscal();

        NFCeAutorizarBodyRequest entity = new NFCeAutorizarBodyRequest();
        entity.setNfce(nfceRequisicao);

        assertNotNull(entity);
        assertEquals(nfceRequisicao, entity.getNfce());

        entity = NFCeAutorizarBodyRequest.newBuilder()
            .withNfce(nfceRequisicao)
            .build();

        assertNotNull(entity);
        assertEquals(nfceRequisicao, entity.getNfce());
    }

    @Test
    public void testBeanValidation() throws Exception {
        NFCeAutorizarBodyRequest entity = new NFCeAutorizarBodyRequest(new NFeEnvioRequisicaoNotaFiscal());
        FocusNFeUtils.throwBeanValidation(entity);
    }

    @Test(expectedExceptions = {ConstraintViolationException.class})
    public void testBeanValidationWithError() throws Exception {
        NFCeAutorizarBodyRequest entity = new NFCeAutorizarBodyRequest();
        FocusNFeUtils.throwBeanValidation(entity);
    }
}
