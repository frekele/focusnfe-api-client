package org.frekele.fiscal.focus.nfe.client.exception;

import java.io.Serializable;

/**
 * @author frekele - Leandro Kersting de Freitas
 */
public class FocusNFeException extends RuntimeException implements Serializable {

    private static final long serialVersionUID = 1L;

    public FocusNFeException(String message) {
        super(message);
    }

    public FocusNFeException(Throwable cause) {
        super(cause);
    }

    public FocusNFeException(String message, Throwable cause) {
        super(message, cause);
    }

    public FocusNFeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
