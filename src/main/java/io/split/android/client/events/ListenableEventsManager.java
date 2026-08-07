package io.split.android.client.events;

import io.split.android.client.events.executors.SplitEventExecutorResources;

/* JADX INFO: loaded from: classes4.dex */
public interface ListenableEventsManager {
    boolean eventAlreadyTriggered(SplitEvent event);

    SplitEventExecutorResources getExecutorResources();

    void register(SplitEvent event, SplitEventTask task);
}
