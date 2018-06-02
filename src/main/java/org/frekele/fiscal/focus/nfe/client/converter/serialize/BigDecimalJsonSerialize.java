package org.frekele.fiscal.focus.nfe.client.converter.serialize;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;
import java.math.BigDecimal;

/**
 * @author frekele - Leandro Kersting de Freitas
 */
public class BigDecimalJsonSerialize extends StdSerializer<BigDecimal> {

    protected BigDecimalJsonSerialize() {
        super(BigDecimal.class);
    }

    @Override
    public void serialize(BigDecimal value, JsonGenerator jsonGenerator, SerializerProvider provider) throws IOException {
        if (value != null) {
            //se 1.475 ou 1.471 ou 1.479 vai truncar para 1.47;
            BigDecimal valueScaled = value.setScale(2, BigDecimal.ROUND_DOWN);
            Long numberValue = valueScaled.unscaledValue().longValue();
            jsonGenerator.writeNumber(numberValue);
        }
    }
}
