/**
 * 
 */
package com.jsoft.util;

import java.io.IOException;
import java.util.Date;
import java.util.Locale;

import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.SerializerProvider;
import org.springframework.stereotype.Component;

/**
 * @author Sirimongkol
 *
 */
@Component
public class JsonDateSerializer extends JsonSerializer<Date>{

	@Override
	public void serialize(Date date, JsonGenerator gen, SerializerProvider provider)
			throws IOException, JsonProcessingException {
		gen.writeString(DateTime.formatDate(date, "dd/mm/yyyy", Locale.US));	
	}

}
