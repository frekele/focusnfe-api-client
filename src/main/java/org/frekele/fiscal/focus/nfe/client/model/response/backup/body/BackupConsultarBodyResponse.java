package org.frekele.fiscal.focus.nfe.client.model.response.backup.body;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import org.frekele.fiscal.focus.nfe.client.core.FocusNFeEntity;
import org.frekele.fiscal.focus.nfe.client.model.entities.backup.NFeBackup;
import org.frekele.fiscal.focus.nfe.client.model.entities.erro.NFeErro;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Response Body Backups.
 *
 * @author frekele - Leandro Kersting de Freitas
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class BackupConsultarBodyResponse implements FocusNFeEntity {

    private static final long serialVersionUID = 1L;

    /**
     * As mensagens de erro serão apresentadas em qualquer operação sempre que for devolvido um código HTTP que começa com 4.
     */
    @JsonUnwrapped
    private NFeErro erro;

    /**
     * Lista de backups.
     */
    @JsonProperty("arrayValues")
    private List<NFeBackup> backups;

    public BackupConsultarBodyResponse() {
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
     * Lista de backups.
     */
    public List<NFeBackup> getBackups() {
        return backups;
    }

    /**
     * Lista de backups.
     */
    public void setBackups(List<NFeBackup> backups) {
        this.backups = backups;
    }
}
