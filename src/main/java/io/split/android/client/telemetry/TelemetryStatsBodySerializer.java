package io.split.android.client.telemetry;

import io.split.android.client.service.http.HttpRequestBodySerializer;
import io.split.android.client.telemetry.model.Stats;
import io.split.android.client.utils.Json;

/* JADX INFO: loaded from: classes4.dex */
public class TelemetryStatsBodySerializer implements HttpRequestBodySerializer<Stats> {
    @Override // io.split.android.client.service.http.HttpRequestBodySerializer
    public String serialize(Stats data) {
        return Json.toJsonIgnoringNulls(data);
    }
}
