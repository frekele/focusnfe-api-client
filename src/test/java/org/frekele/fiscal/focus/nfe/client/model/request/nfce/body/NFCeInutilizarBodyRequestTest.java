package org.frekele.fiscal.focus.nfe.client.model.request.nfce.body;

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
public class NFCeInutilizarBodyRequestTest {

    @Test
    public void testNewInstance() throws Exception {
        String cnpj = "65789876543234";
        String serie = "1";
        String numeroInicial = "123";
        String numeroFinal = "2345";
        String justificativa = "bla bla bla bla bla bla bla bla bla bla bla";

        NFCeInutilizarBodyRequest entity = new NFCeInutilizarBodyRequest();
        entity.setCnpj(cnpj);
        entity.setSerie(serie);
        entity.setNumeroInicial(numeroInicial);
        entity.setNumeroFinal(numeroFinal);
        entity.setJustificativa(justificativa);

        assertNotNull(entity);
        assertEquals(cnpj, entity.getCnpj());
        assertEquals(serie, entity.getSerie());
        assertEquals(numeroInicial, entity.getNumeroInicial());
        assertEquals(numeroFinal, entity.getNumeroFinal());
        assertEquals(justificativa, entity.getJustificativa());

        entity = NFCeInutilizarBodyRequest.newBuilder()
            .withCnpj(cnpj)
            .withSerie(serie)
            .withNumeroInicial(numeroInicial)
            .withNumeroFinal(numeroFinal)
            .withJustificativa(justificativa)
            .build();

        assertNotNull(entity);
        assertEquals(cnpj, entity.getCnpj());
        assertEquals(serie, entity.getSerie());
        assertEquals(numeroInicial, entity.getNumeroInicial());
        assertEquals(numeroFinal, entity.getNumeroFinal());
        assertEquals(justificativa, entity.getJustificativa());
    }

    @Test
    public void testBeanValidation() throws Exception {
        String cnpj = "65789876543234";
        String serie = "1";
        String numeroInicial = "123";
        String numeroFinal = "2345";
        String justificativa = "bla bla bla bla bla bla bla bla bla bla bla";

        NFCeInutilizarBodyRequest entity = new NFCeInutilizarBodyRequest(cnpj, serie, numeroInicial, numeroFinal, justificativa);
        FocusNFeUtils.throwBeanValidation(entity);
    }

    @Test(expectedExceptions = {ConstraintViolationException.class})
    public void testBeanValidationWithError() throws Exception {
        NFCeInutilizarBodyRequest entity = new NFCeInutilizarBodyRequest();
        FocusNFeUtils.throwBeanValidation(entity);
    }
}
