package org.frekele.fiscal.focus.nfe.client.model.entities.requisicao.notafiscal;

import org.frekele.fiscal.focus.nfe.client.model.entities.requisicao.notafiscal.NFeLacreVolumeTransportado;
import org.frekele.fiscal.focus.nfe.client.model.entities.requisicao.notafiscal.NFeVolumeTransportado;
import org.frekele.fiscal.focus.nfe.client.testng.InvokedMethodListener;
import org.frekele.fiscal.focus.nfe.client.util.FocusNFeUtils;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import javax.validation.ConstraintViolationException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;

/**
 * @author frekele - Leandro Kersting de Freitas
 */
@Listeners(InvokedMethodListener.class)
public class NFeVolumeTransportadoTest {

    @Test
    public void testNewInstance() throws Exception {
        String quantidade = "54654";
        String especie = "A";
        String marca = "Teste";
        String numero = "765786";
        BigDecimal pesoLiquido = new BigDecimal("1234.45");
        BigDecimal pesoBruto = new BigDecimal("6343.354");
        List<NFeLacreVolumeTransportado> lacres = new ArrayList<>();
        lacres.add(new NFeLacreVolumeTransportado());

        NFeVolumeTransportado entity = new NFeVolumeTransportado();
        entity.setQuantidade(quantidade);
        entity.setEspecie(especie);
        entity.setMarca(marca);
        entity.setNumero(numero);
        entity.setPesoLiquido(pesoLiquido);
        entity.setPesoBruto(pesoBruto);
        entity.setLacres(lacres);

        assertNotNull(entity);
        assertEquals(quantidade, entity.getQuantidade());
        assertEquals(especie, entity.getEspecie());
        assertEquals(marca, entity.getMarca());
        assertEquals(numero, entity.getNumero());
        assertEquals(pesoLiquido, entity.getPesoLiquido());
        assertEquals(pesoBruto, entity.getPesoBruto());
        assertEquals(lacres, entity.getLacres());

        entity = NFeVolumeTransportado.newBuilder()
            .withQuantidade(quantidade)
            .withEspecie(especie)
            .withMarca(marca)
            .withNumero(numero)
            .withPesoLiquido(pesoLiquido)
            .withPesoBruto(pesoBruto)
            .withLacres(lacres)
            .build();

        assertNotNull(entity);
        assertEquals(quantidade, entity.getQuantidade());
        assertEquals(especie, entity.getEspecie());
        assertEquals(marca, entity.getMarca());
        assertEquals(numero, entity.getNumero());
        assertEquals(pesoLiquido, entity.getPesoLiquido());
        assertEquals(pesoBruto, entity.getPesoBruto());
        assertEquals(lacres, entity.getLacres());
    }

    @Test
    public void testBeanValidation() throws Exception {
        NFeVolumeTransportado entity = new NFeVolumeTransportado();
        FocusNFeUtils.throwBeanValidation(entity);
    }

    @Test(expectedExceptions = {ConstraintViolationException.class})
    public void testBeanValidationWithError() throws Exception {
        NFeVolumeTransportado entity = new NFeVolumeTransportado();
        entity.setQuantidade("12347832849875945873495874359847");
        FocusNFeUtils.throwBeanValidation(entity);
    }
}
