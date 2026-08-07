package io.split.android.client.events;

import io.split.android.client.api.Key;

/* JADX INFO: loaded from: classes4.dex */
public interface EventsManagerRegistry {
    void registerEventsManager(Key key, ISplitEventsManager splitEventsManager);

    void unregisterEventsManager(Key key);
}
