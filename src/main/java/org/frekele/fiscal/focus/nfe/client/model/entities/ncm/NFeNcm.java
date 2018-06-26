package org.frekele.fiscal.focus.nfe.client.model.entities.ncm;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.frekele.fiscal.focus.nfe.client.core.FocusNFeEntity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Classe Json de NCM.
 * O código NCM é formato por 8 dígitos no seguinte formato:
 * <p>
 * CCPPSÇII, sendo:
 * <ul>
 * <li>CC = Capitulo;
 * <li>PP = Posição;
 * <li>S = Subposição 1;
 * <li>Ç = Subposição 2;
 * <li>II = Item 1 e 2;
 * </ul>
 * São aceitos os seguintes parâmetros de pesquisa:
 * codigo: Pesquise pela parte inicial do código NCM
 * descricao: Pesquisa por parte da descrição do código NCM.
 * capitulo, posicao, subposicao1, subposicao2, item1 e item2: Pesquisa exata informando qualquer uma das partes do código NCM.
 * Para buscar os demais registros, utilize o parâmetro offset.
 *
 * @author frekele - Leandro Kersting de Freitas
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class NFeNcm implements FocusNFeEntity {

    private static final long serialVersionUID = 1L;

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

    public NFeNcm() {
        super();
    }

    private NFeNcm(Builder builder) {
        setCodigo(builder.codigo);
        setDescricaoCompleta(builder.descricaoCompleta);
        setCapitulo(builder.capitulo);
        setPosicao(builder.posicao);
        setSubposicao1(builder.subposicao1);
        setSubposicao2(builder.subposicao2);
        setItem1(builder.item1);
        setItem2(builder.item2);
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

    public String getDescricaoCompleta() {
        return descricaoCompleta;
    }

    public void setDescricaoCompleta(String descricaoCompleta) {
        this.descricaoCompleta = descricaoCompleta;
    }

    public String getCapitulo() {
        return capitulo;
    }

    public void setCapitulo(String capitulo) {
        this.capitulo = capitulo;
    }

    public String getPosicao() {
        return posicao;
    }

    public void setPosicao(String posicao) {
        this.posicao = posicao;
    }

    public String getSubposicao1() {
        return subposicao1;
    }

    public void setSubposicao1(String subposicao1) {
        this.subposicao1 = subposicao1;
    }

    public String getSubposicao2() {
        return subposicao2;
    }

    public void setSubposicao2(String subposicao2) {
        this.subposicao2 = subposicao2;
    }

    public String getItem1() {
        return item1;
    }

    public void setItem1(String item1) {
        this.item1 = item1;
    }

    public String getItem2() {
        return item2;
    }

    public void setItem2(String item2) {
        this.item2 = item2;
    }

    public static final class Builder {

        private String codigo;

        private String descricaoCompleta;

        private String capitulo;

        private String posicao;

        private String subposicao1;

        private String subposicao2;

        private String item1;

        private String item2;

        private Builder() {
        }

        public Builder withCodigo(String val) {
            codigo = val;
            return this;
        }

        public Builder withDescricaoCompleta(String val) {
            descricaoCompleta = val;
            return this;
        }

        public Builder withCapitulo(String val) {
            capitulo = val;
            return this;
        }

        public Builder withPosicao(String val) {
            posicao = val;
            return this;
        }

        public Builder withSubposicao1(String val) {
            subposicao1 = val;
            return this;
        }

        public Builder withSubposicao2(String val) {
            subposicao2 = val;
            return this;
        }

        public Builder withItem1(String val) {
            item1 = val;
            return this;
        }

        public Builder withItem2(String val) {
            item2 = val;
            return this;
        }

        public NFeNcm build() {
            return new NFeNcm(this);
        }
    }
}
