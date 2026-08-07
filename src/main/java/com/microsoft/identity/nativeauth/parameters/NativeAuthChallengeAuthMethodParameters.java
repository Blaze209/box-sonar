package com.microsoft.identity.nativeauth.parameters;

import com.microsoft.identity.nativeauth.AuthMethod;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NativeAuthChallengeAuthMethodParameters.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/microsoft/identity/nativeauth/parameters/NativeAuthChallengeAuthMethodParameters;", "", "authMethod", "Lcom/microsoft/identity/nativeauth/AuthMethod;", "verificationContact", "", "(Lcom/microsoft/identity/nativeauth/AuthMethod;Ljava/lang/String;)V", "getAuthMethod", "()Lcom/microsoft/identity/nativeauth/AuthMethod;", "getVerificationContact", "()Ljava/lang/String;", "setVerificationContact", "(Ljava/lang/String;)V", "msal_distRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class NativeAuthChallengeAuthMethodParameters {
    private final AuthMethod authMethod;
    private String verificationContact;

    public NativeAuthChallengeAuthMethodParameters(AuthMethod authMethod, String verificationContact) {
        Intrinsics.checkNotNullParameter(authMethod, "authMethod");
        Intrinsics.checkNotNullParameter(verificationContact, "verificationContact");
        this.authMethod = authMethod;
        this.verificationContact = verificationContact;
    }

    public final AuthMethod getAuthMethod() {
        return this.authMethod;
    }

    public final String getVerificationContact() {
        return this.verificationContact;
    }

    public final void setVerificationContact(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.verificationContact = str;
    }
}
