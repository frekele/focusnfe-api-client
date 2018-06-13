package org.frekele.fiscal.focus.nfe.client.model.entities.requisicao.notafiscal;

import org.frekele.fiscal.focus.nfe.client.model.entities.requisicao.notafiscal.NFeLacreVolumeTransportado;
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
public class NFeLacreVolumeTransportadoTest {

    @Test
    public void testNewInstance() throws Exception {
        String numero = "2798594759483";

        NFeLacreVolumeTransportado entity = new NFeLacreVolumeTransportado();
        entity.setNumero(numero);

        assertNotNull(entity);
        assertEquals(numero, entity.getNumero());

        entity = NFeLacreVolumeTransportado.newBuilder()
            .withNumero(numero)
            .build();

        assertNotNull(entity);
        assertEquals(numero, entity.getNumero());
    }

    @Test
    public void testBeanValidation() throws Exception {
        NFeLacreVolumeTransportado entity = new NFeLacreVolumeTransportado();
        FocusNFeUtils.throwBeanValidation(entity);
    }

    @Test(expectedExceptions = {ConstraintViolationException.class})
    public void testBeanValidationWithError() throws Exception {
        NFeLacreVolumeTransportado entity = new NFeLacreVolumeTransportado("");
        FocusNFeUtils.throwBeanValidation(entity);
    }
}
