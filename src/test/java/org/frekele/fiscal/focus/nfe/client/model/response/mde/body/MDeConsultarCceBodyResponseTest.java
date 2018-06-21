package org.frekele.fiscal.focus.nfe.client.model.response.mde.body;

import org.frekele.fiscal.focus.nfe.client.model.entities.erro.NFeErro;
import org.frekele.fiscal.focus.nfe.client.model.entities.manifesto.MDeManifesto;
import org.frekele.fiscal.focus.nfe.client.model.entities.protocolo.cartacorrecao.NFeProtocoloCartaCorrecao;
import org.frekele.fiscal.focus.nfe.client.model.entities.requisicao.cartacorrecao.NFeRequisicaoCartaCorrecao;
import org.frekele.fiscal.focus.nfe.client.testng.InvokedMethodListener;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * @author frekele - Leandro Kersting de Freitas
 */
@Listeners(InvokedMethodListener.class)
public class MDeConsultarCceBodyResponseTest {

    @Test
    public void testNewInstance() throws Exception {
        NFeErro erro = new NFeErro();
        MDeManifesto manifesto = new MDeManifesto();
        NFeRequisicaoCartaCorrecao requisicaoCartaCorrecao = new NFeRequisicaoCartaCorrecao();
        NFeProtocoloCartaCorrecao protocoloCartaCorrecao = new NFeProtocoloCartaCorrecao();

        MDeConsultarCCeBodyResponse entity = new MDeConsultarCCeBodyResponse();
        entity.setErro(erro);
        entity.setManifesto(manifesto);
        entity.setRequisicaoCartaCorrecao(requisicaoCartaCorrecao);
        entity.setProtocoloCartaCorrecao(protocoloCartaCorrecao);

        assertNotNull(entity);
        assertEquals(erro, entity.getErro());
        assertEquals(manifesto, entity.getManifesto());
        assertEquals(requisicaoCartaCorrecao, entity.getRequisicaoCartaCorrecao());
        assertEquals(protocoloCartaCorrecao, entity.getProtocoloCartaCorrecao());
    }
}
