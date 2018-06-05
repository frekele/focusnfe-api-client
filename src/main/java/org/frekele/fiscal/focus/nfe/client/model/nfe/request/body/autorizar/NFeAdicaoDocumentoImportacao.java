package org.frekele.fiscal.focus.nfe.client.model.nfe.request.body.autorizar;

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
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class NFeAdicaoDocumentoImportacao implements FocusNFeEntity {

    private static final long serialVersionUID = 1L;

    //Número da adição.
    @Size(min = 1, max = 3)
    @JsonProperty("numero")
    private String numero;

    //Número sequencial do item dentro da adição.
    @Size(min = 1, max = 3)
    @JsonProperty("numero_sequencial_item")
    private String numero_sequencial_item;

    //Código interno do fabricante estrangeiro.
    @Size(min = 1, max = 60)
    @JsonProperty("codigo_fabricante_estrangeiro")
    private String codigo_fabricante_estrangeiro;

    //Valor do desconto do item na adição.
    @Digits(integer = 13, fraction = 2)
    @JsonProperty("valor_desconto")
    private String valor_desconto;

    //Número do ato concessório de Drawback.
    @Size(max = 11)
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
