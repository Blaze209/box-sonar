package io.split.android.client.service.splits;

import com.google.gson.JsonSyntaxException;
import io.split.android.client.dtos.SplitChange;
import io.split.android.client.service.http.HttpResponseParser;
import io.split.android.client.service.http.HttpResponseParserException;
import io.split.android.client.utils.Json;

/* JADX INFO: loaded from: classes4.dex */
public class SplitChangeResponseParser implements HttpResponseParser<SplitChange> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // io.split.android.client.service.http.HttpResponseParser
    public SplitChange parse(String responseData) throws HttpResponseParserException {
        try {
            return (SplitChange) Json.fromJson(responseData, SplitChange.class);
        } catch (JsonSyntaxException e) {
            throw new HttpResponseParserException("Syntax error parsing my segments http response: " + e.getLocalizedMessage());
        } catch (Exception e2) {
            throw new HttpResponseParserException("Unknown error parsing my segments http response: " + e2.getLocalizedMessage());
        }
    }
}
