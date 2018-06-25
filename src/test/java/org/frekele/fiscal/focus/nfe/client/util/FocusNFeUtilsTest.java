package org.frekele.fiscal.focus.nfe.client.util;

import com.fasterxml.jackson.databind.JsonNode;
import org.frekele.fiscal.focus.nfe.client.auth.EnvironmentFocusNFeEnum;
import org.frekele.fiscal.focus.nfe.client.auth.FocusNFeAuth;
import org.frekele.fiscal.focus.nfe.client.exception.FocusNFeException;
import org.frekele.fiscal.focus.nfe.client.model.entities.erro.NFeErro;
import org.frekele.fiscal.focus.nfe.client.model.request.nfe.body.NFeCancelarBodyRequest;
import org.frekele.fiscal.focus.nfe.client.testng.InvokedMethodListener;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.validation.ConstraintViolationException;
import javax.ws.rs.client.ClientResponseContext;
import javax.ws.rs.core.MediaType;
import java.io.ByteArrayInputStream;
import java.math.BigDecimal;
import java.nio.charset.Charset;

import static org.mockito.Mockito.*;
import static org.testng.Assert.*;

/**
 * @author frekele - Leandro Kersting de Freitas
 */
@Listeners(InvokedMethodListener.class)
public class FocusNFeUtilsTest {

    String accessToken = "hd8f3sd3t3y4t87hfer8h4";

    EnvironmentFocusNFeEnum environmentNull = null;

    EnvironmentFocusNFeEnum environment = EnvironmentFocusNFeEnum.HOMOLOGATION;

    String xmlContent = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
        "<procEventoNFe versao=\"1.00\" xmlns=\"http://www.portalfiscal.inf.br/nfe\">\n" +
        "    <evento versao=\"1.00\" xmlns=\"http://www.portalfiscal.inf.br/nfe\">\n" +
        "        <infEvento Id=\"ID1101104118062514300066015855001000918468000004248003\">\n" +
        "            <cOrgao>41</cOrgao>\n" +
        "            <tpAmb>2</tpAmb>\n" +
        "            <CNPJ>00391015884680</CNPJ>\n" +
        "            <chNFe>41180625143000660158550010009184680000042480</chNFe>\n" +
        "            <dhEvento>2018-06-22T19:34:59-03:00</dhEvento>\n" +
        "            <tpEvento>110110</tpEvento>\n" +
        "            <nSeqEvento>3</nSeqEvento>\n" +
        "            <verEvento>1.00</verEvento>\n" +
        "            <detEvento versao=\"1.00\">\n" +
        "                <descEvento>Carta de Correcao</descEvento>\n" +
        "                <xCorrecao>Teste 12345 carta de correcao</xCorrecao>\n" +
        "                <xCondUso>A Carta de Correcao e etc...</xCondUso>\n" +
        "            </detEvento>\n" +
        "        </infEvento>\n" +
        "    </evento>\n" +
        "    <retEvento versao=\"1.00\" xmlns=\"http://www.portalfiscal.inf.br/nfe\">\n" +
        "        <infEvento>\n" +
        "            <tpAmb>2</tpAmb>\n" +
        "            <verAplic>PR-v4_2_1</verAplic>\n" +
        "            <cOrgao>41</cOrgao>\n" +
        "            <cStat>135</cStat>\n" +
        "            <xMotivo>Evento registrado e vinculado a NF-e</xMotivo>\n" +
        "            <chNFe>41180625143000660158550010009184680000042480</chNFe>\n" +
        "            <tpEvento>110110</tpEvento>\n" +
        "            <xEvento>Carta de Correcao</xEvento>\n" +
        "            <nSeqEvento>3</nSeqEvento>\n" +
        "            <dhRegEvento>2018-06-22T19:35:01-03:00</dhRegEvento>\n" +
        "            <nProt>141100004846601</nProt>\n" +
        "        </infEvento>\n" +
        "    </retEvento>\n" +
        "</procEventoNFe>";

    @Test
    public void testThrowInjection() throws Exception {
        FocusNFeUtils c = new FocusNFeUtils();
        FocusNFeUtils.throwInjection("");
        FocusNFeUtils.throwInjection("a");
        FocusNFeUtils.throwInjection("a", "b");
        FocusNFeUtils.throwInjection("a", "b", "c", 1, 3, 5);
        FocusNFeUtils.throwInjection("a", "b", "c", 1, 3, 5, new BigDecimal(0.0));
    }

    @Test
    public void testThrowInjection2() throws Exception {
        FocusNFeUtils.throwInjection();
    }

    @Test(expectedExceptions = {FocusNFeException.class})
    public void testThrowInjectionWithError() throws Exception {
        String val = null;
        FocusNFeUtils.throwInjection(val);
    }

    @Test(expectedExceptions = {FocusNFeException.class})
    public void testThrowInjectionWithError2() throws Exception {
        String val1 = "";
        BigDecimal val2 = null;
        FocusNFeUtils.throwInjection(val1, val2);
    }

    @Test
    public void testThrowAuth() throws Exception {
        FocusNFeAuth auth = new FocusNFeAuth(accessToken, environment);
        FocusNFeUtils.throwAuth(auth);
    }

    @Test(expectedExceptions = {FocusNFeException.class})
    public void testThrowAuthWithError() throws Exception {
        FocusNFeUtils.throwAuth(null);
    }

    @Test(expectedExceptions = {FocusNFeException.class})
    public void testThrowAuthWithError2() throws Exception {

        FocusNFeAuth auth = new FocusNFeAuth(null, environmentNull);
        FocusNFeUtils.throwAuth(auth);
    }

    @Test(expectedExceptions = {FocusNFeException.class})
    public void testThrowAuthWithError3() throws Exception {
        FocusNFeAuth auth = new FocusNFeAuth("", environmentNull);
        FocusNFeUtils.throwAuth(auth);
    }

    @Test(expectedExceptions = {FocusNFeException.class})
    public void testThrowAuthWithError4() throws Exception {
        FocusNFeAuth auth = new FocusNFeAuth(accessToken, environmentNull);
        FocusNFeUtils.throwAuth(auth);
    }

    @Test
    public void testThrowObject() throws Exception {
        FocusNFeUtils.throwObject("xxxxx", "value");
    }

    @Test(expectedExceptions = {FocusNFeException.class})
    public void testThrowObjectWithError() throws Exception {
        FocusNFeUtils.throwObject(null, "value");
    }

    @Test(expectedExceptions = {FocusNFeException.class})
    public void testThrowObjectWithError2() throws Exception {
        FocusNFeUtils.throwObject("", "value");
    }

    @Test
    public void testThrowBeanValidation() throws Exception {
        NFeCancelarBodyRequest bean = new NFeCancelarBodyRequest("bla bla bla bla bla bla");
        FocusNFeUtils.throwBeanValidation(bean);
    }

    @Test(expectedExceptions = {ConstraintViolationException.class})
    public void testThrowBeanValidationWithError() throws Exception {
        NFeCancelarBodyRequest bean = new NFeCancelarBodyRequest();
        FocusNFeUtils.throwBeanValidation(bean);
    }

    @Test(expectedExceptions = {ConstraintViolationException.class})
    public void testThrowBeanValidationWithError2() throws Exception {
        String justificativa = "";
        NFeCancelarBodyRequest bean = new NFeCancelarBodyRequest(justificativa);
        FocusNFeUtils.throwBeanValidation(bean);
    }

    @Test(expectedExceptions = {ConstraintViolationException.class})
    public void testThrowBeanValidationWithError3() throws Exception {
        String justificativa = "aaaaa";//5
        NFeCancelarBodyRequest bean = new NFeCancelarBodyRequest(justificativa);
        FocusNFeUtils.throwBeanValidation(bean);
    }

    @Test(expectedExceptions = {ConstraintViolationException.class})
    public void testThrowBeanValidationWithError4() throws Exception {
        String justificativa = "";
        justificativa += "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
        justificativa += "bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb";
        justificativa += "cccccccccccccccccccccccccccccccccccccccccccccccccc";
        justificativa += "dddddddddddddddddddddddddddddddddddddddddddddddddd";
        justificativa += "eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee";
        justificativa += "ffffff";//256
        System.out.println("justificativa.length(): " + justificativa.length());
        NFeCancelarBodyRequest bean = new NFeCancelarBodyRequest(justificativa);
        FocusNFeUtils.throwBeanValidation(bean);
    }

    @Test
    public void testThrowBeanValidationWithoutError() throws Exception {
        String justificativa = "";
        justificativa += "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
        justificativa += "bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb";
        justificativa += "cccccccccccccccccccccccccccccccccccccccccccccccccc";
        justificativa += "dddddddddddddddddddddddddddddddddddddddddddddddddd";
        justificativa += "eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee";
        justificativa += "fffff";//255
        System.out.println("justificativa.length(): " + justificativa.length());
        NFeCancelarBodyRequest bean = new NFeCancelarBodyRequest(justificativa);
        FocusNFeUtils.throwBeanValidation(bean);
    }

    @Test
    public void testDiscoveryCharset() throws Exception {
        ClientResponseContext responseContext = mock(ClientResponseContext.class);

        Charset value = FocusNFeUtils.discoveryCharset(responseContext);
        assertEquals(value, Charset.defaultCharset());

        MediaType mediaType = MediaType.APPLICATION_JSON_TYPE;
        when(responseContext.getMediaType()).thenReturn(mediaType);
        value = FocusNFeUtils.discoveryCharset(responseContext);
        assertEquals(value, Charset.defaultCharset());

        mediaType = MediaType.APPLICATION_JSON_TYPE.withCharset("UTF-8");
        when(responseContext.getMediaType()).thenReturn(mediaType);
        value = FocusNFeUtils.discoveryCharset(responseContext);
        assertEquals(value, Charset.forName("UTF-8"));
    }

    @Test
    public void testResponseBodyToString() throws Exception {
        ClientResponseContext responseContext = mock(ClientResponseContext.class);

        when(responseContext.hasEntity()).thenReturn(false);
        String value = FocusNFeUtils.responseBodyToString(responseContext);
        assertNull(value);

        String expectedValue = "{}";
        when(responseContext.hasEntity()).thenReturn(true);
        when(responseContext.getMediaType()).thenReturn(MediaType.APPLICATION_JSON_TYPE.withCharset("UTF-8"));
        when(responseContext.getEntityStream()).thenReturn(new ByteArrayInputStream(expectedValue.getBytes("UTF-8")));
        value = FocusNFeUtils.responseBodyToString(responseContext);
        assertEquals(value, expectedValue);
    }

    @Test
    public void testReplaceResponseBodyJsonArrayToJsonObject() throws Exception {
        ClientResponseContext responseContext = mock(ClientResponseContext.class);

        when(responseContext.hasEntity()).thenReturn(false);
        FocusNFeUtils.replaceResponseBodyJsonArrayToJsonObject(responseContext);

        when(responseContext.hasEntity()).thenReturn(true);
        when(responseContext.getMediaType()).thenReturn(MediaType.APPLICATION_JSON_TYPE.withCharset("UTF-8"));
        when(responseContext.getEntityStream()).thenReturn(new ByteArrayInputStream("{}".getBytes("UTF-8")));
        FocusNFeUtils.replaceResponseBodyJsonArrayToJsonObject(responseContext);

        when(responseContext.getEntityStream()).thenReturn(new ByteArrayInputStream("[]".getBytes("UTF-8")));
        FocusNFeUtils.replaceResponseBodyJsonArrayToJsonObject(responseContext);
    }

    @Test
    public void testEncodeBase64() throws Exception {
        String value = "ksjldfoiw7t9834j7vtfwejf8wef";
        String expectedValue = "a3NqbGRmb2l3N3Q5ODM0ajd2dGZ3ZWpmOHdlZg==";

        String valueBase64 = FocusNFeUtils.encodeBase64(value);
        assertEquals(valueBase64, expectedValue);
    }

    @Test(expectedExceptions = {FocusNFeException.class})
    public void testEncodeBase64WithError() throws Exception {
        FocusNFeUtils.encodeBase64("");
    }

    @Test(expectedExceptions = {FocusNFeException.class})
    public void testEncodeBase64WithError2() throws Exception {
        FocusNFeUtils.encodeBase64(null);
    }

    @Test
    public void testDecodeBase64() throws Exception {
        String valueBase64 = "eWdkZTc2MjNnZmZnaHVkZnRnMjNmZGJxZGY=";
        String expectedValue = "ygde7623gffghudftg23fdbqdf";

        String value = FocusNFeUtils.decodeBase64(valueBase64);
        assertEquals(value, expectedValue);
    }

    @Test(expectedExceptions = {FocusNFeException.class})
    public void testDecodeBase64WithError() throws Exception {
        FocusNFeUtils.decodeBase64("");
    }

    @Test(expectedExceptions = {FocusNFeException.class})
    public void testDecodeBase64WithError2() throws Exception {
        FocusNFeUtils.decodeBase64(null);
    }

    @Test
    public void testBuildAuthorization() throws Exception {
        String username = "uigfy3j4vt83f743tyvh37t784";
        String password = "37ht637848tc3yfrfwbrfcwy4";
        String expectedValue = "dWlnZnkzajR2dDgzZjc0M3R5dmgzN3Q3ODQ6MzdodDYzNzg0OHRjM3lmcmZ3YnJmY3d5NA==";

        String value = FocusNFeUtils.buildAuthorization(username, password);
        assertEquals(value, expectedValue);
    }

    @Test
    public void testBuildAuthorization2() throws Exception {
        String username = "dg98vey8tj35gv34786tyjg7";
        String password = "";
        String expectedValue = "ZGc5OHZleTh0ajM1Z3YzNDc4NnR5amc3Og==";

        String value = FocusNFeUtils.buildAuthorization(username, password);
        assertEquals(value, expectedValue);

        value = FocusNFeUtils.buildAuthorization(username, null);
        assertEquals(value, expectedValue);
    }

    @Test
    public void testBuildAuthorization3() throws Exception {
        String username = "";
        String password = "";
        String expectedValue = "Og==";

        String value = FocusNFeUtils.buildAuthorization(username, password);
        assertEquals(value, expectedValue);

        value = FocusNFeUtils.buildAuthorization(null, null);
        assertEquals(value, expectedValue);
    }

    @Test
    public void testBuildAuthorization4() throws Exception {
        String username = "hfg78y5vjg37h47htybv87w4t";
        String expectedValue = "aGZnNzh5NXZqZzM3aDQ3aHR5YnY4N3c0dDo=";

        String value = FocusNFeUtils.buildAuthorization(username);
        assertEquals(value, expectedValue);
    }

    @Test
    public void testParseJsonToJsonNode() throws Exception {
        String content = "{\"codigo\":\"123\",\"mensagem\":\"teste\"}";
        JsonNode value = FocusNFeUtils.parseJsonToJsonNode(content);
        assertEquals(value.get("codigo").asInt(), 123);
        assertEquals(value.get("mensagem").asText(), "teste");
    }

    @Test
    public void testParseJsonTo() throws Exception {
        String content = "{\"codigo\":\"123\",\"mensagem\":\"teste\"}";
        NFeErro value = FocusNFeUtils.parseJsonTo(content, NFeErro.class);
        assertEquals(value.getCodigo(), "123");
        assertEquals(value.getMensagem(), "teste");
    }

    @Test
    public void testParseJsonToString() throws Exception {
        String content = "{\"codigo\":\"123\",\"mensagem\":\"teste\"}";
        JsonNode jsonNode = FocusNFeUtils.parseJsonToJsonNode(content);
        String value = FocusNFeUtils.parseJsonToString(jsonNode);
        assertEquals(value, content);

        Object objValue = FocusNFeUtils.parseJsonToJsonNode(content);
        value = FocusNFeUtils.parseJsonToString(objValue);
        assertEquals(value, content);

        String expectedValue = "{\n  \"codigo\" : \"123\",\n  \"mensagem\" : \"teste\"\n}";
        value = FocusNFeUtils.parseJsonToString(objValue, true);
        //Remove \r if is windows system.
        value = value.replace("\r", "");
        assertEquals(value, expectedValue);
    }

    @Test
    public void testParseXmlToJsonNode() throws Exception {
        JsonNode rootNode = FocusNFeUtils.parseXmlToJsonNode(xmlContent);
        assertEquals(rootNode.get("evento").get("infEvento").get("cOrgao").asText(), "41");
        assertEquals(rootNode.get("evento").get("infEvento").get("chNFe").asText(), "41180625143000660158550010009184680000042480");
        assertEquals(rootNode.get("evento").get("infEvento").get("detEvento").get("xCorrecao").asText(), "Teste 12345 carta de correcao");
        assertEquals(rootNode.get("retEvento").get("infEvento").get("xMotivo").asText(), "Evento registrado e vinculado a NF-e");
        assertEquals(rootNode.get("retEvento").get("infEvento").get("xEvento").asText(), "Carta de Correcao");
        assertEquals(rootNode.get("retEvento").get("infEvento").get("nProt").asText(), "141100004846601");
    }

    @Test
    public void testParseXmlToDocument() throws Exception {
        Document document = FocusNFeUtils.parseXmlToDocument(xmlContent);
        Element element = document.getDocumentElement();
        assertEquals(element.getElementsByTagName("cOrgao").item(0).getFirstChild().getNodeValue(), "41");
        assertEquals(element.getElementsByTagName("chNFe").item(0).getFirstChild().getNodeValue(), "41180625143000660158550010009184680000042480");
        assertEquals(element.getElementsByTagName("xCorrecao").item(0).getFirstChild().getNodeValue(), "Teste 12345 carta de correcao");
        assertEquals(element.getElementsByTagName("xMotivo").item(0).getFirstChild().getNodeValue(), "Evento registrado e vinculado a NF-e");
        assertEquals(element.getElementsByTagName("xEvento").item(0).getFirstChild().getNodeValue(), "Carta de Correcao");
        assertEquals(element.getElementsByTagName("nProt").item(0).getFirstChild().getNodeValue(), "141100004846601");
    }
}
