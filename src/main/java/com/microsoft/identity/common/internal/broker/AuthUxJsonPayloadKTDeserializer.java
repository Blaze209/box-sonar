package com.microsoft.identity.common.internal.broker;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AuthUxJsonPayload.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J \u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, d2 = {"Lcom/microsoft/identity/common/internal/broker/AuthUxJsonPayloadKTDeserializer;", "Lcom/google/gson/JsonDeserializer;", "Lcom/microsoft/identity/common/internal/broker/AuthUxJsonPayload;", "()V", "deserialize", "json", "Lcom/google/gson/JsonElement;", "typeOfT", "Ljava/lang/reflect/Type;", "context", "Lcom/google/gson/JsonDeserializationContext;", "common_distRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class AuthUxJsonPayloadKTDeserializer implements JsonDeserializer<AuthUxJsonPayload> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.gson.JsonDeserializer
    public AuthUxJsonPayload deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) {
        Intrinsics.checkNotNullParameter(json, "json");
        Intrinsics.checkNotNullParameter(typeOfT, "typeOfT");
        Intrinsics.checkNotNullParameter(context, "context");
        JsonObject asJsonObject = json.getAsJsonObject();
        JsonElement jsonElement = asJsonObject.get(SerializedNames.CORRELATION_ID);
        String asString = jsonElement != null ? jsonElement.getAsString() : null;
        if (asString == null) {
            throw new JsonParseException("correlationID is required and cannot be null");
        }
        JsonElement jsonElement2 = asJsonObject.get(SerializedNames.ACTION_NAME);
        String asString2 = jsonElement2 != null ? jsonElement2.getAsString() : null;
        if (asString2 == null) {
            throw new JsonParseException("action_name is required and cannot be null");
        }
        JsonElement jsonElement3 = asJsonObject.get(SerializedNames.ACTION_COMPONENT);
        String asString3 = jsonElement3 != null ? jsonElement3.getAsString() : null;
        if (asString3 == null) {
            throw new JsonParseException("action_component is required and cannot be null");
        }
        JsonElement jsonElement4 = asJsonObject.get(SerializedNames.PARAMS);
        return new AuthUxJsonPayload(asString, asString2, asString3, jsonElement4 != null ? (AuthUxParams) context.deserialize(jsonElement4, AuthUxParams.class) : null);
    }
}
