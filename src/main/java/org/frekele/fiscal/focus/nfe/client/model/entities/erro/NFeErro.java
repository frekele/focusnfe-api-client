package org.frekele.fiscal.focus.nfe.client.model.entities.erro;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.frekele.fiscal.focus.nfe.client.core.FocusNFeEntity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * @author frekele - Leandro Kersting de Freitas
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class NFeErro implements FocusNFeEntity {

    private static final long serialVersionUID = 1L;

    //codigo
    @JsonProperty("codigo")
    private String codigo;

    //mensagem
    @JsonProperty("mensagem")
    private String mensagem;

    //erros
    @JsonProperty("erros")
    private List<String> erros;

    public NFeErro() {
        super();
    }

    private NFeErro(Builder builder) {
        setCodigo(builder.codigo);
        setMensagem(builder.mensagem);
        setErros(builder.erros);
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public List<String> getErros() {
        return erros;
    }

    public void setErros(List<String> erros) {
        this.erros = erros;
    }

    public static final class Builder {

        private String codigo;

        private String mensagem;

        private List<String> erros;

        private Builder() {
        }

        public Builder withCodigo(String val) {
            codigo = val;
            return this;
        }

        public Builder withMensagem(String val) {
            mensagem = val;
            return this;
        }

        public Builder withErros(List<String> val) {
            erros = val;
            return this;
        }

        public NFeErro build() {
            return new NFeErro(this);
        }
    }
}
