package com.microsoft.identity.client.claims;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import java.lang.reflect.Type;
import java.util.Iterator;

/* JADX INFO: loaded from: classes14.dex */
class RequestClaimAdditionalInformationSerializer implements JsonSerializer<RequestedClaimAdditionalInformation> {
    RequestClaimAdditionalInformationSerializer() {
    }

    @Override // com.google.gson.JsonSerializer
    public JsonElement serialize(RequestedClaimAdditionalInformation requestedClaimAdditionalInformation, Type type, JsonSerializationContext jsonSerializationContext) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("essential", requestedClaimAdditionalInformation.getEssential());
        if (requestedClaimAdditionalInformation.getValue() != null) {
            jsonObject.addProperty("value", requestedClaimAdditionalInformation.getValue().toString());
        }
        if (requestedClaimAdditionalInformation.getValues().size() > 0) {
            JsonArray jsonArray = new JsonArray();
            Iterator<Object> it = requestedClaimAdditionalInformation.getValues().iterator();
            while (it.hasNext()) {
                jsonArray.add(it.next().toString());
            }
            jsonObject.add("values", jsonArray);
        }
        return jsonObject;
    }
}
