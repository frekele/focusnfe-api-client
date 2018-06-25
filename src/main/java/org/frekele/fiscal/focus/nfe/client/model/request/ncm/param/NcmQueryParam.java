package org.frekele.fiscal.focus.nfe.client.model.request.ncm.param;

import org.frekele.fiscal.focus.nfe.client.core.FocusNFeEntity;

/**
 * QueryParam para Consulta de NCMs.
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
 *
 * @author frekele - Leandro Kersting de Freitas
 */

public class NcmQueryParam implements FocusNFeEntity {

    private static final long serialVersionUID = 1L;

    /**
     * Pesquise pela parte inicial do código NCM.
     */
    private String codigo;

    /**
     * Pesquisa por parte da descrição do código NCM.
     */
    private String descricao;

    /**
     * CC = Capitulo.
     */
    private String capitulo;

    /**
     * PP = Posição.
     */
    private String posicao;

    /**
     * S = Subposição 1.
     */
    private String subposicao1;

    /**
     * Ç = Subposição 2.
     */
    private String subposicao2;

    /**
     * II = Item  1.
     */
    private String item1;

    /**
     * II = Item  2.
     */
    private String item2;

    /**
     * A API devolve apenas 50 registros por vez, para buscar os demais registros, utilize o parâmetro offset.
     */
    private String offset;

    public NcmQueryParam() {
        super();
    }

    private NcmQueryParam(Builder builder) {
        setCodigo(builder.codigo);
        setDescricao(builder.descricao);
        setCapitulo(builder.capitulo);
        setPosicao(builder.posicao);
        setSubposicao1(builder.subposicao1);
        setSubposicao2(builder.subposicao2);
        setItem1(builder.item1);
        setItem2(builder.item2);
        setOffset(builder.offset);
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    /**
     * Pesquise pela parte inicial do código NCM.
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * Pesquise pela parte inicial do código NCM.
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    /**
     * Pesquisa por parte da descrição do código NCM.
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * Pesquisa por parte da descrição do código NCM.
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCapitulo() {
        return capitulo;
    }

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

    /**
     * A API devolve apenas 50 registros por vez, para buscar os demais registros, utilize o parâmetro offset.
     */
    public String getOffset() {
        return offset;
    }

    /**
     * A API devolve apenas 50 registros por vez, para buscar os demais registros, utilize o parâmetro offset.
     */
    public void setOffset(String offset) {
        this.offset = offset;
    }

    /**
     * NcmQueryParam Builder Pattern.
     */
    public static final class Builder {

        private String codigo;

        private String descricao;

        private String capitulo;

        private String posicao;

        private String subposicao1;

        private String subposicao2;

        private String item1;

        private String item2;

        private String offset;

        private Builder() {
        }

        /**
         * Pesquise pela parte inicial do código NCM.
         */
        public Builder withCodigo(String val) {
            codigo = val;
            return this;
        }

        /**
         * Pesquisa por parte da descrição do código NCM.
         */
        public Builder withDescricao(String val) {
            descricao = val;
            return this;
        }

        /**
         * PP = Posição.
         */
        public Builder withCapitulo(String val) {
            capitulo = val;
            return this;
        }

        /**
         * PP = Posição.
         */
        public Builder withPosicao(String val) {
            posicao = val;
            return this;
        }

        /**
         * S = Subposição 1.
         */
        public Builder withSubposicao1(String val) {
            subposicao1 = val;
            return this;
        }

        /**
         * Ç = Subposição 2.
         */
        public Builder withSubposicao2(String val) {
            subposicao2 = val;
            return this;
        }

        /**
         * II = Item  1.
         */
        public Builder withItem1(String val) {
            item1 = val;
            return this;
        }

        /**
         * II = Item  2.
         */
        public Builder withItem2(String val) {
            item2 = val;
            return this;
        }

        /**
         * A API devolve apenas 50 registros por vez, para buscar os demais registros, utilize o parâmetro offset.
         */
        public Builder withOffset(String val) {
            offset = val;
            return this;
        }

        public NcmQueryParam build() {
            return new NcmQueryParam(this);
        }
    }
}
