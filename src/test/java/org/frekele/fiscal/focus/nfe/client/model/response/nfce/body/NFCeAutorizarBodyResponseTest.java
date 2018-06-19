package org.frekele.fiscal.focus.nfe.client.model.response.nfce.body;

import org.frekele.fiscal.focus.nfe.client.model.entities.erro.NFeErro;
import org.frekele.fiscal.focus.nfe.client.model.entities.protocolo.notafiscal.NFeProtocoloNotaFiscal;
import org.frekele.fiscal.focus.nfe.client.model.entities.requisicao.notafiscal.NFeRetornoRequisicaoNotaFiscal;
import org.frekele.fiscal.focus.nfe.client.testng.InvokedMethodListener;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * @author frekele - Leandro Kersting de Freitas
 */
@Listeners(InvokedMethodListener.class)
public class NFCeAutorizarBodyResponseTest {

    @Test
    public void testNewInstance() throws Exception {
        NFeErro erro = new NFeErro();
        String status = "autorizado";
        String statusSefaz = "100";
        String mensagemSefaz = "Autorizado o uso da NF-e";
        String serie = "1";
        String numero = "33";
        String cnpjEmitente = "67855678434976";
        String referencia = "674565667577";
        String chaveNfe = "NFe43691010000002072570478000505164180050162750";
        String caminhoXmlNotaFiscal = "/teste1/teste/arquivo.xml";
        String caminhoDanfe = "/teste2/teste/arquivo.pdf";
        String qrcodeUrl = "https://www.sefaz.rs.gov.br/NFCE/NFCE-COM.aspx?chNFe=43180695646546546545645645";
        String urlConsultaNf = "https://www.sefaz.rs.gov.br/NFE/NFE-NFC.aspx";
        NFeRetornoRequisicaoNotaFiscal requisicaoNotaFiscal = new NFeRetornoRequisicaoNotaFiscal();
        NFeProtocoloNotaFiscal protocoloNotaFiscal = new NFeProtocoloNotaFiscal();

        NFCeAutorizarBodyResponse entity = new NFCeAutorizarBodyResponse();
        entity.setErro(erro);
        entity.setStatus(status);
        entity.setStatusSefaz(statusSefaz);
        entity.setMensagemSefaz(mensagemSefaz);
        entity.setSerie(serie);
        entity.setNumero(numero);
        entity.setCnpjEmitente(cnpjEmitente);
        entity.setReferencia(referencia);
        entity.setChaveNfe(chaveNfe);
        entity.setCaminhoXmlNotaFiscal(caminhoXmlNotaFiscal);
        entity.setCaminhoDanfe(caminhoDanfe);
        entity.setQrcodeUrl(qrcodeUrl);
        entity.setUrlConsultaNf(urlConsultaNf);
        entity.setRequisicaoNotaFiscal(requisicaoNotaFiscal);
        entity.setProtocoloNotaFiscal(protocoloNotaFiscal);

        assertNotNull(entity);
        assertEquals(erro, entity.getErro());
        assertEquals(status, entity.getStatus());
        assertEquals(statusSefaz, entity.getStatusSefaz());
        assertEquals(mensagemSefaz, entity.getMensagemSefaz());
        assertEquals(serie, entity.getSerie());
        assertEquals(numero, entity.getNumero());
        assertEquals(cnpjEmitente, entity.getCnpjEmitente());
        assertEquals(referencia, entity.getReferencia());
        assertEquals(chaveNfe, entity.getChaveNfe());
        assertEquals(caminhoXmlNotaFiscal, entity.getCaminhoXmlNotaFiscal());
        assertEquals(caminhoDanfe, entity.getCaminhoDanfe());
        assertEquals(qrcodeUrl, entity.getQrcodeUrl());
        assertEquals(urlConsultaNf, entity.getUrlConsultaNf());
        assertEquals(requisicaoNotaFiscal, entity.getRequisicaoNotaFiscal());
        assertEquals(protocoloNotaFiscal, entity.getProtocoloNotaFiscal());
    }
}
