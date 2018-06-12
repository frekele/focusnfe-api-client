package org.frekele.fiscal.focus.nfe.client.model.requisicao;

import org.frekele.fiscal.focus.nfe.client.enumeration.NFeFormaIntermedioEnum;
import org.frekele.fiscal.focus.nfe.client.enumeration.NFeUnidadeFederativaEnum;
import org.frekele.fiscal.focus.nfe.client.enumeration.NFeViaTransporteEnum;
import org.frekele.fiscal.focus.nfe.client.testng.InvokedMethodListener;
import org.frekele.fiscal.focus.nfe.client.util.FocusNFeUtils;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import javax.validation.ConstraintViolationException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;

/**
 * @author frekele - Leandro Kersting de Freitas
 */
@Listeners(InvokedMethodListener.class)
public class NFeDocumentoImportacaoTest {

    @Test
    public void testNewInstance() throws Exception {
        String numero = "367456735";
        LocalDate dataRegistro = LocalDate.parse("2017-04-02");
        String localDesembaracoAduaneiro = "Ssh sdkjfh sdkjfh ksjdh fsd";
        NFeUnidadeFederativaEnum ufDesembaracoAduaneiro = NFeUnidadeFederativaEnum.RIO_GRANDE_DO_SUL;
        LocalDate dataDesembaracoAduaneiro = LocalDate.parse("2017-04-02");
        NFeViaTransporteEnum viaTransporte = NFeViaTransporteEnum.RODOVIARIA;
        BigDecimal valorAfrmm = new BigDecimal("2354.45");
        NFeFormaIntermedioEnum formaIntermedio = NFeFormaIntermedioEnum.IMPORTACAO_POR_ENCOMENDA;
        String cnpj = "91725747000162";
        NFeUnidadeFederativaEnum ufTerceiro = NFeUnidadeFederativaEnum.RIO_GRANDE_DO_SUL;
        String codigoExportador = "75765765765";
        List<NFeAdicaoDocumentoImportacao> adicoes = new ArrayList<>();
        adicoes.add(new NFeAdicaoDocumentoImportacao());

        NFeDocumentoImportacao entity = new NFeDocumentoImportacao();
        entity.setNumero(numero);
        entity.setDataRegistro(dataRegistro);
        entity.setLocalDesembaracoAduaneiro(localDesembaracoAduaneiro);
        entity.setUfDesembaracoAduaneiro(ufDesembaracoAduaneiro);
        entity.setDataDesembaracoAduaneiro(dataDesembaracoAduaneiro);
        entity.setViaTransporte(viaTransporte);
        entity.setValorAfrmm(valorAfrmm);
        entity.setFormaIntermedio(formaIntermedio);
        entity.setCnpj(cnpj);
        entity.setUfTerceiro(ufTerceiro);
        entity.setCodigoExportador(codigoExportador);
        entity.setAdicoes(adicoes);

        assertNotNull(entity);
        assertEquals(numero, entity.getNumero());
        assertEquals(dataRegistro, entity.getDataRegistro());
        assertEquals(localDesembaracoAduaneiro, entity.getLocalDesembaracoAduaneiro());
        assertEquals(ufDesembaracoAduaneiro, entity.getUfDesembaracoAduaneiro());
        assertEquals(dataDesembaracoAduaneiro, entity.getDataDesembaracoAduaneiro());
        assertEquals(viaTransporte, entity.getViaTransporte());
        assertEquals(valorAfrmm, entity.getValorAfrmm());
        assertEquals(formaIntermedio, entity.getFormaIntermedio());
        assertEquals(cnpj, entity.getCnpj());
        assertEquals(ufTerceiro, entity.getUfTerceiro());
        assertEquals(codigoExportador, entity.getCodigoExportador());
        assertEquals(adicoes, entity.getAdicoes());

        entity = NFeDocumentoImportacao.newBuilder()
            .withNumero(numero)
            .withDataRegistro(dataRegistro)
            .withLocalDesembaracoAduaneiro(localDesembaracoAduaneiro)
            .withUfDesembaracoAduaneiro(ufDesembaracoAduaneiro)
            .withDataDesembaracoAduaneiro(dataDesembaracoAduaneiro)
            .withViaTransporte(viaTransporte)
            .withValorAfrmm(valorAfrmm)
            .withFormaIntermedio(formaIntermedio)
            .withCnpj(cnpj)
            .withUfTerceiro(ufTerceiro)
            .withCodigoExportador(codigoExportador)
            .withAdicoes(adicoes)
            .build();

        assertNotNull(entity);
        assertEquals(numero, entity.getNumero());
        assertEquals(dataRegistro, entity.getDataRegistro());
        assertEquals(localDesembaracoAduaneiro, entity.getLocalDesembaracoAduaneiro());
        assertEquals(ufDesembaracoAduaneiro, entity.getUfDesembaracoAduaneiro());
        assertEquals(dataDesembaracoAduaneiro, entity.getDataDesembaracoAduaneiro());
        assertEquals(viaTransporte, entity.getViaTransporte());
        assertEquals(valorAfrmm, entity.getValorAfrmm());
        assertEquals(formaIntermedio, entity.getFormaIntermedio());
        assertEquals(cnpj, entity.getCnpj());
        assertEquals(ufTerceiro, entity.getUfTerceiro());
        assertEquals(codigoExportador, entity.getCodigoExportador());
        assertEquals(adicoes, entity.getAdicoes());
    }

    @Test
    public void testBeanValidation() throws Exception {
        NFeDocumentoImportacao entity = new NFeDocumentoImportacao();
        FocusNFeUtils.throwBeanValidation(entity);
    }

    @Test(expectedExceptions = {ConstraintViolationException.class})
    public void testBeanValidationWithError() throws Exception {
        NFeDocumentoImportacao entity = new NFeDocumentoImportacao();
        entity.setCnpj("1213456479085430985347");
        FocusNFeUtils.throwBeanValidation(entity);
    }
}
