package org.frekele.fiscal.focus.nfe.client.auth;

import java.io.Serializable;

/**
 * @author frekele - Leandro Kersting de Freitas
 */
public final class FocusNFeAuth implements Serializable {

    private static final long serialVersionUID = 1L;

    private final String accessToken;

    private final EnvironmentFocusNFeEnum environment;

    public FocusNFeAuth(String accessToken, EnvironmentFocusNFeEnum environment) {
        this.accessToken = accessToken;
        this.environment = environment;
    }

    public FocusNFeAuth(String accessToken, String environment) {
        this.accessToken = accessToken;
        this.environment = EnvironmentFocusNFeEnum.fromValue(environment);
    }

    private FocusNFeAuth(Builder builder) {
        accessToken = builder.accessToken;
        environment = builder.environment;
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
