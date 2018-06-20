package org.frekele.fiscal.focus.nfe.client.model.response.mde.body;

import org.frekele.fiscal.focus.nfe.client.enumeration.MDeTipoManifestacaoEnum;
import org.frekele.fiscal.focus.nfe.client.model.entities.erro.NFeErro;
import org.frekele.fiscal.focus.nfe.client.testng.InvokedMethodListener;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * @author frekele - Leandro Kersting de Freitas
 */
@Listeners(InvokedMethodListener.class)
public class MDeManifestarBodyResponseTest {

    @Test
    public void testNewInstance() throws Exception {
        NFeErro erro = new NFeErro();
        String status = "evento_registrado";
        String statusSefaz = "135";
        String mensagemSefaz = "Evento registrado e vinculado a NF-e";
        String protocolo = "891170005150285";
        MDeTipoManifestacaoEnum tipo = MDeTipoManifestacaoEnum.NAO_REALIZADA;
        String justificativa = "Fornecedor cancelou a operação devido a falta dos produtos em estoque.";

        MDeManifestarBodyResponse entity = new MDeManifestarBodyResponse();
        entity.setErro(erro);
        entity.setStatus(status);
        entity.setStatusSefaz(statusSefaz);
        entity.setMensagemSefaz(mensagemSefaz);
        entity.setProtocolo(protocolo);
        entity.setTipo(tipo);
        entity.setJustificativa(justificativa);

        assertNotNull(entity);
        assertEquals(erro, entity.getErro());
        assertEquals(status, entity.getStatus());
        assertEquals(statusSefaz, entity.getStatusSefaz());
        assertEquals(mensagemSefaz, entity.getMensagemSefaz());
        assertEquals(protocolo, entity.getProtocolo());
        assertEquals(tipo, entity.getTipo());
        assertEquals(justificativa, entity.getJustificativa());
    }
}
