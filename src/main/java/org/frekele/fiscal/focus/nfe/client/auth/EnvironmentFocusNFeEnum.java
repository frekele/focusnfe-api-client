package org.frekele.fiscal.focus.nfe.client.auth;

import java.util.Arrays;
import java.util.List;

/**
 * @author frekele - Leandro Kersting de Freitas
 */
public enum EnvironmentFocusNFeEnum {

    PRODUCTION("PRODUCTION", "https://api.focusnfe.com.br"),
    HOMOLOGATION("HOMOLOGATION", "http://homologacao.acrasnfe.acras.com.br");

    private String value;

    private String targetUrl;

    EnvironmentFocusNFeEnum(String value, String targetUrl) {
        this.value = value;
        this.targetUrl = targetUrl;
    }

    public String getTargetUrl() {
        return targetUrl;
    }

    public String getValue() {
        return value;
    }

    public static EnvironmentFocusNFeEnum fromValue(String value) {
        if (value != null && value.length() != 0) {
            for (EnvironmentFocusNFeEnum obj : getAll()) {
                if (obj.getValue().equals(value)) {
                    return obj;
                }
            }
        }
        return null;
    }

    public static List<EnvironmentFocusNFeEnum> getAll() {
        return Arrays.asList(EnvironmentFocusNFeEnum.values());
    }

}
