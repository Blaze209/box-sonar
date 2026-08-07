package io.split.android.client.utils.deserializer;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import io.split.android.client.dtos.Event;
import io.split.android.client.dtos.SerializableEvent;
import java.lang.reflect.Type;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public class EventDeserializer implements JsonDeserializer<Event> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.gson.JsonDeserializer
    public Event deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonObject asJsonObject = json.getAsJsonObject();
        JsonObject asJsonObject2 = !asJsonObject.get("properties").isJsonNull() ? asJsonObject.get("properties").getAsJsonObject() : new JsonObject();
        Event event = new Event();
        if (asJsonObject.get(Event.SIZE_IN_BYTES_FIELD) != null && !asJsonObject.get(Event.SIZE_IN_BYTES_FIELD).isJsonNull()) {
            event.setSizeInBytes(asJsonObject.get(Event.SIZE_IN_BYTES_FIELD).getAsInt());
        }
        event.eventTypeId = asJsonObject.get(SerializableEvent.EVENT_TYPE_FIELD).getAsString();
        event.trafficTypeName = asJsonObject.get(SerializableEvent.TRAFFIC_TYPE_NAME_FIELD).getAsString();
        event.key = asJsonObject.get("key").getAsString();
        event.value = asJsonObject.get("value").getAsDouble();
        event.timestamp = asJsonObject.get("timestamp").getAsLong();
        event.properties = buildMappedProperties(asJsonObject2);
        return event;
    }

    private static Map<String, Object> buildMappedProperties(JsonObject properties) {
        HashMap map = new HashMap();
        if (properties == null) {
            return Collections.unmodifiableMap(map);
        }
        for (Map.Entry<String, JsonElement> entry : properties.entrySet()) {
            JsonElement value = entry.getValue();
            String key = entry.getKey();
            if (value != null && !value.isJsonNull()) {
                try {
                    String asString = value.getAsString();
                    if (asString.equals(String.valueOf(value.getAsBoolean()))) {
                        map.put(key, Boolean.valueOf(value.getAsBoolean()));
                    } else if (asString.equals(String.valueOf(value.getAsInt()))) {
                        map.put(key, Integer.valueOf(value.getAsInt()));
                    } else if (asString.equals(String.valueOf(value.getAsLong()))) {
                        map.put(key, Long.valueOf(value.getAsLong()));
                    } else if (asString.equals(String.valueOf(value.getAsDouble()))) {
                        map.put(key, Double.valueOf(value.getAsDouble()));
                    } else if (asString.equals(String.valueOf(value.getAsBigDecimal()))) {
                        map.put(key, value.getAsBigDecimal());
                    } else {
                        map.put(key, asString);
                    }
                } catch (NumberFormatException unused) {
                    map.put(key, value.getAsString());
                }
            } else {
                map.put(key, null);
            }
        }
        return Collections.unmodifiableMap(map);
    }
}
