package com.microsoft.identity.nativeauth.parameters;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NativeAuthResetPasswordParameters.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/microsoft/identity/nativeauth/parameters/NativeAuthResetPasswordParameters;", "", "username", "", "(Ljava/lang/String;)V", "getUsername", "()Ljava/lang/String;", "msal_distRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class NativeAuthResetPasswordParameters {
    private final String username;

    public NativeAuthResetPasswordParameters(String username) {
        Intrinsics.checkNotNullParameter(username, "username");
        this.username = username;
    }

    public final String getUsername() {
        return this.username;
    }
}
