package org.frekele.fiscal.focus.nfe.client.model.response.nfe.body;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import org.frekele.fiscal.focus.nfe.client.core.FocusNFeEntity;
import org.frekele.fiscal.focus.nfe.client.model.entities.erro.NFeErro;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author frekele - Leandro Kersting de Freitas
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class NFeAutorizarBodyResponse implements FocusNFeEntity {

    private static final long serialVersionUID = 1L;

    /**
     * As mensagens de erro serão apresentadas em qualquer operação sempre que for devolvido um código HTTP que começa com 4.
     */
    @JsonUnwrapped
    private NFeErro erro;

    /**
     * A situação da NFe, podendo ser: processando_autorizacao, autorizado, cancelado, erro_autorizacao ou denegado.
     */
    @JsonProperty("status")
    private String status;

    /**
     * A referência da emissão.
     */
    @JsonProperty("ref")
    private String referencia;

    /**
     * O CNPJ do emitente da nota fiscal.
     */
    @JsonProperty("cnpj_emitente")
    private String cnpjEmitente;

    public NFeAutorizarBodyResponse() {
        super();
    }

    /**
     * As mensagens de erro serão apresentadas em qualquer operação sempre que for devolvido um código HTTP que começa com 4.
     */
    public NFeErro getErro() {
        return erro;
    }

    /**
     * As mensagens de erro serão apresentadas em qualquer operação sempre que for devolvido um código HTTP que começa com 4.
     */
    public void setErro(NFeErro erro) {
        this.erro = erro;
    }

    /**
     * A situação da NFe, podendo ser: processando_autorizacao, autorizado, cancelado, erro_autorizacao ou denegado.
     */
    public String getStatus() {
        return status;
    }

    /**
     * A situação da NFe, podendo ser: processando_autorizacao, autorizado, cancelado, erro_autorizacao ou denegado.
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * A referência da emissão.
     */
    public String getReferencia() {
        return referencia;
    }

    /**
     * A referência da emissão.
     */
    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    /**
     * O CNPJ do emitente da nota fiscal.
     */
    public String getCnpjEmitente() {
        return cnpjEmitente;
    }

    /**
     * O CNPJ do emitente da nota fiscal.
     */
    public void setCnpjEmitente(String cnpjEmitente) {
        this.cnpjEmitente = cnpjEmitente;
    }
}
