package org.frekele.fiscal.focus.nfe.client.model.response.webhook.body;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import org.frekele.fiscal.focus.nfe.client.core.FocusNFeEntity;
import org.frekele.fiscal.focus.nfe.client.model.entities.erro.NFeErro;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Response Body WebHook.
 *
 * @author frekele - Leandro Kersting de Freitas
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class WebHookBodyResponse implements FocusNFeEntity {

    private static final long serialVersionUID = 1L;

    /**
     * As mensagens de erro serão apresentadas em qualquer operação sempre que for devolvido um código HTTP que começa com 4.
     */
    @JsonUnwrapped
    private NFeErro erro;

    /**
     * ID da criação do WebHook.
     */
    @JsonProperty("id")
    private String id;

    /**
     * URL de Callback do evento.
     */
    @JsonProperty("url")
    private String url;

    /**
     * Autorização.
     */
    @JsonProperty("authorization")
    private String authorization;

    /**
     * Evento que causam o acionamento do gatilho.
     */
    @JsonProperty("event")
    private String event;

    /**
     * Cnpj da Empresa.
     */
    @JsonProperty("cnpj")
    private String cnpj;

    /**
     * Se true o WebHook foi excluido.
     */
    @JsonProperty("deleted")
    private String deleted;

    public WebHookBodyResponse() {
        super();
    }

    /**
     * ID da criação do WebHook.
     */
    public String getId() {
        return id;
    }

    /**
     * ID da criação do WebHook.
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * URL de Callback do evento.
     */
    public String getUrl() {
        return url;
    }

    /**
     * URL de Callback do evento.
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * Autorização.
     */
    public String getAuthorization() {
        return authorization;
    }

    /**
     * Autorização.
     */
    public void setAuthorization(String authorization) {
        this.authorization = authorization;
    }

    /**
     * Evento que causam o acionamento do gatilho.
     */
    public String getEvent() {
        return event;
    }

    /**
     * Evento que causam o acionamento do gatilho.
     */
    public void setEvent(String event) {
        this.event = event;
    }

    /**
     * Cnpj da Empresa.
     */
    public String getCnpj() {
        return cnpj;
    }

    /**
     * Cnpj da Empresa.
     */
    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    /**
     * Se true o WebHook foi excluido.
     */
    public String getDeleted() {
        return deleted;
    }

    /**
     * Se true o WebHook foi excluido.
     */
    public void setDeleted(String deleted) {
        this.deleted = deleted;
    }
}
