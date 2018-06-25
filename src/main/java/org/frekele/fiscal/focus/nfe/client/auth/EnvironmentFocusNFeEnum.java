package org.frekele.fiscal.focus.nfe.client.auth;

import java.util.Arrays;
import java.util.List;

/**
 * A API do Focus NFe oferece dois ambientes para emissão de notas: homologação e produção.
 *
 * @author frekele - Leandro Kersting de Freitas
 */
public enum EnvironmentFocusNFeEnum {

    /**
     * Este é o ambiente com validade fiscal e tributária, pois isso, recomendamos que utilize este ambiente apenas quando for iniciar o processo de envio de notas válidas.
     * Produção: https://api.focusnfe.com.br (obrigatório o uso de SSL).
     */
    PRODUCTION("PRODUCTION", "https://api.focusnfe.com.br"),
    /**
     * O ambiente de homologação serve para envio de notas fiscais com a finalidade de teste. As notas emitidas aqui não possuem validade fiscal/tributária.
     * Homologação: http://homologacao.acrasnfe.acras.com.br (note que não é utilizado SSL).
     */
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
