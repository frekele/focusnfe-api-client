package org.frekele.fiscal.focus.nfe.client.model.nfe.request.body.requisicao;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.frekele.fiscal.focus.nfe.client.converter.LocalDateJsonConverter;
import org.frekele.fiscal.focus.nfe.client.core.FocusNFeEntity;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.time.LocalDate;

/**
 * @author frekele - Leandro Kersting de Freitas
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class NFeRastro implements FocusNFeEntity {

    private static final long serialVersionUID = 1L;

    //Número do lote do produto
    @Size(min = 1, max = 20)
    @JsonProperty("numero_lote")
    private String numero_lote;

    //Quantidade de produtos no Lote.
    @Digits(integer = 8, fraction = 3)
    @JsonProperty("quantidade_lote")
    private String quantidade_lote;

    //Data de Fabricaçao do medicamento
    @LocalDateJsonConverter
    @JsonProperty("data_fabricacao")
    private LocalDate data_fabricacao;

    //Data de Validade do medicamento
    @LocalDateJsonConverter
    @JsonProperty("data_validade")
    private LocalDate data_validade;

    //Código de agregação
    @Size(min = 1, max = 20)
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
