package org.frekele.fiscal.focus.nfe.client.model.response.mde.body;

import org.frekele.fiscal.focus.nfe.client.model.entities.erro.NFeErro;
import org.frekele.fiscal.focus.nfe.client.model.entities.manifesto.MDeManifesto;
import org.frekele.fiscal.focus.nfe.client.model.entities.protocolo.cancelamento.NFeProtocoloCancelamento;
import org.frekele.fiscal.focus.nfe.client.model.entities.requisicao.cancelamento.NFeRequisicaoCancelamento;
import org.frekele.fiscal.focus.nfe.client.testng.InvokedMethodListener;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * @author frekele - Leandro Kersting de Freitas
 */
@Listeners(InvokedMethodListener.class)
public class MDeConsultarCancelamentoBodyResponseTest {

    @Test
    public void testNewInstance() throws Exception {
        NFeErro erro = new NFeErro();
        MDeManifesto manifesto = new MDeManifesto();
        NFeRequisicaoCancelamento requisicaoCancelamento = new NFeRequisicaoCancelamento();
        NFeProtocoloCancelamento protocoloCancelamento = new NFeProtocoloCancelamento();

        MDeConsultarCancelamentoBodyResponse entity = new MDeConsultarCancelamentoBodyResponse();
        entity.setErro(erro);
        entity.setManifesto(manifesto);
        entity.setRequisicaoCancelamento(requisicaoCancelamento);
        entity.setProtocoloCancelamento(protocoloCancelamento);

        assertNotNull(entity);
        assertEquals(erro, entity.getErro());
        assertEquals(manifesto, entity.getManifesto());
        assertEquals(requisicaoCancelamento, entity.getRequisicaoCancelamento());
        assertEquals(protocoloCancelamento, entity.getProtocoloCancelamento());
    }
}
