package org.frekele.fiscal.focus.nfe.client.model.request.nfce.body;

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
public class NFCeEmailBodyRequestTest {

    @Test
    public void testNewInstance() throws Exception {
        List<String> emails = new ArrayList<>();
        emails.add("teste@teste.com.br");

        NFCeEmailBodyRequest entity = new NFCeEmailBodyRequest();
        entity.setEmails(emails);

        assertNotNull(entity);
        assertEquals(emails, entity.getEmails());

        entity = NFCeEmailBodyRequest.newBuilder()
            .withEmails(emails)
            .build();

        assertNotNull(entity);
        assertEquals(emails, entity.getEmails());

        entity = new NFCeEmailBodyRequest(emails);
        assertNotNull(entity);
        assertEquals(emails, entity.getEmails());

        entity = NFCeEmailBodyRequest.newBuilder()
            .withEmails("teste@teste.com.br")
            .build();

        assertNotNull(entity);
        assertEquals(emails, entity.getEmails());
    }

    @Test
    public void testBeanValidation() throws Exception {
        NFCeEmailBodyRequest entity = new NFCeEmailBodyRequest();
        List<String> emails = new ArrayList<>();
        emails.add("teste@teste.com.br");
        entity.setEmails(emails);
        FocusNFeUtils.throwBeanValidation(entity);

        entity = new NFCeEmailBodyRequest("teste2@teste.com.br");
        FocusNFeUtils.throwBeanValidation(entity);
    }

    @Test(expectedExceptions = {ConstraintViolationException.class})
    public void testBeanValidationWithError() throws Exception {
        NFCeEmailBodyRequest entity = new NFCeEmailBodyRequest();
        FocusNFeUtils.throwBeanValidation(entity);
    }
}
