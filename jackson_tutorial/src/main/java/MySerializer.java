import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

public class MySerializer
    extends JsonSerializer<MyValue>
{

    @Override
    public void serialize(MyValue value, JsonGenerator jgen, SerializerProvider serializers)
            throws IOException, JsonProcessingException
    {
        jgen.writeStartObject();
        jgen.writeFieldName("*" + value.name + "*");
        jgen.writeNumber(value.age);
        jgen.writeEndObject();
    }
}
