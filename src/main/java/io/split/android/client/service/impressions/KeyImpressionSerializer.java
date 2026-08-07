package io.split.android.client.service.impressions;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import io.split.android.client.dtos.KeyImpression;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes4.dex */
public class KeyImpressionSerializer implements JsonSerializer<KeyImpression> {
    private final Gson mGson = new GsonBuilder().serializeNulls().create();

    @Override // com.google.gson.JsonSerializer
    public JsonElement serialize(KeyImpression src, Type typeOfSrc, JsonSerializationContext context) {
        JsonObject jsonObject = (JsonObject) this.mGson.toJsonTree(src);
        if (src.properties == null) {
            jsonObject.remove("properties");
        }
        return jsonObject;
    }
}
