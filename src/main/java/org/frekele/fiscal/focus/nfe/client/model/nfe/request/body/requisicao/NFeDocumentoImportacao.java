package org.frekele.fiscal.focus.nfe.client.model.nfe.request.body.requisicao;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.frekele.fiscal.focus.nfe.client.converter.LocalDateJsonConverter;
import org.frekele.fiscal.focus.nfe.client.core.FocusNFeEntity;
import org.frekele.fiscal.focus.nfe.client.enumeration.NFeFormaIntermedioEnum;
import org.frekele.fiscal.focus.nfe.client.enumeration.NFeUnidadeFederativaEnum;
import org.frekele.fiscal.focus.nfe.client.enumeration.NFeViaTransporteEnum;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.time.LocalDate;
import java.util.List;

/**
 * @author frekele - Leandro Kersting de Freitas
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class NFeDocumentoImportacao implements FocusNFeEntity {

    private static final long serialVersionUID = 1L;

    //Número do documento de importação DI/DSA/DA.
    @Size(min = 1, max = 12)
    @JsonProperty("numero")
    private String numero;

    //Data de registro do documento de importação.
    @LocalDateJsonConverter
    @JsonProperty("data_registro")
    private LocalDate dataRegistro;

    //Local do desembaraço aduaneiro.
    @Size(min = 1, max = 60)
    @JsonProperty("local_desembaraco_aduaneiro")
    private String localDesembaracoAduaneiro;

    //UF do desembaraço aduaneiro.
    @JsonProperty("uf_desembaraco_aduaneiro")
    private NFeUnidadeFederativaEnum ufDesembaracoAduaneiro;

    //Data do desembaraço aduaneiro.
    @LocalDateJsonConverter
    @JsonProperty("data_desembaraco_aduaneiro")
    private LocalDate dataDesembaracoAduaneiro;

    //Via de transporte internacional informada na DI
    @JsonProperty("via_transporte")
    private NFeViaTransporteEnum viaTransporte;

    //Valor da AFRMM - Adicional ao Frete para Renovação da Marinha Mercante (obrigatório se marítimo)
    @Digits(integer = 13, fraction = 2)
    @JsonProperty("valor_afrmm")
    private String valorAfrmm;

    //Forma de importação quanto a intermediação
    @JsonProperty("forma_intermedio")
    private NFeFormaIntermedioEnum formaIntermedio;

    //CNPJ do adquirente ou do encomendante.
    //Informação obrigatória no caso de importação por conta e ordem ou por encomenda
    @Size(max = 14)
    @JsonProperty("cnpj")
    private String cnpj;

    //Sigla da UF do adquirente ou do encomendante.
    @JsonProperty("uf_terceiro")
    private NFeUnidadeFederativaEnum ufTerceiro;

    //Código interno do exportador.
    @Size(min = 1, max = 60)
    @JsonProperty("codigo_exportador")
    private String codigoExportador;

    //Adições do documento de importação.
    @Size(min = 1, max = 100)
    @JsonProperty("adicoes")
    private List<NFeAdicaoDocumentoImportacao> adicoes;

    public NFeDocumentoImportacao() {
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
