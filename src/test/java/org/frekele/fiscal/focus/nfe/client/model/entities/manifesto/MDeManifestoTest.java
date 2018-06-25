package org.frekele.fiscal.focus.nfe.client.model.entities.manifesto;

import org.frekele.fiscal.focus.nfe.client.testng.InvokedMethodListener;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import static org.testng.Assert.*;

/**
 * @author frekele - Leandro Kersting de Freitas
 */
@Listeners(InvokedMethodListener.class)
public class MDeManifestoTest {

    @Test
    public void testNewInstance() throws Exception {
        String nomeEmitente = "Empresa emitente Ltda";
        String documentoEmitente = "79119601900003";
        String cnpjDestinatario = "91960103000791";
        String chaveNfe = "41171179060190000000026610018255001875685069";
        BigDecimal valorTotal = new BigDecimal("24560.00");
        OffsetDateTime dataEmissao = OffsetDateTime.now();
        String situacao = "autorizada";
        String manifestacaoDestinatario = "ciencia";
        Boolean nfeCompleta = Boolean.TRUE;
        String tipoNfe = "1";
        String versao = "73";
        String digestValue = "fhj643qhgjhdf4875egfe";
        String numeroCartaCorrecao = "2";
        String cartaCorrecao = "bla bla bla bla bla bla bla bla bla bla bla bla";
        OffsetDateTime dataCartaCorrecao = OffsetDateTime.now();
        OffsetDateTime dataCancelamento = OffsetDateTime.now();
        String justificativaCancelamento = "bla bla bla bla bla bla";

        MDeManifesto entity = new MDeManifesto();
        entity.setNomeEmitente(nomeEmitente);
        entity.setDocumentoEmitente(documentoEmitente);
        entity.setCnpjDestinatario(cnpjDestinatario);
        entity.setChaveNfe(chaveNfe);
        entity.setValorTotal(valorTotal);
        entity.setDataEmissao(dataEmissao);
        entity.setSituacao(situacao);
        entity.setManifestacaoDestinatario(manifestacaoDestinatario);
        entity.setNfeCompleta(nfeCompleta);
        entity.setTipoNfe(tipoNfe);
        entity.setVersao(versao);
        entity.setDigestValue(digestValue);
        entity.setNumeroCartaCorrecao(numeroCartaCorrecao);
        entity.setCartaCorrecao(cartaCorrecao);
        entity.setDataCartaCorrecao(dataCartaCorrecao);
        entity.setDataCancelamento(dataCancelamento);
        entity.setJustificativaCancelamento(justificativaCancelamento);

        assertNotNull(entity);
        assertEquals(nomeEmitente, entity.getNomeEmitente());
        assertEquals(documentoEmitente, entity.getDocumentoEmitente());
        assertEquals(cnpjDestinatario, entity.getCnpjDestinatario());
        assertEquals(chaveNfe, entity.getChaveNfe());
        assertEquals(valorTotal, entity.getValorTotal());
        assertEquals(dataEmissao, entity.getDataEmissao());
        assertEquals(situacao, entity.getSituacao());
        assertEquals(manifestacaoDestinatario, entity.getManifestacaoDestinatario());
        assertEquals(nfeCompleta, entity.getNfeCompleta());
        assertEquals(tipoNfe, entity.getTipoNfe());
        assertEquals(versao, entity.getVersao());
        assertEquals(digestValue, entity.getDigestValue());
        assertEquals(numeroCartaCorrecao, entity.getNumeroCartaCorrecao());
        assertEquals(cartaCorrecao, entity.getCartaCorrecao());
        assertEquals(dataCartaCorrecao, entity.getDataCartaCorrecao());
        assertEquals(dataCancelamento, entity.getDataCancelamento());
        assertEquals(justificativaCancelamento, entity.getJustificativaCancelamento());

        entity = MDeManifesto.newBuilder()
            .withNomeEmitente(nomeEmitente)
            .withDocumentoEmitente(documentoEmitente)
            .withCnpjDestinatario(cnpjDestinatario)
            .withChaveNfe(chaveNfe)
            .withValorTotal(valorTotal)
            .withDataEmissao(dataEmissao)
            .withSituacao(situacao)
            .withManifestacaoDestinatario(manifestacaoDestinatario)
            .withNfeCompleta(nfeCompleta)
            .withTipoNfe(tipoNfe)
            .withVersao(versao)
            .withDigestValue(digestValue)
            .withNumeroCartaCorrecao(numeroCartaCorrecao)
            .withCartaCorrecao(cartaCorrecao)
            .withDataCartaCorrecao(dataCartaCorrecao)
            .withDataCancelamento(dataCancelamento)
            .withJustificativaCancelamento(justificativaCancelamento)
            .build();

        assertNotNull(entity);
        assertEquals(nomeEmitente, entity.getNomeEmitente());
        assertEquals(documentoEmitente, entity.getDocumentoEmitente());
        assertEquals(cnpjDestinatario, entity.getCnpjDestinatario());
        assertEquals(chaveNfe, entity.getChaveNfe());
        assertEquals(valorTotal, entity.getValorTotal());
        assertEquals(dataEmissao, entity.getDataEmissao());
        assertEquals(situacao, entity.getSituacao());
        assertEquals(manifestacaoDestinatario, entity.getManifestacaoDestinatario());
        assertEquals(nfeCompleta, entity.getNfeCompleta());
        assertEquals(tipoNfe, entity.getTipoNfe());
        assertEquals(versao, entity.getVersao());
        assertEquals(digestValue, entity.getDigestValue());
        assertEquals(numeroCartaCorrecao, entity.getNumeroCartaCorrecao());
        assertEquals(cartaCorrecao, entity.getCartaCorrecao());
        assertEquals(dataCartaCorrecao, entity.getDataCartaCorrecao());
        assertEquals(dataCancelamento, entity.getDataCancelamento());
        assertEquals(justificativaCancelamento, entity.getJustificativaCancelamento());
    }
}
