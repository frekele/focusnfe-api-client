package org.frekele.fiscal.focus.nfe.client.model.nfe.request.body.autorizar;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.frekele.fiscal.focus.nfe.client.core.FocusNFeEntity;
import org.frekele.fiscal.focus.nfe.client.enumeration.NFeIcmsOrigemEnum;
import org.frekele.fiscal.focus.nfe.client.enumeration.NFeIcmsSituacaoTributariaEnum;
import org.frekele.fiscal.focus.nfe.client.enumeration.NFeIncluiNoTotalEnum;
import org.frekele.fiscal.focus.nfe.client.enumeration.NFePisCofinsSituacaoTributariaEnum;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author frekele - Leandro Kersting de Freitas
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class NFeItem implements FocusNFeEntity {

    private static final long serialVersionUID = 1L;

    @JsonProperty("xxx")
    private String xxx;

    //Numeração que indica qual a posição do item na nota, deve ser usado numeração sequencial a partir do número “1”.
    @JsonProperty("numero_item")
    private String numeroItem;

    //Código do produto.
    @JsonProperty("codigo_produto")
    private String codigoProduto;

    //Descrição do produto.
    @JsonProperty("descricao")
    private String descricao;

    //Código Fiscal da Operação, CFOP da operação válido para NFe.
    @JsonProperty("cfop")
    private String cfop;

    //Quantidade da mercadoria.
    @JsonProperty("quantidade_comercial")
    private String quantidadeComercial;

    //Quantidade tributavel da mercadoria. Caso não se aplique, utilize o mesmo valor do campo quantidade_comercial.
    @JsonProperty("quantidade_tributavel")
    private String quantidadeTributavel;

    // Valor unitário da mercadoria.
    @JsonProperty("valor_unitario_comercial")
    private String valorUnitarioComercial;

    //Valor unitário tributável da mercadoria. Caso não se aplique, utilize o mesmo valor do campo valor_unitario_comercial.
    @JsonProperty("valor_unitario_tributavel")
    private String valorUnitarioTributavel;

    //Unidade comercial do produto. Você pode utilizar valores como “KG”, “L”, “UN” entre outros. * Caso não se aplique, use “UN”.
    @JsonProperty("unidade_comercial")
    private String unidadeComercial;

    // Unidade tributável do produto. Caso não se aplique, utilize o mesmo valor do campo unidade_comercial.
    @JsonProperty("unidade_tributavel")
    private String unidadeTributavel;

    //Valor bruto do produto.
    @JsonProperty("valor_bruto")
    private String valorBruto;

    //Código NCM do produto. Este código possui 8 dígitos.
    @JsonProperty("codigo_ncm")
    private String codigoNcm;

    //Valor do item (valor_bruto) compõe valor total da NFe (valor_produtos)?.
    @JsonProperty("inclui_no_total")
    private NFeIncluiNoTotalEnum incluiNoTotal;

    //Informar a origem do ICMS.
    @JsonProperty("icms_origem")
    private NFeIcmsOrigemEnum icmsOrigem;

    //Informar qual a situação do ICMS para a operação.
    @JsonProperty("icms_situacao_tributaria")
    private NFeIcmsSituacaoTributariaEnum icmsSituacaoTributaria;

    //Informar qual a situação do PIS para a operação.
    @JsonProperty("pis_situacao_tributaria")
    private NFePisCofinsSituacaoTributariaEnum pisSituacaoTributaria;

    //Informar qual a situação do CONFINS para a operação.
    @JsonProperty("cofins_situacao_tributaria")
    private NFePisCofinsSituacaoTributariaEnum cofinsSituacaoTributaria;

    public NFeItem() {
        super();
    }

    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
}
