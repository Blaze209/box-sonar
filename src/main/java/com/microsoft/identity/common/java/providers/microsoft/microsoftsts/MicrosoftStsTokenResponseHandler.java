package com.microsoft.identity.common.java.providers.microsoft.microsoftsts;

import com.microsoft.identity.common.java.net.HttpResponse;
import com.microsoft.identity.common.java.util.ObjectMapper;

/* JADX INFO: loaded from: classes14.dex */
public class MicrosoftStsTokenResponseHandler extends AbstractMicrosoftStsTokenResponseHandler {
    @Override // com.microsoft.identity.common.java.providers.microsoft.microsoftsts.AbstractMicrosoftStsTokenResponseHandler
    protected MicrosoftStsTokenResponse getSuccessfulResponse(HttpResponse httpResponse) {
        if (httpResponse == null) {
            throw new NullPointerException("httpResponse is marked non-null but is null");
        }
        return (MicrosoftStsTokenResponse) ObjectMapper.deserializeJsonStringToObject(httpResponse.getBody(), MicrosoftStsTokenResponse.class);
    }
}
