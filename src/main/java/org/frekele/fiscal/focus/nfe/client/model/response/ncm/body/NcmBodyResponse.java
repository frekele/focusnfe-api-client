package org.frekele.fiscal.focus.nfe.client.model.response.ncm.body;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import org.frekele.fiscal.focus.nfe.client.core.FocusNFeEntity;
import org.frekele.fiscal.focus.nfe.client.model.entities.erro.NFeErro;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Response Body NCM.
 *
 * @author frekele - Leandro Kersting de Freitas
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class NcmBodyResponse implements FocusNFeEntity {

    private static final long serialVersionUID = 1L;

    /**
     * As mensagens de erro serão apresentadas em qualquer operação sempre que for devolvido um código HTTP que começa com 4.
     */
    @JsonUnwrapped
    private NFeErro erro;

    /**
     * Código do NCM.
     */
    @JsonProperty("codigo")
    private String codigo;

    /**
     * Descrição completa do código NCM.
     */
    @JsonProperty("descricao_completa")
    private String descricaoCompleta;

    /**
     * CC = Capitulo.
     */
    @JsonProperty("capitulo")
    private String capitulo;

    /**
     * PP = Posição.
     */
    @JsonProperty("posicao")
    private String posicao;

    /**
     * S = Subposição 1.
     */
    @JsonProperty("subposicao1")
    private String subposicao1;

    /**
     * Ç = Subposição 2.
     */
    @JsonProperty("subposicao2")
    private String subposicao2;

    /**
     * II = Item  1.
     */
    @JsonProperty("item1")
    private String item1;

    /**
     * II = Item  2.
     */
    @JsonProperty("item2")
    private String item2;

    public NcmBodyResponse() {
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
     * Código do NCM.
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * Código do NCM.
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    /**
     * Descrição completa do código NCM.
     */
    public String getDescricaoCompleta() {
        return descricaoCompleta;
    }

    /**
     * Descrição completa do código NCM.
     */
    public void setDescricaoCompleta(String descricaoCompleta) {
        this.descricaoCompleta = descricaoCompleta;
    }

    /**
     * CC = Capitulo.
     */
    public String getCapitulo() {
        return capitulo;
    }

    /**
     * CC = Capitulo.
     */
    public void setCapitulo(String capitulo) {
        this.capitulo = capitulo;
    }

    /**
     * PP = Posição.
     */
    public String getPosicao() {
        return posicao;
    }

    /**
     * PP = Posição.
     */
    public void setPosicao(String posicao) {
        this.posicao = posicao;
    }

    /**
     * S = Subposição 1.
     */
    public String getSubposicao1() {
        return subposicao1;
    }

    /**
     * S = Subposição 1.
     */
    public void setSubposicao1(String subposicao1) {
        this.subposicao1 = subposicao1;
    }

    /**
     * Ç = Subposição 2.
     */
    public String getSubposicao2() {
        return subposicao2;
    }

    /**
     * Ç = Subposição 2.
     */
    public void setSubposicao2(String subposicao2) {
        this.subposicao2 = subposicao2;
    }

    /**
     * II = Item  1.
     */
    public String getItem1() {
        return item1;
    }

    /**
     * II = Item  1.
     */
    public void setItem1(String item1) {
        this.item1 = item1;
    }

    /**
     * II = Item  2.
     */
    public String getItem2() {
        return item2;
    }

    /**
     * II = Item  2.
     */
    public void setItem2(String item2) {
        this.item2 = item2;
    }
}
