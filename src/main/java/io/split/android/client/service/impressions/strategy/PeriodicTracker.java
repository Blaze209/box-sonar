package io.split.android.client.service.impressions.strategy;

/* JADX INFO: loaded from: classes4.dex */
public interface PeriodicTracker {
    void enableTracking(boolean enable);

    void flush();

    void startPeriodicRecording();

    void stopPeriodicRecording();
}
