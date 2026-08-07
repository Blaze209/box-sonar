package io.split.android.client.network;

import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
interface AuthenticatedRequest<T> {
    String getHeader(String name);

    Map<String, String> getHeaders();

    String getRequestUrl();

    void setHeader(String name, String value);
}
