package org.frekele.fiscal.focus.nfe.client.model.nfe.request.body.requisicao;

import org.frekele.fiscal.focus.nfe.client.enumeration.NFeUnidadeFederativaEnum;
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

        NFeReboque nFeReboque = new NFeReboque();
        nFeReboque.setVeiculoPlaca(veiculoPlaca);
        nFeReboque.setVeiculoUf(veiculoUf);
        nFeReboque.setVeiculoRntc(veiculoRntc);

        assertNotNull(nFeReboque);
        assertEquals(veiculoPlaca, nFeReboque.getVeiculoPlaca());
        assertEquals(veiculoUf, nFeReboque.getVeiculoUf());
        assertEquals(veiculoRntc, nFeReboque.getVeiculoRntc());

        nFeReboque = NFeReboque.newBuilder()
            .withVeiculoPlaca(veiculoPlaca)
            .withVeiculoUf(veiculoUf)
            .withVeiculoRntc(veiculoRntc)
            .build();

        assertNotNull(nFeReboque);
        assertEquals(veiculoPlaca, nFeReboque.getVeiculoPlaca());
        assertEquals(veiculoUf, nFeReboque.getVeiculoUf());
        assertEquals(veiculoRntc, nFeReboque.getVeiculoRntc());
    }

    @Test
    public void testBeanValidation() throws Exception {
        NFeReboque nFeReboque = new NFeReboque();
        FocusNFeUtils.throwBeanValidation(nFeReboque);
    }

    @Test(expectedExceptions = {ConstraintViolationException.class})
    public void testBeanValidationWithError() throws Exception {
        NFeReboque nFeReboque = new NFeReboque();
        nFeReboque.setVeiculoRntc("");
        FocusNFeUtils.throwBeanValidation(nFeReboque);
    }
}
