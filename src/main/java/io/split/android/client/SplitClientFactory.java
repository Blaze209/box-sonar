package io.split.android.client;

import io.split.android.client.api.Key;
import io.split.android.client.events.SplitEventsManager;
import io.split.android.client.service.mysegments.MySegmentsTaskFactory;

/* JADX INFO: loaded from: classes4.dex */
public interface SplitClientFactory {
    SplitClient getClient(Key key, MySegmentsTaskFactory mySegmentsTaskFactory, SplitEventsManager eventsManager, boolean isDefaultClient);
}
