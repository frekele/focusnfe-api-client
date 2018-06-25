package org.frekele.fiscal.focus.nfe.client.converter.deserialize;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * JsonDeserialize para LocalDate.
 *
 * @author frekele - Leandro Kersting de Freitas
 */
public class LocalDateJsonDeserialize extends StdDeserializer<LocalDate> {

    protected LocalDateJsonDeserialize() {
        super(LocalDate.class);
    }

    @Override
    public LocalDate deserialize(JsonParser jsonParser, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        if (jsonParser != null) {
            String value = jsonParser.readValueAs(String.class);
            if (value != null) {
                return LocalDate.parse(value, DateTimeFormatter.ISO_LOCAL_DATE);
            }
        }
        return null;
    }
}
