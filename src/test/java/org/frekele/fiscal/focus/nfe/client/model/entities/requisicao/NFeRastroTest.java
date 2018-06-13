package org.frekele.fiscal.focus.nfe.client.model.entities.requisicao;

import org.frekele.fiscal.focus.nfe.client.model.entities.requisicao.NFeRastro;
import org.frekele.fiscal.focus.nfe.client.testng.InvokedMethodListener;
import org.frekele.fiscal.focus.nfe.client.util.FocusNFeUtils;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import javax.validation.ConstraintViolationException;
import java.math.BigDecimal;
import java.time.LocalDate;

import static org.testng.Assert.*;

/**
 * @author frekele - Leandro Kersting de Freitas
 */
@Listeners(InvokedMethodListener.class)
public class NFeRastroTest {

    @Test
    public void testNewInstance() throws Exception {
        String numeroLote = "784235687456";
        BigDecimal quantidadeLote = new BigDecimal("314.45");
        LocalDate dataFabricacao = LocalDate.parse("2018-05-03");
        LocalDate dataValidade = LocalDate.parse("2019-05-03");
        String codigoAgregacao = "89457349574";

        NFeRastro entity = new NFeRastro();
        entity.setNumeroLote(numeroLote);
        entity.setQuantidadeLote(quantidadeLote);
        entity.setDataFabricacao(dataFabricacao);
        entity.setDataValidade(dataValidade);
        entity.setCodigoAgregacao(codigoAgregacao);

        assertNotNull(entity);
        assertEquals(numeroLote, entity.getNumeroLote());
        assertEquals(quantidadeLote, entity.getQuantidadeLote());
        assertEquals(dataFabricacao, entity.getDataFabricacao());
        assertEquals(dataValidade, entity.getDataValidade());
        assertEquals(codigoAgregacao, entity.getCodigoAgregacao());

        entity = NFeRastro.newBuilder()
            .withNumeroLote(numeroLote)
            .withQuantidadeLote(quantidadeLote)
            .withDataFabricacao(dataFabricacao)
            .withDataValidade(dataValidade)
            .withCodigoAgregacao(codigoAgregacao)
            .build();

        assertNotNull(entity);
        assertEquals(numeroLote, entity.getNumeroLote());
        assertEquals(quantidadeLote, entity.getQuantidadeLote());
        assertEquals(dataFabricacao, entity.getDataFabricacao());
        assertEquals(dataValidade, entity.getDataValidade());
        assertEquals(codigoAgregacao, entity.getCodigoAgregacao());
    }

    @Test
    public void testBeanValidation() throws Exception {
        NFeRastro entity = new NFeRastro();
        FocusNFeUtils.throwBeanValidation(entity);
    }

    @Test(expectedExceptions = {ConstraintViolationException.class})
    public void testBeanValidationWithError() throws Exception {
        NFeRastro entity = new NFeRastro();
        entity.setNumeroLote("28905474395438537459483573498547893");
        FocusNFeUtils.throwBeanValidation(entity);
    }
}
