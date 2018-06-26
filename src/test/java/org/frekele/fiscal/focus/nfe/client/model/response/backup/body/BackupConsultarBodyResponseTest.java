package org.frekele.fiscal.focus.nfe.client.model.response.backup.body;

import org.frekele.fiscal.focus.nfe.client.model.entities.backup.NFeBackup;
import org.frekele.fiscal.focus.nfe.client.model.entities.erro.NFeErro;
import org.frekele.fiscal.focus.nfe.client.testng.InvokedMethodListener;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;

/**
 * @author frekele - Leandro Kersting de Freitas
 */
@Listeners(InvokedMethodListener.class)
public class BackupConsultarBodyResponseTest {

    @Test
    public void testNewInstance() throws Exception {
        NFeErro erro = new NFeErro();
        List<NFeBackup> backups = new ArrayList<>();
        backups.add(new NFeBackup());

        BackupConsultarBodyResponse entity = new BackupConsultarBodyResponse();
        entity.setErro(erro);
        entity.setBackups(backups);

        assertNotNull(entity);
        assertEquals(erro, entity.getErro());
        assertEquals(backups, entity.getBackups());
    }
}
