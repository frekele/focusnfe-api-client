package org.frekele.fiscal.focus.nfe.client.model.entities.requisicao.notafiscal;

import org.frekele.fiscal.focus.nfe.client.model.entities.requisicao.notafiscal.NFeDetalheExportacao;
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
public class NFeDetalheExportacaoTest {

    @Test
    public void testNewInstance() throws Exception {
        String numeroDrawback = "2394756";
        String numeroRe = "3453453";
        String chaveNfe = "45354354354343";
        BigDecimal quantidadeExportado = new BigDecimal("545.65");

        NFeDetalheExportacao entity = new NFeDetalheExportacao();
        entity.setNumeroDrawback(numeroDrawback);
        entity.setNumeroRe(numeroRe);
        entity.setChaveNfe(chaveNfe);
        entity.setQuantidadeExportado(quantidadeExportado);

        assertNotNull(entity);
        assertEquals(numeroDrawback, entity.getNumeroDrawback());
        assertEquals(numeroRe, entity.getNumeroRe());
        assertEquals(chaveNfe, entity.getChaveNfe());
        assertEquals(quantidadeExportado, entity.getQuantidadeExportado());

        entity = NFeDetalheExportacao.newBuilder()
            .withNumeroDrawback(numeroDrawback)
            .withNumeroRe(numeroRe)
            .withChaveNfe(chaveNfe)
            .withQuantidadeExportado(quantidadeExportado)
            .build();

        assertNotNull(entity);
        assertEquals(numeroDrawback, entity.getNumeroDrawback());
        assertEquals(numeroRe, entity.getNumeroRe());
        assertEquals(chaveNfe, entity.getChaveNfe());
        assertEquals(quantidadeExportado, entity.getQuantidadeExportado());
    }

    @Test
    public void testBeanValidation() throws Exception {
        NFeDetalheExportacao entity = new NFeDetalheExportacao();
        FocusNFeUtils.throwBeanValidation(entity);
    }

    @Test(expectedExceptions = {ConstraintViolationException.class})
    public void testBeanValidationWithError() throws Exception {
        NFeDetalheExportacao entity = new NFeDetalheExportacao();
        entity.setNumeroDrawback("1234567890123456789");
        FocusNFeUtils.throwBeanValidation(entity);
    }
}
