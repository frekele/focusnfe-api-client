package org.frekele.fiscal.focus.nfe.client.model.entities.requisicao;

import org.frekele.fiscal.focus.nfe.client.enumeration.NFeModeloEcfEnum;
import org.frekele.fiscal.focus.nfe.client.enumeration.NFeUnidadeFederativaEnum;
import org.frekele.fiscal.focus.nfe.client.model.entities.requisicao.notafiscal.NFeNotaReferenciada;
import org.frekele.fiscal.focus.nfe.client.testng.InvokedMethodListener;
import org.frekele.fiscal.focus.nfe.client.util.FocusNFeUtils;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import javax.validation.ConstraintViolationException;

import static org.testng.Assert.*;

/**
 * @author frekele - Leandro Kersting de Freitas
 */
@Listeners(InvokedMethodListener.class)
public class NFeNotaReferenciadaTest {

    @Test
    public void testNewInstance() throws Exception {
        String chaveNfe = "";
        NFeUnidadeFederativaEnum uf = NFeUnidadeFederativaEnum.RIO_GRANDE_DO_SUL;
        String mes = "1804";
        String cnpj = "3456787654345";
        String modelo = "1";
        String serie = "1";
        String numero = "4564";
        NFeUnidadeFederativaEnum ufNfProdutor = NFeUnidadeFederativaEnum.RIO_GRANDE_DO_SUL;
        String mesNfProdutor = "1803";
        String cnpjNfProdutor = "87654987654327";
        String cpfNfProdutor = "76543456789";
        String inscricaoEstadualNfProdutor = "83459847";
        String modeloNfProdutor = "1";
        String serieNfProdutor = "1";
        String numeroNfProdutor = "1";
        String chaveCte = "7986745986745968745689897987";
        NFeModeloEcfEnum modeloEcf = NFeModeloEcfEnum.CUPOM_FISCAL_EMITIDO_ECF;
        String numeroEcf = "5";
        String coo = "675755";

        NFeNotaReferenciada entity = new NFeNotaReferenciada();
        entity.setChaveNfe(chaveNfe);
        entity.setUf(uf);
        entity.setMes(mes);
        entity.setCnpj(cnpj);
        entity.setModelo(modelo);
        entity.setSerie(serie);
        entity.setNumero(numero);
        entity.setUfNfProdutor(ufNfProdutor);
        entity.setMesNfProdutor(mesNfProdutor);
        entity.setCnpjNfProdutor(cnpjNfProdutor);
        entity.setCpfNfProdutor(cpfNfProdutor);
        entity.setInscricaoEstadualNfProdutor(inscricaoEstadualNfProdutor);
        entity.setModeloNfProdutor(modeloNfProdutor);
        entity.setSerieNfProdutor(serieNfProdutor);
        entity.setNumeroNfProdutor(numeroNfProdutor);
        entity.setChaveCte(chaveCte);
        entity.setModeloEcf(modeloEcf);
        entity.setNumeroEcf(numeroEcf);
        entity.setCoo(coo);

        assertNotNull(entity);
        assertEquals(chaveNfe, entity.getChaveNfe());
        assertEquals(uf, entity.getUf());
        assertEquals(mes, entity.getMes());
        assertEquals(cnpj, entity.getCnpj());
        assertEquals(modelo, entity.getModelo());
        assertEquals(serie, entity.getSerie());
        assertEquals(numero, entity.getNumero());
        assertEquals(ufNfProdutor, entity.getUfNfProdutor());
        assertEquals(mesNfProdutor, entity.getMesNfProdutor());
        assertEquals(cnpjNfProdutor, entity.getCnpjNfProdutor());
        assertEquals(cpfNfProdutor, entity.getCpfNfProdutor());
        assertEquals(inscricaoEstadualNfProdutor, entity.getInscricaoEstadualNfProdutor());
        assertEquals(modeloNfProdutor, entity.getModeloNfProdutor());
        assertEquals(serieNfProdutor, entity.getSerieNfProdutor());
        assertEquals(numeroNfProdutor, entity.getNumeroNfProdutor());
        assertEquals(chaveCte, entity.getChaveCte());
        assertEquals(modeloEcf, entity.getModeloEcf());
        assertEquals(numeroEcf, entity.getNumeroEcf());
        assertEquals(coo, entity.getCoo());

        entity = NFeNotaReferenciada.newBuilder()
            .withChaveNfe(chaveNfe)
            .withUf(uf)
            .withMes(mes)
            .withCnpj(cnpj)
            .withModelo(modelo)
            .withSerie(serie)
            .withNumero(numero)
            .withUfNfProdutor(ufNfProdutor)
            .withMesNfProdutor(mesNfProdutor)
            .withCnpjNfProdutor(cnpjNfProdutor)
            .withCpfNfProdutor(cpfNfProdutor)
            .withInscricaoEstadualNfProdutor(inscricaoEstadualNfProdutor)
            .withModeloNfProdutor(modeloNfProdutor)
            .withSerieNfProdutor(serieNfProdutor)
            .withNumeroNfProdutor(numeroNfProdutor)
            .withChaveCte(chaveCte)
            .withModeloEcf(modeloEcf)
            .withNumeroEcf(numeroEcf)
            .withCoo(coo)
            .build();

        assertNotNull(entity);
        assertEquals(chaveNfe, entity.getChaveNfe());
        assertEquals(uf, entity.getUf());
        assertEquals(mes, entity.getMes());
        assertEquals(cnpj, entity.getCnpj());
        assertEquals(modelo, entity.getModelo());
        assertEquals(serie, entity.getSerie());
        assertEquals(numero, entity.getNumero());
        assertEquals(ufNfProdutor, entity.getUfNfProdutor());
        assertEquals(mesNfProdutor, entity.getMesNfProdutor());
        assertEquals(cnpjNfProdutor, entity.getCnpjNfProdutor());
        assertEquals(cpfNfProdutor, entity.getCpfNfProdutor());
        assertEquals(inscricaoEstadualNfProdutor, entity.getInscricaoEstadualNfProdutor());
        assertEquals(modeloNfProdutor, entity.getModeloNfProdutor());
        assertEquals(serieNfProdutor, entity.getSerieNfProdutor());
        assertEquals(numeroNfProdutor, entity.getNumeroNfProdutor());
        assertEquals(chaveCte, entity.getChaveCte());
        assertEquals(modeloEcf, entity.getModeloEcf());
        assertEquals(numeroEcf, entity.getNumeroEcf());
        assertEquals(coo, entity.getCoo());
    }

    @Test
    public void testBeanValidation() throws Exception {
        NFeNotaReferenciada entity = new NFeNotaReferenciada();
        FocusNFeUtils.throwBeanValidation(entity);
    }

    @Test(expectedExceptions = {ConstraintViolationException.class})
    public void testBeanValidationWithError() throws Exception {
        NFeNotaReferenciada entity = new NFeNotaReferenciada();
        entity.setMes("27346786");
        FocusNFeUtils.throwBeanValidation(entity);
    }
}
