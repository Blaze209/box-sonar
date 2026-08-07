package com.microsoft.identity.client.claims;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes14.dex */
public class ClaimsRequest {
    public static final String ACCESS_TOKEN = "access_token";
    public static final String ID_TOKEN = "id_token";
    public static final String USERINFO = "userinfo";
    private List<RequestedClaim> mUserInfoClaimsRequested = new ArrayList();
    private List<RequestedClaim> mAccessTokenClaimsRequested = new ArrayList();
    private List<RequestedClaim> mIdTokenClaimsRequested = new ArrayList();

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ClaimsRequest)) {
            return false;
        }
        ClaimsRequest claimsRequest = (ClaimsRequest) obj;
        List<RequestedClaim> list = this.mUserInfoClaimsRequested;
        if (list == null ? claimsRequest.mUserInfoClaimsRequested != null : !list.equals(claimsRequest.mUserInfoClaimsRequested)) {
            return false;
        }
        List<RequestedClaim> list2 = this.mAccessTokenClaimsRequested;
        if (list2 == null ? claimsRequest.mAccessTokenClaimsRequested != null : !list2.equals(claimsRequest.mAccessTokenClaimsRequested)) {
            return false;
        }
        List<RequestedClaim> list3 = this.mIdTokenClaimsRequested;
        if (list3 != null) {
            return list3.equals(claimsRequest.mIdTokenClaimsRequested);
        }
        return claimsRequest.mIdTokenClaimsRequested == null;
    }

    public int hashCode() {
        List<RequestedClaim> list = this.mUserInfoClaimsRequested;
        int iHashCode = (list != null ? list.hashCode() : 0) * 31;
        List<RequestedClaim> list2 = this.mAccessTokenClaimsRequested;
        int iHashCode2 = (iHashCode + (list2 != null ? list2.hashCode() : 0)) * 31;
        List<RequestedClaim> list3 = this.mIdTokenClaimsRequested;
        return iHashCode2 + (list3 != null ? list3.hashCode() : 0);
    }

    public List<RequestedClaim> getUserInfoClaimsRequested() {
        return this.mUserInfoClaimsRequested;
    }

    public List<RequestedClaim> getAccessTokenClaimsRequested() {
        return this.mAccessTokenClaimsRequested;
    }

    public List<RequestedClaim> getIdTokenClaimsRequested() {
        return this.mIdTokenClaimsRequested;
    }

    public static ClaimsRequest getClaimsRequestFromJsonString(String str) {
        return deserializeClaimsRequest(str);
    }

    public static String getJsonStringFromClaimsRequest(ClaimsRequest claimsRequest) {
        return serializeClaimsRequest(claimsRequest);
    }

    private static String serializeClaimsRequest(ClaimsRequest claimsRequest) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        ClaimsRequestSerializer claimsRequestSerializer = new ClaimsRequestSerializer();
        RequestClaimAdditionalInformationSerializer requestClaimAdditionalInformationSerializer = new RequestClaimAdditionalInformationSerializer();
        gsonBuilder.registerTypeAdapter(ClaimsRequest.class, claimsRequestSerializer);
        gsonBuilder.registerTypeAdapter(RequestedClaimAdditionalInformation.class, requestClaimAdditionalInformationSerializer);
        gsonBuilder.serializeNulls();
        Gson gsonCreate = gsonBuilder.create();
        if (claimsRequest != null) {
            return gsonCreate.toJson(claimsRequest);
        }
        return null;
    }

    private static ClaimsRequest deserializeClaimsRequest(String str) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(ClaimsRequest.class, new ClaimsRequestDeserializer());
        return (ClaimsRequest) gsonBuilder.create().fromJson(str, ClaimsRequest.class);
    }

    public void requestClaimInAccessToken(String str, RequestedClaimAdditionalInformation requestedClaimAdditionalInformation) {
        requestClaimIn(this.mAccessTokenClaimsRequested, str, requestedClaimAdditionalInformation);
    }

    public void requestClaimInIdToken(String str, RequestedClaimAdditionalInformation requestedClaimAdditionalInformation) {
        requestClaimIn(this.mIdTokenClaimsRequested, str, requestedClaimAdditionalInformation);
    }

    public void requestClaimInUserInfo(String str, RequestedClaimAdditionalInformation requestedClaimAdditionalInformation) {
        requestClaimIn(this.mUserInfoClaimsRequested, str, requestedClaimAdditionalInformation);
    }

    private void requestClaimIn(List<RequestedClaim> list, String str, RequestedClaimAdditionalInformation requestedClaimAdditionalInformation) {
        RequestedClaim requestedClaim = new RequestedClaim();
        requestedClaim.setName(str);
        requestedClaim.setAdditionalInformation(requestedClaimAdditionalInformation);
        list.add(requestedClaim);
    }
}
