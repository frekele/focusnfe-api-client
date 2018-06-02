package org.frekele.fiscal.focus.nfe.client.converter.serialize;

import com.fasterxml.jackson.core.JsonGenerator;
import org.frekele.fiscal.focus.nfe.client.testng.InvokedMethodListener;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.time.OffsetDateTime;

import static org.testng.Assert.*;

@Listeners(InvokedMethodListener.class)
public class OffsetDateTimeJsonSerializeTest {

    @Mock
    JsonGenerator jsonGenerator;

    @BeforeClass
    public void beforeClass() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testSerialize() throws Exception {
        OffsetDateTimeJsonSerialize jsonSerialize = new OffsetDateTimeJsonSerialize();
        assertNotNull(jsonSerialize);

        jsonSerialize.serialize(null, null, null);
        jsonSerialize.serialize(null, jsonGenerator, null);
        jsonSerialize.serialize(OffsetDateTime.now(), jsonGenerator, null);
        jsonSerialize.serialize(OffsetDateTime.now().minusDays(4), jsonGenerator, null);
        jsonSerialize.serialize(OffsetDateTime.now().plusHours(6), jsonGenerator, null);
    }
}
