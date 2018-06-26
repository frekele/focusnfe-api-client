package org.frekele.fiscal.focus.nfe.client.model.response.ncm.body;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import org.frekele.fiscal.focus.nfe.client.core.FocusNFeEntity;
import org.frekele.fiscal.focus.nfe.client.model.entities.erro.NFeErro;
import org.frekele.fiscal.focus.nfe.client.model.entities.ncm.NFeNcm;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Response Body NCM.
 *
 * @author frekele - Leandro Kersting de Freitas
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class NcmBodyResponse implements FocusNFeEntity {

    private static final long serialVersionUID = 1L;

    /**
     * As mensagens de erro serão apresentadas em qualquer operação sempre que for devolvido um código HTTP que começa com 4.
     */
    @JsonUnwrapped
    private NFeErro erro;

    /**
     * NCM - "Nomenclatura Comum do Mercosul".
     */
    @JsonUnwrapped
    private NFeNcm ncm;

    public NcmBodyResponse() {
        super();
    }

    /**
     * As mensagens de erro serão apresentadas em qualquer operação sempre que for devolvido um código HTTP que começa com 4.
     */
    public NFeErro getErro() {
        return erro;
    }

    /**
     * As mensagens de erro serão apresentadas em qualquer operação sempre que for devolvido um código HTTP que começa com 4.
     */
    public void setErro(NFeErro erro) {
        this.erro = erro;
    }

    /**
     * NCM - "Nomenclatura Comum do Mercosul".
     */
    public NFeNcm getNcm() {
        return ncm;
    }

    /**
     * NCM - "Nomenclatura Comum do Mercosul".
     */
    public void setNcm(NFeNcm ncm) {
        this.ncm = ncm;
    }
}
