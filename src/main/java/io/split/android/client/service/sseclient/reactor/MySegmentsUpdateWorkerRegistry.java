package io.split.android.client.service.sseclient.reactor;

/* JADX INFO: loaded from: classes4.dex */
public interface MySegmentsUpdateWorkerRegistry {
    void registerMySegmentsUpdateWorker(String matchingKey, MySegmentsUpdateWorker mySegmentsUpdateWorker);

    void start();

    void stop();

    void unregisterMySegmentsUpdateWorker(String matchingKey);
}
