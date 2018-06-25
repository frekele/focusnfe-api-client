package org.frekele.fiscal.focus.nfe.client.model.entities.erro;

import org.frekele.fiscal.focus.nfe.client.testng.InvokedMethodListener;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;

/**
 * @author frekele - Leandro Kersting de Freitas
 */
@Listeners(InvokedMethodListener.class)
public class NFeErroTest {

    @Test
    public void testNewInstance() throws Exception {
        String codigo = "xxxxxxxx";
        String mensagem = "bla bla bla bla bla";
        List<NFeErro> erros = new ArrayList<>();
        erros.add(NFeErro.newBuilder().withCodigo("erro_xxx").withMensagem("bla bla bla bla bla").build());

        NFeErro entity = new NFeErro();
        entity.setCodigo(codigo);
        entity.setMensagem(mensagem);
        entity.setErros(erros);

        assertNotNull(entity);
        assertEquals(codigo, entity.getCodigo());
        assertEquals(mensagem, entity.getMensagem());
        assertEquals(erros, entity.getErros());

        entity = NFeErro.newBuilder()
            .withCodigo(codigo)
            .withMensagem(mensagem)
            .withErros(erros)
            .build();

        assertNotNull(entity);
        assertEquals(codigo, entity.getCodigo());
        assertEquals(mensagem, entity.getMensagem());
        assertEquals(erros, entity.getErros());
    }
}
