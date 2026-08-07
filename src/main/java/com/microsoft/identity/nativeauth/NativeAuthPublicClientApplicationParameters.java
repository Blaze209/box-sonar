package com.microsoft.identity.nativeauth;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NativeAuthPublicClientApplicationParameters.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u000f\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006¢\u0006\u0002\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\"\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\tR\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\t\"\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/microsoft/identity/nativeauth/NativeAuthPublicClientApplicationParameters;", "", "clientId", "", "authorityUrl", "challengeTypes", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getAuthorityUrl", "()Ljava/lang/String;", NativeAuthPublicClientApplicationConfiguration.NativeAuthSerializedNames.CAPABILITIES, "getCapabilities", "()Ljava/util/List;", "setCapabilities", "(Ljava/util/List;)V", "getChallengeTypes", "getClientId", "redirectUri", "getRedirectUri", "setRedirectUri", "(Ljava/lang/String;)V", "msal_distRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class NativeAuthPublicClientApplicationParameters {
    private final String authorityUrl;
    private List<String> capabilities;
    private final List<String> challengeTypes;
    private final String clientId;
    private String redirectUri;

    public NativeAuthPublicClientApplicationParameters(String clientId, String authorityUrl, List<String> challengeTypes) {
        Intrinsics.checkNotNullParameter(clientId, "clientId");
        Intrinsics.checkNotNullParameter(authorityUrl, "authorityUrl");
        Intrinsics.checkNotNullParameter(challengeTypes, "challengeTypes");
        this.clientId = clientId;
        this.authorityUrl = authorityUrl;
        this.challengeTypes = challengeTypes;
    }

    public final String getClientId() {
        return this.clientId;
    }

    public final String getAuthorityUrl() {
        return this.authorityUrl;
    }

    public final List<String> getChallengeTypes() {
        return this.challengeTypes;
    }

    public final List<String> getCapabilities() {
        return this.capabilities;
    }

    public final void setCapabilities(List<String> list) {
        this.capabilities = list;
    }

    public final String getRedirectUri() {
        return this.redirectUri;
    }

    public final void setRedirectUri(String str) {
        this.redirectUri = str;
    }
}
