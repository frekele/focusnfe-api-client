package org.frekele.fiscal.focus.nfe.client.model.nfe.request.body.autorizar;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.frekele.fiscal.focus.nfe.client.core.FocusNFeEntity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * @author frekele - Leandro Kersting de Freitas
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class NFeDocumentoImportacao implements FocusNFeEntity {

    private static final long serialVersionUID = 1L;

    //Número do documento de importação DI/DSA/DA.
    @JsonProperty("numero")
    private String numero;

    //Data de registro do documento de importação.
    @JsonProperty("data_registro")
    private String data_registro;

    //Local do desembaraço aduaneiro.
    @JsonProperty("local_desembaraco_aduaneiro")
    private String local_desembaraco_aduaneiro;

    //UF do desembaraço aduaneiro.
    @JsonProperty("uf_desembaraco_aduaneiro")
    private String uf_desembaraco_aduaneiro;

    //Data do desembaraço aduaneiro.
    @JsonProperty("data_desembaraco_aduaneiro")
    private String data_desembaraco_aduaneiro;

    //Via de transporte internacional informada na DI
    @JsonProperty("via_transporte")
    private String via_transporte;

    //Valor da AFRMM - Adicional ao Frete para Renovação da Marinha Mercante (obrigatório se marítimo)
    @JsonProperty("valor_afrmm")
    private String valor_afrmm;

    //Forma de importação quanto a intermediação
    @JsonProperty("forma_intermedio")
    private String forma_intermedio;

    //CNPJ do adquirente ou do encomendante.
    //Informação obrigatória no caso de importação por conta e ordem ou por encomenda
    @JsonProperty("cnpj")
    private String cnpj;

    //Sigla da UF do adquirente ou do encomendante.
    @JsonProperty("uf_terceiro")
    private String uf_terceiro;

    //Código interno do exportador.
    @JsonProperty("codigo_exportador")
    private String codigo_exportador;

    //Adições do documento de importação.
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
