package org.frekele.fiscal.focus.nfe.client.converter.serialize;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * @author frekele - Leandro Kersting de Freitas
 */
public class LocalDateJsonSerialize extends StdSerializer<LocalDate> {

    protected LocalDateJsonSerialize() {
        super(LocalDate.class);
    }

    @Override
    public void serialize(LocalDate value, JsonGenerator jsonGenerator, SerializerProvider provider) throws IOException {
        if (value != null) {
            jsonGenerator.writeString(value.format(DateTimeFormatter.ISO_LOCAL_DATE));
        }
    }
}
