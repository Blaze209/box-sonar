package io.split.android.client.service.sseauthentication;

import com.google.gson.JsonSyntaxException;
import io.split.android.client.service.http.HttpResponseParser;
import io.split.android.client.service.http.HttpResponseParserException;
import io.split.android.client.service.sseclient.SseAuthenticationResponse;
import io.split.android.client.utils.Json;

/* JADX INFO: loaded from: classes4.dex */
public class SseAuthenticationResponseParser implements HttpResponseParser<SseAuthenticationResponse> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // io.split.android.client.service.http.HttpResponseParser
    public SseAuthenticationResponse parse(String responseData) throws HttpResponseParserException {
        try {
            return (SseAuthenticationResponse) Json.fromJson(responseData, SseAuthenticationResponse.class);
        } catch (JsonSyntaxException e) {
            throw new HttpResponseParserException("Syntax error parsing my segments http response: " + e.getLocalizedMessage());
        } catch (Exception e2) {
            throw new HttpResponseParserException("Unknown error parsing my segments http response: " + e2.getLocalizedMessage());
        }
    }
}
