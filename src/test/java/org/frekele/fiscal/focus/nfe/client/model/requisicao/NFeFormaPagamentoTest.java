package org.frekele.fiscal.focus.nfe.client.model.requisicao;

import org.frekele.fiscal.focus.nfe.client.enumeration.NFeBandeiraOperadoraEnum;
import org.frekele.fiscal.focus.nfe.client.enumeration.NFeFormaPagamentoEnum;
import org.frekele.fiscal.focus.nfe.client.enumeration.NFeTipoIntegracaoEnum;
import org.frekele.fiscal.focus.nfe.client.model.entities.requisicao.NFeFormaPagamento;
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
public class NFeFormaPagamentoTest {

    @Test
    public void testNewInstance() throws Exception {
        NFeFormaPagamentoEnum formaPagamento = NFeFormaPagamentoEnum.SEM_PAGAMENTO;
        BigDecimal valorPagamento = new BigDecimal("234.34");
        NFeTipoIntegracaoEnum tipoIntegracao = NFeTipoIntegracaoEnum.PAGAMENTO_INTEGRADO_COM_SISTEMA_DE_AUTOMACAO;
        String cnpjCredenciadora = "789765431234564";
        NFeBandeiraOperadoraEnum bandeiraOperadora = NFeBandeiraOperadoraEnum.MASTERCARD;
        String numeroAutorizacao = "743658734";
        BigDecimal valorTroco = new BigDecimal("33.45");

        NFeFormaPagamento entity = new NFeFormaPagamento();
        entity.setFormaPagamento(formaPagamento);
        entity.setValorPagamento(valorPagamento);
        entity.setTipoIntegracao(tipoIntegracao);
        entity.setCnpjCredenciadora(cnpjCredenciadora);
        entity.setBandeiraOperadora(bandeiraOperadora);
        entity.setNumeroAutorizacao(numeroAutorizacao);
        entity.setValorTroco(valorTroco);

        assertNotNull(entity);
        assertEquals(formaPagamento, entity.getFormaPagamento());
        assertEquals(valorPagamento, entity.getValorPagamento());
        assertEquals(tipoIntegracao, entity.getTipoIntegracao());
        assertEquals(cnpjCredenciadora, entity.getCnpjCredenciadora());
        assertEquals(bandeiraOperadora, entity.getBandeiraOperadora());
        assertEquals(numeroAutorizacao, entity.getNumeroAutorizacao());
        assertEquals(valorTroco, entity.getValorTroco());

        entity = NFeFormaPagamento.newBuilder()
            .withFormaPagamento(formaPagamento)
            .withValorPagamento(valorPagamento)
            .withTipoIntegracao(tipoIntegracao)
            .withCnpjCredenciadora(cnpjCredenciadora)
            .withBandeiraOperadora(bandeiraOperadora)
            .withNumeroAutorizacao(numeroAutorizacao)
            .withValorTroco(valorTroco)
            .build();

        assertNotNull(entity);
        assertEquals(formaPagamento, entity.getFormaPagamento());
        assertEquals(valorPagamento, entity.getValorPagamento());
        assertEquals(tipoIntegracao, entity.getTipoIntegracao());
        assertEquals(cnpjCredenciadora, entity.getCnpjCredenciadora());
        assertEquals(bandeiraOperadora, entity.getBandeiraOperadora());
        assertEquals(numeroAutorizacao, entity.getNumeroAutorizacao());
        assertEquals(valorTroco, entity.getValorTroco());
    }

    @Test
    public void testBeanValidation() throws Exception {
        NFeFormaPagamento entity = new NFeFormaPagamento();
        FocusNFeUtils.throwBeanValidation(entity);
    }

    @Test(expectedExceptions = {ConstraintViolationException.class})
    public void testBeanValidationWithError() throws Exception {
        NFeFormaPagamento entity = new NFeFormaPagamento();
        entity.setCnpjCredenciadora("987654321987654321");
        FocusNFeUtils.throwBeanValidation(entity);
    }
}
