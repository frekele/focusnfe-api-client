package org.frekele.fiscal.focus.nfe.client.model.request.webhook.body;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.frekele.fiscal.focus.nfe.client.core.FocusNFeEntity;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Request Body Criar WebHook.
 *
 * @author frekele - Leandro Kersting de Freitas
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class WebHookCriarBodyRequest implements FocusNFeEntity {

    private static final long serialVersionUID = 1L;

    /**
     * CNPJ da empresa.
     */
    @NotNull
    private String cnpj;

    /**
     * Informe qual evento que gostará de escutar: nfe, nfse ou nfe_recebida.
     */
    @NotNull
    private String event;

    /**
     * URL que deverá ser chamada quando o webhook for ativado.
     */
    @NotNull
    private String url;

    public WebHookCriarBodyRequest() {
        super();
    }

    public WebHookCriarBodyRequest(String cnpj, String event, String url) {
        this.cnpj = cnpj;
        this.event = event;
        this.url = url;
    }

    private WebHookCriarBodyRequest(Builder builder) {
        setCnpj(builder.cnpj);
        setEvent(builder.event);
        setUrl(builder.url);
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    /**
     * CNPJ da empresa.
     */
    public String getCnpj() {
        return cnpj;
    }

    /**
     * CNPJ da empresa.
     */
    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    /**
     * Informe qual evento que gostará de escutar: nfe, nfse ou nfe_recebida.
     */
    public String getEvent() {
        return event;
    }

    /**
     * Informe qual evento que gostará de escutar: nfe, nfse ou nfe_recebida.
     */
    public void setEvent(String event) {
        this.event = event;
    }

    /**
     * URL que deverá ser chamada quando o webhook for ativado.
     */
    public String getUrl() {
        return url;
    }

    /**
     * URL que deverá ser chamada quando o webhook for ativado.
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * WebHookCriarBodyRequest Builder Pattern.
     */
    public static final class Builder {

        private String cnpj;

        private String event;

        private String url;

        private Builder() {
        }

        /**
         * CNPJ da empresa.
         */
        public Builder withCnpj(String val) {
            cnpj = val;
            return this;
        }

        /**
         * Informe qual evento que gostará de escutar: nfe, nfse ou nfe_recebida.
         */
        public Builder withEvent(String val) {
            event = val;
            return this;
        }

        /**
         * URL que deverá ser chamada quando o webhook for ativado.
         */
        public Builder withUrl(String val) {
            url = val;
            return this;
        }

        public WebHookCriarBodyRequest build() {
            return new WebHookCriarBodyRequest(this);
        }
    }
}
