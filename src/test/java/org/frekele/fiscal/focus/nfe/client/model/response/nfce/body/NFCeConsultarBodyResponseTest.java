package org.frekele.fiscal.focus.nfe.client.model.response.nfce.body;

import org.frekele.fiscal.focus.nfe.client.model.entities.erro.NFeErro;
import org.frekele.fiscal.focus.nfe.client.model.entities.protocolo.cancelamento.NFeProtocoloCancelamento;
import org.frekele.fiscal.focus.nfe.client.model.entities.protocolo.notafiscal.NFeProtocoloNotaFiscal;
import org.frekele.fiscal.focus.nfe.client.model.entities.requisicao.cancelamento.NFeRequisicaoCancelamento;
import org.frekele.fiscal.focus.nfe.client.model.entities.requisicao.notafiscal.NFeRetornoRequisicaoNotaFiscal;
import org.frekele.fiscal.focus.nfe.client.testng.InvokedMethodListener;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * @author frekele - Leandro Kersting de Freitas
 */
@Listeners(InvokedMethodListener.class)
public class NFCeConsultarBodyResponseTest {

    @Test
    public void testNewInstance() throws Exception {
        NFeErro erro = new NFeErro();
        String status = "autorizado";
        String statusSefaz = "100";
        String mensagemSefaz = "Autorizado o uso da NF-e";
        String serie = "1";
        String numero = "33";
        String cnpjEmitente = "67854345678976";
        String referencia = "674567576567";
        String chaveNfe = "NFe43691010000002072570470505164180058000162750";
        String caminhoXmlNotaFiscal = "/teste1/teste/arquivo.xml";
        String caminhoDanfe = "/teste2/teste/arquivo.pdf";
        String caminhoXmlCancelamento = "/teste5/teste/arquivo.xml";
        NFeRetornoRequisicaoNotaFiscal requisicaoNotaFiscal = new NFeRetornoRequisicaoNotaFiscal();
        NFeProtocoloNotaFiscal protocoloNotaFiscal = new NFeProtocoloNotaFiscal();
        NFeRequisicaoCancelamento requisicaoCancelamento = new NFeRequisicaoCancelamento();
        NFeProtocoloCancelamento protocoloCancelamento = new NFeProtocoloCancelamento();

        NFCeConsultarBodyResponse entity = new NFCeConsultarBodyResponse();
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
        entity.setCaminhoXmlCancelamento(caminhoXmlCancelamento);
        entity.setRequisicaoNotaFiscal(requisicaoNotaFiscal);
        entity.setProtocoloNotaFiscal(protocoloNotaFiscal);
        entity.setRequisicaoCancelamento(requisicaoCancelamento);
        entity.setProtocoloCancelamento(protocoloCancelamento);

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
        assertEquals(caminhoXmlCancelamento, entity.getCaminhoXmlCancelamento());
        assertEquals(requisicaoNotaFiscal, entity.getRequisicaoNotaFiscal());
        assertEquals(protocoloNotaFiscal, entity.getProtocoloNotaFiscal());
        assertEquals(requisicaoCancelamento, entity.getRequisicaoCancelamento());
        assertEquals(protocoloCancelamento, entity.getProtocoloCancelamento());
    }
}
