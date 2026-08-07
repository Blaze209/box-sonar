package io.split.android.client.events;

import io.split.android.client.api.Key;
import io.split.android.client.utils.Utils;
import io.split.android.client.utils.logger.Logger;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: loaded from: classes4.dex */
public class EventsManagerCoordinator extends BaseEventsManager implements ISplitEventsManager, EventsManagerRegistry {
    private final ConcurrentMap<Key, ISplitEventsManager> mChildren = new ConcurrentHashMap();
    private final Object mEventLock = new Object();

    @Override // io.split.android.client.events.BaseEventsManager, io.split.android.client.events.ISplitEventsManager
    public void notifyInternalEvent(SplitInternalEvent internalEvent) {
        Utils.checkNotNull(internalEvent);
        try {
            this.mQueue.add(internalEvent);
        } catch (IllegalStateException unused) {
            Logger.d("Internal events queue is full");
        }
    }

    @Override // io.split.android.client.events.BaseEventsManager
    protected void triggerEventsWhenAreAvailable() {
        try {
            SplitInternalEvent splitInternalEventTake = this.mQueue.take();
            synchronized (this.mEventLock) {
                this.mTriggered.add(splitInternalEventTake);
                switch (AnonymousClass1.$SwitchMap$io$split$android$client$events$SplitInternalEvent[splitInternalEventTake.ordinal()]) {
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                        Iterator<ISplitEventsManager> it = this.mChildren.values().iterator();
                        while (it.hasNext()) {
                            it.next().notifyInternalEvent(splitInternalEventTake);
                        }
                        break;
                }
            }
        } catch (InterruptedException e) {
            Logger.d(e.getMessage());
        }
    }

    /* JADX INFO: renamed from: io.split.android.client.events.EventsManagerCoordinator$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$split$android$client$events$SplitInternalEvent;

        static {
            int[] iArr = new int[SplitInternalEvent.values().length];
            $SwitchMap$io$split$android$client$events$SplitInternalEvent = iArr;
            try {
                iArr[SplitInternalEvent.SPLITS_UPDATED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$split$android$client$events$SplitInternalEvent[SplitInternalEvent.RULE_BASED_SEGMENTS_UPDATED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$split$android$client$events$SplitInternalEvent[SplitInternalEvent.SPLITS_FETCHED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$io$split$android$client$events$SplitInternalEvent[SplitInternalEvent.SPLITS_LOADED_FROM_STORAGE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$io$split$android$client$events$SplitInternalEvent[SplitInternalEvent.SPLIT_KILLED_NOTIFICATION.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$io$split$android$client$events$SplitInternalEvent[SplitInternalEvent.ENCRYPTION_MIGRATION_DONE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    @Override // io.split.android.client.events.EventsManagerRegistry
    public void registerEventsManager(Key key, ISplitEventsManager splitEventsManager) {
        this.mChildren.put(key, splitEventsManager);
        propagateTriggeredEvents(splitEventsManager);
    }

    @Override // io.split.android.client.events.EventsManagerRegistry
    public void unregisterEventsManager(Key key) {
        this.mChildren.remove(key);
    }

    private void propagateTriggeredEvents(ISplitEventsManager splitEventsManager) {
        synchronized (this.mEventLock) {
            Iterator<SplitInternalEvent> it = this.mTriggered.iterator();
            while (it.hasNext()) {
                splitEventsManager.notifyInternalEvent(it.next());
            }
        }
    }
}
