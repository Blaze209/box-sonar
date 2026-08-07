package com.microsoft.identity.client.claims;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import java.lang.reflect.Type;
import java.util.List;

/* JADX INFO: loaded from: classes14.dex */
class ClaimsRequestDeserializer implements JsonDeserializer<ClaimsRequest> {
    ClaimsRequestDeserializer() {
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.gson.JsonDeserializer
    public ClaimsRequest deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        ClaimsRequest claimsRequest = new ClaimsRequest();
        addProperties(claimsRequest.getAccessTokenClaimsRequested(), jsonElement.getAsJsonObject().getAsJsonObject("access_token"), jsonDeserializationContext);
        addProperties(claimsRequest.getIdTokenClaimsRequested(), jsonElement.getAsJsonObject().getAsJsonObject("id_token"), jsonDeserializationContext);
        addProperties(claimsRequest.getUserInfoClaimsRequested(), jsonElement.getAsJsonObject().getAsJsonObject(ClaimsRequest.USERINFO), jsonDeserializationContext);
        return claimsRequest;
    }

    private void addProperties(List<RequestedClaim> list, JsonObject jsonObject, JsonDeserializationContext jsonDeserializationContext) {
        if (jsonObject == null) {
            return;
        }
        for (String str : jsonObject.keySet()) {
            RequestedClaim requestedClaim = new RequestedClaim();
            requestedClaim.setName(str);
            if (!(jsonObject.get(str) instanceof JsonNull)) {
                requestedClaim.setAdditionalInformation((RequestedClaimAdditionalInformation) jsonDeserializationContext.deserialize(jsonObject.getAsJsonObject(str), RequestedClaimAdditionalInformation.class));
            }
            list.add(requestedClaim);
        }
    }
}
