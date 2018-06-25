package org.frekele.fiscal.focus.nfe.client.model.entities.erro;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.frekele.fiscal.focus.nfe.client.core.FocusNFeEntity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * As mensagens de erro serão apresentadas em qualquer operação sempre que for devolvido um código HTTP que começa com 4.
 * Abaixo listamos os códigos de erro mais comuns.
 * <ul>
 * <li> 400	requisicao_invalida	Faltou informar algum campo na requisição. Este campo é informando na mensagem do erro;
 * <li> 400	empresa_nao_habilitada	Empresa ainda não habilitada para emitir o documento que você precisa. Habilite no seu painel ou contate o suporte técnico;
 * <li> 400	nfe_cancelada	Foi feita uma tentativa de cancelar uma nota já cancelada;
 * <li> 403	permissao_negada	Sua aplicação por algum motivo se encontra bloqueada para uso. Contate o nosso suporte;
 * <li> 404	nao_encontrado	Ocorre quando o recurso que você está procurando (NFe, NFCe ou NFSe) não é encontrado;
 * <li> 422	nfe_nao_autorizada	Foi feita alguma operação com a nota que só é aplicável se ela estiver autorizada (por exemplo a ação de cancelamento);
 * <li> 422	nfe_autorizada	Foi solicitado o processamento de uma nota já autorizada;
 * <li> 422	em_processamento	Foi solicitado o processamento de uma nota que já está em processamento.
 * <ul>
 *
 * @author frekele - Leandro Kersting de Freitas
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class NFeErro implements FocusNFeEntity {

    private static final long serialVersionUID = 1L;

    /**
     * O código da mensagem.
     */
    @JsonProperty("codigo")
    private String codigo;

    /**
     * A descrição mais detalhada do que ocorreu.
     */
    @JsonProperty("mensagem")
    private String mensagem;

    /**
     * (Opcional) Quando for possível detalhar o erro, ele será informado nesta lista de objetos.
     */
    @JsonProperty("erros")
    private List<NFeErro> erros;

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

    /**
     * O código da mensagem.
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * O código da mensagem.
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    /**
     * A descrição mais detalhada do que ocorreu.
     */
    public String getMensagem() {
        return mensagem;
    }

    /**
     * A descrição mais detalhada do que ocorreu.
     */
    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    /**
     * (Opcional) Quando for possível detalhar o erro, ele será informado nesta lista de objetos.
     */
    public List<NFeErro> getErros() {
        return erros;
    }

    /**
     * (Opcional) Quando for possível detalhar o erro, ele será informado nesta lista de objetos.
     */
    public void setErros(List<NFeErro> erros) {
        this.erros = erros;
    }

    /**
     * NFeErro Builder Pattern.
     */
    public static final class Builder {

        /**
         * O código da mensagem.
         */
        private String codigo;

        /**
         * A descrição mais detalhada do que ocorreu.
         */
        private String mensagem;

        /**
         * (Opcional) Quando for possível detalhar o erro, ele será informado nesta lista de objetos.
         */
        private List<NFeErro> erros;

        private Builder() {
        }

        /**
         * O código da mensagem.
         */
        public Builder withCodigo(String val) {
            codigo = val;
            return this;
        }

        /**
         * A descrição mais detalhada do que ocorreu.
         */
        public Builder withMensagem(String val) {
            mensagem = val;
            return this;
        }

        /**
         * (Opcional) Quando for possível detalhar o erro, ele será informado nesta lista de objetos.
         */
        public Builder withErros(List<NFeErro> val) {
            erros = val;
            return this;
        }

        public NFeErro build() {
            return new NFeErro(this);
        }
    }
}
