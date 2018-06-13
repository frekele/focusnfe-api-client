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
public class NFeCancelarBodyResponseTest {

    @Test
    public void testNewInstance() throws Exception {
        NFeErro erro = new NFeErro();
        String status = "cancelado";
        String statusSefaz = "cancelado ok";
        String mensagemSefaz = "cancelado com sucesso";
        String caminhoXmlCancelamento = "/teste/testex/arquivo.xml";

        NFeCancelarBodyResponse entity = new NFeCancelarBodyResponse();
        entity.setErro(erro);
        entity.setStatus(status);
        entity.setStatusSefaz(statusSefaz);
        entity.setMensagemSefaz(mensagemSefaz);
        entity.setCaminhoXmlCancelamento(caminhoXmlCancelamento);

        assertNotNull(entity);
        assertEquals(erro, entity.getErro());
        assertEquals(status, entity.getStatus());
        assertEquals(statusSefaz, entity.getStatusSefaz());
        assertEquals(mensagemSefaz, entity.getMensagemSefaz());
        assertEquals(caminhoXmlCancelamento, entity.getCaminhoXmlCancelamento());

        entity = NFeCancelarBodyResponse.newBuilder()
            .withErro(erro)
            .withStatus(status)
            .withStatusSefaz(statusSefaz)
            .withMensagemSefaz(mensagemSefaz)
            .withCaminhoXmlCancelamento(caminhoXmlCancelamento)
            .build();

        assertNotNull(entity);
        assertEquals(erro, entity.getErro());
        assertEquals(status, entity.getStatus());
        assertEquals(statusSefaz, entity.getStatusSefaz());
        assertEquals(mensagemSefaz, entity.getMensagemSefaz());
        assertEquals(caminhoXmlCancelamento, entity.getCaminhoXmlCancelamento());
    }
}
