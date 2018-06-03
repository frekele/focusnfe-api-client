package org.frekele.fiscal.focus.nfe.client.auth;

import org.frekele.fiscal.focus.nfe.client.util.FocusNFeUtils;

import java.io.Serializable;

/**
 * @author frekele - Leandro Kersting de Freitas
 */
public final class FocusNFeAuth implements Serializable {

    private static final long serialVersionUID = 1L;

    private final String accessToken;

    private final EnvironmentFocusNFeEnum environment;

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

    public String getAccessToken() {
        return accessToken;
    }

    public EnvironmentFocusNFeEnum getEnvironment() {
        return environment;
    }

    public String getAuthorization() {
        return authorization;
    }

    public static final class Builder {

        private String accessToken;

        private EnvironmentFocusNFeEnum environment;

        private Builder() {
        }

        public Builder withAccessToken(String val) {
            accessToken = val;
            return this;
        }

        public Builder withEnvironment(EnvironmentFocusNFeEnum val) {
            environment = val;
            return this;
        }

        public Builder withEnvironment(String val) {
            return withEnvironment(EnvironmentFocusNFeEnum.fromValue(val));
        }

        public FocusNFeAuth build() {
            return new FocusNFeAuth(this);
        }
    }
}
