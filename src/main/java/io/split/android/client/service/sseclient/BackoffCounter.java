package io.split.android.client.service.sseclient;

/* JADX INFO: loaded from: classes4.dex */
public interface BackoffCounter {
    long getNextRetryTime();

    void resetCounter();
}
