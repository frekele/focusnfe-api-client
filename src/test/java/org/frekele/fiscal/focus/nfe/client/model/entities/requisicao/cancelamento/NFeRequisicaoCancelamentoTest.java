package org.frekele.fiscal.focus.nfe.client.model.entities.requisicao.cancelamento;

import org.frekele.fiscal.focus.nfe.client.testng.InvokedMethodListener;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.time.OffsetDateTime;

import static org.testng.Assert.*;

/**
 * @author frekele - Leandro Kersting de Freitas
 */
@Listeners(InvokedMethodListener.class)
public class NFeRequisicaoCancelamentoTest {

    @Test
    public void testNewInstance() throws Exception {
        String versao = "1.00";
        String idTag = "ID1101114501700917257470001625180100000003180678916221";
        String codigoOrgao = "43";
        String ambiente = "2";
        String cnpj = "65678543234567";
        String chaveNfe = "43180000162550006910000789725711816224700170";
        OffsetDateTime dataEvento = OffsetDateTime.now();
        String tipoEvento = "110111";
        String numeroSequencialEvento = "1";
        String versaoEvento = "1.00";
        String descricaoEvento = "Cancelamento";
        String protocolo = "143180390045007";
        String justificativa = "bla bla bla bla bla bla bla bla bla bla";

        NFeRequisicaoCancelamento entity = new NFeRequisicaoCancelamento();
        entity.setVersao(versao);
        entity.setIdTag(idTag);
        entity.setCodigoOrgao(codigoOrgao);
        entity.setAmbiente(ambiente);
        entity.setCnpj(cnpj);
        entity.setChaveNfe(chaveNfe);
        entity.setDataEvento(dataEvento);
        entity.setTipoEvento(tipoEvento);
        entity.setNumeroSequencialEvento(numeroSequencialEvento);
        entity.setVersaoEvento(versaoEvento);
        entity.setDescricaoEvento(descricaoEvento);
        entity.setProtocolo(protocolo);
        entity.setJustificativa(justificativa);

        assertNotNull(entity);
        assertEquals(versao, entity.getVersao());
        assertEquals(idTag, entity.getIdTag());
        assertEquals(codigoOrgao, entity.getCodigoOrgao());
        assertEquals(ambiente, entity.getAmbiente());
        assertEquals(cnpj, entity.getCnpj());
        assertEquals(chaveNfe, entity.getChaveNfe());
        assertEquals(dataEvento, entity.getDataEvento());
        assertEquals(tipoEvento, entity.getTipoEvento());
        assertEquals(numeroSequencialEvento, entity.getNumeroSequencialEvento());
        assertEquals(versaoEvento, entity.getVersaoEvento());
        assertEquals(descricaoEvento, entity.getDescricaoEvento());
        assertEquals(protocolo, entity.getProtocolo());
        assertEquals(justificativa, entity.getJustificativa());

        entity = NFeRequisicaoCancelamento.newBuilder()
            .withVersao(versao)
            .withIdTag(idTag)
            .withCodigoOrgao(codigoOrgao)
            .withAmbiente(ambiente)
            .withCnpj(cnpj)
            .withChaveNfe(chaveNfe)
            .withDataEvento(dataEvento)
            .withTipoEvento(tipoEvento)
            .withNumeroSequencialEvento(numeroSequencialEvento)
            .withVersaoEvento(versaoEvento)
            .withDescricaoEvento(descricaoEvento)
            .withProtocolo(protocolo)
            .withJustificativa(justificativa)
            .build();

        assertNotNull(entity);
        assertEquals(versao, entity.getVersao());
        assertEquals(idTag, entity.getIdTag());
        assertEquals(codigoOrgao, entity.getCodigoOrgao());
        assertEquals(ambiente, entity.getAmbiente());
        assertEquals(cnpj, entity.getCnpj());
        assertEquals(chaveNfe, entity.getChaveNfe());
        assertEquals(dataEvento, entity.getDataEvento());
        assertEquals(tipoEvento, entity.getTipoEvento());
        assertEquals(numeroSequencialEvento, entity.getNumeroSequencialEvento());
        assertEquals(versaoEvento, entity.getVersaoEvento());
        assertEquals(descricaoEvento, entity.getDescricaoEvento());
        assertEquals(protocolo, entity.getProtocolo());
        assertEquals(justificativa, entity.getJustificativa());
    }
}
