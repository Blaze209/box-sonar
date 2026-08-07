package com.microsoft.identity.nativeauth.parameters;

import com.microsoft.identity.client.claims.ClaimsRequest;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: compiled from: NativeAuthGetAccessTokenParameters.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/microsoft/identity/nativeauth/parameters/NativeAuthGetAccessTokenParameters;", "", "()V", "claimsRequest", "Lcom/microsoft/identity/client/claims/ClaimsRequest;", "getClaimsRequest", "()Lcom/microsoft/identity/client/claims/ClaimsRequest;", "setClaimsRequest", "(Lcom/microsoft/identity/client/claims/ClaimsRequest;)V", "forceRefresh", "", "getForceRefresh", "()Z", "setForceRefresh", "(Z)V", "scopes", "", "", "getScopes", "()Ljava/util/List;", "setScopes", "(Ljava/util/List;)V", "msal_distRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class NativeAuthGetAccessTokenParameters {
    private ClaimsRequest claimsRequest;
    private boolean forceRefresh;
    private List<String> scopes;

    public final boolean getForceRefresh() {
        return this.forceRefresh;
    }

    public final void setForceRefresh(boolean z) {
        this.forceRefresh = z;
    }

    public final List<String> getScopes() {
        return this.scopes;
    }

    public final void setScopes(List<String> list) {
        this.scopes = list;
    }

    public final ClaimsRequest getClaimsRequest() {
        return this.claimsRequest;
    }

    public final void setClaimsRequest(ClaimsRequest claimsRequest) {
        this.claimsRequest = claimsRequest;
    }
}
