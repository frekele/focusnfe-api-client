package org.frekele.fiscal.focus.nfe.client.model.entities.protocolo.cancelamento;

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
public class NFeProtocoloCancelamento implements FocusNFeEntity {

    private static final long serialVersionUID = 1L;

    @JsonProperty("versao")
    private String versao;

    @JsonProperty("ambiente")
    private String ambiente;

    @JsonProperty("versao_aplicativo")
    private String versaoAplicativo;

    @JsonProperty("codigo_orgao")
    private String codigoOrgao;

    @JsonProperty("status")
    private String status;

    @JsonProperty("motivo")
    private String motivo;

    @JsonProperty("chave_nfe")
    private String chaveNfe;

    @JsonProperty("tipo_evento")
    private String tipoEvento;

    @JsonProperty("descricao_evento")
    private String descricaoEvento;

    //Formato padrão ISO, exemplo: “2016-12-25T12:00-0300”.
    @OffsetDateTimeJsonConverter
    @JsonProperty("data_evento")
    private OffsetDateTime dataEvento;

    @JsonProperty("numero_protocolo")
    private String numeroProtocolo;

    public NFeProtocoloCancelamento() {
        super();
    }
}
