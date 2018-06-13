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
public class NFeCCeBodyResponseTest {

    @Test
    public void testNewInstance() throws Exception {
        NFeErro erro = new NFeErro();
        String status = "autorizado";
        String statusSefaz = "autorizado ok";
        String mensagemSefaz = "autorizado com sucesso";
        String caminhoXmlCartaCorrecao = "/teste/testex1/arquivo.xml";
        String caminhoPdfCartaCorrecao = "/teste/testex2/arquivo.xml";
        Integer numeroCartaCorrecao = 1;

        NFeCCeBodyResponse entity = new NFeCCeBodyResponse();
        entity.setErro(erro);
        entity.setStatus(status);
        entity.setStatusSefaz(statusSefaz);
        entity.setMensagemSefaz(mensagemSefaz);
        entity.setCaminhoXmlCartaCorrecao(caminhoXmlCartaCorrecao);
        entity.setCaminhoPdfCartaCorrecao(caminhoPdfCartaCorrecao);
        entity.setNumeroCartaCorrecao(numeroCartaCorrecao);

        assertNotNull(entity);
        assertEquals(erro, entity.getErro());
        assertEquals(status, entity.getStatus());
        assertEquals(statusSefaz, entity.getStatusSefaz());
        assertEquals(mensagemSefaz, entity.getMensagemSefaz());
        assertEquals(caminhoXmlCartaCorrecao, entity.getCaminhoXmlCartaCorrecao());
        assertEquals(caminhoPdfCartaCorrecao, entity.getCaminhoPdfCartaCorrecao());
        assertEquals(numeroCartaCorrecao, entity.getNumeroCartaCorrecao());

        entity = NFeCCeBodyResponse.newBuilder()
            .withErro(erro)
            .withStatus(status)
            .withStatusSefaz(statusSefaz)
            .withMensagemSefaz(mensagemSefaz)
            .withCaminhoXmlCartaCorrecao(caminhoXmlCartaCorrecao)
            .withCaminhoPdfCartaCorrecao(caminhoPdfCartaCorrecao)
            .withNumeroCartaCorrecao(numeroCartaCorrecao)
            .build();

        assertNotNull(entity);
        assertEquals(erro, entity.getErro());
        assertEquals(status, entity.getStatus());
        assertEquals(statusSefaz, entity.getStatusSefaz());
        assertEquals(mensagemSefaz, entity.getMensagemSefaz());
        assertEquals(caminhoXmlCartaCorrecao, entity.getCaminhoXmlCartaCorrecao());
        assertEquals(caminhoPdfCartaCorrecao, entity.getCaminhoPdfCartaCorrecao());
        assertEquals(numeroCartaCorrecao, entity.getNumeroCartaCorrecao());
    }
}
