package org.frekele.fiscal.focus.nfe.client.model.request.nfe.body;

import org.frekele.fiscal.focus.nfe.client.model.request.nfe.body.NFeInutilizarBodyRequest;
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
public class NFeInutilizarBodyRequestTest {

    @Test
    public void testNewInstance() throws Exception {
        String cnpj = "65789876543234";
        String serie = "1";
        String numeroInicial = "123";
        String numeroFinal = "2345";
        String justificativa = "bla bla bla bla bla bla bla bla bla bla bla";

        NFeInutilizarBodyRequest entity = new NFeInutilizarBodyRequest();
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

        entity = NFeInutilizarBodyRequest.newBuilder()
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

        NFeInutilizarBodyRequest entity = new NFeInutilizarBodyRequest(cnpj, serie, numeroInicial, numeroFinal, justificativa);
        FocusNFeUtils.throwBeanValidation(entity);
    }

    @Test(expectedExceptions = {ConstraintViolationException.class})
    public void testBeanValidationWithError() throws Exception {
        NFeInutilizarBodyRequest entity = new NFeInutilizarBodyRequest();
        FocusNFeUtils.throwBeanValidation(entity);
    }
}
