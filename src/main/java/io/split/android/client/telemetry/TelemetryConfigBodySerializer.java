package io.split.android.client.telemetry;

import io.split.android.client.service.http.HttpRequestBodySerializer;
import io.split.android.client.telemetry.model.Config;
import io.split.android.client.utils.Json;

/* JADX INFO: loaded from: classes4.dex */
public class TelemetryConfigBodySerializer implements HttpRequestBodySerializer<Config> {
    @Override // io.split.android.client.service.http.HttpRequestBodySerializer
    public String serialize(Config data) {
        return Json.toJsonIgnoringNulls(data);
    }
}
