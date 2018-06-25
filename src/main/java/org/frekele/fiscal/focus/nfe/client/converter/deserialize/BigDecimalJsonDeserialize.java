package org.frekele.fiscal.focus.nfe.client.converter.deserialize;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;
import java.math.BigDecimal;

/**
 * JsonDeserialize para BigDecimal.
 *
 * @author frekele - Leandro Kersting de Freitas
 */
public class BigDecimalJsonDeserialize extends StdDeserializer<BigDecimal> {

    protected BigDecimalJsonDeserialize() {
        super(BigDecimal.class);
    }

    @Override
    public BigDecimal deserialize(JsonParser jsonParser, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        if (jsonParser != null) {
            String value = jsonParser.readValueAs(String.class);
            if (value != null) {
                return new BigDecimal(value);
            }
        }
        return null;
    }
}
