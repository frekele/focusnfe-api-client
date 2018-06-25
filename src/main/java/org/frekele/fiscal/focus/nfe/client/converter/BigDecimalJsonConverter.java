package org.frekele.fiscal.focus.nfe.client.converter;

import com.fasterxml.jackson.annotation.JacksonAnnotationsInside;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.frekele.fiscal.focus.nfe.client.converter.deserialize.BigDecimalJsonDeserialize;
import org.frekele.fiscal.focus.nfe.client.converter.serialize.BigDecimalJsonSerialize;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * JsonSerialize e JsonDeserialize para BigDecimal.
 *
 * @author frekele - Leandro Kersting de Freitas
 */

@Retention(RetentionPolicy.RUNTIME)
@JacksonAnnotationsInside
@JsonDeserialize(using = BigDecimalJsonDeserialize.class)
@JsonSerialize(using = BigDecimalJsonSerialize.class)
public @interface BigDecimalJsonConverter {

}
