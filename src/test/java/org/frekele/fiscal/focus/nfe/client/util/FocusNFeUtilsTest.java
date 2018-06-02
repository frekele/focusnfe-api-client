package org.frekele.fiscal.focus.nfe.client.util;

import org.frekele.fiscal.focus.nfe.client.auth.EnvironmentFocusNFeEnum;
import org.frekele.fiscal.focus.nfe.client.auth.FocusNFeAuth;
import org.frekele.fiscal.focus.nfe.client.exception.FocusNFeException;
import org.frekele.fiscal.focus.nfe.client.testng.InvokedMethodListener;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.math.BigDecimal;

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
}
