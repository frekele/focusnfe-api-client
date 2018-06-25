package org.frekele.fiscal.focus.nfe.client.converter.serialize;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;
import java.math.BigDecimal;

/**
 * JsonSerialize para BigDecimal.
 *
 * @author frekele - Leandro Kersting de Freitas
 */
public class BigDecimalJsonSerialize extends StdSerializer<BigDecimal> {

    protected BigDecimalJsonSerialize() {
        super(BigDecimal.class);
    }

    @Override
    public void serialize(BigDecimal value, JsonGenerator jsonGenerator, SerializerProvider provider) throws IOException {
        if (value != null) {
            jsonGenerator.writeString(value.toString());
        }
    }
}
