package com.microsoft.intune.mam.policy;

/* JADX INFO: loaded from: classes3.dex */
public final class MAMServiceAuthentication {
    public static final String APIV2_AUTH_USED = "MAMServiceAuthentication.ApiV2AuthUsed";
    public static final String BROKER_NEEDED = "MAMServiceAuthentication.BrokerNeeded";
    public static final String MAMSERVICE_RESOURCE_ID = "https://msmamservice.api.application";

    private MAMServiceAuthentication() {
    }

    public static String authHeaderFromToken(String str) {
        return "Bearer " + str;
    }
}
