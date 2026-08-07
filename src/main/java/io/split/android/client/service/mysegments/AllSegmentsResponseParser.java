package io.split.android.client.service.mysegments;

import com.google.gson.JsonSyntaxException;
import io.split.android.client.dtos.AllSegmentsChange;
import io.split.android.client.service.http.HttpResponseParser;
import io.split.android.client.service.http.HttpResponseParserException;
import io.split.android.client.utils.Json;

/* JADX INFO: loaded from: classes4.dex */
public class AllSegmentsResponseParser implements HttpResponseParser<AllSegmentsChange> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // io.split.android.client.service.http.HttpResponseParser
    public AllSegmentsChange parse(String responseData) throws HttpResponseParserException {
        try {
            return (AllSegmentsChange) Json.fromJson(responseData, AllSegmentsChange.class);
        } catch (JsonSyntaxException e) {
            throw new HttpResponseParserException("Syntax error parsing my large segments http response: " + e.getLocalizedMessage());
        } catch (Exception e2) {
            throw new HttpResponseParserException("Unknown error parsing my large segments http response: " + e2.getLocalizedMessage());
        }
    }
}
