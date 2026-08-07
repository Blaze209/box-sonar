package io.split.android.client.factory;

/* JADX INFO: loaded from: classes4.dex */
public interface FactoryMonitor {
    void add(String apiKey);

    int count();

    int count(String apiKey);

    void remove(String apiKey);
}
