package io.split.android.client.utils.serializer;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes4.dex */
public class DoubleSerializer implements JsonSerializer<Double> {
    @Override // com.google.gson.JsonSerializer
    public JsonElement serialize(Double src, Type typeOfSrc, JsonSerializationContext context) {
        if (src.doubleValue() == src.longValue()) {
            return new JsonPrimitive(Long.valueOf(src.longValue()));
        }
        return new JsonPrimitive(src);
    }
}
