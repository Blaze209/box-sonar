package com.microsoft.identity.nativeauth.parameters;

import com.microsoft.identity.common.java.nativeauth.providers.NativeAuthConstants;
import com.microsoft.identity.nativeauth.UserAttributes;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NativeAuthSignUpParameters.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0019\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/microsoft/identity/nativeauth/parameters/NativeAuthSignUpParameters;", "", "username", "", "(Ljava/lang/String;)V", NativeAuthConstants.GrantType.ATTRIBUTES, "Lcom/microsoft/identity/nativeauth/UserAttributes;", "getAttributes", "()Lcom/microsoft/identity/nativeauth/UserAttributes;", "setAttributes", "(Lcom/microsoft/identity/nativeauth/UserAttributes;)V", "password", "", "getPassword", "()[C", "setPassword", "([C)V", "getUsername", "()Ljava/lang/String;", "msal_distRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class NativeAuthSignUpParameters {
    private UserAttributes attributes;
    private char[] password;
    private final String username;

    public NativeAuthSignUpParameters(String username) {
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

    public final UserAttributes getAttributes() {
        return this.attributes;
    }

    public final void setAttributes(UserAttributes userAttributes) {
        this.attributes = userAttributes;
    }
}
