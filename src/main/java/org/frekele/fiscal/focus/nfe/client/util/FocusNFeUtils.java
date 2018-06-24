package org.frekele.fiscal.focus.nfe.client.util;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.apache.commons.io.IOUtils;
import org.frekele.fiscal.focus.nfe.client.auth.FocusNFeAuth;
import org.frekele.fiscal.focus.nfe.client.exception.FocusNFeException;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.validation.ConstraintViolationException;
import javax.validation.Validation;
import javax.validation.ValidatorFactory;
import javax.ws.rs.client.ClientResponseContext;
import javax.ws.rs.core.MediaType;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.Base64;
import java.util.Set;

/**
 * FocusNFe métodos utilitários.
 *
 * @author frekele - Leandro Kersting de Freitas
 */
public final class FocusNFeUtils {

    public static void throwInjection(Object... objects) {
        for (Object obj : objects) {
            if (obj == null) {
                String msg = "Parameters in the constructor were not injected!";
                throw new FocusNFeException(msg);
            }
        }
    }

    public static void throwAuth(FocusNFeAuth auth) {
        if (auth == null) {
            throw new FocusNFeException("FocusNFeAuth can not be Null!");
        }
        if (auth.getAccessToken() == null) {
            throw new FocusNFeException("AccessToken can not be Null!");
        }
        if (auth.getAccessToken().trim().isEmpty()) {
            throw new FocusNFeException("AccessToken can not be Empty!");
        }
        if (auth.getEnvironment() == null) {
            throw new FocusNFeException("Environment can not be Null!");
        }
    }

    public static void throwObject(Object obj, String objectName) {
        if (obj == null || obj.toString().trim().isEmpty()) {
            throw new FocusNFeException("" + objectName + " can not be Null!");
        }
    }

    public static void throwBeanValidation(Object bean) {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Set constraintViolations = validatorFactory.getValidator().validate(bean);
        if (constraintViolations != null && !constraintViolations.isEmpty()) {
            throw new ConstraintViolationException(constraintViolations);
        }
        validatorFactory.close();
    }

    public static Charset discoveryCharset(ClientResponseContext responseContext) {
        Charset charset = null;
        MediaType mediaType = responseContext.getMediaType();
        if (mediaType != null) {
            String charsetName = mediaType.getParameters().get("charset");
            if (charsetName != null) {
                charset = Charset.forName(charsetName);
            }
        }
        if (charset == null) {
            charset = Charset.defaultCharset();
        }
        return charset;
    }

    public static String responseBodyToString(ClientResponseContext responseContext) throws IOException {
        String body = null;
        if (responseContext.hasEntity()) {
            try (InputStream entityStream = responseContext.getEntityStream()) {
                Charset charset = discoveryCharset(responseContext);
                body = IOUtils.toString(entityStream, charset);
                //Original EntityStream is closed, add InputStream again for Security.
                responseContext.setEntityStream(IOUtils.toInputStream(body, charset));
            }
        }
        return body;
    }

    public static void replaceResponseBodyJsonArrayToJsonObject(ClientResponseContext responseContext) throws IOException {
        if (responseContext.hasEntity()) {
            try (InputStream entityStream = responseContext.getEntityStream()) {
                Charset charset = discoveryCharset(responseContext);
                String body = IOUtils.toString(entityStream, charset);

                if (!body.trim().isEmpty()) {
                    body = body.trim();
                    if (body.substring(0, 1).equals("[")) {
                        body = "{ \"arrayValues\" : " + body + " }";
                    }
                }
                responseContext.setEntityStream(IOUtils.toInputStream(body, charset));
            }
        }
    }

    public static String encodeBase64(String value) {
        if (value != null && !value.isEmpty()) {
            return Base64.getEncoder().encodeToString(value.getBytes(Charset.forName("UTF-8")));
        } else {
            throw new FocusNFeException("value is null or empty.");
        }
    }

    public static String decodeBase64(String base64Value) {
        if (base64Value != null && !base64Value.isEmpty()) {
            byte[] bytesValue = Base64.getDecoder().decode(base64Value);
            return new String(bytesValue, Charset.forName("UTF-8"));
        } else {
            throw new FocusNFeException("base64Value is null or empty.");
        }
    }

    public static String buildAuthorization(String username) {
        return buildAuthorization(username, "");
    }

    public static String buildAuthorization(String username, String password) {
        String authorization = (username == null ? "" : username) + ":" + (password == null ? "" : password);
        return encodeBase64(authorization);
    }

    public static JsonNode parseJsonToJsonNode(String content) throws IOException {
        return new ObjectMapper().readTree(content);
    }

    public static <T> T parseJsonTo(String content, Class<T> classType) throws IOException {
        return new ObjectMapper().readValue(content, classType);
    }

    public static String parseJsonToString(JsonNode jsonValue) throws IOException {
        return parseJsonToString(jsonValue, false);
    }

    public static String parseJsonToString(Object jsonValue) throws IOException {
        return parseJsonToString(jsonValue, false);
    }

    public static String parseJsonToString(Object jsonValue, boolean pretty) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        if (pretty) {
            return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonValue);
        } else {
            return mapper.writeValueAsString(jsonValue);
        }
    }

    public static JsonNode parseXmlToJsonNode(String content) throws IOException {
        return new XmlMapper().readTree(content);
    }

    public static Document parseXmlToDocument(String content) throws ParserConfigurationException, IOException, SAXException {
        return parseXmlToDocument(content, Charset.forName("UTF-8"));
    }

    public static Document parseXmlToDocument(String content, Charset charset) throws ParserConfigurationException, IOException, SAXException {
        Document document;
        try (ByteArrayInputStream inputStream = new ByteArrayInputStream(content.getBytes(charset))) {
            document = parseXmlToDocument(inputStream);
        }
        return document;
    }

    public static Document parseXmlToDocument(InputStream xml) throws ParserConfigurationException, IOException, SAXException {
        return DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(xml);
    }
}
