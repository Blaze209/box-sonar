package com.microsoft.identity.common.internal.fido;

import com.google.android.gms.fido.u2f.api.common.ClientData;
import com.squareup.moshi.Json;
import java.util.List;

/* JADX INFO: loaded from: classes14.dex */
public class PublicKeyCredentialRequestOptions {

    @Json(name = "allowCredentials")
    public final List<PublicKeyCredentialDescriptor> allowCredentials;

    @Json(name = ClientData.KEY_CHALLENGE)
    public final String challenge;

    @Json(name = "rpId")
    public final String rpId;

    @Json(name = "userVerification")
    public final String userVerification;

    public String getChallenge() {
        return this.challenge;
    }

    public String getRpId() {
        return this.rpId;
    }

    public List<PublicKeyCredentialDescriptor> getAllowCredentials() {
        return this.allowCredentials;
    }

    public String getUserVerification() {
        return this.userVerification;
    }

    public PublicKeyCredentialRequestOptions(String str, String str2, List<PublicKeyCredentialDescriptor> list, String str3) {
        this.challenge = str;
        this.rpId = str2;
        this.allowCredentials = list;
        this.userVerification = str3;
    }
}
