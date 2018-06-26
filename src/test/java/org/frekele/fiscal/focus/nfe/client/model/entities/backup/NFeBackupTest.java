package org.frekele.fiscal.focus.nfe.client.model.entities.backup;

import org.frekele.fiscal.focus.nfe.client.testng.InvokedMethodListener;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * @author frekele - Leandro Kersting de Freitas
 */
@Listeners(InvokedMethodListener.class)
public class NFeBackupTest {

    @Test
    public void testNewInstance() throws Exception {
        String mes = "201806";
        String danfes = "/backups-xxxxx/danfes.zip";
        String xmls = "/backups-xxxxx/xmls.zip";
        NFeBackup entity = new NFeBackup();
        entity.setMes(mes);
        entity.setDanfes(danfes);
        entity.setXmls(xmls);

        assertNotNull(entity);
        assertEquals(mes, entity.getMes());
        assertEquals(danfes, entity.getDanfes());
        assertEquals(xmls, entity.getXmls());

        entity = NFeBackup.newBuilder()
            .withMes(mes)
            .withDanfes(danfes)
            .withXmls(xmls)
            .build();

        assertNotNull(entity);
        assertEquals(mes, entity.getMes());
        assertEquals(danfes, entity.getDanfes());
        assertEquals(xmls, entity.getXmls());
    }
}
