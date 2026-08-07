package com.microsoft.identity.common.java.authscheme;

import com.microsoft.identity.common.java.exception.ClientException;

/* JADX INFO: loaded from: classes14.dex */
public interface ITokenAuthenticationSchemeInternal {
    String getAccessTokenForScheme(String str) throws ClientException;
}
