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
public class NFeInutilizarBodyResponseTest {

    @Test
    public void testNewInstance() throws Exception {
        NFeErro erro = new NFeErro();
        String status = "autorizado";
        String statusSefaz = "autorizado ok";
        String mensagemSefaz = "autorizado com sucesso";
        String serie = "1";
        String numeroInicial = "12";
        String numeroFinal = "23";
        String caminhoXml = "/teste/testex1/arquivo.xml";

        NFeInutilizarBodyResponse entity = new NFeInutilizarBodyResponse();
        entity.setErro(erro);
        entity.setStatus(status);
        entity.setStatusSefaz(statusSefaz);
        entity.setMensagemSefaz(mensagemSefaz);
        entity.setSerie(serie);
        entity.setNumeroInicial(numeroInicial);
        entity.setNumeroFinal(numeroFinal);
        entity.setCaminhoXml(caminhoXml);

        assertNotNull(entity);
        assertEquals(erro, entity.getErro());
        assertEquals(status, entity.getStatus());
        assertEquals(statusSefaz, entity.getStatusSefaz());
        assertEquals(mensagemSefaz, entity.getMensagemSefaz());
        assertEquals(serie, entity.getSerie());
        assertEquals(numeroInicial, entity.getNumeroInicial());
        assertEquals(numeroFinal, entity.getNumeroFinal());
        assertEquals(caminhoXml, entity.getCaminhoXml());

        entity = NFeInutilizarBodyResponse.newBuilder()
            .withErro(erro)
            .withStatus(status)
            .withStatusSefaz(statusSefaz)
            .withMensagemSefaz(mensagemSefaz)
            .withSerie(serie)
            .withNumeroInicial(numeroInicial)
            .withNumeroFinal(numeroFinal)
            .withCaminhoXml(caminhoXml)
            .build();

        assertNotNull(entity);
        assertEquals(erro, entity.getErro());
        assertEquals(status, entity.getStatus());
        assertEquals(statusSefaz, entity.getStatusSefaz());
        assertEquals(mensagemSefaz, entity.getMensagemSefaz());
        assertEquals(serie, entity.getSerie());
        assertEquals(numeroInicial, entity.getNumeroInicial());
        assertEquals(numeroFinal, entity.getNumeroFinal());
        assertEquals(caminhoXml, entity.getCaminhoXml());
    }
}
