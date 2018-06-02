package org.frekele.fiscal.focus.nfe.client.auth;

import org.frekele.fiscal.focus.nfe.client.testng.InvokedMethodListener;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * @author frekele - Leandro Kersting de Freitas
 */
@Listeners(InvokedMethodListener.class)
public class FocusNFeAuthTest {

    @Test
    public void testNewInstance() throws Exception {
        String accessToken = "3gf4765n8736nfd65fg";
        EnvironmentFocusNFeEnum environment = EnvironmentFocusNFeEnum.HOMOLOGATION;

        FocusNFeAuth auth = new FocusNFeAuth(accessToken, environment);

        assertNotNull(auth);
        assertEquals(accessToken, auth.getAccessToken());
        assertEquals(environment, auth.getEnvironment());
    }

    @Test
    public void testNewInstance2() throws Exception {
        String accessToken = "s76d786e6234rhucv7824";
        String environment = "HOMOLOGATION";

        FocusNFeAuth auth = new FocusNFeAuth(accessToken, environment);

        assertNotNull(auth);
        assertEquals(accessToken, auth.getAccessToken());
        assertNotNull(auth.getEnvironment());
        assertEquals(environment, auth.getEnvironment().getValue());

        auth = FocusNFeAuth.newBuilder()
            .withAccessToken(accessToken)
            .withEnvironment(environment)
            .build();

        assertNotNull(auth);
        assertEquals(accessToken, auth.getAccessToken());
        assertNotNull(auth.getEnvironment());
        assertEquals(environment, auth.getEnvironment().getValue());
    }
}
