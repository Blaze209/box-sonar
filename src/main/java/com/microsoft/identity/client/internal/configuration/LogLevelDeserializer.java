package com.microsoft.identity.client.internal.configuration;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.microsoft.identity.client.Logger;
import java.lang.reflect.Type;
import java.util.Locale;

/* JADX INFO: loaded from: classes14.dex */
public class LogLevelDeserializer implements JsonDeserializer<Logger.LogLevel> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.gson.JsonDeserializer
    public Logger.LogLevel deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        return Logger.LogLevel.valueOf(jsonElement.getAsString().toUpperCase(Locale.US));
    }
}
