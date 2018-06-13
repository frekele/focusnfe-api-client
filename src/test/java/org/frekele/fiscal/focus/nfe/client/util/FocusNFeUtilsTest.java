package org.frekele.fiscal.focus.nfe.client.util;

import org.frekele.fiscal.focus.nfe.client.auth.EnvironmentFocusNFeEnum;
import org.frekele.fiscal.focus.nfe.client.auth.FocusNFeAuth;
import org.frekele.fiscal.focus.nfe.client.exception.FocusNFeException;
import org.frekele.fiscal.focus.nfe.client.model.request.nfe.body.NFeCancelarBodyRequest;
import org.frekele.fiscal.focus.nfe.client.testng.InvokedMethodListener;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import javax.validation.ConstraintViolationException;
import java.math.BigDecimal;

import static org.testng.Assert.*;

/**
 * @author frekele - Leandro Kersting de Freitas
 */
@Listeners(InvokedMethodListener.class)
public class FocusNFeUtilsTest {

    String accessToken = "hd8f3sd3t3y4t87hfer8h4";

    EnvironmentFocusNFeEnum environmentNull = null;

    EnvironmentFocusNFeEnum environment = EnvironmentFocusNFeEnum.HOMOLOGATION;

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
}
