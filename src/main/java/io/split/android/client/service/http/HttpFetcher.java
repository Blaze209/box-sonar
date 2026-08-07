package io.split.android.client.service.http;

import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public interface HttpFetcher<T> {
    T execute(Map<String, Object> params, Map<String, String> headers) throws HttpFetcherException;
}
