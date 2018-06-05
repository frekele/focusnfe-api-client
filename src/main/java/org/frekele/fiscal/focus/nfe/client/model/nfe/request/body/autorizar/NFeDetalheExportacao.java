package org.frekele.fiscal.focus.nfe.client.model.nfe.request.body.autorizar;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.frekele.fiscal.focus.nfe.client.core.FocusNFeEntity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author frekele - Leandro Kersting de Freitas
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class NFeDetalheExportacao implements FocusNFeEntity {

    private static final long serialVersionUID = 1L;

    //Número do ato concessório de Drawback
    @JsonProperty("numero_drawback")
    private String numero_drawback;

    //Número do Registro de Exportação
    @JsonProperty("numero_re")
    private String numero_re;

    //Chave de Acesso da NF-e recebida para exportação
    @JsonProperty("chave_nfe")
    private String chave_nfe;

    //Quantidade do item efetivamente exportado
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
