package org.frekele.fiscal.focus.nfe.client.model.entities.requisicao.cartacorrecao;

import org.frekele.fiscal.focus.nfe.client.testng.InvokedMethodListener;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.time.OffsetDateTime;

import static org.testng.Assert.*;

/**
 * @author frekele - Leandro Kersting de Freitas
 */
@Listeners(InvokedMethodListener.class)
public class NFeRequisicaoCartaCorrecaoTest {

    @Test
    public void testNewInstance() throws Exception {
        String versao = "1.00";
        String idTag = "ID1101114501700917257470001625180100000003180678916221";
        String codigoOrgao = "43";
        String ambiente = "2";
        String cnpj = "65674323854567";
        String chaveNfe = "43180000162550006725711816224791000078900170";
        OffsetDateTime dataEvento = OffsetDateTime.now();
        String tipoEvento = "656755";
        String numeroSequencialEvento = "1";
        String versaoEvento = "1.00";
        String descricaoEvento = "Carta Correcao";
        String correcao = "bla bla bla 2 bla bla 2";
        String condicoesUso = "bla bla bla 3 bla bla bla 3 bla";

        NFeRequisicaoCartaCorrecao entity = new NFeRequisicaoCartaCorrecao();
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
        entity.setCorrecao(correcao);
        entity.setCondicoesUso(condicoesUso);

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
        assertEquals(correcao, entity.getCorrecao());
        assertEquals(condicoesUso, entity.getCondicoesUso());

        entity = NFeRequisicaoCartaCorrecao.newBuilder()
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
            .withCorrecao(correcao)
            .withCondicoesUso(condicoesUso)
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
        assertEquals(correcao, entity.getCorrecao());
        assertEquals(condicoesUso, entity.getCondicoesUso());
    }
}
