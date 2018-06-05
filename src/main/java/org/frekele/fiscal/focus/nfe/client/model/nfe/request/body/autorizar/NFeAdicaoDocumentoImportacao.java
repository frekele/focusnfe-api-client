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
public class NFeAdicaoDocumentoImportacao implements FocusNFeEntity {

    private static final long serialVersionUID = 1L;

    //Número da adição.
    @JsonProperty("numero")
    private String numero;

    //Número sequencial do item dentro da adição.
    @JsonProperty("numero_sequencial_item")
    private String numero_sequencial_item;

    //Código interno do fabricante estrangeiro.
    @JsonProperty("codigo_fabricante_estrangeiro")
    private String codigo_fabricante_estrangeiro;

    //Valor do desconto do item na adição.
    @JsonProperty("valor_desconto")
    private String valor_desconto;

    //Número do ato concessório de Drawback.
    @JsonProperty("numero_drawback")
    private String numero_drawback;

    public NFeAdicaoDocumentoImportacao() {
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
