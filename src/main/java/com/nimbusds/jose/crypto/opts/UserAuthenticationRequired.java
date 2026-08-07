package com.nimbusds.jose.crypto.opts;

import com.nimbusds.jose.JWSSignerOption;
import com.nimbusds.jose.shaded.jcip.Immutable;

/* JADX INFO: loaded from: classes3.dex */
@Immutable
public final class UserAuthenticationRequired implements JWSSignerOption {
    private static final UserAuthenticationRequired SINGLETON = new UserAuthenticationRequired();

    public static UserAuthenticationRequired getInstance() {
        return SINGLETON;
    }

    private UserAuthenticationRequired() {
    }

    public String toString() {
        return "UserAuthenticationRequired";
    }
}
