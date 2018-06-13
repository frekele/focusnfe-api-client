package org.frekele.fiscal.focus.nfe.client.model.response.nfe.body;

import org.frekele.fiscal.focus.nfe.client.model.entities.erro.NFeErro;
import org.frekele.fiscal.focus.nfe.client.testng.InvokedMethodListener;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * @author frekele - Leandro Kersting de Freitas
 */
@Listeners(InvokedMethodListener.class)
public class NFeAutorizarBodyResponseTest {

    @Test
    public void testNewInstance() throws Exception {
        NFeErro erro = new NFeErro();
        String status = "autorizado";
        String referencia = "X12345";
        String cnpjEmitente = "98765476545678";

        NFeAutorizarBodyResponse entity = new NFeAutorizarBodyResponse();
        entity.setErro(erro);
        entity.setStatus(status);
        entity.setReferencia(referencia);
        entity.setCnpjEmitente(cnpjEmitente);

        assertNotNull(entity);
        assertEquals(erro, entity.getErro());
        assertEquals(status, entity.getStatus());
        assertEquals(referencia, entity.getReferencia());
        assertEquals(cnpjEmitente, entity.getCnpjEmitente());
    }
}
