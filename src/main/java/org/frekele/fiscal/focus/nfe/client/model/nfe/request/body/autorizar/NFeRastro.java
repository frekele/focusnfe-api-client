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
public class NFeRastro implements FocusNFeEntity {

    private static final long serialVersionUID = 1L;

    //Número do lote do produto
    @JsonProperty("numero_lote")
    private String numero_lote;

    //Quantidade de produtos no Lote.
    @JsonProperty("quantidade_lote")
    private String quantidade_lote;

    //Data de Fabricaçao do medicamento
    @JsonProperty("data_fabricacao")
    private String data_fabricacao;

    //Data de Validade do medicamento
    @JsonProperty("data_validade")
    private String data_validade;

    //Código de agregação
    @JsonProperty("codigo_agregacao")
    private String codigo_agregacao;

    public NFeRastro() {
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
