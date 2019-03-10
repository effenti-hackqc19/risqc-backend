package ca.effenti.risqc.model;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import org.hibernate.cache.spi.support.AbstractReadWriteAccess;

import java.io.IOException;

public class GeoDeserializer  extends StdDeserializer<ZoneRisqc> {
    public GeoDeserializer() {
        this(null);
    }

    @Override
    public ZoneRisqc deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        return null;
    }

    public GeoDeserializer(Class<?> vc) {
        super(vc);
    }

   /*
    @Override
    public AbstractReadWriteAccess.Item deserialize(JsonParser jp, DeserializationContext ctxt)
            throws IOException, JsonProcessingException {
        JsonNode node = jp.getCodec().readTree(jp);
        int id = (Integer) ((IntNode) node.get("id")).numberValue();
        String itemName = node.get("itemName").asText();
        int userId = (Integer) ((IntNode) node.get("createdBy")).numberValue();

        return new Item(id, itemName, new User(userId, null));
    }
    */

}
