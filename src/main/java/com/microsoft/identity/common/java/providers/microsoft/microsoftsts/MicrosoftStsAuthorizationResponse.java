package com.microsoft.identity.common.java.providers.microsoft.microsoftsts;

import com.microsoft.identity.common.java.providers.microsoft.MicrosoftAuthorizationResponse;
import java.util.Map;

/* JADX INFO: loaded from: classes14.dex */
public class MicrosoftStsAuthorizationResponse extends MicrosoftAuthorizationResponse {
    public MicrosoftStsAuthorizationResponse(String str, String str2, Map<String, String> map) {
        super(str, str2);
        this.mCloudGraphHostName = map.get("cloud_graph_host_name");
        this.mCloudInstanceHostName = map.get("cloud_instance_host_name");
        this.mCloudInstanceName = map.get("cloud_instance_name");
        this.mSessionState = map.get(MicrosoftAuthorizationResponse.SESSION_STATE);
        this.mDeviceCode = map.get("device_code");
        this.mUserCode = map.get(MicrosoftAuthorizationResponse.USER_CODE);
        this.mVerificationUri = map.get(MicrosoftAuthorizationResponse.VERIFICATION_URI);
        this.mExpiresIn = map.get("expires_in");
        this.mInterval = map.get(MicrosoftAuthorizationResponse.INTERVAL);
        this.mMessage = map.get("message");
    }
}
