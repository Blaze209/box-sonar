package io.split.android.client.storage.events;

import io.split.android.client.dtos.Event;
import io.split.android.client.storage.common.Storage;
import io.split.android.client.storage.common.StoragePusher;
import io.split.android.client.utils.Utils;
import io.split.android.client.utils.logger.Logger;
import java.util.AbstractQueue;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes4.dex */
public class EventsStorage implements Storage<Event>, StoragePusher<Event> {
    private final AbstractQueue<Event> mEvents = new ConcurrentLinkedQueue();
    private final AtomicBoolean mIsPersistenceEnabled;
    private final PersistentEventsStorage mPersistentStorage;

    public EventsStorage(PersistentEventsStorage persistentStorage, boolean isPersistenceEnabled) {
        AtomicBoolean atomicBoolean = new AtomicBoolean(true);
        this.mIsPersistenceEnabled = atomicBoolean;
        this.mPersistentStorage = (PersistentEventsStorage) Utils.checkNotNull(persistentStorage);
        atomicBoolean.set(isPersistenceEnabled);
    }

    @Override // io.split.android.client.storage.common.Storage
    public void enablePersistence(boolean enabled) {
        this.mIsPersistenceEnabled.set(enabled);
        if (enabled) {
            Logger.v("Persisting in memory events");
            ArrayList arrayList = new ArrayList(this.mEvents);
            this.mEvents.removeAll(arrayList);
            this.mPersistentStorage.pushMany(arrayList);
        }
        Logger.d("Persistence for events has been ".concat(enabled ? "enabled" : "disabled"));
    }

    @Override // io.split.android.client.storage.common.Storage, io.split.android.client.storage.common.StoragePusher
    public void push(Event element) {
        if (element == null) {
            return;
        }
        if (this.mIsPersistenceEnabled.get()) {
            Logger.v("Pushing events to persistent storage");
            this.mPersistentStorage.push(element);
        } else {
            Logger.v("Pushing events to in memory storage");
            this.mEvents.add(element);
        }
    }

    @Override // io.split.android.client.storage.common.Storage
    public void clearInMemory() {
        this.mEvents.clear();
    }
}
