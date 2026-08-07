package com.microsoft.identity.client.claims;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import java.lang.reflect.Type;
import java.util.List;

/* JADX INFO: loaded from: classes14.dex */
class ClaimsRequestSerializer implements JsonSerializer<ClaimsRequest> {
    ClaimsRequestSerializer() {
    }

    @Override // com.google.gson.JsonSerializer
    public JsonElement serialize(ClaimsRequest claimsRequest, Type type, JsonSerializationContext jsonSerializationContext) {
        JsonObject jsonObject = new JsonObject();
        JsonObject jsonObject2 = new JsonObject();
        JsonObject jsonObject3 = new JsonObject();
        JsonObject jsonObject4 = new JsonObject();
        addPropertiesToObject(claimsRequest.getAccessTokenClaimsRequested(), jsonObject3, jsonSerializationContext);
        addPropertiesToObject(claimsRequest.getIdTokenClaimsRequested(), jsonObject4, jsonSerializationContext);
        addPropertiesToObject(claimsRequest.getUserInfoClaimsRequested(), jsonObject2, jsonSerializationContext);
        if (jsonObject2.size() != 0) {
            jsonObject.add(ClaimsRequest.USERINFO, jsonObject2);
        }
        if (jsonObject4.size() != 0) {
            jsonObject.add("id_token", jsonObject4);
        }
        if (jsonObject3.size() != 0) {
            jsonObject.add("access_token", jsonObject3);
        }
        return jsonObject;
    }

    public void addPropertiesToObject(List<RequestedClaim> list, JsonObject jsonObject, JsonSerializationContext jsonSerializationContext) {
        for (RequestedClaim requestedClaim : list) {
            jsonObject.add(requestedClaim.getName(), jsonSerializationContext.serialize(requestedClaim.getAdditionalInformation(), RequestedClaimAdditionalInformation.class));
        }
    }
}
