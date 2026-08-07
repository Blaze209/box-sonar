package io.split.android.client.service.impressions.unique;

import io.split.android.client.service.http.HttpRequestBodySerializer;
import io.split.android.client.utils.Json;

/* JADX INFO: loaded from: classes4.dex */
public class MTKRequestBodySerializer implements HttpRequestBodySerializer<MTK> {
    @Override // io.split.android.client.service.http.HttpRequestBodySerializer
    public String serialize(MTK data) {
        return Json.toJson(data);
    }
}
