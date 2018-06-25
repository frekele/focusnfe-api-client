package org.frekele.fiscal.focus.nfe.client.converter;

import com.fasterxml.jackson.annotation.JacksonAnnotationsInside;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.frekele.fiscal.focus.nfe.client.converter.deserialize.LocalDateJsonDeserialize;
import org.frekele.fiscal.focus.nfe.client.converter.serialize.LocalDateJsonSerialize;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * JsonSerialize e JsonDeserialize para LocalDate.
 *
 * @author frekele - Leandro Kersting de Freitas
 */
@Retention(RetentionPolicy.RUNTIME)
@JacksonAnnotationsInside
@JsonDeserialize(using = LocalDateJsonDeserialize.class)
@JsonSerialize(using = LocalDateJsonSerialize.class)
public @interface LocalDateJsonConverter {

}
