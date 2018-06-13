package org.frekele.fiscal.focus.nfe.client.model.entities.requisicao.cartacorrecao;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.frekele.fiscal.focus.nfe.client.converter.OffsetDateTimeJsonConverter;
import org.frekele.fiscal.focus.nfe.client.core.FocusNFeEntity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.time.OffsetDateTime;

/**
 * @author frekele - Leandro Kersting de Freitas
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class NFeRequisicaoCartaCorrecao implements FocusNFeEntity {

    private static final long serialVersionUID = 1L;

    @JsonProperty("versao")
    private String versao;

    @JsonProperty("id_tag")
    private String id_tag;

    @JsonProperty("codigo_orgao")
    private String codigoOrgao;

    @JsonProperty("ambiente")
    private String ambiente;

    @JsonProperty("cnpj")
    private String cnpj;

    @JsonProperty("chave_nfe")
    private String chaveNfe;

    //Formato padrão ISO, exemplo: “2016-12-25T12:00-0300”.
    @OffsetDateTimeJsonConverter
    @JsonProperty("data_evento")
    private OffsetDateTime dataEvento;

    @JsonProperty("tipo_evento")
    private String tipoEvento;

    @JsonProperty("numero_sequencial_evento")
    private String numeroSequencialEvento;

    @JsonProperty("versao_evento")
    private String versaoEvento;

    @JsonProperty("descricao_evento")
    private String descricaoEvento;

    @JsonProperty("correcao")
    private String correcao;

    @JsonProperty("condicoes_uso")
    private String condicoesUso;

    public NFeRequisicaoCartaCorrecao() {
        super();
    }
}
