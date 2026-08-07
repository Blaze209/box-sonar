package com.microsoft.identity.nativeauth.parameters;

import com.microsoft.identity.client.claims.ClaimsRequest;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NativeAuthSignInParameters.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0019\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2 = {"Lcom/microsoft/identity/nativeauth/parameters/NativeAuthSignInParameters;", "", "username", "", "(Ljava/lang/String;)V", "claimsRequest", "Lcom/microsoft/identity/client/claims/ClaimsRequest;", "getClaimsRequest", "()Lcom/microsoft/identity/client/claims/ClaimsRequest;", "setClaimsRequest", "(Lcom/microsoft/identity/client/claims/ClaimsRequest;)V", "password", "", "getPassword", "()[C", "setPassword", "([C)V", "scopes", "", "getScopes", "()Ljava/util/List;", "setScopes", "(Ljava/util/List;)V", "getUsername", "()Ljava/lang/String;", "msal_distRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class NativeAuthSignInParameters {
    private ClaimsRequest claimsRequest;
    private char[] password;
    private List<String> scopes;
    private final String username;

    public NativeAuthSignInParameters(String username) {
        Intrinsics.checkNotNullParameter(username, "username");
        this.username = username;
    }

    public final String getUsername() {
        return this.username;
    }

    public final char[] getPassword() {
        return this.password;
    }

    public final void setPassword(char[] cArr) {
        this.password = cArr;
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
