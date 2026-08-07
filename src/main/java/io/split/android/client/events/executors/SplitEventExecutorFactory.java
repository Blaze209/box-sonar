package io.split.android.client.events.executors;

import io.split.android.client.events.SplitEvent;
import io.split.android.client.events.SplitEventTask;
import io.split.android.client.service.executor.SplitTaskExecutor;

/* JADX INFO: loaded from: classes4.dex */
public class SplitEventExecutorFactory {

    /* JADX INFO: renamed from: io.split.android.client.events.executors.SplitEventExecutorFactory$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$split$android$client$events$SplitEvent;

        static {
            int[] iArr = new int[SplitEvent.values().length];
            $SwitchMap$io$split$android$client$events$SplitEvent = iArr;
            try {
                iArr[SplitEvent.SDK_READY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$split$android$client$events$SplitEvent[SplitEvent.SDK_READY_FROM_CACHE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$split$android$client$events$SplitEvent[SplitEvent.SDK_UPDATE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$io$split$android$client$events$SplitEvent[SplitEvent.SDK_READY_TIMED_OUT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public static SplitEventExecutor factory(SplitTaskExecutor taskExecutor, SplitEvent event, SplitEventTask task, SplitEventExecutorResources resources) {
        int i = AnonymousClass1.$SwitchMap$io$split$android$client$events$SplitEvent[event.ordinal()];
        if (i == 1 || i == 2 || i == 3 || i == 4) {
            return new SplitEventExecutorWithClient(taskExecutor, task, resources.getSplitClient());
        }
        throw new IllegalArgumentException();
    }
}
