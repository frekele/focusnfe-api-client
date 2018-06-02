package org.frekele.fiscal.focus.nfe.client.converter.deserialize;

import com.fasterxml.jackson.core.JsonParser;
import org.frekele.fiscal.focus.nfe.client.testng.InvokedMethodListener;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.math.BigDecimal;

import static org.mockito.Mockito.*;
import static org.testng.Assert.*;

/**
 * @author frekele - Leandro Kersting de Freitas
 */
@Listeners(InvokedMethodListener.class)
public class BigDecimalJsonDeserializeTest {

    @Mock
    private JsonParser jsonParser;

    @BeforeClass
    public void beforeClass() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testDeserialize() throws Exception {
        BigDecimalJsonDeserialize jsonDeserialize = new BigDecimalJsonDeserialize();
        assertNotNull(jsonDeserialize);

        BigDecimal resultValue = jsonDeserialize.deserialize(null, null);
        assertNull(resultValue);

        when(jsonParser.readValueAs(Long.class)).thenReturn(null);
        resultValue = jsonDeserialize.deserialize(jsonParser, null);
        assertNull(resultValue);

        long longValue = 5432;
        when(jsonParser.readValueAs(Long.class)).thenReturn(longValue);
        resultValue = jsonDeserialize.deserialize(jsonParser, null);
        assertNotNull(resultValue);
        assertEquals(BigDecimal.valueOf(longValue, 2), resultValue);
    }
}
