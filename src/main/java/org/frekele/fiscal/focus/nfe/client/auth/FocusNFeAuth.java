package org.frekele.fiscal.focus.nfe.client.auth;

import org.frekele.fiscal.focus.nfe.client.util.FocusNFeUtils;

import java.io.Serializable;

/**
 * FocusNFe HTTP Authorization, A autenticação é feita através de um token.
 * Ao habilitar a API para sua empresa é fornecido uma string secreta e única que será usada para efetuar todas as operações.
 *
 * @author frekele - Leandro Kersting de Freitas
 */
public final class FocusNFeAuth implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * Token de Autenticação fornecido pela Acras FocusNFe.
     */
    private final String accessToken;

    /**
     * Ambiente que será conectado, homologacao ou producao.
     */
    private final EnvironmentFocusNFeEnum environment;

    /**
     * Authorization contém os valores (token + senha em branco) codificado em Base64.
     */
    private final String authorization;

    public FocusNFeAuth(String accessToken, EnvironmentFocusNFeEnum environment) {
        this.accessToken = accessToken;
        this.environment = environment;
        this.authorization = FocusNFeUtils.buildAuthorization(accessToken);
    }

    public FocusNFeAuth(String accessToken, String environment) {
        this.accessToken = accessToken;
        this.environment = EnvironmentFocusNFeEnum.fromValue(environment);
        this.authorization = FocusNFeUtils.buildAuthorization(accessToken);
    }

    private FocusNFeAuth(Builder builder) {
        accessToken = builder.accessToken;
        environment = builder.environment;
        authorization = FocusNFeUtils.buildAuthorization(builder.accessToken);
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    /**
     * Token de Autenticação fornecido pela Acras FocusNFe.
     */
    public String getAccessToken() {
        return accessToken;
    }

    /**
     * Ambiente que será conectado, homologacao ou producao.
     */
    public EnvironmentFocusNFeEnum getEnvironment() {
        return environment;
    }

    /**
     * Authorization contém os valores (token + senha em branco) codificado em Base64.
     */
    public String getAuthorization() {
        return authorization;
    }

    /**
     * Authorization contém os valores Basic + (token + senha em branco) codificado em Base64.
     */
    public String getBasicAuthorization() {
        return "Basic " + authorization;
    }

    /**
     * FocusNFeAuth Builder Pattern.
     */
    public static final class Builder {

        private String accessToken;

        private EnvironmentFocusNFeEnum environment;

        private Builder() {
        }

        /**
         * Token de Autenticação fornecido pela Acras FocusNFe.
         */
        public Builder withAccessToken(String val) {
            accessToken = val;
            return this;
        }

        /**
         * Ambiente que será conectado, homologacao ou producao.
         */
        public Builder withEnvironment(EnvironmentFocusNFeEnum val) {
            environment = val;
            return this;
        }

        /**
         * Ambiente que será conectado, homologacao ou producao.
         */
        public Builder withEnvironment(String val) {
            return withEnvironment(EnvironmentFocusNFeEnum.fromValue(val));
        }

        public FocusNFeAuth build() {
            return new FocusNFeAuth(this);
        }
    }
}
