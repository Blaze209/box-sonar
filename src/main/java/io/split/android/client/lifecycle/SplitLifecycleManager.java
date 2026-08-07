package io.split.android.client.lifecycle;

/* JADX INFO: loaded from: classes4.dex */
public interface SplitLifecycleManager {
    void destroy();

    void register(SplitLifecycleAware component);
}
