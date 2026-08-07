package com.microsoft.identity.common.java.providers.oauth2;

import com.microsoft.identity.common.java.exception.ClientException;
import com.microsoft.identity.common.java.net.HttpResponse;
import com.microsoft.identity.common.java.providers.oauth2.TokenResult;

/* JADX INFO: loaded from: classes14.dex */
public interface ITokenResponseHandler<GenericTokenResult extends TokenResult> {
    GenericTokenResult handleTokenResponse(HttpResponse httpResponse) throws ClientException;
}
