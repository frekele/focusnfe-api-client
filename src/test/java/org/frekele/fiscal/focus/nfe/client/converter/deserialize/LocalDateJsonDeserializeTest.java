package org.frekele.fiscal.focus.nfe.client.converter.deserialize;

import com.fasterxml.jackson.core.JsonParser;
import org.frekele.fiscal.focus.nfe.client.testng.InvokedMethodListener;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.mockito.Mockito.*;
import static org.testng.Assert.*;

/**
 * @author frekele - Leandro Kersting de Freitas
 */
@Listeners(InvokedMethodListener.class)
public class LocalDateJsonDeserializeTest {

    @Mock
    private JsonParser jsonParser;

    @BeforeClass
    public void beforeClass() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testDeserialize() throws Exception {
        LocalDateJsonDeserialize jsonDeserialize = new LocalDateJsonDeserialize();
        assertNotNull(jsonDeserialize);

        LocalDate resultValue = jsonDeserialize.deserialize(null, null);
        assertNull(resultValue);

        when(jsonParser.readValueAs(String.class)).thenReturn(null);
        resultValue = jsonDeserialize.deserialize(jsonParser, null);
        assertNull(resultValue);

        String stringValue = "2018-01-13T12:51:34Z";
        LocalDate expected = LocalDate.parse(stringValue, DateTimeFormatter.ISO_LOCAL_DATE);
        when(jsonParser.readValueAs(String.class)).thenReturn(stringValue);
        resultValue = jsonDeserialize.deserialize(jsonParser, null);
        assertNotNull(resultValue);
        assertEquals(expected, resultValue);
    }
}
