package org.frekele.fiscal.focus.nfe.client.model.nfe.request.body.requisicao;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.frekele.fiscal.focus.nfe.client.core.FocusNFeEntity;
import org.frekele.fiscal.focus.nfe.client.enumeration.NFeModeloEcfEnum;
import org.frekele.fiscal.focus.nfe.client.enumeration.NFeUnidadeFederativaEnum;

import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author frekele - Leandro Kersting de Freitas
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class NFeNotaReferenciada implements FocusNFeEntity {

    private static final long serialVersionUID = 1L;

    //Chave de acesso da nota referenciada.
    @Size(max = 44)
    @JsonProperty("chave_nfe")
    private String chaveNfe;

    //UF do emitente (nota modelo 1).
    @JsonProperty("uf")
    private NFeUnidadeFederativaEnum uf;

    //Ano e mês de emissão no formato AAMM (nota modelo 1).
    @Size(max = 4)
    @JsonProperty("mes")
    private String mes;

    //CNPJ do emitente (nota modelo 1).
    @Size(max = 14)
    @JsonProperty("cnpj")
    private String cnpj;

    //Código do modelo (nota modelo 1). Utilizar 01 para modelo 1/1A ou 02 para modelo 2.
    @Size(max = 2)
    @JsonProperty("modelo")
    private String modelo;

    //Série (nota modelo 1). Informar 0 se não existir.
    @Size(min = 1, max = 3)
    @JsonProperty("serie")
    private String serie;

    //Número (nota modelo 1).
    @Size(min = 1, max = 9)
    @JsonProperty("numero")
    private String numero;

    //UF do emitente (nota produtor rural).
    @JsonProperty("uf_nf_produtor")
    private NFeUnidadeFederativaEnum ufNfProdutor;

    //Ano e mês de emissão no formato AAMM (nota produtor rural).
    @Size(max = 4)
    @JsonProperty("mes_nf_produtor")
    private String mesNfProdutor;

    //CNPJ do emitente (nota produtor rural).
    @Size(max = 14)
    @JsonProperty("cnpj_nf_produtor")
    private String cnpjNfProdutor;

    //CPF do emitente (nota produtor rural).
    @Size(max = 11)
    @JsonProperty("cpf_nf_produtor")
    private String cpfNfProdutor;

    //Inscrição estadual do emitente (nota produtor rural).
    @Size(min = 2, max = 14)
    @JsonProperty("inscricao_estadual_nf_produtor")
    private String inscricaoEstadualNfProdutor;

    //Código do modelo (nota produtor rural). Utilizar 04 para NF de produtor ou 01 para NF modelo 1.
    @Size(max = 2)
    @JsonProperty("modelo_nf_produtor")
    private String modeloNfProdutor;

    //Série (nota produtor rural). Informar 0 se não existir.
    @Size(min = 1, max = 3)
    @JsonProperty("serie_nf_produtor")
    private String serieNfProdutor;

    //Número (nota produtor rural).
    @Size(min = 1, max = 9)
    @JsonProperty("numero_nf_produtor")
    private String numeroNfProdutor;

    //Chave de acesso da CTe referenciada.
    @Size(max = 44)
    @JsonProperty("chave_cte")
    private String chaveCte;

    //Modelo do Documento Fiscal (cupom fiscal).
    @JsonProperty("modelo_ecf")
    private NFeModeloEcfEnum modeloEcf;

    //Número de ordem sequencial do ECF (cupom fiscal).
    @Size(max = 3)
    @JsonProperty("numero_ecf")
    private String numeroEcf;

    //Número do Contador de Ordem de Operação - COO (cupom fiscal).
    @Size(max = 6)
    @JsonProperty("coo")
    private String coo;

    public NFeNotaReferenciada() {
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
