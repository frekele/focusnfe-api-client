package org.frekele.fiscal.focus.nfe.client.model.entities.requisicao.notafiscal;

import org.frekele.fiscal.focus.nfe.client.model.entities.requisicao.notafiscal.NFeAdicaoDocumentoImportacao;
import org.frekele.fiscal.focus.nfe.client.testng.InvokedMethodListener;
import org.frekele.fiscal.focus.nfe.client.util.FocusNFeUtils;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import javax.validation.ConstraintViolationException;
import java.math.BigDecimal;

import static org.testng.Assert.*;

/**
 * @author frekele - Leandro Kersting de Freitas
 */
@Listeners(InvokedMethodListener.class)
public class NFeAdicaoDocumentoImportacaoTest {

    @Test
    public void testNewInstance() throws Exception {
        String numero = "123";
        String numeroSequencialItem = "123";
        String codigoFabricanteEstrangeiro = "23767845";
        BigDecimal valorDesconto = new BigDecimal("1234.34");
        String numeroDrawback = "23567";

        NFeAdicaoDocumentoImportacao entity = new NFeAdicaoDocumentoImportacao();
        entity.setNumero(numero);
        entity.setNumeroSequencialItem(numeroSequencialItem);
        entity.setCodigoFabricanteEstrangeiro(codigoFabricanteEstrangeiro);
        entity.setValorDesconto(valorDesconto);
        entity.setNumeroDrawback(numeroDrawback);

        assertNotNull(entity);
        assertEquals(numero, entity.getNumero());
        assertEquals(numeroSequencialItem, entity.getNumeroSequencialItem());
        assertEquals(codigoFabricanteEstrangeiro, entity.getCodigoFabricanteEstrangeiro());
        assertEquals(valorDesconto, entity.getValorDesconto());
        assertEquals(numeroDrawback, entity.getNumeroDrawback());

        entity = NFeAdicaoDocumentoImportacao.newBuilder()
            .withNumero(numero)
            .withNumeroSequencialItem(numeroSequencialItem)
            .withCodigoFabricanteEstrangeiro(codigoFabricanteEstrangeiro)
            .withValorDesconto(valorDesconto)
            .withNumeroDrawback(numeroDrawback)
            .build();

        assertNotNull(entity);
        assertEquals(numero, entity.getNumero());
        assertEquals(numeroSequencialItem, entity.getNumeroSequencialItem());
        assertEquals(codigoFabricanteEstrangeiro, entity.getCodigoFabricanteEstrangeiro());
        assertEquals(valorDesconto, entity.getValorDesconto());
        assertEquals(numeroDrawback, entity.getNumeroDrawback());
    }

    @Test
    public void testBeanValidation() throws Exception {
        NFeAdicaoDocumentoImportacao entity = new NFeAdicaoDocumentoImportacao();
        FocusNFeUtils.throwBeanValidation(entity);
    }

    @Test(expectedExceptions = {ConstraintViolationException.class})
    public void testBeanValidationWithError() throws Exception {
        NFeAdicaoDocumentoImportacao entity = new NFeAdicaoDocumentoImportacao();
        entity.setNumero("12345");
        FocusNFeUtils.throwBeanValidation(entity);
    }
}
