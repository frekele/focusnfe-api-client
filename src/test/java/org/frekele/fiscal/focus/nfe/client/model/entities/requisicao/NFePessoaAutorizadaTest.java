package org.frekele.fiscal.focus.nfe.client.model.entities.requisicao;

import org.frekele.fiscal.focus.nfe.client.model.entities.requisicao.notafiscal.NFePessoaAutorizada;
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
public class NFePessoaAutorizadaTest {

    @Test
    public void testNewInstance() throws Exception {
        String cnpj = "65467895434567";
        String cpf = "34567865432";

        NFePessoaAutorizada entity = new NFePessoaAutorizada();
        entity.setCnpj(cnpj);
        entity.setCpf(cpf);

        assertNotNull(entity);
        assertEquals(cnpj, entity.getCnpj());
        assertEquals(cpf, entity.getCpf());

        entity = NFePessoaAutorizada.newBuilder()
            .withCnpj(cnpj)
            .withCpf(cpf)
            .build();

        assertNotNull(entity);
        assertEquals(cnpj, entity.getCnpj());
        assertEquals(cpf, entity.getCpf());
    }

    @Test
    public void testBeanValidation() throws Exception {
        NFePessoaAutorizada entity = new NFePessoaAutorizada();
        FocusNFeUtils.throwBeanValidation(entity);
    }

    @Test(expectedExceptions = {ConstraintViolationException.class})
    public void testBeanValidationWithError() throws Exception {
        NFePessoaAutorizada entity = new NFePessoaAutorizada();
        entity.setCpf("234857985673459834758");
        FocusNFeUtils.throwBeanValidation(entity);
    }
}
