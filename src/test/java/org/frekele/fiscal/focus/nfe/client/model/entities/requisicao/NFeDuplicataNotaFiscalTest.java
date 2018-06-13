package org.frekele.fiscal.focus.nfe.client.model.entities.requisicao;

import org.frekele.fiscal.focus.nfe.client.model.entities.requisicao.notafiscal.NFeDuplicataNotaFiscal;
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
public class NFeDuplicataNotaFiscalTest {

    @Test
    public void testNewInstance() throws Exception {
        String numero = "23454314";
        LocalDate dataVencimento = LocalDate.parse("2018-05-09");
        BigDecimal valor = new BigDecimal("23452343.3456");

        NFeDuplicataNotaFiscal entity = new NFeDuplicataNotaFiscal();
        entity.setNumero(numero);
        entity.setDataVencimento(dataVencimento);
        entity.setValor(valor);

        assertNotNull(entity);
        assertEquals(numero, entity.getNumero());
        assertEquals(dataVencimento, entity.getDataVencimento());
        assertEquals(valor, entity.getValor());

        entity = NFeDuplicataNotaFiscal.newBuilder()
            .withNumero(numero)
            .withDataVencimento(dataVencimento)
            .withValor(valor)
            .build();

        assertNotNull(entity);
        assertEquals(numero, entity.getNumero());
        assertEquals(dataVencimento, entity.getDataVencimento());
        assertEquals(valor, entity.getValor());
    }

    @Test
    public void testBeanValidation() throws Exception {
        String numero = "23454314";
        LocalDate dataVencimento = LocalDate.parse("2018-05-09");
        BigDecimal valor = new BigDecimal("23452343.12");
        NFeDuplicataNotaFiscal entity = new NFeDuplicataNotaFiscal(numero, dataVencimento, valor);
        FocusNFeUtils.throwBeanValidation(entity);
    }

    @Test(expectedExceptions = {ConstraintViolationException.class})
    public void testBeanValidationWithError() throws Exception {
        BigDecimal valor = new BigDecimal("23452343.3456");
        NFeDuplicataNotaFiscal entity = new NFeDuplicataNotaFiscal();
        entity.setValor(valor);
        FocusNFeUtils.throwBeanValidation(entity);
    }
}
