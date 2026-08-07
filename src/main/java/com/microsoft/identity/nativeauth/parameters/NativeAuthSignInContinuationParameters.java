package com.microsoft.identity.nativeauth.parameters;

import com.microsoft.identity.client.claims.ClaimsRequest;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: compiled from: NativeAuthSignInContinuationParameters.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/microsoft/identity/nativeauth/parameters/NativeAuthSignInContinuationParameters;", "", "()V", "claimsRequest", "Lcom/microsoft/identity/client/claims/ClaimsRequest;", "getClaimsRequest", "()Lcom/microsoft/identity/client/claims/ClaimsRequest;", "setClaimsRequest", "(Lcom/microsoft/identity/client/claims/ClaimsRequest;)V", "scopes", "", "", "getScopes", "()Ljava/util/List;", "setScopes", "(Ljava/util/List;)V", "msal_distRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class NativeAuthSignInContinuationParameters {
    private ClaimsRequest claimsRequest;
    private List<String> scopes;

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
