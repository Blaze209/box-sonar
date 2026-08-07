package com.microsoft.identity.common.java.authscheme;

import java.net.URL;

/* JADX INFO: loaded from: classes14.dex */
public interface IPoPAuthenticationSchemeParams extends INonced {
    String getClientClaims();

    String getHttpMethod();

    URL getUrl();
}
