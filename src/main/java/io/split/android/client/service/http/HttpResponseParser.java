package io.split.android.client.service.http;

/* JADX INFO: loaded from: classes4.dex */
public interface HttpResponseParser<T> {
    T parse(String responseData) throws HttpResponseParserException;
}
