package org.frekele.fiscal.focus.nfe.client.exception;

import org.frekele.fiscal.focus.nfe.client.testng.InvokedMethodListener;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * @author frekele - Leandro Kersting de Freitas
 */
@Listeners(InvokedMethodListener.class)
public class FocusNFeExceptionTest {

    String msg = "Error Message";

    IOException cause = new IOException("IO error");

    @Test(expectedExceptions = FocusNFeException.class)
    public void testConstructorWithMessage() throws Exception {
        throw new FocusNFeException(msg);
    }

    @Test(expectedExceptions = FocusNFeException.class)
    public void testConstructorWithCause() throws Exception {
        throw new FocusNFeException(cause);
    }

    @Test(expectedExceptions = FocusNFeException.class)
    public void testConstructorWithMessageAndCause() throws Exception {
        throw new FocusNFeException(msg, cause);
    }

    @Test(expectedExceptions = FocusNFeException.class)
    public void testConstructorWithMessageAndCauseAndMore() throws Exception {
        throw new FocusNFeException(msg, cause, true, true);
    }
}
