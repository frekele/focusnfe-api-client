package org.frekele.fiscal.focus.nfe.client.model.entities.protocolo.notafiscal;

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
public class NFeProtocoloNotaFiscal implements FocusNFeEntity {

    private static final long serialVersionUID = 1L;

    @JsonProperty("versao")
    private String versao;

    @JsonProperty("ambiente")
    private String ambiente;

    @JsonProperty("versao_aplicativo")
    private String versaoAplicativo;

    @JsonProperty("chave_nfe")
    private String chaveNfe;

    //Formato padrão ISO, exemplo: “2016-12-25T12:00-0300”.
    @OffsetDateTimeJsonConverter
    @JsonProperty("data_recebimento")
    private OffsetDateTime dataRecebimento;

    @JsonProperty("numero_protocolo")
    private String numeroProtocolo;

    @JsonProperty("digest_value")
    private String digestValue;

    @JsonProperty("status")
    private String status;

    @JsonProperty("motivo")
    private String motivo;

    public NFeProtocoloNotaFiscal() {
        super();
    }
}
