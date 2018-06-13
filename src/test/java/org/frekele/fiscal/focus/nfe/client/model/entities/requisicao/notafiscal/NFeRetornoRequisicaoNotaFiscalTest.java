package org.frekele.fiscal.focus.nfe.client.model.entities.requisicao.notafiscal;

import org.frekele.fiscal.focus.nfe.client.testng.InvokedMethodListener;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * @author frekele - Leandro Kersting de Freitas
 */
@Listeners(InvokedMethodListener.class)
public class NFeRetornoRequisicaoNotaFiscalTest {

    @Test
    public void testNewInstance() throws Exception {
        String versao = "4.00";
        String chaveNfe = "NFe43180691725747000162550010000000181622789170";
        String uf = "43";
        String codigoUnico = "62278917";
        String modelo = "55";
        String municipio = "4314902";
        String formatoImpressao = "1";
        String formaEmissao = "1";
        String digitoVerificador = "0";
        String ambiente = "2";
        String processoEmissao = "0";
        String versaoAplicativo = "0.1.0";

        NFeRetornoRequisicaoNotaFiscal entity = new NFeRetornoRequisicaoNotaFiscal();
        entity.setVersao(versao);
        entity.setChaveNfe(chaveNfe);
        entity.setUf(uf);
        entity.setCodigoUnico(codigoUnico);
        entity.setModelo(modelo);
        entity.setMunicipio(municipio);
        entity.setFormatoImpressao(formatoImpressao);
        entity.setFormaEmissao(formaEmissao);
        entity.setDigitoVerificador(digitoVerificador);
        entity.setAmbiente(ambiente);
        entity.setProcessoEmissao(processoEmissao);
        entity.setVersaoAplicativo(versaoAplicativo);

        assertNotNull(entity);
        assertEquals(versao, entity.getVersao());
        assertEquals(chaveNfe, entity.getChaveNfe());
        assertEquals(uf, entity.getUf());
        assertEquals(codigoUnico, entity.getCodigoUnico());
        assertEquals(modelo, entity.getModelo());
        assertEquals(municipio, entity.getMunicipio());
        assertEquals(formatoImpressao, entity.getFormatoImpressao());
        assertEquals(formaEmissao, entity.getFormaEmissao());
        assertEquals(digitoVerificador, entity.getDigitoVerificador());
        assertEquals(ambiente, entity.getAmbiente());
        assertEquals(processoEmissao, entity.getProcessoEmissao());
        assertEquals(versaoAplicativo, entity.getVersaoAplicativo());

        entity = NFeRetornoRequisicaoNotaFiscal.newBuilder()
            .withVersao(versao)
            .withChaveNfe(chaveNfe)
            .withUf(uf)
            .withCodigoUnico(codigoUnico)
            .withModelo(modelo)
            .withMunicipio(municipio)
            .withFormatoImpressao(formatoImpressao)
            .withFormaEmissao(formaEmissao)
            .withDigitoVerificador(digitoVerificador)
            .withAmbiente(ambiente)
            .withProcessoEmissao(processoEmissao)
            .withVersaoAplicativo(versaoAplicativo)
            .build();

        assertNotNull(entity);
        assertEquals(versao, entity.getVersao());
        assertEquals(chaveNfe, entity.getChaveNfe());
        assertEquals(uf, entity.getUf());
        assertEquals(codigoUnico, entity.getCodigoUnico());
        assertEquals(modelo, entity.getModelo());
        assertEquals(municipio, entity.getMunicipio());
        assertEquals(formatoImpressao, entity.getFormatoImpressao());
        assertEquals(formaEmissao, entity.getFormaEmissao());
        assertEquals(digitoVerificador, entity.getDigitoVerificador());
        assertEquals(ambiente, entity.getAmbiente());
        assertEquals(processoEmissao, entity.getProcessoEmissao());
        assertEquals(versaoAplicativo, entity.getVersaoAplicativo());
    }
}
