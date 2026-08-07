package io.split.android.client.telemetry;

/* JADX INFO: loaded from: classes4.dex */
public interface TelemetrySynchronizer {
    void destroy();

    void flush();

    void synchronizeConfig();

    void synchronizeStats();
}
