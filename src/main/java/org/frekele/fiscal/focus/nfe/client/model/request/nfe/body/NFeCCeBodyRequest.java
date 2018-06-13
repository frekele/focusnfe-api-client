package org.frekele.fiscal.focus.nfe.client.model.request.nfe.body;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.frekele.fiscal.focus.nfe.client.converter.LocalDateJsonConverter;
import org.frekele.fiscal.focus.nfe.client.core.FocusNFeEntity;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.time.LocalDate;

/**
 * @author frekele - Leandro Kersting de Freitas
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class NFeCCeBodyRequest implements FocusNFeEntity {

    private static final long serialVersionUID = 1L;

    //Texto da carta de correção. Deverá conter de 15 a 255 caracteres.
    @NotNull
    @Size(min = 15, max = 255)
    @JsonProperty("correcao")
    private String correcao;

    //Campo opcional. Data do evento da carta de correção. Se não informado será usado a data atual.
    @LocalDateJsonConverter
    @JsonProperty("data_evento")
    private LocalDate dataEvento;

    public NFeCCeBodyRequest() {
        super();
    }

    public NFeCCeBodyRequest(String correcao) {
        this.correcao = correcao;
    }

    public NFeCCeBodyRequest(String correcao, LocalDate dataEvento) {
        this.correcao = correcao;
        this.dataEvento = dataEvento;
    }

    private NFeCCeBodyRequest(Builder builder) {
        setCorrecao(builder.correcao);
        setDataEvento(builder.dataEvento);
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public String getCorrecao() {
        return correcao;
    }

    public void setCorrecao(String correcao) {
        this.correcao = correcao;
    }

    public LocalDate getDataEvento() {
        return dataEvento;
    }

    public void setDataEvento(LocalDate dataEvento) {
        this.dataEvento = dataEvento;
    }

    public static final class Builder {

        private String correcao;

        private LocalDate dataEvento;

        private Builder() {
        }

        public Builder withCorrecao(String val) {
            correcao = val;
            return this;
        }

        public Builder withDataEvento(LocalDate val) {
            dataEvento = val;
            return this;
        }

        public NFeCCeBodyRequest build() {
            return new NFeCCeBodyRequest(this);
        }
    }
}
