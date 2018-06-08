package org.frekele.fiscal.focus.nfe.client.model.nfe.request.body;

import org.frekele.fiscal.focus.nfe.client.testng.InvokedMethodListener;
import org.frekele.fiscal.focus.nfe.client.util.FocusNFeUtils;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import javax.validation.ConstraintViolationException;
import java.time.LocalDate;

import static org.testng.Assert.*;

/**
 * @author frekele - Leandro Kersting de Freitas
 */
@Listeners(InvokedMethodListener.class)
public class NFeCCeBodyRequestTest {

    @Test
    public void testNewInstance() throws Exception {
        String correcao = "bla bla bla bla bla bla bla";
        LocalDate dataEvento = LocalDate.parse("2018-04-03");

        NFeCCeBodyRequest entity = new NFeCCeBodyRequest();
        entity.setCorrecao(correcao);
        entity.setDataEvento(dataEvento);
        assertNotNull(entity);
        assertEquals(correcao, entity.getCorrecao());
        assertEquals(dataEvento, entity.getDataEvento());

        entity = NFeCCeBodyRequest.newBuilder()
            .withCorrecao(correcao)
            .withDataEvento(dataEvento)
            .build();

        assertNotNull(entity);
        assertEquals(correcao, entity.getCorrecao());
        assertEquals(dataEvento, entity.getDataEvento());
    }

    @Test
    public void testBeanValidation() throws Exception {
        NFeCCeBodyRequest entity = new NFeCCeBodyRequest("bla bla bla bla bla bla bla");
        FocusNFeUtils.throwBeanValidation(entity);

        entity = new NFeCCeBodyRequest("bla bla bla bla bla bla bla", LocalDate.parse("2018-04-03"));
        FocusNFeUtils.throwBeanValidation(entity);
    }

    @Test(expectedExceptions = {ConstraintViolationException.class})
    public void testBeanValidationWithError() throws Exception {
        NFeCCeBodyRequest entity = new NFeCCeBodyRequest();
        FocusNFeUtils.throwBeanValidation(entity);
    }
}
