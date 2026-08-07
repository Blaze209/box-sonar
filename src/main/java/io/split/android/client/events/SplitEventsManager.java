package io.split.android.client.events;

import io.split.android.client.SplitClientConfig;
import io.split.android.client.events.executors.SplitEventExecutor;
import io.split.android.client.events.executors.SplitEventExecutorFactory;
import io.split.android.client.events.executors.SplitEventExecutorResources;
import io.split.android.client.events.executors.SplitEventExecutorResourcesImpl;
import io.split.android.client.service.executor.SplitTaskExecutor;
import io.split.android.client.utils.Utils;
import io.split.android.client.utils.logger.Logger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes4.dex */
public class SplitEventsManager extends BaseEventsManager implements ISplitEventsManager, ListenableEventsManager, Runnable {
    private final Map<SplitEvent, Integer> mExecutionTimes;
    private SplitEventExecutorResources mResources;
    private final SplitTaskExecutor mSplitTaskExecutor;
    private final Map<SplitEvent, List<SplitEventTask>> mSubscriptions;

    public SplitEventsManager(SplitClientConfig config, SplitTaskExecutor splitTaskExecutor) {
        this(splitTaskExecutor, config.blockUntilReady());
    }

    public SplitEventsManager(SplitTaskExecutor splitTaskExecutor, final int blockUntilReady) {
        this.mSplitTaskExecutor = splitTaskExecutor;
        this.mSubscriptions = new ConcurrentHashMap();
        this.mExecutionTimes = new ConcurrentHashMap();
        this.mResources = new SplitEventExecutorResourcesImpl();
        registerMaxAllowedExecutionTimesPerEvent();
        new Thread(new Runnable() { // from class: io.split.android.client.events.SplitEventsManager.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    int i = blockUntilReady;
                    if (i > 0) {
                        Thread.sleep(i);
                        SplitEventsManager.this.notifyInternalEvent(SplitInternalEvent.SDK_READY_TIMEOUT_REACHED);
                    }
                } catch (InterruptedException e) {
                    Logger.d("Waiting before to check if SDK is READY has been interrupted", e.getMessage());
                    SplitEventsManager.this.notifyInternalEvent(SplitInternalEvent.SDK_READY_TIMEOUT_REACHED);
                } catch (Throwable th) {
                    Logger.d("Waiting before to check if SDK is READY interrupted ", th.getMessage());
                    SplitEventsManager.this.notifyInternalEvent(SplitInternalEvent.SDK_READY_TIMEOUT_REACHED);
                }
            }
        }).start();
    }

    public void setExecutionResources(SplitEventExecutorResources resources) {
        this.mResources = resources;
    }

    private void registerMaxAllowedExecutionTimesPerEvent() {
        this.mExecutionTimes.put(SplitEvent.SDK_READY, 1);
        this.mExecutionTimes.put(SplitEvent.SDK_READY_TIMED_OUT, 1);
        this.mExecutionTimes.put(SplitEvent.SDK_READY_FROM_CACHE, 1);
        this.mExecutionTimes.put(SplitEvent.SDK_UPDATE, -1);
    }

    @Override // io.split.android.client.events.ListenableEventsManager
    public SplitEventExecutorResources getExecutorResources() {
        return this.mResources;
    }

    @Override // io.split.android.client.events.BaseEventsManager, io.split.android.client.events.ISplitEventsManager
    public void notifyInternalEvent(SplitInternalEvent internalEvent) {
        Utils.checkNotNull(internalEvent);
        if ((internalEvent == SplitInternalEvent.SPLITS_FETCHED || internalEvent == SplitInternalEvent.MY_SEGMENTS_FETCHED) && isTriggered(SplitEvent.SDK_READY)) {
            return;
        }
        try {
            this.mQueue.add(internalEvent);
        } catch (IllegalStateException unused) {
            Logger.d("Internal events queue is full");
        }
    }

    @Override // io.split.android.client.events.ListenableEventsManager
    public void register(SplitEvent event, SplitEventTask task) {
        Utils.checkNotNull(event);
        Utils.checkNotNull(task);
        if (this.mExecutionTimes.containsKey(event) && this.mExecutionTimes.get(event).intValue() == 0) {
            executeTask(event, task);
            return;
        }
        if (!this.mSubscriptions.containsKey(event)) {
            this.mSubscriptions.put(event, new ArrayList());
        }
        this.mSubscriptions.get(event).add(task);
    }

    @Override // io.split.android.client.events.ListenableEventsManager
    public boolean eventAlreadyTriggered(SplitEvent event) {
        return isTriggered(event);
    }

    private boolean wasTriggered(SplitInternalEvent event) {
        return this.mTriggered.contains(event);
    }

    @Override // io.split.android.client.events.BaseEventsManager
    protected void triggerEventsWhenAreAvailable() {
        try {
            SplitInternalEvent splitInternalEventTake = this.mQueue.take();
            this.mTriggered.add(splitInternalEventTake);
            switch (AnonymousClass2.$SwitchMap$io$split$android$client$events$SplitInternalEvent[splitInternalEventTake.ordinal()]) {
                case 1:
                case 2:
                case 3:
                case 4:
                    if (isTriggered(SplitEvent.SDK_READY)) {
                        trigger(SplitEvent.SDK_UPDATE);
                    } else {
                        triggerSdkReadyIfNeeded();
                    }
                    break;
                case 5:
                case 6:
                    if (!isTriggered(SplitEvent.SDK_READY)) {
                        triggerSdkReadyIfNeeded();
                    }
                    break;
                case 7:
                case 8:
                case 9:
                case 10:
                    if (wasTriggered(SplitInternalEvent.SPLITS_LOADED_FROM_STORAGE) && wasTriggered(SplitInternalEvent.MY_SEGMENTS_LOADED_FROM_STORAGE) && wasTriggered(SplitInternalEvent.ATTRIBUTES_LOADED_FROM_STORAGE) && wasTriggered(SplitInternalEvent.ENCRYPTION_MIGRATION_DONE)) {
                        trigger(SplitEvent.SDK_READY_FROM_CACHE);
                        break;
                    }
                    break;
                case 11:
                    if (isTriggered(SplitEvent.SDK_READY)) {
                        trigger(SplitEvent.SDK_UPDATE);
                    }
                    break;
                case 12:
                    if (!isTriggered(SplitEvent.SDK_READY)) {
                        trigger(SplitEvent.SDK_READY_TIMED_OUT);
                    }
                    break;
                default:
                    break;
            }
        } catch (InterruptedException e) {
            Logger.d(e.getMessage());
        }
    }

    /* JADX INFO: renamed from: io.split.android.client.events.SplitEventsManager$2, reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$io$split$android$client$events$SplitInternalEvent;

        static {
            int[] iArr = new int[SplitInternalEvent.values().length];
            $SwitchMap$io$split$android$client$events$SplitInternalEvent = iArr;
            try {
                iArr[SplitInternalEvent.SPLITS_UPDATED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$split$android$client$events$SplitInternalEvent[SplitInternalEvent.MY_SEGMENTS_UPDATED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$split$android$client$events$SplitInternalEvent[SplitInternalEvent.MY_LARGE_SEGMENTS_UPDATED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$io$split$android$client$events$SplitInternalEvent[SplitInternalEvent.RULE_BASED_SEGMENTS_UPDATED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$io$split$android$client$events$SplitInternalEvent[SplitInternalEvent.SPLITS_FETCHED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$io$split$android$client$events$SplitInternalEvent[SplitInternalEvent.MY_SEGMENTS_FETCHED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$io$split$android$client$events$SplitInternalEvent[SplitInternalEvent.SPLITS_LOADED_FROM_STORAGE.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$io$split$android$client$events$SplitInternalEvent[SplitInternalEvent.MY_SEGMENTS_LOADED_FROM_STORAGE.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$io$split$android$client$events$SplitInternalEvent[SplitInternalEvent.ATTRIBUTES_LOADED_FROM_STORAGE.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$io$split$android$client$events$SplitInternalEvent[SplitInternalEvent.ENCRYPTION_MIGRATION_DONE.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$io$split$android$client$events$SplitInternalEvent[SplitInternalEvent.SPLIT_KILLED_NOTIFICATION.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$io$split$android$client$events$SplitInternalEvent[SplitInternalEvent.SDK_READY_TIMEOUT_REACHED.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
        }
    }

    private boolean isTriggered(SplitEvent event) {
        Integer num = this.mExecutionTimes.get(event);
        return num != null && num.intValue() == 0;
    }

    private void triggerSdkReadyIfNeeded() {
        if (wasTriggered(SplitInternalEvent.MY_SEGMENTS_UPDATED) || wasTriggered(SplitInternalEvent.MY_SEGMENTS_FETCHED) || wasTriggered(SplitInternalEvent.MY_LARGE_SEGMENTS_UPDATED)) {
            if ((wasTriggered(SplitInternalEvent.SPLITS_UPDATED) || wasTriggered(SplitInternalEvent.SPLITS_FETCHED)) && !isTriggered(SplitEvent.SDK_READY)) {
                if (!isTriggered(SplitEvent.SDK_READY_FROM_CACHE)) {
                    trigger(SplitEvent.SDK_READY_FROM_CACHE);
                }
                trigger(SplitEvent.SDK_READY);
            }
        }
    }

    private void trigger(SplitEvent event) {
        List<SplitEventTask> list;
        if (this.mExecutionTimes.get(event).intValue() == 0) {
            return;
        }
        if (this.mExecutionTimes.get(event).intValue() > 0) {
            Map<SplitEvent, Integer> map = this.mExecutionTimes;
            map.put(event, Integer.valueOf(map.get(event).intValue() - 1));
        }
        if (event != null) {
            Logger.d(event.name() + " event triggered");
        }
        if (!this.mSubscriptions.containsKey(event) || (list = this.mSubscriptions.get(event)) == null) {
            return;
        }
        Iterator<SplitEventTask> it = list.iterator();
        while (it.hasNext()) {
            executeTask(event, it.next());
        }
    }

    private void executeTask(SplitEvent event, SplitEventTask task) {
        SplitEventExecutor splitEventExecutorFactory;
        if (task == null || (splitEventExecutorFactory = SplitEventExecutorFactory.factory(this.mSplitTaskExecutor, event, task, this.mResources)) == null) {
            return;
        }
        splitEventExecutorFactory.execute();
    }
}
