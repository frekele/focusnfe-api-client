package org.frekele.fiscal.focus.nfe.client.model.nfe.request.body;

import org.frekele.fiscal.focus.nfe.client.testng.InvokedMethodListener;
import org.frekele.fiscal.focus.nfe.client.util.FocusNFeUtils;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;

/**
 * @author frekele - Leandro Kersting de Freitas
 */
@Listeners(InvokedMethodListener.class)
public class NFeEmailBodyRequestTest {

    @Test
    public void testNewInstance() throws Exception {
        List<String> emails = new ArrayList<>();
        emails.add("teste@teste.com.br");

        NFeEmailBodyRequest entity = new NFeEmailBodyRequest();
        entity.setEmails(emails);

        assertNotNull(entity);
        assertEquals(emails, entity.getEmails());

        entity = NFeEmailBodyRequest.newBuilder()
            .withEmails(emails)
            .build();

        assertNotNull(entity);
        assertEquals(emails, entity.getEmails());
    }

    @Test
    public void testBeanValidation() throws Exception {
        NFeEmailBodyRequest entity = new NFeEmailBodyRequest();
        List<String> emails = new ArrayList<>();
        emails.add("teste@teste.com.br");
        entity.setEmails(emails);
        FocusNFeUtils.throwBeanValidation(entity);

        entity = new NFeEmailBodyRequest("teste2@teste.com.br");
        FocusNFeUtils.throwBeanValidation(entity);
    }

    @Test(expectedExceptions = {ConstraintViolationException.class})
    public void testBeanValidationWithError() throws Exception {
        NFeEmailBodyRequest entity = new NFeEmailBodyRequest();
        FocusNFeUtils.throwBeanValidation(entity);
    }
}
