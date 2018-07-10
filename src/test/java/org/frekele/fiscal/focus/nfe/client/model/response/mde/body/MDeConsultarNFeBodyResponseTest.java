package org.frekele.fiscal.focus.nfe.client.model.response.mde.body;

import org.frekele.fiscal.focus.nfe.client.model.entities.erro.NFeErro;
import org.frekele.fiscal.focus.nfe.client.model.entities.manifesto.MDeManifesto;
import org.frekele.fiscal.focus.nfe.client.model.entities.protocolo.cancelamento.NFeProtocoloCancelamento;
import org.frekele.fiscal.focus.nfe.client.model.entities.protocolo.cartacorrecao.NFeProtocoloCartaCorrecao;
import org.frekele.fiscal.focus.nfe.client.model.entities.protocolo.notafiscal.NFeProtocoloNotaFiscal;
import org.frekele.fiscal.focus.nfe.client.model.entities.requisicao.cancelamento.NFeRequisicaoCancelamento;
import org.frekele.fiscal.focus.nfe.client.model.entities.requisicao.cartacorrecao.NFeRequisicaoCartaCorrecao;
import org.frekele.fiscal.focus.nfe.client.model.entities.requisicao.notafiscal.NFeRetornoRequisicaoNotaFiscal;
import org.frekele.fiscal.focus.nfe.client.testng.InvokedMethodListener;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * @author frekele - Leandro Kersting de Freitas
 */
@Listeners(InvokedMethodListener.class)
public class MDeConsultarNFeBodyResponseTest {

    @Test
    public void testNewInstance() throws Exception {
        NFeErro erro = new NFeErro();
        MDeManifesto manifesto = new MDeManifesto();
        NFeRetornoRequisicaoNotaFiscal requisicaoNotaFiscal = new NFeRetornoRequisicaoNotaFiscal();
        NFeProtocoloNotaFiscal protocoloNotaFiscal = new NFeProtocoloNotaFiscal();
        NFeRequisicaoCancelamento requisicaoCancelamento = new NFeRequisicaoCancelamento();
        NFeProtocoloCancelamento protocoloCancelamento = new NFeProtocoloCancelamento();
        NFeRequisicaoCartaCorrecao requisicaoCartaCorrecao = new NFeRequisicaoCartaCorrecao();
        NFeProtocoloCartaCorrecao protocoloCartaCorrecao = new NFeProtocoloCartaCorrecao();

        MDeConsultarNFeBodyResponse entity = new MDeConsultarNFeBodyResponse();
        entity.setErro(erro);
        entity.setManifesto(manifesto);
        entity.setRequisicaoNotaFiscal(requisicaoNotaFiscal);
        entity.setProtocoloNotaFiscal(protocoloNotaFiscal);
        entity.setRequisicaoCancelamento(requisicaoCancelamento);
        entity.setProtocoloCancelamento(protocoloCancelamento);
        entity.setRequisicaoCartaCorrecao(requisicaoCartaCorrecao);
        entity.setProtocoloCartaCorrecao(protocoloCartaCorrecao);

        assertNotNull(entity);
        assertEquals(erro, entity.getErro());
        assertEquals(manifesto, entity.getManifesto());
        assertEquals(requisicaoNotaFiscal, entity.getRequisicaoNotaFiscal());
        assertEquals(protocoloNotaFiscal, entity.getProtocoloNotaFiscal());
        assertEquals(requisicaoCancelamento, entity.getRequisicaoCancelamento());
        assertEquals(protocoloCancelamento, entity.getProtocoloCancelamento());
        assertEquals(requisicaoCartaCorrecao, entity.getRequisicaoCartaCorrecao());
        assertEquals(protocoloCartaCorrecao, entity.getProtocoloCartaCorrecao());
    }
}
