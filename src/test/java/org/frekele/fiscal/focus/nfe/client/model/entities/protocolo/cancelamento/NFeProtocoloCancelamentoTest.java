package org.frekele.fiscal.focus.nfe.client.model.entities.protocolo.cancelamento;

import org.frekele.fiscal.focus.nfe.client.testng.InvokedMethodListener;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.time.OffsetDateTime;

import static org.testng.Assert.*;

/**
 * @author frekele - Leandro Kersting de Freitas
 */
@Listeners(InvokedMethodListener.class)
public class NFeProtocoloCancelamentoTest {

    @Test
    public void testNewInstance() throws Exception {
        String versao = "1.00";
        String ambiente = "2";
        String versaoAplicativo = "RS201710241716";
        String codigoOrgao = "43";
        String status = "135";
        String motivo = "Evento registrado e vinculado a NF-e";
        String chaveNfe = "43180000162550006911816221000078972574700170";
        String tipoEvento = "110111";
        String descricaoEvento = "Cancelamento";
        OffsetDateTime dataEvento = OffsetDateTime.now();
        String numeroProtocolo = "143180007240354";
        String cnpj="00549100030551";

        NFeProtocoloCancelamento entity = new NFeProtocoloCancelamento();
        entity.setVersao(versao);
        entity.setAmbiente(ambiente);
        entity.setVersaoAplicativo(versaoAplicativo);
        entity.setCodigoOrgao(codigoOrgao);
        entity.setStatus(status);
        entity.setMotivo(motivo);
        entity.setChaveNfe(chaveNfe);
        entity.setTipoEvento(tipoEvento);
        entity.setDescricaoEvento(descricaoEvento);
        entity.setDataEvento(dataEvento);
        entity.setNumeroProtocolo(numeroProtocolo);
        entity.setCnpj(cnpj);

        assertNotNull(entity);
        assertEquals(versao, entity.getVersao());
        assertEquals(ambiente, entity.getAmbiente());
        assertEquals(versaoAplicativo, entity.getVersaoAplicativo());
        assertEquals(codigoOrgao, entity.getCodigoOrgao());
        assertEquals(status, entity.getStatus());
        assertEquals(motivo, entity.getMotivo());
        assertEquals(chaveNfe, entity.getChaveNfe());
        assertEquals(tipoEvento, entity.getTipoEvento());
        assertEquals(descricaoEvento, entity.getDescricaoEvento());
        assertEquals(dataEvento, entity.getDataEvento());
        assertEquals(numeroProtocolo, entity.getNumeroProtocolo());
        assertEquals(cnpj, entity.getCnpj());

        entity = NFeProtocoloCancelamento.newBuilder()
            .withVersao(versao)
            .withAmbiente(ambiente)
            .withVersaoAplicativo(versaoAplicativo)
            .withCodigoOrgao(codigoOrgao)
            .withStatus(status)
            .withMotivo(motivo)
            .withChaveNfe(chaveNfe)
            .withTipoEvento(tipoEvento)
            .withDescricaoEvento(descricaoEvento)
            .withDataEvento(dataEvento)
            .withNumeroProtocolo(numeroProtocolo)
            .withCnpj(cnpj)
            .build();

        assertNotNull(entity);
        assertEquals(versao, entity.getVersao());
        assertEquals(ambiente, entity.getAmbiente());
        assertEquals(versaoAplicativo, entity.getVersaoAplicativo());
        assertEquals(codigoOrgao, entity.getCodigoOrgao());
        assertEquals(status, entity.getStatus());
        assertEquals(motivo, entity.getMotivo());
        assertEquals(chaveNfe, entity.getChaveNfe());
        assertEquals(tipoEvento, entity.getTipoEvento());
        assertEquals(descricaoEvento, entity.getDescricaoEvento());
        assertEquals(dataEvento, entity.getDataEvento());
        assertEquals(numeroProtocolo, entity.getNumeroProtocolo());
        assertEquals(cnpj, entity.getCnpj());
    }
}
