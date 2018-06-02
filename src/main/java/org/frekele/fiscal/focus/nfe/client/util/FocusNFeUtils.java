package org.frekele.fiscal.focus.nfe.client.util;

import org.apache.commons.io.IOUtils;
import org.frekele.fiscal.focus.nfe.client.auth.FocusNFeAuth;
import org.frekele.fiscal.focus.nfe.client.exception.FocusNFeException;

import javax.ws.rs.client.ClientResponseContext;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

/**
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

    public static String responseBodyToString(ClientResponseContext responseContext) throws IOException {
        String body = null;
        if (responseContext.hasEntity()) {
            try (InputStream entityStream = responseContext.getEntityStream()) {
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
                body = IOUtils.toString(entityStream, charset);
                //Original EntityStream is closed, add InputStream again for Security.
                responseContext.setEntityStream(IOUtils.toInputStream(body, charset));
            }
        }
        return body;
    }
}
