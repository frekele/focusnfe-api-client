package org.frekele.fiscal.focus.nfe.client.model.entities.protocolo.notafiscal;

import org.frekele.fiscal.focus.nfe.client.testng.InvokedMethodListener;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.time.OffsetDateTime;

import static org.testng.Assert.*;

/**
 * @author frekele - Leandro Kersting de Freitas
 */
@Listeners(InvokedMethodListener.class)
public class NFeProtocoloNotaFiscalTest {

    @Test
    public void testNewInstance() throws Exception {
        String versao = "4.00";
        String ambiente = "2";
        String versaoAplicativo = "RS201805250750";
        String chaveNfe = "43180000162550006910000789725711816224700170";
        OffsetDateTime dataRecebimento = OffsetDateTime.now();
        String numeroProtocolo = "143180035047090";
        String digestValue = "GAhivq5IojjamwoqZn3bga+K5i0=";
        String status = "100";
        String motivo = "Autorizado o uso da NF-e";

        NFeProtocoloNotaFiscal entity = new NFeProtocoloNotaFiscal();
        entity.setVersao(versao);
        entity.setAmbiente(ambiente);
        entity.setVersaoAplicativo(versaoAplicativo);
        entity.setChaveNfe(chaveNfe);
        entity.setDataRecebimento(dataRecebimento);
        entity.setNumeroProtocolo(numeroProtocolo);
        entity.setDigestValue(digestValue);
        entity.setStatus(status);
        entity.setMotivo(motivo);

        assertNotNull(entity);
        assertEquals(versao, entity.getVersao());
        assertEquals(ambiente, entity.getAmbiente());
        assertEquals(versaoAplicativo, entity.getVersaoAplicativo());
        assertEquals(chaveNfe, entity.getChaveNfe());
        assertEquals(dataRecebimento, entity.getDataRecebimento());
        assertEquals(numeroProtocolo, entity.getNumeroProtocolo());
        assertEquals(digestValue, entity.getDigestValue());
        assertEquals(status, entity.getStatus());
        assertEquals(motivo, entity.getMotivo());

        entity = NFeProtocoloNotaFiscal.newBuilder()
            .withVersao(versao)
            .withAmbiente(ambiente)
            .withVersaoAplicativo(versaoAplicativo)
            .withChaveNfe(chaveNfe)
            .withDataRecebimento(dataRecebimento)
            .withNumeroProtocolo(numeroProtocolo)
            .withDigestValue(digestValue)
            .withStatus(status)
            .withMotivo(motivo)
            .build();

        assertNotNull(entity);
        assertEquals(versao, entity.getVersao());
        assertEquals(ambiente, entity.getAmbiente());
        assertEquals(versaoAplicativo, entity.getVersaoAplicativo());
        assertEquals(chaveNfe, entity.getChaveNfe());
        assertEquals(dataRecebimento, entity.getDataRecebimento());
        assertEquals(numeroProtocolo, entity.getNumeroProtocolo());
        assertEquals(digestValue, entity.getDigestValue());
        assertEquals(status, entity.getStatus());
        assertEquals(motivo, entity.getMotivo());
    }
}
