package org.frekele.fiscal.focus.nfe.client.model.request.ncm.param;

import org.frekele.fiscal.focus.nfe.client.testng.InvokedMethodListener;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * @author frekele - Leandro Kersting de Freitas
 */
@Listeners(InvokedMethodListener.class)
public class NcmQueryParamTest {

    @Test
    public void testNewInstance() throws Exception {
        String codigo = "90049090";
        String descricao = "Óculos";
        String capitulo = "90";
        String posicao = "04";
        String subposicao1 = "9";
        String subposicao2 = "0";
        String item1 = "9";
        String item2 = "0";
        String offset = "20";

        NcmQueryParam entity = new NcmQueryParam();
        entity.setCodigo(codigo);
        entity.setDescricao(descricao);
        entity.setCapitulo(capitulo);
        entity.setPosicao(posicao);
        entity.setSubposicao1(subposicao1);
        entity.setSubposicao2(subposicao2);
        entity.setItem1(item1);
        entity.setItem2(item2);
        entity.setOffset(offset);

        assertNotNull(entity);
        assertEquals(codigo, entity.getCodigo());
        assertEquals(descricao, entity.getDescricao());
        assertEquals(capitulo, entity.getCapitulo());
        assertEquals(posicao, entity.getPosicao());
        assertEquals(subposicao1, entity.getSubposicao1());
        assertEquals(subposicao2, entity.getSubposicao2());
        assertEquals(item1, entity.getItem1());
        assertEquals(item2, entity.getItem2());
        assertEquals(offset, entity.getOffset());

        entity = NcmQueryParam.newBuilder()
            .withCodigo(codigo)
            .withDescricao(descricao)
            .withCapitulo(capitulo)
            .withPosicao(posicao)
            .withSubposicao1(subposicao1)
            .withSubposicao2(subposicao2)
            .withItem1(item1)
            .withItem2(item2)
            .withOffset(offset)
            .build();

        assertNotNull(entity);
        assertEquals(codigo, entity.getCodigo());
        assertEquals(descricao, entity.getDescricao());
        assertEquals(capitulo, entity.getCapitulo());
        assertEquals(posicao, entity.getPosicao());
        assertEquals(subposicao1, entity.getSubposicao1());
        assertEquals(subposicao2, entity.getSubposicao2());
        assertEquals(item1, entity.getItem1());
        assertEquals(item2, entity.getItem2());
        assertEquals(offset, entity.getOffset());
    }
}
