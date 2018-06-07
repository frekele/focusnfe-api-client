package org.frekele.fiscal.focus.nfe.client.model.nfe.request.body.requisicao;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.frekele.fiscal.focus.nfe.client.core.FocusNFeEntity;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author frekele - Leandro Kersting de Freitas
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class NFeDetalheExportacao implements FocusNFeEntity {

    private static final long serialVersionUID = 1L;

    //Número do ato concessório de Drawback
    @Size(max = 11)
    @JsonProperty("numero_drawback")
    private String numero_drawback;

    //Número do Registro de Exportação
    @Size(max = 12)
    @JsonProperty("numero_re")
    private String numero_re;

    //Chave de Acesso da NF-e recebida para exportação
    @Size(max = 44)
    @JsonProperty("chave_nfe")
    private String chave_nfe;

    //Quantidade do item efetivamente exportado
    @Digits(integer = 11, fraction = 4)
    @JsonProperty("quantidade_exportado")
    private String quantidade_exportado;

    public NFeDetalheExportacao() {
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
