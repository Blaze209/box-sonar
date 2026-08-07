package io.split.android.client.service.impressions;

import io.split.android.client.service.http.HttpRequestBodySerializer;
import io.split.android.client.utils.Json;

/* JADX INFO: loaded from: classes4.dex */
public class ImpressionsCountRequestBodySerializer implements HttpRequestBodySerializer<ImpressionsCount> {
    @Override // io.split.android.client.service.http.HttpRequestBodySerializer
    public String serialize(ImpressionsCount data) {
        return Json.toJson(data);
    }
}
