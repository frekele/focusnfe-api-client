package org.frekele.fiscal.focus.nfe.client.model.entities.ncm;

import org.frekele.fiscal.focus.nfe.client.testng.InvokedMethodListener;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * @author frekele - Leandro Kersting de Freitas
 */
@Listeners(InvokedMethodListener.class)
public class NFeNcmTest {

    @Test
    public void testNewInstance() throws Exception {
        String codigo = "90049090";
        String descricaoCompleta = "Óculos para correção, proteção ou outros fins, e artigos semelhantes. Outros Outros";
        String capitulo = "90";
        String posicao = "04";
        String subposicao1 = "9";
        String subposicao2 = "0";
        String item1 = "9";
        String item2 = "0";

        NFeNcm entity = new NFeNcm();
        entity.setCodigo(codigo);
        entity.setDescricaoCompleta(descricaoCompleta);
        entity.setCapitulo(capitulo);
        entity.setPosicao(posicao);
        entity.setSubposicao1(subposicao1);
        entity.setSubposicao2(subposicao2);
        entity.setItem1(item1);
        entity.setItem2(item2);

        assertNotNull(entity);
        assertEquals(codigo, entity.getCodigo());
        assertEquals(descricaoCompleta, entity.getDescricaoCompleta());
        assertEquals(capitulo, entity.getCapitulo());
        assertEquals(posicao, entity.getPosicao());
        assertEquals(subposicao1, entity.getSubposicao1());
        assertEquals(subposicao2, entity.getSubposicao2());
        assertEquals(item1, entity.getItem1());
        assertEquals(item2, entity.getItem2());

        entity = NFeNcm.newBuilder()
            .withCodigo(codigo)
            .withDescricaoCompleta(descricaoCompleta)
            .withCapitulo(capitulo)
            .withPosicao(posicao)
            .withSubposicao1(subposicao1)
            .withSubposicao2(subposicao2)
            .withItem1(item1)
            .withItem2(item2)
            .build();

        assertNotNull(entity);
        assertEquals(codigo, entity.getCodigo());
        assertEquals(descricaoCompleta, entity.getDescricaoCompleta());
        assertEquals(capitulo, entity.getCapitulo());
        assertEquals(posicao, entity.getPosicao());
        assertEquals(subposicao1, entity.getSubposicao1());
        assertEquals(subposicao2, entity.getSubposicao2());
        assertEquals(item1, entity.getItem1());
        assertEquals(item2, entity.getItem2());
    }
}
