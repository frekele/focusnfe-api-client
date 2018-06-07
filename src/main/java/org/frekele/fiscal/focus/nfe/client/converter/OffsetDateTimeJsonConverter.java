package org.frekele.fiscal.focus.nfe.client.converter;

import com.fasterxml.jackson.annotation.JacksonAnnotationsInside;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.frekele.fiscal.focus.nfe.client.converter.deserialize.OffsetDateTimeJsonDeserialize;
import org.frekele.fiscal.focus.nfe.client.converter.serialize.OffsetDateTimeJsonSerialize;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @author frekele - Leandro Kersting de Freitas
 */

@Retention(RetentionPolicy.RUNTIME)
@JacksonAnnotationsInside
@JsonDeserialize(using = OffsetDateTimeJsonDeserialize.class)
@JsonSerialize(using = OffsetDateTimeJsonSerialize.class)
public @interface OffsetDateTimeJsonConverter {

}
