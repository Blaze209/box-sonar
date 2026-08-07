package io.opentelemetry.rum.internal.instrumentation;

/* JADX INFO: loaded from: classes4.dex */
public interface ApplicationStateListener {
    void onApplicationBackgrounded();

    void onApplicationForegrounded();
}
