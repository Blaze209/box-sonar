package com.microsoft.identity.common.internal.request;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.microsoft.identity.common.java.authscheme.AbstractAuthenticationScheme;
import com.microsoft.identity.common.java.authscheme.BearerAuthenticationSchemeInternal;
import com.microsoft.identity.common.java.authscheme.PopAuthenticationSchemeInternal;
import com.microsoft.identity.common.java.authscheme.PopAuthenticationSchemeWithClientKeyInternal;
import com.microsoft.identity.common.logging.Logger;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes14.dex */
public class AuthenticationSchemeTypeAdapter implements JsonDeserializer<AbstractAuthenticationScheme>, JsonSerializer<AbstractAuthenticationScheme> {
    private static final String TAG = "AuthenticationSchemeTypeAdapter";
    private static Gson sRequestAdapterGsonInstance = new GsonBuilder().registerTypeAdapter(AbstractAuthenticationScheme.class, new AuthenticationSchemeTypeAdapter()).create();

    public static Gson getGsonInstance() {
        return sRequestAdapterGsonInstance;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.gson.JsonDeserializer
    public AbstractAuthenticationScheme deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        String str = TAG + ":deserialize";
        String asString = jsonElement.getAsJsonObject().get("name").getAsString();
        asString.hashCode();
        switch (asString) {
            case "PoP_With_Client_Key":
                return (AbstractAuthenticationScheme) jsonDeserializationContext.deserialize(jsonElement, PopAuthenticationSchemeWithClientKeyInternal.class);
            case "PoP":
                return (AbstractAuthenticationScheme) jsonDeserializationContext.deserialize(jsonElement, PopAuthenticationSchemeInternal.class);
            case "Bearer":
                return (AbstractAuthenticationScheme) jsonDeserializationContext.deserialize(jsonElement, BearerAuthenticationSchemeInternal.class);
            default:
                Logger.warn(str, "Unrecognized auth scheme. Deserializing as null.");
                return null;
        }
    }

    @Override // com.google.gson.JsonSerializer
    public JsonElement serialize(AbstractAuthenticationScheme abstractAuthenticationScheme, Type type, JsonSerializationContext jsonSerializationContext) {
        String str = TAG + ":serialize";
        String name = abstractAuthenticationScheme.getName();
        name.hashCode();
        switch (name) {
            case "PoP_With_Client_Key":
                return jsonSerializationContext.serialize(abstractAuthenticationScheme, PopAuthenticationSchemeWithClientKeyInternal.class);
            case "PoP":
                return jsonSerializationContext.serialize(abstractAuthenticationScheme, PopAuthenticationSchemeInternal.class);
            case "Bearer":
                return jsonSerializationContext.serialize(abstractAuthenticationScheme, BearerAuthenticationSchemeInternal.class);
            default:
                Logger.warn(str, "Unrecognized auth scheme. Serializing as null.");
                return null;
        }
    }
}
