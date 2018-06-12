package org.frekele.fiscal.focus.nfe.client.model.requisicao;

import org.frekele.fiscal.focus.nfe.client.enumeration.NFeUnidadeFederativaEnum;
import org.frekele.fiscal.focus.nfe.client.model.nfe.request.body.requisicao.NFeReboque;
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
public class NFeReboqueTest {

    @Test
    public void testNewInstance() throws Exception {
        String veiculoPlaca = "FR3476";
        NFeUnidadeFederativaEnum veiculoUf = NFeUnidadeFederativaEnum.RIO_GRANDE_DO_SUL;
        String veiculoRntc = "TAC-12345678";

        NFeReboque entity = new NFeReboque();
        entity.setVeiculoPlaca(veiculoPlaca);
        entity.setVeiculoUf(veiculoUf);
        entity.setVeiculoRntc(veiculoRntc);

        assertNotNull(entity);
        assertEquals(veiculoPlaca, entity.getVeiculoPlaca());
        assertEquals(veiculoUf, entity.getVeiculoUf());
        assertEquals(veiculoRntc, entity.getVeiculoRntc());

        entity = NFeReboque.newBuilder()
            .withVeiculoPlaca(veiculoPlaca)
            .withVeiculoUf(veiculoUf)
            .withVeiculoRntc(veiculoRntc)
            .build();

        assertNotNull(entity);
        assertEquals(veiculoPlaca, entity.getVeiculoPlaca());
        assertEquals(veiculoUf, entity.getVeiculoUf());
        assertEquals(veiculoRntc, entity.getVeiculoRntc());
    }

    @Test
    public void testBeanValidation() throws Exception {
        NFeReboque entity = new NFeReboque();
        FocusNFeUtils.throwBeanValidation(entity);
    }

    @Test(expectedExceptions = {ConstraintViolationException.class})
    public void testBeanValidationWithError() throws Exception {
        NFeReboque entity = new NFeReboque();
        entity.setVeiculoRntc("");
        FocusNFeUtils.throwBeanValidation(entity);
    }
}
